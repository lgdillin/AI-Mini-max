

class Main {
  String[] values;

  Main() {
    values = new String[9];
    for(int i = 0; i < values.length; ++i) { values[i] = Integer.toString(i + 1); }
  }

  void updateBoard(boolean human, int move) {
    if(human) values[move] = "X";
    else values[move] = "o";
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
