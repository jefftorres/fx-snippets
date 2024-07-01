package com.chef.fxstart;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FxControls extends Application {
    Scene scene1;
    Label response;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Using fx controls");

        FlowPane rootNode = new FlowPane();
        Scene scene = new Scene(rootNode, 300, 200);
        stage.setScene(scene);

        Label label = new Label("This is a label, pretty good huh");
        // This adds the label to the current flowpane, showing it on the current scene
        rootNode.getChildren().add(label);

        Button hide = new Button("Hide");
        // Setting the next scene
        hide.setOnAction(event -> {
            stage.setScene(scene1);
        });
        rootNode.getChildren().add(hide);

        // To delete this control from the scene just call
        // rootNode.getChildren().remove(label);

        // TODO Search stuff about ObservableList

        // The parameters hgap and vgap are used to space the elements on the flowpane
        FlowPane second = new FlowPane(10, 10);
        // x and y center
        second.setAlignment(Pos.CENTER);

        scene1 = new Scene(second, 300, 100);
        // Default button state
        response = new Label("Push a button");

        // Create buttons
        Button btnUp = new Button("Up");
        Button btnDown = new Button("Down");

        // Adding handlers to button
        btnUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                response.setText("Up pressed");
            }
        });

        btnDown.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                response.setText("Down pressed");
            }
        });

        // Adding all elements
        second.getChildren().addAll(btnUp, btnDown, response);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
