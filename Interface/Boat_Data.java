import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.util.*;
/**
 * Name: Boat_Data.java
 * Part of Programming Project Final
 * @authors (Matthew Denholm) 
 * @version (11/7/17 - 11/30/17)
 */
public class Boat_Data extends Boat_Screen
{
    Container contentPane;
    private JPanel panelButton;
    private JPanel panelMain;
    private JFrame frame;
    //text fields are made available to the whole class.
    private JTextField model;
    private JTextField brand;
    private JTextField sell;
    private JTextField buy;
    private JTextField profit;
    private JTextField miles;
    private JTextField year;
    private JComboBox color;
    private JComboBox status;
    private JLabel ModelT = new JLabel("Name of Boat Model: ", SwingConstants.RIGHT);
    private JLabel BrandT = new JLabel("Brand of Boat: ", SwingConstants.RIGHT);
    private JLabel MSRPT = new JLabel("Manufacturer Standard Retail Price: ", SwingConstants.RIGHT);
    private JLabel SellT = new JLabel("Price Boat was Sold: ", SwingConstants.RIGHT);
    private JLabel ComT = new JLabel("Commission Amount (Profit): ", SwingConstants.RIGHT);
    private JLabel ColorT = new JLabel("Color of Boat: ", SwingConstants.RIGHT);
    private JLabel StatusT = new JLabel("Status of Boat: ", SwingConstants.RIGHT);
    private JLabel MilesT = new JLabel("Number of Miles Traveled so Far: ", SwingConstants.RIGHT);
    private JLabel YearT = new JLabel("Year of Boat Model: ", SwingConstants.RIGHT);
    /**
     * Constructor for objects of class Boat_Data
     */
    public Boat_Data(int index)
    {
        super.hideScreen();
        makeNewFrame(index);
    }

    public Boat_Data(String s, int index)
    {
        super.hideScreen();
        makeEditFrame(index);
    }

    private void ReturnToMain()
    {
        frame.dispose();
        super.ContinueScreen();
    }

    private void ResetFields()
    {
        model.setText("");
        brand.setText("");
        sell.setText("");
        buy.setText("");
        profit.setText("");
        miles.setText("");
        year.setText("");
        color.setSelectedIndex(0);
        status.setSelectedIndex(0);
    }

    private void ReloadFields(int index)
    {
        //BoatFiles.load(BoatFiles.getLineSize());
        model.setText(boatValues[index].getModel());
        brand.setText(boatValues[index].getBrand());
        sell.setText("" + boatValues[index].getMSRP());
        buy.setText("" + boatValues[index].getPrice());
        profit.setText("" + boatValues[index].getCom());
        miles.setText("" + boatValues[index].getMiles());
        year.setText("" + boatValues[index].getYear());
        color.setSelectedItem(boatValues[index].getColor());
        status.setSelectedItem(boatValues[index].getStatus());
    }

    public void SaveData(int index)
    {
        //creates a new object to add.
        boatTest = new Boats();
        try
        { //validate all data
            String modelvar = model.getText();
            String brandvar = brand.getText();
            double sellvar = Double.valueOf("" + sell.getText()).doubleValue();
            double buyvar = Double.valueOf("" + buy.getText()).doubleValue();
            double profitvar = Double.valueOf("" + profit.getText()).doubleValue();
            int mileage = Integer.parseInt("" + miles.getText());
            int yearvar = Integer.parseInt("" + year.getText());
            String paint = color.getSelectedItem().toString();
            String condition = status.getSelectedItem().toString();
            
            //add the object to the array;
            boatValues[index] = boatTest;
            
            //set all validated data. to added object.
            Boats.setModel(boatValues, index, modelvar);
            Boats.setBrand(boatValues, index, brandvar);
            Boats.setMSRP(boatValues, index, sellvar);
            Boats.setPrice(boatValues, index, buyvar);
            Boats.setCom(boatValues, index, profitvar);
            Boats.setMiles(boatValues, index, mileage);
            Boats.setYear(boatValues, index, yearvar);
            Boats.setColor(boatValues, index, paint);
            Boats.setStatus(boatValues, index, condition);

            Boats.insertionSort(boatValues, getLength()); //to sort it once added.
            ReturnToMain(); //close the window and return to the previous screen.
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error in input in 1 or multiple fields", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        //catch block here.
    }

    private int getLength()
    {
        int count = 0;
        for(int i=0; i<10; i++)
            if(boatValues[i] != null)
            {
                count++;
            }
            else
            {
                break;
            }
        return count;
    }

    private void makeNewFrame(int index)
    {
        frame = new JFrame("Final Project - Create A Boat"); //creates a frame with the title
        frame.setLocation(500, 90); //sets the popup location
        frame.setPreferredSize(new Dimension(500,500)); //sets the size of the JFrame.
        frame.setUndecorated(true);//removes the close button normally found on the top right of the window.
        contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        makeMenuBar(frame); //creates a menu bar on a specific frame.
        makePanel(index); //makes a panel for the buttons.

        //JLabel label = new JLabel("Label here");
        //contentPane.add(label);

        frame.pack();
        frame.show();
    }

    private void makeEditFrame(int index)
    {
        frame = new JFrame("Final Project - Edit A Boat"); //creates a frame with the title
        frame.setLocation(500, 90); //sets the popup location
        frame.setPreferredSize(new Dimension(500,500)); //sets the size of the JFrame.
        frame.setUndecorated(true);//removes the close button normally found on the top right of the window.
        contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        makeMenuBar(frame); //creates a menu bar on a specific frame.
        makePanelE(index); //makes a panel for the buttons.

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
    }

    private void makeTextBoxes()
    {
        model = new JTextField(30);
        model.addActionListener(new ActionListener()
            { 
                public void actionPerformed(ActionEvent ev)
                {
                    //
                }
            }
        );

        brand = new JTextField(30);
        brand.addActionListener(new ActionListener()
            { 
                public void actionPerformed(ActionEvent ev)
                {
                    //
                }
            }
        );

        sell = new JTextField(30);
        sell.addActionListener(new ActionListener()
            { 
                public void actionPerformed(ActionEvent ev)
                {
                    //
                }
            }
        );

        buy = new JTextField(30);
        buy.addActionListener(new ActionListener()
            { 
                public void actionPerformed(ActionEvent ev)
                {
                    //
                }
            }
        );

        profit = new JTextField(30);
        profit.addActionListener(new ActionListener()
            { 
                public void actionPerformed(ActionEvent ev)
                {
                    //
                }
            }
        );

        miles = new JTextField(30);
        miles.addActionListener(new ActionListener()
            { 
                public void actionPerformed(ActionEvent ev)
                {
                    //
                }
            }
        );

        year = new JTextField(30);
        year.addActionListener(new ActionListener()
            { 
                public void actionPerformed(ActionEvent ev)
                {
                    //
                }
            }
        );
    }

    private void makeComboBoxes()
    {
        color = new JComboBox();
        color.addItem("Select Color");
        color.addItem("Red");
        color.addItem("Blue");
        color.addItem("Green");
        color.addItem("Yellow");
        color.addItem("White");
        color.addItem("Black");
        color.addActionListener(new ActionListener()
            { 
                public void actionPerformed(ActionEvent ev)
                {
                    //
                }
            }
        );

        status = new JComboBox();
        status.addItem("Select Status");
        status.addItem("New");
        status.addItem("Used");
        status.addItem("Damaged");
        status.addItem("Unusable");
        status.addActionListener(new ActionListener()
            { 
                public void actionPerformed(ActionEvent ev)
                {
                    //
                }
            }
        );
    }

    private void makeButtons(int index) //new version of the form
    {
        JButton Cancel = new JButton("Cancel");
        Cancel.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    ReturnToMain();
                }
            }
        );

        JButton Reset = new JButton("Clear");
        Reset.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    ResetFields();
                }
            }
        );

        JButton Save = new JButton("Save");
        Save.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    SaveData(index);
                }
            }
        );

        panelButton.add(Cancel);
        panelButton.add(Reset);
        panelButton.add(Save);
    }

    private void makeButtonsE(int index) //edit version of the form
    {
        JButton Cancel = new JButton("Cancel");
        Cancel.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    ReturnToMain();
                }
            }
        );

        JButton Reset = new JButton("Reload");
        Reset.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    ReloadFields(index);
                }
            }
        );

        JButton Save = new JButton("Save");
        Save.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    SaveData(index);
                }
            }
        );

        panelButton.add(Cancel);
        panelButton.add(Reset);
        panelButton.add(Save);
    }

    private void makePanel(int index)
    {
        panelMain = new JPanel();
        makeTextBoxes();
        makeComboBoxes();
        panelButton = new JPanel();
        makeButtons(index);
        addItems();
        contentPane.setLayout(new BorderLayout());
        panelMain.setLayout(new GridLayout(9,2));
        panelButton.setLayout(new FlowLayout());
        contentPane.add(panelMain, BorderLayout.CENTER);
        contentPane.add(panelButton, BorderLayout.SOUTH);
    }

    private void makePanelE(int index) //edit version of the form
    {
        panelMain = new JPanel();       
        makeTextBoxes();
        makeComboBoxes();
        panelButton = new JPanel();
        makeButtonsE(index);
        addItems();
        contentPane.setLayout(new BorderLayout());
        panelMain.setLayout(new GridLayout(9,2));
        panelButton.setLayout(new FlowLayout());
        contentPane.add(panelMain, BorderLayout.CENTER);
        contentPane.add(panelButton, BorderLayout.SOUTH);
        ReloadFields(index);
    }

    private void addItems()
    {
        panelMain.add(ModelT);
        panelMain.add(model);
        panelMain.add(BrandT);
        panelMain.add(brand);
        panelMain.add(MSRPT);
        panelMain.add(sell);
        panelMain.add(SellT);
        panelMain.add(buy);
        panelMain.add(ComT);
        panelMain.add(profit);
        panelMain.add(MilesT);
        panelMain.add(miles);
        panelMain.add(YearT);
        panelMain.add(year);
        panelMain.add(ColorT);
        panelMain.add(color);
        panelMain.add(StatusT);
        panelMain.add(status);
    }
}
