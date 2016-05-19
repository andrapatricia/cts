package testare;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import clase.DateClient;

public class TestDateClient {
	DateClient date;
	
	@Before
	public void setUp() throws Exception {
		date = new DateClient("0744123456", "Bucuresti, Bulevardul Unirii, Nr. 30");
	}

	@Test
	public void testDateClient() {
		assertTrue(("0744123456").equals(date.getNrTelefon()));
		assertTrue(("Bucuresti, Bulevardul Unirii, Nr. 30").equals(date.getAdresa()));
	}

}
