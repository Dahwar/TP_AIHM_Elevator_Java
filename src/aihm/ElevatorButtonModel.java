package aihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultButtonModel;

public class ElevatorButtonModel extends DefaultButtonModel implements ActionListener{
	
	public ElevatorButtonModel(){
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
	}
}
