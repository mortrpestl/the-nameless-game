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
public class LocationMenuFXMLController implements Initializable {
    
    @FXML StackPane enter_portion;
    @FXML ImageView loc1_img, loc2_img, loc3_img, loc4_img, loc5_img;
    @FXML ImageView exit_btn;
    @FXML Rectangle enter_btn;
    @FXML Text wl_title, wl_desc;
    
    private ArrayList<ImageView> locImgsList;
    private boolean loc4disable = true;
    private boolean loc5disable = true;
    
    @FXML private void exit(MouseEvent event) throws IOException{
        Node node = (Node) event.getSource();
        Scene currentScene = node.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/PhaseMenuFXML.fxml"));
        Parent root = loader.load();

        PhaseMenuFXMLController controller = loader.getController();
        Scene nextScene = new Scene(root);
        nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent e){
                try{
                    controller.keyPress(e, nextScene);
                }
                catch(IOException io){
                    System.out.println("io sdjkgdsnj");
                }

            }
        });
        currentStage.hide();
        currentStage.setScene(nextScene);
        currentStage.show();
    }
    
    @FXML private void clickWithinLocation(MouseEvent event){
        int i = 0;
        enter_portion.setVisible(true);
        
        for(ImageView iv : locImgsList){
            if(iv == (ImageView) event.getSource()){
                WithinLocation.setWLNum(i);
                setLocInfo();
            }
            i++;
        }
    }
    
    public void disableLocs(){
        if(!(WithinLocation.getWL(2).getStoryComplete())){
            loc4_img.setImage(new Image(getClass().getResourceAsStream(""))); //insert greyed out ver here
        } else loc4disable = false;
        if(!(WithinLocation.getWL(1).getStoryComplete()&&WithinLocation.getWL(2).getStoryComplete()&&WithinLocation.getWL(3).getStoryComplete())){
            loc5_img.setImage(new Image(getClass().getResourceAsStream(""))); //insert greyed out ver here
        } else loc5disable = false;
        
    }
    
    public void setLocInfo(){
        WithinLocation wl = WithinLocation.getWL(WithinLocation.getWLNum());
        
        wl_title.setText(wl.getName());
        wl_desc.setText(wl.getDesc());
    }
    
    public void clearLocInfo(){
        enter_portion.setVisible(false);
        wl_title.setText(null);
        wl_desc.setText(null);
    }
    
    @FXML private void confirmWithinLocation(MouseEvent event) throws IOException{
        if(!(((ImageView) event.getSource() == loc4_img && loc4disable)|| ((ImageView) event.getSource() == loc5_img && loc5disable))){
            Node node = (Node) event.getSource();
            Scene currentScene = node.getScene();
            Stage currentStage = (Stage) currentScene.getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainGPMenuFXML.fxml"));
            Parent root = loader.load();

            MainGPMenuFXMLController controller = loader.getController();
            Scene nextScene = new Scene(root);
            nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                @Override
                public void handle(KeyEvent e){
                    try{
                        controller.keyPress(e, nextScene);
                    }
                    catch(IOException io){
                        System.out.println("io klefnglehldnh");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        }
    }
    
    @FXML private void onMouseEnter(MouseEvent event){
        if(locImgsList.contains((ImageView) event.getSource())){
            if(!(((ImageView) event.getSource() == loc4_img && loc4disable)|| ((ImageView) event.getSource() == loc5_img && loc5disable))){
                ImageView tempLoc = (ImageView) event.getSource();
                Image newLoc = new Image(getClass().getResourceAsStream("graphics/locationpointerhover-locationmenu.png"));

                tempLoc.setImage(newLoc);
            }
        }
        
        if((ImageView) event.getSource() == exit_btn){
            ImageView tempExit = (ImageView) event.getSource();
            Image newExit = new Image(getClass().getResourceAsStream("graphics/exitButtonHovered.png"));
        
            tempExit.setImage(newExit);
        }
    }
    
    @FXML private void onMouseExit(MouseEvent event){
        if(locImgsList.contains((ImageView) event.getSource())){
            if(!(((ImageView) event.getSource() == loc4_img && loc4disable)|| ((ImageView) event.getSource() == loc5_img && loc5disable))){
                ImageView tempLoc = (ImageView) event.getSource();
                Image newLoc = new Image(getClass().getResourceAsStream("graphics/locationpointer-locationmenu.png"));

                tempLoc.setImage(newLoc);
            }
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/PhaseMenuFXML.fxml"));
            Parent root = loader.load();

            PhaseMenuFXMLController controller = loader.getController();
            Scene nextScene = new Scene(root);
            nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                @Override
                public void handle(KeyEvent e){
                    try{
                        controller.keyPress(e, nextScene);
                    }
                    catch(IOException io){
                        System.out.println("io ksdlngld");
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
        clearLocInfo();
        locImgsList = new ArrayList<>();
        
        locImgsList.add(loc1_img);
        locImgsList.add(loc2_img);
        locImgsList.add(loc3_img);
        locImgsList.add(loc4_img);
        locImgsList.add(loc5_img);
        
        disableLocs();
        enter_portion.setVisible(false);

    }  
    
}
    
