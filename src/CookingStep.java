
/**
 * Object contains one step of making a pizza.
 *
 * @author Anna-Maria Renalds
 * @version Oct 15, 2026
 */
public class CookingStep
{
    private String name;

    /**
     * Creates a new CookingStep object.
     *
     * @param name
     *            name of step
     */
    public CookingStep(String name)
    {
        this.name = name;
    }


    /**
     * Returns the name of the CookingStep.
     *
     * @return name of the cooking step
     */
    public String getName()
    {
        return name;
    }


    /**
     * Checks whether a name is a valid cooking step.
     *
     * @param name
     *            the cooking step name to check
     * @return true if the name is valid
     */
    public static boolean isValidName(String name)
    {
        if (name == null)
        {
            return false;
        }

        String normalizedName = name.trim().toLowerCase();

        return normalizedName.equals("1") || normalizedName.equals("2")
            || normalizedName.equals("3") || normalizedName.equals("4")
            || normalizedName.equals("5") || normalizedName.equals("6")
            || normalizedName.equals("7")
            || normalizedName.equals("wash the vegetables")
            || normalizedName.equals("precook the meats")
            || normalizedName.equals("cut up the ingredients")
            || normalizedName.equals("make and stretch the dough")
            || normalizedName.equals("preheat the oven")
            || normalizedName.equals("put the toppings on")
            || normalizedName.equals("bake");
    }


    /**
     * Creates a CookingStep from a valid name.
     *
     * @param name
     *            the cooking step name
     * @return the new CookingStep, or null if the name is invalid
     */
    /**
     * Creates a CookingStep from a valid name or number.
     *
     * @param name
     *            the cooking step name or number
     * @return the new CookingStep, or null if invalid
     */
    public static CookingStep fromName(String name)
    {
        if (!isValidName(name))
        {
            return null;
        }

        String normalizedName = name.trim().toLowerCase();
        String displayName = "";

        if (normalizedName.equals("wash the vegetables")
            || normalizedName.equals("1"))
        {
            displayName = "Wash the vegetables";
        }
        else if (normalizedName.equals("precook the meats")
            || normalizedName.equals("2"))
        {
            displayName = "Precook the meats";
        }
        else if (normalizedName.equals("cut up the ingredients")
            || normalizedName.equals("3"))
        {
            displayName = "Cut up the ingredients";
        }
        else if (normalizedName.equals("make and stretch the dough")
            || normalizedName.equals("4"))
        {
            displayName = "Make and stretch the dough";
        }
        else if (normalizedName.equals("preheat the oven")
            || normalizedName.equals("5"))
        {
            displayName = "Preheat the oven";
        }
        else if (normalizedName.equals("put the toppings on")
            || normalizedName.equals("6"))
        {
            displayName = "Put the toppings on";
        }
        else if (normalizedName.equals("bake") || normalizedName.equals("7"))
        {
            displayName = "Bake";
        }

        return new CookingStep(displayName);
    }
}
