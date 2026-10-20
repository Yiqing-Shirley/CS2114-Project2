# CS 2114 Project 2 

## How to Compile and Run

### Compile the Program
Open the project in Eclipse and select **Project → Build Project** to compile the Java source files.

### Run the Game
Run `GamePlay.java` as a Java Application. The program will display the welcome message and available commands. Players can add ingredients, add or insert cooking steps, view their ingredients and cooking steps, remove items, and attempt to make a pizza.

### Run the Tests
Run the test classes in Eclipse using the testing framework configured for the project:

- `LinkedChainTest.java` — Tests the linked-chain collection and its operations.
- `IngredientTest.java` — Tests ingredient information and behavior.
- `CookingStepTest.java` — Tests cooking-step information and behavior.
- `GameTest.java` — Tests game commands, ingredient and cooking-step management, input validation, and pizza-making outcomes.

## Reflection

### 1. What changed from our specification?

During implementation, we made several adjustments to our original specification to make the application run more smoothly and simplify the interaction between classes.

The Ingredient and CookingStep classes remained relatively close to our original specification. However, we adjusted some method signatures and implementation details in other classes. For example, our specification originally described Game.userInput() as returning void, but our implementation returns a boolean. This allows GamePlay to use the return value to control the game loop. When the player enters "quit", userInput() returns false, allowing the game to end without requiring a separate condition to check whether the player wants to quit. We made this adjustment during implementation to simplify game control.

We also changed the LinkedChain.insert(int, T) method to return void rather than the boolean described in our specification. Our implementation focuses on inserting an entry at a valid position and throwing an exception when the position is invalid. These changes were made during implementation to support the functionality we needed.

These adjustments came from our implementation experience and team discussions. We also used GenAI to help review implementation decisions, including whether certain methods were necessary for our application.

### 2. What changed in the LinkedChain?

We extended the course-provided LinkedChain class with methods that better supported our game design.

First, we added insert(int, T) so that players could insert a cooking step at a specified position instead of only adding steps to the beginning or end of the chain. This was important because the order of cooking steps affects whether a pizza is successful.

Second, we added addToEnd(T) to make it easier to append cooking steps to the end of the chain while preserving their order.

We also removed the toArray(T[]) method after discussing whether it was necessary for our application. We reviewed how the rest of our program used LinkedChain and confirmed with GenAI that array conversion was not needed for our current implementation. We therefore removed this unused functionality to keep the class focused on the operations our application required.

These changes were driven by our implementation needs and team discussion, with GenAI used as a secondary source of confirmation. The application uses the public API of LinkedChain rather than directly accessing its internal nodes.

### 3. What happened to our unknowns?

Before implementation, we were unsure how well LinkedChain would support our game because we had not previously used it in a project of this kind. After implementing the application, we found that the same generic data structure could store both Ingredient and CookingStep objects. Using methods such as add(), addToEnd(), insert(), get(), and remove() helped us understand how a reusable data structure can support different application features.

Another challenge was balancing our original game design with the amount of code required. Many of our ideas depended on the player's ingredient choices and combinations. Implementing every possible combination with individual conditional statements would have created a large amount of repetitive code. We discussed whether more general approaches, such as using ingredient categories, could handle these choices more efficiently. This helped us recognize the importance of balancing game complexity, maintainability, and the time available for implementation.

Overall, implementing the prototype helped us resolve our uncertainty about using LinkedChain. The question of how to support more complex ingredient combinations efficiently remains an area for future improvement.

### 4. What doesn't work yet?

All of our current JUnit tests pass, and the main game functionality works as expected. We have also completed part of our stretch goals, including the pizza title system and numbered cooking-step input.

The title system allows players to unlock special titles such as Weird Pizza, Carnivore, Herbivore, and Fire Alarm after successfully making a pizza. We also improved the user interface by allowing players to enter cooking steps using either their names or numbers.

However, some planned features are still incomplete. The collection system for tracking unlocked titles has not yet been implemented, and additional ideas such as the pancake scenario remain future improvements.

We would also like to improve the variety of game messages and continue testing different ingredient combinations. These are areas for further development rather than known failures in the current application.

## Next Steps

Our next steps focus on improving the variety of pizza outcomes, implementing the collection system, and preparing our final presentation. We will prioritize the remaining work based on its importance and the time available.

### 1. Remaining MVP Work

1. Review and balance the pizza outcomes.

We will discuss the different possible pizza results and decide how ingredient choices and cooking steps should affect each outcome. We will consider how to make the results interesting without making the game logic unnecessarily complicated.

Attribution: Shirley and Anna-Maria.

2. Implement the remaining pizza outcomes.

Shirley will revise the game logic and add the remaining interesting outcomes, including the fire alarm and pancake scenarios, as well as other planned outcomes that are not yet implemented. We will also improve the outcome messages to make the game more engaging and consistent with its playful theme.

Attribution: Shirley.

3. Implement the collection system.

Anna-Maria will implement a system that allows players to collect or keep track of interesting pizza results. The implementation will follow the design decisions agreed upon by the team.

Attribution: Anna-Maria.

4. Test and integrate the new features.

We will review the integrated application and run the relevant tests after the new outcomes and collection system are implemented. We will fix any problems introduced by these changes and preserve the existing MVP functionality.

Attribution: Shirley and Anna-Maria.

5. Prepare and refine the presentation slides.

Anna-Maria will draft the slide text, while Shirley will integrate the material and improve the visual design. Both team members will review the slides together.

Attribution: Anna-Maria (slide content) and Shirley (integration and visual design).

6. Revise the code if time permits.

After the main features are complete, we will review the code for opportunities to reduce repetitive conditional logic and improve maintainability.

Attributions: Shirley and Anna-Maria.

### 2. Stretch Goals

- **Pizza Title System — Committed and completed.**

We implemented a pizza title system that unlocks special titles when players successfully make a pizza and meet additional conditions. The implemented titles include Weird Pizza, Carnivore, Herbivore, and Fire Alarm. The `successful()` method determines whether the pizza was made correctly, while the title system checks for special achievements only after a successful pizza.

- **Numbered Cooking-Step Input — Completed.**

We improved the user interface by allowing players to add cooking steps using either their names or corresponding numbers. This makes the game easier to play while preserving the original text-based commands.

- **Collection System — Committed, not yet completed.**

We plan to implement a system that allows players to track previously unlocked pizza titles.

- **Additional Pizza Outcomes — Not yet completed.**

Other planned features, including the pancake scenario, remain possible future improvements.

### 3. New Tests

As we extend the prototype, we will add or revise tests to cover:

- New pizza outcomes: Tests for the fire alarm, pancake, and other newly implemented outcomes, including the ingredient or cooking-step conditions that trigger each result.
- Outcome combinations: Tests for relevant combinations of ingredients and cooking steps, including cases where different conditions could lead to different results.
- Collection system: Tests for adding and retrieving collected results, handling an empty collection, and any other public methods introduced by the final design.
- Other testing: Tests to ensure that existing successful, failed, and weird pizza outcomes continue to work after changes to the game logic.
- Bad-input handling: Tests for any new invalid inputs or boundary cases introduced by the additional features.
- 
### 4. Team Responsibilities

- Yiqing: Game logic, code revisions, implementation of part of the stretch goals, and a smaller portion of the presentation slides.
- Anna-Maria: LinkedChain and supporting classes, the planned collection system, and most of the presentation slides.
- Both: Testing, reviewing implementation decisions, and finalizing the project.

## Attribution

| Class or File | Contributor(s) | Contribution |
|---|---|---|
| LinkedChain.java | Anna-Maria | Implemented and revised the linked-chain data structure. |
| LinkedChainTest.java | Anna-Maria | Developed and revised unit tests for LinkedChain. |
| Ingredient.java | Anna-Maria | Implemented the Ingredient class. |
| IngredientTest.java | Anna-Maria | Developed unit tests for Ingredient. |
| CookingStep.java | Anna-Maria, Yiqing | Anna-Maria implemented the original class; Yiqing revised the input validation and added support for numbered cooking steps. |
| CookingStepTest.java | Anna-Maria | Developed unit tests for CookingStep. |
| Game.java | Yiqing | Implemented and revised the game logic, command handling, input validation, and part of the stretch goals, including the pizza title system. |
| GameTest.java | Yiqing | Developed and revised unit tests for game commands, pizza outcomes, and additional features. |
| GamePlay.java | Yiqing | Implemented the application entry point and gameplay loop. |
| README.md | Yiqing, Anna-Maria | Collaboratively wrote and revised the Reflection, Next Steps, and Attribution sections. |
| Presentation Slides | Anna-Maria, Yiqing | Anna-Maria completed most of the presentation slides, while Yiqing contributed a smaller portion of the content and revisions. |

### GenAI Use

We used GenAI as a supplementary tool during development to review design decisions, discuss whether certain LinkedChain methods were necessary, and help identify potential improvements to our implementation and tests. We reviewed the suggestions in the context of our project requirements and made the final implementation decisions as a team.
