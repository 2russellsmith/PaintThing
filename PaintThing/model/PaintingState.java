package model;

import javafx.scene.paint.Color;

/**
 * Painting State.
 */
public class PaintingState {
    private Color paintingColor;
    private ShapeMode shapeMode;

    /**
     * Constructor for PaintingState.
     * @param paintingColor paintingColor
     * @param shapeMode shapeMode
     */
    public PaintingState(Color paintingColor, ShapeMode shapeMode) {
        this.paintingColor = paintingColor;
        this.shapeMode = shapeMode;
    }

    public Color getPaintingColor() {
        return paintingColor;
    }

    public void setPaintingColor(Color paintingColor) {
        this.paintingColor = paintingColor;
    }

    public ShapeMode getShapeMode() {
        return shapeMode;
    }

    public void setShapeMode(ShapeMode shapeMode) {
        this.shapeMode = shapeMode;
    }

    public enum ShapeMode {
        CIRCLE, RECTANGLE
    }
}
