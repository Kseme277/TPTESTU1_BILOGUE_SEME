import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stjean.tptestu1_bilogue_seme.EmailInvalidException;
import com.stjean.tptestu1_bilogue_seme.SuppressionInvalidException;
import com.stjean.tptestu1_bilogue_seme.Utilisateur;

class TestUtilisateur {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	

	@AfterEach
	void tearDown() throws Exception {
	}
	private Utilisateur user1;
    private Utilisateur user2;
    
    @BeforeEach
    void setUp() {
        // Nettoyer la liste avant chaque test
        Utilisateur.users.clear();
        user1 = new Utilisateur(1, "Alice", 30, "alice@email.com", "123", "Paris", 1000.0);
        user2 = new Utilisateur(2, "Bob", 25, "bob@email.com", "456", "Lyon", -500.0);
    }
    
    @Test
    void testAjouter() throws EmailInvalidException {
        Utilisateur.ajouter(user1);
        assertEquals(1, Utilisateur.lister().size());
        assertThrows(EmailInvalidException.class, () -> Utilisateur.ajouter(new Utilisateur(3, "Charlie", 20, "invalid-email", "789", "Marseille", 200.0)));
    }
    
    @Test
    void testSupprimer() throws EmailInvalidException, SuppressionInvalidException {
        Utilisateur.ajouter(user1);
        Utilisateur.supprimer(1);
        assertEquals(0, Utilisateur.lister().size());
        assertThrows(SuppressionInvalidException.class, () -> Utilisateur.supprimer(999));
    }
    @Test
    void testAfficher() throws EmailInvalidException {
        Utilisateur.ajouter(user1);
        assertEquals(user1, Utilisateur.afficher(1));
        assertNull(Utilisateur.afficher(999));
    }
    
    @Test
    void testAnalyseSoldeGeneral() throws EmailInvalidException, NegativeGeneralBalanceException {
        Utilisateur.ajouter(new Utilisateur(1, "A", 30, "a@email.com", "123", "P", 1000.0));
        Utilisateur.ajouter(new Utilisateur(2, "B", 25, "b@email.com", "456", "L", 500.0));
        assertEquals(1500.0, Utilisateur.analyseSoldeGeneral());
        
        // Test exception négatif
        Utilisateur.ajouter(new Utilisateur(3, "C", 20, "c@email.com", "789", "M", -3000.0));
        assertThrows(NegativeGeneralBalanceException.class, () -> Utilisateur.analyseSoldeGeneral());
    }
    
    @Test
    void testUtilisateurLePlusRiche() throws EmailInvalidException {
        Utilisateur.ajouter(user1); // 1000
        Utilisateur.ajouter(user2); // -500
        assertEquals(user1, Utilisateur.utilisateurLePlusRiche());
    }
}
