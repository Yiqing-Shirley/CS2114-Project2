# CS 2114 Project 2 

## How to Compile and Run

### Compile the Program
Compile all Java source files in Eclipse by selecting the project and choosing **Project → Build Project**.

### Run the Program
Run `GamePlay.java` as a Java Application to start the game.

### Run the Tests
Run the test classes, including `LinkedChainTest.java`, `IngredientTest.java`, `CookingStepTest.java`, and `GameTest.java`, using the testing framework configured for the project in Eclipse.

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

All of our current tests pass, and we have not encountered any known test failures during our current testing. The main functionality of the prototype runs successfully.

However, some aspects could still be improved. The current pizza outcome messages are intentionally simple, using messages such as "Your pizza is ready!", "Your pizza failed!". These messages allow us to demonstrate the MVP without adding unnecessary complexity, but they do not fully capture the playful nature of the game.

The variety of implemented outcomes is also limited compared with our original ideas. Although the weird pizza outcome has been implemented, other interesting outcomes, including the fire alarm and pancake scenarios, have not yet been added. We also have not implemented the collection system that would allow players to collect or track interesting pizza results.

These features remain future work rather than known failures in the current prototype. Our next steps will focus on expanding the outcomes, improving their descriptions, and implementing the collection system if time permits.

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

- Weird pizza outcome — Committed and completed.

The current prototype recognizes unusual ingredients, including chocolate sauce, banana, and Carolina Reaper, and displays a special result for weird pizzas.

- Additional pizza outcomes — Committed, not yet completed.

We plan to implement the remaining planned outcomes, including the fire alarm and pancake scenarios, and improve the variety of result messages. We will prioritize these changes based on the time available.

- Collection system — Committed, not yet completed.

We plan to implement a system for collecting or tracking interesting pizza results. The exact behavior will be determined through team discussion before implementation.

### 3. New Tests

As we extend the prototype, we will add or revise tests to cover:

- New pizza outcomes: Tests for the fire alarm, pancake, and other newly implemented outcomes, including the ingredient or cooking-step conditions that trigger each result.
- Outcome combinations: Tests for relevant combinations of ingredients and cooking steps, including cases where different conditions could lead to different results.
- Collection system: Tests for adding and retrieving collected results, handling an empty collection, and any other public methods introduced by the final design.
- Other testing: Tests to ensure that existing successful, failed, and weird pizza outcomes continue to work after changes to the game logic.
- Bad-input handling: Tests for any new invalid inputs or boundary cases introduced by the additional features.
- 
### 4. Team Responsibilities

- Shirley: Implement the remaining pizza outcomes, revise the related game logic, and integrate and improve the visual design of the presentation slides.
- Anna-Maria: Implement the collection system and draft the presentation slide content.
- Both: Discuss and balance the pizza outcomes, agree on feature requirements, review design decisions, test the integrated application, and finalize the presentation.

## Attribution

| Class or Test File | Contributor(s) | Contribution |
|---|---|---|
| LinkedChain.java | Anna-Maria | Implemented and revised the linked-chain data structure. |
| LinkedChainTest.java | Anna-Maria | Wrote and tested unit tests for LinkedChain. |
| Ingredient.java | Anna-Maria | Implemented the Ingredient class. |
| IngredientTest.java | Anna-Maria | Wrote and tested unit tests for Ingredient. |
| CookingStep.java | Anna-Maria | Implemented the CookingStep class. |
| CookingStepTest.java | Anna-Maria | Wrote and tested unit tests for CookingStep. |
| Game.java | Yiqing | Implemented the game logic, command handling, validation, and pizza outcomes. |
| GameTest.java | Yiqing | Wrote and tested unit tests for Game. |
| GamePlay.java | Yiqing | Implemented the application entry point and gameplay loop. |
| GamePlayTest.java | Yiqing | Wrote and tested unit tests for GamePlay. |
| README.md | Yiqing and Anna-Maria | Collaboratively discussed and wrote the Reflection and Next Steps sections. |

### GenAI Use

We used GenAI as a supplementary tool during development to review design decisions, discuss whether certain LinkedChain methods were necessary, and help identify potential improvements to our implementation and tests. We reviewed the suggestions in the context of our project requirements and made the final implementation decisions as a team.
