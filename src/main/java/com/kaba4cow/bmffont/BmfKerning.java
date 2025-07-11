package com.kaba4cow.bmffont;

/**
 * Represents kerning information between two characters in a bitmap font. Kerning adjusts the spacing between specific pairs of
 * characters for better visual appearance.
 */
public class BmfKerning {

	private final int first;
	private final int second;
	private int amount;

	/**
	 * Creates a new kerning pair for two characters.
	 *
	 * @param first  the code of the first character
	 * @param second the code of the second character
	 */
	public BmfKerning(int first, int second) {
		this.first = first;
		this.second = second;
		this.amount = 0;
	}

	/**
	 * Returns the code of the first character in the kerning pair.
	 *
	 * @return the first character code
	 */
	public int getFirst() {
		return first;
	}

	/**
	 * Returns the code of the second character in the kerning pair.
	 *
	 * @return the second character code
	 */
	public int getSecond() {
		return second;
	}

	/**
	 * Returns the kerning amount (adjustment) between the characters.
	 *
	 * @return the kerning amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Sets the kerning amount (adjustment) between the characters.
	 *
	 * @param amount the kerning amount to set
	 * 
	 * @return a reference to this object
	 */
	public BmfKerning setAmount(int amount) {
		this.amount = amount;
		return this;
	}

	@Override
	public String toString() {
		return String.format("BmfKerning [first=%s, second=%s, amount=%s]", first, second, amount);
	}

}
