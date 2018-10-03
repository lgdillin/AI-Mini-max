

class Main {
  String[] values;

  Main() {
    values = new String[9];
    for(int i = 0; i < values.length; ++i) { values[i] = Integer.toString(i + 1); }
  }

  // void miniMax(node, depth, maximizingPlayer) {
  //   if(depth == 0 || node == terminal) {
  //     return heuristic;
  //   }
  //
  //   if(maximizingPlayer) {
  //     bestValue = 0; // Supposed to be neg inf
  //
  //     for(each child of node) {
  //       v = miniMax(child, depth - 1, false);
  //       bestValue = Math.max(bestValue, v);
  //     }
  //
  //     return bestValue;
  //   } else { // Minimizing player
  //     bestValue = 10000; // positive inf
  //     for(each child of node) {
  //       v = miniMax(child, depth - 1, true);
  //       bestValue = Math.min(bestValue, v);
  //     }
  //
  //     return bestValue;
  //   }
  // }

  void updateBoard(boolean human, int move) {
    if(human) values[move] = "X";
    else values[move] = "O";
  }

  void drawBoard() {
    System.out.println(" " + values[0] + " | " + values[1] + " | " + values[2] + " ");
    System.out.println("---+---+---");
    System.out.println(" " + values[3] + " | " + values[4] + " | " + values[5] + " ");
    System.out.println("---+---+---");
    System.out.println(" " + values[6] + " | " + values[7] + " | " + values[8] + " ");
    System.out.println();
  }

  public static void main(String[] args) {
    Main main = new Main();
    main.drawBoard();
    main.updateBoard(true, 3);
    main.drawBoard();
  }
}
