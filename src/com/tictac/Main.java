package com.tictac;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

import static com.tictac.CheckWinner.checkWinner;
import static com.tictac.PrintBoard.printBoard;
import static com.tictac.PrintBoard.setBoard;
import static com.tictac.clearScreen.clrscr;
import javax.sound.sampled.*;
import javax.sound.sampled.TargetDataLine;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.lang.ClassNotFoundException;

public class Main {

    static String[] board;
    static String turn, pl;
    static String p1, p2;
    static Integer x = 0, y = 0;

        public static void main (String[]args) throws ClassNotFoundException, UnsupportedAudioFileException,IOException,LineUnavailableException {
            turn = "X";
            pl = p1;
            int ch = 1;
            int round = 0;
            Scanner in = new Scanner(System.in);
            Scanner win = new Scanner(System.in);
            board = new String[9];
            String winner = null;

            clearScreen c= new clearScreen();
            c.clrscr();
            setBoard();
            Scanner scanner = new Scanner(System.in);
            com.tictac.audio a = new com.tictac.audio();
            a.playAudio("C:\\Users\\sanjana\\Downloads\\sci-fi-voiceclip-961-sound-effect-33605958.wav");

            System.out.println("Welcome to world famous Tic Tac Toe.");
            printBoard();
            System.out.println("Enter the name of Player 1: ");
            Scanner s = new Scanner(System.in);
            String p1 = s.next();
            System.out.println("Enter the name of Player 2: ");
            String p2 = s.next();
            clrscr();
            while (ch == 1) {
                System.out.println(p1 + " vs " + p2);
                while (round > 0) {
                    System.out.println("ROUND " + round);
                    System.out.println("Score:" + p1 + "=" + x + "   " + p2 + "=" + y);
                    break;
                }
                if (round % 2 == 0) {
                    turn = "X";
                    pl = p1;
                } else {
                    turn = "S";
                    pl = p2;
                }

                printBoard();
                System.out.println(
                        pl + " will play first. Enter a slot number between 1-9 to place " + turn + " in:");
                winner = null;
                while (winner == null) {
                    int numInput;
                    try {
                        numInput = in.nextInt();
                        if (!(numInput > 0 && numInput <= 9)) {
                            System.out.println(
                                    "Invalid input. Please re-enter a slot between 1-9");
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(
                                "Invalid input. Please re-enter slot number between 1-9:");
                        break;
                    }

                    if (board[numInput - 1].equals(
                            String.valueOf(numInput))) {
                        board[numInput - 1] = turn;

                        if (turn.equals("X")) {
                            turn = "S";
                        } else {
                            turn = "X";
                        }
                        clrscr();
                        printBoard();
                        winner = checkWinner(p1, p2);
                    } else {
                        System.out.println(
                                "Slot already taken; re-enter slot number:");
                    }
                }


                if (winner != null) {
                    if (winner.equalsIgnoreCase("draw")) {
                        System.out.println(
                                "It's a draw! Thanks for playing.");
                    } else {
                        if (winner.equalsIgnoreCase("X")) {
                            x++;
                            winner = p1;
                        }
                        if (winner.equalsIgnoreCase("S")) {
                            y++;
                            winner = p2;
                        }
                        a.playAudio("C:\\Users\\sanjana\\Downloads\\2PBE8A4-huge-win.wav");
                        System.out.println(
                                "Congratulations! " + winner
                                        + " has won! Thanks for playing.");
                    }
                }
                round++;
                System.out.println("Press 1 to keep Enjoying");
                ch = win.nextInt();
                if (ch == 1) {
                   //com.tictac.clearScreen c = new com.tictac.clearScreen
                    clearScreen cs=new clearScreen();
                    cs.clrscr();
                   setBoard();
        } else{
                    System.out.println("Thank you for playing. Come back soon!!");
                    System.exit(0);
        }
                /*clearScreen c = new clearScreen();
                c.clrscr();*/
            }
        }
    }
