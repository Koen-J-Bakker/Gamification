package client.scenes;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Pair;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrimaryCtrl {
    private Stage primaryStage;
    private Scene redScene;
    private Scene blueScene;
    private Scene homeScene;

    public void init(Stage primaryStage, Pair<RedCtrl, Parent> red, Pair<BlueCtrl, Parent> blue, Pair<HomeScreenCtrl, Parent> home) {
        this.primaryStage = primaryStage;
        this.homeScene = new Scene(home.getValue());

        primaryStage.setFullScreen(true);
        primaryStage.setScene(homeScene);

        primaryStage.show();
    }

    public void showRed() {
        primaryStage.setTitle("Red!");
        primaryStage.setScene(redScene);
    }

    public void showBlue() {
        primaryStage.setTitle("Blue!");
        primaryStage.setScene(blueScene);
    }
}