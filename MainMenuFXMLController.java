/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package placeholder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import placeholder.model.*;

/**
 *
 * @author Diogn Lei R. Mortera, Krixian Skye D. Del Rosario
 */
public class MainMenuFXMLController implements Initializable {
    
    @FXML private ImageView play_btn, options_btn, quit_btn;
    
    @FXML
    private void takeAction(MouseEvent event) throws IOException {
        /*try{*/
            Node node = (Node) event.getSource();
            Scene currentScene = node.getScene();
            Stage currentStage = (Stage) currentScene.getWindow();


            if(event.getSource() == play_btn){
                //enter LocationMenu.fxml
                if(Protag.getFirstPlay()){
                    Protag.firstPlayDone();
                    WithinLocation.setWLNum(0);

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
                                System.out.println("io play btn");
                            }

                        }
                    });
                    currentStage.hide();
                    currentStage.setScene(nextScene);
                    currentStage.show();

                } else{
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
                                System.out.println("io play else");
                            }

                        }
                    });
                    currentStage.hide();
                    currentStage.setScene(nextScene);
                    currentStage.show();
                }
            }

            if(event.getSource() == options_btn){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("view/OptionsMenuFXML.fxml"));
                Settings.setOptionsOrigin("view/MainMenuFXML.fxml");
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
                            System.out.println("io optbut");
                        }

                    }
                });
                currentStage.hide();
                currentStage.setScene(nextScene);
                currentStage.show();
            }
            if(event.getSource() == quit_btn){
                currentStage.close();
            }
        /*} catch(LoadException le){
            //tentative
        }*/
    }
    
    @FXML
    private void onMouseEnter(MouseEvent event) {
        if(event.getSource() == play_btn){
            Image img = new Image(getClass().getResourceAsStream("graphics/playbuttonhover-mainmenu.png"));
            play_btn.setImage(img);
        }
        if(event.getSource() == options_btn){
            Image img = new Image(getClass().getResourceAsStream("graphics/optionsbuttonhover-mainmenu.png"));
            options_btn.setImage(img);
        }
        if(event.getSource() == quit_btn){
            Image img = new Image(getClass().getResourceAsStream("graphics/quitbuttonhover-mainmenu.png"));
            quit_btn.setImage(img);
        }
    }
    
    @FXML
    private void onMouseExit(MouseEvent event) {
        if(event.getSource() == play_btn){
            Image img = new Image(getClass().getResourceAsStream("graphics/playbutton-mainmenu.png"));
            play_btn.setImage(img);
        }
        if(event.getSource() == options_btn){
            Image img = new Image(getClass().getResourceAsStream("graphics/optionsbutton-mainmenu.png"));
            options_btn.setImage(img);
        }
        if(event.getSource() == quit_btn){
            Image img = new Image(getClass().getResourceAsStream("graphics/quitbutton-mainmenu.png"));
            quit_btn.setImage(img);
        }
    }
    
    // EVERYTHING BELOW IS TEMPORARY (except initialize), USED FOR NAVIGATION BETWEEN MENUS
    
    /*public void pressB(KeyEvent event) throws IOException{
        Node node = (Node) event.getSource();
        Scene currentScene = node.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("view/BattleMenuFXML.fxml"));

        Scene nextScene = new Scene(root);
        currentStage.hide();
        currentStage.setScene(nextScene);
        currentStage.show();
        System.out.println(event.getCode());
    }*/
    /*@Override
    public void handle(KeyEvent event){
        try{
            Node node = (Node) event.getSource();
            Scene currentScene = node.getScene();
            Stage currentStage = (Stage) currentScene.getWindow();

            if(event.getCode()==KeyCode.B){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("view/BattleMenuFXML.fxml"));
                Parent root = loader.load();
                Scene nextScene = new Scene(root);
                currentStage.hide();
                currentStage.setScene(nextScene);
                currentStage.show();
            } else if(event.getCode()==KeyCode.G){
                Parent root = FXMLLoader.load(getClass().getResource("view/MainGPMenuFXML.fxml"));

                Scene nextScene = new Scene(root);
                currentStage.hide();
                currentStage.setScene(nextScene);
                currentStage.show();
            } else if(event.getCode()==KeyCode.I){
                Parent root = FXMLLoader.load(getClass().getResource("view/InventoryMenuFXML.fxml"));

                Scene nextScene = new Scene(root);
                currentStage.hide();
                currentStage.setScene(nextScene);
                currentStage.show();
            } else if(event.getCode()==KeyCode.L){
                Parent root = FXMLLoader.load(getClass().getResource("view/LocationMenuFXML.fxml"));

                Scene nextScene = new Scene(root);
                currentStage.hide();
                currentStage.setScene(nextScene);
                currentStage.show();
            } else if(event.getCode()==KeyCode.M){
                Parent root = FXMLLoader.load(getClass().getResource("view/MainMenuFXML.fxml"));

                Scene nextScene = new Scene(root);
                currentStage.hide();
                currentStage.setScene(nextScene);
                currentStage.show();
            } else if(event.getCode()==KeyCode.O){
                Parent root = FXMLLoader.load(getClass().getResource("view/OptionsMenuFXML.fxml"));

                Scene nextScene = new Scene(root);
                currentStage.hide();
                currentStage.setScene(nextScene);
                currentStage.show();
            } else if(event.getCode()==KeyCode.P){
                Parent root = FXMLLoader.load(getClass().getResource("view/PauseMenuFXML.fxml"));

                Scene nextScene = new Scene(root);
                currentStage.hide();
                currentStage.setScene(nextScene);
                currentStage.show();
            } else if(event.getCode()==KeyCode.S){
                Parent root = FXMLLoader.load(getClass().getResource("view/PuzzleMenuFXML.fxml"));

                Scene nextScene = new Scene(root);
                currentStage.hide();
                currentStage.setScene(nextScene);
                currentStage.show();
            }
        }
        catch(IOException io){
            System.out.println("io");
        }
    }*/
        
    public void keyPress(KeyEvent event, Scene scene) throws IOException{
        //System.out.println(event.getCode());
        FXMLLoader loader;
        Scene currentScene = scene;
        Stage currentStage = (Stage) currentScene.getWindow();
        
        if(event.getCode()==KeyCode.B){
            loader = new FXMLLoader(getClass().getResource("view/BattleMenuFXML.fxml"));
            Parent root = loader.load();

            BattleMenuFXMLController controller = loader.getController();
            Scene nextScene = new Scene(root);
            nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                @Override
                public void handle(KeyEvent e){
                    try{
                        controller.keyPress(e, nextScene);
                    }
                    catch(IOException io){
                        System.out.println("io b");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        } else if(event.getCode()==KeyCode.G){
            loader = new FXMLLoader(getClass().getResource("view/MainGPMenuFXML.fxml"));
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
                        System.out.println("io g");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        } else if(event.getCode()==KeyCode.H){
            loader = new FXMLLoader(getClass().getResource("view/PhaseMenuFXML.fxml"));
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
                        System.out.println("io h");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        } else if(event.getCode()==KeyCode.I){
            loader = new FXMLLoader(getClass().getResource("view/InventoryMenuFXML.fxml"));
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
                        System.out.println("io i");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        } else if(event.getCode()==KeyCode.L){
            loader = new FXMLLoader(getClass().getResource("view/LocationMenuFXML.fxml"));
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
                        System.out.println("io l");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        } else if(event.getCode()==KeyCode.M){
            loader = new FXMLLoader(getClass().getResource("view/MainMenuFXML.fxml"));
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
                        System.out.println("io m");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        } else if(event.getCode()==KeyCode.O){
            loader = new FXMLLoader(getClass().getResource("view/OptionsMenuFXML.fxml"));
            Settings.setOptionsOrigin("view/MainMenuFXML.fxml");
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
                        System.out.println("io o");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        } else if(event.getCode()==KeyCode.P){
            loader = new FXMLLoader(getClass().getResource("view/PauseMenuFXML.fxml"));
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
                        System.out.println("io p");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        } else if(event.getCode()==KeyCode.S){
            loader = new FXMLLoader(getClass().getResource("view/PuzzleMenuFXML.fxml"));
            Parent root = loader.load();

            PuzzleMenuFXMLController controller = loader.getController();
            Scene nextScene = new Scene(root);
            nextScene.setOnKeyPressed(new EventHandler<KeyEvent>(){

                @Override
                public void handle(KeyEvent e){
                    try{
                        controller.keyPress(e, nextScene);
                    }
                    catch(IOException io){
                        System.out.println("io from main");
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
        Puzzle.setPuzzleNum(0);
        WithinLocation.setWLNum(0);
        Battle.setBattleNum(0);
    }    
    
    
    
}
