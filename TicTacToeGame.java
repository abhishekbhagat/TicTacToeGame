package com.bridgelabz.workshop;

import java.util.Arrays;
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

	/**
	 * uc7
	 * 
	 * @param board
	 * @param userLetter
	 */
	public static boolean checkIsPlayerWinOrNot(char board[], char playerLetter) {
		if (checkRow(board, playerLetter) || checkColumn(board, playerLetter) || checkDiagonal(board, playerLetter))
			return true;
		else
			return false;
	}

	public static boolean checkRow(char board[], char playerLetter) {
		if ((board[0] == playerLetter && board[1] == playerLetter && board[2] == playerLetter)
				|| (board[3] == playerLetter && board[4] == playerLetter && board[5] == playerLetter)
				|| (board[6] == playerLetter && board[7] == playerLetter && board[8] == playerLetter))
			return true;
		return false;
	}

	public static boolean checkColumn(char board[], char playerLetter) {
		if ((board[0] == playerLetter && board[3] == playerLetter && board[6] == playerLetter)
				|| (board[1] == playerLetter && board[4] == playerLetter && board[7] == playerLetter)
				|| (board[1] == playerLetter && board[4] == playerLetter && board[7] == playerLetter))
			return true;
		else
			return false;
	}

	public static boolean checkDiagonal(char board[], char playerLetter) {
		if ((board[0] == playerLetter && board[4] == playerLetter && board[8] == playerLetter)
				|| (board[2] == playerLetter && board[4] == playerLetter && board[6] == playerLetter))
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
		for (int cell = 0; cell < 9; cell++) {
			if (board[cell] == ' ') {
				board[cell] = playerLetter;
				if (checkIsPlayerWinOrNot(board, playerLetter)) {
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

	public static int findAvailableCorners(char board[]) {
		if (board[0] == ' ')
			return 0;
		else if (board[2] == ' ')
			return 2;
		else if (board[6] == ' ')
			return 6;
		else if (board[8] == ' ')
			return 8;
		else
			return -1;
	}

	public static void main(String[] args) {
		char board[] = createBoard();
		Scanner scannnerLetterObject = new Scanner(System.in);
		System.out.println("Player please choose a letter X OR O ");
		char userLetter = scannnerLetterObject.next().charAt(0);
		char computerLetter = chooseLetter(userLetter);
		showBoard(board);
		if (whoWinToss() == Player.USER) {
			int winingPosition = findWiningPosition(board, userLetter);
			if (winingPosition != -1) {
				makeMove(board, userLetter, winingPosition);
				if (checkIsPlayerWinOrNot(board, userLetter))
					System.out.println("Player Won");
			} else if (findBlockPostion(board, userLetter) != -1) {

				makeMove(board, userLetter, findBlockPostion(board, userLetter));
			} else {
				int availableCornerPosition = findAvailableCorners(board);
				if (availableCornerPosition != -1)
					makeMove(board, userLetter, availableCornerPosition);
				int desiredLocation = findPostitionWhichIsFree(board, userLetter);
				makeMove(board, userLetter, desiredLocation);
				if (checkIsPlayerWinOrNot(board, userLetter))
					System.out.println("Player Won");
			}
		} else {
			int desiredLocation = findPostitionWhichIsFree(board, computerLetter);
			makeMove(board, computerLetter, desiredLocation);
			if (checkIsPlayerWinOrNot(board, computerLetter))
				System.out.println("Computer won ");
		}

	}
}
