import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class Main_Screen here.
 * Our Interface to interact with all the classes and other interfaces.
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main_Screen extends StartApp
{
    private JFrame frame;
    private JPanel panel;
    Container contentPane;
    
    /**
     * Constructor for objects of class Interface2
     */
    public Main_Screen() //constructor method. creates the Interface in memory.
    {
        makeFrame();
    }
    
    private void quit()
    {
        System.exit(0);
    }
    
    public void ContinueMain()
    {
        frame.show();
    }
    
    public void hideMain()
    {
        frame.hide();
    }
    
    private void CallBoat()
    { //creates a new window to interact with only the boat classes.
        Boat_Screen boatscreen = new Boat_Screen();
        hideMain();
    }
    
    private void CallMotor()
    {
        Motorcycle_Screen motorscreen = new Motorcycle_Screen();
        hideMain();
    }
    
    private void CallCar()
    { //creates a new window to interact with only the boat classes.
        Car_Screen carscreen = new Car_Screen();
        hideMain();
    }
    
    private void CallPlane()
    { //creates a new window to interact with only the boat classes.
        Plane_Screen planescreen = new Plane_Screen();
        hideMain();
    }
    //This method creates a frame
    private void makeFrame()
    {
        frame = new JFrame("Final Project"); //creates a frame with the title
        frame.setLocation(500, 90); //sets the popup location
        frame.setPreferredSize(new Dimension(500,500)); //sets the size of the JFrame.
        frame.setUndecorated(true);//removes the close button normally found on the top right of the window.
        contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        makeMenuBar(frame); //creates a menu bar on a specific frame.
        makePanel(); //makes a panel for the buttons.
        makeButtons(); //creates the buttons and adds them to the panel.
   
        
        JLabel label = new JLabel("Pick A Vehicle Category");
        contentPane.add(label);
        
        frame.pack();
        frame.show();
    }
    
    //this method creates a menuBar. actions by clicking on those items are handled by inner classes.
    private void makeMenuBar(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        //creates a file menu
        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu); //adds the section to the menu bar.
        
        //adds the Quit item in the file menu
        JMenuItem quitItem = new JMenuItem("Quit");
        fileMenu.add(quitItem);
        quitItem.addActionListener(new ActionListener()
            { //will quit the app
                public void actionPerformed(ActionEvent ev)
                {
                    quit();
                }
            }
            );
        
        //add another dropdown menu to the menu bar.
        JMenu vehicleMenu = new JMenu("Vehicle");
        menubar.add(vehicleMenu);
        
        //items in the container.
        JMenuItem carItem = new JMenuItem("Cars");
        vehicleMenu.add(carItem);
        carItem.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    CallCar();
                }
            }
            );
            
        JMenuItem motorItem = new JMenuItem("Motorcycles");
        vehicleMenu.add(motorItem);
        motorItem.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    CallMotor();
                }
            }
            );
            
        JMenuItem boatItem = new JMenuItem("Boats");
        vehicleMenu.add(boatItem);
        boatItem.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    CallBoat();
                }
            }
            );
            
        JMenuItem planeItem = new JMenuItem("Planes");
        vehicleMenu.add(planeItem);
        planeItem.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    CallPlane();
                }
            }
            );
    }
    
    private void makeButtons()
    { //adds all the buttons to the frame.
        JButton Cars = new JButton("Cars");
        Cars.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    CallCar();
                }
            }
            );
        
        JButton Motors = new JButton("MotorCycles");
        Motors.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    CallMotor();
                }
            }
            );
            
        JButton Boats = new JButton("Boats");
        Boats.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    CallBoat();
                }
            }
            );
        
        JButton Planes = new JButton("Planes");
        Planes.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    CallPlane();
                }
            }
            );
        
        panel.add(Cars);
        panel.add(Motors);
        panel.add(Boats);
        panel.add(Planes);
    }
    
    private void makePanel()
    {
        panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));
        contentPane.add(panel, BorderLayout.WEST);
    }
}
