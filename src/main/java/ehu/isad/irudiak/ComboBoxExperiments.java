package ehu.isad.irudiak;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ComboBoxExperiments extends Application  {

    private  ListView<Argazki> listViewOfArgazki;
    private ImageView imageView = new ImageView();
    private ComboBox comboBox ;
    private List<String> bilduma;
    private ObservableList<String> bildumaList;
    private Map<String,List<Argazki>> bildumaMap;
    private ObservableList<Argazki> argazkiList;

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("Irudia aukeratu");

         comboBox = new ComboBox();

        bilduma = List.of("Abereak","Landareak","Frutak");

        bildumaList = FXCollections.observableArrayList(bilduma);

        comboBox.setItems(bildumaList);

        bildumaMap = new HashMap<>();
        bildumaMap.put("Abereak", List.of(
                new Argazki("Elefantea", "elefantea.jpeg"),
                new Argazki("Txakurra", "txakurra.jpeg"),
                new Argazki("Untxia", "untxia.png")));

        bildumaMap.put("Landareak", List.of(
                new Argazki("Cactus", "cactus.png"),
                new Argazki("Landare Berdea", "landareberdea.jpeg"),
                new Argazki("Landare Horia", "landarehoria.jpeg")));

        bildumaMap.put("Frutak", List.of(
                new Argazki("Fresa", "fresa.jpeg"),
                new Argazki("Sagarra", "sagarra.jpeg"),
                new Argazki("Sandia", "sandia.png")));

        argazkiList = FXCollections.observableArrayList();


        comboBox.setOnAction(e -> {
                argazkiList.clear();
                argazkiList.addAll(bildumaMap.get(comboBox.getValue()));

                });

        listViewOfArgazki = new ListView<>(argazkiList);

        listViewOfArgazki.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (observable.getValue() == null) return;

            String fitx = observable.getValue().getArgazkia();

            try {
               imageView.setImage(lortuIrudia(fitx /* 48x48 */));
           } catch (IOException e) {
                e.printStackTrace();
            }

        });

        comboBox.setEditable(false);


        VBox vbox = new VBox(comboBox,listViewOfArgazki,imageView);
        Scene scene = new Scene(vbox, 400, 120);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Image lortuIrudia(String fitx) throws IOException {
        InputStream is = getClass().getResourceAsStream("/"+fitx);
        BufferedImage reader = ImageIO.read(is);
        Image argazkia = SwingFXUtils.toFXImage(reader,null);
        return argazkia;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
