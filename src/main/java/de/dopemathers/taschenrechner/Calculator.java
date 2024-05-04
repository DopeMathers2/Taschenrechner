package de.dopemathers.taschenrechner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class Calculator extends Application
{

    public static Image getImg16() {
        return img16;
    }

    public static Image getImg32() {
        return img32;
    }

    public static Image getImg64() {
        return img64;
    }

    public static Image getImg128() {
        return img128;
    }

    public static Image getImg256() {
        return img256;
    }

    public static Image getImg512() {
        return img512;
    }

    private static final Image img16 = new Image(Objects.requireNonNull(Calculator.class.getResourceAsStream("images/icon/icon16.png")));
    private static final Image img32 = new Image(Objects.requireNonNull(Calculator.class.getResourceAsStream("images/icon/icon32.png")));
    private static final Image img64 = new Image(Objects.requireNonNull(Calculator.class.getResourceAsStream("images/icon/icon64.png")));
    private static final Image img128 = new Image(Objects.requireNonNull(Calculator.class.getResourceAsStream("images/icon/icon128.png")));
    private static final Image img256 = new Image(Objects.requireNonNull(Calculator.class.getResourceAsStream("images/icon/icon256.png")));
    private static final Image img512 = new Image(Objects.requireNonNull(Calculator.class.getResourceAsStream("images/icon/icon512.png")));
    private static ResourceBundle bundle;
    private static Stage stg;

    public static String actualStyle;
    public static Locale actualLocale;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Calculator.class.getResource("calculatorWindow.fxml"));

        //noinspection deprecation
        fxmlLoader.setResources(ResourceBundle.getBundle("lang", new Locale("de", "DE")));
        bundle = fxmlLoader.getResources();

        actualLocale = new Locale("de","DE");

        Scene scene = new Scene(fxmlLoader.load(), 400, 430);

        UserInputs.initKeyEvents(scene);

        stage.setMinHeight(490);
        stage.setMinWidth(440);
        stage.setTitle(bundle.getString("window-title"));

        stage.getIcons().add(img16);
        stage.getIcons().add(img32);
        stage.getIcons().add(img64);
        stage.getIcons().add(img128);
        stage.getIcons().add(img256);
        stage.getIcons().add(img512);
        stg = stage;


        initTextField(fxmlLoader);
        setStyle(scene,"taschenrechner-darkmode.css");

        stage.show();


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
        actualLocale = new Locale(language,country);
        bundle = fxmlLoader.getResources();
        stg.setTitle(bundle.getString("window-title")); //geht das onTheFly! JUUUP es geht otf nice !
        Scene scene = new Scene(fxmlLoader.load(), 400, 430);
        UserInputs.initKeyEvents(scene);
        initTextField(fxmlLoader);
        setStyle(scene,actualStyle);
        stg.setScene(scene);

    }

    public static void initTextField(FXMLLoader fxmlLoader)
    {
        UserInputs u = fxmlLoader.getController();
        u.initTextField();
    }

    public static void setStyle(Scene scene, String mode)
    {
        String  style= Calculator.class.getResource("styles/" + mode).toExternalForm();
        scene.getStylesheets().add(style);
        stg.setScene(scene);
        actualStyle = mode;
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