# BMF Font Library

A Java library for reading and manipulating **BMFont** files. This library provides a clean and intuitive API for parsing and manipulating bitmap font data generated by tools like [Bitmap Font Generator](http://www.angelcode.com/products/bmfont/) and [Hiero](https://libgdx.com/wiki/tools/hiero).

## Features

- Parse **BMFont** files from various sources (`String`, `InputStream`, or `Reader`)
- Access and modify font properties, characters, and kerning information
- Clean, documented API with builder-style method chaining
- Support for multiple texture pages
- Comprehensive character metrics including position, size, offsets, and advance
- Kerning pair management for improved text rendering
- Font properties including size, line height, padding, and rendering options

## Usage

### Basic Example

```java
// Parse a BMFont file
try {
    BMFFont font = BMFParser.parse(new FileInputStream("path/to/your/font.fnt"), null);
    
    // Access font properties
    System.out.println("Font face: " + font.getFace());
    System.out.println("Font size: " + font.getSize());
    System.out.println("Line height: " + font.getLineHeight());
    
    // Get character information
    BMFCharacter character = font.getCharacter(65); // 'A'
    if (character != null) {
        System.out.println("Character A width: " + character.getWidth());
        System.out.println("Character A height: " + character.getHeight());
    }
    
    // Check kerning between two characters
    Optional<BMFKerning> kerning = font.getKerning(65, 86); // A and V
    kerning.ifPresent(k -> System.out.println("Kerning amount: " + k.getAmount()));
    
} catch (IOException e) {
    e.printStackTrace();
}
```

### Creating a Font Programmatically

```java
// Create font
BMFFont font = new BMFFont()
    .setFace("Arial")
    .setSize(32)
    .setLineHeight(36)
    .setBold(true)
    .setSmooth(true);

// Add a character
BMFCharacter character = new BMFCharacter(65) // 'A'
    .setX(0)
    .setY(0)
    .setWidth(24)
    .setHeight(32)
    .setOffsetX(0)
    .setOffsetY(0)
    .setAdvanceX(26);
font.addCharacter(character);

// Add kerning
BMFKerning kerning = new BMFKerning(65, 86) // A to V
    .setAmount(-2);
font.addKerning(kerning);
```

## Key Classes

### BMFFont
The main class representing a bitmap font:
- Font properties (face, size, line height, etc.)
- Character and kerning management
- Texture page handling
- Builder-style setters for easy configuration

### BMFCharacter
Represents a single character in the font:
- Position in texture (x, y)
- Dimensions (width, height)
- Rendering offsets
- Advance value
- Page and channel information

### BMFKerning
Manages spacing adjustments between character pairs:
- First and second character codes
- Kerning amount

### BMFParser
Utility class for parsing **BMFont** files:
- Multiple input source support (`Reader`, `InputStream`, `String`)
- Optional target font object for reuse