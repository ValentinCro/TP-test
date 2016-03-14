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




}