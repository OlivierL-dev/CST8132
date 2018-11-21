/*
 * Name: Olivier Lauzon
 * Student ID: 040918796
 * Course & Section: CST8132 303
 * Assignment: Lab 2
 * Date: Sept 17, 2018
 */
public class ExerciseTwo {

	// we initialize the array that we will use
	int[][] myArray;

	// this is the method which creates a new object of ExerciseOne and runs the
	// printArrayValues and displayArrayProduct methods
	public static void main(String[] args) {
		ExerciseTwo lab2 = new ExerciseTwo();
		lab2.printArrayValues();
		lab2.displayArrayTotal();
	}

	// this is the constructor which creates an iteration of myArray and fills it
	public ExerciseTwo() {
		this.myArray = new int[6][10];
		for (int i = 0; i < myArray.length; i++) {
			for (int j = 0; j < myArray[i].length; j++) {
				myArray[i][j] = (i * 10) + (j + 1);
			}
		}
	}

	// this method runs through each index of the array and prints its value
	public void printArrayValues() {
		System.out.println("myArray = {");
		for (int i = 0; i < myArray.length; i++) {
			System.out.print("{");
			for (int j = 0; j < myArray[i].length; j++) {
				System.out.print(myArray[i][j]);
				if (j < (myArray[i].length - 1)) {
					System.out.print(",");
				}
			}
			System.out.print("}");
			if (i < (myArray.length - 1)) {
				System.out.println(",");
			}
		}
		System.out.println("\n};");
	}

	// this method finds the sum of all the values in the array
	public void displayArrayTotal() {
		int sum = 0;
		for (int[] i : myArray) {
			for (int j : i) {
				sum += j;
			}
		}
		System.out.print("The sum of all elements of myArray is " + sum + ".");
	}
}