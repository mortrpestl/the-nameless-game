/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package placeholder;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import placeholder.model.*;

/**
 *
 * @author Diogn Lei R. Mortera, Krixian Skye D. Del Rosario
 */
public class PhaseMenuFXMLController implements Initializable {
    
    //edited these
    @FXML StackPane enter_portion;
    @FXML ImageView phase0_img, phase1_img, phase2_img, phase3_img;
    @FXML ImageView exit_btn;
    @FXML Rectangle enter_btn;
    @FXML Text phase_title, phase_desc;
    //stopped editing here
    
    private ArrayList<ImageView> phaseImgsList;
    
    @FXML private void exit(MouseEvent event) throws IOException{
        Node node = (Node) event.getSource();
        Scene currentScene = node.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainMenuFXML.fxml"));
        Parent root = loader.load();

        MainMenuFXMLController controller = loader.getController();
        Scene nextScene = new Scene(root);
        nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent e){
                try{
                    controller.keyPress(e, nextScene);
                }
                catch(IOException io){
                    System.out.println("io dbdgb");
                }

            }
        });
        currentStage.hide();
        currentStage.setScene(nextScene);
        currentStage.show();
    }
    
    @FXML private void clickPhase(MouseEvent event){
        int i = 0;
        enter_portion.setVisible(true);
        
        for(ImageView iv : phaseImgsList){
            if(iv == (ImageView) event.getSource()){
                Phase.setPhaseNum(i); 
                setPhaseInfo();
            }
            i++;
        }
    }
    
    public void setPhaseInfo(){
        Phase ph = Phase.getPhase(Phase.getPhaseNum());
        
        phase_title.setText(ph.getName());
        phase_desc.setText(ph.getDesc());
    }
    
    public void clearPhaseInfo(){
        enter_portion.setVisible(false);
        phase_title.setText(null);
        phase_desc.setText(null);
    }
    
    @FXML private void confirmPhase(MouseEvent event) throws IOException{
        if(Phase.getPhaseNum()==1){ //only phase 1 is playable for now
            Node node = (Node) event.getSource();
            Scene currentScene = node.getScene();
            Stage currentStage = (Stage) currentScene.getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/LocationMenuFXML.fxml"));
            Parent root = loader.load();

            LocationMenuFXMLController controller = loader.getController();
            Scene nextScene = new Scene(root);
            nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                @Override
                public void handle(KeyEvent e){
                    try{
                        controller.keyPress(e, nextScene);
                    }
                    catch(IOException io){
                        System.out.println("io dsbdgb");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        }
    }
    
    @FXML private void onMouseEnter(MouseEvent event){
        if(phaseImgsList.contains((ImageView) event.getSource())){
            ImageView tempPhase = (ImageView) event.getSource();
            Image newPhase = new Image(getClass().getResourceAsStream("graphics/phaseselectorhover.png")); //insert filename for phase hover
        
            tempPhase.setImage(newPhase);
        }
        
        if((ImageView) event.getSource() == exit_btn){
            ImageView tempExit = (ImageView) event.getSource();
            Image newExit = new Image(getClass().getResourceAsStream("graphics/exitButtonHovered.png"));
        
            tempExit.setImage(newExit);
        }
    }
    
    @FXML private void onMouseExit(MouseEvent event){
        if(phaseImgsList.contains((ImageView) event.getSource())){
            ImageView tempPhase = (ImageView) event.getSource();
            Image newPhase = new Image(getClass().getResourceAsStream("graphics/phaseselector.png")); //insert filename for normal phase

            tempPhase.setImage(newPhase);
        }
        
        if((ImageView) event.getSource() == exit_btn){
            ImageView tempExit = (ImageView) event.getSource();
            Image newExit = new Image(getClass().getResourceAsStream("graphics/exitButton.png"));
        
            tempExit.setImage(newExit);
        }
    }
    
    @FXML private void rectOnMouseEnter(MouseEvent event){
        Rectangle tempRectangle = (Rectangle) event.getSource();
        tempRectangle.setFill(Color.PURPLE);
    }
    
    @FXML private void rectOnMouseExit(MouseEvent event){
        Rectangle tempRectangle = (Rectangle) event.getSource();
        tempRectangle.setFill(Color.rgb(135, 87, 189));
    }
    
    public void keyPress(KeyEvent event, Scene scene) throws IOException{
        //System.out.println(event.getCode());
        Scene currentScene = scene;
        Stage currentStage = (Stage) currentScene.getWindow();
        
        if(event.getCode()==KeyCode.ESCAPE){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainMenuFXML.fxml"));
            Parent root = loader.load();

            MainMenuFXMLController controller = loader.getController();
            Scene nextScene = new Scene(root);
            nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                @Override
                public void handle(KeyEvent e){
                    try{
                        controller.keyPress(e, nextScene);
                    }
                    catch(IOException io){
                        System.out.println("io dbdgbdsb");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        } 
    }
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        clearPhaseInfo();
        phaseImgsList = new ArrayList<>();
        
        phaseImgsList.add(phase0_img);
        phaseImgsList.add(phase1_img);
        phaseImgsList.add(phase2_img);
        phaseImgsList.add(phase3_img);

        enter_portion.setVisible(false);
    }  
    
}
    



