package com.kaba4cow.bmffont;

/**
 * Represents a character in a bitmap font. Each character contains information about its position in the texture, dimensions,
 * offsets, and other rendering properties.
 */
public class BmfCharacter {

	private final int id;

	private final BmfCoordinates textureCoordinates;

	private final BmfDimensions textureDimensions;

	private final BmfCoordinates offsetCoordinates;

	private int advance;

	private int page;

	private int channel;

	/**
	 * Creates a new bitmap font character with the specified ID.
	 *
	 * @param id the unique identifier of the character, typically its ASCII or Unicode value
	 */
	public BmfCharacter(int id) {
		this.id = id;
		this.textureCoordinates = new BmfCoordinates();
		this.textureDimensions = new BmfDimensions();
		this.offsetCoordinates = new BmfCoordinates();
		this.advance = 0;
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
	 * Returns the coordinates of this character in the texture.
	 * 
	 * @return the texture coordinates
	 */
	public BmfCoordinates getTextureCoordinates() {
		return textureCoordinates;
	}

	/**
	 * Returns the dimensions of this character in the texture.
	 * 
	 * @return the texture dimensions
	 */

	public BmfDimensions getTextureDimensions() {
		return textureDimensions;
	}

	/**
	 * Returns the offset coordinates for rendering this character.
	 * 
	 * @return the offset coordinates
	 */
	public BmfCoordinates getOffsetCoordinates() {
		return offsetCoordinates;
	}

	/**
	 * Returns the advance value for this character.
	 *
	 * @return the advance value
	 */
	public int getAdvance() {
		return advance;
	}

	/**
	 * Sets the advance value for this character.
	 *
	 * @param advance the advance value to set
	 * 
	 * @return a reference to this object
	 */
	public BmfCharacter setAdvance(int advance) {
		this.advance = advance;
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
	public BmfCharacter setPage(int page) {
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
	public BmfCharacter setChannel(int channel) {
		this.channel = channel;
		return this;
	}

	@Override
	public String toString() {
		return String.format(
				"BmfCharacter [id=%s, textureCoordinates=%s, textureDimensions=%s, offsetCoordinates=%s, advance=%s, page=%s, channel=%s]",
				id, textureCoordinates, textureDimensions, offsetCoordinates, advance, page, channel);
	}

}
