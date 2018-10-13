package view;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import model.ComboColor;
import model.PaintingState;

/**
 * view.DrawPane Class.
 */
public class DrawPane extends BorderPane {
    private final DrawingCanvas canvas;
    private final ComboBox<ComboColor> colorSelectionComboBox;
    private final PaintingState paintingState;

    /**
     * view.DrawPane Constructor.
     */
    public DrawPane() {
        final Button undoBtn, eraseBtn;
        undoBtn = new Button("Undo");
        undoBtn.setOnAction(new UndoButtonHandler());
        eraseBtn = new Button("Erase");
        eraseBtn.setOnAction(new EraseButtonHandler());

        paintingState = new PaintingState(Color.BLACK, PaintingState.ShapeMode.RECTANGLE);

        colorSelectionComboBox = new ComboBox(FXCollections.observableArrayList(ComboColor.values()));
        colorSelectionComboBox.setOnAction(new ColorHandler());
        colorSelectionComboBox.getSelectionModel().select(0);

        final RadioButton rectangle;
        final RadioButton circle;
        final ToggleGroup toggleGroup = new ToggleGroup();
        rectangle = new RadioButton();
        rectangle.setText("Rectangle");
        rectangle.setToggleGroup(toggleGroup);
        rectangle.setOnAction(new RectModeHandler());
        circle = new RadioButton();
        circle.setText("Circle");
        circle.setToggleGroup(toggleGroup);
        circle.setOnAction(new CircleModeHandler());

        canvas = new DrawingCanvas(this.paintingState);
        final SelectorPane selectorPane = new SelectorPane(this.colorSelectionComboBox, rectangle, circle);
        final ButtonBar buttonBar = new ButtonBar(undoBtn, eraseBtn);

        this.setCenter(canvas);
        this.setLeft(selectorPane);
        this.setBottom(buttonBar);
    }

    private class UndoButtonHandler implements EventHandler<ActionEvent> {
        /**
         * UndoButton handler.
         * @param event action event.
         */
        public void handle(ActionEvent event) {
            if (canvas.getChildren().size() > 0) {
                canvas.getChildren().remove(canvas.getChildren().size() - 1);
            }
        }
    }

    private class EraseButtonHandler implements EventHandler<ActionEvent> {
        /**
         * EraseButton handler.
         * @param event action event.
         */
        public void handle(ActionEvent event) {
            canvas.getChildren().clear();
        }
    }

    private class CircleModeHandler implements EventHandler<ActionEvent> {
        /**
         * Shape handle event.
         *
         * @param event action event.
         */
        public void handle(ActionEvent event) {
            paintingState.setShapeMode(PaintingState.ShapeMode.CIRCLE);
            System.out.println("Circle Mode");
        }

    }
    private class RectModeHandler implements EventHandler<ActionEvent> {
        /**
         * Shape handle event.
         *
         * @param event action event.
         */
        public void handle(ActionEvent event) {
            paintingState.setShapeMode(PaintingState.ShapeMode.RECTANGLE);
            System.out.println("Rectangle Mode");
        }

    }

    private class ColorHandler implements EventHandler<ActionEvent> {

        /**
         * Color handler event.
         * @param event action event.
         */
        public void handle(ActionEvent event) {
            try {
                paintingState.setPaintingColor(colorSelectionComboBox.getValue().getColor());
            } catch (NullPointerException e) {
                System.out.println("Null");
            }
        }
    }
}
