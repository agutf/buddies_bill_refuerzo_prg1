package es.unileon.refuerzoPrg1.buddiesBill;

public class Movements {
	
	private int next;
	private Movement movements[];
	
	public Movements(int maxMovements) {
		this.movements = new Movement[maxMovements];
		this.next = 0;
	}
	
	public String toString() {
		return "[]";
	}

}
