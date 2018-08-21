import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class Motorcycle_Data here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Motorcycle_Data extends Motorcycle_Screen
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
    private JLabel ModelT = new JLabel("Name of Motorcycle Model: ", SwingConstants.RIGHT);
    private JLabel BrandT = new JLabel("Brand of Motorcycle: ", SwingConstants.RIGHT);
    private JLabel MSRPT = new JLabel("Manufacturer Standard Retail Price: ", SwingConstants.RIGHT);
    private JLabel SellT = new JLabel("Price Motorcycle was Sold: ", SwingConstants.RIGHT);
    private JLabel ComT = new JLabel("Commission Amount (Profit): ", SwingConstants.RIGHT);
    private JLabel ColorT = new JLabel("Color of Motorcycle: ", SwingConstants.RIGHT);
    private JLabel StatusT = new JLabel("Status of Motorcycle: ", SwingConstants.RIGHT);
    private JLabel MilesT = new JLabel("Number of Miles Traveled so Far: ", SwingConstants.RIGHT);
    private JLabel YearT = new JLabel("Year of Motorcycle Model: ", SwingConstants.RIGHT);
    /**
     * Constructor for objects of class Motorcycle_Data
     */
    public Motorcycle_Data()
    {
        super.hideScreen();
        makeNewFrame();
    }
    
    public Motorcycle_Data(String s, int index)
    {
        super.hideScreen();
        //makeEditFrame();
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
    
    private void ReloadFields()
    {
        //MotorcycleFiles.load(MotorcycleFiles.getLineSize());
        //model.setText(MotorArray[index].getModel());
        //brand.setText(MotorArray[index].getBrand());
        //sell.setText("" + MotorArray[index].getMSRP());
        //buy.setText("" + MotorArray[index].getPrice());
        //profit.setText("" + MotorArray[index].getCom());
        //miles.setText("" + MotorArray[index].getMiles());
        //year.setText("" + MotorArray[index].getYear());
        //color.setSelectedItem(MotorArray[index].getColor());
        //status.setSelectedItem(MotorArray[index].getStatus());
    }
    
    public void SaveData()
    {
        //create a new instance.
        motorTest = new Motorcycle();
        try
        {
            //get all the user input and set it to variables
            String modelvar = model.getText();
            String brandvar = brand.getText();
            double sellvar = Double.parseDouble(sell.getText());
            double buyvar = Double.parseDouble(buy.getText());
            double profitvar = Double.parseDouble(profit.getText());
            int mileage = Integer.parseInt(miles.getText());
            int yearvar = Integer.parseInt(year.getText());
            String paint = color.getSelectedItem().toString();
            String condition = status.getSelectedItem().toString();
            
            //if everything is valid add the instance to the queue.
            Motorcycle.insert(motorArray, motorTest);
            
            //sets the current object's fields.
            Motorcycle.setModel(motorArray, modelvar);
            Motorcycle.setBrand(motorArray, brandvar);
            Motorcycle.setMSRP(motorArray, sellvar);
            Motorcycle.setPrice(motorArray, buyvar);
            Motorcycle.setCom(motorArray, profitvar);
            Motorcycle.setMiles(motorArray, mileage);
            Motorcycle.setYear(motorArray, yearvar);
            Motorcycle.setColor(motorArray, paint);
            Motorcycle.setStatus(motorArray, condition);
    
            ReturnToMain(); //close the form, and return to the previous screen.
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error in input in 1 or multiple fields", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void makeNewFrame()
    {
        frame = new JFrame("Final Project - Create A Motorcycle"); //creates a frame with the title
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
    
    private void makeButtons() //new version of the form
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
                    SaveData();
                }
            }
            );
            
        panelButton.add(Cancel);
        panelButton.add(Reset);
        panelButton.add(Save);
    }
    
    private void makeButtonsE() //edit version of the form
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
                    ReloadFields();
                }
            }
            );
            
        JButton Save = new JButton("Save");
        Save.addActionListener(new ActionListener()
            { //
                public void actionPerformed(ActionEvent ev)
                {
                    SaveData();
                }
            }
            );
            
        panelButton.add(Cancel);
        panelButton.add(Reset);
        panelButton.add(Save);
    }
    
    private void makePanel()
    {
        panelMain = new JPanel();
        makeTextBoxes();
        makeComboBoxes();
        panelButton = new JPanel();
        makeButtons();
        addItems();
        contentPane.setLayout(new BorderLayout());
        panelMain.setLayout(new GridLayout(9,2));
        panelButton.setLayout(new FlowLayout());
        contentPane.add(panelMain, BorderLayout.CENTER);
        contentPane.add(panelButton, BorderLayout.SOUTH);
    }
    
    private void makePanelE() //edit version of the form
    {
        panelMain = new JPanel();       
        makeTextBoxes();
        makeComboBoxes();
        panelButton = new JPanel();
        makeButtonsE();
        addItems();
        contentPane.setLayout(new BorderLayout());
        panelMain.setLayout(new GridLayout(9,2));
        panelButton.setLayout(new FlowLayout());
        contentPane.add(panelMain, BorderLayout.CENTER);
        contentPane.add(panelButton, BorderLayout.SOUTH);
        ReloadFields();
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
