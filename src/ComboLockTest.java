import java.util.*;

/**
 * Tester for class ComboLock
 * @author McKayla
 *
 */
public class ComboLockTest {
	/**Example of a correctly used ComboLock:
	 * ComboLock lock = new ComboLock(17, 25, 10);
	 * lock.turnLeft(22);
	 * lock.turnRight(8);
	 * lock.turnLeft(15);
	 * lock.open(); **/
	public static void main(String args[]) {
		
		
		System.out.println("This is a simulation of a combination lock. You can "
				+ "\nopen the lock by correctly entering the amount of numbers to "
				+ "\nspin through to get to your target combination numbers. "
				+ "\nRemember that combination locks only go from 0-39, and will "
				+ "\nspin to the left first, then right, then left again.");
		System.out.println(" ");
		System.out.println("Enter 3 numbers one by one, hitting enter after each "
				+ "number, to create your combination. ");
		Scanner in = new Scanner(System.in);
		int number1 = in.nextInt();
		int number2 = in.nextInt();
		int number3 = in.nextInt();
		ComboLock lock = new ComboLock(number1, number2, number3);
		System.out.println("Attempt to open the lock. Enter how many numbers"
				+ "\nleft you want to turn from the current position, which is 0, "
				+ "\nto reach the first number in your combination.");
		int spin1 = in.nextInt();
		lock.turnLeft(spin1);
		System.out.println("Enter how many numbers right you want to turn from"
				+ "\nthe current position of the lock to reach the next number.");
		int spin2 = in.nextInt();
		lock.turnRight(spin2);
		System.out.println("Enter how many numbers left you want to turn from"
				+ "\nthe current position of the lock to reach the next number.");
		int spin3 = in.nextInt();
		lock.turnLeft(spin3);
		in.close();
		lock.open();
		
		
		
		
	}
}