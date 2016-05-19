package testare;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import clase.Comanda;
import clase.Factura;
import clase.MobilaEnum;
import clase.MobilaFactory;

public class TestFactura {
	Factura factura;
	Comanda comanda;
	@Before
	public void setUp() throws Exception {
		comanda = new Comanda();
		MobilaFactory factory = MobilaFactory.getInstance();
		comanda.addMobila(factory.getMobila(MobilaEnum.Masa,375));
		comanda.addMobila(factory.getMobila(MobilaEnum.Scaun,150));
		comanda.addMobila(factory.getMobila(MobilaEnum.Scaun,150));
		factura = new Factura(null, null, comanda);
	}

	@Test
	public void testClona() {
		assertNotSame(factura, factura.copiaza());
	}
	
	@Test
	public void testValFaraTva() {
		assertEquals(675, factura.calculeazaValoareFaraTVA(comanda.getLista()), 0.2);
	}
	

	@Test
	public void testValFaraTvaInvers() {
		double suma = factura.calculeazaValoareFaraTVA(comanda.getLista());
		assertEquals(375+150, suma-150, 0.2);
	}

	@Test
	public void testValFaraTvaCrossCheck() {
		assertEquals(375+150+150, factura.calculeazaValoareFaraTVA(comanda.getLista()), 0.2);
	}
	
	@Test
	public void testValCuTva() {
		assertEquals(810, factura.calculeazaValoareCuTVA(comanda.getLista()), 0.2);
	}
	
	@Test
	public void testValCuTvaInvers() {
		assertEquals(675, factura.calculeazaValoareCuTVA(comanda.getLista())/1.2, 0.2);
	}
	
	@Test
	public void testValCuTvaCrossCheck() {
		assertEquals((375+150+150)*1.2, factura.calculeazaValoareCuTVA(comanda.getLista()), 0.2);
	}
	
	@Test
	public void testTVA() {
		assertEquals(20, factura.calculeazaTVA(100), 0.2);
		assertEquals(31.06, factura.calculeazaTVA(155.3), 0.2);
	}
	
	@Test
	public void testTVACrossCheck() {
		assertEquals(100*0.2, factura.calculeazaTVA(100), 0.2);
		assertEquals(155.3*0.2, factura.calculeazaTVA(155.3), 0.2);
	}
	
	@Test
	public void testTVAInvers() {
		assertEquals(100, factura.calculeazaTVA(100)/0.2, 0.2);
		assertEquals(155.3, factura.calculeazaTVA(155.3)/0.2, 0.2);
	}
	
	@Test
	public void testNrProduse() {
		assertEquals(3, factura.nrProduse(comanda.getLista()));
	}
	
	@Test
	public void testIsValid() {
		assertTrue(factura.isValid(comanda.getLista()));
	}

	@Test
	public void testGreutateColet() {
		assertEquals(22.6, factura.calculeazaGreutateColet(comanda.getLista()), 0.2);
	}
	
	@Test
	public void testGreutateColetCrossCheck() {
		assertEquals(15+2*3.8, factura.calculeazaGreutateColet(comanda.getLista()), 0.2);
	}
	
	@Test
	public void testGreutateColetInvers() {
		assertEquals(15, factura.calculeazaGreutateColet(comanda.getLista())-2*3.8, 0.2);
	}
}
