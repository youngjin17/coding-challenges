import java.util.ArrayList;
import java.util.Scanner;

public class Challenge2 {
	private static Scanner scan;
	private static int choice;

	public static void main(String[] args) {
		choice = 0;
		scan = new Scanner(System.in);
		do {
			System.out.println("Select an option for notation or enter 4 to quit:\n1. Infix (PEMDAS)\n2. Prefix\n3. Postfix");
			choice = scan.nextInt();
			if (choice > 4 || choice < 1)
				System.out.println("Enter a valid option");
			else if (choice != 4) {
				System.out.println("Enter your equation, use spaces to separate numbers and functions");
				scan.nextLine();
				String[] equation = scan.nextLine().split(" ");
				ArrayList<String> arr = new ArrayList<String>();
				for (int i = 0; i < equation.length; i++)
					arr.add(equation[i]);
				if (choice == 1)
					System.out.println(infix(arr));
				if (choice == 2)
					System.out.println(prefix(arr));
				if (choice == 3)
					System.out.println(postfix(arr));
			}

		} while (choice != 4);
		System.out.println("thanks for using this calculator");
	}

	public static double infix(ArrayList<String> arr) {
		int index = 1;
		while (index < arr.size()) {
			if (arr.get(index).equals("*")) {
				double factor2 = Double.parseDouble(arr.remove(index + 1));
				double factor1 = Double.parseDouble(arr.remove(index - 1));
				double product = factor1 * factor2;
				arr.remove(index - 1);
				arr.add(index - 1, product + "");
				index = 1;
			} else if (arr.get(index).equals("/")) {
				double factor2 = Double.parseDouble(arr.remove(index + 1));
				double factor1 = Double.parseDouble(arr.remove(index - 1));
				double product = factor1 / factor2;
				arr.remove(index - 1);
				arr.add(index - 1, product + "");
				index = 1;
			} else
				index += 2;
		}
		index = 1;
		while (index < arr.size()) {
			if (arr.get(index).equals("+")) {
				double factor2 = Double.parseDouble(arr.remove(index + 1));
				double factor1 = Double.parseDouble(arr.remove(index - 1));
				double product = factor1 + factor2;
				arr.remove(index - 1);
				arr.add(index - 1, product + "");
				index = 1;
			} else if (arr.get(index).equals("-")) {
				double factor2 = Double.parseDouble(arr.remove(index + 1));
				double factor1 = Double.parseDouble(arr.remove(index - 1));
				double product = factor1 - factor2;
				arr.remove(index - 1);
				arr.add(index - 1, product + "");
				index = 1;
			} else
				index += 2;
		}
		return Double.parseDouble(arr.get(0));
	}

	public static double prefix(ArrayList<String> arr) {
		if (arr.size() < 2)
			return Double.parseDouble(arr.get(0));
		ArrayList<String> arrSmall = new ArrayList<String>();
		double factor1 = Double.parseDouble(arr.get(1));
		for (int i = 2; i < arr.size(); i++)
			arrSmall.add(arr.get(i));
		if (arr.get(0).equals("*"))
			return factor1 * prefix(arrSmall);
		else if (arr.get(0).equals("/"))
			return factor1 / prefix(arrSmall);
		else if (arr.get(0).equals("+"))
			return factor1 + prefix(arrSmall);
		else
			return factor1 - prefix(arrSmall);
	}

	public static double postfix(ArrayList<String> arr) {
		int index = 2;
		while (arr.size() > 2) {
			double factor1 = Double.parseDouble(arr.get(index - 2));
			double factor2 = Double.parseDouble(arr.get(index - 1));
			boolean remove = false;
			if (arr.get(index).equals("*")) {
				remove = true;
				arr.add(index - 2, factor1 * factor2 + "");
			} else if (arr.get(index).equals("/")) {
				remove = true;
				arr.add(index - 2, factor1 / factor2 + "");
			} else if (arr.get(index).equals("+")) {
				remove = true;
				arr.add(index - 2, factor1 + factor2 + "");
			} else if (arr.get(index).equals("-")) {
				remove = true;
				arr.add(index - 2, factor1 - factor2 + "");
			}
			if (remove) {
				for (int j = 0; j < 3; j++)
					arr.remove(index - 1);
				index = 2;
			} else
				index++;
		}
		return Double.parseDouble(arr.get(0));
	}
}
