package com.bridgelabz.workshop;

import java.util.Scanner;

public class TicTacToeGame {

	public static char[] createBoard() {
		char[] board = new char[10];
		for (int i = 0; i < 10; i++) {
			board[i] = ' ';
		}
		return board;
	}

	public static char chooseLetter(char playerLetter) {
		char computerLetter;
		if (playerLetter == 'X')
			computerLetter = 'O';
		else
			computerLetter = 'X';
		return computerLetter;
	}

	public static void showBoard(char board[]) {
		for (int cell = 0; cell < 9; cell++) {
			if (cell == 3 || cell == 6)
				System.out.println("\n");
			if (cell == 2 || cell == 5 || cell == 8)
				System.out.println(board[cell]);
			else
				System.out.print(board[cell] + " |");
		}
	}

	public static void main(String[] args) {
		char board[] = createBoard();
		Scanner letter = new Scanner(System.in);
		System.out.println("Player please choose a letter X OR O ");
		char playerLetter = letter.next().charAt(0);
		char computerLetter = chooseLetter(playerLetter);
		showBoard(board);
	}

}
