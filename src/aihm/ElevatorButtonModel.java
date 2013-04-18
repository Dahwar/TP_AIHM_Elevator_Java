package aihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultButtonModel;

/**
 * 
 * Model for synchronized the buttons
 * 
 * @author Florent LACROIX (Dahwar)
 * @version 1.0
 *
 */

public class ElevatorButtonModel extends DefaultButtonModel implements ActionListener{
	
	public ElevatorButtonModel(){
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
	}
}
