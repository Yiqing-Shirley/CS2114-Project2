// -------------------------------------------------------------------------
/**
 *  Ingredients for making the pizza.
 * 
 *  @author Anna-Maria Renalds
 *  @version Oct 15, 2026
 */
public class Ingredient
{
    /**
     * name of ingredient
     */
    String name;
    /**
     * type of ingredient
     */
    String type;
    
    // ----------------------------------------------------------
    /**
     * Create a new Ingredient object.
     * @param name name of the ingredient
     * @param type type of ingredient
     */
    public Ingredient(String name, String type)
    {
        this.name = name;
        this.type = type;
    }
    // ----------------------------------------------------------
    /**
     * Returns the ingredient's name.
     * @return the name
     */
    public String getName() 
    {
        return name;
    }
   // ----------------------------------------------------------
/**
 *Returns the category/type of the ingredient. 
 * @return the category
 */
public String getCategory()
{
    return type;
}
   

}
