/**
 * Start a new game
 * @author Yiqing Wang
 * @version 10/20/2026
 */
public class GamePlay
{
    /**
     * Start a new game
     * @param args 
     */
    public static void main(String[] args)
    {
        Game game = new Game();

        game.startGame();

        while (game.userInput())
        {
            continue;
        }
    }
}