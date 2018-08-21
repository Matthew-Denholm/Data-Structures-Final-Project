import java.util.*;
import java.io.*;
/**
 * Name: Boats.java
 * Part of Programming Project Final
 * @authors (Matthew Denholm, Anthony Marquez, Devon Vierthaler) 
 * @version (11/7/17 - 11/30/17)
 */
public class Boats
{
    String Model;
    String Brand;
    double SellingPrice;
    double StandardPrice;
    double Commission; //seller profit
    String Color;
    String Status; //new or used
    int Mileage;
    int Year;
    public Boats(String Brand, String Model, double SellingPrice, double StandardPrice, double Commission, String Color, String Status, int Mileage, int Year)
    {
        this.Model = Model;
        this.Brand = Brand;
        this.SellingPrice = SellingPrice;
        this.StandardPrice = StandardPrice;
        this.Commission = Commission;
        this.Color = Color;
        this.Status = Status;
        this.Mileage = Mileage;
        this.Year = Year;
        //System.out.println(BoatsApp.boatValues[0].Model);
    }
    
    public Boats()
    {
        Model = null;
        Brand = null;
        SellingPrice = 0;
        StandardPrice = 0;
        Commission = 0;
        Color = null;
        Status = null;
        Mileage = 0;
        Year = 0;
    }

    public static void insertionSort(Boats[] Values, int length) //sorting by price
    {
        int out, in;
        Boats tempa[] = new Boats[length]; //create a copy to use for sorting
        for (int i = 0; i < length; i++)
        {
            tempa[i] = Values[i]; //assign copy
        }
        //display(tempa);
        for(out = 1; out < length; out++)
        {
            double temp = tempa[out].getMSRP(); //sorting by price, set price to a variable.
            in = out;
            while(in > 0 && tempa[in-1].getMSRP() >= temp) //while instances have prices greater than that being compared
            {
                tempa[in] = tempa[in-1]; //switch locations
                --in;
            }
            tempa[in] = Values[out]; //assign the value being compared to the temp array.
            for (int i = 0; i < length; i++)
            {
                Values[i] = tempa[i]; //make the arrays the same again to compare again (if needed).
            }
        }
    }

    public static void display(Boats[] Values) //displays order of queue
    {
        System.out.println("");
        for(int i=0; i<Values.length; i++)
            if(Values[i] != null)
            {
                System.out.print("| Item "+(i+1)+": "+ Values[i].getModel() + " : "+ Values[i].getBrand() + " : "+ Values[i].getMSRP());
                System.out.print(" : "+ Values[i].getPrice() + " : "+ Values[i].getCom() + " : "+ Values[i].getColor() + " : "+ Values[i].getStatus());
                System.out.print(" : "+ Values[i].getMiles() + " : "+ Values[i].getYear());
            }
            else
                System.out.print("| Item "+(i+1)+" empty.");
        System.out.print("|");
        System.out.println("");
    }

    public static void setModel(Boats[] Values, int item, String Input) //array, index, whats changing
    {
        Values[item].Model = Input;
    }

    public static void setBrand(Boats[] Values, int item, String Input)
    {
        Values[item].Brand = Input;
    }    

    public static void setMSRP(Boats[] Values, int item, double Input)
    {
        Values[item].StandardPrice = Input;
    }    

    public static void setPrice(Boats[] Values, int item, double Input)
    {
        Values[item].SellingPrice = Input;
    }    

    public static void setCom(Boats[] Values, int item, double Input)
    {
        Values[item].Commission = Input;
    }    

    public static void setColor(Boats[] Values, int item, String Input)
    {
        Values[item].Color = Input;
    }    

    public static void setStatus(Boats[] Values, int item, String Input)
    {
        Values[item].Status = Input;
    }    

    public static void setMiles(Boats[] Values, int item, int Input)
    {
        Values[item].Mileage = Input;
    }    

    public static void setYear(Boats[] Values, int item, int Input)
    {
        Values[item].Year = Input;
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
}
