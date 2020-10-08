package com.bridgelabz.workshop;

import java.util.Scanner;

public class TicTacToeGame {
	private static final int HEAD = 0;
	private static final int TAIL = 1;

	enum Player {
		USER, COMPUTER;
	}

	/**
	 * uc1
	 * 
	 * @return
	 */
	public static char[] createBoard() {
		char[] board = new char[10];
		for (int i = 0; i < 10; i++) {
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
		for (int cell = 0; cell < 9; cell++) {
			if (cell == 3 || cell == 6)
				System.out.println("\n");
			if (cell == 2 || cell == 5 || cell == 8)
				System.out.print(board[cell]);
			else
				System.out.print(board[cell] + " |");
		}
		System.out.print("\n");
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

	public static void main(String[] args) {
		char board[] = createBoard();
		Scanner scannerObject = new Scanner(System.in);
		System.out.println("Player please choose a letter X OR O ");
		char playerLetter = scannerObject.next().charAt(0);
		char computerLetter = chooseLetter(playerLetter);
		showBoard(board);
		if (whoWinToss() == Player.USER) {
			int desiredLocation = findPostitionWhichIsFree(board, playerLetter);
			makeMove(board, playerLetter, desiredLocation);
		} else {
			int desiredLocation = findPostitionWhichIsFree(board, computerLetter);
			makeMove(board, computerLetter, desiredLocation);
		}

	}
}
