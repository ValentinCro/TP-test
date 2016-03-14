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

    @Test
    public void score_avec_strike_et_deux_lancer_apres() throws Exception {
        //Given
        String score = "x;12;--;--;--;--;--;--;--;--";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(16);
    }


    @Test
    public void score_avec_deux_spares_a_la_suite() throws Exception {
        //Given
        String score = "1/;1/;--;--;--;--;--;--;--;--";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(21);
    }

    @Test
    public void score_avec_un_spare_et_un_strike() throws Exception {
        //Given
        String score = "-/;x;--;--;--;--;--;--;--;--";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(30);
    }


    @Test
    public void score_avec_deux_spares_deux_strike_et_un_lancer_apres() throws Exception {
        //Given
        String score = "-/;2/;x;--;--;x;--;12;--;--";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(55);
    }


    @Test
    public void score_avec_nine_spares() throws Exception {
        //Given
        String score = "9/;9/;9/;9/;9/;9/;9/;9/;9/;9/9";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(190);
    }


    @Test
    public void score_avec_eight_spares_et_double_strike_a_la_fin() throws Exception {
        //Given
        String score = "9/;9/;9/;9/;9/;9/;9/;9/;9/;xx9";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(201);

    }


    @Test
    public void score_avec_291_game() throws Exception {
        //Given
        String score = "x-;x-;x-;x-;x-;x-;x-;x-;x-;xx1";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(291);

    }

    @Test
    public void score_avec_300() throws Exception {
        //Given
        String score = "x;x;x;x;x;x;x;x;x;xxx";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(300);

    }

    @Test
    public void score_avec_277() throws Exception {
        //Given
        String score = "x;x;8/;x;x;x;x;x;x;xx9";
        //When
        int resultat = bowlingCalculator.score(score);
        //Then
        assertThat(resultat).isEqualTo(277);
    }

    @Test
    public void should_simple_score_only_in_frame1() throws Exception {
        //Given
        String feuilleDeScore = "1-;2-;3-;4-;5-;6-;7-;8-;9-;1-";
        final BowlingCalculator bowlingCalculator = new BowlingCalculator();
        //When
        final int score = bowlingCalculator.score(feuilleDeScore);
        //Then
        assertThat(score).isEqualTo(46);
    }

    @Test
    public void should_simple_score_with_frame1_and_frame2() throws Exception {
        //Given
        String feuilleDeScore = "11;22;33;44;51;62;71;81;9-;11";
        final BowlingCalculator bowlingCalculator = new BowlingCalculator();
        //When
        final int score = bowlingCalculator.score(feuilleDeScore);
        //Then
        assertThat(score).isEqualTo(62);
    }

    @Test
    public void should_score_with_frame1_and_frame2_and_1spare() throws Exception {
        //Given
        String feuilleDeScore = "11;2/;33;44;51;62;71;81;9-;11";
        final BowlingCalculator bowlingCalculator = new BowlingCalculator();
        //When
        final int score = bowlingCalculator.score(feuilleDeScore);
        //Then
        assertThat(score).isEqualTo(71);
    }

    @Test
    public void should_score_with_frame1_and_frame2_and_2spares() throws Exception {
        //Given
        String feuilleDeScore = "11;2/;33;4/;51;62;71;81;9-;11";
        final BowlingCalculator bowlingCalculator = new BowlingCalculator();
        //When
        final int score = bowlingCalculator.score(feuilleDeScore);
        //Then
        assertThat(score).isEqualTo(78);
    }

    @Test
    public void should_score_with_frame1_and_frame2_and_3spares() throws Exception {
        //Given
        String feuilleDeScore = "11;2/;3/;4/;51;62;71;81;9-;11";
        final BowlingCalculator bowlingCalculator = new BowlingCalculator();
        //When
        final int score = bowlingCalculator.score(feuilleDeScore);
        //Then
        assertThat(score).isEqualTo(86);
    }

    @Test
    public void should_score_with_frame1_and_frame2_and_1strike() throws Exception {
        //Given
        String feuilleDeScore = "11;x;33;44;51;62;71;81;9-;11";
        final BowlingCalculator bowlingCalculator = new BowlingCalculator();
        //When
        final int score = bowlingCalculator.score(feuilleDeScore);
        //Then
        assertThat(score).isEqualTo(74);
    }

    @Test
    public void should_score_with_frame1_and_frame2_and_2strikes() throws Exception {
        //Given
        String feuilleDeScore = "11;x;x;44;51;62;71;81;9-;11";
        final BowlingCalculator bowlingCalculator = new BowlingCalculator();
        //When
        final int score = bowlingCalculator.score(feuilleDeScore);
        //Then
        assertThat(score).isEqualTo(94);
    }


    @Test
    public void should_score_200() throws Exception {
        //Given
        String feuilleDeScore = "x;8/;x;9/;x;7/;x;6/;x;1/x";
        final BowlingCalculator bowlingCalculator = new BowlingCalculator();
        //When
        final int score = bowlingCalculator.score(feuilleDeScore);
        //Then
        assertThat(score).isEqualTo(200);
    }


    @Test
    public void should_score_9spare_all_frame() throws Exception {
        //Given
        String feuilleDeScore = "9/;9/;9/;9/;9/;9/;9/;9/;9/;9/9";
        final BowlingCalculator bowlingCalculator = new BowlingCalculator();
        //When
        final int score = bowlingCalculator.score(feuilleDeScore);
        //Then
        assertThat(score).isEqualTo(190);
    }



}