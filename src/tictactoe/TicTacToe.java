package tictactoe;

import java.lang.reflect.Array;
import java.util.*;
public class TicTacToe {
	static int turn = 0;
	public static boolean gameDone = false;
	public static int[][] coords = new int[18][2];
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
			int[] compInput = computerInput();

			//render grid

			while (displayGrid(input[0], input[1], true)) {
				input = getInput();

			}
			if (gameDone == false) {
				System.out.println("My turn now:");
				boolean t;
				while (t = displayGrid(compInput[0], compInput[1], false)) {
					compInput = computerInput();

				}
			}

		}

	}
	public static boolean displayGrid(int x, int y, boolean p1Turn) {
		//Hashtable of co-ords on the grid - to be rendered/interpreted:





		//interpret grid here:

		//here i use 3x3 because a tictactoe grid will always be in these dimensions.
		if (x <= 3) x -= 1;

		if (y == 3) y = 5;

		if ((y % 2 == 0)) y += 1;


		coords[turn] = new int[] {x, y};
		//update grid

		if (renderableGrid[y][x].contains("X") == false && renderableGrid[y][x].contains("O") == false ) {

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
				switch (x) {
				case 0:
					renderableGrid[y][x] = " O|";
					break;
				case 1:
					renderableGrid[y][x] = "  O|";
					break;
				case 2:
					renderableGrid[y][x] = "  O|";
					break;
				default:
					break;
				}
			}
		} else {
			if (p1Turn) System.out.println("Space is already occupied!");
			return true;
		}
		//render grid
		for (String[] gridY: renderableGrid) {
			for (String square: gridY) {


				System.out.print(square);
			}
			System.out.println();
		}
		//gets whichever is true
		gameDone = (checkTie() || checkWin());
		turn++;
		return false;
	}

	public static int[] getInput() {
		while (true) {
			try {
				int[] coordsInput = new int[2];
				do {
					Scanner in = new Scanner(System.in);
					
					System.out.print("\nEnter y coordinate (1,1) is top left: ");
					coordsInput[1] = in.nextInt();
					System.out.print("Enter x coordinate: ");
					coordsInput[0] = in.nextInt();

				} while ((coordsInput[0] < 0 || coordsInput[1] < 0) || (coordsInput[0] > 3 || coordsInput[1] >= 3));

				turn++;
				return coordsInput;
			} catch (Exception e) {
				continue;
			}
		}

	}

	public static int[] computerInput() {
		Random rand = new Random();
		int[] compCoords = {(int) (1 + Math.random() * 3), rand.nextInt(4)};
		System.out.println(Arrays.toString(compCoords));
		return compCoords;
	}
	public static boolean checkTie() {
		//checks for tie
		for (String[] gridY: renderableGrid) {
			for (String square: gridY) {
				if (square == "   |") {
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
