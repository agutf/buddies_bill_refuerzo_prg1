package es.unileon.refuerzoPrg1.buddiesBill;

public class Event {
	
	private String name;
	private Buddies buddies;
	
	public Event(String name, int maxBuddies, int maxMovements) {
		this.name = name;
		this.buddies = new Buddies(maxMovements, maxBuddies);
	}
	
	public void add(String buddyName) {
		this.buddies.add(buddyName);
	}
	
	public void remove(String buddyName) {
		this.buddies.remove(buddyName);
	}

}
