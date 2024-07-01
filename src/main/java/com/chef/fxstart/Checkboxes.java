package com.chef.fxstart;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Checkboxes extends Application {
    CheckBox cbSmartphone;
    CheckBox cbTablet;
    CheckBox cbNotebook;
    CheckBox cbDesktop;

    Label response;
    Label selected;

    String devices;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Checkboxes demo yea");

        // Now they'll be one over another instead of inline
        // Also 10px of padding
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);

        // Center
        rootNode.setAlignment(Pos.CENTER);

        Scene scene = new Scene(rootNode, 240, 300);
        primaryStage.setScene(scene);

        Label heading = new Label("What devices do you own?");

        // This label is to notify from last changed checkbox
        response = new Label("");
        // This label checks for every checkbox selected
        selected = new Label("");

        cbSmartphone = new CheckBox("Smartphone");
        cbSmartphone.setAllowIndeterminate(true);
        cbTablet = new CheckBox("Tablet");
        cbNotebook = new CheckBox("Notebook");
        cbDesktop = new CheckBox("Desktop");

        // Add check/uncheck handlers for every device
        // There should be like... a better way to do this but just to follow the book
        cbSmartphone.setOnAction(ae -> {
            if (cbSmartphone.isIndeterminate()) {
                response.setText("Smartphone state is indeterminate");
            } else if (cbSmartphone.isSelected()) {
                response.setText("Smartphone was selected");
            } else {
                response.setText("Smartphone was cleared");
            }

            showAll();
        });

        cbTablet.setOnAction(ae -> {
            if (cbTablet.isSelected()) {
                response.setText("Tablet was selected");
            } else {
                response.setText("Tablet was cleared");
            }

            showAll();
        });

        cbNotebook.setOnAction(ae -> {
            if (cbNotebook.isSelected()) {
                response.setText("Notebook was selected");
            } else {
                response.setText("Notebook was cleared");
            }

            showAll();
        });

        cbDesktop.setOnAction(ae -> {
            if (cbDesktop.isSelected()) {
                response.setText("Desktop was selected");
            } else {
                response.setText("Desktop was cleared");
            }

            showAll();
        });

        rootNode.getChildren().addAll(heading, cbSmartphone, cbTablet,
                cbNotebook, cbDesktop, response, selected);

        primaryStage.show();
    }

    private void showAll() {
        devices = "";
        if (cbSmartphone.isSelected()) devices += "\nSmartphone ";
        if (cbTablet.isSelected()) devices += "\nTablet ";
        if (cbNotebook.isSelected()) devices += "\nNotebook ";
        if (cbDesktop.isSelected()) devices += "\nDesktop ";

        selected.setText("Devices selected: " + devices);
    }
}
