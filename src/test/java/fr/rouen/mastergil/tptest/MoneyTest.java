package fr.rouen.mastergil.tptest;

/**
 * Created by rudy on 22/02/16.
 */

import org.junit.Test;

import static org.junit.Assert.*;
public class MoneyTest {

    @Test
    public void constructeurVideDoitRemplirMontantEtDevise() {
        Money money = new Money();

        assertEquals(0, money.getMontant());
        assertEquals(Devise.EURO, money.getDevise());
    }

    @Test
    public void constructeurDoitRemplirMontantEtDevise() {
        Money money = new Money(5, Devise.EURO);

        assertEquals(5, money.getMontant());
        assertEquals(Devise.EURO, money.getDevise());
    }

    @Test
    public void constructeurInterditDeviseInconnueOuVide() {
        try {
            new Money(5, null);
            fail("Une devise null n'est pas autorisée");
        } catch (IllegalArgumentException iae) {
            ; // comportement normal
        }
    }

    @Test
    public void isPositifDoitRetournerFalseSiLeMontantEstNegatif() {
        Money money = new Money();
        money.setMontant(-2);
        final boolean isPositif = money.isPositif();
        assertFalse(isPositif);
    }

    @Test
    public void isPositifDoitRetournerTrueSiLeMontantEstPositif() {
        Money money = new Money();
        money.setMontant(2);
        final boolean isPositif = money.isPositif();
        assertTrue(isPositif);
    }


}
