package com.kaba4cow.bmffont;

import java.util.Objects;

public class BmfDimensions {

	private int width;

	private int height;

	public BmfDimensions() {
		this.width = 0;
		this.height = 0;
	}

	/**
	 * Returns the width value.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width value.
	 *
	 * @param width the width to set
	 * 
	 * @return a reference to this object
	 */
	public BmfDimensions setWidth(int width) {
		this.width = width;
		return this;
	}

	/**
	 * Returns the height value.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height value.
	 *
	 * @param height the height to set
	 * 
	 * @return a reference to this object
	 */
	public BmfDimensions setHeight(int height) {
		this.height = height;
		return this;
	}

	@Override
	public int hashCode() {
		return Objects.hash(height, width);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BmfDimensions other = (BmfDimensions) obj;
		return height == other.height && width == other.width;
	}

	@Override
	public String toString() {
		return String.format("BmfDimensions [width=%s, height=%s]", width, height);
	}

}
