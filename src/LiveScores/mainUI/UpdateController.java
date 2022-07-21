
package LiveScores.mainUI;


import java.sql.*; //SQL classes!

import LiveScores.Services.*;


import javafx.collections.*;
import java.net.URL;
import static java.lang.Integer.parseInt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.util.ResourceBundle;


/**
 * FXML Controller class
 *
 * @author Debug Entity
 */
public class UpdateController implements Initializable {

    String Match_id;
    String team1_id;
    String team2_id;
    ObservableList<String> allPlayersTeam1 = FXCollections.observableArrayList();
    ObservableList<String> allPlayersTeam2 = FXCollections.observableArrayList();
    int tossResult = 0;
    boolean isTossSet = false,_1stInnOver = false,matchOver = false;
    int t1_score = 0,t2_score = 0;
    int inningsCount;
    int overCount = 1,ballCount = 1;
    
    @FXML
    private Label __over;
    @FXML
    private Label __ball;
    @FXML
    private Label __innings;
    @FXML
    private Button __noball;
    @FXML
    private Button __dotball;
    @FXML
    private Button __wideball;
    @FXML
    private TextField xtra_runs;
    @FXML
    private Button __wicket;
    @FXML
    private ComboBox<String> batsman__1;
    @FXML
    private ComboBox<String> batsman__2;
    @FXML
    private ComboBox<String> __bowler;
    @FXML
    private RadioButton __b1Out;
    @FXML
    private RadioButton __b2Out;
    @FXML
    private Label __team_1;
    @FXML
    private Label __team_2;
    @FXML
    private ToggleGroup __batsman_wicket;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try
        {
            DBContext db = new DBContext();
            Connection conn = db.getConnection();
            String Query = "SELECT * FROM allmatch WHERE match_id = '%s'";
            Query = String.format(Query,Match_id);
            Statement statement;
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(Query);
            while(result.next()){
                team1_id = result.getString("contestant1");
                team2_id = result.getString("contestant2");
                int innings = result.getInt("innings");
                __innings.setText(String.format("%s",innings));
                __team_1.setText(result.getString("name_contestant1"));
                __team_2.setText(result.getString("name_contestant2"));
            }
            __over.setText("1");
            __ball.setText("1");
            inningsCount = java.lang.Integer.parseInt(__innings.getText());
            Query = "SELECT captain,player1,player2,player3,player4,player5,player6,player7,player8,player9,player10 FROM allteam WHERE team_id = '%s'";
            Query = String.format(Query,team1_id);
            result = statement.executeQuery(Query);
            while(result.next()){
                allPlayersTeam1.add(result.getString("captain"));
                allPlayersTeam1.add(result.getString("player1"));
                allPlayersTeam1.add(result.getString("player2"));
                allPlayersTeam1.add(result.getString("player3"));
                allPlayersTeam1.add(result.getString("player4"));
                allPlayersTeam1.add(result.getString("player5"));
                allPlayersTeam1.add(result.getString("player6"));
                allPlayersTeam1.add(result.getString("player7"));
                allPlayersTeam1.add(result.getString("player8"));
                allPlayersTeam1.add(result.getString("player9"));
                allPlayersTeam1.add(result.getString("player10"));
            }
            Query = String.format(Query,team2_id);
            result = statement.executeQuery(Query);
            while(result.next()){
                allPlayersTeam2.add(result.getString("captain"));
                allPlayersTeam2.add(result.getString("player1"));
                allPlayersTeam2.add(result.getString("player2"));
                allPlayersTeam2.add(result.getString("player3"));
                allPlayersTeam2.add(result.getString("player4"));
                allPlayersTeam2.add(result.getString("player5"));
                allPlayersTeam2.add(result.getString("player6"));
                allPlayersTeam2.add(result.getString("player7"));
                allPlayersTeam2.add(result.getString("player8"));
                allPlayersTeam2.add(result.getString("player9"));
                allPlayersTeam2.add(result.getString("player10"));
            }
            Query = "SELECT * FROM allplayer WHERE pid = '%s' OR pid = '%s' OR pid = '%s' OR pid = '%s' OR pid = '%s' OR pid = '%s' OR pid = '%s' OR pid = '%s' OR pid = '%s' OR pid = '%s' OR pid = '%s'";
            Query = String.format(Query,
                    allPlayersTeam1.get(0),
                    allPlayersTeam1.get(1),
                    allPlayersTeam1.get(2),
                    allPlayersTeam1.get(3),
                    allPlayersTeam1.get(4),
                    allPlayersTeam1.get(5),
                    allPlayersTeam1.get(6),
                    allPlayersTeam1.get(7),
                    allPlayersTeam1.get(8),
                    allPlayersTeam1.get(9),
                    allPlayersTeam1.get(10)
                );
            allPlayersTeam1.clear();
            result = statement.executeQuery(Query);
            while(result.next()){
                allPlayersTeam1.add(result.getString("name"));
            }
            Query = String.format(Query,
                    allPlayersTeam2.get(0),
                    allPlayersTeam2.get(1),
                    allPlayersTeam2.get(2),
                    allPlayersTeam2.get(3),
                    allPlayersTeam2.get(4),
                    allPlayersTeam2.get(5),
                    allPlayersTeam2.get(6),
                    allPlayersTeam2.get(7),
                    allPlayersTeam2.get(8),
                    allPlayersTeam2.get(9),
                    allPlayersTeam2.get(10)
                );
            allPlayersTeam2.clear();
            result = statement.executeQuery(Query);
            while(result.next()){
                allPlayersTeam2.add(result.getString("name"));
            }
            
        }
        catch(SQLException | NumberFormatException e){
            System.out.println(e.getMessage());
        }
        
        while(!matchOver){
            if(matchOver){
                
            }
            if(_1stInnOver){
                
            }
        }
    }    

    @FXML
    private void setTossResult(ActionEvent event) {
        if(!isTossSet){
            if(tossResult == 1 || tossResult == 11){
                __bowler.setItems(allPlayersTeam2);
                batsman__1.setItems(allPlayersTeam1);
                batsman__2.setItems(allPlayersTeam1);
            }
            else{
                __bowler.setItems(allPlayersTeam1);
                batsman__1.setItems(allPlayersTeam2);
                batsman__2.setItems(allPlayersTeam2);
            }
            isTossSet = true;
        }
    }

    @FXML
    private void ____update(ActionEvent event) {
    }
    
    private void __matchUpdate(int run){
        if(isTossSet){
            if(tossResult == 1 || tossResult == 11){
                score(run,t1_score);
                
            }
            else{
                score(run,t2_score);
            }
            ballCount += 1;
            if(ballCount > 6){
                overCount += 1;
                ballCount = 1;
            }
            if(overCount > inningsCount){
                if(!_1stInnOver){
                    overCount = 1;
                    ballCount = 1;
                    if(tossResult == 1 || tossResult == 11){
                        __bowler.setItems(allPlayersTeam1);
                        batsman__1.setItems(allPlayersTeam2);
                        batsman__2.setItems(allPlayersTeam2);
                    }
                    else{
                        __bowler.setItems(allPlayersTeam1);
                        batsman__1.setItems(allPlayersTeam2);
                        batsman__2.setItems(allPlayersTeam2);
                    }
                    _1stInnOver = true;
                }
                else{
                    matchOver = true;
                }
            }
        }
    }
    
    private void score(int run,int teamReference){
        teamReference += run;
    }


    @FXML
    private void __noball_clicked(ActionEvent event) {
        ballCount -= 1;
        if(ballCount == 0){
            ballCount = 6;
            overCount -= 1;
        }
    }
    
    @FXML
    private void __wideball_clicked(ActionEvent event) {
        __matchUpdate(1);
    }

    @FXML
    private void __onWicket(ActionEvent event) {
        __matchUpdate(0);
    }

    @FXML
    private void __dotball_clicked(ActionEvent event) {
        __matchUpdate(0);
    }

    @FXML
    private void __sixer(ActionEvent event) {
        __matchUpdate(6);
    }

    @FXML
    private void __boundry(ActionEvent event) {
        int run = parseInt(xtra_runs.getText());
        __matchUpdate(run+4);
        xtra_runs.setText("");
    }

    @FXML
    private void __run_scored(ActionEvent event) {
        int run = parseInt(xtra_runs.getText());
        __matchUpdate(run);
        xtra_runs.setText("");
    }
    
}
