
/**
 * Tests the CookingStep class
 *
 * @author Anna-Maria Renalds
 * @version Oct 15, 2026
 */
public class CookingStepTest extends student.TestCase
{
    /**
     * Tests the constructor and getName method
     */
    public void testGetName()
    {
        CookingStep step = new CookingStep("Bake");
        assertEquals("Bake", step.getName());

        CookingStep anotherStep =
            new CookingStep("Wash the vegetables");
        assertEquals("Wash the vegetables", anotherStep.getName());
    }


    /**
     * Tests isValidName with valid and invalid names
     */
    public void testIsValidName()
    {
        assertTrue(CookingStep.isValidName("Bake"));
        assertTrue(
            CookingStep.isValidName("Wash the vegetables"));
        assertTrue(
            CookingStep.isValidName("PRECOOK THE MEATS"));
        assertTrue(
            CookingStep.isValidName("  cut up the ingredients  "));

        assertFalse(CookingStep.isValidName("invalid step"));
        assertFalse(CookingStep.isValidName(""));
        assertFalse(CookingStep.isValidName("   "));
        assertFalse(CookingStep.isValidName(null));
    }


    /**
     * Tests fromName with valid and invalid names
     */
    public void testFromName()
    {
        CookingStep step = CookingStep.fromName("bake");

        assertNotNull(step);
        assertEquals("Bake", step.getName());

        CookingStep wash =
            CookingStep.fromName("  WASH THE VEGETABLES  ");

        assertNotNull(wash);
        assertEquals("Wash the vegetables", wash.getName());

        CookingStep dough =
            CookingStep.fromName("make and stretch the dough");

        assertNotNull(dough);
        assertEquals("Make and stretch the dough", dough.getName());

        assertNull(CookingStep.fromName("invalid step"));
        assertNull(CookingStep.fromName(null));
    }
}

