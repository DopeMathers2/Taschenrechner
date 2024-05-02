package de.dopemathers.taschenrechner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class Calculator extends Application
{

    private final Image img16 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/icon/icon16.png")));
    private final Image img32 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/icon/icon32.png")));
    private final Image img64 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/icon/icon64.png")));
    private final Image img128 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/icon/icon128.png")));
    private final Image img256 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/icon/icon256.png")));
    private final Image img512 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/icon/icon512.png")));
    private static ResourceBundle bundle;
    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Calculator.class.getResource("calculatorWindow.fxml"));

        //noinspection deprecation
        fxmlLoader.setResources(ResourceBundle.getBundle("lang", new Locale("de", "DE")));
        bundle = fxmlLoader.getResources();

        Scene scene = new Scene(fxmlLoader.load(), 400, 430);

        stage.setMinHeight(430);
        stage.setMinWidth(400);
        stage.setTitle(bundle.getString("window-title"));

        stage.getIcons().add(img16);
        stage.getIcons().add(img32);
        stage.getIcons().add(img64);
        stage.getIcons().add(img128);
        stage.getIcons().add(img256);
        stage.getIcons().add(img512);

        stage.setScene(scene);
        stage.show();
        stg = stage;

    }

    public static void main(String[] args)
    {
        launch();
    }

    public static ResourceBundle getBundle(){
        return bundle;
    }

    public static void setLanguage(String language, String country) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Calculator.class.getResource("calculatorWindow.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("lang", new Locale(language,country)));
        bundle = fxmlLoader.getResources();
        stg.setTitle(bundle.getString("window-title")); //geht das onTheFly! JUUUP es geht otf nice !
        Scene scene = new Scene(fxmlLoader.load(), 400, 430);
        stg.setScene(scene);
    }

    public static void setStyle()
    {
        //Implement das User zwischen Designes wechseln kann, sprich er kann zwischen den CSS Dateien switchen
    }

    public static void exitApp(){
        Platform.exit();
    }

    public static void maxApp()
    {
        stg.setFullScreen(true);
    }

    public static void minApp()
    {
        stg.setIconified(true);
    }
}