package fr.rouen.mastergil.tptest;

/**
 * Created by rudy on 22/02/16.
 */

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void constructeurVideDoitRemplirMontantEtDevise() {
        //Given

        //When
        Money money = new Money();

        // then
        assertThat(money.getMontant()).isEqualTo(0);
        assertThat(money.getDevise()).isEqualTo(Devise.EURO);
    }

    @Test
    public void constructeurDoitRemplirMontantEtDevise() {
        //Given

        //When
        Money money = new Money(5, Devise.EURO);

        //Then
        assertThat(money.getMontant()).isEqualTo(5);
        assertThat(money.getDevise()).isEqualTo(Devise.EURO);
    }

    @Test
    public void constructeurInterditDeviseInconnueOuVide() {
        //Given
        final Money money = new Money(20, Devise.EURO);
        try {
            //When
            money.setDevise(null);
            //Then
            fail("setDevise doit envoyer une exception si aucune devise n'est spécifiée");
        } catch (IllegalArgumentException iae) {
            //Then
            assertEquals("Devise doit être spécifiée", iae.getMessage());
        }
    }


    @Test
    public void isPositif_doit_etre_vrai_si_montant_superieur_a_zero() throws Exception {
        //Given
        final Money money = new Money(20, Devise.EURO);
        //When
        final boolean isPositif = money.isPositif();
        //Then
        assertThat(isPositif).isTrue();
    }

    @Test
    public void isPositif_doit_etre_vrai_si_montant_egal_a_zero() throws Exception {
        //Given
        final Money money = new Money(0, Devise.EURO);
        //When
        final boolean isPositif = money.isPositif();
        //Then
        assertThat(isPositif).isTrue();
    }

    @Test
    public void isPositif_doit_etre_faux_si_montant_inferieur_a_zero() throws Exception {
        //Given
        final Money money = new Money(-20, Devise.EURO);
        //When
        final boolean isPositif = money.isPositif();
        //Then
        assertThat(isPositif).isFalse();
    }




}
