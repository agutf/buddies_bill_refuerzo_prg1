package es.unileon.refuerzoPrg1.buddiesBill;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BuddiesTest {
	
	private Buddies buddies;
	private String sergio, oliver, gladis;
	
	@Before
	public void setUp() {
		this.buddies = new Buddies(3, 3);
		this.sergio = "Sergio";
		this.oliver = "Oliver";
		this.gladis = "Gladis";
	}
	
	@Test
	public void testRemoveOk() throws BuddiesBillException{
		this.buddies.add(this.sergio);
		assertEquals("Sergio\n[]\n", this.buddies.toString());
		
		this.buddies.remove(this.sergio);
		assertEquals("No hay buddies", this.buddies.toString());
	}
	
	@Test
	public void testRemoveFirst() throws BuddiesBillException {
		this.buddies.add(this.sergio);
		this.buddies.add(this.oliver);
		this.buddies.add(this.gladis);
		assertEquals("Sergio\n[]\nOliver\n[]\nGladis\n[]\n", this.buddies.toString());
		
		this.buddies.remove(this.sergio);
		assertEquals("Oliver\n[]\nGladis\n[]\n", this.buddies.toString());
	}
	
	@Test
	public void testRemoveLast() throws BuddiesBillException {
		this.buddies.add(this.sergio);
		this.buddies.add(this.oliver);
		this.buddies.add(this.gladis);
		assertEquals("Sergio\n[]\nOliver\n[]\nGladis\n[]\n", this.buddies.toString());
		
		this.buddies.remove(this.gladis);
		assertEquals("Sergio\n[]\nOliver\n[]\n", this.buddies.toString());
	}
	
	@Test
	public void testRemoveMiddle() throws BuddiesBillException {
		this.buddies.add(this.sergio);
		this.buddies.add(this.oliver);
		this.buddies.add(this.gladis);
		assertEquals("Sergio\n[]\nOliver\n[]\nGladis\n[]\n", this.buddies.toString());
		
		this.buddies.remove(this.oliver);
		assertEquals("Sergio\n[]\nGladis\n[]\n", this.buddies.toString());
	}
	
	@Test(expected = BuddiesBillException.class)
	public void testRemoveEmpty() throws BuddiesBillException {
		this.buddies.remove(this.sergio);
	}
	
	@Test(expected = BuddiesBillException.class)
	public void testRemoveNotExists() throws BuddiesBillException {
		this.buddies.add(this.sergio);
		this.buddies.add(this.oliver);
		this.buddies.remove(this.gladis);
	}
	
	@Test
	public void testToString() throws BuddiesBillException {
		this.buddies.add(this.sergio);
		this.buddies.add(this.gladis);
		this.buddies.add(this.oliver);
		
		assertEquals("Sergio\n[]\nGladis\n[]\nOliver\n[]\n", this.buddies.toString());
	}

}
