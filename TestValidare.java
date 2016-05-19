package testare;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clase.Validare;

public class TestValidare {
	Validare validare;
	
	@Before
	public void setUp() throws Exception {
		validare = new Validare();
	}

	@Test
	public void testCNP() {
		String cnp1 = "1930729213031";
		String cnp2 = "1930729s13031";
		String cnp3 = "193072921303";		
		
		assertTrue(validare.validareCNP(cnp1.toCharArray()));
		assertFalse(validare.validareCNP(cnp2.toCharArray()));
		assertFalse(validare.validareCNP(cnp3.toCharArray()));
	}

	@Test
	public void testNume(){
		String nume1 = "Popescu";
		String nume2 = " ";
		String nume3 = " Pop";
		String nume4 = "pop2";
		
		assertTrue(validare.validareNume(nume1.toCharArray()));
		assertFalse(validare.validareNume(nume2.toCharArray()));
		assertFalse(validare.validareNume(nume3.toCharArray()));
		assertFalse(validare.validareNume(nume4.toCharArray()));
	}
	
	@Test
	public void testPrenume(){
		String nume1 = "Andra";
		String nume2 = " ";
		String nume3 = "Andra Patricia";
		String nume4 = "Andra-Patricia";
		String nume5 = "Andra-Patr1cia";
		String nume6 = " Andra Patricia";
		String nume7 = " Andr@dsd";
				
		assertTrue(validare.validarePrenume(nume1));
		assertFalse(validare.validarePrenume(nume2));
		assertTrue(validare.validarePrenume(nume3));
		assertTrue(validare.validarePrenume(nume4));
		assertFalse(validare.validarePrenume(nume5));
		assertFalse(validare.validarePrenume(nume6));
		assertFalse(validare.validarePrenume(nume7));
	}
	
	@Test
	public void testTelefon(){
		String t1 = "0744123456";
		String t2 = "074412345";
		String t3 = " 744123456";
		String t4 = "o744123456";
		
		assertTrue(validare.validareTelefon(t1.toCharArray()));
		assertFalse(validare.validareTelefon(t2.toCharArray()));
		assertFalse(validare.validareTelefon(t3.toCharArray()));
		assertFalse(validare.validareTelefon(t4.toCharArray()));
	}
	
	@Test
	public void testAdresa(){
		String a1 = "Strada Cuza Voda, nr 15, Bucuresti ";
		String a2 = "";
		
		assertTrue(validare.validareAdresa(a1));
		assertFalse(validare.validareAdresa(a2));
		
	}
}
