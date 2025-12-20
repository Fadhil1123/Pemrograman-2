module com.cafemenu {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.cafemenu to javafx.fxml;
    opens com.cafemenu.controller to javafx.fxml;
    opens com.cafemenu.model.baseModel to javafx.base;
    opens com.cafemenu.model.concreteModel to javafx.base;
    opens com.cafemenu.model.dto to javafx.base;

    exports com.cafemenu;
    exports com.cafemenu.controller;
}