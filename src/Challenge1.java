import java.util.Scanner;

public class Challenge1 {

	private static Scanner scan;

	public static void main(String[] args) {
		System.out.print(averager());
	}

	public static int averager() {
		System.out.println("enter heading");
		scan = new Scanner(System.in);
		int sum = 0, count = 0, x = scan.nextInt();
		while (x != -1) {
			sum += x;
			count++;
			System.out.println("enter heading, enter -1 to quit");
			x = scan.nextInt();
		}
		return (sum / count);
	}
}