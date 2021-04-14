package es.unileon.refuerzoPrg1.buddiesBill;

public class Buddy {
	
	private String name;
	private Movements movements;
	
	public Buddy(String name, int maxMovements) {
		this.name = name;
		this.movements = new Movements(maxMovements);
	}
	
	public boolean equals(String buddyName) {
		return this.name == buddyName;
	}
	
	public String toString() {
		return this.name + "\n" + this.movements.toString();
	}

}
