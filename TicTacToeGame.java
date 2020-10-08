package com.bridgelabz.workshop;

import java.util.Scanner;

public class TicTacToeGame {

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
		while (true) {
			Scanner desiedLocation = new Scanner(System.in);
			System.out.println("Enter desired location in the board");
			int selectedIndex = desiedLocation.nextInt();
			if (board[selectedIndex] == ' ') {
				return selectedIndex;
			}
		}
	}

	public static void main(String[] args) {
		char board[] = createBoard();
		Scanner scannerObject = new Scanner(System.in);
		System.out.println("Player please choose a letter X OR O ");
		char playerLetter = scannerObject.next().charAt(0);
		char computerLetter = chooseLetter(playerLetter);
		showBoard(board);
		findPostitionWhichIsFree(board, playerLetter);

	}
}
