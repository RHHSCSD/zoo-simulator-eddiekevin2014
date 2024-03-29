package zoosim;

import java.io.*;
import java.util.Scanner;

/**
 * Main Class of Zoo Simulator
 */
public class ZooSim {
	/**
 	 * Main method of Zoo Simulator
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// Zoo object
		Zoo myZoo = new Zoo();

		// print welcome
		System.out.println("---------------------");
		System.out.println("Welcome to to MY ZOO!");
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Select a number of menu to START. Enjoy!");
		System.out.println();
		// input
		Scanner scan = new Scanner(System.in);
		boolean play = true;
		int num = 0;
		while (play) {
			// print menu
			System.out.println("1. Display Animal Summary");
			System.out.println("2. Display Animal Details");
			System.out.println("3. Display Object Summary");
			System.out.println("4. Display Object Details");
			System.out.println("5. Display Hungry Animals");
			System.out.println("6. Display Tired Animals");
			System.out.println("7. Feed Hungry Animals");
			System.out.println("8. Let Tired Animals Sleep");
			System.out.println("9. Move Animals");
                        System.out.println("10. Turn Land Animals");
                        System.out.println("11. Turn Bird Animals");
                        System.out.println("12. Turn Water Animals");
                        System.out.println("0. Exit");
			// proceed selected option
			if (scan.hasNextInt()) {
				num = scan.nextInt();
				switch (num) {
				case 1:
					myZoo.listAnimals();
					break;
				case 2:
					myZoo.displayAnimals();
					break;
				case 3:
					myZoo.listObjects();
					break;
				case 4:
					myZoo.displayObjects();
					break;
				case 5:
					myZoo.listHungryAnimals();
					break;
				case 6:
					myZoo.listTiredAnimals();
					break;
				case 7:
					myZoo.feedHungryAnimals();
					break;
				case 8:
					myZoo.restTiredAnimals();
					break;
				case 9:
					myZoo.moveAnimals();
					break;
				case 0:
					play = false;
					break;
                                case 10:
                                        myZoo.turnLandAnimals();
                                        break;
                                case 11:
                                        myZoo.turnBirdAnimals();
                                        break;
                                case 12:
                                        myZoo.turnWaterAnimals();
                                        break;
                                }
			} else {
				System.out.println();
				System.out.println("WRONG INPUT!");
				scan.nextLine();
			}
			// continue

			if (play) {
				System.out.println("------------------------------------");
				System.out.println("Select a number of menu to CONTINUE.");
				System.out.println();
			}
		}
		// close
		scan.close();
		System.out.println();
		System.out.println("Goodbye!");

	}

}
