package client.scenes;

import javafx.application.Platform;
import javafx.beans.binding.DoubleBinding;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;


public class HomeScreenCtrl {

    @FXML private StackPane root;
    @FXML private Group group;

    private final double designWidth = 3840;
    private final double designHeight = 2160;

    public void initialize() {
        Platform.runLater(() -> {
            Scene scene = root.getScene();
            if (scene == null) return;

            DoubleBinding scaleBindingX = new DoubleBinding() {
                { super.bind(scene.widthProperty(), scene.heightProperty()); }
                @Override
                protected double computeValue() {
                    return scene.getWidth() / designWidth;
                }
            };

            DoubleBinding scaleBindingY = new DoubleBinding() {
                { super.bind(scene.widthProperty(), scene.heightProperty()); }
                @Override
                protected double computeValue() {
                    return scene.getHeight() / designHeight;
                }
            };

            group.scaleXProperty().bind(scaleBindingX);
            group.scaleYProperty().bind(scaleBindingY);
        });
    }
}