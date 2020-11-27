package tictactoe;

import java.lang.reflect.Array;
import java.util.*;
public class TicTacToe {
	static int turn = 0;
	public static boolean gameDone = false;
	public static int[][] coords = new int[9][2];
	static String[][] renderableGrid = {
			{"---", " --- ", "---"},
			{"  |", "   |", "   |"},
			{"---", " --- ", "---"},
			{"  |", "   |", "   |"},
			{"---", " --- ", "---"},
			{"  |", "   |", "   |"},
			{"---", " --- ", "---"}
	};
	public static void main(String[] args) {
		//GAME LOOP
		while (gameDone == false) {
			//get input

			int[] input = getInput();

			//render grid
			displayGrid(input[0], input[1], true);

		}

	}
	public static void displayGrid(int x, int y, boolean p1Turn) {
		//Hashtable of co-ords on the grid - to be rendered/interpreted:





		//interpret grid here:

		//here i use 3x3 because a tictactoe grid will always be in these dimensions.
		if (x <= 3) x -= 1;

		if (y == 3) y = 5;

		if ((y % 2 == 0)) y += 1;


		coords[turn] = new int[] {x, y};
		//update grid

		if (renderableGrid[y][x].contains("X") == false || renderableGrid[y][x].contains("O") == false ) {

			if (p1Turn) {

				switch (x) {
				case 0:
					renderableGrid[y][x] = " X|";
					break;
				case 1:
					renderableGrid[y][x] = "  X|";
					break;
				case 2:
					renderableGrid[y][x] = "  X|";
					break;
				default:
					break;
				}

			} else {
				renderableGrid[y][x] = " O|";
			}
		} else {
			System.out.println("Space is already occupied!");
		}
		//render grid
		for (String[] gridY: renderableGrid) {
			for (String square: gridY) {


				System.out.print(square);
			}
			System.out.println();
		}
		gameDone = checkWin();
		turn++;
	}

	public static int[] getInput() {
		int[] coordsInput = new int[2];
		Scanner in = new Scanner(System.in);
		System.out.println("Enter y coordinate (1,1) is top left:");
		coordsInput[1] = in.nextInt();
		System.out.println("Enter x coordinate:");
		coordsInput[0] = in.nextInt();
		turn++;
		return coordsInput;
	}

	public static boolean checkWin() {

		boolean isMatched = true;
		String winner;
		for (String[] gridY: renderableGrid) {
			//check if horizontal win
			for (String square: gridY) {
				//System.out.println(square.contains("X"));
				isMatched = square.contains("X");
			}
			if (isMatched) {
				System.out.println("winner is X");
				return isMatched;
			}



		}
		//check if vertical win
		for (int j = 0; j < 3; j++) {
			for (int i = 1; i < 6; i += 2) {

				isMatched = renderableGrid[i][j].contains("X");
				

				

			}
			if (isMatched) {
				System.out.println("winner is X");
				return isMatched;
			}
		}

		//System.out.println("wpllpl");
		return isMatched;

		
	}



}
