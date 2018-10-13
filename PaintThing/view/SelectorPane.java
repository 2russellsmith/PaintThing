package view;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import model.ComboColor;

/**
 * Pane for painter selection.
 */
public class SelectorPane extends VBox {

    /**
     * Constructor for SelectorPane.
     * @param comboColorComboBox comboColorComboBox
     * @param rectangle rectangle
     * @param circle circle
     */
    public SelectorPane(ComboBox<ComboColor> comboColorComboBox, RadioButton rectangle, RadioButton circle) {
        this.getChildren().add(comboColorComboBox);
        this.getChildren().add(rectangle);
        this.getChildren().add(circle);
        this.setSpacing(40);
        this.setPadding(new Insets(10, 10, 10, 10));
    }
}
