package com.kaba4cow.bmffont;

import java.util.Objects;

public class BmfCoordinates {

	private int x;

	private int y;

	public BmfCoordinates() {
		this.x = 0;
		this.y = 0;
	}

	/**
	 * Returns the X coordinate.
	 *
	 * @return the X coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the X coordinate.
	 *
	 * @param x the X coordinate to set
	 * 
	 * @return a reference to this object
	 */
	public BmfCoordinates setX(int x) {
		this.x = x;
		return this;
	}

	/**
	 * Returns the Y coordinate.
	 *
	 * @return the Y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the Y coordinate.
	 *
	 * @param y the Y coordinate to set
	 * 
	 * @return a reference to this object
	 */
	public BmfCoordinates setY(int y) {
		this.y = y;
		return this;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BmfCoordinates other = (BmfCoordinates) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return String.format("BmfCoordinates [x=%s, y=%s]", x, y);
	}

}
