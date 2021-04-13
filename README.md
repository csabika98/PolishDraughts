# Polish draughts

## Story

Your best friend Tom is board games lover, and he plays checkers all the time like a pro! Recently he is really into
digital versions of his favorite games, unfortunately he cannot find any implementation of the
Polish Draughts. 
Give Tom your console version of this game.


## What are you going to learn?

You will learn and practice how to do the following things:

- variables,
- methods,
- loops and conditionals,
- classes and instances,
- print formatting,
- user input validation,
- handle edge cases,
- access modifiers,
- OOP.

## Tasks

1. There is a class `Board` which represents square board for Polish draughts.
    - There is a parameter `n` in the constructor describing the length of the side of the square, size should be an integer between 10 and 20 provided from user input.
    - There is a 2D array `Pawn[][] fields` which represents fields on a board. Each field can be `null` (empty) or a `Pawn` instance.
    - Pawns are created and placed only at every second field when the board is initialized. Their number is determined by board size as a `2 * n`.
    - There is `toString()` method that overrides built-in method. This method should mark rows as a numbers and columns as a letters.
    - There is `removePawn()` method that removes pawn with given position from.
    - There is `movePawn()` method that moves pawn with given position from one field to another.

2. There is a `Pawn` class.
    - There is a method `boolean getIsWhite()` that returns `true` if the pawn is white and `false` if it's black.
    - There is a field of class `Coordinates position` that represent pawn coordinates on a board. `Coordinates` class has two fields `int x` and `int y`.
    - [Extra] There is a field `boolean isCrowned` that returns `true` if given pawn is crowned.
    - `Pawn` contains a method that validates given move (checks whether it's according to the game's rules) before making it.
    - [Extra] Pawn can check if it can make multiple jumps according to the rules.

3. There is a class `Game` which contains all game logic and actions.
    - There is a method `start()` that starts whole game between players.
    - There is a method `playRound()` that determines one round actions i.e. check who plays next or is there a winner yet.
    - There is a method that checks if starting position from user input is a valid pawn and if ending position is within board boundaries. If so, it calls `tryToMakeMove()` on pawn instance.
    - There is a method `checkForWinner()` that checks after each round is there an a winner.
    - Method `checkForWinner()` checks also for draws.

4. [OPTIONAL] Try to implement singleton pattern. Try to implement additional features such as crowning, multi-jumping and checking for draw.
    - `Board` is a singleton so it can have only one instance.
    - Crowned feature is implemented. There is a property on `Pawn` called `boolean isCrowned` that returns `true` if given pawn is crowned and it implements crowning rules.
    - `Pawn` can check if it can make multiple jumps according to the rules.

## General requirements

- Whole board is redrawn in the console after each move.
- In case of an invalid input, the user is asked to input again, until receiving a valid value.

## Hints

- Try implement regular draughts rules and moves at first, try to expand it after your first code works.
- You can use e.g. [Singleton Design Pattern](https://refactoring.guru/design-patterns/singleton/java/example) to make only one board instance.
- You can try to convert user input letters from chars to integers,
this might help you find the way [ASCII TABLE](https://upload.wikimedia.org/wikipedia/commons/1/1b/ASCII-Table-wide.svg)


## Background materials

In this project your job is to implement variation of [Polish draughts](https://en.wikipedia.org/wiki/International_draughts) for two players.
You also can try writing some AI to play the game.

Main rules:
- there are two players with white and black pawns. White moves first,
- size board can be picked before the game starts, but it must be an integer between 10 and 20,
- all moves and captures are made diagonally,
- pawns can also capture backward.

Optional rules:
- Multiple successive jumps forward or backward in a single turn can and must be made if after each jump there is an unoccupied square
immediately beyond the enemy pawn,
- A piece is crowned if it stops on the far edge of the board at the end of its turn (that is, not if it reaches the edge but must
then jump another piece backward).

Winning and draws:
- A player with no valid move remaining loses,
- Optional: The game is considered a draw when the same position repeats itself for the third time
(not necessarily consecutive), with the same player having the move each time,
- A king-versus-king endgame is automatically declared a draw.

- <i class="far fa-exclamation"></i> [Fields](http://tutorials.jenkov.com/java/fields.html)
- <i class="far fa-exclamation"></i> [Methods](https://www.w3schools.com/java/java_methods.asp)
- <i class="far fa-exclamation"></i> [Types in Java](https://www.w3schools.com/java/java_data_types.asp)
- <i class="far fa-exclamation"></i> [Clean Code in Java](https://www.baeldung.com/java-clean-code)
- <i class="far fa-exclamation"></i> [Singleton Design Pattern](https://www.geeksforgeeks.org/singleton-class-java/)
- <i class="far fa-exclamation"></i> [Access Modifiers](https://www.javatpoint.com/access-modifiers)

