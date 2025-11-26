# Malatro

**Malatro** is a card game project developed in Scala, inspired by the game *Balatro*. It simulates a poker-based game with unique mechanics involving Jokers and score calculations.

## Features

- **Card System**: Implementation of standard playing cards with Ranks and Suits.
- **Poker Combinations**: Logic to detect and evaluate poker hands (e.g., Pair, Flush, Straight).
- **Joker Mechanics**: A system of Jokers that modify the game state and scoring:
  - **Greedy Joker**
  - **Devious Joker**
  - **EvenSteven**
  - **ScaryFace**
- **Scoring System**: Dynamic score calculation based on played cards and Joker effects.
- **Game Flow**: Managed by a state machine to handle different phases of the game.

## Architecture

The project follows a Model-View-Controller (MVC) inspired architecture, emphasizing the **State** and **Observer** design patterns.

### Model (`src/main/scala/model`)
Contains the core entities of the game:
- `Card`: Represents a playing card.
- `Deck`: Manages a deck of cards.
- `Hand`: Represents a player's hand.
- `Player`: Represents the game player.
- `Joker`: Abstract base class for Joker effects, with specific implementations in `model.joker`.

### Controller (`src/main/scala/controller`)
Manages the game logic and flow:
- `GameController`: The main entry point for game actions.
- **State Pattern** (`controller.state`): Handles game states (e.g., `NotStartedState`, `AwaitingActionState`, `GameOverState`).
- **Observer Pattern** (`controller.observer`): Allows the controller to react to changes in the game model (e.g., hand updates).

## Getting Started

### Prerequisites
- Scala 3.3.3
- sbt (Scala Build Tool)

### Running Tests
To run the test suite, navigate to the project root and run:

```bash
sbt test
```

### Running the Game
The game logic is encapsulated in the `GameController`. You can instantiate it and start a game programmatically or via a main application entry point (if configured).

## License
This project is licensed under the [Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/).