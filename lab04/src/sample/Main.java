package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {

    private TextField uName; // username field
    private PasswordField pw; // password field
    private Button login; // login button


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Lab 04 Demo");

        GridPane gp = new GridPane();
        gp.setPadding(new Insets(10,10,10,10));
        gp.setHgap(10);
        gp.setVgap(10);


        Label uNameLabel = new Label("Username");
        uName = new TextField();
        uName.setPromptText("Username01");

        uName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if  (keyEvent.getCode() == KeyCode.ENTER)
                    pw.requestFocus();
            }
        });

        gp.add(uNameLabel, 0, 0);
        gp.add(uName, 1, 0);

        Label pwLabel =  new Label("Password");
        pw = new PasswordField();

        gp.add(pwLabel, 0, 1);
        gp.add(pw, 1, 1);


        login = new Button("Login");

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Username: " + uName.getText());
                System.out.println("Password: " + pw.getText());

                uName.clear();
                pw.clear();
            }
        });

        gp.add(login, 1, 2);



        Scene scene = new Scene(gp, 500, 300);


        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
