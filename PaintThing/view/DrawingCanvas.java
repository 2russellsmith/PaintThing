package view;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import model.PaintingState;

/**
 * Canvas Pane where shapes are drawn.
 */
public class DrawingCanvas extends Pane {

    private final PaintingState paintingState;

    /**
     * Constructor for DrawingCanvas.
     * @param paintingState paintingState
     */
    public DrawingCanvas(PaintingState paintingState) {
        this.paintingState = paintingState;
        this.setStyle("-fx-background-color: white;");
        this.addEventHandler(MouseEvent.ANY, new MouseHandler(this));
    }

    private class MouseHandler implements EventHandler<MouseEvent> {

        private final DrawingCanvas drawingCanvas;
        private Circle circleS;
        private Rectangle rectangleS;
        private double originX;
        private double originY;

        /**
         * Constructor for Mouse Handler.
         * @param drawingCanvas drawingCanvas
         */
        public MouseHandler(DrawingCanvas drawingCanvas) {
            this.drawingCanvas = drawingCanvas;
        }

        /**
         * Handles mouse events over canvas.
         * @param event event
         */
        public void handle(MouseEvent event) {
            switch (paintingState.getShapeMode()) {
                case CIRCLE:
                    if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                        System.out.println("Registered");
                        circleS = new Circle(event.getX(), event.getY(), 0, paintingState.getPaintingColor());
                        circleS.setFill(paintingState.getPaintingColor());
                        circleS.setStroke(Color.BLACK);
                        drawingCanvas.getChildren().add(circleS);
                    }
                    if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                        final double radius = Math.hypot(circleS.getCenterX() - event.getX(), circleS.getCenterY() - event.getY());
                        circleS.setRadius(radius);
                    }
                    if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                        System.out.println("Circle Created");
                    }
                    break;
                case RECTANGLE:
                    if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                        System.out.println("Registered");
                        this.originX = event.getX();
                        this.originY = event.getY();
                        rectangleS = new Rectangle(event.getX(), event.getY(), 0, 0);
                        rectangleS.setFill(paintingState.getPaintingColor());
                        rectangleS.setStroke(Color.BLACK);
                        drawingCanvas.getChildren().add(rectangleS);
                    }
                    if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                        final double width = Math.abs(event.getX() - this.originX);
                        final double height = Math.abs(event.getY() - this.originY);
                        rectangleS.setWidth(width);
                        rectangleS.setHeight(height);
                        rectangleS.setX(Math.min(this.originX, event.getX()));
                        rectangleS.setY(Math.min(this.originY, event.getY()));
                    }
                    if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                        System.out.println("Rectangle Created");
                    }
                    break;

                default:
                    System.out.print("Drawing mode not supported");
            }
        }
    }
}
