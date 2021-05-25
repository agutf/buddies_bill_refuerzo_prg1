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
	public void testAddEmpty() throws BuddiesBillException {
		assertEquals("No hay buddies", this.buddies.toString());
		this.buddies.add(this.sergio);
		assertEquals("Sergio\n[\n]\n", this.buddies.toString());
	}
	
	@Test(expected = BuddiesBillException.class)
	public void testAddFull() throws BuddiesBillException {
		this.buddies.add(this.sergio);
		this.buddies.add(this.gladis);
		this.buddies.add(this.oliver);
		this.buddies.add("Miranda");
	}
	
	@Test
	public void testAddUntilFull() throws BuddiesBillException {
		this.buddies.add(this.sergio);
		this.buddies.add(this.gladis);
		this.buddies.add(this.oliver);
		assertEquals("Sergio\n[\n]\nGladis\n[\n]\nOliver\n[\n]\n", this.buddies.toString());
	}
	
	@Test(expected = BuddiesBillException.class)
	public void testAddRepeated() throws BuddiesBillException {
		this.buddies.add(this.oliver);
		this.buddies.add(this.oliver);
	}
	
	@Test
	public void testRemoveOk() throws BuddiesBillException{
		this.buddies.add(this.sergio);
		assertEquals("Sergio\n[\n]\n", this.buddies.toString());
		
		this.buddies.remove(this.sergio);
		assertEquals("No hay buddies", this.buddies.toString());
	}
	
	@Test
	public void testRemoveFirst() throws BuddiesBillException {
		this.buddies.add(this.sergio);
		this.buddies.add(this.oliver);
		this.buddies.add(this.gladis);
		assertEquals("Sergio\n[\n]\nOliver\n[\n]\nGladis\n[\n]\n", this.buddies.toString());
		
		this.buddies.remove(this.sergio);
		assertEquals("Oliver\n[\n]\nGladis\n[\n]\n", this.buddies.toString());
	}
	
	@Test
	public void testRemoveLast() throws BuddiesBillException {
		this.buddies.add(this.sergio);
		this.buddies.add(this.oliver);
		this.buddies.add(this.gladis);
		assertEquals("Sergio\n[\n]\nOliver\n[\n]\nGladis\n[\n]\n", this.buddies.toString());
		
		this.buddies.remove(this.gladis);
		assertEquals("Sergio\n[\n]\nOliver\n[\n]\n", this.buddies.toString());
	}
	
	@Test
	public void testRemoveMiddle() throws BuddiesBillException {
		this.buddies.add(this.sergio);
		this.buddies.add(this.oliver);
		this.buddies.add(this.gladis);
		assertEquals("Sergio\n[\n]\nOliver\n[\n]\nGladis\n[\n]\n", this.buddies.toString());
		
		this.buddies.remove(this.oliver);
		assertEquals("Sergio\n[\n]\nGladis\n[\n]\n", this.buddies.toString());
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
	public void testAddMovementOk() throws BuddiesBillException {
		this.buddies.add(this.sergio);
		this.buddies.add(this.oliver);
		
		Movement gasolina = new Movement(100, "Gasolina");
		Movement hotel = new Movement(500, "Hotel");
		
		this.buddies.add(gasolina, this.sergio);
		this.buddies.add(hotel, this.oliver);
		
		assertEquals("Sergio\n[\nGasolina 100.0\n]\nOliver\n[\nHotel 500.0\n]\n", this.buddies.toString());
	}
	
	@Test(expected = BuddiesBillException.class)
	public void testAddMovementRepeated() throws BuddiesBillException {
		this.buddies.add(this.sergio);
		this.buddies.add(this.oliver);
		
		Movement gasolina = new Movement(100, "Gasolina");
		
		this.buddies.add(gasolina, this.sergio);
		this.buddies.add(gasolina, this.oliver);
	}

	@Test(expected = BuddiesBillException.class)
	public void testAddMovementNoBuddy() throws BuddiesBillException {
		Movement gasolina = new Movement(100, "Gasolina");
		this.buddies.add(gasolina, this.sergio);
	}

	@Test
	public void testRemoveMovementOK() throws BuddiesBillException {
		this.buddies.add("Sergio");
		Movement hotel = new Movement(500, "Hotel");
		this.buddies.add(hotel,"Sergio");
		assertEquals("Sergio\n"
				+ "[\n"
				+ "Hotel 500.0\n"
				+ "]\n", this.buddies.toString());
		this.buddies.removeMovement("Hotel");
		assertEquals("Sergio\n"
				+ "[\n"
				+ "]\n", this.buddies.toString());
	}
	
	
	@Test(expected = BuddiesBillException.class)
	public void testRemoveMovement() throws BuddiesBillException {
		this.buddies.removeMovement("Hotel");
	}

	@Test
	public void testToString() throws BuddiesBillException {
		this.buddies.add(this.sergio);
		this.buddies.add(this.gladis);
		this.buddies.add(this.oliver);
		
		assertEquals("Sergio\n[\n]\nGladis\n[\n]\nOliver\n[\n]\n", this.buddies.toString());
	}

}
