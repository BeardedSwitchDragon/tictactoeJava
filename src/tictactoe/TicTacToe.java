package tictactoe;

import java.lang.reflect.Array;


import java.util.*;
public class TicTacToe {
	static int turn = 0;
	public static boolean gameDone = false;
	public static int[][] coords = new int[18][2];
	static String[][] renderableGrid = {
			{"---", " --- ", "---"},
			{"a  |", "b  |", "c  |"},
			{"---", " --- ", "---"},
			{"d  |", "e  |", "f  |"},
			{"---", " --- ", "---"},
			{"g  |", "h  |", "i  |"},
			{"---", " --- ", "---"}

	};
	public static void main(String[] args) {
		System.out.println("Welcome to tic-tac-toe! I'm O and you're X!");
		System.out.println("Enter a valid input, or you'll be prompted again. \n");
		
		printGrid();
		//GAME LOOP
		
		while (gameDone == false) {
			//get input
			
			
			String input = getInput();
			

			//render grid


			while (displayGrid(input, true)) {
				
				input = getInput();
				

			}
			gameDone = (checkWin() || checkTie());
			
			computerInput();

		}

	}
	
	public static void printGrid() {
		for (String[] gridY: renderableGrid) {
			for (String square: gridY) {


				System.out.print(square);
			}
			System.out.println();
		}
	}
	public static boolean displayGrid(CharSequence squareLetter, boolean p1Turn) {
		//Hashtable of co-ords on the grid - to be rendered/interpreted:
		int x = 0;
		int y = 0;



		//interpret grid here:
		
		
		for (int i = 0; i < renderableGrid.length; i++) {
			
			for (int j = 0; j < renderableGrid[i].length; j++) {
				String square = renderableGrid[i][j];
		
				if (square.contains(squareLetter + " ") || square.contains((squareLetter + " ").toUpperCase()) ) {
					y = i;
					x = j;
				} 
			}
		}
		
		
		
		renderableGrid[y][x] = "X  |";
		printGrid();
		//here i use 3x3 because a tictactoe grid will always be in these dimensions.

		//update grid



		//render grid
		
		//gets whichever is true

		
		turn++;
		return false;
	}

	public static String getInput() {
		while (true) {
			try {
				int[] coordsInput = new int[2];
				String spaceInput;
				do {
					Scanner in = new Scanner(System.in);

					System.out.print("select grid space using letter: ");
					spaceInput = in.next();
					System.out.println();

				} while ((Arrays.deepToString(renderableGrid).contains(spaceInput) == false) || (Arrays.deepToString(renderableGrid).contains(spaceInput.toLowerCase()) == false));

				turn++;
				return spaceInput;
			} catch (Exception e) {
				System.out.println("invalid input.");
				continue;
			}
		}

	}

	public static void computerInput() {
		Random rand = new Random();
		int[] compCoords = new int[2];
		do {

			int[] possibleY = {1, 3, 5};
			compCoords[0] = possibleY[(int) (rand.nextInt(3))];
			compCoords[1] = (int) (rand.nextInt(3));
		} while ((renderableGrid[compCoords[0]][compCoords[1]].contains("X")) || ((renderableGrid[compCoords[0]][compCoords[1]].contains("O"))));
		if (gameDone == false) {
			System.out.println("My turn now: \n");
			renderableGrid[compCoords[0]][compCoords[1]] = "O  |";
			printGrid();
		}
		

	}
	public static boolean checkTie() {
		//checks for tie
		for (String[] gridY: renderableGrid) {
			for (String square: gridY) {
				if (((square.contains("X  |") == false) && (square.contains("O  |") == false)) && (square.contains("-") == false)) {
					
					return false;
				}
			}
		}
		System.out.println("Aw man, it's a tie!!");
		return true;
	}

	public static boolean checkWin() {

		boolean isMatchedX = false;
		boolean isMatchedO = false;

		String winner;
		for (String[] gridY: renderableGrid) {
			//check if horizontal win
			for (String square: gridY) {
				//System.out.println(square.contains("X"));

				//this block of code replaced 'isMatchedX = square.contains("X")' [
				if (square.contains("X") && isMatchedO == false) {
					isMatchedX = true;


				} else if (square.contains("O") && isMatchedX == false){
					isMatchedO = true;


				} else {
					isMatchedO = false;
					isMatchedX = false;
					break;
				}
				//]


			}
			if (isMatchedX) {
				System.out.println("winner is X horizontally");
				return true;
			} else if (isMatchedO) {
				System.out.println("winner is O horizontally");
				return true;
			}



		}
		//check if vertical win
		for (int j = 0; j < 3; j++) {
			for (int i = 1; i < 6; i += 2) {

				//this block of code replaced 'isMatchedX = renderableGrid[i][j].contains("X")' [
				if (renderableGrid[i][j].contains("X") && isMatchedO == false) {
					isMatchedX = true;

				} else if (renderableGrid[i][j].contains("O") && isMatchedX == false){
					isMatchedO = true;

				} else {
					isMatchedO = false;
					isMatchedX = false;
					break;
				}


			}
			if (isMatchedX) {
				System.out.println("winner is X vertically");
				return true;
			} else if (isMatchedO) {
				System.out.println("winner is O vertically");
			}
		}
		//diagonal win
		if ((renderableGrid[1][2].contains("X") && renderableGrid[3][1].contains("X") && renderableGrid[5][0].contains("X")) ||
				(renderableGrid[1][0].contains("X") && renderableGrid[3][1].contains("X") && renderableGrid[5][2].contains("X"))) {

			System.out.println("Winner is X diagonally");
			return true;
		}else if ((renderableGrid[1][2].contains("O") && renderableGrid[3][1].contains("O") && renderableGrid[5][0].contains("O")) ||
				(renderableGrid[1][0].contains("O") && renderableGrid[3][1].contains("O") && renderableGrid[5][2].contains("O"))) {

			System.out.println("Winner is O diagonally");
			return true;
		}

		//System.out.println("wpllpl");
		return false;


	}



}
