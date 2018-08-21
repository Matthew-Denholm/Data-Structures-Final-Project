import java.util.*;
/**
 * Name:
 * Part of Programming Project Final
 * @authors (Matthew Denholm, Anthony Marquez, Devon Vierthaler) 
 * @version (11/7/17 - 11/30/17)
 */
public class Cars
{
    //Variables
    static String Model;
    static String Brand;
    static double SellingPrice;
    static double StandardPrice;
    static double Commission; //seller profit
    static String Color;
    static String Status; //new or used
    static int Mileage;
    static int Year;
    static int wheels;
    
    //Storage Variables
    private static int maxSize;
    public static int top;
    public static int bottom;
    public static int show;
    public static boolean hit;
    //Input
    //Scanner keyboard = new Scanner(System.in);
    public Cars() //constructor method
    {
        Model = null;
        Brand = null;
        SellingPrice = 0;
        StandardPrice = 0;
        Commission = 0;
        Color = null;
        Status = null;
        Mileage = 0;
        Year = 0000;
    }
    
    public static void Cars(int s) //Initializer method
    {
        maxSize = s;
        //CArray = new Cars[maxSize];
        top = -1;
        bottom = -1;
        show = maxSize-1;
        hit = false;
    }
    
    public static void pushTop(Cars[] array, Cars car)
    {
        if(!isFull())
        {
            array[++top] = car;  //put item on top of the stack
        }
    }
    
    public static Cars popTop(Cars[] array)
    {
        if(!isEmpty())
        {
            return array[top--];   //take item from top of the stack
        }
        else
        {
            return null; //default value to return if empty
        }
    }
    
    public static void pushBot(Cars[] array, Cars j)
    {
        if(!isFull())
        {
            top++;
            for(int i = top; i > 0; i--)
            {
                Cars temp = array[i];
                array[i] = array[i-1];
                array[i-1] = temp;
            }
            array[0] = j;  //put item on bottom of the stack
        }
    }
    
    public static Cars popBot(Cars[] array)
    {
        if(!isEmpty())
        {
            Cars bottom = array[0];
            for(int i = 1; i <= top; i++)
            {
                array[i-1] = array[i];
            }
            top--;
            return bottom;  //take item from bottom of the stack
        }
        else
        {
            return null; //default value to return if empty
        }
    }
    
    public static Cars peek(Cars[] array)
    { //returns the object on top
        return array[top];
    }
    
    public static boolean isFull()
    {
        return (top == maxSize-1);
    }
    
    public static boolean isEmpty()
    {
        return (top == -1);
    }
    
    
    public static void setModel(Cars[] car, String Input)
    {
        car[top].Model = Input;
    }
    public static void setBrand(Cars[] car, String Input)
    {
        car[top].Brand = Input;
    }    
    public static void setMSRP(Cars[] car, double Input)
    {
        car[top].StandardPrice = Input;
    }    
    public static void setPrice(Cars[] car, double Input)
    {
        car[top].SellingPrice = Input;
    }    
    public static void setCom(Cars[] car, double Input)
    {
        car[top].Commission = Input;
    }    
    public static void setColor(Cars[] car, String Input)
    {
        car[top].Color = Input;
    }    
    public static void setStatus(Cars[] car, String Input)
    {
        car[top].Status = Input;
    }    
    public static void setMiles(Cars[] car, int Input)
    {
        car[top].Mileage = Input;
    }    
    public static void setYear(Cars[] car, int Input)
    {
        car[top].Year = Input;
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
    
    public static int getShow()
    {
        return show;
    }
    
    //Display Method
    public static Cars display(Cars[] array) //displays order of queue
    {
        int r = show;
        show--;
        if (show < 0)
        {
            show = maxSize-1;
            hit = true;
        }
        return array[r];
    }
    
    public static boolean getHit()
    {
        if (hit == true)
        {
            hit = false;
            return true;
        }
        else
        {
            return false;
        }
    }
    public static int getTop()
    { //returns the top position
        return top;
    }
    
    public static void displaya(Cars[] array) //displays order of queue
    {
        System.out.println("");
        for(int i=0; i<maxSize; i++)
            if(array[i] != null)
                System.out.print("| Item "+(i+1)+": "+array[i]);
            else
                System.out.print("| Item "+(i+1)+" empty.");
        System.out.print("|");
        System.out.println("");
    }
}
