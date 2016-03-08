package fr.rouen.mastergil.tptest.bonus;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class StringManipulationTest {

    @Test
    public void aRetourneFalseSiLaTailleDeSEstEgaleAZero() {
        //given
        StringManipulation sm = new StringManipulation();

        //when
        boolean test = sm.a("");

        //then
        assertThat(test).isFalse();
    }

    @Test
    public void aRetourneFalseSiSEstNull() {
        //given
        StringManipulation sm = new StringManipulation();

        //when
        boolean test = sm.a(null);

        //then
        assertThat(test).isFalse();
    }

    @Test
    public void aRetourneTrueSiSestUnPalindromeSansAccent() {
        //given
        StringManipulation sm = new StringManipulation();

        //when
        boolean test = sm.a("Mon nom");

        //then
        assertThat(test).isTrue();

    }

    @Test
    public void aRetourneFalseSiSestUnPalindromeAvecAccent() {
        //given
        StringManipulation sm = new StringManipulation();

        //when
        boolean test = sm.a("Tâte l'État");

        //then
        assertThat(test).isFalse();

    }

    @Test
    public void aRetourneTrueSiSestUnPalindromeSansAccentAvecDesSymboles() {
        //given
        StringManipulation sm = new StringManipulation();

        //when
        boolean test = sm.a("mo----&n[[ no[[m");

        //then
        assertThat(test).isTrue();
    }
}