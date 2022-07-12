
package LiveScores.mainUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Debug Entity
 */
public class UpdateController implements Initializable {

    @FXML
    private Label __team_x;
    @FXML
    private Label __team_y;
    
    @FXML
    private Label __inningsCount;
    @FXML
    private Label __overCount;
    @FXML
    private Label __ballCount;
    
    
    @FXML
    private Button scorebutton__1;
    @FXML
    private Button scorebutton__2;
    @FXML
    private Button scorebutton__3;
    @FXML
    private Button scorebutton__4;
    @FXML
    private Button scorebutton__5;
    @FXML
    private Button scorebutton__6;
    
    @FXML
    private Button __noball;
    @FXML
    private Button __dotball;
    @FXML
    private Button __wideball;
    @FXML
    private ComboBox<?> xtra_runs;
    @FXML
    private ComboBox<?> __wicket;
    @FXML
    private ComboBox<?> batsman__1;
    @FXML
    private ComboBox<?> batsman__2;
    @FXML
    private ComboBox<?> __bowler;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void setTossResult(ActionEvent event) {
    }

    @FXML
    private void ____update(ActionEvent event) {
    }
    
}
