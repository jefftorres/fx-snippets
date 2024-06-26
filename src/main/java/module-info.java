module com.chef.fxstart {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.chef.fxstart to javafx.fxml;
    exports com.chef.fxstart;
}