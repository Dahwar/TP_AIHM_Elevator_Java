package aihm;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class Cabin extends JPanel{

	private ImageIcon imgButtonCall = new ImageIcon("images/Call.png");
	private ImageIcon imgButtonCallSelected = new ImageIcon("images/CallSelected.png");
	
	private JToggleButton buttonFloor0 = new JToggleButton (imgButtonCall);
    private JToggleButton buttonFloor1 = new JToggleButton (imgButtonCall);
    private JToggleButton buttonFloor2 = new JToggleButton (imgButtonCall);
	
	int sizeElevX=100;
	int sizeElevY=150;
	int coef = 1000;
	
	private HashMap<String, JToggleButton> HMButtonsFloor;
	
	public Cabin(){
	}
	
	public void paintComponent(Graphics g){
		
		double width = this.getWidth();
		double height = this.getHeight();
		
		double positionX = (width-sizeElevX)/2;
		double positionY = (height-sizeElevY)*((double)this.coef/1000);	
		
		super.paintComponent(g);
		
		this.setLayout(null);
		
		this.buttonFloor0.setSelectedIcon(this.imgButtonCallSelected);
		this.buttonFloor0.setFocusable(false);
		this.buttonFloor0.setBounds((int)(positionX+150), 50, 50, 50);
		this.add(this.buttonFloor0);
		
		this.buttonFloor1.setSelectedIcon(this.imgButtonCallSelected);
		this.buttonFloor1.setFocusable(false);
		this.buttonFloor1.setBounds((int)(positionX+150), 210, 50, 50);
		this.add(this.buttonFloor1);
		
		this.buttonFloor2.setSelectedIcon(this.imgButtonCallSelected);
		this.buttonFloor2.setFocusable(false);
		this.buttonFloor2.setBounds((int)(positionX+150), 380, 50, 50);
		this.add(this.buttonFloor2);
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, (int)width, (int)height);
	    g.setColor(Color.BLACK);
	    g.drawLine((int)positionX-2, 0, (int)positionX-2, (int)height);
	    g.drawLine((int)positionX+sizeElevX+1, 0, (int)positionX+sizeElevX+1, (int)height);
	    g.setColor(Color.GRAY);
	    g.fillRect((int)positionX, (int)positionY, sizeElevX/2-1, sizeElevY);
	    g.fillRect((int)positionX+sizeElevX/2+1, (int)positionY, sizeElevX/2-1, sizeElevY);
	}
}
