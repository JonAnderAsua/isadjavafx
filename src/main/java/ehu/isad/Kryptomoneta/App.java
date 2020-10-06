package ehu.isad.Kryptomoneta;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App extends Application{

    private ComboBox comboBox;
    private HBox hbox;
    private Scene scene;
    private Gson gson;

    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("Kryptomoneta aukeratu");

        comboBox.getItems().add("BTC");
        comboBox.getItems().add("ETH");
        comboBox.getItems().add("LTC");

        comboBox.setEditable(false);

        comboBox.setOnAction(e -> {
            String s = comboBox.getValue().toString(); //Zein moneta aukeratu den
            String moneta = "";
            try {
                moneta = URLReader.URLlortu(s);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            String t = gson.toJson(moneta,Txanpona.class);
            

        });

        hbox = new HBox(comboBox);

        scene = new Scene(hbox, 200, 120);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
