package fr.rouen.mastergil.tptest;

<<<<<<< HEAD
import org.junit.Test;

import static org.junit.Assert.*;

=======
/**
 * Created by rudy on 22/02/16.
 */

import org.junit.Test;

import static org.junit.Assert.*;
>>>>>>> upstream/TP2
public class MoneyTest {

    @Test
    public void constructeurVideDoitRemplirMontantEtDevise() {
<<<<<<< HEAD
        Money testMoney = new Money();

        assertEquals(0, testMoney.getMontant());
        assertEquals(Devise.EURO, testMoney.getDevise());
    }

    @Test
    public void constructeurAvecParametreDoitRemplirMontantEtDevise() {
        Money testMoney = new Money(5, Devise.DINAR);

        assertEquals(5, testMoney.getMontant());
        assertEquals(Devise.DINAR, testMoney.getDevise());
    }

    @Test
    public void isPositifRenvoieTruePourMontantEgal0() {
        Money testMoney = new Money();

        assertTrue(testMoney.isPositif());
    }

    @Test
    public void isPositifRenvoieTruePourMontantPositif() {
        Money testMoney = new Money();

        testMoney.setMontant(5);

        assertTrue(testMoney.isPositif());
    }

    @Test
    public void isPositifRenvoieFalsePourMontantNegatif() {
        Money testMoney = new Money();

        testMoney.setMontant(-5);

        assertFalse(testMoney.isPositif());
    }

    @Test
    public void setMontantRempliBienLeMontant() {
        Money testMoney = new Money();

        testMoney.setMontant(5);

        assertEquals(5, testMoney.getMontant());
    }

    @Test
    public void setDeviseRenvoiBienUneException() {
        Money testMoney = new Money();

        try {
            testMoney.setDevise(null);
            fail("Devise doit être spécifiée");
        } catch(IllegalArgumentException e) {

        }

    }

    @Test
    public void setDeviseRempliBienDevise() {
        Money testMoney = new Money();

        testMoney.setDevise(Devise.DOLLAR);

        assertEquals(Devise.DOLLAR, testMoney.getDevise());

    }
}
=======
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
>>>>>>> upstream/TP2
