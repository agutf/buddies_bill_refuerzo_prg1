package es.unileon.refuerzoPrg1.buddiesBill;

public class Buddy {
	
	private String name;
	private Movements movements;
	
	public Buddy(String name, int maxMovements) {
		this.name = name;
		this.movements = new Movements(maxMovements);
	}
	
	public void add(Movement movement) throws BuddiesBillException {
		this.movements.add(movement);
	}
	
	public void removeMovement(String movementName) throws BuddiesBillException {
		this.movements.remove(movementName);
	}
	
	public boolean equals(String buddyName) {
		return this.name == buddyName;
	}
	
	public boolean exists(String movementName) {
		return this.movements.exists(movementName);
	}
	
	public String toString() {
		return this.name + "\n" + this.movements.toString();
	}

}
