package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button insert;

    @FXML
    private Button delete;

    @FXML
    private Button update;

    @FXML
    private Button search;

    @FXML
    private TextField username;

    @FXML
    private TextField email;

    @FXML
    private TextField address;

    @FXML
    private TextField phone;

    @FXML
    private PasswordField password;
    @FXML
    private TextField id;
    Start start;


    public void insertAction(ActionEvent actionEvent) {

        start.insert(id.getText(), username.getText(), password.getText(), email.getText(), address.getText(), phone.getText());

    }

    public void updateAction(ActionEvent actionEvent) {


        if (id.getText().equals("") || id.getText() == null) {
            new dialog(Alert.AlertType.ERROR, "Id Null", "Id Null");


        } else {
            System.out.println("update.....");
            start.update(id.getText(), username.getText(), password.getText(), email.getText(), address.getText(), phone.getText());

        }
    }

    public void deleteAction(ActionEvent actionEvent) {
        if (id.getText().equals("") || id.getText() == null) {
            new dialog(Alert.AlertType.ERROR, "Id Null", "Id Null");

        } else {
            start.delete(id.getText());

        }

    }

    public void SearchAction(ActionEvent actionEvent) {
        if (id.getText().equals("") || id.getText() == null) {
            new dialog(Alert.AlertType.ERROR, "Id Null", "Id Null");

        } else {
            Map map = start.find(id.getText());

            username.setText(map.get("username").toString());
            password.setText(map.get("password").toString());
            email.setText(map.get("email").toString());
            address.setText(map.get("Address").toString());
            phone.setText(map.get("phone").toString());


        }


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        start = new Start();

//        new dialog(Alert.AlertType.INFORMATION ,"Done","Done");

    }
}
