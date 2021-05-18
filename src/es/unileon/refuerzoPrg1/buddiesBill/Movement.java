package es.unileon.refuerzoPrg1.buddiesBill;

public class Movement {
	
	private float amount;
	private String concept;
	
	public Movement(float amount, String concept) {
		this.amount = amount;
		this.concept = concept;
	}
	
	public String getConcept() {
		return this.concept;
	}
	
	public boolean equals(String movementName) {
		return this.concept.equals(movementName);
	}
	
	public String toString() {
		return this.concept + " " + this.amount;
	}
}
