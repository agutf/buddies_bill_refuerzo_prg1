package es.unileon.refuerzoPrg1.buddiesBill;

public class Payments {
	
	private int next;
	private Payment payments[];
	
	public Payments(int maxPayments) {
		this.next = 0;
		this.payments = new Payment[maxPayments];
	}

}
