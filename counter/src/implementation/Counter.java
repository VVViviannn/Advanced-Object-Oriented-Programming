package implementation;

/**
 * A counter is bounded betwen its MIN and MAX.
 * @author jackie
 *
 */
public class Counter {
	/**
	 * A constant denoting the lower bound of counter value.
	 */
	public final int MIN = 0;
	
	/**
	 * A constant denoting the upper bound of counter value.
	 */
	public final int MAX = 3;
	
	private int value;
	
	/**
	 * Read the current value of counter.
	 * @return Current value of counter.
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Initialize the counter with an initial value 'v'.
	 * @param initVal Initial value of counter
	 * @throws IllegalArgumentException When v is out of the bounds.
	 */
	public Counter(int v) throws IllegalArgumentException {
		if(v < MIN || v > MAX) {
			throw new IllegalArgumentException("Illegal initial value " + v);
		}
		else {
			value = v;
		}
	}
	
	/**
	 * Increment the current counter value by 1.
	 * @throws IllegalArgumentException When v is too large to be incremented.
	 */
	public void increment() throws IllegalArgumentException {
		if(value == MAX) {
			throw new IllegalArgumentException("Counter reaches its MAX.");
		}
		else {
			value ++;
		}
	}
	
	/**
	 * Decrement the current counter value by 1.
	 * @throws IllegalArgumentException When v is too small to be decremented.
	 */
	public void decrement() throws IllegalArgumentException {
		if(value == MIN) {
			throw new IllegalArgumentException("Counter reaches its MAX.");
		}
		else {
			value --;
		}
	}
}
