
/**
 * Write a description of class StartApp here.
 * this class starts the application. any variables that are not recreated at any point are stored here.
 * @author (your name)
 * @version (a version number or a date)
 */
public class StartApp
{
    //Global Variables
    public static Boats boatValues[];
    public static Boats boatTest;
    public static Motorcycle motorArray[];
    public static Motorcycle motorTest;
    public static Cars carArray[];
    public static Cars carTest;
    public static Planes planeTest;
    public static void main(String[] args)
    {
        initGlobalVariables();
        Main_Screen App = new Main_Screen();
    }
    
    public static void initGlobalVariables()
    {
        boatValues = new Boats[10];
        motorArray = new Motorcycle[10];
        carArray = new Cars[10];
        Motorcycle.Motorcycle(10);
        Cars.Cars(10);
    }
}
