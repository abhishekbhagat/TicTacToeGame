package com.bridgelabz.workshop;

import java.util.Scanner;

public class TicTacToeGame {

	public static void createBoard() {
		char[] board = new char[10];
		for (int i = 0; i < 10; i++) {
			board[i] = ' ';
		}

	}

	public static char chooseLetter(char playerLetter) {
		char computerLetter;
		if (playerLetter == 'X')
			computerLetter = 'O';
		else
			computerLetter = 'X';
		return computerLetter;
	}

	public static void main(String[] args) {
		createBoard();
		Scanner letter = new Scanner(System.in);
		System.out.println("Player please choose a letter X OR O ");
		char playerLetter = letter.next().charAt(0);
		char computerLetter=chooseLetter(playerLetter);
	}

}
