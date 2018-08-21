import java.util.*;
/**
 * Write a description of class Queue here.
 * 
 * @author (Devon, Anthony, Matthew) 
 * @version (11/7/17)
 */
public class Motorcycle
{
    public static int maxSize; //max size of an array
    private static String[] strArray;
    private static int front;
    private static int rear;
    private static int nItems; // #of items
    private static int show;
    //static Scanner keyboard = new Scanner(System.in);
    static String Brand; //replacing "make"
    static String Model;//replacing "make"
    static double StandardPrice; // double//listed price
    static double SellingPrice; // double//sold price
    static double Commission; //double
    static String Color; // String//
    static int Mileage; //int
    static int Year; // int

    static String Status; //boolean 
    
    public Motorcycle()
    {
        //String Name = "none"; //string //pontetc
        Model = null;//replacing "make"
        Brand = null; //replacing "make"
        StandardPrice = 0; // double//listed price
        SellingPrice = 0; // double//sold price
        Commission = 0; //double
        Color = null; // String//
        Status = null; //boolean 
        Mileage = 0; //int
        Year = 0; // int
    }
    
    public static void Motorcycle(int s) //constructor
    {
        maxSize = s;
        front = 0;
        rear = -1;
        nItems = 0;
        show = front;
    }
    //Change Variable Methods
    public static void setModel(Motorcycle[] motor, String Input)
    {
        motor[front].Model = Input;
    }
    public static void setBrand(Motorcycle[] motor, String Input)
    {
        motor[front].Brand = Input;
    }    
    public static void setMSRP(Motorcycle[] motor, double Input)
    {
        motor[front].StandardPrice = Input;
    }    
    public static void setPrice(Motorcycle[] motor, double Input)
    {
        motor[front].SellingPrice = Input;
    }    
    public static void setCom(Motorcycle[] motor, double Input)
    {
        motor[front].Commission = Input;
    }    
    public static void setColor(Motorcycle[] motor, String Input)
    {
        motor[front].Color = Input;
    }    
    public static void setStatus(Motorcycle[] motor, String Input)
    {
        motor[front].Status = Input;
    }    
    public static void setMiles(Motorcycle[] motor, int Input)
    {
        motor[front].Mileage = Input;
    }    
    public static void setYear(Motorcycle[] motor, int Input)
    {
        motor[front].Year = Input;
    }    
    
    //Return methods
    public String getModel()
    {
        return Model;
    }

    public String getBrand()
    {
        return Brand;
    }    

    public double getMSRP()
    {
        return StandardPrice;
    }    

    public double getPrice()
    {
        return SellingPrice;
    }    

    public double getCom()
    {
        return Commission;
    }    

    public String getColor()
    {
        return Color;
    }    

    public String getStatus()
    {
        return Status;
    }    

    public int getMiles()
    {
        return Mileage;
    }    

    public int getYear()
    {
        return Year;
    }

    public int getMax()
    {
        return nItems;
    }

    public static void insert(Motorcycle[] array, Motorcycle motor) //put item at the rear of the queue
    {
        System.out.println(motor.Model);
        System.out.println(rear);
        if(rear == maxSize-1) //deal with wrap
            rear = -1;
        array[++rear] = motor; //why is motor set to default constructor when inserted?
        System.out.println(rear);
        motor = array[rear];
        System.out.println(motor.Model);
        nItems++;
    }
    
    public static Motorcycle remove(Motorcycle[] array)
    {
        array[front] = new Motorcycle();
        front++;
        show = front;
        if(front == maxSize)
        {
            front = 0;
        }
        nItems--;
        return array[front];
    }

    public static Motorcycle peekFront(Motorcycle[] array) //peek at the front of the queue
    {
        return array[front];
    }
    
    public static boolean isEmpty() //true if queue is empty 
    {
        return (nItems == 0);
    }

    public static boolean isFull() //true if queue is full
    {
        return (nItems == maxSize);
    }

    public int size() //number of items in the queue
    {
        return nItems;
    }
    
    public static Motorcycle display(Motorcycle[] array) //displays order of queue
    {
        int r = show;
        show++;
        if (show == maxSize)
            show = 0;
        return array[r];
    }
    
    public static int getFront()
    {
        return front;
    }
}
