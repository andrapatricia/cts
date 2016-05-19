package testare;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clase.Comanda;
import clase.Mobila;
import clase.MobilaEnum;
import clase.MobilaFactory;

public class TestComanda {

	Comanda comanda;
	
	@Before
	public void setUp() throws Exception {
		comanda = new Comanda();
	}
	
	@Test
	public void testGetNull() {
		assertNull(comanda.getLista());
	}
	
	@Test
	public void testAdd(){
		MobilaFactory factory = MobilaFactory.getInstance();
		comanda.addMobila(factory.getMobila(MobilaEnum.Masa,375));
		assertEquals(1, comanda.getLista().size());
	}
	
	@Test
	public void testRemove(){
		MobilaFactory factory = MobilaFactory.getInstance();
		comanda.addMobila(factory.getMobila(MobilaEnum.Masa,375));
		Mobila m = factory.getMobila(MobilaEnum.Noptiera, 200);
		comanda.addMobila(m);
		comanda.removeMobila(m);
		assertEquals(1, comanda.getLista().size());
	}
	
	@Test
	public void testGet() {
		MobilaFactory factory = MobilaFactory.getInstance();
		comanda.addMobila(factory.getMobila(MobilaEnum.Masa,375));
		assertNotNull(comanda.getLista());
	}
	


}
