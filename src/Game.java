
import java.util.Scanner;

/**
 * Manages the pizza-making game, including ingredients, cooking steps, player
 * commands, and pizza results.
 * 
 * @author Yiqing Wang
 * @version 10/20/2026
 */
public class Game
{
    private static int MAX_INGREDIENTS = 20;
    private static int MAX_COOKING_STEPS = 20;
    private LinkedChain<Ingredient> ingredients;
    private LinkedChain<CookingStep> cookingSteps;
    private Scanner scanner;

    /**
     * Creates a new game.
     */
    public Game()
    {
        ingredients = new LinkedChain<Ingredient>();
        cookingSteps = new LinkedChain<CookingStep>();
        scanner = new Scanner(System.in);
    }


    /**
     * Starts the game and initializes the game state.
     */

    public void startGame()
    {
        System.out.println("========================================");
        System.out.println(" Welcome to I'm the Pizza King!");
        System.out.println("========================================");
        System.out.println();

        System.out.println("Create your own pizza by adding, removing,");
        System.out.println("and arranging ingredients and cooking steps.");
        System.out.println();
        System.out.println("Let your imagination and creativity run wild!");
        System.out.println("Have fun creating your very own pizza!");
        System.out.println();

        printAvailableOptions();

        System.out.println();
        System.out.println("Type 'help' to see all available commands.");
        System.out.println("Type 'quit' to exit the game.");
        System.out.println();
    }


    /**
     * Display the available options
     */
    public void printAvailableOptions()
    {
        System.out.println("========== Available Ingredients ==========");

        System.out.println("Cheese:");
        System.out.println("  Cheddar, Feta, Parmesan, Mozzarella");

        System.out.println("Sauce:");
        System.out.println("  Tomato sauce, Alfredo sauce, Chocolate sauce");

        System.out.println("Meats:");
        System.out.println("  Pepperoni, Sausage, Chicken, Steak");

        System.out.println("Dough:");
        System.out.println("  Stuff crust, Whole wheat, Pan, Thin");

        System.out.println("Vegetables:");
        System.out.println("  Onions, Mushrooms, Peppers, Olives");

        System.out.println("Other toppings:");
        System.out.println("  Pineapple, banana, Carolina Reaper");

        System.out.println();
        System.out.println("========== Available Cooking Steps ==========");

        System.out.println("  1. Wash the vegetables");
        System.out.println("  2. Precook the meats");
        System.out.println("  3. Cut up the ingredients");
        System.out.println("  4. Make and stretch the dough");
        System.out.println("  5. Preheat the oven");
        System.out.println("  6. Put the toppings on");
        System.out.println("  7. Bake");
    }


    /**
     * Accept the player's input
     * 
     * @return true if player's input is valid; and false if input is invalid
     */
    public boolean userInput()
    {
        System.out.print("Enter your command: ");
        String command = scanner.nextLine().trim();
        String lowerCommand = command.toLowerCase();

        if (lowerCommand.equals("quit"))
        {
            System.out.println("Thanks for playing I'm the Pizza King!");
            return false;
        }

        else if (lowerCommand.equals("help"))
        {
            printHelp();
        }

        else if (lowerCommand.equals("cook"))
        {
            if (ingredients.isEmpty() || cookingSteps.isEmpty())
            {
                System.out.println(
                    "Your pizza is incomplete! Please add ingredients and cooking steps.");
            }
            else if (!successful())
            {
                System.out.println(
                    "Your pizza failed! The cooking steps are incorrect.");
            }
            else
            {
                System.out.println("Your pizza is ready!");

                checkTitles();
            }

            return true;
        }

        else if (lowerCommand.equals("show ingredients"))
        {
            showIngredients();
        }
        else if (lowerCommand.equals("show steps"))
        {
            showCookingSteps();
        }
        else if (lowerCommand.startsWith("insert step "))
        {
            String remainder =
                command.substring("insert step ".length()).trim();
            int lastSpace = remainder.lastIndexOf(' ');

            if (lastSpace == -1)
            {
                System.out
                    .println("Invalid command. Example: insert step bake 2");
            }
            else
            {
                String name = remainder.substring(0, lastSpace).trim();
                String positionText = remainder.substring(lastSpace + 1).trim();

                try
                {
                    int position = Integer.parseInt(positionText);

                    if (CookingStep.isValidName(name))
                    {
                        insertCookingStep(name, position);
                    }
                    else
                    {
                        System.out.println("Invalid cooking step.");
                    }
                }
                catch (NumberFormatException e)
                {
                    System.out
                        .println("Invalid position. Please enter a number.");
                }
            }
        }

        else if (lowerCommand.startsWith("remove "))
        {
            String name = command.substring(7).trim();

            if (name.isEmpty())
            {
                System.out.println(
                    "Invalid removal. Please specify an ingredient or cooking step.");
            }
            else
            {
                removeItem(name);
            }
        }

        else if (lowerCommand.startsWith("add "))
        {
            String name = command.substring(4).trim();

            if (Ingredient.isValidName(name))
            {
                addIngredient(name);
            }
            else if (CookingStep.isValidName(name))
            {
                addCookingStep(name);
            }
            else
            {
                System.out.println(
                    "Invalid addition. Please choose from the available options.");
            }
        }

        else
        {
            System.out.println(
                "Invalid command. Type 'help' to see available commands.");
        }

        return true;
    }


    private void addIngredient(String name)
    {
        if (ingredients.size() >= MAX_INGREDIENTS)
        {
            System.out.println("You cannot add more than 20 ingredients.");
            return;
        }

        Ingredient ingredient = Ingredient.fromName(name);

        if (ingredient == null)
        {
            System.out
                .println("Invalid addition. Please choose a valid ingredient.");
            return;
        }

        ingredients.add(ingredient);

        System.out.println("Added ingredient: " + ingredient.getName());
    }


    private void addCookingStep(String name)
    {
        if (cookingSteps.size() >= MAX_COOKING_STEPS)
        {
            System.out.println("You cannot add more than 20 cooking steps.");
            return;
        }

        CookingStep step = CookingStep.fromName(name);

        if (step == null)
        {
            System.out.println(
                "Invalid addition. Please choose a valid cooking step.");
            return;
        }

        cookingSteps.addToEnd(step);

        System.out.println("Added cooking step: " + step.getName());
    }


    private void showIngredients()
    {
        System.out.println("Your ingredients:");

        if (ingredients.isEmpty())
        {
            System.out.println("  No ingredients added yet.");
            return;
        }

        for (int i = 0; i < ingredients.size(); i++)
        {
            Ingredient ingredient = ingredients.get(i);
            System.out.println(
                "  " + ingredient.getName() + " (" + ingredient.getCategory()
                    + ")");
        }
    }


    private void showCookingSteps()
    {
        System.out.println("Your cooking steps:");

        if (cookingSteps.isEmpty())
        {
            System.out.println("  No cooking steps added yet.");
            return;
        }

        for (int i = 0; i < cookingSteps.size(); i++)
        {
            CookingStep step = cookingSteps.get(i);
            System.out.println("  " + (i + 1) + ". " + step.getName());
        }
    }


    private void removeItem(String name)
    {
        String normalizedName = name.trim().toLowerCase();

        if (Ingredient.isValidName(normalizedName))
        {
            boolean removed = false;

            for (int i = 0; i < ingredients.size(); i++)
            {
                Ingredient ingredient = ingredients.get(i);

                if (ingredient.getName().equalsIgnoreCase(normalizedName))
                {
                    ingredients.remove(ingredient);
                    removed = true;
                    System.out
                        .println("Removed ingredient: " + ingredient.getName());
                    break;
                }
            }

            if (!removed)
            {
                System.out.println("This ingredient is not in your pizza.");
            }
        }
        else if (CookingStep.isValidName(normalizedName))
        {
            boolean removed = false;

            for (int i = 0; i < cookingSteps.size(); i++)
            {
                CookingStep step = cookingSteps.get(i);

                if (step.getName().equalsIgnoreCase(normalizedName))
                {
                    cookingSteps.remove(step);
                    removed = true;
                    System.out
                        .println("Removed cooking step: " + step.getName());
                    break;
                }
            }

            if (!removed)
            {
                System.out.println("This cooking step is not in your pizza.");
            }
        }
        else
        {
            System.out.println(
                "Invalid choice. Please choose from the available options.");
        }
    }


    private void insertCookingStep(String name, int position)
    {
        CookingStep step = CookingStep.fromName(name);

        if (step == null)
        {
            System.out.println("Invalid cooking step.");
            return;
        }

        int sizeBeforeInsert = cookingSteps.size();
        if (sizeBeforeInsert >= MAX_COOKING_STEPS)
        {
            System.out.println("You cannot add more than 20 cooking steps.");
            return;
        }

        try
        {
            cookingSteps.insert(position - 1, step);
            System.out.println("Inserted cooking step: " + step.getName());
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println(
                "Invalid position. Choose a position from 1 to "
                    + (sizeBeforeInsert + 1) + ".");
        }
    }


    /**
     * Displays all available game commands.
     */
    private void printHelp()
    {
        System.out.println();
        System.out.println("========== Available Commands ==========");
        System.out.println(
            "add <name>                 - Add an ingredient or cooking step");
        System.out.println(
            "add <number>               - Add a cooking step by number");
        System.out.println(
            "remove <name>              - Remove an ingredient or cooking step");
        System.out.println(
            "insert step <name> <pos>   - Insert a cooking step at a position");
        System.out.println(
            "show ingredients           - Show your selected ingredients");
        System.out
            .println("show steps                 - Show your cooking steps");
        System.out
            .println("cook                       - Check your pizza result");
        System.out
            .println("help                       - Display available commands");
        System.out.println("quit                       - Exit the game");
        System.out.println("========================================");
        System.out.println();
    }


    /**
     * Determines whether the pizza is successful.
     *
     * @return true if the pizza is successful
     */

    public boolean successful()
    {
        if (cookingSteps.isEmpty())
        {
            return false;
        }

        boolean washSeen = false;
        boolean cutSeen = false;
        boolean doughSeen = false;
        boolean toppingsSeen = false;

        boolean washBeforeCut = false;
        boolean doughBeforeToppings = false;
        boolean cutBeforeToppings = false;

        // Check the cooking steps in their current order.
        for (int i = 0; i < cookingSteps.size(); i++)
        {
            String stepName = cookingSteps.get(i).getName();

            if (stepName.equalsIgnoreCase("Wash the vegetables"))
            {
                washSeen = true;
            }
            else if (stepName.equalsIgnoreCase("Cut up the ingredients"))
            {
                if (washSeen)
                {
                    washBeforeCut = true;
                }
                cutSeen = true;
            }
            else if (stepName.equalsIgnoreCase("Make and stretch the dough"))
            {
                doughSeen = true;
            }
            else if (stepName.equalsIgnoreCase("Put the toppings on"))
            {
                if (doughSeen)
                {
                    doughBeforeToppings = true;
                }
                if (cutSeen)
                {
                    cutBeforeToppings = true;
                }
                toppingsSeen = true;
            }
        }

        String lastStep = cookingSteps.get(cookingSteps.size() - 1).getName();
        boolean bakeLast = lastStep.equalsIgnoreCase("Bake");

        return washSeen && cutSeen && doughSeen && toppingsSeen && washBeforeCut
            && doughBeforeToppings && cutBeforeToppings && bakeLast;
    }


    /**
     * Checks and displays unlocked pizza titles.
     */
    public void checkTitles()
    {
        boolean weirdPizza = false;
        int meatCount = 0;
        int vegetableCount = 0;
        int bakeCount = 0;

        // Check ingredients
        for (int i = 0; i < ingredients.size(); i++)
        {
            Ingredient ingredient = ingredients.get(i);
            String name = ingredient.getName();
            String category = ingredient.getCategory();

            if (name.equalsIgnoreCase("Chocolate sauce")
                || name.equalsIgnoreCase("banana")
                || name.equalsIgnoreCase("Carolina Reaper"))
            {
                weirdPizza = true;
            }

            if (category.equalsIgnoreCase("Meats"))
            {
                meatCount++;
            }
            else if (category.equalsIgnoreCase("Vegetables"))
            {
                vegetableCount++;
            }
        }

        // Check cooking steps
        for (int i = 0; i < cookingSteps.size(); i++)
        {
            CookingStep step = cookingSteps.get(i);

            if (step.getName().equalsIgnoreCase("Bake"))
            {
                bakeCount++;
            }
        }

        System.out.println("========== Pizza Titles ==========");

        if (weirdPizza)
        {
            System.out.println("Unlocked: Weird Pizza!");
        }

        if (meatCount >= 3 && meatCount > vegetableCount)
        {
            System.out.println("Unlocked: Carnivore!");
        }

        if (vegetableCount >= 3 && vegetableCount > meatCount)
        {
            System.out.println("Unlocked: Herbivore!");
        }

        if (bakeCount >= 3)
        {
            System.out.println("Unlocked: Fire Alarm!");
        }
    }

}
