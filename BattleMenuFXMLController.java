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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import placeholder.model.*;

/**
 *
 * @author Krixian Skye D. Del Rosario
 */

class HPBarUpdate extends TimerTask {
    private Battle basis = Battle.getBattleList().get(Battle.getBattleNum()); //insert battlenum here
    @FXML private Text bigFinText, smallFinText, health20, health40, health60, health80, health100;
    @FXML private ImageView you, help1, help2, harm1, harm2, harm3, youHealth, help1Health, help2Health, harm1Health, harm2Health, harm3Health;
    @FXML private Rectangle backLoc, backMain, close;
    @FXML private HBox noLives, hasLives;
    @FXML private Pane finPane;
    
    private int runNum = 1;
    private ArrayList<ImageView> hpBarSprites, charSprites;
    private ArrayList<Text> hpText;
    private boolean displayedEnd = false;
    

    
    @Override
    public void run(){
        if(runNum==1){
            hpBarSprites.add(youHealth);
            hpBarSprites.add(help1Health);
            hpBarSprites.add(help2Health);
            hpBarSprites.add(harm1Health);
            hpBarSprites.add(harm2Health);
            hpBarSprites.add(harm3Health);

            hpText.add(health20);
            hpText.add(health40);
            hpText.add(health60);
            hpText.add(health80);
            hpText.add(health100);
            
            charSprites.add(help1);
            charSprites.add(help2);
            charSprites.add(harm1);
            charSprites.add(harm2);
            charSprites.add(harm3);
        }
        
        int i=0;
        for(Chara c : basis.getCharaList()){
            if(c instanceof Protag){
                for(int j=5; j>=1; j--){
                    if(c.getHP()<c.getMaxHP()*(0.20*j+0.01)) {
                        for(Text t : hpText){
                            t.setText(null);
                        }
                        hpText.get(j-1).setText(c.getHP() + "");
                        if(j<5){
                            health100.setText("100");
                        }
                    }
                }
                ImageView tempBar = hpBarSprites.get(i);
                Image newBar = new Image(getClass().getResourceAsStream("hpBar" + c.getHPBar() + "big.png"));
                
                tempBar.setImage(newBar);
                
                if(c.getHP()<=0 && !displayedEnd){
                    displayedEnd = true;
                    Protag p = (Protag) c;
                    p.die();
                    
                    bigFinText.setText("Rest in Peace.");
                    smallFinText.setText("You have " + p.getLifeCount() + " lives left. Better luck next time!");
                    
                    
                    if(p.getDead()){
                       smallFinText.setText("You have no lives left. You have lost the game.");
                        
                       noLives.setVisible(true);
                       hasLives.setVisible(false);
                    }else{
                       hasLives.setVisible(true);
                       noLives.setVisible(false);
                       
                    }
                }
            } else{
                ImageView tempBar = hpBarSprites.get(i);
                Image newBar = new Image(getClass().getResourceAsStream("hpBar" + c.getHPBar() + ".png"));
                
                tempBar.setImage(newBar);
                
                if(c.getHP()==0){
                    charSprites.get(i).setImage(null);
                }
            }
            if((basis.getCharaList().get(3).getHP()<=0 && basis.getCharaList().get(4).getHP()<=0 && basis.getCharaList().get(5).getHP()<=0)&&!displayedEnd){
                displayedEnd = true;
                bigFinText.setText("Congratulations!");
                smallFinText.setText("You won the battle!");
                hasLives.setVisible(true);
                noLives.setVisible(false);
            }
            i++;
        }
        runNum++;
    }
}

public class BattleMenuFXMLController implements Initializable {
    
    private Battle basis = Battle.getBattleList().get(Battle.getBattleNum()); //insert battlenum here
    private boolean attacking = false;
    private int enemyAttacked = 0;
    private ArrayList<ImageView> hpBarSprites, allySprites, enemySprites;
    private ArrayList<Text> hpText;
    private Timer timer = new Timer();
    private TimerTask task = new HPBarUpdate();
    
    @FXML private ImageView attackButton, itemButton, bg, you, help1, help2, harm1, harm2, harm3, youHealth, help1Health, help2Health, harm1Health, harm2Health, harm3Health;
    @FXML private AnchorPane healthSec, attackSec, itemSec;
    @FXML private Rectangle backLoc, backMain, close;
    @FXML private Text bigFinText, smallFinText, health20, health40, health60, health80, health100, attackText, showemText;
    @FXML private Pane finPane;
    @FXML private HBox noLives, hasLives;
    
    
    
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
    
    @FXML private void pressPause(MouseEvent e) throws IOException{
        Node node = (Node) e.getSource();
        Scene currentScene = node.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        
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
                    System.out.println("io dghktdr");
                }

            }
        });
        currentStage.hide();
        currentStage.setScene(nextScene);
        currentStage.show();
    }
    
    @FXML private void checkItems(MouseEvent e) throws IOException{
        Node node = (Node) e.getSource();
        Scene currentScene = node.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/InventoryMenuFXML.fxml"));
        Parent root = loader.load();

        InventoryMenuFXMLController controller = loader.getController();
        Scene nextScene = new Scene(root);
        nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent e){
                try{
                    controller.keyPress(e, nextScene);
                }
                catch(IOException io){
                    System.out.println("io dfkfdvndh");
                }

            }
        });
        currentStage.hide();
        currentStage.setScene(nextScene);
        currentStage.show();
    }
    
    @FXML private void enemySelect(Event e){
        if(attacking){
            if(e.getSource()==harm1){
                enemyAttacked = 1;
            } else if (e.getSource()==harm2){
                enemyAttacked = 2;
            } else if (e.getSource()==harm3){
                enemyAttacked = 3;
            }
            
        }
    }
    
    @FXML private void trigAttack(Event e){
        if(attacking){
            basis.getProtag().attack(basis.getEnemy(enemyAttacked));
            showemText.setText("Show 'em what you're worth!");

        } else {
            showemText.setText("Press A or click again to confirm!");
        }
        attacking = !attacking;
    }
    
    public void spriteSetup(){
        hpBarUpdate();
        you.setImage(new Image(basis.getProtag().getTextureStr()));
        for(ImageView iv : allySprites){
            int i = 0;
            if(basis.getAlly(i)!=null){
                iv.setImage(new Image(getClass().getResourceAsStream(basis.getAlly(i).getTextureStr())));
            }
            i++;
        }
        for(ImageView iv : enemySprites){
            int i = 0;
            if(basis.getEnemy(i)!=null){
                iv.setImage(new Image(getClass().getResourceAsStream(basis.getEnemy(i).getTextureStr())));
            }
            i++;
        }
    }
    
    @FXML private void closeGame(MouseEvent e){
        Node node = (Node) e.getSource();
        Scene currentScene = node.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        
        currentStage.close();
    }
    
    @FXML private void back(MouseEvent e) throws IOException{
        basis.getProtag().setHP(basis.getProtag().getMaxHP());
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
                        System.out.println("io kldfgnldh");
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
                        System.out.println("io dkfngdnfh");
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
    
    public void hpBarUpdate(){
        
        int i=0;
        for(Chara c : basis.getCharaList()){
            if(c instanceof Protag){
                for(int j=5; j>=1; j--){
                    if(c.getHP()<c.getMaxHP()*(0.20*j+0.01)) {
                        for(Text t : hpText){
                            t.setText(null);
                        }
                        hpText.get(j-1).setText(c.getHP() + "");
                        if(j<5){
                            health100.setText("100");
                        }
                    }
                }
                ImageView tempBar = hpBarSprites.get(i);
                Image newBar = new Image(getClass().getResourceAsStream("hpBar" + c.getHPBar() + "big.png"));
                
                tempBar.setImage(newBar);
            } else{
                ImageView tempBar = hpBarSprites.get(i);
                Image newBar = new Image(getClass().getResourceAsStream("hpBar" + c.getHPBar() + ".png"));
                
                tempBar.setImage(newBar);
            }
            i++;
        }
        
    }
    
    public void keyPress(KeyEvent event, Scene scene) throws IOException{
        //System.out.println(event.getCode());
        Scene currentScene = scene;
        Stage currentStage = (Stage) currentScene.getWindow();
        
        if(event.getCode()==KeyCode.ESCAPE){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/PauseMenuFXML.fxml"));
            Settings.setPauseOrigin("view/BattleMenuFXML.fxml");
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
                        System.out.println("io eklhnddgdh");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        } else if (event.getCode()==KeyCode.E){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/InventoryMenuFXML.fxml"));
            Parent root = loader.load();

            InventoryMenuFXMLController controller = loader.getController();
            Scene nextScene = new Scene(root);
            nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                @Override
                public void handle(KeyEvent e){
                    try{
                        controller.keyPress(e, nextScene);
                    }
                    catch(IOException io){
                        System.out.println("io dkghenrhgf");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        } else if (event.getCode()==KeyCode.Q){
            attacking = !attacking;
            if(attacking){
                attackButton.setImage(new Image(getClass().getResourceAsStream("attackbuttonconfirm.png")));
            } else {
                attackButton.setImage(new Image(getClass().getResourceAsStream("attackbutton.png")));
            }
        } else if (event.getCode()==KeyCode.A){
            if (attacking)
            {
                basis.getProtag().attack(basis.getEnemy(enemyAttacked));
                showemText.setText("Show 'em what you're worth!");
            } 
        }
    }
    
    @FXML private void buttonsOnEnter(MouseEvent e){
        if(e.getSource() == attackButton){
            if(attacking){
                attackButton.setImage(new Image(getClass().getResourceAsStream("attackbuttonconfirmhover.png")));
            } else {
                attackButton.setImage(new Image(getClass().getResourceAsStream("attackbuttonhover.png")));
            }
        } else if (e.getSource() == itemButton){
            itemButton.setImage(new Image(getClass().getResourceAsStream("itembuttonhover.png")));
        }
    }
    
    @FXML private void buttonsOnExit(MouseEvent e){
        if(e.getSource() == attackButton){
            if(attacking){
                attackButton.setImage(new Image(getClass().getResourceAsStream("attackbuttonconfirm.png")));
            } else {
                attackButton.setImage(new Image(getClass().getResourceAsStream("attackbutton.png")));
            }
        } else if (e.getSource() == itemButton){
            itemButton.setImage(new Image(getClass().getResourceAsStream("itembutton.png")));
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bg.setImage(new Image(getClass().getResourceAsStream(basis.getTextureStr())));
        finPane.setVisible(false);
        
        
        allySprites = new ArrayList<>();
        enemySprites = new ArrayList<>();
        hpBarSprites = new ArrayList<>();
        hpText = new ArrayList<>();
        
        allySprites.add(help1);
        allySprites.add(help2);
        enemySprites.add(harm1);
        enemySprites.add(harm2);
        enemySprites.add(harm3);
        
        hpBarSprites.add(youHealth);
        hpBarSprites.add(help1Health);
        hpBarSprites.add(help2Health);
        hpBarSprites.add(harm1Health);
        hpBarSprites.add(harm2Health);
        hpBarSprites.add(harm3Health);
        
        hpText.add(health20);
        hpText.add(health40);
        hpText.add(health60);
        hpText.add(health80);
        hpText.add(health100);
        
        spriteSetup();
        timer.schedule(task,0,1);
    }    
    
}
