package com.chef.fxstart;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TextFields extends Application {
    TextField tf;
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("In this box you can put text");

        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);

        Scene scene = new Scene(rootNode, 230, 140);
        primaryStage.setScene(scene);

        response = new Label("Enter Name: ");

        Button btnGetText = new Button("Get Name");

        // Creates the text field
        tf = new TextField();
        // Setting a placeholder
        tf.setPromptText("Enter a name");
        // Sets a custom size for the text field
        tf.setPrefColumnCount(15);

        // Event triggers when pressing Enter key focused on the text field
        tf.setOnAction(ae -> response.setText("Enter pressed. Name is: " + tf.getText()));
        // Trigger for button
        btnGetText.setOnAction(ae -> response.setText("Button pressed. Name is: " + tf.getText()));

        // Separator to uh, separate, yeah. Similar to <hr>
        Separator separator = new Separator();
        separator.setPrefWidth(180);

        // TODO Check other text based controls: TextArea, PasswordField, HTMLEditor, TextInputDialog

        rootNode.getChildren().addAll(tf, btnGetText, separator, response);
        primaryStage.show();
    }
}
