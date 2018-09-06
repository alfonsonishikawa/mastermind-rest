# mastermind-rest
Technical Test for a position in Barcelona

# Mastermind API
## Introduction

<img align="left" src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/Mastermind.jpg/200px-Mastermind.jpg">

Mastermind is a code-breaking game for two players. One player becomes the _codemaker_, the other the _codebreaker_. The codemaker chooses a pattern of four color code pegs (duplicates allowed) and the _codebreaker_ tries to guess it, in both order and color.
Each guess is made by placing a row of color code pegs on the decoding board. Once placed, the _codemaker_ provides feedback by placing from zero to four key pegs in the small holes of the row with the guess. A black key peg (small red in the image) is placed for each code peg from the guess which is correct in both color and position. A white key peg indicates the existence of a correct color code peg placed in the wrong position.

_Example: Given a code `[RED, BLUE, GREEN, RED]` when the codebreaker gives a code with `[RED, GREEN, RED, YELLOW]` the feedback will be: 1 black, 2 whites._

For more information about the game: https://en.wikipedia.org/wiki/Mastermind_(board_game)

## Project requirements
We want a Rest API that simulates the role of the Masterminds codemaker, its main features are:
* Create game (given a user request)
* Return feedback given a code guess
* Check game historic (optional, actually is a role of the board not the codemaker)
* The code should be production ready
* Use git for versioning (commits and documentation will be valuated)
* The code can be written in any language or framework (but java is preferred)
* Once finished send us a link to the remote git repository where it’s stored (Github, bitbucket, gitlab etc.)
* This project should take between 6-8h
