// -------------------------------------------------------------------------
/**
 * Object contains one step of making a pizza.
 * 
 *  @author Anna-Maria Renalds
 *  @version Oct 15, 2026
 */
public class CookingStep
{
   /**
 * name of the cooking step
 */
String name;

// ----------------------------------------------------------
/**
 * Create a new CookingStep object.
 * @param name name of step
 */
public CookingStep(String name)
{
    this.name = name;
}
   
   // ----------------------------------------------------------
/**
 * returns the name of the CookingStep
 * @return name of the cooking step
 */
public String getName()
   {
       return name;
   }
}
