package es.unileon.refuerzoPrg1.buddiesBill;

public class TextUI {
	
	private Event event;
	
	public TextUI(Event event) {
		this.event = event;
	}
	
	public void init() {
		int option = 0;
		
		while(option != 9) {
//			this.showSummary();
//			this.showOptions();
			option = this.selectOption();
//			this.executeOption(option);
		}
	}
	
	private int selectOption() {
		int option;
		
		do {
			System.out.println("Introduce la opcion que quieres seleccionar:");
			option = Keyboard.readInteger();
			if(option == Integer.MIN_VALUE) {
				System.out.println("Error: No has introducido un numero");
			}
			else if(option < 1 || option > 9) {
				System.out.println("Error: La opcion introducida no es valida");
			}
		} while(option == Integer.MIN_VALUE || option < 1 || option > 9);
		
		return option;
	}
	
	private void execute(int option) {
		switch(option) {
			case 1: this.addBuddy();
				break;
			case 2: this.removeBuddy();
				break;
			case 3: this.addMovement();
				break;
			case 4: this.removeMovement();
				break;
			case 5: //this.showSummary();
				break;
			case 6: this.settleUp();
				break;
			case 7: //this.exit();
				break;
		}
	}
	
	private void settleUp() {
		this.event.settleUp();
	}

	private void addBuddy() {
		System.out.println("Introduce el nombre del buddy a anyadir");
		String buddyName = Keyboard.readString();
		try {
			this.event.add(buddyName);
		} catch (BuddiesBillException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void removeBuddy() {
		System.out.println("Introduce el nombre del buddy a eliminar");
		String buddyName = Keyboard.readString();
		try {
			this.event.remove(buddyName);
		} catch (BuddiesBillException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void addMovement() {
		System.out.println("Introduce el concepto del movimiento");
		String what = Keyboard.readString();
		
		float howMuch;
		
		do {
			System.out.println("Introduce el valor del movimiento");
			howMuch = Keyboard.readFloat();
			
			if(howMuch == Float.MIN_VALUE) {
				System.out.println("Error: No has introducido un valor valido");
			}
			else if(howMuch < 0) {
				System.out.println("Error: No se permiten valores negativos");
			}
		} while(howMuch == Float.MIN_VALUE || howMuch < 0);
		
		String buddyName = Keyboard.readString();
		
		Movement movement = new Movement(howMuch, what);
		
		try {
			this.event.add(movement, buddyName);
		} catch (BuddiesBillException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void removeMovement() {
		String movementName = Keyboard.readString();
		//this.event.remove(movementName);
	}
	
}
