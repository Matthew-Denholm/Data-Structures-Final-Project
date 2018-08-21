
/**
 * Name: doublyLinked.java
 * demonstrates doubly-linked lists.
 * @author (Matthew Denholm, Anthony Marquez, Devon Vierthaler)
 * @version (10/17/17)
 */
class Link
{
    public Planes dData;
    public Link next;
    public Link previous;
    
    public Link(Planes plane) //constructor
    {
        dData = plane;
    }
    
    public void displayLink() //display this link
    {
        System.out.print("Model: " + dData.Model + "\nBrand: " + dData.Brand + "\nMSRP: " + dData.StandardPrice + "\nSold for: " + dData.SellingPrice +
        "\nRevenue: " + dData.Commission + "\nPaint Color: " + dData.Color + "\nCondition: " + dData.Status + "\nOdometer: " + dData.Mileage + "\nYear: " + dData.Year + "\n\n");
    }
}
