package it.polito.tdp.librettovoti;

import it.polito.tdp.librettovoti.model.Libretto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
        Parent root = loader.load();
        // invece di chiamare un metodo statico della classe FXMLLoader passandogli info su quale FXML leggere,
        // ho creato un nuovo oggetto FXMLLoader dicendogli nel costruttore quale scena deve creare
        // e poi ho chiamato il metodo load che a questo punto diventa un metodo di instanza.
        
        FXMLController controller = loader.getController(); // il loader mi dice quale controller ha creato in automatico
        
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        Libretto model = new Libretto(); // servirà al controller per chiamarci i metodi definiti nella classe Libretto
        controller.setModel(model); // il controller così si ricorderà con quale model interagire
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
