/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package placeholder;

import java.io.IOException;
import java.util.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import placeholder.model.*;

/**
 * FXML Controller class
 *
 * @author Diogn Lei R. Mortera, Krixian Skye D. Del Rosario
 */
public class PauseMenuFXMLController implements Initializable {
    
    // DISCLAIMER: The windows that the buttons of this menu link to are not yet fully functional, so the buttons on those layouts may not work.
    
    @FXML private ImageView pause_btn;
    @FXML private Rectangle resume_btn, settings_btn, location_btn, mainmenu_btn;
    
    
    //code that happens when a button is pressed
    @FXML private void takeAction(MouseEvent event) throws IOException{
        Node node = (Node) event.getSource();
        Scene currentScene = node.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        
        //Exits the pause menu and resumes the game
        if(event.getSource() == pause_btn || event.getSource() == resume_btn){
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Settings.getPauseOrigin()));
            Parent root = loader.load();
            
            if(Settings.getPauseOrigin().equals("view/BattleMenuFXML.fxml")){
                BattleMenuFXMLController controller = loader.getController();
                Scene nextScene = new Scene(root);
                nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                    @Override
                    public void handle(KeyEvent e){
                        try{
                            controller.keyPress(e, nextScene);
                        }
                        catch(IOException io){
                            System.out.println("io klfgnfd");
                        }

                    }
                });
                currentStage.hide();
                currentStage.setScene(nextScene);
                currentStage.show();
            } else if(Settings.getPauseOrigin().equals("view/MainGPMenuFXML.fxml")){
                MainGPMenuFXMLController controller = loader.getController();
                Scene nextScene = new Scene(root);
                nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                    @Override
                    public void handle(KeyEvent e){
                        try{
                            controller.keyPress(e, nextScene);
                        }
                        catch(IOException io){
                            System.out.println("io kelfnge");
                        }

                    }
                });
                currentStage.hide();
                currentStage.setScene(nextScene);
                currentStage.show();
            } else if(Settings.getPauseOrigin().equals("view/PuzzleMenuFXML.fxml")){
                PuzzleMenuFXMLController controller = loader.getController();
                Scene nextScene = new Scene(root);
                nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                    @Override
                    public void handle(KeyEvent e){
                        try{
                            controller.keyPress(e, nextScene);
                        }
                        catch(IOException io){
                            System.out.println("io klsdfnbf");
                        }

                    }
                });
                currentStage.hide();
                currentStage.setScene(nextScene);
                currentStage.show();
            }
        }
        //Opens the settings menu
        if(event.getSource() == settings_btn){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/OptionsMenuFXML.fxml"));
            Settings.setOptionsOrigin("view/PauseMenuFXML.fxml");
            Parent root = loader.load();

            OptionsMenuFXMLController controller = loader.getController();
            Scene nextScene = new Scene(root);
            nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                @Override
                public void handle(KeyEvent e){
                    try{
                        controller.keyPress(e, nextScene);
                    }
                    catch(IOException io){
                        System.out.println("io dklngd");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        }
        //Exists the puzzle/within-location menu and goes back to location menu
        if(event.getSource() == location_btn){
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
                        System.out.println("io dfbdfbgdf");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        }
        //Returns to main menu
        if(event.getSource() == mainmenu_btn){
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
                        System.out.println("io dfklbndb");
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Settings.getPauseOrigin()));
            Parent root = loader.load();
            
            if(Settings.getPauseOrigin().equals("view/BattleMenuFXML.fxml")){
                BattleMenuFXMLController controller = loader.getController();
                Scene nextScene = new Scene(root);
                nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                    @Override
                    public void handle(KeyEvent e){
                        try{
                            controller.keyPress(e, nextScene);
                        }
                        catch(IOException io){
                            System.out.println("io dnbklds");
                        }

                    }
                });
                currentStage.hide();
                currentStage.setScene(nextScene);
                currentStage.show();
            } else if(Settings.getPauseOrigin().equals("view/MainGPMenuFXML.fxml")){
                MainGPMenuFXMLController controller = loader.getController();
                Scene nextScene = new Scene(root);
                nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                    @Override
                    public void handle(KeyEvent e){
                        try{
                            controller.keyPress(e, nextScene);
                        }
                        catch(IOException io){
                            System.out.println("io ebddfbd");
                        }

                    }
                });
                currentStage.hide();
                currentStage.setScene(nextScene);
                currentStage.show();
            } else if(Settings.getPauseOrigin().equals("view/PuzzleMenuFXML.fxml")){
                PuzzleMenuFXMLController controller = loader.getController();
                Scene nextScene = new Scene(root);
                nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                    @Override
                    public void handle(KeyEvent e){
                        try{
                            controller.keyPress(e, nextScene);
                        }
                        catch(IOException io){
                            System.out.println("io sdbdb");
                        }

                    }
                });
                currentStage.hide();
                currentStage.setScene(nextScene);
                currentStage.show();
            }
        } 
    }
    
    //changes pause button on hover
    @FXML private void changePauseButtonOnEnter(MouseEvent e){
        ImageView tempPause = (ImageView) e.getSource();
        Image newPause = new Image(getClass().getResourceAsStream("graphics/pauseButtonHovered.png"));
        
        tempPause.setImage(newPause);
    }
    
    //changes pause button back to original state when user stops hovering
    @FXML private void changePauseButtonOnExit(MouseEvent e){
        ImageView tempPause = (ImageView) e.getSource();
        Image newPause = new Image(getClass().getResourceAsStream("graphics/pauseButton.png"));
        
        tempPause.setImage(newPause);
    }
    
    //changes background on hover
    @FXML private void changeBackgroundOnEnter(MouseEvent event){
        Rectangle tempRectangle = (Rectangle) event.getSource();
        tempRectangle.setFill(Color.PURPLE);
    }
    
    //changes background back to original state when user stops hovering
    @FXML public void changeBackgroundOnExit(MouseEvent event){
        Rectangle tempRectangle = (Rectangle) event.getSource();
        tempRectangle.setFill(Color.rgb(135, 87, 189));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
