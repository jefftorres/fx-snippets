package com.chef.fxstart;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class EffectsAndTransforms extends Application {
    double angle = 0.0;
    double scaleFactor = 0.4;
    double blurValue = 0.0;

    // Effects/Transforms
    Reflection reflection = new Reflection();
    BoxBlur blur = new BoxBlur(1.0, 1.0, 1);
    Rotate rotate = new Rotate();
    Scale scale = new Scale(scaleFactor, scaleFactor);

    // Buttons
    Button btnRotate = new Button("Rotate");
    Button btnBlur = new Button("Blur off");
    Button btnScale = new Button("Scale");

    Label reflect = new Label("Reflection adds visual sparkle");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Move things and pull them");

        FlowPane pane = new FlowPane(20, 20);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane, 300, 120);
        primaryStage.setScene(scene);

        // Add rotation to the transforms list
        btnRotate.getTransforms().add(rotate);
        // Add scale to the transform list
        btnScale.getTransforms().add(scale);

        reflection.setTopOpacity(0.7);
        reflection.setBottomOpacity(0.3);
        reflect.setEffect(reflection);

        btnRotate.setOnAction(ae -> {
            // When a button is pressed, turn 30 degrees over its center
            angle += 30.0;

            rotate.setAngle(angle);
            rotate.setPivotX(btnRotate.getWidth()/2);
            rotate.setPivotY(btnRotate.getHeight()/2);
        });

        btnScale.setOnAction(ae -> {
            // When the button is pressed, change its scale
            scaleFactor += 0.1;
            if (scaleFactor > 2.0) scaleFactor = 0.4;

            scale.setX(scaleFactor);
            scale.setY(scaleFactor);
        });

        btnBlur.setOnAction(ae -> {
            // Every time the button is pressed, change the blur
            if (blurValue == 10.0) {
                blurValue = 1.0;
                btnBlur.setEffect(null);
                btnBlur.setText("Blur off");
            } else {
                blurValue++;
                btnBlur.setEffect(blur);
                btnBlur.setText("Blur on");
            }

            blur.setWidth(blurValue);
            blur.setHeight(blurValue);
        });

        pane.getChildren().addAll(btnRotate, btnScale, btnBlur, reflect);
        primaryStage.show();
    }
}
