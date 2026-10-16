
/**
 * Ingredients for making the pizza.
 *
 * @author Anna-Maria Renalds
 * @version Oct 15, 2026
 */
public class Ingredient
{
    private String name;
    private String type;

    /**
     * Creates a new Ingredient object.
     *
     * @param name name of the ingredient
     * @param type type of ingredient
     */
    public Ingredient(String name, String type)
    {
        this.name = name;
        this.type = type;
    }

    /**
     * Returns the ingredient's name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the category/type of the ingredient.
     *
     * @return the category
     */
    public String getCategory()
    {
        return type;
    }

    /**
     * Checks whether a name is a valid ingredient.
     *
     * @param name the ingredient name to check
     * @return true if the name is valid
     */
    public static boolean isValidName(String name)
    {
        if (name == null)
        {
            return false;
        }

        String normalizedName = name.trim().toLowerCase();

        return normalizedName.equals("cheddar")
            || normalizedName.equals("feta")
            || normalizedName.equals("parmesan")
            || normalizedName.equals("mozzarella")
            || normalizedName.equals("tomato sauce")
            || normalizedName.equals("alfredo sauce")
            || normalizedName.equals("chocolate sauce")
            || normalizedName.equals("pepperoni")
            || normalizedName.equals("sausage")
            || normalizedName.equals("chicken")
            || normalizedName.equals("steak")
            || normalizedName.equals("stuff crust")
            || normalizedName.equals("whole wheat")
            || normalizedName.equals("pan")
            || normalizedName.equals("thin")
            || normalizedName.equals("onions")
            || normalizedName.equals("mushrooms")
            || normalizedName.equals("peppers")
            || normalizedName.equals("olives")
            || normalizedName.equals("pineapple")
            || normalizedName.equals("banana")
            || normalizedName.equals("carolina reaper");
    }

    /**
     * Returns the category of a valid ingredient name.
     *
     * @param name the ingredient name
     * @return the category, or null if the name is invalid
     */
    public static String getCategoryForName(String name)
    {
        if (!isValidName(name))
        {
            return null;
        }

        String normalizedName = name.trim().toLowerCase();

        if (normalizedName.equals("cheddar")
            || normalizedName.equals("feta")
            || normalizedName.equals("parmesan")
            || normalizedName.equals("mozzarella"))
        {
            return "Cheese";
        }
        else if (normalizedName.equals("tomato sauce")
            || normalizedName.equals("alfredo sauce")
            || normalizedName.equals("chocolate sauce"))
        {
            return "Sauce";
        }
        else if (normalizedName.equals("pepperoni")
            || normalizedName.equals("sausage")
            || normalizedName.equals("chicken")
            || normalizedName.equals("steak"))
        {
            return "Meats";
        }
        else if (normalizedName.equals("stuff crust")
            || normalizedName.equals("whole wheat")
            || normalizedName.equals("pan")
            || normalizedName.equals("thin"))
        {
            return "Dough";
        }
        else if (normalizedName.equals("onions")
            || normalizedName.equals("mushrooms")
            || normalizedName.equals("peppers")
            || normalizedName.equals("olives"))
        {
            return "Vegetables";
        }
        else
        {
            return "Other toppings";
        }
    }

    /**
     * Creates an Ingredient from a valid name.
     *
     * @param name the ingredient name
     * @return the new Ingredient, or null if the name is invalid
     */
    public static Ingredient fromName(String name)
    {
        if (!isValidName(name))
        {
            return null;
        }

        String normalizedName = name.trim().toLowerCase();
        String category = getCategoryForName(normalizedName);

        // Keep the display name consistent.
        String displayName = normalizedName;

        if (normalizedName.equals("carolina reaper"))
        {
            displayName = "Carolina Reaper";
        }
        else if (normalizedName.equals("tomato sauce"))
        {
            displayName = "Tomato sauce";
        }
        else if (normalizedName.equals("alfredo sauce"))
        {
            displayName = "Alfredo sauce";
        }
        else if (normalizedName.equals("chocolate sauce"))
        {
            displayName = "Chocolate sauce";
        }

        return new Ingredient(displayName, category);
    }
}

