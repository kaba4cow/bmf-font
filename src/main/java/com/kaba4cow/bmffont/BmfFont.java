package com.kaba4cow.bmffont;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

/**
 * Represents a bitmap font with all its properties and character data. This class holds information about the font's
 * appearance, metrics, and character mappings.
 */
public class BmfFont {

	private final Map<Integer, BmfCharacter> characters;

	private final Set<BmfKerning> kernings;

	private final List<String> pages;

	private String face;
	private String charset;

	private int size;
	private int scaleW;
	private int scaleH;
	private int stretchH;

	private int lineHeight;
	private int base;

	private int[] padding;
	private int[] spacing;

	private boolean bold;
	private boolean italic;
	private boolean unicode;
	private boolean smooth;
	private boolean antiAliased;
	private boolean packed;

	/**
	 * Creates a new empty bitmap font with default values.
	 */
	public BmfFont() {
		this.characters = new TreeMap<>();
		this.kernings = new LinkedHashSet<>();
		this.pages = new ArrayList<>();
		this.face = "";
		this.charset = "";
		this.size = 0;
		this.scaleW = 0;
		this.scaleH = 0;
		this.stretchH = 0;
		this.lineHeight = 0;
		this.base = 0;
		this.padding = new int[4];
		this.spacing = new int[2];
		this.bold = false;
		this.italic = false;
		this.unicode = false;
		this.smooth = false;
		this.antiAliased = false;
		this.packed = false;
	}

	/**
	 * Returns an unmodifiable map of all characters in this font, keyed by their character codes.
	 *
	 * @return an unmodifiable map of character codes to {@link BmfCharacter} objects
	 */
	public Map<Integer, BmfCharacter> getCharacterMap() {
		return Collections.unmodifiableMap(characters);
	}

	/**
	 * Returns an unmodifiable set of all character codes in this font.
	 *
	 * @return an unmodifiable set of character codes
	 */
	public Set<Integer> getCharacterCodes() {
		return Collections.unmodifiableSet(characters.keySet());
	}

	/**
	 * Returns an unmodifiable collection of all characters in this font.
	 *
	 * @return an unmodifiable collection of {@link BmfCharacter} objects
	 */
	public Collection<BmfCharacter> getCharacters() {
		return Collections.unmodifiableCollection(characters.values());
	}

	/**
	 * Checks if a character with the specified code exists in this font.
	 *
	 * @param code the character code to check
	 * 
	 * @return {@code true} if the character exists, {@code false} otherwise
	 */
	public boolean hasCharacter(int code) {
		return characters.containsKey(Integer.valueOf(code));
	}

	/**
	 * Returns the character with the specified code, or {@code null} if not found.
	 *
	 * @param code the character code to get
	 * 
	 * @return the {@link BmfCharacter} object, or {@code null} if not found
	 */
	public BmfCharacter getCharacter(int code) {
		return characters.get(Integer.valueOf(code));
	}

	/**
	 * Adds a character to this font.
	 *
	 * @param character the character to add
	 * 
	 * @return a reference to this object
	 */
	public BmfFont addCharacter(BmfCharacter character) {
		characters.put(character.getId(), character);
		return this;
	}

	/**
	 * Removes the character with the specified code.
	 *
	 * @param code the character code to remove
	 * 
	 * @return a reference to this object
	 */
	public BmfFont removeCharacter(int code) {
		characters.remove(Integer.valueOf(code));
		return this;
	}

	/**
	 * Removes all characters from this font.
	 *
	 * @return a reference to this object
	 */
	public BmfFont clearCharacters() {
		characters.clear();
		return this;
	}

	/**
	 * Returns an unmodifiable set of all kernings in this font.
	 *
	 * @return an unmodifiable set of kernings
	 */
	public Set<BmfKerning> getKernings() {
		return Collections.unmodifiableSet(kernings);
	}

	/**
	 * Finds kerning for a pair of characters.
	 *
	 * @param first  the code of the first character
	 * @param second the code of the second character
	 * 
	 * @return an {@link Optional} containing the kerning
	 */
	public Optional<BmfKerning> getKerning(int first, int second) {
		return kernings.stream().filter(kerning -> kerning.getFirst() == first && kerning.getSecond() == second).findAny();
	}

	/**
	 * Adds a kerning to this font.
	 *
	 * @param kerning the kerning to add
	 * 
	 * @return a reference to this object
	 */
	public BmfFont addKerning(BmfKerning kerning) {
		kernings.add(kerning);
		return this;
	}

	/**
	 * Removes a kerning from this font.
	 *
	 * @param kerning the kerning to remove
	 * 
	 * @return a reference to this object
	 */
	public BmfFont removeKerning(BmfKerning kerning) {
		kernings.remove(kerning);
		return this;
	}

	/**
	 * Removes all kernings from this font.
	 *
	 * @return a reference to this object
	 */
	public BmfFont clearKernings() {
		kernings.clear();
		return this;
	}

	/**
	 * Returns an unmodifiable list of texture page file names.
	 *
	 * @return an unmodifiable list of page file names
	 */
	public List<String> getPages() {
		return Collections.unmodifiableList(pages);
	}

	/**
	 * Returns the file name of the texture page with the specified ID.
	 *
	 * @param id the page ID
	 * 
	 * @return the page file name
	 */
	public String getPage(int id) {
		return pages.get(id);
	}

	/**
	 * Adds a texture page file name at the specified index.
	 *
	 * @param id   the page ID
	 * @param page the page file name
	 * 
	 * @return a reference to this object
	 */
	public BmfFont addPage(int id, String page) {
		pages.add(id, page);
		return this;
	}

	/**
	 * Removes the texture page at the specified index.
	 *
	 * @param id the page ID to remove
	 * 
	 * @return a reference to this object
	 */
	public BmfFont removePage(int id) {
		pages.remove(id);
		return this;
	}

	/**
	 * Removes the specified texture page file name.
	 *
	 * @param page the page file name to remove
	 * 
	 * @return a reference to this object
	 */
	public BmfFont removePage(String page) {
		pages.remove(page);
		return this;
	}

	/**
	 * Removes all texture pages.
	 *
	 * @return a reference to this object
	 */
	public BmfFont clearPages() {
		pages.clear();
		return this;
	}

	/**
	 * Returns the font face name.
	 *
	 * @return the font face name
	 */
	public String getFace() {
		return face;
	}

	/**
	 * Sets the font face name.
	 *
	 * @param face the font face name to set
	 * 
	 * @return a reference to this object
	 */
	public BmfFont setFace(String face) {
		this.face = face;
		return this;
	}

	/**
	 * Returns the font character set.
	 *
	 * @return the character set
	 */
	public String getCharset() {
		return charset;
	}

	/**
	 * Sets the font character set.
	 *
	 * @param charset the character set to set
	 * 
	 * @return a reference to this object
	 */
	public BmfFont setCharset(String charset) {
		this.charset = charset;
		return this;
	}

	/**
	 * Returns the font size in pixels.
	 *
	 * @return the font size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the font size in pixels.
	 *
	 * @param size the font size to set
	 * 
	 * @return a reference to this object
	 */
	public BmfFont setSize(int size) {
		this.size = size;
		return this;
	}

	/**
	 * Returns the width of the texture.
	 *
	 * @return the texture width
	 */
	public int getScaleW() {
		return scaleW;
	}

	/**
	 * Sets the width of the texture.
	 *
	 * @param scaleW the texture width to set
	 * 
	 * @return a reference to this object
	 */
	public BmfFont setScaleW(int scaleW) {
		this.scaleW = scaleW;
		return this;
	}

	/**
	 * Returns the height of the texture.
	 *
	 * @return the texture height
	 */
	public int getScaleH() {
		return scaleH;
	}

	/**
	 * Sets the height of the texture.
	 *
	 * @param scaleH the texture height to set
	 * 
	 * @return a reference to this object
	 */
	public BmfFont setScaleH(int scaleH) {
		this.scaleH = scaleH;
		return this;
	}

	/**
	 * Returns the font stretch height percentage.
	 *
	 * @return the stretch height
	 */
	public int getStretchH() {
		return stretchH;
	}

	/**
	 * Sets the font stretch height percentage.
	 *
	 * @param stretchH the stretch height to set
	 * 
	 * @return a reference to this object
	 */
	public BmfFont setStretchH(int stretchH) {
		this.stretchH = stretchH;
		return this;
	}

	/**
	 * Returns the line height in pixels.
	 *
	 * @return the line height
	 */
	public int getLineHeight() {
		return lineHeight;
	}

	/**
	 * Sets the line height in pixels.
	 *
	 * @param lineHeight the line height to set
	 * 
	 * @return a reference to this object
	 */
	public BmfFont setLineHeight(int lineHeight) {
		this.lineHeight = lineHeight;
		return this;
	}

	/**
	 * Returns the font baseline in pixels.
	 *
	 * @return the baseline
	 */
	public int getBase() {
		return base;
	}

	/**
	 * Sets the font baseline in pixels.
	 *
	 * @param base the baseline to set
	 * 
	 * @return a reference to this object
	 */
	public BmfFont setBase(int base) {
		this.base = base;
		return this;
	}

	/**
	 * Returns the font padding values.
	 *
	 * @return array of padding values [up, right, down, left]
	 */
	public int[] getPadding() {
		return padding;
	}

	/**
	 * Sets the font padding values.
	 *
	 * @param padding array of padding values [up, right, down, left]
	 * 
	 * @return a reference to this object
	 */
	public BmfFont setPadding(int[] padding) {
		this.padding = padding;
		return this;
	}

	/**
	 * Returns the font spacing values.
	 *
	 * @return array of spacing values [horizontal, vertical]
	 */
	public int[] getSpacing() {
		return spacing;
	}

	/**
	 * Sets the font spacing values.
	 *
	 * @param spacing array of spacing values [horizontal, vertical]
	 * 
	 * @return a reference to this object
	 */
	public BmfFont setSpacing(int[] spacing) {
		this.spacing = spacing;
		return this;
	}

	/**
	 * Returns whether the font is bold.
	 *
	 * @return {@code true} if bold, {@code false} otherwise
	 */
	public boolean isBold() {
		return bold;
	}

	/**
	 * Sets whether the font is bold.
	 *
	 * @param bold {@code true} to set bold, {@code false} otherwise
	 * 
	 * @return a reference to this object
	 */
	public BmfFont setBold(boolean bold) {
		this.bold = bold;
		return this;
	}

	/**
	 * Returns whether the font is italic.
	 *
	 * @return {@code true} if italic, {@code false} otherwise
	 */
	public boolean isItalic() {
		return italic;
	}

	/**
	 * Sets whether the font is italic.
	 *
	 * @param italic {@code true} to set italic, {@code false} otherwise
	 * 
	 * @return a reference to this object
	 */
	public BmfFont setItalic(boolean italic) {
		this.italic = italic;
		return this;
	}

	/**
	 * Returns whether the font uses unicode.
	 *
	 * @return {@code true} if unicode, {@code false} otherwise
	 */
	public boolean isUnicode() {
		return unicode;
	}

	/**
	 * Sets whether the font uses unicode.
	 *
	 * @param unicode {@code true} to set unicode, {@code false} otherwise
	 * 
	 * @return a reference to this object
	 */
	public BmfFont setUnicode(boolean unicode) {
		this.unicode = unicode;
		return this;
	}

	/**
	 * Returns whether smoothing is enabled.
	 *
	 * @return {@code true} if smoothing enabled, {@code false} otherwise
	 */
	public boolean isSmooth() {
		return smooth;
	}

	/**
	 * Sets whether smoothing is enabled.
	 *
	 * @param smooth {@code true} to enable smoothing, {@code false} otherwise
	 * 
	 * @return a reference to this object
	 */
	public BmfFont setSmooth(boolean smooth) {
		this.smooth = smooth;
		return this;
	}

	/**
	 * Returns whether anti-aliasing is enabled.
	 *
	 * @return {@code true} if anti-aliasing enabled, {@code false} otherwise
	 */
	public boolean isAntiAliased() {
		return antiAliased;
	}

	/**
	 * Sets whether anti-aliasing is enabled.
	 *
	 * @param antiAliased {@code true} to enable anti-aliasing, {@code false} otherwise
	 * 
	 * @return a reference to this object
	 */
	public BmfFont setAntiAliased(boolean antiAliased) {
		this.antiAliased = antiAliased;
		return this;
	}

	/**
	 * Returns whether the font texture is packed.
	 *
	 * @return {@code true} if packed, {@code false} otherwise
	 */
	public boolean isPacked() {
		return packed;
	}

	/**
	 * Sets whether the font texture is packed.
	 *
	 * @param packed {@code true} to set packed, {@code false} otherwise
	 * 
	 * @return a reference to this object
	 */
	public BmfFont setPacked(boolean packed) {
		this.packed = packed;
		return this;
	}

	@Override
	public String toString() {
		return String.format(
				"BMFFont [characters=%s, kernings=%s, pages=%s, face=%s, charset=%s, size=%s, scaleW=%s, scaleH=%s, stretchH=%s, lineHeight=%s, base=%s, padding=%s, spacing=%s, bold=%s, italic=%s, unicode=%s, smooth=%s, antiAliased=%s, packed=%s]",
				characters.size(), kernings.size(), pages, face, charset, size, scaleW, scaleH, stretchH, lineHeight, base,
				Arrays.toString(padding), Arrays.toString(spacing), bold, italic, unicode, smooth, antiAliased, packed);
	}

}
