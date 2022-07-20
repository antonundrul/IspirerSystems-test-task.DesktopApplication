package sample;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private Button showInfoButton;
    @FXML
    private MenuButton languagesMenuButton;
    @FXML
    private MenuItem russianMenuItem;
    @FXML
    private MenuItem englishMenuItem;
    @FXML
    private Label languageLabel;
    @FXML
    private Label taskLabel;

    private Language currentLanguage = Language.RUSSIAN;

    public void changeOnRussian() {
        Locale.setDefault(new Locale("ru"));
        ResourceBundle rb = ResourceBundle.getBundle("resourceBundle");
        changeLanguage(rb);
        currentLanguage = Language.RUSSIAN;
    }

    public void changeOnEnglish() {
        Locale.setDefault(new Locale("en"));
        ResourceBundle rb = ResourceBundle.getBundle("resourceBundle");
        changeLanguage(rb);
        currentLanguage = Language.ENGLISH;
    }

    public void onButtonClick() {

        Label secondLabel = new Label();

        if (currentLanguage.equals(Language.ENGLISH)) {
            Locale.setDefault(new Locale("en"));
            ResourceBundle rb = ResourceBundle.getBundle("resourceBundle");
            secondLabel.setText(rb.getString("info"));
        } else {
            Locale.setDefault(new Locale("ru"));
            ResourceBundle rb = ResourceBundle.getBundle("resourceBundle");
            secondLabel.setText(rb.getString("info"));
        }

        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(secondLabel);

        Scene secondScene = new Scene(secondaryLayout, 400, 200);

        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Second Stage");
        newWindow.setScene(secondScene);

        newWindow.show();

    }

    private void changeLanguage(ResourceBundle rb) {
        showInfoButton.setText(rb.getString("buttonText"));
        languageLabel.setText(rb.getString("labelText"));
        languagesMenuButton.setText(rb.getString("chooseLanguageMenuButtonText"));
        russianMenuItem.setText(rb.getString("russianMenuItemText"));
        englishMenuItem.setText(rb.getString("englishMenuItemText"));
        taskLabel.setText(rb.getString("taskLabelText"));
    }
}
