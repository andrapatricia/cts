package testare;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import clase.Client;

public class TestClient {

	
	@Test
	public void testClient() {
		Client client = new Client("1234567890", "Popescu", "Ion");
		assertTrue(("1234567890").equals(client.getCNP()));
		assertTrue(("Popescu").equals(client.getNume()));
		assertTrue(("Ion").equals(client.getPrenume()));
	}

}
