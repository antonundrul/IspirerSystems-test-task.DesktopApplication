package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller {

    //task1
    @FXML private TextField nameTextField;
    @FXML private TextField ageTextField;
    @FXML private Button addUserButton;
    @FXML private TextField usersNumberTextField;

    //task2
    @FXML private TableView<User> usersTableView;
    @FXML private TableColumn<User, String> nameColumn;
    @FXML private TableColumn<User, String> ageColumn;
    @FXML private TextField listSizeTextField;
    @FXML private TextField findUserByNumberTextField;
    @FXML private Button findUserButton;
    @FXML private TextField foundNameTextField;
    @FXML private TextField foundAgeTextField;

    //task3
    @FXML private Button showInfoButton;
    @FXML private MenuButton languagesMenuButton;
    @FXML private MenuItem russianMenuItem;
    @FXML private MenuItem englishMenuItem;
    @FXML private Label languageLabel;
    @FXML private Label taskLabel;

    private Language currentLanguage = Language.RUSSIAN;
    private ListUsr<User> users = new ListUsr<>();

    public void addUserButtonClick(){
       String name = nameTextField.getText();
       int age = Integer.parseInt(ageTextField.getText());

       User newUser = new User(name,age);

       nameTextField.setText("");
       ageTextField.setText("");
       usersNumberTextField.setText(String.valueOf(User.count()));
       users.add(newUser);
       listSizeTextField.setText(String.valueOf(users.getSize()));
       userTableInit();

    }

    public void userTableInit() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        usersTableView.setItems(getUserObservableList());
    }

    public ObservableList<User> getUserObservableList() {
        List<User> userList = users.castToList();
        return FXCollections.observableList(userList);
    }

    public void findUserButtonClick(){
        int userNumber = Integer.parseInt(findUserByNumberTextField.getText());
        User foundUser = users.get(userNumber);

        foundNameTextField.setText(foundUser.getName());
        foundAgeTextField.setText(String.valueOf(foundUser.getAge()));

        findUserByNumberTextField.setText("");

    }


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
