// -------------------------------------------------------------------------
/**
 *  Tests the Ingredient class
 * 
 *  @author Anna-Maria Renalds
 *  @version Oct 15, 2026
 */
public class IngredientTest extends student.TestCase
{
    // ----------------------------------------------------------
    /**
     * Tests getName and getCategory from the Ingredient class
     */
    public void testGetters()
    {
        Ingredient ingredient = new Ingredient("food", "veggie");
        assertEquals(ingredient.getName(), "food");
        assertEquals(ingredient.getCategory(), "veggie");
    }

}
