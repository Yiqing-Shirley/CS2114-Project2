import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Tests the Game class.
 *
 * @author Yiqing
 * @version Oct 16, 2026
 */
public class GameTest extends student.TestCase
{
    private InputStream originalIn;
    private PrintStream originalOut;
    private ByteArrayOutputStream output;

    /**
     * Saves the original input and output streams.
     */
    public void setUp()
    {
        originalIn = System.in;
        originalOut = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }


    /**
     * Restores the original input and output streams.
     */
    public void tearDown()
    {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }


    /**
     * Sets up simulated user input.
     *
     * @param input the simulated commands
     * @return a new Game
     */
    private Game createGame(String input)
    {
        System.setIn(
            new ByteArrayInputStream(input.getBytes()));
        return new Game();
    }


    /**
     * Tests the constructor.
     */
    public void testConstructor()
    {
        Game game = createGame("quit\n");
        assertNotNull(game);
        assertFalse(game.successful());
    }


    /**
     * Tests startGame output.
     */
    public void testStartGame()
    {
        Game game = createGame("quit\n");
        game.startGame();

        assertTrue(output.toString().contains(
            "Welcome to I'm the Pizza King!"));
        assertTrue(output.toString().contains(
            "Type 'help' to see all available commands."));
        assertTrue(output.toString().contains(
            "Cheddar, Feta, Parmesan, Mozzarella"));
    }


    /**
     * Tests printAvailableOptions.
     */
    public void testPrintAvailableOptions()
    {
        Game game = createGame("quit\n");
        game.printAvailableOptions();

        assertTrue(output.toString().contains(
            "Available Ingredients"));
        assertTrue(output.toString().contains(
            "Available Cooking Steps"));
        assertTrue(output.toString().contains("Bake"));
    }


    /**
     * Tests quitting the game.
     */
    public void testQuit()
    {
        Game game = createGame("quit\n");

        assertFalse(game.userInput());
        assertTrue(output.toString().contains(
            "Thanks for playing I'm the Pizza King!"));
    }


    /**
     * Tests an invalid command.
     */
    public void testInvalidCommand()
    {
        Game game = createGame("hello\nquit\n");

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "Invalid command."));
        assertFalse(game.userInput());
    }


    /**
     * Tests the help command.
     */
    public void testHelp()
    {
        Game game = createGame("help\nquit\n");

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "Available Commands"));
        assertFalse(game.userInput());
    }


    /**
     * Tests adding a valid ingredient.
     */
    public void testAddIngredient()
    {
        Game game = createGame(
            "add cheddar\nshow ingredients\nquit\n");

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "Added ingredient: cheddar"));

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "cheddar (Cheese)"));

        assertFalse(game.userInput());
    }


    /**
     * Tests adding an invalid ingredient.
     */
    public void testInvalidAddition()
    {
        Game game = createGame("add pizza\nquit\n");

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "Invalid addition."));
        assertFalse(game.userInput());
    }


    /**
     * Tests adding a valid cooking step.
     */
    public void testAddCookingStep()
    {
        Game game = createGame(
            "add bake\nshow steps\nquit\n");

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "Added cooking step: Bake"));

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "1. Bake"));

        assertFalse(game.userInput());
    }


    /**
     * Tests showing ingredients when the list is empty.
     */
    public void testShowEmptyIngredients()
    {
        Game game = createGame(
            "show ingredients\nquit\n");

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "No ingredients added yet."));
        assertFalse(game.userInput());
    }


    /**
     * Tests showing cooking steps when the list is empty.
     */
    public void testShowEmptySteps()
    {
        Game game = createGame("show steps\nquit\n");

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "No cooking steps added yet."));
        assertFalse(game.userInput());
    }


    /**
     * Tests removing an existing ingredient.
     */
    public void testRemoveIngredient()
    {
        Game game = createGame(
            "add cheddar\nremove cheddar\n"
                + "show ingredients\nquit\n");

        assertTrue(game.userInput());
        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "Removed ingredient: cheddar"));

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "No ingredients added yet."));
        assertFalse(game.userInput());
    }


    /**
     * Tests removing an item that is not present.
     */
    public void testRemoveMissingItem()
    {
        Game game = createGame(
            "remove cheddar\nquit\n");

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "This ingredient is not in your pizza."));
        assertFalse(game.userInput());
    }


    /**
     * Tests removing an item with an empty name.
     */
    public void testRemoveEmptyName()
    {
        Game game = createGame("remove\nquit\n");

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "Invalid command."));
        assertFalse(game.userInput());
    }

    /**
     * Tests inserting a cooking step at a valid position.
     */
    public void testInsertStep()
    {
        Game game = createGame(
            "add bake\n"
                + "insert step wash the vegetables 1\n"
                + "show steps\nquit\n");

        assertTrue(game.userInput());
        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "Inserted cooking step: Wash the vegetables"));

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "1. Wash the vegetables"));
        assertTrue(output.toString().contains(
            "2. Bake"));

        assertFalse(game.userInput());
    }


    /**
     * Tests an invalid insert position.
     */
    public void testInvalidInsertPosition()
    {
        Game game = createGame(
            "insert step bake 5\nquit\n");

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "Invalid position."));
        assertFalse(game.userInput());
    }


    /**
     * Tests a nonnumeric insert position.
     */
    public void testNonnumericInsertPosition()
    {
        Game game = createGame(
            "insert step bake abc\nquit\n");

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "Invalid position. Please enter a number."));
        assertFalse(game.userInput());
    }


    /**
     * Tests an invalid cooking step name.
     */
    public void testInvalidCookingStep()
    {
        Game game = createGame(
            "insert step pizza 1\nquit\n");

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "Invalid cooking step."));
        assertFalse(game.userInput());
    }


    /**
     * Tests an incomplete pizza.
     */
    public void testCookIncompletePizza()
    {
        Game game = createGame("cook\nquit\n");

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "Your pizza is incomplete!"));
        assertFalse(game.userInput());
    }


    /**
     * Tests cooking with incorrect step order.
     */
    public void testCookIncorrectOrder()
    {
        Game game = createGame(
            "add cheddar\n"
                + "add cut up the ingredients\n"
                + "add wash the vegetables\n"
                + "add make and stretch the dough\n"
                + "add put the toppings on\n"
                + "add bake\n"
                + "cook\nquit\n");

        for (int i = 0; i < 6; i++)
        {
            assertTrue(game.userInput());
        }

        assertFalse(game.successful());
        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "Your pizza failed!"));
        assertFalse(game.userInput());
    }


    /**
     * Tests a successful pizza.
     */
    public void testSuccessfulPizza()
    {
        Game game = createGame(
            "add cheddar\n"
                + "add wash the vegetables\n"
                + "add cut up the ingredients\n"
                + "add make and stretch the dough\n"
                + "add put the toppings on\n"
                + "add bake\n"
                + "cook\nquit\n");

        for (int i = 0; i < 6; i++)
        {
            assertTrue(game.userInput());
        }

        assertTrue(game.successful());

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "Your pizza is ready!"));
        assertFalse(game.userInput());
    }


    /**
     * Tests the weird pizza result.
     */
    public void testWeirdPizza()
    {
        Game game = createGame(
            "add banana\n"
                + "add wash the vegetables\n"
                + "add cut up the ingredients\n"
                + "add make and stretch the dough\n"
                + "add put the toppings on\n"
                + "add bake\n"
                + "cook\nquit\n");

        for (int i = 0; i < 6; i++)
        {
            assertTrue(game.userInput());
        }

        assertTrue(game.successful());

        assertTrue(game.userInput());
        assertTrue(output.toString().contains(
            "Your pizza is weird!"));
        assertFalse(game.userInput());
    }


    /**
     * Tests successful when there are no cooking steps.
     */
    public void testSuccessfulEmpty()
    {
        Game game = createGame("quit\n");

        assertFalse(game.successful());
    }


    /**
     * Tests successful when a required step is missing.
     */
    public void testSuccessfulMissingStep()
    {
        Game game = createGame(
            "add wash the vegetables\n"
                + "add cut up the ingredients\n"
                + "add bake\nquit\n");

        for (int i = 0; i < 3; i++)
        {
            assertTrue(game.userInput());
        }

        assertFalse(game.successful());
        assertFalse(game.userInput());
    }
    /**
     * Tests that more than 20 ingredients cannot be added.
     */
    public void testAddIngredientBeyondLimit()
    {
        StringBuilder input = new StringBuilder();

        for (int i = 0; i < 21; i++)
        {
            input.append("add cheddar\n");
        }
        input.append("show ingredients\nquit\n");

        Game game = createGame(input.toString());

        for (int i = 0; i < 21; i++)
        {
            assertTrue(game.userInput());
        }

        assertTrue(output.toString().contains(
            "You cannot add more than 20 ingredients."));
    }
}