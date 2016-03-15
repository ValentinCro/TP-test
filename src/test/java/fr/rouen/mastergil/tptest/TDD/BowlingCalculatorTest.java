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
    public void score_Egale_a_0() throws Exception {
        //Given
        String feuilleScore = "--;--;--;--;--;--;--;--;--;---";
        //When
        int score = bowlingCalculator.score(feuilleScore);
        //Then
        assertThat(score).isEqualTo(0);
    }

    @Test
    public void score_Egale_a_1() throws Exception {
        //Given
        String feuilleScore = "1-;--;--;--;--;--;--;--;--;---";
        //When
        int score = bowlingCalculator.score(feuilleScore);
        //Then
        assertThat(score).isEqualTo(1);
    }

    @Test
    public void score_avec_valeur_identique() throws Exception {
        //Given
        String feuilleScore = "1-;1-;1-;1-;1-;1-;1-;1-;1-;1--";
        //When
        int score = bowlingCalculator.score(feuilleScore);
        //Then
        assertThat(score).isEqualTo(10);
    }

    @Test
    public void score_avec_spare() throws Exception {
        //Given
        String feuilleScore = "1/;1-;1-;1-;1-;1-;1-;1-;1-;1--";
        //When
        int score = bowlingCalculator.score(feuilleScore);
        //Then
        assertThat(score).isEqualTo(20);
    }

    @Test
    public void score_avec_strike() throws Exception {
        //Given
        String feuilleScore = "x;--;--;--;--;--;--;--;--;---";
        //When
        int score = bowlingCalculator.score(feuilleScore);
        //Then
        assertThat(score).isEqualTo(10);
    }

    @Test
    public void score_avec_strike_et_un_lancer() throws Exception {
        //Given
        String feuilleScore = "x;1-;--;--;--;--;--;--;--;---";
        //When
        int score = bowlingCalculator.score(feuilleScore);
        //Then
        assertThat(score).isEqualTo(12);
    }

    @Test
    public void score_avec_strike_et_deux_lancer() throws Exception {
        //Given
        String feuilleScore = "x;21;--;--;--;--;--;--;--;---";
        //When
        int score = bowlingCalculator.score(feuilleScore);
        //Then
        assertThat(score).isEqualTo(16);
    }

    @Test
    public void score_avec_deux_spare_a_la_suite() throws Exception {
        //Given
        String feuilleScore = "1/;1/;--;--;--;--;--;--;--;---";
        //When
        int score = bowlingCalculator.score(feuilleScore);
        //Then
        assertThat(score).isEqualTo(21);
    }
}