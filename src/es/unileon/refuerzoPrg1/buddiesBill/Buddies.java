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
	
	public void add(String buddyName) throws BuddiesBillException {
		if(this.exists(buddyName)) {
			throw new BuddiesBillException("El buddy " + buddyName + " ya existe");
		}
		else if(this.next == this.buddies.length) {
			throw new BuddiesBillException("No se puede anyadir al buddy " + buddyName + ". Lista de buddies llena");
		}
		else {
			this.buddies[this.next] = new Buddy(buddyName, this.MAX_MOVEMENTS);
			this.next++;
		}
	}
	
	// TO-DO: Metodo reorder para llevar los null al final
	
	// DONE: Codigo duplicado
	
	// TO-DO: Hacer el toString()
	
	public void remove(String buddyName) throws BuddiesBillException {
		int buddyPosition = this.search(buddyName);
		
		if(buddyPosition == -1) {
			throw new BuddiesBillException("No se puede borrar a " + buddyName + " porque no existe");
		}
		else {
			this.buddies[buddyPosition] = null;
			this.reorder(buddyPosition);
			this.next--;
		}
	}
	
	public void add(Movement movement, String buddyName) throws BuddiesBillException {
		int buddyPosition = this.search(buddyName);
		
		if(buddyPosition == -1) {
			throw new BuddiesBillException("No se puede anyadir un movimiento a un buddy que no existe");
		}
		else if(this.exists(movement)) {
			throw new BuddiesBillException("El movimiento ya lo ha hecho otro buddy.");
		}
		else {
			this.buddies[buddyPosition].add(movement);
		}
	}
	
	public void removeMovement(String movementName) throws BuddiesBillException {
		int position = 0;
		boolean found = false;
		
		while(!found && position < this.next) {
			found = this.buddies[position].exists(movementName);
			position++;
		}
		// explicacion de esto tan raro
		position--;
		if(found) {
			this.buddies[position].removeMovement(movementName);
		}
		else {
			throw new BuddiesBillException("No se ha encontrado el movimiento");
		}
	}
	
	private boolean exists(Movement movement) {
		boolean found = false;
		int position = 0;
		
		while(position < this.next && !found) {
			found = this.buddies[position].exists(movement.getConcept());
			position++;
		}
		
		return found;
	}
	
	// TO-DO: Metodo equals de la clase Buddy para usarlo en este metodo
	
	private boolean exists(String buddyName) {
		return this.search(buddyName) != -1;
	}
	
	private int search(String buddyName) {
		int position = 0;
		
		while(position < this.next && !this.buddies[position].equals(buddyName)) {
			position++;
		}
		
		if(position == this.next) {
			position = -1;
		}
		
		return position;
		
	}
	
	private void reorder(int from) {
		for(int i=from; i<this.next - 1; i++) {
			this.swap(i, i+1);
		}
	}
	
	private void swap(int i, int j) {
		Buddy aux = this.buddies[i];
		this.buddies[i] = this.buddies[j];
		this.buddies[j] = aux;
	}
	
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		for(int i=0; i<this.next; i++) {
			output.append(this.buddies[i].toString() + "\n");
		}
		
		if(output.toString().length() == 0) {
			output.append("No hay buddies");
		}
		
		return output.toString();
	}

	public void settleUp() {
		
	}

}
