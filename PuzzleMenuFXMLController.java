/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package placeholder;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import placeholder.model.*;

/**
 *
 * @author Krixian Skye D. Del Rosario
 */
class checkFinish extends TimerTask {
    
    @FXML private FlowPane flow00, flow01, flow02, flow03, flow04, flow05, flow10, flow11, flow12, flow13, flow14, flow15, flow20, flow21, flow22, flow23, flow24, flow25, flow30, flow31, flow32, flow33, flow34, flow35, flow40, flow41, flow42, flow43, flow44, flow45, flow50, flow51, flow52, flow53, flow54, flow55;
    @FXML private Rectangle backLoc, backMain;
    @FXML private HBox hasLives;
    @FXML private Pane finPane;
    
    private Puzzle basis = Puzzle.getPuzzleList().get(Puzzle.getPuzzleNum());
    private boolean displayedEnd = false;
    
    @Override
    public void run(){
        if((basis.getPlayerX() == basis.getTrophyX() && basis.getPlayerY() == basis.getTrophyY()) && !displayedEnd){
            finPane.setVisible(true);
            displayedEnd = true;
        }
    }
}

public class PuzzleMenuFXMLController implements Initializable {
    
    @FXML private FlowPane flow00, flow01, flow02, flow03, flow04, flow05, flow10, flow11, flow12, flow13, flow14, flow15, flow20, flow21, flow22, flow23, flow24, flow25, flow30, flow31, flow32, flow33, flow34, flow35, flow40, flow41, flow42, flow43, flow44, flow45, flow50, flow51, flow52, flow53, flow54, flow55;
    @FXML private Rectangle backLoc, backMain;
    @FXML private HBox hasLives;
    @FXML private Pane finPane;
   
    private Puzzle basis = Puzzle.getPuzzleList().get(Puzzle.getPuzzleNum());
    private ArrayList<FlowPane> xgrid0, xgrid1, xgrid2, xgrid3, xgrid4, xgrid5;
    private ArrayList<ArrayList<FlowPane>> grid;
    private ImageView chara, puzBlock;
    private GridPane puzGrid;
    private Protag protag = Battle.getBattleList().get(Battle.getBattleNum()).getProtag();
    private Timer timer = new Timer();
    private TimerTask task = new checkFinish();
    
    @FXML private void pause(MouseEvent e) throws IOException{
        Node node = (Node) e.getSource();
        Scene currentScene = node.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        
        currentStage.close();
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
    
    public void printIndex(){
        GridPane.setColumnIndex(chara, 2);
    }
    
    @FXML private void pressPause(MouseEvent e) throws IOException{
        Node node = (Node) e.getSource();
        Scene currentScene = node.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/PauseMenuFXML.fxml"));
        Settings.setPauseOrigin("view/PuzzleMenuFXML.fxml");
        Parent root = loader.load();

        PauseMenuFXMLController controller = loader.getController();
        Scene nextScene = new Scene(root);
        nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent e){
                try{
                    controller.keyPress(e, nextScene);
                }
                catch(IOException io){
                    System.out.println("io presspause");
                }

            }
        });
        currentStage.hide();
        currentStage.setScene(nextScene);
        currentStage.show();
    }
    
    public void keyPress(KeyEvent event, Scene scene) throws IOException{
        //System.out.println(event.getCode());
        Scene currentScene = scene;
        Stage currentStage = (Stage) currentScene.getWindow();
        
        if(event.getCode()==KeyCode.ESCAPE){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/PauseMenuFXML.fxml"));
            Parent root = loader.load();

            PauseMenuFXMLController controller = loader.getController();
            Scene nextScene = new Scene(root);
            nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                @Override
                public void handle(KeyEvent e){
                    try{
                        controller.keyPress(e, nextScene);
                    }
                    catch(IOException io){
                        System.out.println("io escape");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        } else if(event.getCode()==KeyCode.UP){
            basis.move("u");
        } else if(event.getCode()==KeyCode.RIGHT){
            basis.move("r");
        } else if(event.getCode()==KeyCode.DOWN){
            basis.move("d");
        } else if(event.getCode()==KeyCode.LEFT){
            basis.move("l");
        }
        
    }
    
    public void gridSetup(ArrayList<FlowPane> x, FlowPane a, FlowPane b, FlowPane c, FlowPane d, FlowPane e, FlowPane f){
        x.add(a);
        x.add(b);
        x.add(c);
        x.add(d);
        x.add(e);
        x.add(f);
        
        grid.add(x);
    }
    
    public void clearBoard(){
        for(int i=0; i<5; i++){ //y
            for(int j=0; j<5; j++){ //x
                ImageView img = new ImageView();
                if(!grid.get(i).get(j).getChildren().isEmpty())
                {
                    grid.get(i).get(j).getChildren().removeAll();
                }
            }
        }
    }
    
    public void setBoard(){
        clearBoard();
        for(int i=0; i<5; i++){ //y
            for(int j=0; j<5; j++){ //x
                ImageView img = new ImageView();
                if(basis.getChaGrid()[i][j]==null){
                    if(basis.getObjGrid()[i][j]!=null){
                        img.setImage(new Image(basis.getObjGrid()[i][j].getTextureStr()));
                    }
                } else {
                    img.setImage(new Image(basis.getChaGrid()[i][j].getTextureStr()));
                }

                grid.get(i).get(j).getChildren().add(img);
            }
        }
        
        grid.get(basis.getTrophyY()).get(basis.getTrophyX()).getChildren().add(new ImageView(new Image(getClass().getResourceAsStream("trophy.png"))));
    }
    
    // <<<<SMTH HERE THAT CHECKS IF DONE NA W PUZZLE>>>>>
    
    @FXML private void back(MouseEvent e) throws IOException{
        protag.setHP(protag.getMaxHP());
        Node node = (Node) e.getSource();
        Scene currentScene = node.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        
        if(e.getSource() == backLoc){
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
                        System.out.println("io backloc");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        } else if (e.getSource() == backMain){
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
                        System.out.println("io backmain");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        finPane.setVisible(false);
        
        grid = new ArrayList();
        xgrid0 = new ArrayList();
        xgrid1 = new ArrayList();
        xgrid2 = new ArrayList();
        xgrid3 = new ArrayList();
        xgrid4 = new ArrayList();
        xgrid5 = new ArrayList();
        
        gridSetup(xgrid0, flow00, flow01, flow02, flow03, flow04, flow05);
        gridSetup(xgrid1, flow10, flow11, flow12, flow13, flow14, flow15);
        gridSetup(xgrid2, flow20, flow21, flow22, flow23, flow24, flow25);
        gridSetup(xgrid3, flow30, flow31, flow32, flow33, flow34, flow35);
        gridSetup(xgrid4, flow40, flow41, flow42, flow43, flow44, flow45);
        gridSetup(xgrid5, flow50, flow51, flow52, flow53, flow54, flow55);
        
        setBoard();
        timer.schedule(task,0,1);
    }    
    
}
