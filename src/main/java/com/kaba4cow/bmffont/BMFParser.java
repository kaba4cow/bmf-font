package com.kaba4cow.bmffont;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import com.kaba4cow.stringview.StringView;

/**
 * A utility class for reading BMFont data from {@link Reader}s, {@link InputStream}s or {@link String}s and converting it to
 * {@link BMFFont} objects.
 */
public class BMFParser {

	private BMFParser() {}

	/**
	 * Reads the BMFont data from the specified {@link Reader} and converts its contents to an {@link BMFFont} object. If the
	 * {@code target} is not {@code null} its contents are cleared using {@link BMFFont#clearCharacters()},
	 * {@link BMFFont#clearKernings()} and {@link BMFFont#clearPages()}
	 * 
	 * @param source the {@link Reader} to read the BMFont data from
	 * @param target the {@link BMFFont} to convert the BMFont data to, or {@code null}
	 * 
	 * @return the {@link BMFFont} containing the data, either the passed one or a newly created one if {@code target} is
	 *             {@code null}
	 * 
	 * @throws IOException if an I/O error occurs
	 */
	public static BMFFont parse(Reader source, BMFFont target) throws IOException {
		Objects.requireNonNull(source, "Source Reader must not be null");
		if (Objects.isNull(target))
			target = new BMFFont();
		else
			target.clearCharacters().clearKernings().clearPages();
		try (BufferedReader reader = new BufferedReader(source)) {
			String line = null;
			while (Objects.nonNull(line = reader.readLine())) {
				Map<String, StringView> map = parseLine(line);
				switch (map.get("header").asString()) {
					case "info":
						target.setFace(map.get("face").asString());
						target.setSize(map.get("size").asInt());
						target.setBold(map.get("bold").asInt() != 0);
						target.setItalic(map.get("italic").asInt() != 0);
						target.setCharset(map.get("charset").asString());
						target.setUnicode(map.get("unicode").asInt() != 0);
						target.setStretchH(map.get("stretchH").asInt());
						target.setSmooth(map.get("smooth").asInt() != 0);
						target.setAntiAliased(map.get("aa").asInt() != 0);
						target.setPadding(map.get("padding").asIntArray(","));
						target.setSpacing(map.get("spacing").asIntArray(","));
						break;
					case "common":
						target.setLineHeight(map.get("lineHeight").asInt());
						target.setBase(map.get("base").asInt());
						target.setScaleW(map.get("scaleW").asInt());
						target.setScaleH(map.get("scaleH").asInt());
						target.setPacked(map.get("packed").asInt() != 0);
						break;
					case "page":
						target.addPage(map.get("id").asInt(), map.get("file").asString());
						break;
					case "char":
						BMFCharacter character = new BMFCharacter(map.get("id").asInt());
						character.setX(map.get("x").asInt());
						character.setY(map.get("y").asInt());
						character.setWidth(map.get("width").asInt());
						character.setHeight(map.get("height").asInt());
						character.setOffsetX(map.get("xoffset").asInt());
						character.setOffsetY(map.get("yoffset").asInt());
						character.setAdvanceX(map.get("xadvance").asInt());
						character.setPage(map.get("page").asInt());
						character.setChannel(map.get("chnl").asInt());
						target.addCharacter(character);
						break;
					case "kerning":
						BMFKerning kerning = new BMFKerning(map.get("first").asInt(), map.get("second").asInt());
						kerning.setAmount(map.get("amount").asInt());
						target.addKerning(kerning);
						break;
					default:
						break;
				}
			}
			return target;
		}
	}

	/**
	 * Reads the BMFont data from the specified {@link InputStream} and converts its contents to an {@link BMFFont} object. If
	 * the {@code target} is not {@code null} its contents are cleared using {@link BMFFont#clearCharacters()},
	 * {@link BMFFont#clearKernings()} and {@link BMFFont#clearPages()}
	 * 
	 * @param source the {@link InputStream} to read the BMFont data from
	 * @param target the {@link BMFFont} to convert the BMFont data to, or {@code null}
	 * 
	 * @return the {@link BMFFont} containing the data, either the passed one or a newly created one if {@code target} is
	 *             {@code null}
	 * 
	 * @throws IOException if an I/O error occurs
	 */
	public static BMFFont parse(InputStream source, BMFFont target) throws IOException {
		Objects.requireNonNull(source, "Source InputStream must not be null");
		return parse(new InputStreamReader(source), target);
	}

	/**
	 * Reads the BMFont data from the specified {@link String} and converts its contents to an {@link BMFFont} object. If the
	 * {@code target} is not {@code null} its contents are cleared using {@link BMFFont#clearCharacters()},
	 * {@link BMFFont#clearKernings()} and {@link BMFFont#clearPages()}
	 * 
	 * @param source the {@link String} to read the BMFont data from
	 * @param target the {@link BMFFont} to convert the BMFont data to, or {@code null}
	 * 
	 * @return the {@link BMFFont} containing the data, either the passed one or a newly created one if {@code target} is
	 *             {@code null}
	 * 
	 * @throws IOException if an I/O error occurs
	 */
	public static BMFFont parse(String source, BMFFont target) throws IOException {
		Objects.requireNonNull(source, "Source String must not be null");
		return parse(new StringReader(source), target);
	}

	private static Map<String, StringView> parseLine(String line) {
		if (line.trim().isEmpty())
			return new LinkedHashMap<>();
		String[] values = line.trim().split(" ", 2);
		Map<String, StringView> map = new LinkedHashMap<>();
		map.put("header", StringView.view(values[0]));
		String pairs = values[1];
		StringBuilder currentKey = new StringBuilder();
		StringBuilder currentValue = new StringBuilder();
		boolean quotes = false;
		boolean readingValue = false;
		for (char c : pairs.toCharArray())
			if (c == '\"')
				quotes = !quotes;
			else if (c == ' ' && !quotes) {
				if (readingValue) {
					map.put(currentKey.toString(), StringView.view(currentValue.toString()));
					currentKey.setLength(0);
					currentValue.setLength(0);
					readingValue = false;
				}
			} else if (!readingValue && c != '=')
				currentKey.append(c);
			else if (c == '=')
				readingValue = true;
			else
				currentValue.append(c);
		if (currentKey.length() > 0 && currentValue.length() > 0)
			map.put(currentKey.toString(), StringView.view(currentValue.toString()));
		return map;
	}

}
