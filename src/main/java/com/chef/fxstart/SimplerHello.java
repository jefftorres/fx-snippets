package com.chef.fxstart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.logging.Logger;

// Ok this one should not be using pre-made stuff by ide's project builder
public class SimplerHello extends Application {
    private static final Logger logger = Logger.getLogger(SimplerHello.class.getName());

    @Override
    public void init() {
        // This method can't be used to create the scene nor its parts
        logger.info("On the init() method");
    }

    @Override
    public void start(Stage stage) {
        logger.info("On the start() method");
        stage.setTitle("JavaFX Hello World");

        FlowPane rootNode = new FlowPane();

        Scene scene = new Scene(rootNode, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public void stop() {
        // This method executes after start() returns, before application closes
        logger.info("On the stop() method");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
