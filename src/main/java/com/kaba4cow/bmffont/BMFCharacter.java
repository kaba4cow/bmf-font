package com.kaba4cow.bmffont;

/**
 * Represents a character in a bitmap font. Each character contains information about its position in the texture, dimensions,
 * offsets, and other rendering properties.
 */
public class BMFCharacter {

	private final int id;

	private int x;
	private int y;
	private int width;
	private int height;

	private int offsetX;
	private int offsetY;
	private int advanceX;

	private int page;
	private int channel;

	/**
	 * Creates a new bitmap font character with the specified ID.
	 *
	 * @param id the unique identifier of the character, typically its ASCII or Unicode value
	 */
	public BMFCharacter(int id) {
		this.id = id;
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		this.offsetX = 0;
		this.offsetY = 0;
		this.advanceX = 0;
		this.page = 0;
		this.channel = 0;
	}

	/**
	 * Returns the unique identifier of this character.
	 *
	 * @return the character ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the X coordinate of this character in the texture.
	 *
	 * @return the X coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the X coordinate of this character in the texture.
	 *
	 * @param x the X coordinate to set
	 * 
	 * @return a reference to this object
	 */
	public BMFCharacter setX(int x) {
		this.x = x;
		return this;
	}

	/**
	 * Returns the Y coordinate of this character in the texture.
	 *
	 * @return the Y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the Y coordinate of this character in the texture.
	 *
	 * @param y the Y coordinate to set
	 * 
	 * @return a reference to this object
	 */
	public BMFCharacter setY(int y) {
		this.y = y;
		return this;
	}

	/**
	 * Returns the width of this character in the texture.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width of this character in the texture.
	 *
	 * @param width the width to set
	 * 
	 * @return a reference to this object
	 */
	public BMFCharacter setWidth(int width) {
		this.width = width;
		return this;
	}

	/**
	 * Returns the height of this character in the texture.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height of this character in the texture.
	 *
	 * @param height the height to set
	 * 
	 * @return a reference to this object
	 */
	public BMFCharacter setHeight(int height) {
		this.height = height;
		return this;
	}

	/**
	 * Returns the X offset for rendering this character.
	 *
	 * @return the X offset
	 */
	public int getOffsetX() {
		return offsetX;
	}

	/**
	 * Sets the X offset for rendering this character.
	 *
	 * @param offsetX the X offset to set
	 * 
	 * @return a reference to this object
	 */
	public BMFCharacter setOffsetX(int offsetX) {
		this.offsetX = offsetX;
		return this;
	}

	/**
	 * Returns the Y offset for rendering this character.
	 *
	 * @return the Y offset
	 */
	public int getOffsetY() {
		return offsetY;
	}

	/**
	 * Sets the Y offset for rendering this character.
	 *
	 * @param offsetY the Y offset to set
	 * 
	 * @return a reference to this object
	 */
	public BMFCharacter setOffsetY(int offsetY) {
		this.offsetY = offsetY;
		return this;
	}

	/**
	 * Returns the horizontal advance value for this character.
	 *
	 * @return the horizontal advance value
	 */
	public int getAdvanceX() {
		return advanceX;
	}

	/**
	 * Sets the horizontal advance value for this character.
	 *
	 * @param advanceX the horizontal advance value to set
	 * 
	 * @return a reference to this object
	 */
	public BMFCharacter setAdvanceX(int advanceX) {
		this.advanceX = advanceX;
		return this;
	}

	/**
	 * Returns the texture page index for this character.
	 *
	 * @return the page index
	 */
	public int getPage() {
		return page;
	}

	/**
	 * Sets the texture page index for this character.
	 *
	 * @param page the page index to set
	 * 
	 * @return a reference to this object
	 */
	public BMFCharacter setPage(int page) {
		this.page = page;
		return this;
	}

	/**
	 * Returns the texture channel for this character.
	 *
	 * @return the channel index
	 */
	public int getChannel() {
		return channel;
	}

	/**
	 * Sets the texture channel for this character.
	 *
	 * @param channel the channel index to set
	 * 
	 * @return a reference to this object
	 */
	public BMFCharacter setChannel(int channel) {
		this.channel = channel;
		return this;
	}

	@Override
	public String toString() {
		return String.format(
				"BMFCharacter [id=%s, x=%s, y=%s, width=%s, height=%s, offsetX=%s, offsetY=%s, advanceX=%s, page=%s, channel=%s]",
				id, x, y, width, height, offsetX, offsetY, advanceX, page, channel);
	}

}
