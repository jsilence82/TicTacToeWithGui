# Tic Tac Toe With GUI
Gui version of my previous text console Tic Tac Toe Game.

This project is a continuation of a simple Tic Tac Toe game that had previously been developed as a text console game.
The goal for this project was to add a graphical user interface to the game, as well as demonstrate OOP principles and utilize some design patterns.


# 1 - MVC
The project was created using the Model View Controller pattern.

The View element consists of a selection screen for the user to select which type of players: Human player, against the computer (using a random number
generator), or against an AI. It also allows the user to give names for any human players. (Computer vs. Computer is possible)

The information is sent to the Controller and the View (the game field) is displayed. The Controller handles all requests from the View and delegates to the
`GameControls` interface, which is implemented by `GameState` — the entry point into the Model layer.

### Interfaces
- `GameControllerInterface` (Controller package) — defines the contract between the View and Controller. `Controller` implements this interface. The View and Adapter depend only on this abstraction, not the concrete `Controller` class.
- `UIControl` (View package) — defines the contract between the Controller and the View. `GameBoardView` implements this interface.
- `GameControls` (Model package) — defines the contract between the Controller and the Model. `GameState` implements this interface.

![MVC-classOnly-edit](https://user-images.githubusercontent.com/98595145/222442120-430923df-122a-4940-b979-ccfb9d30cf57.png)

# 2 - Adapter
An `ActionAdapter` class (in the `Adapter` package) implements `ActionListener` and bridges Swing button click events from the View to the Controller.
It determines which button was clicked (board space, undo, reset, or exit) and calls the appropriate method on `GameControllerInterface`. This keeps
Swing-specific event handling isolated from both game logic and the view's display responsibilities.

# 3 - Factory
The user can select for each player three separate player types: Human player (controlled by the user(s)), Computer (controlled by the computer via a random
number generator, considered very easy to beat), and an AI model (more info on that below).

All three classes inherit from an abstract class: `Player`. The concrete classes (`HumanPlayer`, `Computer`, `AI`) are created via two cooperating mechanisms:
- `PlayerType` enum — each enum value holds a `create()` factory method that instantiates the appropriate `Player` subclass.
- `Factory` class — a static `playerFactory()` method that delegates to `PlayerType.create()`.
- `GameStateFactory` — a static factory that constructs a full `GameState` instance with two players based on the player type strings received from the selection screen.

The `ComputerPlayer` interface is implemented by both `Computer` and `AI`, allowing `GameState` to inject the `Board` reference into computer players before the game begins.

![factoryclass_edit_edit](https://user-images.githubusercontent.com/98595145/222441951-d12bcb36-549f-4cef-9a48-1aaa608ebe83.png)

# 4 - AI model
The `AI` class uses a miniMax algorithm to calculate the best move for the computer. It will search for the best available space for a win, and it will also
block its opponent if it calculates the opponent has a winning move.

Getting more than a draw against the AI is impossible.

# 5 - The Controller class
The `Controller` class is the central coordinator of the application. A few notes on how it functions:

- `GameState` is created via `GameStateFactory` and stored behind the `GameControls` interface. The Controller never references the concrete `GameState` class directly.
- A Swing `Timer` introduces a one-second delay for the computer to make its move (when one of the two computer options is selected). This gives time for
the "computer is picking" message to appear before the move is made and play switches to the next player.
- An undo stack (`Stack<List<Integer>>`) stores the coordinates of each move as it is made. The undo button pops from this stack and calls `undoBoardMove()`
on the model to revert the board. If the game is Player vs. Computer, the undo operation removes both the computer's and the human's last moves in one action.

# 6 - Exceptions
A custom `MoveStackEmptyException` (in the `Exceptions` package) extends `RuntimeException`. It is thrown by the Controller when the undo stack is empty
and caught in `ActionAdapter`, which then displays an error dialog to the user via `UIControl`.

# 7 - Further updates
Further updates may be made on the project, including:
- Improvements in the GUI design
- Bug fixes or other issues
