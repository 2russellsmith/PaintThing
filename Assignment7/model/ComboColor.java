package model;

import javafx.scene.paint.Color;

/**
 * This enum provides color mapping for this application.
 */
public enum ComboColor {
    BLACK("Black", Color.BLACK),
    BLUE("Blue", Color.BLUE),
    GREEN("Green", Color.GREEN),
    RED("Red", Color.RED),
    YELLOW("Yellow", Color.YELLOW),
    ORANGE("Orange", Color.ORANGE),
    PINK("Pink", Color.PINK);

    private String name;
    private Color color;

    /**
     * Constructor for ComboColors
     *
     * @param name name of color
     * @param color color value
     */
    ComboColor(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    /**
     * Getter for color.
     * @return color
     */
    public Color getColor() {
        return color;
    }
}
