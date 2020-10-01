package ehu.isad;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.nio.channels.GatheringByteChannel;


public class ComboBoxExperiments extends Application  {

    @Override
    public void start(Stage primaryStage) {
        Gson gson = new Gson();
        primaryStage.setTitle("Cryptomoneta aukeratu");
        Label l = new Label();
        l.setVisible(true);
        l.setText("froga");

        ComboBox comboBox = new ComboBox();

        comboBox.getItems().add("BTC");
        comboBox.getItems().add("ETH");
        comboBox.getItems().add("LTC");

        comboBox.setEditable(false);

        comboBox.setOnAction(e -> { //Arrow e -> = event e
            String moneta = comboBox.getValue().toString(); //Erabiltzaileak zein moneta aukeratu duen gorde
            try {
                String json = URLReader.URLlortu(moneta);
                Txanpona t =gson.fromJson(json,Txanpona.class); //Da null
                System.out.println(t);
                l.setText(t.getPrice());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        VBox vbox = new VBox(l,comboBox);
        Scene scene = new Scene(vbox, 400, 120);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
