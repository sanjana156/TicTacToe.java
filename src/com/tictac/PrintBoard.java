package com.tictac;
import static com.tictac.Main.board;

public class PrintBoard {
    static void printBoard () {
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
    }

    static void setBoard () {
        // printBoard();
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
    }
}
