import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

  static void displayGame(int[][] game) {
    System.out.println("The Game state is as follows!");
    for (int i = 0; i < game.length; i++) {
      for (int j = 0; j < game[i].length; j++) {
        if (game[i][j] == 0) {
          System.out.print("_" + "  ");
        }
        if (game[i][j] == 1) {
          System.out.print("X" + "  ");
        }
        if (game[i][j] == 2) {
          System.out.print("O" + "  ");
        }
      }
      System.out.println();
      System.out.println();
    }
    System.out.println();
  }

  static void makeMove(int[][] game, int a, int b, String str) {
    if (str == "X") {
      game[a][b] = 1;
      return;
    }
    if (str == "O") {
      game[a][b] = 2;
      return;
    }
  }

  static boolean checkWinning(int[][] game) {
    boolean winning = false;
    // Row Wise Checking for winning
    if (
      game[0][0] == game[0][1] && game[0][1] == game[0][2] && game[0][0] != 0
    ) {
      winning = true;
    }
    if (
      game[1][0] == game[1][1] && game[1][1] == game[1][2] && game[1][0] != 0
    ) {
      winning = true;
    }
    if (
      game[2][0] == game[2][1] && game[2][1] == game[2][2] && game[2][0] != 0
    ) {
      winning = true;
    }

    // Column wise checking for winning
    if (
      game[0][0] == game[1][0] && game[1][0] == game[2][0] && game[0][0] != 0
    ) {
      winning = true;
    }
    if (
      game[0][1] == game[1][1] && game[1][1] == game[2][1] && game[0][1] != 0
    ) {
      winning = true;
    }
    if (
      game[0][2] == game[1][2] && game[1][2] == game[2][2] && game[0][2] != 0
    ) {
      winning = true;
    }

    // Checking for diagonals
    if (
      game[0][0] == game[1][1] && game[1][1] == game[2][2] && game[0][0] != 0
    ) {
      winning = true;
    }
    if (
      game[0][2] == game[1][1] && game[1][1] == game[2][0] && game[0][2] != 0
    ) {
      winning = true;
    }

    return winning;
  }

  /// 1 represent X

  /// 2 represent O

  public static void main(String[] args) {
    int[][] game = new int[3][3];
    Arrays.fill(game[0], 0);
    Arrays.fill(game[1], 0);
    Arrays.fill(game[2], 0);
    displayGame(game);

    System.out.println();

    System.out.println("The game has started please make moves!");
    System.out.println("First Player will be Marked as 'O' ");
    System.out.println("Second Player will be marked as 'X' ");

    boolean playerChance = false;

    // If playerChance if false, Its player 1 chance, otherwise its Player 2 Chance!!!
    Scanner s = new Scanner(System.in);

    System.out.println("This is the winning position " + checkWinning(game));

    while (checkWinning(game) == false) {
      if (playerChance == false) {
        // Its Player 1 Chance
        System.out.println("First Player Chance");

        int a = s.nextInt() - 1;
        int b = s.nextInt() - 1;

        while (game[a][b] != 0) {
          System.out.println(
            "This move is invalid!, Please enter a valid Move"
          );
          a = s.nextInt() - 1;
          b = s.nextInt() - 1;
        }

        makeMove(game, a, b, "O");
        if (checkWinning(game)) break;
        displayGame(game);

        playerChance = !playerChance;
      }
      if (playerChance == true) {
        // Its Player 1 Chance
        System.out.println("Second Player Chance");
        int a = s.nextInt() - 1;
        int b = s.nextInt() - 1;

        while (game[a][b] != 0) {
          System.out.println(
            "This move is invalid!, Please enter a valid Move"
          );
          a = s.nextInt() - 1;
          b = s.nextInt() - 1;
        }
        makeMove(game, a, b, "X");
        if (checkWinning(game)) break;
        displayGame(game);
        playerChance = !playerChance;
      }
    }
    displayGame(game);
    System.out.println("The Game is finished!!!!");

    if (!playerChance) {
      System.out.println("First Player Wins, Congratulations");
    } else System.out.println("Second Player wins");
    s.close();
  }
}
