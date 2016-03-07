package fr.rouen.mastergil.tptest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountWithDAOUniTest {

    @Mock
    private JdbcDAO bankDAO;

    @InjectMocks
    private BankAccountWithDAO bankAccountWithDAO;

    @Before
    public void setUp() throws Exception {
        //Mock setupConnection
        Connection connection = mock(Connection.class);
//        when(connection.isClosed()).thenReturn(false);
//        when(connection.isReadOnly()).thenReturn(false);
        when(bankDAO.setUpConnection()).thenReturn(connection);
//        //Mock getSolde => return 20 DOLLAR
        Money solde = new Money(20, Devise.DOLLAR);
        when(bankDAO.getSolde()).thenReturn(solde);
    }


    @Test
    public void creer_un_compte_vide() throws Exception {
        //Given
        //When
        bankAccountWithDAO.creerCompte();
        //Then
        verify(bankDAO, times(1)).creerCompte();
    }


    @Test
    public void creer_un_compte_non_vide() throws Exception {

        //Given
        //When
        bankAccountWithDAO.creerCompte(20, Devise.DOLLAR);

        //Then
        verify(bankDAO, times(1)).creerCompte(20, Devise.DOLLAR);


    }


    @Test
    public void consulterSolde_affiche_solde() throws Exception {
        //Given
        //when
        String solde = bankAccountWithDAO.consulterSolde();
        //Then
        verify(bankDAO, times(1)).getSolde();
        assertThat(solde).isEqualTo("Votre solde actuel est de 20 DOLLAR");


    }

    @Test
    public void deposerArgent_change_le_montant() throws Exception {
        //Given
        //when
        final Money soldeApresDepot = bankAccountWithDAO.deposerArgent(30);
        //then
        verify(bankDAO, times(1)).saveMoney(any(Money.class));
        verify(bankDAO, times(1)).getSolde();
        assertThat(soldeApresDepot.getMontant()).isEqualTo(50);

    }

    @Test
    public void retirerArgent_change_le_montant() throws Exception {
        //Given
        //When
        final Money soldeApresDepot = bankAccountWithDAO.retirerArgent(10);
        //Then
        verify(bankDAO, times(1)).saveMoney(any(Money.class));
        verify(bankDAO, times(1)).getSolde();
        assertThat(soldeApresDepot.getMontant()).isEqualTo(10);
    }



    @Test
    public void isSoldePositif_depend_du_montant() throws Exception {
        //Given
        //When
        final boolean soldePositif = bankAccountWithDAO.isSoldePositif();
        //Then
        verify(bankDAO, times(1)).getSolde();
        assertThat(soldePositif).isTrue();
    }

}