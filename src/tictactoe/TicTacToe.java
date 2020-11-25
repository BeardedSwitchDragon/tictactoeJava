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
		if (x <= 3) {
			x -= 1;
		}
		if ((y % 2 == 0)) {
			y += 1;
		}
		
		coords[turn] = new int[] {x, y};
		//update grid
		
		
		
		if (p1Turn) {
			
			renderableGrid[y][x] = " X|";
		} else {
			renderableGrid[y][x] = " O|";
		}
		//render grid
		for (String[] gridY: renderableGrid) {
			for (String gridX: gridY) {
				
				
				System.out.print(gridX);
			}
			System.out.println();
		}
		turn++;
	}
	
	public static int[] getInput() {
		int[] coordsInput = new int[2];
		Scanner in = new Scanner(System.in);
		System.out.println("Enter x coordinate (1,1) is top left:");
		coordsInput[0] = in.nextInt();
		System.out.println("Enter y coordinate:");
		coordsInput[1] = in.nextInt();
		turn++;
		return coordsInput;
	}
	
}
