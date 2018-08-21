import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Name: Boat_Screen.java
 * Part of Programming Project Final
 * @authors (Matthew Denholm) 
 * @version (11/7/17 - 11/30/17)
 */
public class Boat_Screen extends Main_Screen
{
    private JFrame frame;
    private JPanel panelChk;
    private JPanel panelButton;
    private JComboBox Objects;
    Container contentPane;
    /**
     * Constructor for objects of class Boat_Screen
     */
    public Boat_Screen()
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
        frame.show();
        refresh();
    }
    
    private void CallEdit()
    {
        int index = Objects.getSelectedIndex();
        String message = "No Objects available to Edit or None Selected.";
        if (index < 0)
        {
            JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            Boat_Data edit = new Boat_Data("edit", index); //the string is never used, but is needed to determine a different window
            hideScreen();
        }
    }
    
    private void CallNew()
    {
        int i = 0;
        int index = 0;
        while (i < 10)
        {
            if (boatValues[i] == null)
            {
                index = i;
                break;
            }
            i++;
        }
        if (i >= 10)
        {
            String message = "The lot is full. You need to sell/remove one before you can add more.";
            JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            Boat_Data create = new Boat_Data(index);
            hideScreen();
        }
    }
    
    private void CallDelete()
    {
        int index = Objects.getSelectedIndex();
        String message = "Are you sure you want to delete this object? This cannot be undone!";
        if (index < 0)
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
                while (index < 9)
                {
                    boatValues[index] = boatValues[index+1];
                    index++;
                }
                boatValues[index] = null;
            }
            refresh();
        }
    }
    
    private void makeFrame()
    {
        frame = new JFrame("Final Project - Boats"); //creates a frame with the title
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
                    Boats.display(boatValues);
                }
            }
            );
    }
    
    private void refresh()
    {
        Objects.removeAllItems();
        for(int i=0; i<10; i++)
            if(boatValues[i] != null)
            {
                Objects.addItem("Model: " + boatValues[i].Model.toString());
            }
    }
    
    private void showObjects()
    {
        JLabel Instruct = new JLabel("Select a model to edit, or add a new one.", SwingConstants.CENTER);
        Objects = new JComboBox();
        for(int i=0; i<10; i++)
            if(boatValues[i] != null)
            {
                Objects.addItem("Model: " + boatValues[i].Model.toString());
            }
        Objects.addActionListener(new ActionListener()
            { 
                public void actionPerformed(ActionEvent ev)
                {
                    //
                }
            }
            );
            
        panelChk.add(Instruct);
        panelChk.add(Objects);
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
            
        JButton Edit = new JButton("Edit Selected");
        Edit.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    CallEdit();
                }
            }
            );
            
        JButton Delete = new JButton("Delete Boat");
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
        panelButton.add(Edit);
        panelButton.add(Delete);
    }
    
    private void makePanel()
    {
        panelChk = new JPanel();
        showObjects();
        panelButton = new JPanel();
        makeButtons();
        contentPane.setLayout(new BorderLayout());
        panelChk.setLayout(new FlowLayout());
        panelButton.setLayout(new FlowLayout());
        contentPane.add(panelChk, BorderLayout.CENTER);
        contentPane.add(panelButton, BorderLayout.SOUTH);
    }
}
