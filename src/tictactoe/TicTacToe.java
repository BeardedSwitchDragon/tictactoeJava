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
		
		
		
		
		x = 2;
		y = 1;
		//interpret grid here:
		
		//here i use 3x3 because a tictactoe grid will always be in these dimensions.
		if (y < 2 && x < 2) {
			x += 1;
			y += 1;
		} else if ( y > 2) {
			//(2 is equiv. to 3 i.e the edge of the grid)
			//i use 2 instead of y in case someone puts higher than 2, same for x.
			coords[turn] = new int[] {x, 2};
		} else if ( x > 2) {
			x = 2;
			
		} else if (y <= 0) {
			y = 1;
		}
		else {
			x = 2;
			y = 2;
		}
		
		coords[turn] = new int[] {x, y};
		//update grid
		int[] newCoords = coords[turn];
		
		
		if (p1Turn) {
			
			renderableGrid[newCoords[1]][newCoords[0]] = " X|";
		} else {
			renderableGrid[newCoords[1]][newCoords[0]] = " O|";
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
		System.out.println("Enter x coordinate (0,0) is top left:");
		coordsInput[0] = in.nextInt();
		System.out.println("Enter y coordinate:");
		coordsInput[1] = in.nextInt();
		turn++;
		return coordsInput;
	}
	
}
