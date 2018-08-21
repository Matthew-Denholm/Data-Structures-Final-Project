import java.util.*;
/**
 * Name: SortedList.java
 * Exercise 5.1
 * Note: This exercise is basically Listing 5.6. The priority queue removes the smallest key value.
 * @author (Matthew Denholm, Anthony Marquez, Devon Vierthaler)
 * @version (10/17/17)
 */
public class Planes
{
    private static Link first = null; //ref to first item on list
    
    //Variables
    String Model;
    String Brand;
    double SellingPrice;
    double StandardPrice;
    double Commission; //seller profit
    String Color;
    String Status; //new or used
    int Mileage;
    int Year;
    int Engines;
    
    //Input
    Scanner keyboard = new Scanner(System.in);
    public Planes() //constructor method
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
        Engines = 0;
    }
    
    public boolean isEmpty() //returns true if the list is empty
    {
        return first==null;
    }
    
    public static void inserts(Planes plane) //inserts the plane in sorted order
    {
        Link newLink = new Link(plane);
        Link previous = null;
        Link current = first;
        
        while(current != null && plane.Commission > current.dData.Commission)
        {
            previous = current;
            current = current.next;
        }
        if (previous==null)
        {
            first = newLink;
        }else{
            previous.next = newLink;
        }
        newLink.next = current;
    }
    public static Link remove() //removes the first key (First key in the list is priority. Hence the priority Queue).
    {
        Link temp = first;
        first = first.next;
        return temp;
    }
    
    public static void displayList()
    {   
        System.out.print("List (first-->last): ");
        Link current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
      }
    //Change Variable Methods
    public static void setModel(Planes plane, String Input)
    {
        plane.Model = Input;
    }
    public static void setBrand(Planes plane, String Input)
    {
        plane.Brand = Input;
    }    
    public static void setMSRP(Planes plane, double Input)
    {
        plane.StandardPrice = Input;
    }    
    public static void setPrice(Planes plane, double Input)
    {
        plane.SellingPrice = Input;
    }    
    public static void setCom(Planes plane, double Input)
    {
        plane.Commission = Input;
    }    
    public static void setColor(Planes plane, String Input)
    {
        plane.Color = Input;
    }    
    public static void setStatus(Planes plane, String Input)
    {
        plane.Status = Input;
    }    
    public static void setMiles(Planes plane, int Input)
    {
        plane.Mileage = Input;
    }    
    public static void setYear(Planes plane, int Input)
    {
        plane.Year = Input;
    }    

    public void setEngines(Planes plane, int Input)
    {
        Engines  = Input;
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
    public int getEngines()
    {
        return Engines;
    }
}
