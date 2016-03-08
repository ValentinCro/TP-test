package fr.rouen.mastergil.tptest;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class MoneyTest {

    @Test
    public void constructeurVideDoitRemplirMontantEtDevise() {
        //given

        //when
        Money testMoney = new Money();

        //then
        assertThat(testMoney.getMontant()).isEqualTo(0);
        assertThat(testMoney.getDevise()).isEqualTo(Devise.EURO);
    }

    @Test
    public void constructeurAvecParametreDoitRemplirMontantEtDevise() {
        //given
        int montant = 5;
        Devise devise = Devise.DINAR;

        //when
        Money testMoney = new Money(montant, devise);

        //then
        assertThat(testMoney.getMontant()).isEqualTo(montant);
        assertThat(testMoney.getDevise()).isEqualTo(devise);
    }

    @Test
    public void isPositifRenvoieTruePourMontantEgal0() {
        //given

        //when
        Money testMoney = new Money();

        //then
        assertThat(testMoney.isPositif()).isTrue();
    }

    @Test
    public void isPositifRenvoieTruePourMontantPositif() {
        //given
        Money testMoney = new Money();
        int montant = 5;

        //when
        testMoney.setMontant(montant);

        //then
        assertThat(testMoney.isPositif()).isTrue();
    }

    @Test
    public void isPositifRenvoieFalsePourMontantNegatif() {
        //given
        Money testMoney = new Money();
        int montant = -5;

        //when
        testMoney.setMontant(montant);

        //then
        assertThat(testMoney.isPositif()).isFalse();
    }

    @Test
    public void setMontantRempliBienLeMontant() {
        //given
        Money testMoney = new Money();
        int montant = 5;

        //when
        testMoney.setMontant(montant);

        //then
        assertThat(testMoney.getMontant()).isEqualTo(montant);
    }

    @Test
    public void setDeviseRenvoiBienUneException() {
        //given
        Money testMoney = new Money();

        try {
            //when
            testMoney.setDevise(null);
            fail("Devise doit être spécifiée");
        } catch(IllegalArgumentException e) {
            //then
        }

    }

    @Test
    public void setDeviseRempliBienDevise() {
        //given
        Money testMoney = new Money();
        Devise devise = Devise.DOLLAR;

        //when
        testMoney.setDevise(devise);

        //then
        assertThat(testMoney.getDevise()).isEqualTo(devise);

    }
}

