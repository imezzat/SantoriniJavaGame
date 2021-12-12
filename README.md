## Santorini Java game

A simple 2 player game with GUI (Java Swing) employing OOP principles & Adapter design patterns.

### Game Rules:
* * *
-  Each player has 2 pieces of one type (either a cube or a pyramid).
-  A cube can move one step right/left or up/down, while a pyramid can move one step diagonally.
-  After moving a piece, the player can then place a tile on any of the adjacent cells (incrementing the level of that cell).
-  a piece can move to a cell having the same level or one level higher (i.e a piece on level 1 can move to a cell with level 2)
-  The first player to have a piece on a cell with 4 tiles wins the game.
-  if a player has no possible moves, the other player moves the game.
-  A cell with level 5 is disabled (can't be moved to or built upon).

### How to use the Files:
run the main method in the  eg.edu.guc.santorini.gui.Window class or by creating an instance of class window (new window())
