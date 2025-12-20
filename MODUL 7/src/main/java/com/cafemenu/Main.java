package com.cafemenu;

import com.cafemenu.controller.MainController;
import com.cafemenu.repository.InMemoryRepository;
import com.cafemenu.factory.MenuItemFactory;
import com.cafemenu.repository.Repository;
import com.cafemenu.service.Service;
import com.cafemenu.service.ServiceImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.println("=== Starting Cafe Menu Application ===");

            Repository repo = new InMemoryRepository();
            MenuItemFactory factory = new MenuItemFactory();
            Service service = new ServiceImpl(repo, factory);

            System.out.println("Initializing sample data...");
            initializeSampleData(service);

            System.out.println("Items in repository: " + repo.findAll().size());

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/cafemenu/MainView.fxml"));

            if (loader.getLocation() == null) {
                System.err.println("ERROR: Cannot find MainView.fxml!");
                System.err.println("Check if file exists at: src/main/resources/com/cafemenu/MainView.fxml");
                return;
            }

            System.out.println("Loading FXML from: " + loader.getLocation());
            Parent root = loader.load();

            MainController controller = loader.getController();
            if (controller != null) {
                controller.setService(service);
                System.out.println("Controller initialized successfully");

                controller.refreshData();
            } else {
                System.err.println("ERROR: Controller is null!");
                System.err.println("Check fx:controller in FXML file");
                return;
            }

            Scene scene = new Scene(root);
            primaryStage.setTitle("Sistem Manajemen Menu Kafe");
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(1000);
            primaryStage.setMinHeight(600);
            primaryStage.show();

            System.out.println("=== Application Started Successfully ===");

        } catch (Exception e) {
            System.err.println("ERROR during application start:");
            e.printStackTrace();

            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(
                    javafx.scene.control.Alert.AlertType.ERROR);
            alert.setTitle("Application Error");
            alert.setHeaderText("Failed to start application");
            alert.setContentText("Error: " + e.getMessage());
            alert.showAndWait();
        }
    }

    private void initializeSampleData(Service service) {
        try {
            System.out.println("Adding sample data to service...");

            service.createMenuItem(new com.cafemenu.model.dto.DTO()
                    .id("D001")
                    .name("Americano")
                    .category("Kopi")
                    .type("Drink")
                    .price(28000)
                    .description("Espresso dengan air panas"));

            service.createMenuItem(new com.cafemenu.model.dto.DTO()
                    .id("D002")
                    .name("Cappuccino")
                    .category("Kopi")
                    .type("Drink")
                    .price(32000)
                    .description("Espresso dengan susu steamed dan busa susu"));

            service.createMenuItem(new com.cafemenu.model.dto.DTO()
                    .id("D003")
                    .name("Matcha Latte")
                    .category("Teh")
                    .type("Drink")
                    .price(35000)
                    .description("Matcha premium dengan susu"));

            service.createMenuItem(new com.cafemenu.model.dto.DTO()
                    .id("F001")
                    .name("Nasi Goreng Spesial")
                    .category("Makanan Utama")
                    .type("Food")
                    .price(45000)
                    .description("Nasi goreng dengan telur, ayam, dan sayuran"));

            service.createMenuItem(new com.cafemenu.model.dto.DTO()
                    .id("F002")
                    .name("French Fries")
                    .category("Makanan Ringan")
                    .type("Food")
                    .price(25000)
                    .description("Kentang goreng renyah dengan saus pilihan"));

            service.createMenuItem(new com.cafemenu.model.dto.DTO()
                    .id("F003")
                    .name("Brownies")
                    .category("Makanan Penutup")
                    .type("Food")
                    .price(20000)
                    .description("Brownies coklat dengan topping almond"));

            System.out.println("Sample data initialized successfully");

        } catch (Exception e) {
            System.err.println("Error initializing sample data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Cafe Menu Management System ===");
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Launching application...");
        launch(args);
    }
}