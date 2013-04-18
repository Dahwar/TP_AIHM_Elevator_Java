package aihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;

/**
 * 
 * Create and animate a elevator, with a state machine
 * 
 * @author Florent LACROIX (Dahwar)
 * @version 1.0
 *
 */

public class Cabin extends JPanel{

	// the current Window
	private Window myWindow;
	
	// Init State Machine
	private enum CabinMoves {UP, DOWN, STAY};
	private CabinMoves currentMove = CabinMoves.STAY;
	private int currentPosition = 0;
	
	// Import Images
	private ImageIcon imgButtonCall = new ImageIcon("images/Call.png");
	private ImageIcon imgButtonCallSelected = new ImageIcon("images/CallSelected.png");
	
	// Create Buttons
	private JToggleButton buttonFloor0 = new JToggleButton (imgButtonCall);
    private JToggleButton buttonFloor1 = new JToggleButton (imgButtonCall);
    private JToggleButton buttonFloor2 = new JToggleButton (imgButtonCall);
	
    // Timers
    private Timer timer;
	private Timer timerPause;
	private Timer timerButtonFloor0 = new Timer(750, new ActionListener(){  
		public void actionPerformed(ActionEvent evt){
			buttonFloor0.setSelected(false);
			timerButtonFloor0.stop();
		}
	});	
	private Timer timerButtonFloor1 = new Timer(750, new ActionListener(){  
		public void actionPerformed(ActionEvent evt){
			buttonFloor1.setSelected(false);
			timerButtonFloor1.stop();
		}
	});	
	private Timer timerButtonFloor2 = new Timer(750, new ActionListener(){  
		public void actionPerformed(ActionEvent evt){
			buttonFloor2.setSelected(false);
			timerButtonFloor2.stop();
		}
	});	
	
	// Size of the cabin and coef for position
	int sizeElevX=100;
	int sizeElevY=150;
	int coef = 1000;
	
	// List of floor called
	private LinkedList<Integer> listFloor = new LinkedList<>();
	
	// List of buttons (inside/toolbar)
	private HashMap<Integer, JToggleButton> HMButtons;
	
	public Cabin(HashMap<Integer, JToggleButton> hm, Window window){
		this.myWindow = window;
		this.HMButtons = hm;
		
		// State Machine
		ActionListener taskPerformer = new ActionListener(){  
			public void actionPerformed(ActionEvent evt){
				switch(currentMove){
					case STAY:
						if(!listFloor.isEmpty()){
							if(listFloor.get(0)!=currentPosition){
								if(listFloor.get(0)>currentPosition)
									currentMove = CabinMoves.UP;
								else if(listFloor.get(0)<currentPosition)
									currentMove = CabinMoves.DOWN;
								else
									listFloor.remove(0);
							}
							else
								listFloor.remove(0);
								HMButtons.get(currentPosition).setSelected(false);
						}
						break;
						
					case UP:
						coef-=5;
						if(coef==0){
							currentPosition=2;
							myWindow.setCabinLevel(currentPosition);
						}
						else if(coef==500){
							currentPosition=1;
							myWindow.setCabinLevel(currentPosition);
						}
						else if(coef==1000){
							currentPosition=0;
							myWindow.setCabinLevel(currentPosition);
						}
						else;
						
						if(listFloor.get(0)==currentPosition){
							currentMove = CabinMoves.STAY;
							HMButtons.get(currentPosition).setSelected(false);
							timer.stop();
							timerPause.start();
							listFloor.remove(0);
						}
						break;
						
					case DOWN:
						coef+=5;
						if(coef==0){
							currentPosition=2;
							myWindow.setCabinLevel(currentPosition);
						}
						else if(coef==500){
							currentPosition=1;
							myWindow.setCabinLevel(currentPosition);
						}
						else if(coef==1000){
							currentPosition=0;
							myWindow.setCabinLevel(currentPosition);
						}
						else;
						
						if(listFloor.get(0)==currentPosition){
							currentMove = CabinMoves.STAY;
							HMButtons.get(currentPosition).setSelected(false);
							timer.stop();
							timerPause.start();
							listFloor.remove(0);
						}
						break;
				}
				repaint();
			}  
		};
		
		// Pause for each level
		ActionListener pause = new ActionListener(){  
			public void actionPerformed(ActionEvent evt){
				timer.start();
				timerPause.stop();
			}
		};
		
		// Start the state machine
		this.timer = new Timer(10, taskPerformer);
		this.timer.start();
		
		this.timerPause = new Timer(1000, pause);
	}
	
	public void paintComponent(Graphics g){
		
		double width = this.getWidth();
		double height = this.getHeight();
		
		double positionX = (width-sizeElevX)/2;
		double positionY = (height-sizeElevY)*((double)this.coef/1000);	
		
		super.paintComponent(g);
		
		this.setLayout(null);
		
		// Set the buttons and their positions
		this.buttonFloor2.setSelectedIcon(this.imgButtonCallSelected);
		this.buttonFloor2.setFocusable(false);
		this.buttonFloor2.setBounds((int)(positionX+150), 50, 50, 50);
		this.buttonFloor2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				addFloorToList(2);
				buttonFloor2.setSelected(true);
				timerButtonFloor2.start();
	    	}
	    });
		this.add(this.buttonFloor2);		
		
		this.buttonFloor1.setSelectedIcon(this.imgButtonCallSelected);
		this.buttonFloor1.setFocusable(false);
		this.buttonFloor1.setBounds((int)(positionX+150), 210, 50, 50);
		this.buttonFloor1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				addFloorToList(1);
				buttonFloor1.setSelected(true);
				timerButtonFloor1.start();
	    	}
	    });
		this.add(this.buttonFloor1);
		
		this.buttonFloor0.setSelectedIcon(this.imgButtonCallSelected);
		this.buttonFloor0.setFocusable(false);
		this.buttonFloor0.setBounds((int)(positionX+150), 380, 50, 50);
		this.buttonFloor0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				addFloorToList(0);
				buttonFloor0.setSelected(true);
				timerButtonFloor0.start();
	    	}
	    });
		this.add(this.buttonFloor0);
		
		// Draw the elevator and the cabin
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, (int)width, (int)height);
	    g.setColor(Color.BLACK);
	    g.drawLine((int)positionX-2, 0, (int)positionX-2, (int)height);
	    g.drawLine((int)positionX+sizeElevX+1, 0, (int)positionX+sizeElevX+1, (int)height);
	    g.setColor(Color.GRAY);
	    g.fillRect((int)positionX, (int)positionY, sizeElevX/2-1, sizeElevY);
	    g.fillRect((int)positionX+sizeElevX/2+1, (int)positionY, sizeElevX/2-1, sizeElevY);
	}
	
	
	/**
	 * 
	 * If a floor is called and isn't in the list of floor called, add him
	 * 
	 * @param floor floor to add in the list
	 * 
	 */
	public void addFloorToList(int floor){
		if(floor>=0 && floor<=2){
			if(!this.listFloor.contains(floor)){
				this.listFloor.add(floor);
				HMButtons.get(floor).setSelected(true);
			}
		}
	}
}
