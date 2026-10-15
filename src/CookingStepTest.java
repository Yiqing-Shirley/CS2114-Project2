// -------------------------------------------------------------------------
/**
 *  Testing the CookingStep class
 * 
 *  @author Anna-Maria Renalds
 *  @version Oct 15, 2026
 */
public class CookingStepTest extends student.TestCase
{
    // ----------------------------------------------------------
    /**
     * testing the getName method
     */
    public void testGetName()
    {
        CookingStep cooking = new CookingStep("step");
        assertEquals("step", cooking.getName());
        
    }

}
