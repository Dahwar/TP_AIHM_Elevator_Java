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
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class Window extends JFrame{
	
	private JPanel cabin;
	
	// JMenuBar
	private JMenuBar JMenuBar = new JMenuBar();
	private JMenu JMenuFiles = new JMenu("Files");
	private JMenuItem itemFiles_Quit = new JMenuItem("Quit");
	
	private JToolBar toolBar = new JToolBar();
	private Box elevatorInsideButtons = Box.createVerticalBox();
	private Box elevatorToolBarButtons = Box.createHorizontalBox();
	private JPanel JPElevatorInside = new JPanel();
	
	// Import Images
	private ImageIcon imgButton0 = new ImageIcon("images/Zero.png");
	private ImageIcon imgButton1 = new ImageIcon("images/One.png");
	private ImageIcon imgButton2 = new ImageIcon("images/Two.png");
	private ImageIcon imgButton0Selected = new ImageIcon("images/ZeroSelected.png");
	private ImageIcon imgButton1Selected = new ImageIcon("images/OneSelected.png");
	private ImageIcon imgButton2Selected = new ImageIcon("images/TwoSelected.png");
	
	// Button creation
	private JToggleButton buttonInside0 = new JToggleButton(imgButton0);
	private JToggleButton buttonInside1 = new JToggleButton(imgButton1);
	private JToggleButton buttonInside2 = new JToggleButton(imgButton2);
	private JToggleButton buttonToolBar0 = new JToggleButton(imgButton0);
	private JToggleButton buttonToolBar1 = new JToggleButton(imgButton1);
	private JToggleButton buttonToolBar2 = new JToggleButton(imgButton2);
	
    // Elevator Button Model
	private ElevatorButtonModel modelButton0 = new ElevatorButtonModel();
	private ElevatorButtonModel modelButton1 = new ElevatorButtonModel();
	private ElevatorButtonModel modelButton2 = new ElevatorButtonModel();
    
    // HashMap of buttons
	private HashMap<Integer, JToggleButton> HMButtons = new HashMap<>();
    
	// Label
	private JLabel JLelevator = new JLabel("Elevator");
	private JLabel JLcabin = new JLabel("Cabin");
	
	// Level Screen
	private JTextField cabinLevel = new JTextField("0");
	
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
		
		// --
		this.cabinLevel.setFocusable(false);
		this.elevatorInsideButtons.add(Box.createRigidArea(new Dimension(0,10)));
		this.elevatorInsideButtons.add(this.JLcabin);
		this.elevatorInsideButtons.add(Box.createRigidArea(new Dimension(0,10)));
		this.elevatorInsideButtons.add(this.cabinLevel);
		this.elevatorInsideButtons.add(Box.createRigidArea(new Dimension(0,10)));
		
		// Configure Inside Button
		this.buttonInside2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.buttonInside2.setFocusable(false);
		this.buttonInside2.setMaximumSize(new Dimension(50, 35));
		this.buttonInside2.setMinimumSize(new Dimension(50, 35));
		this.buttonInside2.setPreferredSize(new Dimension(50, 35));
		this.buttonInside2.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent event){
	    		  ((Cabin) cabin).addFloorToList(2);
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
	    		  ((Cabin) cabin).addFloorToList(1);
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
	    		  ((Cabin) cabin).addFloorToList(0);
	    	  }
	    });
		this.elevatorInsideButtons.add(this.buttonInside0);
		
		this.HMButtons.put(0, this.buttonInside0);
		this.HMButtons.put(1, this.buttonInside1);
		this.HMButtons.put(2, this.buttonInside2);
		
		this.cabin = new Cabin(this.HMButtons, this);
		this.cabin.add(this.JLelevator);
		
		this.JPElevatorInside.add(this.elevatorInsideButtons);
		
		this.setLayout(new BorderLayout());
		this.getContentPane().add(this.JPElevatorInside, BorderLayout.EAST);
		this.getContentPane().add(this.toolBar, BorderLayout.NORTH);
		this.getContentPane().add(this.cabin, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	public void setCabinLevel(int level){
		this.cabinLevel.setText(String.valueOf(level));
	}
}
