package de.dopemathers.taschenrechner;

import com.google.gson.Gson;
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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class Calculator extends Application
{

    private static final Image img16 = new Image(Objects.requireNonNull(Calculator.class.getResourceAsStream("images/icon/icon16.png")));
    private static final Image img32 = new Image(Objects.requireNonNull(Calculator.class.getResourceAsStream("images/icon/icon32.png")));
    private static final Image img64 = new Image(Objects.requireNonNull(Calculator.class.getResourceAsStream("images/icon/icon64.png")));
    private static final Image img128 = new Image(Objects.requireNonNull(Calculator.class.getResourceAsStream("images/icon/icon128.png")));
    private static final Image img256 = new Image(Objects.requireNonNull(Calculator.class.getResourceAsStream("images/icon/icon256.png")));
    private static final Image img512 = new Image(Objects.requireNonNull(Calculator.class.getResourceAsStream("images/icon/icon512.png")));

    private static Gson gson;
    private static boolean fileExists = true;
    private static FileReader reader = null;
    private static Config config = null;

    private static String style = "taschenrechner-darkmode.css";
    private static ResourceBundle bundle;
    private static Stage stg;

    //public static String actualStyle;
    public static Locale actualLocale;
    private static FXMLLoader fxmlLoader;

    public static void main(String[] args)
    {
        gson = new Gson();
        actualLocale = new Locale("en","EN");

        try
        {
           reader = new FileReader("config.json");
           config = gson.fromJson(reader,Config.class);
        }
        catch (FileNotFoundException e)
        {
            config = new Config(new Locale("en","EN"),"taschenrechner-darkmode.css");
            changeConfig();
        }

        launch();
    }

    public static void changeConfig()
    {
        try
        {
            FileWriter writer = new FileWriter("config.json");
            gson.toJson(config, writer);
            writer.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void start(Stage stage) throws IOException
    {

        stg = stage;
        style = config.getDesign();
        actualLocale = config.getLanguage();

        FXMLLoader fxmlLoader = new FXMLLoader(Calculator.class.getResource("calculatorWindow.fxml"));
        //noinspection deprecation
        fxmlLoader.setResources(ResourceBundle.getBundle("lang", actualLocale));
        this.fxmlLoader = fxmlLoader;
        bundle = fxmlLoader.getResources();

        Scene scene = new Scene(fxmlLoader.load(), 400, 430);

        setStyle(scene,style);
        initStage();
    }

    private static void initStage()
    {
        stg.setMinHeight(490);
        stg.setMinWidth(440);
        stg.setTitle(bundle.getString("window-title"));

        stg.getIcons().add(img16);
        stg.getIcons().add(img32);
        stg.getIcons().add(img64);
        stg.getIcons().add(img128);
        stg.getIcons().add(img256);
        stg.getIcons().add(img512);

        stg.show();
    }

    public static void initTextField(FXMLLoader fxmlLoader)
    {
        UserInputs u = fxmlLoader.getController();
        u.initTextField();
    }

    public static void setLanguage(String language, String country, Scene scn) throws IOException
    {
        actualLocale = new Locale(language,country);
        FXMLLoader fxmlLoader = new FXMLLoader(Calculator.class.getResource("calculatorWindow.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("lang", actualLocale));
        bundle = fxmlLoader.getResources();
        stg.setTitle(bundle.getString("window-title"));
        Scene scene = new Scene(fxmlLoader.load(), scn.getWidth(), scn.getHeight());
        UserInputs.initKeyEvents(scene);
        initTextField(fxmlLoader);
        setStyle(scene,style);
        stg.setScene(scene);
        config.setLanguage(actualLocale);
        changeConfig();
    }

    public static void setStyle(Scene scn, String mode) throws IOException
    {
        String  style= Calculator.class.getResource("styles/" + mode).toExternalForm();
        scn.getStylesheets().clear();
        UserInputs.initKeyEvents(scn);
        initTextField(fxmlLoader);
        scn.getStylesheets().add(style);
        stg.setScene(scn);
        style = mode;
        config.setDesign(style);
        changeConfig();
    }

    public static void exitApp()
    {
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

    public static void saveStyle(String style)
    {
        Calculator.style = style;
    }

    public static String getStyle()
    {
        return style;
    }

    public static Image getImg16()
    {
        return img16;
    }

    public static Image getImg32()
    {
        return img32;
    }

    public static Image getImg64()
    {
        return img64;
    }

    public static Image getImg128()
    {
        return img128;
    }

    public static Image getImg256()
    {
        return img256;
    }

    public static Image getImg512()
    {
        return img512;
    }

    public static ResourceBundle getBundle()
    {
        return bundle;
    }

}