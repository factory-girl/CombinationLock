/**
 * Class that constructs a combination lock
 * @author McKayla
 *
 */
public class ComboLock {
	boolean unlocked;
	private int currentPosition;
	private int secret1;
	private int secret2;
	private int secret3;
	private int spinCount;
	private int spin1;
	private int spin2;
	private int spin3;
	
	/**
	 * Constructs combination lock based on a given combination
	 * @param secret1 
	 * first number in combination
	 * @param secret2 
	 * second number in combination
	 * @param secret3 
	 * third number in combination
	 */
	public ComboLock(int secret1, int secret2, int secret3) { 
		unlocked = false;
		this.secret1 = secret1;
		this.secret2 = secret2;
		this.secret3 = secret3;
		spinCount = 0;
		currentPosition = 0;
		
	}
	
	/**
	 * Method resets the lock and unlocking attempts back to 0
	 */
    public void reset() { 
    	unlocked = false;
    	currentPosition = 0;
    	spin1 = 0;
    	spin2 = 0;
    	spin3 = 0;
    	spinCount = 0;
    	
    }
    
    /**
     * Method which turns the combination dial left to reach a 
     * combination number
     * @param ticks 
     * how far to turn the lock
     * @return currentPosition 
     * current position of lock
     */
    public int turnLeft(int ticks) {
    	if ((currentPosition - ticks) < 0) { //If lock is spun past 0
    		int leftover = currentPosition - ticks;
    		leftover = leftover*(-1);
    		currentPosition = 39 - leftover;
    	}
    	else if ((currentPosition - ticks) >= 0) {
    		currentPosition = currentPosition - ticks;
    	}
    	spinAttempt();
    	return currentPosition;
    }
    
    /**
     * Method which turns the combination dial right to reach a number
     * @param ticks the difference between the current position and the current 
     * target number in the combination, as it would occur on a physical
     * combination lock
     * @return currentPosition current position of lock
     */
    public int turnRight(int ticks) {
    	if ((currentPosition + ticks) > 39) { //If the lock is spun past 39
    		currentPosition = currentPosition + ticks;
    		int leftover = currentPosition - 39 ;
    		currentPosition = leftover;
    	}
    	else if ((currentPosition + ticks) <= 39) {
    		currentPosition = currentPosition + ticks;
    	}
    	
    	spinAttempt();
    	return currentPosition;
    }
    
    /**
     * Method that tracks the spin attempts
     */
    public void spinAttempt() {
    	if (spinCount == 0) {
    		spinCount = 1;
    		spin1 = currentPosition;
    	}
    	else if (spinCount == 1) {
    		spinCount = 2;
    		spin2 = currentPosition;
    	}
    	else if (spinCount == 2) {
    		spinCount = 3;
    		spin3 = currentPosition;
    	}
    }
    
    /**
     * Method which opens the lock if combination was correct
     * @return unlocked true if the lock is unlocked, false if the combination
     * was incorrect.
     */
    public boolean open() { 
    	if ((spin1 == secret1) && (spin2 == secret2) && (spin3 == secret3)) {
    		unlocked = true;
    		System.out.println("Lock is unlocked.");
    	}
    	else System.out.println("Wrong combination. Please try again.");
    	return unlocked;
    }
}