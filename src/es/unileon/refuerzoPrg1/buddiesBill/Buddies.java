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
	
	public void add(String buddyName) {
		if(this.exists(buddyName)) {
			throw new BuddiesBillException("El buddy " + buddyName + " ya existe");
		}
		else if(this.next == this.buddies.length) {
			throw new BuddiesBillExpception("No se puede anyadir al buddy " + buddyName ". Lista de buddies llena");
		}
		else {
			this.buddies[this.next] = new Buddy(buddyName, this.MAX_MOVEMENTS);
			this.next++;
		}
	}
	
	// TO-DO: Metodo reorder para llevar los null al final
	
	// TO-DO: Codigo duplicado
	
	public void remove(String buddyName) {
		int position = 0;
		
		while(!this.buddies[position].equals(buddyName) && position < this.next) {
			position++;
		}
		
		if(position != this.next) {
			this.buddies[position] = null;
			this.reorder();
			this.next--;
		}
	}
	
	// TO-DO: Metodo equals de la clase Buddy para usarlo en este metodo
	
	private boolean exists(String buddyName) {
		int position = 0;
		boolean exists = false;
		
		while(!this.buddies[position].equals(buddyName) && position < this.next) {
			position++;
		}
		
		if(position != this.next) {
			exists = true;
		}
		
		return exists;
	}

}
