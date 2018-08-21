import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class Plane_Screen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Plane_Screen extends Main_Screen
{
    private JFrame frame;
    private JPanel panelButton;
    private JPanel panelMain;
    private JTextArea Recent;
    private JScrollPane scroll;
    Container contentPane;
    /**
     * Constructor for objects of class Plane_Screen
     */
    public Plane_Screen()
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
    }

    private void refresh()
    {
        //planeTest = Planes.peek(PlaneArray);
        //Recent.setText("Most Recent Planes Added: \nModel: " + PlaneTest.Model + "\nBrand: " + PlaneTest.Brand + "\nMSRP: " + PlaneTest.StandardPrice + "\nSold for: " + PlaneTest.SellingPrice +
        //"\nRevenue: " + PlaneTest.Commission + "\nPaint Color: " + PlaneTest.Color + "\nCondition: " + PlaneTest.Status + "\nOdometer: " + PlaneTest.Mileage + "\nYear: " + PlaneTest.Year);
    }

    private void showAllPlanes()
    {
        Planes.displayList();
    }

    private void CallNew()
    {
        Plane_Data create = new Plane_Data();
        hideScreen();
    }

    private void CallDelete()
    {
        String message = "The first object in this list will be deleted. Continue? This cannot be undone!";
        int selectedOption = JOptionPane.showConfirmDialog(null, message, "Confirm delete", JOptionPane.YES_NO_OPTION);
        if(selectedOption == JOptionPane.YES_OPTION)
        {
            //delete the option and open the array up for a new instance.
            Planes.remove();
        }
        refresh();
    }

    private void makeFrame()
    {
        frame = new JFrame("Final Project - Planes"); //creates a frame with the title
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
        JMenuItem addItem = new JMenuItem("Add Plane");
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
        JMenuItem viewItem = new JMenuItem("All Planes");
        viewMenu.add(viewItem);
        viewItem.addActionListener(new ActionListener()
            { 
                public void actionPerformed(ActionEvent ev)
                {
                    showAllPlanes();
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

        JButton Delete = new JButton("Delete Plane");
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

    private void makePanel()
    {
        panelButton = new JPanel();
        makeButtons();
        panelMain = new JPanel();
        makeLayout();
        contentPane.setLayout(new BorderLayout());
        panelMain.setLayout(new FlowLayout());
        panelButton.setLayout(new FlowLayout());
        contentPane.add(panelMain, BorderLayout.NORTH);
        contentPane.add(panelButton, BorderLayout.SOUTH);
    }

    private void makeLayout()
    {
        Recent = new JTextArea("Newly arrived vehicles will appear in the terminal", 20, 30);
        Recent.setEditable(false);
        Recent.setLineWrap(true);
        scroll = new JScrollPane(Recent);
        panelMain.add(scroll);
    }
}