import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class LocationDetectorResponsive extends Application {

    private Label locationLabel;
    private TextField phoneNumberField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Location Detector");

        locationLabel = new Label("Location: Unknown");
        locationLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");

        Button simulateButton = new Button("Simulate Location Change");
        simulateButton.setStyle("-fx-background-color: #00796B; -fx-text-fill: white;");
        simulateButton.setOnAction(e -> simulateLocationChange());

        phoneNumberField = new TextField();
        phoneNumberField.setPromptText("Enter Phone Number");
        phoneNumberField.setStyle("-fx-font-size: 14;");

        Button checkPhoneNumberButton = new Button("Check Phone Number");
        checkPhoneNumberButton.setStyle("-fx-background-color: #00796B; -fx-text-fill: white;");
        checkPhoneNumberButton.setOnAction(e -> checkPhoneNumber());

        Hyperlink contactLink = new Hyperlink("Contact DammyTech");
        contactLink.setStyle("-fx-text-fill: #00796B; -fx-font-size: 14; -fx-underline: true;");
        contactLink.setOnAction(e -> openContactLink());

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.getChildren().addAll(locationLabel, simulateButton, phoneNumberField, checkPhoneNumberButton, contactLink);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox, 300, 300);
        scene.setFill(Color.web("#00796B")); // Set the scene background color

        // Add listener for screen size changes
        Screen screen = Screen.getPrimary();
        scene.widthProperty().addListener((observable, oldValue, newValue) -> {
            double screenWidth = screen.getBounds().getWidth();
            if (newValue.doubleValue() < screenWidth / 2) {
                // Apply mobile styles
                applyMobileStyles();
            } else {
                // Apply desktop styles
                applyDesktopStyles();
            }
        });

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void applyDesktopStyles() {
        locationLabel.setStyle("-fx-font-size: 16; -fx-text-fill: white;");
        phoneNumberField.setStyle("-fx-font-size: 14;");
    }

    private void applyMobileStyles() {
        locationLabel.setStyle("-fx-font-size: 14; -fx-text-fill: white;");
        phoneNumberField.setStyle("-fx-font-size: 12;");
    }

    private void simulateLocationChange() {
        // Simulate a scenario where the location is not available
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Location Warning");
        alert.setHeaderText(null);
        alert.setContentText("Your location is not available or visible. Please turn on your location services.");
        alert.showAndWait();
    }

    private void onLocationChanged(double latitude, double longitude) {
        String locationText = "Latitude: " + latitude + ", Longitude: " + longitude;
        String phoneNumber = getPhoneNumber();
        String combinedInfo = locationText + "\nPhone Number: " + phoneNumber;

        locationLabel.setText(combinedInfo);
    }

    private void checkPhoneNumber() {
        String phoneNumber = phoneNumberField.getText();

        // Simulate a scenario where the phone number is not valid
        if (!isValidPhoneNumber(phoneNumber)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Phone Number Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid phone number.");
            alert.showAndWait();
        }
    }

    private String getPhoneNumber() {
        return phoneNumberField.getText();
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        
        return !phoneNumber.trim().isEmpty();
    }

    private void openContactLink() {
        // Open the contact link in the default web browser
        String url = "https://dammytech.netlify.app";
        getHostServices().showDocument(url);
    }
}
