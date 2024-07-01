package com.chef.fxstart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ListViews extends Application {
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lists and how to select them with multiple selection");

        FlowPane pane = new FlowPane(10, 10);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane, 200,120);
        primaryStage.setScene(scene);

        response = new Label("Select device type");

        // Get an ObservableList of entries to the ListView
        ObservableList<String> deviceTypes = FXCollections
                .observableArrayList("Smartphone", "Tablet", "Notebook", "Desktop");

        // Creates a ListView
        ListView<String> lvDevices = new ListView<>(deviceTypes);
        lvDevices.setPrefSize(100, 70);

        // Creates a new SelectionModel using the ListView
        // then it uses MultipleSelectionModel even with single selection
        MultipleSelectionModel<String> lvSelModel = lvDevices.getSelectionModel();

        // To support multiple selection just use
        // lvSelModel.setSelectionMode(SelectionMode.MULTIPLE);

        // To get selected items on multiple selection:
        // lvSelModel.getSelectedItems();

        // Add an event listener for every selected item in the list
        lvSelModel.selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> response.setText("Device selected is " + newValue));

        pane.getChildren().addAll(lvDevices, response);
        primaryStage.show();
    }
}
