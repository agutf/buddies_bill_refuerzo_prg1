package es.unileon.refuerzoPrg1.buddiesBill;

public class Payment {
	
	private float amount;
	private Buddy from;
	private Buddy to;
	
	public Payment(float amount, Buddy from, Buddy to) {
		this.amount = amount;
		this.from = from;
		this.to = to;
	}
}
