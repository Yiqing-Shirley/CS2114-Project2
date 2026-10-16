
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
     * @param name name of step
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
     * @param name the cooking step name to check
     * @return true if the name is valid
     */
    public static boolean isValidName(String name)
    {
        if (name == null)
        {
            return false;
        }

        String normalizedName = name.trim().toLowerCase();

        return normalizedName.equals("wash the vegetables")
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
     * @param name the cooking step name
     * @return the new CookingStep, or null if the name is invalid
     */
    public static CookingStep fromName(String name)
    {
        if (!isValidName(name))
        {
            return null;
        }

        String normalizedName = name.trim().toLowerCase();
        String displayName = "";

        if (normalizedName.equals("wash the vegetables"))
        {
            displayName = "Wash the vegetables";
        }
        else if (normalizedName.equals("precook the meats"))
        {
            displayName = "Precook the meats";
        }
        else if (normalizedName.equals("cut up the ingredients"))
        {
            displayName = "Cut up the ingredients";
        }
        else if (normalizedName.equals("make and stretch the dough"))
        {
            displayName = "Make and stretch the dough";
        }
        else if (normalizedName.equals("preheat the oven"))
        {
            displayName = "Preheat the oven";
        }
        else if (normalizedName.equals("put the toppings on"))
        {
            displayName = "Put the toppings on";
        }
        else if (normalizedName.equals("bake"))
        {
            displayName = "Bake";
        }

        return new CookingStep(displayName);
    }
}

