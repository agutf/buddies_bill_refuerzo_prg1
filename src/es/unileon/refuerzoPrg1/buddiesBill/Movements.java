package es.unileon.refuerzoPrg1.buddiesBill;

public class Movements {
	
	private int next;
	private Movement movements[];
	
	public Movements(int maxMovements) {
		this.movements = new Movement[maxMovements];
		this.next = 0;
	}
	
	public void add(Movement movement) throws BuddiesBillException {
		if(this.next == this.movements.length) {
			throw new BuddiesBillException("Se ha alcanzado el maximo de movimientos para este buddy");
		}
		else {
			this.movements[this.next] = movement;
			this.next++;
		}
	}
	
	public void remove(String movementName) throws BuddiesBillException {
		if(!this.exists(movementName)) {
			throw new BuddiesBillException("No se puede borrar el movimiento porque no existe.");
		}
		else {
			int position = this.search(movementName);
			this.movements[position] = null;
			this.reorder(position);
			this.next--;
		}
	}
	
	private void reorder(int from) {
		for(int i=from; i<this.next - 1; i++) {
			this.swap(i, i+1);
		}
	}
	
	private void swap(int i, int j) {
		Movement aux = this.movements[i];
		this.movements[i] = this.movements[j];
		this.movements[j] = aux;
	}
	
	public boolean exists(String movementName) {
		return this.search(movementName) != -1;
	}
	
	private int search(String movementName) {
		int position = 0;
		boolean found = false;
		
		while(position < this.next && !found) {
			found = this.movements[position].equals(movementName);
			position++;
		}
		
		if(!found) {
			position = -1;
		}
		
		return position;
	}
	
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		for(int i=0; i<this.next; i++) {
			output.append(this.movements[i].toString() + "\n");
		}
		
		return "[\n" + output.toString() + "]";
	}

}
