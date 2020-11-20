package tictactoe;

import java.lang.reflect.Array;
import java.util.*;
public class TicTacToe {
	public static void main(String[] args) {
		displayGrid(0,0, false);
		int[] input = getInput();
		System.out.println(Arrays.toString(input));
	}
	public static void displayGrid(int x, int y, boolean p1Turn) {
		//Hashtable of co-ords on the grid - to be rendered/interpreted:
		Hashtable<Integer, Integer> coords = new Hashtable<Integer, Integer>();
		
		//Grid to render:
		String[][] renderableGrid = {
				{"---", " --- ", "---"},
				{"  |", "   |", "   |"},
				{"---", " --- ", "---"},
				{"  |", "   |", "   |"},
				{"---", " --- ", "---"},
				{"  |", "   |", "   |"},
				{"---", " --- ", "---"}
		};
		
		//interpret grid here:
		
		//render grid
		for (String[] gridY: renderableGrid) {
			for (String gridX: gridY) {
				System.out.print(gridX);
			}
			System.out.println();
		}
	}
	
	public static int[] getInput() {
		int[] coordsInput = new int[2];
		Scanner in = new Scanner(System.in);
		System.out.println("Enter x coordinate:");
		coordsInput[0] = in.nextInt();
		System.out.println("Enter y coordinate:");
		coordsInput[1] = in.nextInt();
		
		return coordsInput;
	}
	
}
