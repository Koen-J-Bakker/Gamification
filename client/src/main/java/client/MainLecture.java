package client;

import client.scenes.BlueCtrl;
import client.scenes.HomeScreenCtrl;
import client.scenes.PrimaryCtrl;
import client.scenes.RedCtrl;
import client.utils.ServerUtils;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;

import static com.google.inject.Guice.createInjector;

public class MainLecture extends Application {

    private static final Injector INJECTOR = createInjector(new MyModule());
    private static final MyFXML FXML = new MyFXML(INJECTOR);


    @FXML
    public Label myLabel;

    public static void main(String[] args) {
        launch(args);
    }

    private static URL getLocation(String path) {
        return MainLecture.class.getClassLoader().getResource(path);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        var serverUtils = INJECTOR.getInstance(ServerUtils.class);
        if (!serverUtils.isServerAvailable()) {
            var msg = "Server needs to be started before the client, but it does not seem to be available. Shutting down.";
            System.err.println(msg);
            return;
        }

        var red = FXML.load(RedCtrl.class, "client", "scenes", "red.fxml");
        var blue = FXML.load(BlueCtrl.class, "client", "scenes", "blue.fxml");
        var home = FXML.load(HomeScreenCtrl.class, "client", "scenes", "home.fxml");
        var pc = INJECTOR.getInstance(PrimaryCtrl.class);
        pc.init(primaryStage, red, blue, home);
    }
}