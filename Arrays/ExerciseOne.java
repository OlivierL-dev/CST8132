
/*
 * Name: Olivier Lauzon
 * Student ID: 040918796
 * Course & Section: CST8132 303
 * Assignment: Lab 2
 * Date: Sept 17, 2018
 */
import java.text.DecimalFormat;

public class ExerciseOne {
	// we initialize the array that we will use
	private int myArray[];

	// this is the method which creates a new object of ExerciseOne and runs the
	// printArrayValues and displayArrayProduct methods
	public static void main(String[] args) {
		ExerciseOne lab2 = new ExerciseOne();
		lab2.printArrayValues();
		lab2.displayArrayProduct();
	}

	// this is the constructor which creates an iteration of myArray and fills it
	public ExerciseOne() {
		this.myArray = new int[10];
		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = i + 1;
		}
	}

	// this method runs through each index of the array and prints its value
	public void printArrayValues() {
		System.out.print("myArray = {");
		for (int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i]);
			if (i < (myArray.length - 1)) {
				System.out.print(",");
			}
		}
		System.out.println("};");
	}

	// this method finds the product of all the values in the array
	public void displayArrayProduct() {
		DecimalFormat df = new DecimalFormat("###,###,###");
		int product = 1;
		for (int i : myArray) {
			product *= i;
		}
		System.out.print("The product of all elements of myArray is " + df.format(product) + ".");
	}

}