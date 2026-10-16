
/**
 * Tests the Ingredient class
 *
 * @author Anna-Maria Renalds
 * @version Oct 15, 2026
 */
public class IngredientTest extends student.TestCase
{
    /**
     * Tests getName and getCategory from the Ingredient class
     */
    public void testGetters()
    {
        Ingredient ingredient = new Ingredient("food", "veggie");
        assertEquals("food", ingredient.getName());
        assertEquals("veggie", ingredient.getCategory());
    }


    /**
     * Tests isValidName with valid and invalid names
     */
    public void testIsValidName()
    {
        assertTrue(Ingredient.isValidName("cheddar"));
        assertTrue(Ingredient.isValidName("MOZZARELLA"));
        assertTrue(Ingredient.isValidName("  tomato sauce  "));
        assertTrue(Ingredient.isValidName("banana"));
        assertTrue(Ingredient.isValidName("Carolina Reaper"));

        assertFalse(Ingredient.isValidName("invalid food"));
        assertFalse(Ingredient.isValidName(""));
        assertFalse(Ingredient.isValidName("   "));
        assertFalse(Ingredient.isValidName(null));
    }


    /**
     * Tests getCategoryForName with valid and invalid names
     */
    public void testGetCategoryForName()
    {
        assertEquals("Cheese",
            Ingredient.getCategoryForName("cheddar"));
        assertEquals("Sauce",
            Ingredient.getCategoryForName("tomato sauce"));
        assertEquals("Meats",
            Ingredient.getCategoryForName("pepperoni"));
        assertEquals("Dough",
            Ingredient.getCategoryForName("thin"));
        assertEquals("Vegetables",
            Ingredient.getCategoryForName("onions"));
        assertEquals("Other toppings",
            Ingredient.getCategoryForName("banana"));

        assertEquals("Cheese",
            Ingredient.getCategoryForName("  CHEDDAR  "));

        assertNull(Ingredient.getCategoryForName("invalid food"));
        assertNull(Ingredient.getCategoryForName(null));
    }


    /**
     * Tests fromName with valid and invalid names
     */
    public void testFromName()
    {
        Ingredient ingredient = Ingredient.fromName("cheddar");

        assertNotNull(ingredient);
        assertEquals("cheddar", ingredient.getName());
        assertEquals("Cheese", ingredient.getCategory());

        Ingredient sauce = Ingredient.fromName("TOMATO SAUCE");

        assertNotNull(sauce);
        assertEquals("Tomato sauce", sauce.getName());
        assertEquals("Sauce", sauce.getCategory());

        Ingredient reaper = Ingredient.fromName("carolina reaper");

        assertNotNull(reaper);
        assertEquals("Carolina Reaper", reaper.getName());
        assertEquals("Other toppings", reaper.getCategory());

        assertNull(Ingredient.fromName("invalid food"));
        assertNull(Ingredient.fromName(null));
    }
}

