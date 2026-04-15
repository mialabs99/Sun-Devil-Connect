package view;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Leader;

import static controller.SaveLoadData.saveClub;
import static controller.ViewManager.displayLeaderView;

public class ClubCreationUI {
    
    private static TextField name;

    public static Parent clubCreation(Leader leader) {
        String currentUser = leader.getFirstName() + " " + leader.getLastName();
        VBox clubCreationBox = new VBox();
        HBox clubName = createHBox("Club Name: ");
        HBox clubType = new HBox();
        Label typeLabel = new Label("Club Type: ");
        ComboBox<String> dropdown = new ComboBox<>();
        dropdown.getItems().add("Academic");
        dropdown.getItems().add("Social");
        dropdown.getItems().add("Religious");
        dropdown.getItems().add("Culture");
        dropdown.getItems().add("Sport");
        dropdown.getItems().add("Civic Engagement");
        dropdown.getItems().add("Special Interest");
        clubType.getChildren().addAll(typeLabel, dropdown);
        Button createClub = new Button("Create Club");
        createClub.setOnAction(e -> {
            try {
                saveClub(name.getText(), dropdown.getValue(), currentUser);
                displayLeaderView(leader);
            } catch (Exception ex) {
                System.out.println("Could not save club to the system: " + ex.getMessage());
            }
        });
        clubCreationBox.getChildren().addAll(clubName, clubType, createClub);
        clubCreationBox.setSpacing(10);
        clubCreationBox.setAlignment(Pos.CENTER);
        return clubCreationBox;
    }

    public static HBox createHBox(String label) {
        HBox newHBox = new HBox();
        Label newLabel = new Label(label);
        newHBox.getChildren().add(newLabel);
        if(label.equals("Club Name: ")) {
            name = new TextField();
            newHBox.getChildren().add(name);
        }
        return newHBox;
    }
}
