/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package placeholder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import placeholder.model.*;


/**
 *
 * @author Diogn Lei R. Mortera, Krixian Skye D. Del Rosario
 */
public class OptionsMenuFXMLController implements Initializable {
    
    //TODO Fix the MouseTransparency bits
    //TODO Fix the setText method
    @FXML private Rectangle diff_btn, phaseText_btn, back_btn, diffEasy_btn, diffNormal_btn, diffDifficult_btn, pT0_btn, pT1_btn, pT2_btn, pT3_btn;
    @FXML private Text textSpecial;
    @FXML private HBox difficulty_pane;
    @FXML private GridPane phaseText_pane;

    //determines what happens if certain buttons in sidebar is clicked
    @FXML private void sidebarTakeAction(MouseEvent event){
        if(event.getSource() == diff_btn){
            //set mouseTransparency of phaseText gridPane to false
            //phaseText_pane.setMouseTransparent(true);
            
            //set textSpecial to "Difficulty"
            textSpecial.setVisible(true);
            textSpecial.setText("Difficulty");
            
            //set opacity of phaseText gridPane to 20
            phaseText_pane.setVisible(false);
            
            //set mouseTransparency of diff_btn gridPane to false
            //difficulty_pane.setMouseTransparent(false);
            
            //set opacity of diff_btn gridPane to 100
            difficulty_pane.setVisible(true);
            
            //System.out.println(phaseText_pane.isMouseTransparent());
        }
        if(event.getSource() == phaseText_btn){
            //set mouseTransparency of diff_btn gridPane to false
            //difficulty_pane.setMouseTransparent(true);
            
            //set textSpecial to "Phase Text"
            textSpecial.setVisible(true);
            textSpecial.setText("Phase Text");
            
            //set opacity of diff_btn gridPane to 20
            difficulty_pane.setVisible(false);
            
            //set mouseTransparency of phaseText gridPane to true
            //phaseText_pane.setMouseTransparent(false);
            
            //set opacity of phaseText gridPane to 100
            phaseText_pane.setVisible(true);
            pT0_btn.setVisible(true);
            
            //System.out.println(phaseText_pane.isMouseTransparent());
        }
        if(event.getSource() == back_btn){
            //go back to WithinLocation menu or main menu (depends)
            
        }
    }
    
    //changes background on hover
    @FXML private void changeBackgroundOnEnter(MouseEvent event){
        Rectangle tempRectangle = (Rectangle) event.getSource();
        tempRectangle.setFill(Color.PURPLE);
        //System.out.println("hover"); /*mouse transparency checker*/
    }
    
    //changes background back to original state when user stops hovering
    @FXML public void changeBackgroundOnExit(MouseEvent event){
        Rectangle tempRectangle = (Rectangle) event.getSource();
        tempRectangle.setFill(Color.rgb(135, 87, 189));
        //System.out.println("end hover"); /*mouse transparency checker*/
    }
    
    /*protected void makeChildrenTransparent() {
        for (Parent child : getChildren()) {
          if (child instanceof Rectangle) {
            child.setMouseTransparent(true);
          } 
        }
      }*/
    
    //determines what happens if certain buttons in difficulty gridPane is clicked
    private void difficultyTakeAction(MouseEvent event){
        Protag p = Battle.getBattleList().get(Battle.getBattleNum()).getProtag();
        if(event.getSource() == diffEasy_btn){
            Settings.setDifficulty(1, p);
        }
        if(event.getSource() == diffNormal_btn){
            Settings.setDifficulty(2, p);
        }
        if(event.getSource() == diffDifficult_btn){
            Settings.setDifficulty(3, p);
        }
    }
    
    //determines what happens if certain buttons in phaseText gridPane is clicked
    private void phaseTextTakeAction(MouseEvent event){
        //make 0, 2, and 3 not do anyth for now
        if(event.getSource() == pT0_btn){
           Settings.setPhaseText(1);
        }
        if(event.getSource() == pT1_btn){
           Settings.setPhaseText(1);
        }
        if(event.getSource() == pT2_btn){
           Settings.setPhaseText(1);
        }
        if(event.getSource() == pT3_btn){
           Settings.setPhaseText(1);
        }
    }
    
    public void back(MouseEvent e) throws IOException{
        Node node = (Node) e.getSource();
        Scene currentScene = node.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Settings.getOptionsOrigin()));
        Parent root = loader.load();

        if(Settings.getOptionsOrigin().equals("view/MainMenuFXML.fxml")){
            MainMenuFXMLController controller = loader.getController();
            Scene nextScene = new Scene(root);
            nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                @Override
                public void handle(KeyEvent e){
                    try{
                        controller.keyPress(e, nextScene);
                    }
                    catch(IOException io){
                        System.out.println("io eoer");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        } else if(Settings.getOptionsOrigin().equals("view/PauseMenuFXML.fxml")){
            PauseMenuFXMLController controller = loader.getController();
            Scene nextScene = new Scene(root);
            nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                @Override
                public void handle(KeyEvent e){
                    try{
                        controller.keyPress(e, nextScene);
                    }
                    catch(IOException io){
                        System.out.println("io eyrek");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        }
    }
    
    public void keyPress(KeyEvent event, Scene scene) throws IOException{
        //System.out.println(event.getCode());
        Scene currentScene = scene;
        Stage currentStage = (Stage) currentScene.getWindow();
        
        if(event.getCode()==KeyCode.ESCAPE){
            // depends on if the scene before is the pause menu or the main menu
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Settings.getOptionsOrigin()));
            Parent root = loader.load();
            
            if(Settings.getOptionsOrigin().equals("view/MainMenuFXML.fxml")){
                MainMenuFXMLController controller = loader.getController();
                Scene nextScene = new Scene(root);
                nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                    @Override
                    public void handle(KeyEvent e){
                        try{
                            controller.keyPress(e, nextScene);
                        }
                        catch(IOException io){
                            System.out.println("io ehedg");
                        }

                    }
                });
                currentStage.hide();
                currentStage.setScene(nextScene);
                currentStage.show();
            } else if(Settings.getOptionsOrigin().equals("view/PauseMenuFXML.fxml")){
                PauseMenuFXMLController controller = loader.getController();
                Scene nextScene = new Scene(root);
                nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                    @Override
                    public void handle(KeyEvent e){
                        try{
                            controller.keyPress(e, nextScene);
                        }
                        catch(IOException io){
                            System.out.println("io eletrh");
                        }

                    }
                });
                currentStage.hide();
                currentStage.setScene(nextScene);
                currentStage.show();
            }
        } 
    }
    
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textSpecial.setVisible(false);
        difficulty_pane.setVisible(false);
        phaseText_pane.setVisible(false);
        // TODO
    }    
    
}
