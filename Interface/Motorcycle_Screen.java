import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class Motorcycle_Screen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Motorcycle_Screen extends Main_Screen
{
    private JFrame frame;
    private JPanel panelButton;
    private JPanel panelMain;
    private JTextArea Recent;
    private JScrollPane scroll;
    Container contentPane;
    /**
     * Constructor for objects of class Motorcycle_Screen
     */
    public Motorcycle_Screen()
    {
        super.hideMain();
        makeFrame();
    }
    
    private void ReturnToMain()
    {
        frame.dispose();
        super.ContinueMain();
    }

    public void hideScreen()
    {
        frame.hide();
    }
    
    public void ContinueScreen()
    {
        refresh();
        frame.show();
    }
    
    private void refresh()
    {
        motorTest = Motorcycle.peekFront(motorArray);
        Recent.setText("Most Recent Motorcycle Added: \nModel: " + motorTest.Model + "\nBrand: " + motorTest.Brand + "\nMSRP: " + motorTest.StandardPrice + "\nSold for: " + motorTest.SellingPrice +
            "\nRevenue: " + motorTest.Commission + "\nPaint Color: " + motorTest.Color + "\nCondition: " + motorTest.Status + "\nOdometer: " + motorTest.Mileage + "\nYear: " + motorTest.Year);
    }
    
    private void showAllMotors()
    {
        Recent.setText("");
        for (int i = 0; i < 10; i++)
        {
            motorTest = Motorcycle.display(motorArray);
            if (motorTest == null)
            {
                Recent.append("Lot " + (i+1) + " is empty.\n");
            }
            else
            {
                Recent.append("Lot " + (i+1) + ": \nModel: " + motorTest.Model + "\nBrand: " + motorTest.Brand + "\nMSRP: " + motorTest.StandardPrice + "\nSold for: " + motorTest.SellingPrice +
                "\nRevenue: " + motorTest.Commission + "\nPaint Color: " + motorTest.Color + "\nCondition: " + motorTest.Status + "\nOdometer: " + motorTest.Mileage + "\nYear: " + motorTest.Year + "\n\n");
            }
        }
    }
    
    private void CallNew()
    {
        if (Motorcycle.isFull())
        {
            String message = "The lot is full. You need to sell/remove one before you can add more.";
            JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            Motorcycle_Data create = new Motorcycle_Data();
            hideScreen();
        }
    }
    
    private void CallDelete()
    {
        int front = Motorcycle.getFront();
        String message = "Are you sure you want to delete this object? This cannot be undone!";
        if (motorArray[front] == null) //if there isn't anything on the lot.
        {
            message = "No Objects to delete!";
            JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            int selectedOption = JOptionPane.showConfirmDialog(null, message, "Confirm delete", JOptionPane.YES_NO_OPTION);
            if(selectedOption == JOptionPane.YES_OPTION)
            {
                //delete the option and open the array up for a new instance.
                Motorcycle.remove(motorArray);
            }
        }
        refresh();
    }
    
    private void makeFrame()
    {
        frame = new JFrame("Final Project - Motorcycles"); //creates a frame with the title
        frame.setLocation(500, 90); //sets the popup location
        frame.setPreferredSize(new Dimension(500,500)); //sets the size of the JFrame.
        frame.setUndecorated(true);//removes the close button normally found on the top right of the window.
        contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        makeMenuBar(frame); //creates a menu bar on a specific frame.
        makePanel(); //makes a panel for the buttons.
   
        
        //JLabel label = new JLabel("Label here");
        //contentPane.add(label);
        
        frame.pack();
        frame.show();
    }
    
    private void makeMenuBar(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        //creates a file menu
        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu); //adds the section to the menu bar.
        
        //adds the Return item in the file menu
        JMenuItem cancelItem = new JMenuItem("Cancel");
        fileMenu.add(cancelItem);
        cancelItem.addActionListener(new ActionListener()
            { //will quit the app
                public void actionPerformed(ActionEvent ev)
                {
                    ReturnToMain();
                }
            }
            );
        
        //adds the Return item in the file menu
        JMenuItem addItem = new JMenuItem("Add Vehicle");
        fileMenu.add(addItem);
        addItem.addActionListener(new ActionListener()
            { //will add a new Vehicle to the array
                public void actionPerformed(ActionEvent ev)
                {
                    CallNew();
                }
            }
            );
            
        
        //add another dropdown menu to the menu bar.
        JMenu viewMenu = new JMenu("View");
        menubar.add(viewMenu);
        
        //items in the container.
        JMenuItem viewItem = new JMenuItem("All Vehicles");
        viewMenu.add(viewItem);
        viewItem.addActionListener(new ActionListener()
            { 
                public void actionPerformed(ActionEvent ev)
                {
                    showAllMotors();
                }
            }
            );
    }
    
    private void makeButtons()
    {
        JButton Cancel = new JButton("Return");
        Cancel.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    ReturnToMain();
                }
            }
            );
            
        JButton New = new JButton("New");
        New.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    CallNew();
                }
            }
            );
            
        JButton Delete = new JButton("Delete Motorcycle");
        Delete.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    CallDelete();
                }
            }
            );
        
        panelButton.add(Cancel);
        panelButton.add(New);
        //panelButton.add(Edit);
        panelButton.add(Delete);
    }
    
    private void makeLayout()
    {
        Recent = new JTextArea("Newly arrived vehicles will appear here", 20, 30);
        Recent.setEditable(false);
        Recent.setLineWrap(true);
        scroll = new JScrollPane(Recent);
        panelMain.add(scroll);
    }
    
    private void makePanel()
    {
        panelButton = new JPanel();
        makeButtons();
        panelMain = new JPanel();
        makeLayout();
        contentPane.setLayout(new BorderLayout());
        panelButton.setLayout(new FlowLayout());
        panelMain.setLayout(new FlowLayout());
        contentPane.add(panelMain, BorderLayout.NORTH);
        contentPane.add(panelButton, BorderLayout.SOUTH);
    }
}
