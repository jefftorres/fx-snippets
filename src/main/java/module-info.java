module com.chef.fxstart {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.chef.fxstart to javafx.fxml;
    exports com.chef.fxstart;
}