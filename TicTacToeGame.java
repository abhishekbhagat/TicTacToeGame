package com.bridgelabz.workshop;

import java.util.Scanner;

public class TicTacToeGame {
	private char[] board;

	// uc1 method
	public static void createBoard() {
		char[] board = new char[10];
		for (int i = 0; i < 10; i++) {
			board[i] = ' ';
		}

	}

	public static void main(String[] args) {
		createBoard();

	}

}
