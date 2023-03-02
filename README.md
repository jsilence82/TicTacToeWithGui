# Tic Tac Toe With GUI
Gui version of my previous text console Tic Tac Toe Game.

This project is continuation of a simple Tic Tac Toe game that had previously been developed as a text console game. 
The goal for this project was to a graphical user interface to the game, as well as demonstrate OOP principals and utilize some design patterns.


# 1 - MVC
The project was created using the Model View Controller pattern.

The View element consists of a selection screen for the user to select which type of players: Human player, against the computer (using a random number
generator), or against an AI. It also allows the user to give names for any human players. (Computer vs. Computer is possible)

The information is sent to the controller and the View (the game field) is displayed. The Controller class handles all requests from the View to the GameState
class, which is the interface to the classes contained in the Model section.

# 2 - Adapter
An adapter pattern was used to handle the various requests between Controller and Model and View based on the ActionListener source. 

# 3 - Factory
The user can select for each player three separate player types: Human player (controlled by the user(s)), Random (controlled by the computer via a random
number generator, considered very easy to beat), and an AI model (more info on that below). 

All three classes inherit from an abstract class: Player. The classes are then created and returned via a Factory class based on the user's input on the selection
screen.

# 4 - AI model
The AI class uses a miniMax algorithm to calculate the best move for the computer. It will search for the best available space for a win, and it will also
block its opponent if it calculates the opponent has a winning move. 

Getting more than a draw against the AI is impossible.

# 4 - The GameState class
GameState is created by the Controller and is the entry point into the game's model. A few additional notes about how the GameState class funtions:

- Utilizes a Swing Timer to introduce a two second delay for the computer to make its move (assuming one of the two computer options is selected as an
opponent). This was done to give time for the message that the computer was picking to appear, the move to be made, and the switch to the next player to occur.
- An undo button is also availble, implemented by use of a stack that stores the previous moves. If the game is Player vs. Player, the undo button will remove
only the last player's move. If the game is Player vs. Computer, the undo button removes both the computer's and player's last moves.

# 5 - Further updates
Further updates may be made on the project, including;
- Improvements in the GUI design
- Bug fixes or other issues.

