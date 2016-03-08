package fr.rouen.mastergil.tptest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mockito.*;

import java.sql.Connection;
import java.text.MessageFormat;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class BankAccountWithDAOTest {

    @Mock
    private JdbcDAO bankDao;

    @InjectMocks
    private BankAccountWithDAO bankAccountWithDAO;

    @Before
    public void setUp() throws Exception {
        Connection connection = mock(Connection.class);
        when(bankDao.setUpConnection()).thenReturn(connection);

        Money moneyTest = new Money(20, Devise.DINAR);

        when(bankDao.getSolde()).thenReturn(moneyTest);
    }

    @Test
    public void creerCompteVideDoitAppeleCreerCompte() throws Exception {
        //Given
        //When
        bankAccountWithDAO.creerCompte();
        //Then
        verify(bankDao, times(1)).creerCompte();
    }

    @Test
    public void creerCompteAvecParametreDoitAppeleCreerCompteAvecParametre() throws Exception {
        //Given
        int montant = 10;
        Devise devise = Devise.DINAR;
        //When
        bankAccountWithDAO.creerCompte(montant, devise);
        //Then
        verify(bankDao, times(1)).creerCompte(montant, devise);
    }

    @Test
    public void consulterSoldeDoitAppelerGetSoldeEtRetournerUnMessage() throws Exception {
        //Given
        //When
        String message = bankAccountWithDAO.consulterSolde();
        //Then
        verify(bankDao, times(1)).getSolde();
        assertThat(message).isEqualTo(MessageFormat.format("Votre solde actuel est de {0} {1}", 20, Devise.DINAR.name()));
    }

    @Test
    public void deposerArgentDoitAppelerGetSoldeEtSaveMoneyAvecLeBonMontant() throws Exception {
        //Given
        int montant = 10;
        //When
        bankAccountWithDAO.deposerArgent(montant);
        //Then
        verify(bankDao, times(1)).getSolde();
        verify(bankDao, times(1)).saveMoney(bankDao.getSolde());
        assertThat(bankDao.getSolde().getMontant()).isEqualTo(20 + montant);
    }

    @Test
    public void retirerArgentDoitAppelerGetSoldeEtSaveMoneyAvecLeBonMontant() throws Exception {
        //Given
        int montant = 10;
        //When
        bankAccountWithDAO.retirerArgent(montant);
        //Then
        verify(bankDao, times(1)).getSolde();
        verify(bankDao, times(1)).saveMoney(bankDao.getSolde());
        assertThat(bankDao.getSolde().getMontant()).isEqualTo(20 - montant);
    }

    @Test
    public void isPositifDoitAppelerGetSolde() throws Exception {
        //Given
        //When
        bankAccountWithDAO.isSoldePositif();
        //Then
        verify(bankDao, times(1)).getSolde();
        assertThat(bankAccountWithDAO.isSoldePositif()).isTrue();
    }
}