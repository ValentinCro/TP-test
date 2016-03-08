package fr.rouen.mastergil.tptest;

import org.junit.Test;

import java.text.MessageFormat;

import static org.assertj.core.api.Assertions.*;


public class BankAccountTest {

    @Test
    public void constructeurVideLaisseSoldeANull() {
        //given

        //when
        BankAccount compte = new BankAccount();

        //then
        assertThat(compte.solde).isNull();
    }

    @Test
    public void creerComptreSansParametreInitialiseSoldeAvecConstructeurParDefaut() {
        //given
        Money money = new Money();
        BankAccount compte = new BankAccount();

        //when
        compte.creerCompte();

        //then
        assertThat(compte.solde.getMontant()).isEqualTo(money.getMontant());
        assertThat(compte.solde.getDevise()).isEqualTo(money.getDevise());
    }

    @Test
    public void creerCompteAvecParametreInitialiseSoldeAvecConstructeurAvecParametre() {
        //given
        int montant = 5;
        Devise devise = Devise.DINAR;
        Money money = new Money(montant, devise);
        BankAccount compte = new BankAccount();

        //when
        compte.creerCompte(montant, devise);

        //then
        assertThat(compte.solde.getMontant()).isEqualTo(money.getMontant());
        assertThat(compte.solde.getDevise()).isEqualTo(money.getDevise());
    }

    @Test
    public void consulterSoldeRetourneUnMessageAvecMontantEtSolde() {
        //given
        int montant = 5;
        Devise devise = Devise.PESO;
        BankAccount compte = new BankAccount();
        compte.creerCompte(montant, devise);
        String messageTest = MessageFormat.format("Votre solde actuel est de {0} {1}", montant, devise);

        //when
        String message = compte.consulterSolde();

        //then
        assertThat(message).isEqualTo(messageTest);
    }

    @Test
    public void deposerArgentIncrementeLeSoldeDuMontantEnParametre() {
        //given
        int montantAdd = (int)(Math.random() * 200);
        BankAccount compte = new BankAccount();
        compte.creerCompte();
        int montant = compte.solde.getMontant();

        //when
        compte.deposerArgent(montantAdd);

        //then
        assertThat(compte.solde.getMontant()).isEqualTo(montant + montantAdd);
    }

    @Test
    public void retirerArgentDecrementeLeSoldeDuMontantEnParametre() {
        //given
        int montantDif = (int)(Math.random() * 200);
        BankAccount compte = new BankAccount();
        compte.creerCompte();
        int montant = compte.solde.getMontant();

        //when
        compte.retirerArgent(montantDif);

        //then
        assertThat(compte.solde.getMontant()).isEqualTo(montant - montantDif);
    }

    @Test
    public void isSoldePositifRenvoieTruePourMontantEgal0() {
        //given
        BankAccount compte = new BankAccount();

        //when
        compte.creerCompte();

        //then
        assertThat(compte.isSoldePositif()).isTrue();
    }

    @Test
    public void isSoldePositifRenvoieTruePourMontantPositif() {
        //given
        BankAccount compte = new BankAccount();
        int montant = 5;
        Devise devise = Devise.DINAR;

        //when
        compte.creerCompte(montant, devise);

        //then
        assertThat(compte.isSoldePositif()).isTrue();
    }

    @Test
    public void isPositifRenvoieFalsePourMontantNegatif() {
        //given
        BankAccount compte = new BankAccount();
        int montant = -5;
        Devise devise = Devise.DINAR;

        //when
        compte.creerCompte(montant, devise);

        //then
        assertThat(compte.isSoldePositif()).isFalse();
    }
}