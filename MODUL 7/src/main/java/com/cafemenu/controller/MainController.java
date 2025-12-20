package com.cafemenu.controller;

import com.cafemenu.model.baseModel.MenuItem;
import com.cafemenu.model.dto.DTO;
import com.cafemenu.service.Service;
import com.cafemenu.utils.AlertUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class MainController {

    private Service service;
    private final ObservableList<MenuItem> menuItems = FXCollections.observableArrayList();
    private FilteredList<MenuItem> filteredData;

    @FXML private TextField idField;
    @FXML private ComboBox<String> jenisCombo;
    @FXML private TextField namaField;
    @FXML private ComboBox<String> kategoriCombo;
    @FXML private TextField hargaField;
    @FXML private TextArea deskripsiArea;

    @FXML private Button tambahBtn;
    @FXML private Button updateBtn;
    @FXML private Button deleteBtn;
    @FXML private Button clearBtn;

    @FXML private TableView<MenuItem> menuTableView;
    @FXML private TableColumn<MenuItem, String> idCol;
    @FXML private TableColumn<MenuItem, String> namaCol;
    @FXML private TableColumn<MenuItem, Double> hargaCol;
    @FXML private TableColumn<MenuItem, String> jenisCol;
    @FXML private TableColumn<MenuItem, String> kategoriCol;

    @FXML private TextField searchField;
    @FXML private ComboBox<String> filterKategoriCombo;
    @FXML private RadioButton filterAllBtn;
    @FXML private RadioButton filterMakananBtn;
    @FXML private RadioButton filterMinumanBtn;

    @FXML private Label totalItemsLabel;

    private ToggleGroup filterJenisToggleGroup;

    public MainController() {}

    public void setService(Service service) {
        this.service = service;
        if (service != null) {
            System.out.println("Service set in controller, loading data...");
            loadInitialData();
            updateCategoryFilter();
        }
    }

    @FXML
    public void initialize() {
        System.out.println("MainController initialize() called");

        filterJenisToggleGroup = new ToggleGroup();

        setupTable();
        setupForm();
        setupSearchFilter();

        tambahBtn.setOnAction(event -> handleTambah());
        updateBtn.setOnAction(event -> handleUpdate());
        deleteBtn.setOnAction(event -> handleDelete());
        clearBtn.setOnAction(event -> handleClear());

        System.out.println("MainController initialization complete");
    }

    public void refreshData() {
        System.out.println("refreshData() called");
        if (service != null) {
            loadInitialData();
            updateCategoryFilter();
        }
    }

    private void setupTable() {
        System.out.println("Setting up table...");

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        namaCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        hargaCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        jenisCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        kategoriCol.setCellValueFactory(new PropertyValueFactory<>("category"));

        hargaCol.setCellFactory(tc -> new TableCell<MenuItem, Double>() {
            @Override
            protected void updateItem(Double harga, boolean empty) {
                super.updateItem(harga, empty);
                if (empty || harga == null) {
                    setText(null);
                } else {
                    setText(String.format("Rp%,.0f", harga));
                }
            }
        });

        jenisCol.setCellFactory(tc -> new TableCell<MenuItem, String>() {
            @Override
            protected void updateItem(String jenis, boolean empty) {
                super.updateItem(jenis, empty);
                if (empty || jenis == null) {
                    setText(null);
                } else {
                    // Konversi ke bahasa Indonesia
                    if (jenis.equals("Food")) {
                        setText("Makanan");
                    } else if (jenis.equals("Drink")) {
                        setText("Minuman");
                    } else {
                        setText(jenis);
                    }
                }
            }
        });

        menuTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        System.out.println("Item selected: " + newValue.getId());
                        loadDataToForm(newValue);
                        enableButtons(false, true, true);
                    } else {
                        enableButtons(true, false, false);
                    }
                }
        );
    }

    private void setupForm() {
        System.out.println("Setting up form...");

        // Setup jenis combo
        jenisCombo.getItems().addAll("MAKANAN", "MINUMAN");
        jenisCombo.setValue("MAKANAN");

        // Setup kategori combo
        kategoriCombo.getItems().addAll(
                "Makanan Utama", "Makanan Ringan", "Makanan Penutup",
                "Kopi", "Teh", "Jus", "Mocktail", "Minuman Soda"
        );
        kategoriCombo.setValue("Makanan Utama");

        hargaField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*(\\.\\d*)?")) {
                hargaField.setText(oldValue);
            }
        });
    }

    private void setupSearchFilter() {
        System.out.println("Setting up search filter...");

        filterKategoriCombo.getItems().add("Semua");
        filterKategoriCombo.setValue("Semua");

        filteredData = new FilteredList<>(menuItems, p -> true);

        if (filterAllBtn != null && filterMakananBtn != null && filterMinumanBtn != null) {
            filterAllBtn.setToggleGroup(filterJenisToggleGroup);
            filterMakananBtn.setToggleGroup(filterJenisToggleGroup);
            filterMinumanBtn.setToggleGroup(filterJenisToggleGroup);
            filterAllBtn.setSelected(true);
        } else {
            System.err.println("Radio buttons not initialized properly!");
        }

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(menuItem -> {
                if (newValue == null || newValue.isEmpty()) {
                    return applyJenisFilter(menuItem) && applyKategoriFilter(menuItem);
                }

                String lowerCaseFilter = newValue.toLowerCase();
                return (menuItem.getId().toLowerCase().contains(lowerCaseFilter) ||
                        menuItem.getName().toLowerCase().contains(lowerCaseFilter) ||
                        menuItem.getCategory().toLowerCase().contains(lowerCaseFilter) ||
                        menuItem.getDescription().toLowerCase().contains(lowerCaseFilter)) &&
                        applyJenisFilter(menuItem) && applyKategoriFilter(menuItem);
            });
            updateTable();
        });

        filterKategoriCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(menuItem -> {
                return applyJenisFilter(menuItem) && applyKategoriFilter(menuItem);
            });
            updateTable();
        });

        if (filterJenisToggleGroup != null) {
            filterJenisToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(menuItem -> {
                    return applyJenisFilter(menuItem) && applyKategoriFilter(menuItem);
                });
                updateTable();
            });
        }

        SortedList<MenuItem> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(menuTableView.comparatorProperty());
        menuTableView.setItems(sortedData);
    }

    private boolean applyKategoriFilter(MenuItem menuItem) {
        String kategoriFilter = filterKategoriCombo.getValue();
        return kategoriFilter == null || kategoriFilter.equals("Semua") ||
                menuItem.getCategory().equals(kategoriFilter);
    }

    private boolean applyJenisFilter(MenuItem menuItem) {
        if (filterJenisToggleGroup == null) return true;

        RadioButton selectedRadioButton = (RadioButton) filterJenisToggleGroup.getSelectedToggle();
        if (selectedRadioButton == null) return true;

        if (selectedRadioButton == filterAllBtn) {
            return true;
        } else if (selectedRadioButton == filterMakananBtn) {
            return menuItem.getType().equals("Food");
        } else if (selectedRadioButton == filterMinumanBtn) {
            return menuItem.getType().equals("Drink");
        }
        return true;
    }

    private void loadInitialData() {
        if (service == null) {
            System.err.println("Service is null! Cannot load data.");
            return;
        }

        try {
            System.out.println("Loading initial data...");
            menuItems.clear();
            List<MenuItem> items = service.getAllMenuItems();
            System.out.println("Found " + items.size() + " items in service");
            menuItems.addAll(items);
            updateTable();
            enableButtons(true, false, false);
        } catch (Exception e) {
            System.err.println("Error loading initial data: " + e.getMessage());
            e.printStackTrace();
            AlertUtil.showError("Error", "Gagal memuat data: " + e.getMessage());
        }
    }

    private void updateCategoryFilter() {
        if (service == null) return;

        try {
            List<String> kategoriList = service.getAllKategori();
            filterKategoriCombo.getItems().clear();
            filterKategoriCombo.getItems().add("Semua");
            if (kategoriList != null) {
                filterKategoriCombo.getItems().addAll(kategoriList);
            }
            System.out.println("Updated category filter with " + kategoriList.size() + " categories");
        } catch (Exception e) {
            System.err.println("Error updating kategori filter: " + e.getMessage());
        }
    }

    private void updateTable() {
        menuTableView.refresh();
        int itemCount = menuTableView.getItems().size();
        totalItemsLabel.setText("Total: " + itemCount + " item" + (itemCount != 1 ? "s" : ""));
        System.out.println("Table updated. Items: " + itemCount);
    }

    @FXML
    private void handleTambah() {
        try {
            System.out.println("Handle Tambah clicked");

            // Generate ID jika kosong
            if (idField.getText().trim().isEmpty()) {
                generateNextId();
            }

            DTO dto = createDTOFromForm();

            if (!validateForm(dto)) {
                return;
            }

            System.out.println("Creating menu item: " + dto.getId() + " - " + dto.getName());
            service.createMenuItem(dto);
            loadInitialData();
            updateCategoryFilter();
            clearForm();

            AlertUtil.showInfo("Sukses", "Menu berhasil ditambahkan!");
        } catch (Exception e) {
            System.err.println("Error in handleTambah: " + e.getMessage());
            AlertUtil.showError("Error", "Gagal menambah menu: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleUpdate() {
        try {
            System.out.println("Handle Update clicked");
            MenuItem selected = menuTableView.getSelectionModel().getSelectedItem();
            if (selected == null) {
                AlertUtil.showWarning("Peringatan", "Pilih menu yang akan diupdate");
                return;
            }

            DTO dto = createDTOFromForm();
            if (!validateForm(dto)) {
                return;
            }

            System.out.println("Updating menu item: " + dto.getId());
            service.updateMenuItem(dto);
            loadInitialData();
            updateCategoryFilter();
            clearForm();

            AlertUtil.showInfo("Sukses", "Menu berhasil diupdate!");
        } catch (Exception e) {
            System.err.println("Error in handleUpdate: " + e.getMessage());
            AlertUtil.showError("Error", "Gagal mengupdate menu: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleDelete() {
        try {
            System.out.println("Handle Delete clicked");
            MenuItem selected = menuTableView.getSelectionModel().getSelectedItem();
            if (selected == null) {
                AlertUtil.showWarning("Peringatan", "Pilih menu yang akan dihapus");
                return;
            }

            if (AlertUtil.showConfirmation("Konfirmasi Hapus",
                    "Hapus menu " + selected.getName() + "?")) {
                System.out.println("Deleting menu item: " + selected.getId());
                service.deleteMenuItem(selected.getId());
                loadInitialData();
                updateCategoryFilter();
                clearForm();

                AlertUtil.showInfo("Sukses", "Menu berhasil dihapus!");
            }
        } catch (Exception e) {
            System.err.println("Error in handleDelete: " + e.getMessage());
            AlertUtil.showError("Error", "Gagal menghapus menu: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleClear() {
        System.out.println("Handle Clear clicked");
        clearForm();
    }

    private void generateNextId() {
        String jenis = jenisCombo.getValue();
        String prefix = jenis.equals("MAKANAN") ? "F" : "D";

        int maxNumber = 0;
        for (MenuItem item : menuItems) {
            if (item.getId().startsWith(prefix)) {
                try {
                    int num = Integer.parseInt(item.getId().substring(1));
                    if (num > maxNumber) {
                        maxNumber = num;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }

        String newId = String.format("%s%03d", prefix, maxNumber + 1);
        idField.setText(newId);
    }

    private DTO createDTOFromForm() {
        DTO dto = new DTO();

        String id = idField.getText().trim();
        dto.id(id);

        dto.name(namaField.getText().trim());
        dto.category(kategoriCombo.getValue());

        String hargaText = hargaField.getText().trim();
        if (hargaText.isEmpty()) {
            dto.price(0.0);
        } else {
            try {
                double harga = Double.parseDouble(hargaText);
                dto.price(harga);
            } catch (NumberFormatException e) {
                dto.price(0.0);
            }
        }

        dto.description(deskripsiArea.getText().trim());

        String jenisUI = jenisCombo.getValue();
        if (jenisUI.equals("MAKANAN")) {
            dto.type("Food");
        } else if (jenisUI.equals("MINUMAN")) {
            dto.type("Drink");
        }

        System.out.println("Created DTO: " + dto.getId() + ", " + dto.getName() + ", " + dto.getType());
        return dto;
    }

    private boolean validateForm(DTO dto) {
        if (dto.getId() == null || dto.getId().trim().isEmpty()) {
            AlertUtil.showError("Error", "ID harus diisi");
            idField.requestFocus();
            return false;
        }

        String jenis = dto.getType();
        String id = dto.getId();
        if (jenis.equals("Food") && !id.matches("F\\d{3}")) {
            AlertUtil.showError("Error", "ID makanan harus format FXXX (contoh: F001)");
            idField.requestFocus();
            return false;
        }
        if (jenis.equals("Drink") && !id.matches("D\\d{3}")) {
            AlertUtil.showError("Error", "ID minuman harus format DXXX (contoh: D001)");
            idField.requestFocus();
            return false;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            AlertUtil.showError("Error", "Nama menu harus diisi");
            namaField.requestFocus();
            return false;
        }

        if (dto.getName().length() < 3) {
            AlertUtil.showError("Error", "Nama menu minimal 3 karakter");
            namaField.requestFocus();
            return false;
        }

        if (dto.getPrice() <= 0) {
            AlertUtil.showError("Error", "Harga harus lebih dari 0");
            hargaField.requestFocus();
            return false;
        }

        if (dto.getCategory() == null || dto.getCategory().trim().isEmpty()) {
            AlertUtil.showError("Error", "Kategori harus dipilih");
            kategoriCombo.requestFocus();
            return false;
        }

        return true;
    }

    private void loadDataToForm(MenuItem item) {
        System.out.println("Loading data to form: " + item.getId());

        idField.setText(item.getId());
        namaField.setText(item.getName());
        kategoriCombo.setValue(item.getCategory());
        hargaField.setText(String.valueOf(item.getPrice()));
        deskripsiArea.setText(item.getDescription());

        if (item.getType().equals("Food")) {
            jenisCombo.setValue("MAKANAN");
        } else if (item.getType().equals("Drink")) {
            jenisCombo.setValue("MINUMAN");
        }
    }

    private void clearForm() {
        System.out.println("Clearing form");

        idField.clear();
        namaField.clear();
        kategoriCombo.setValue("Makanan Utama");
        hargaField.clear();
        jenisCombo.setValue("MAKANAN");
        deskripsiArea.clear();

        menuTableView.getSelectionModel().clearSelection();
        enableButtons(true, false, false);
    }

    private void enableButtons(boolean tambah, boolean update, boolean delete) {
        tambahBtn.setDisable(!tambah);
        updateBtn.setDisable(!update);
        deleteBtn.setDisable(!delete);
        clearBtn.setDisable(false);
    }
}