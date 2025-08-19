# Battleship Game (Java Console)

This project is a simple text-based implementation of the **Battleship game** in Java.  
The player competes against the computer by placing ships on a 10x10 grid and taking turns guessing coordinates to sink the opponent’s ships.

---

## 🎮 How the Game Works

1. **Initialize the Battlefield**
   - A `10x10` grid is created and displayed with row and column indices (0–9).
   - Each grid cell can represent:
     - `@` → Player’s ship  
     - `x` → Computer’s ship (hidden in the display)  
     - `!` → A computer’s ship that has been destroyed  
     - `G` → A player’s ship that has been destroyed  
     - `-` → A missed shot  
     - (space) → Empty water

2. **Deploying Ships**
   - The player manually places **5 ships** by entering X and Y coordinates.
   - Input validation ensures:
     - Ships cannot be placed outside the grid.
     - Ships cannot overlap with other ships.
     - Only numeric input is accepted (invalid input is handled).
   - The computer randomly places **5 ships** on the grid.

3. **Battle Phase**
   - The game loop alternates turns between the player and the computer until one side has no ships left.
   - **Player’s Turn:**
     - Enter X and Y coordinates to attack.
     - If the shot hits:
       - Computer’s ship → `"Boom! You sunk the ship!"`  
       - Player’s own ship → `"Oh no, you sunk your own ship :("`  
       - Empty cell → `"Sorry, you missed"`  
       - Already attacked cell → warning message  
   - **Computer’s Turn:**
     - Chooses random coordinates to attack.
     - If the shot hits:
       - Player’s ship → `"The Computer sunk one of your ships!"`  
       - Computer’s own ship → `"The Computer sunk one of its own ships"`  
       - Empty cell → `"Computer missed"`

   - After each round, the battlefield and remaining ships are displayed.

4. **End of Game**
   - When one side’s ships are all destroyed, the game ends.
   - Results:
     - If the player still has ships left → `"Hooray! You won the battle :)"`  
     - If all player’s ships are destroyed → `"Sorry, you lost the battle"`

---

## ✅ Features
- 10x10 battlefield with coordinate-based gameplay.  
- Input validation for player ship placement and attacks.  
- Computer ships and moves are randomly generated.  
- Clear display of battlefield after each round.  
- Possibility for both player and computer to hit their own ships.  

---

## ⚠️ Limitations
- The computer’s attacks are purely random (no strategy).  
- Computer ship positions can be seen in the raw data array (`x`), even though they are hidden in the displayed grid.  
- Ships are only represented as single cells (no multi-cell ships like in the classic Battleship game).  
- The main class should follow Java naming conventions (e.g., `Main` instead of `main`).  

---

## 🚀 How to Run

### 1. Requirements
- **Java Development Kit (JDK) 8 or higher**  
  Make sure Java is installed on your system.  
  You can check by running:
  ```bash
  java -version

---

## 🖥️ Sample Gameplay

 |0123456789|
0|@         |0
1|          |1
2|    @     |2
3|          |3
4|          |4
5|          |5
6|   @      |6
7|          |7
8|          |8
9|     @    |9
 |0123456789|

Deploy your ships:
Enter X coordinate for your #1 ship: 0
Enter Y coordinate for your #1 ship: 0
...

YOUR TURN
Enter X coordinate: 2
Enter Y coordinate: 5
Sorry, you missed

COMPUTER'S TURN
Computer missed

Your ships: 5 | Computer ships: 5

---

<p align="center">❤️ Made with love by <b>Krisna Arji</b></p>
