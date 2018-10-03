import java.util.Scanner;
import java.util.Random;

class Main {
  String[] values;

  Main() {
    values = new String[9];
    for(int i = 0; i < values.length; ++i) { values[i] = Integer.toString(i + 1); }
  }

  // int miniMax(int node, int depth, boolean maximizingPlayer) {
  //   if(depth == 0 || node == checkBoard()) {
  //     return heuristic;
  //   }
  //
  //   if(maximizingPlayer) {
  //     bestValue = -1000; // Supposed to be neg inf
  //
  //     for(each child of node) {
  //       v = miniMax(child, depth - 1, false);
  //       bestValue = Math.max(bestValue, v);
  //     }
  //
  //     return bestValue;
  //   } else { // Minimizing player
  //     bestValue = 1000; // positive inf
  //     for(each child of node) {
  //       v = miniMax(child, depth - 1, true);
  //       bestValue = Math.min(bestValue, v);
  //     }
  //
  //     return bestValue;
  //   }
  // }

  void updateBoard(boolean human, int move) {
    if(move < 0 || move > 8) return;

    if(human) values[move] = "X";
    else values[move] = "O";
  }

  boolean boardFull() {
    // Check for tie game
    for(int i = 0; i < values.length; ++i) {
      if( !(values[i] == "X") && !(values[i] == "O") ) return false; // Game not over
    }
    return true;
  }

  int checkBoard() {
    if(values[0] == values[1] && values[1] == values[2]) { if(values[0] == "X") return 1; else return -1; }
    if(values[3] == values[4] && values[4] == values[5]) { if(values[0] == "X") return 1; else return -1; }
    if(values[6] == values[7] && values[7] == values[8]) { if(values[0] == "X") return 1; else return -1; }

    if(values[0] == values[3] && values[3] == values[6]) { if(values[0] == "X") return 1; else return -1; }
    if(values[1] == values[4] && values[4] == values[7]) { if(values[0] == "X") return 1; else return -1; }
    if(values[2] == values[5] && values[5] == values[8]) { if(values[0] == "X") return 1; else return -1; }

    if(values[0] == values[4] && values[4] == values[8]) { if(values[0] == "X") return 1; else return -1; }
    if(values[6] == values[4] && values[4] == values[2]) { if(values[0] == "X") return 1; else return -1; }

    for(int i = 0; i < values.length; ++i) {
      if( !(values[i] == "X") && !(values[i] == "O") ) return 3; // Game not over
    }

    return 0; // Tie game
  }

  // Draws a tic-tac-toe board
  void drawBoard() {
    System.out.println(" " + values[0] + " | " + values[1] + " | " + values[2] + " ");
    System.out.println("---+---+---");
    System.out.println(" " + values[3] + " | " + values[4] + " | " + values[5] + " ");
    System.out.println("---+---+---");
    System.out.println(" " + values[6] + " | " + values[7] + " | " + values[8] + " ");
  }

  public static void main(String[] args) {
    Main main = new Main();
    Scanner keyboard = new Scanner(System.in);

    Random r = new Random();

    // Game loop
    boolean game_over = false;
    while(main.checkBoard() == 3) {
      // Update screen and collect user input
      main.drawBoard();
      System.out.print("Your move: ");
      int myint = keyboard.nextInt();
      System.out.println();

      //
      main.updateBoard(r.nextBoolean(), myint - 1);
    }

    if(main.checkBoard() == -1) System.out.println("AI Wins");
    else if(main.checkBoard() == 1) System.out.println("Human Wins");
    else System.out.println("Draw");
  }
}

class Node {
  Node parent;

}
