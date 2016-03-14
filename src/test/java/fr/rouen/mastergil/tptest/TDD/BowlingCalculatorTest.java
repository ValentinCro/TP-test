package fr.rouen.mastergil.tptest.TDD;


import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BowlingCalculatorTest {
    /**
     * Exemple de tests :
     * <p/>
     * #1 : score avec que des valeurs entières en frame 1
     * #2 : score avec que des valeurs entières en frame 1 et frame 2
     * #3 : score avec que des valeurs entières en frame 1 et frame 2 et 1 spare
     * #4 : score avec que des valeurs entières en frame 1 et frame 2 et 2 spare
     * #5 : score avec que des valeurs entières en frame 1 et frame 2 et 1 strike
     * ...
     * autre exemple :
     * <p/>
     * #1 : score avec que des valeurs à 1 en frame 1
     * #2 : score avec que des valeurs à 2 en frame 1
     * #3 : score avec que des valeurs à 1 en frame 1 et frame 2
     * #4 : score avec que des valeurs à 2 en frame 1 et frame 2
     * #5 : score avec que des valeurs à 2 en frame 1 et frame 2 et 1 spare
     * <p/>
     * S'inspirer des presets du calculator http://warwickbowling.50webs.com/calculator.html APRES les cas "basiques"
     */

    private BowlingCalculator bowlingCalculator;

    @Before
    public void setUp() throws Exception {
        bowlingCalculator = new BowlingCalculator();
    }


    @Test
    public void score_a_zero() throws Exception {
        //Given
        String score = "--;--;--;--;--;--;--;--;--;--";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(0);
    }


    @Test
    public void score_a_un() throws Exception {
        //Given
        String score = "1-;--;--;--;--;--;--;--;--;--";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(1);
    }


    @Test
    public void score_avec_des_valeurs_identiques_aux_premiers_lancers() throws Exception {
        //Given
        String score = "1-;1-;1-;1-;1-;1-;1-;1-;1-;1-";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(10);
    }


    @Test
    public void score_avec_des_valeurs_differentes_aux_premiers_lancers() throws Exception {
        //Given
        String score = "1-;2-;3-;4-;5-;6-;7-;8-;9-;1-";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(46);
    }


    @Test
    public void score_avec_un_premier_lancer_reussi() throws Exception {
        //Given
        String score = "12;--;--;--;--;--;--;--;--;--";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(3);
    }

    @Test
    public void score_avec_divers_lancer() throws Exception {
        //Given
        String score = "12;-2;-1;-9;--;--;--;--;--;--";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(15);
    }


    @Test
    public void score_avec_divers_lancer2() throws Exception {
        //Given
        String score = "12;--;--;--;--;--;--;--;--;-1-";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(4);
    }


    @Test
    public void score_avec_spare() throws Exception {
        //Given
        String score = "1/;--;--;--;--;--;--;--;--;--";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(10);
    }


    @Test
    public void score_avec_spare_et_un_lancer_apres() throws Exception {
        //Given
        String score = "1/;1-;--;--;--;--;--;--;--;--";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(12);
    }


    @Test
    public void score_avec_strike() throws Exception {
        //Given
        String score = "x;--;--;--;--;--;--;--;--;--";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(10);
    }


    @Test
    public void score_avec_strike_et_un_lancer_apres() throws Exception {
        //Given
        String score = "x;1-;--;--;--;--;--;--;--;--";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(12);
    }






}