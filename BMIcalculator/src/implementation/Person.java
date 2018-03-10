package implementation;

/**
 * @author Yuxian Wang
 * 
 */
public class Person {

	private double weight;
	private double height;
	private String name;
	public double bmi;
	public String interpretation;

	public Person(String n) {
		name = n;
	}

	/**
	 * Set the value of weight from the input.
	 * 
	 * @param w
	 *            the value of weight
	 * @throws IllegalArgumentException
	 *             When weight is not a positive number.
	 */
	public void setWeight(double w) throws IllegalArgumentException {
		if (w <= 0) {
			throw new IllegalArgumentException("weight is not positive!");
		} else {
			weight = w;
		}
	}

	/**
	 * Set the value of height from the input.
	 * 
	 * @param h
	 *            the value of weight
	 * @throws IllegalArgumentException
	 *             When height is not a positive number.
	 */
	public void setHeight(double h) throws IllegalArgumentException {
		if (h <= 0) {
			throw new IllegalArgumentException("height is not positive!");
		} else {
			height = h;
		}
	}

	/**
	 * Round up each calculated BMI value to only one digit after the decimal
	 * point.
	 * 
	 * @return The calculated BMI.
	 */
	public double getBMI() {
		bmi = Math.round((weight / Math.pow(height,2)) * 10) / 10.0;
		return bmi;
	}

	/**
	 * Read the current name.
	 * 
	 * @return Current name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Read the current value of weight.
	 * 
	 * @return Current value of weight.
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Read the current value of height.
	 * 
	 * @return Current value of height.
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * BMI < 18.5 means underweight, 18.5 ≤ BMI < 25.0 means normal, 25.0 ≤ BMI
	 * < 30.0 means overweight, and 30.0 ≤ BMI means obese.
	 * 
	 * @return The interpretation for corresponded BMI.
	 */
	public String getInterpretationOfBMI() {
		if (bmi < 18.5) {
			interpretation = "underweight";
		} else if (bmi >= 18.5 && bmi < 25.0) {
			interpretation = "normal";
		} else if (bmi >= 25.0 && bmi < 30.0) {
			interpretation = "overweight";
		} else {
			interpretation = "obese";
		}
		return interpretation;
	}
}
