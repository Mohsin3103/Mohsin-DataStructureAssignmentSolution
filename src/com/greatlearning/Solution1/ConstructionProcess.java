package com.greatlearning.Solution1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class ConstructionProcess {

	public static void main(String[] args) throws InputMismatchException {
		try {
			// Initializing scanner
			Scanner sc = new Scanner(System.in);

			// Input for Number of floors
			System.out.println("Enter the total no of floors in the building");
			int NoOfFloors = sc.nextInt();

			// Input for Unique floor size day wise
			int[] FloorSize = new int[NoOfFloors];
			for (int i = 0; i < NoOfFloors; i++) {
				System.out.println("Enter the floor size given on day: " + (i + 1));
				FloorSize[i] = sc.nextInt();
				for (int k = 0; k < i; k++) {
					// Check for duplicate USer Input
					if (FloorSize[k] == FloorSize[i]) {
						System.out.println("Only Unique values are allowed, please try again.");
						System.exit(0);
						// Exiting the program since duplicate user inputs are not accepted.
					}

				}
			}

			sc.close();

			// Creating copy of FloorSize array in Ascending order.
			int[] SortedFloorSize = Arrays.copyOf(FloorSize, FloorSize.length);
			Arrays.sort(SortedFloorSize);

			//Pushing the sorted array into stack in order to create a stack with max size on top 
			Stack<Integer> FloorSizeStack = new Stack<Integer>();
			for (int i : SortedFloorSize) {
				FloorSizeStack.push(i);
			}
			
			System.out.println("The order of construction is as follows");
			Stack<Integer> tempStack = new Stack<Integer>();

			for (int i = 0; i < NoOfFloors; i++) {
				System.out.println("Day: " + (i + 1));
				int floorSizeOfTheDay = FloorSize[i];

				int largestFloorSize = FloorSizeStack.peek();
				

				if (floorSizeOfTheDay != largestFloorSize) {
					tempStack.push(floorSizeOfTheDay);
				} else {
					

					System.out.print(FloorSizeStack.pop() + " ");
					
					while (!tempStack.isEmpty() && (int) FloorSizeStack.peek() == (int) tempStack.peek()) {
						System.out.print(FloorSizeStack.pop() + " ");
						tempStack.pop();
					}
				}
				System.out.println("");
			}
		}

		catch (InputMismatchException e) {
			System.out.println("Incorrect Input!! Please enter valid value.\n");
		}
	}
}
