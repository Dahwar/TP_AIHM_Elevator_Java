package aihm;

/**
 * 
 * This is the project of AIHM : Elevator Simulation
 * 
 * ENSISA 2A IR
 * 
 * The purpose is to create a 3-levels elevator, with memorization of the calls and synchronization of the buttons.
 * Here, we chose to memorize a call for a floor if and only if this floor was not called yet (the call is otherwise ignored).
 * And, after put on one of a button representing a floor (a landing), it remains switched on 0.75s only before light off (arbitrary choice)
 * 
 * @author Florent LACROIX (Dahwar)
 * @version 1.0
 * 
 */

public class Main {
	public static void main(String[] args) {
		Window window = new Window();
	}
}
