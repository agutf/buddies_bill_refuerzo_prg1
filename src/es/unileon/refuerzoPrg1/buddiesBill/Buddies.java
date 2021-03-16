package es.unileon.refuerzoPrg1.buddiesBill;

public class Buddies {
	
	private int MAX_MOVEMENTS;
	private int next;
	private Buddy buddies[];
	
	public Buddies(int maxMovements, int maxBuddies) {
		this.MAX_MOVEMENTS = maxMovements;
		this.next = 0;
		this.buddies = new Buddy[maxBuddies];
	}

}
