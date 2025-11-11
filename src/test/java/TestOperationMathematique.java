import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stjean.operation.OperationMathematique;

class TestOperationMathematique {
	private OperationMathematique op = new OperationMathematique();
    

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}


    @Test
    void testEstPositif() {
        assertTrue(op.estPositif(5));
        assertFalse(op.estPositif(-3));
        assertFalse(op.estPositif(0));
    }
    
    @Test
    void testFactoriel() {
        assertEquals(1, op.factoriel(0));
        assertEquals(1, op.factoriel(1));
        assertEquals(120, op.factoriel(5));
        
    }

	// Ajouts aux tests existants

	@Test
	void testTrier() {
		assertArrayEquals(new int[]{5, 4, 3, 1, 1}, op.trier(new int[]{3, 1, 4, 1, 5}));
		assertArrayEquals(new int[]{1}, op.trier(new int[]{1}));
		assertArrayEquals(new int[]{}, op.trier(new int[]{}));
	}

}
