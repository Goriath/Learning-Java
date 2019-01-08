package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Controller {
    @FXML
    private Label label;
    @FXML
    private Button button4;
    @FXML
    private GridPane gridPane;
    @FXML
    private WebView webView;


    public void initialize(){
        button4.setEffect(new DropShadow());

    }

    @FXML
    public void handleMouseEnter(){
        label.setScaleX(2.);
        label.setScaleY(2.);
    }

    @FXML
    public void handleMouseExit(){
        label.setScaleX(1.);
        label.setScaleY(1.);
    }

    @FXML
    public void handleClick(){
        FileChooser chooser = new FileChooser();    //for choosing files
        chooser.setTitle("Save Application File");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );  //we can add specific file extension and name them appropriately or all files with *.*

        //File file = chooser.showOpenDialog(gridPane.getScene().getWindow());    //disables the option to interact with
                                                                        //the main window after the openDialog opens
        //DirectoryChooser chooser = new DirectoryChooser();    //for choosing directory
        //File file = chooser.showDialog(gridPane.getScene().getWindow());
        //File file = chooser.showSaveDialog(gridPane.getScene().getWindow());
        List<File> file = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
        //for multiple files
        if (file != null){
            for (int i=0; i<file.size();i++){
                System.out.println(file.get(i).getPath());
            }
        } else {
            System.out.println("Chooser was cancelled");
        }
        //for one file
    //        if (file != null){
    //            System.out.println(file.getPath());
    //        } else {
    //            System.out.println("Chooser was cancelled");
    //        }
    }

    @FXML
    private void handleLinkClick(){
        //open hyperlink in default browser
//        try {
//            Desktop.getDesktop().browse(new URI("http://www.javafx.com"));  //requires java.desktop; in module-info
//        } catch (IOException e){
//            e.printStackTrace();
//        } catch (URISyntaxException e){
//            e.printStackTrace();
//        }

        //open in WebView
        WebEngine engine  = webView.getEngine();
        engine.load("http://javafx.com");
    }
}
