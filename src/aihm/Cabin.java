package aihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class Cabin extends JPanel{

	int sizeElevX=100;
	int sizeElevY=150;
	int coef = 1000;
	
	private HashMap<String, JToggleButton> HMButtonsFloor;
	
	public Cabin(HashMap<String, JToggleButton> hm){
		this.HMButtonsFloor = hm;
	}
	
	public void paintComponent(Graphics g){
		
		double width = this.getWidth();
		double height = this.getHeight();
		
		double positionX = (width-sizeElevX)/2;
		double positionY = (height-sizeElevY)*((double)this.coef/1000);	
		
		super.paintComponent(g);
		
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
