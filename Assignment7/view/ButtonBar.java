package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * Button bar.
 */
public class ButtonBar extends HBox {

    /**
     * Constructor for ButtonBar.
     * @param undoBtn undoBtn
     * @param eraseBtn eraseBtn
     */
    public ButtonBar(Button undoBtn, Button eraseBtn) {
        undoBtn.setMinWidth(80.0);
        eraseBtn.setMinWidth(80.0);
        this.getChildren().add(undoBtn);
        this.getChildren().add(eraseBtn);
        this.setSpacing(25);
        this.setPadding(new Insets(10, 10, 20, 200));
    }
}
