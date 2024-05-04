package de.dopemathers.taschenrechner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    private static String actualStyle;

    @Override
    public void start(Stage stage) throws IOException
    {

        FXMLLoader fxmlLoader = new FXMLLoader(Calculator.class.getResource("calculatorWindow.fxml"));

        //noinspection deprecation
        fxmlLoader.setResources(ResourceBundle.getBundle("lang", new Locale("de", "DE")));
        bundle = fxmlLoader.getResources();

        Scene scene = new Scene(fxmlLoader.load(), 400, 430);

        initKeyEvents(scene);

        stage.setMinHeight(430);
        stage.setMinWidth(400);
        stage.setTitle(bundle.getString("window-title"));

        stage.getIcons().add(img16);
        stage.getIcons().add(img32);
        stage.getIcons().add(img64);
        stage.getIcons().add(img128);
        stage.getIcons().add(img256);
        stage.getIcons().add(img512);
        stg = stage;


        initTextField(fxmlLoader);
        setStyle(scene,"taschenrechner-greenmode.css");

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
        bundle = fxmlLoader.getResources();
        stg.setTitle(bundle.getString("window-title")); //geht das onTheFly! JUUUP es geht otf nice !
        Scene scene = new Scene(fxmlLoader.load(), 400, 430);
        initKeyEvents(scene);
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

    private static void initKeyEvents(Scene scene)
    {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
        {
            if(key.getCode()== KeyCode.ENTER) {
                System.out.println("You pressed enter");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD1 || key.getCode()==KeyCode.DIGIT1) {
                System.out.println("You pressed 1");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD2 || key.getCode()==KeyCode.DIGIT2) {
                System.out.println("You pressed 2");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD3 || key.getCode()==KeyCode.DIGIT3) {
                System.out.println("You pressed 3");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD4 || key.getCode()==KeyCode.DIGIT4) {
                System.out.println("You pressed 4");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD5 || key.getCode()==KeyCode.DIGIT5) {
                System.out.println("You pressed 5");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD6 || key.getCode()==KeyCode.DIGIT6) {
                System.out.println("You pressed 6");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD7 || key.getCode()==KeyCode.DIGIT7) {
                System.out.println("You pressed 7");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD8 || key.getCode()==KeyCode.DIGIT8) {
                System.out.println("You pressed 8");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD9 || key.getCode()==KeyCode.DIGIT9) {
                System.out.println("You pressed 9");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.NUMPAD0 || key.getCode()==KeyCode.DIGIT0) {
                System.out.println("You pressed 0");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.MINUS) {
                System.out.println("You pressed -");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.PLUS) {
                System.out.println("You pressed +");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.MULTIPLY) {
                System.out.println("You pressed *");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.DIVIDE) {
                System.out.println("You pressed /");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.BACK_SPACE) {
                System.out.println("You pressed Löschen");
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()==KeyCode.ESCAPE) {
                System.out.println("You pressed Escape");
            }
        });
    }


}