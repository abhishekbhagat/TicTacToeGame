package com.bridgelabz.workshop;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
	private static final int HEAD = 0;
	private static final int TAIL = 1;

	enum Player {
		USER, COMPUTER;
	}

	public static char[] createBoard() {
		char[] board = new char[10];
		for (int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
		return board;
	}

	/**
	 * uc2
	 * 
	 * @param playerLetter
	 * @return
	 */
	public static char chooseLetter(char playerLetter) {
		char computerLetter;
		if (playerLetter == 'X')
			computerLetter = 'O';
		else
			computerLetter = 'X';
		return computerLetter;
	}

	/**
	 * uc3
	 * 
	 * @param board
	 */
	public static void showBoard(char board[]) {
		System.out.println(board[1] + " |" + board[2] + " |" + board[3]);
		System.out.println("--------");
		System.out.println(board[4] + " |" + board[5] + " |" + board[6]);
		System.out.println("--------");
		System.out.println(board[7] + " |" + board[8] + " |" + board[9]);
	}

	/**
	 * uc4
	 * 
	 * @param board
	 * @param userIndex
	 * @param playerLetter
	 * @return
	 */
	public static int findPostitionWhichIsFree(char board[], char playerLetter) {
		int selectedIndex;
		while (true) {
			Scanner desiredLocation = new Scanner(System.in);
			System.out.println("Enter desired location in the board");
			selectedIndex = desiredLocation.nextInt();
			if (board[selectedIndex] == ' ') {
				break;
			}
		}
		return selectedIndex;
	}

	/**
	 * uc5
	 * 
	 * @param board
	 * @param playerLetter
	 */
	public static void makeMove(char board[], char letter, int selectedIndex) {
		board[selectedIndex] = letter;
	}

	/**
	 * uc6
	 * 
	 * @return
	 */
	public static Player whoWinToss() {
		if ((int) Math.floor((Math.random() * 10) % 2) == HEAD)
			return Player.USER;
		else
			return Player.COMPUTER;

	}

	/**
	 * uc7
	 * 
	 * @param board
	 * @param userLetter
	 */
	public static String checkIsPlayerWinOrNot(char board[], char playerLetter) {
		if (checkRow(board, playerLetter) || checkColumn(board, playerLetter) || checkDiagonal(board, playerLetter))
			return "win";
		for (int cell = 1; cell < 10; cell++) {
			if (board[cell] == ' ')
				return "changeTurn";
		}
		return "tie";
	}

	public static boolean checkRow(char board[], char playerLetter) {
		if ((board[1] == playerLetter && board[2] == playerLetter && board[3] == playerLetter)
				|| (board[4] == playerLetter && board[5] == playerLetter && board[6] == playerLetter)
				|| (board[7] == playerLetter && board[8] == playerLetter && board[9] == playerLetter))
			return true;
		return false;
	}

	public static boolean checkColumn(char board[], char playerLetter) {
		if ((board[1] == playerLetter && board[4] == playerLetter && board[7] == playerLetter)
				|| (board[3] == playerLetter && board[6] == playerLetter && board[9] == playerLetter)
				|| (board[2] == playerLetter && board[5] == playerLetter && board[8] == playerLetter))
			return true;
		return false;
	}

	public static boolean checkDiagonal(char board[], char playerLetter) {
		if ((board[1] == playerLetter && board[5] == playerLetter && board[9] == playerLetter)
				|| (board[3] == playerLetter && board[5] == playerLetter && board[7] == playerLetter))
			return true;
		else
			return false;
	}

	/**
	 * uc8
	 * 
	 * @param board
	 * @param playerLetter
	 * @return
	 */
	public static int findWiningPosition(char board[], char playerLetter) {
		int winingPosition = -1;
		for (int cell = 1; cell < 10; cell++) {
			if (board[cell] == ' ') {
				board[cell] = playerLetter;
				if (checkIsPlayerWinOrNot(board, playerLetter).contains("win")) {
					winingPosition = cell;
					board[cell] = ' ';
					break;
				}
				board[cell] = ' ';
			}
		}
		return winingPosition;
	}

	/**
	 * uc9
	 * 
	 * @param board
	 * @param playerLetter
	 * @return
	 */
	public static int findBlockPostion(char board[], char playerLetter) {

		if (playerLetter == 'X')
			return (findWiningPosition(board, 'O'));
		else
			return (findWiningPosition(board, 'X'));
	}

	/**
	 * uc10
	 * 
	 * @param board
	 * @return
	 */
	public static int findAvailableCorners(char board[]) {
		if (board[1] == ' ')
			return 1;
		else if (board[3] == ' ')
			return 3;
		else if (board[7] == ' ')
			return 7;
		else if (board[9] == ' ')
			return 9;
		else
			return -1;
	}

	/**
	 * uc11
	 * 
	 * @param board
	 * @return
	 */
	public static int mySubsequentChoices(char board[]) {
		int center = 5;
		int freeCell[] = { 2, 4, 6, 8 };
		if (board[center] == ' ')
			return center;
		for (int freeCellIndex = 0; freeCellIndex < 4; freeCellIndex++) {
			if (freeCell[freeCellIndex] == ' ')
				return freeCellIndex;
		}
		return -1;
	}

	/**
	 * uc12
	 * 
	 * @param board
	 * @param userLetter
	 * @param computerLetter
	 * @return
	 */
	public static boolean gameIsOver(char board[], char playerLetter) {
		if (checkIsPlayerWinOrNot(board, playerLetter).contains("tie"))
			return true;
		return false;

	}

	public static void main(String[] args) {
		char board[] = createBoard();
		Scanner scannnerLetterObject = new Scanner(System.in);
		System.out.println("Player please choose a letter X OR O ");
		char userLetter = scannnerLetterObject.next().charAt(0);
		char computerLetter = chooseLetter(userLetter);
		String player = "";
		if (whoWinToss() == Player.USER)
			player = "user";
		else
			player = "computer";
		while (true) {
			System.out.println("\n");
			showBoard(board);
			char playerLetter;
			if (player.equals("user"))
				playerLetter = userLetter;
			else
				playerLetter = computerLetter;
			int winingPosition = findWiningPosition(board, playerLetter);
			if (winingPosition != -1) {
				makeMove(board, playerLetter, winingPosition);
				if (checkIsPlayerWinOrNot(board, playerLetter).contains("win")) {
					System.out.println("");
					showBoard(board);
					System.out.println(player + " win ");
					break;
				}
			} else if (findBlockPostion(board, playerLetter) != -1) {

				makeMove(board, playerLetter, findBlockPostion(board, playerLetter));
			} else {
				int availableCornerPosition = findAvailableCorners(board);
				if (availableCornerPosition != -1)
					makeMove(board, playerLetter, availableCornerPosition);
				else if (mySubsequentChoices(board) != -1)
					makeMove(board, playerLetter, mySubsequentChoices(board));
				else {
				}
			}
			if (gameIsOver(board, playerLetter))
				break;
			if (player.equals("user"))
				player = "computer";
			else
				player = "user";
		}
	}

}
