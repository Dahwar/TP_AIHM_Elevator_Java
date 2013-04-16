package aihm;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class Window extends JFrame{
	
	JPanel cabin = new Cabin();
	
	// JMenuBar
	JMenuBar JMenuBar = new JMenuBar();
	JMenu JMenuFiles = new JMenu("Files");
	JMenuItem itemFiles_Quit = new JMenuItem("Quit");
	
	JToolBar toolBar = new JToolBar();
	Box elevatorInsideButtons = Box.createVerticalBox();
	Box elevatorToolBarButtons = Box.createHorizontalBox();
	JPanel JPElevatorInside = new JPanel();
	
	// Import Images
	ImageIcon imgButton0 = new ImageIcon("images/Zero.png");
	ImageIcon imgButton1 = new ImageIcon("images/One.png");
	ImageIcon imgButton2 = new ImageIcon("images/Two.png");
	ImageIcon imgButton0Selected = new ImageIcon("images/ZeroSelected.png");
	ImageIcon imgButton1Selected = new ImageIcon("images/OneSelected.png");
	ImageIcon imgButton2Selected = new ImageIcon("images/TwoSelected.png");
	
	// Button creation
    JToggleButton buttonInside0 = new JToggleButton(imgButton0);
    JToggleButton buttonInside1 = new JToggleButton(imgButton1);
    JToggleButton buttonInside2 = new JToggleButton(imgButton2);
    JToggleButton buttonToolBar0 = new JToggleButton(imgButton0);
    JToggleButton buttonToolBar1 = new JToggleButton(imgButton1);
    JToggleButton buttonToolBar2 = new JToggleButton(imgButton2);
	
    // Elevator Button Model
    ElevatorButtonModel modelButton0 = new ElevatorButtonModel();
    ElevatorButtonModel modelButton1 = new ElevatorButtonModel();
    ElevatorButtonModel modelButton2 = new ElevatorButtonModel();
    
    // HashMap of buttons
    HashMap<String, JToggleButton> HMButtonsFloor = new HashMap<String, JToggleButton>();
    
	public Window(){
		//Parameters for window
		this.setTitle("AIHM Elevator");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		// Create JMenuBar
		this.JMenuFiles.setMnemonic('F');
		this.itemFiles_Quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
		this.JMenuFiles.add(this.itemFiles_Quit);
		this.JMenuBar.add(this.JMenuFiles);
		this.itemFiles_Quit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				System.exit(0);
			}
	    });
		this.setJMenuBar(this.JMenuBar);
		
		// Model
		this.buttonInside0.setModel(modelButton0);
		this.buttonToolBar0.setModel(modelButton0);
		this.buttonInside1.setModel(modelButton1);
		this.buttonToolBar1.setModel(modelButton1);
		this.buttonInside2.setModel(modelButton2);
		this.buttonToolBar2.setModel(modelButton2);
		
		// Set selected icon for button
		this.buttonInside0.setSelectedIcon(this.imgButton0Selected);
		this.buttonInside1.setSelectedIcon(this.imgButton1Selected);
		this.buttonInside2.setSelectedIcon(this.imgButton2Selected);
		this.buttonToolBar0.setSelectedIcon(this.imgButton0Selected);
		this.buttonToolBar1.setSelectedIcon(this.imgButton1Selected);
		this.buttonToolBar2.setSelectedIcon(this.imgButton2Selected);
		
		// Configure ToolBar
		this.elevatorToolBarButtons.add(Box.createRigidArea(new Dimension(10,0)));
		this.buttonToolBar0.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.buttonToolBar0.setFocusable(false);
		this.buttonToolBar0.setMaximumSize(new Dimension(35, 50));
		this.buttonToolBar0.setMinimumSize(new Dimension(35, 50));
		this.buttonToolBar0.setPreferredSize(new Dimension(35, 50));
		this.elevatorToolBarButtons.add(this.buttonToolBar0);
		this.elevatorToolBarButtons.add(Box.createRigidArea(new Dimension(10,0)));
		
		this.buttonToolBar1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.buttonToolBar1.setFocusable(false);
		this.buttonToolBar1.setMaximumSize(new Dimension(35, 50));
		this.buttonToolBar1.setMinimumSize(new Dimension(35, 50));
		this.buttonToolBar1.setPreferredSize(new Dimension(35, 50));
		this.elevatorToolBarButtons.add(this.buttonToolBar1);
		this.elevatorToolBarButtons.add(Box.createRigidArea(new Dimension(10,0)));
		
		this.buttonToolBar2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.buttonToolBar2.setFocusable(false);
		this.buttonToolBar2.setMaximumSize(new Dimension(35, 50));
		this.buttonToolBar2.setMinimumSize(new Dimension(35, 50));
		this.buttonToolBar2.setPreferredSize(new Dimension(35, 50));
		this.elevatorToolBarButtons.add(this.buttonToolBar2);
		
		this.toolBar.add(this.elevatorToolBarButtons);
		
		// Configure Inside Button
		this.buttonInside2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.buttonInside2.setFocusable(false);
		this.buttonInside2.setMaximumSize(new Dimension(50, 35));
		this.buttonInside2.setMinimumSize(new Dimension(50, 35));
		this.buttonInside2.setPreferredSize(new Dimension(50, 35));
		this.buttonInside2.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent event){
	    		  buttonInside2.setSelected(!buttonInside2.isSelected());
	    	  }
	    });
		this.elevatorInsideButtons.add(this.buttonInside2);
		this.elevatorInsideButtons.add(Box.createRigidArea(new Dimension(0,10)));
		
		this.buttonInside1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.buttonInside1.setFocusable(false);
		this.buttonInside1.setMaximumSize(new Dimension(50, 35));
		this.buttonInside1.setMinimumSize(new Dimension(50, 35));
		this.buttonInside1.setPreferredSize(new Dimension(50, 35));
		this.buttonInside1.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent event){
	    		  buttonInside1.setSelected(!buttonInside1.isSelected());
	    	  }
	    });
		this.elevatorInsideButtons.add(this.buttonInside1);
		this.elevatorInsideButtons.add(Box.createRigidArea(new Dimension(0,10)));
		
		this.buttonInside0.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.buttonInside0.setFocusable(false);
		this.buttonInside0.setMaximumSize(new Dimension(50, 35));
		this.buttonInside0.setMinimumSize(new Dimension(50, 35));
		this.buttonInside0.setPreferredSize(new Dimension(50, 35));
		this.buttonInside0.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent event){
	    		  buttonInside0.setSelected(!buttonInside0.isSelected());
	    	  }
	    });
		this.elevatorInsideButtons.add(this.buttonInside0);
		
		this.JPElevatorInside.add(this.elevatorInsideButtons);
		
		this.setLayout(new BorderLayout());
		this.getContentPane().add(this.JPElevatorInside, BorderLayout.EAST);
		this.getContentPane().add(this.toolBar, BorderLayout.NORTH);
		this.getContentPane().add(this.cabin, BorderLayout.CENTER);
		this.setVisible(true);
		
		
	}
}
