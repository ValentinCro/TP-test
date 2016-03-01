package fr.rouen.mastergil.tptest;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void constructeurVideDoitRemplirMontantEtDevise() {
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