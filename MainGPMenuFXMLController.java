/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package placeholder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import placeholder.model.*;

/**
 * 
 *
 * @author Krixian Skye D. Del Rosario
 */
public class MainGPMenuFXMLController implements Initializable {

    /*
     actionbuttons
     */
    @FXML private FlowPane actionButton1, actionButton2, actionButton3, actionButton4, actionButton5, actionButton6;
    @FXML private Label actionName1, actionName2, actionName3, actionName4, actionName5, actionName6;
    //private ImageView actionIcon1, actionIcon2, actionIcon3, actionIcon4, actionIcon5, actionIcon6;
    
    @FXML private ImageView pause, bg, toDarkenBG, toGlow, displayed, pfp, icon1, icon2, icon3, icon4, icon5, icon6;
    //@FXML private Label label1, label2, label3, label4, label5, label6;
    @FXML private Label prev, next, charName, dialogue;
    @FXML private Pane obstructor, choicePane; //these panes' visibilities toggled using setVisible(true/false)
    @FXML private Rectangle choiceQues, choice1, choice2, choice3, choice4;
    @FXML private Text question, choiceText1, choiceText2, choiceText3, choiceText4;
    
    
    private WithinLocation basis;
    private int page;
    private int maxPage;
    private ArrayList<ImageView> iconList;
    private ArrayList<Label> labelList;
    private ArrayList<FlowPane> buttonList;
    private ArrayList<String> typeList;
    private ArrayList<Rectangle> choiceList;
    private Event eventPlaying;
    private int eventNumIncrement = 1;
    private int choiceChosen = 0;
    private boolean choiceContDone = false;
    
    @FXML private void navigatePress(MouseEvent e){
        if(e.getSource()==prev&&page!=0){
            clearContent();
            page--;
            setContent();
            checkLimit();
        } else if (e.getSource()==next&&page!=maxPage){
            clearContent();
            page++;
            setContent();
            checkLimit();
        }
    }
    
    @FXML private void actionPress(MouseEvent e) throws IOException{
        try{
            switch(typeList.get(buttonList.indexOf((FlowPane) e.getSource()))){
                case "NPC":
                    ((NPC) basis.getGameplayList()[(page*6)+buttonList.indexOf((FlowPane) e.getSource())]).interact();
                    break;
                case "WorldItem":
                    ((WorldItem) basis.getGameplayList()[(page*6)+buttonList.indexOf((FlowPane) e.getSource())]).interact();
                    break;
                case "Puzzle":
                    Puzzle.setPuzzleNum(Puzzle.getPuzzleList().indexOf(((Puzzle) basis.getGameplayList()[(page*6)+buttonList.indexOf((FlowPane) e.getSource())])));

                    Node node = (Node) e.getSource();
                    Scene currentScene = node.getScene();
                    Stage currentStage = (Stage) currentScene.getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("view/PuzzleMenuFXML.fxml"));
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
                                System.out.println("io jhdgnfvcb");
                            }

                        }
                    });
                    currentStage.hide();
                    currentStage.setScene(nextScene);
                    currentStage.show();
                    break;
                default:
                    break;
            }
        } catch (NullPointerException npe) {
            //tentative
        }
        
        //get source (;)
        
        //tackles what will happen if the buttons on the right of this menu r clicked
    }
    
    @FXML private void choiceClicked(MouseEvent e){
        Rectangle clicked = (Rectangle) e.getSource();
        
        if(clicked == choice1){
            Event.setEventNum(Event.getEventList().indexOf(((Scenario) Event.getEventList().get(Event.getEventNum())).getChoice(1).getEvent()));
            if(Event.getEventNum()!=3){
                eventNumIncrement = 6;
            } else{
                eventNumIncrement = 2;
            }
            choiceChosen = 1;
            play();
        } else if (clicked == choice2){
            Event.setEventNum(Event.getEventList().indexOf(((Scenario) Event.getEventList().get(Event.getEventNum())).getChoice(2).getEvent()));
            if(Event.getEventNum()!=3){
                eventNumIncrement = 4;
            }
            choiceChosen = 2;
            play();
        } else if (Event.getEventNum()!=3 && clicked == choice3){
            Event.setEventNum(Event.getEventList().indexOf(((Scenario) Event.getEventList().get(Event.getEventNum())).getChoice(3).getEvent()));
            eventNumIncrement = 3;
            choiceChosen = 3;
            play();
        } else if (Event.getEventNum()!=3 && clicked == choice4){
            Event.setEventNum(Event.getEventList().indexOf(((Scenario) Event.getEventList().get(Event.getEventNum())).getChoice(4).getEvent()));
            choiceChosen = 4;
        }
        
        //get the event's choice list, then get the choice in the same spot of the array as the clicked variable (get using choiceList.indexOf(choiceX);)
    }
    
    @FXML private void choicesOnEnter(MouseEvent e){
        Rectangle tempRect = (Rectangle) e.getSource();
        tempRect.setFill(Color.rgb(191, 152, 242));
    }
    
    @FXML private void choicesOnExit(MouseEvent e){
        Rectangle tempRect = (Rectangle) e.getSource();
        tempRect.setFill(Color.rgb(153, 114, 201));
    }
    
    @FXML private void rightButtonsOnEnter(MouseEvent e){
        FlowPane tempFP = (FlowPane) e.getSource();
        tempFP.setBackground(new Background(new BackgroundFill(Color.rgb(200, 187, 237), CornerRadii.EMPTY, Insets.EMPTY)));
    }
    
    @FXML private void rightButtonsOnExit(MouseEvent e){
        FlowPane tempFP = (FlowPane) e.getSource();
        tempFP.setBackground(new Background(new BackgroundFill(Color.rgb(225, 215, 255), CornerRadii.EMPTY, Insets.EMPTY)));
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
    
    @FXML private void pressPause(MouseEvent e) throws IOException{
        Node node = (Node) e.getSource();
        Scene currentScene = node.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/PauseMenuFXML.fxml"));
        Settings.setPauseOrigin("view/MainGPMenuFXML.fxml");
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
                    System.out.println("io skgnfd");
                    
                }

            }
        });
        currentStage.hide();
        currentStage.setScene(nextScene);
        currentStage.show();
    }
    
    @FXML private void labelOnMouseEnter(MouseEvent e){
        Label tempLabel = (Label) e.getSource();
        tempLabel.setBackground(new Background(new BackgroundFill(Color.rgb(101,58,148), CornerRadii.EMPTY, Insets.EMPTY)));
    }
    
    @FXML private void labelOnMouseExit(MouseEvent e){
        Label tempLabel = (Label) e.getSource();
        tempLabel.setBackground(new Background(new BackgroundFill(Color.rgb(61,6,118), CornerRadii.EMPTY, Insets.EMPTY)));
    }
    
    public void setContent() throws NullPointerException{
        bg.setImage(new Image(getClass().getResourceAsStream(basis.getTextureStr()))); //check if works
        toDarkenBG.setVisible(false);
        toGlow.setVisible(false);
        
        int index = page*6;
        for(int i=0; i<basis.getGameplayList().length; i++){
            try{
                if(basis.getGameplayList()[index+i] instanceof NPC){
                    Image img = new Image(getClass().getResourceAsStream("graphics/interactIconPerson.png"));
                    iconList.get(i).setImage(img);
                    NPC temp = (NPC) basis.getGameplayList()[index+i];
                    labelList.get(i).setText("interact with " + temp.getName());
                    typeList.add("NPC");
                } else if (basis.getGameplayList()[index+i] instanceof WorldItem){
                    Image img = new Image(getClass().getResourceAsStream("graphics/interactIconItem.png"));
                    iconList.get(i).setImage(img);
                    WorldItem temp = (WorldItem) basis.getGameplayList()[index+i];
                    labelList.get(i).setText("inspect " + temp.getName());
                    typeList.add("WorldItem");
                } else if (basis.getGameplayList()[index+i] instanceof Puzzle){
                    //Puzzle temp = (Puzzle) basis.getGameplayList()[index+i];
                    Image img = new Image(getClass().getResourceAsStream("graphics/interactIconPuzzle.png"));
                    iconList.get(i).setImage(img);
                    labelList.get(i).setText("enter puzzle");
                    typeList.add("Puzzle");
                } else{
                    iconList.get(i).setImage(new Image(getClass().getResourceAsStream("graphics/null.png")));
                    labelList.get(i).setText("");
                }
            }
            catch(IndexOutOfBoundsException e){
                
            }
        }
    }
    
    public void clearContent(){
        for(ImageView i : iconList){
            i.setImage(new Image(getClass().getResourceAsStream("graphics/null.png")));
        }
        for(Label l : labelList){
            l.setText("");
        }
        typeList.clear();
    }
    
    public void checkLimit(){
        if(page == maxPage) {
            next.setBackground(new Background(new BackgroundFill(Color.rgb(129,107,153), CornerRadii.EMPTY, Insets.EMPTY)));//next disable
        }
        else {
            next.setBackground(new Background(new BackgroundFill(Color.rgb(61,6,118), CornerRadii.EMPTY, Insets.EMPTY)));
        }
        if(page == 0) {
            prev.setBackground(new Background(new BackgroundFill(Color.rgb(129,107,153), CornerRadii.EMPTY, Insets.EMPTY)));// prev disable
        }
        else {
            prev.setBackground(new Background(new BackgroundFill(Color.rgb(61,6,118), CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }
    
    public void displayChoices(){
        if(eventPlaying instanceof Scenario){
            try{
            question.setText("What will you say?");
            choiceText1.setText(((Scenario) eventPlaying).getChoice(1).getResponse()); //idk why this is giving an error, theres a method in scenario nmn
            choiceText2.setText(((Scenario) eventPlaying).getChoice(2).getResponse());
            choiceText3.setText(((Scenario) eventPlaying).getChoice(3).getResponse());
            choiceText4.setText(((Scenario) eventPlaying).getChoice(4).getResponse());
            choicePane.setVisible(true);
            }catch(IndexOutOfBoundsException ioobe){
                
            }
        }
    }
    
    public void keyPress(KeyEvent event, Scene scene) throws IOException{
        //System.out.println(event.getCode());
        Scene currentScene = scene;
        Stage currentStage = (Stage) currentScene.getWindow();
        
        if(event.getCode()==KeyCode.ESCAPE){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/PauseMenuFXML.fxml"));
            Settings.setPauseOrigin("view/MainGPMenuFXML.fxml");
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
                        System.out.println("io kndew");
                    }

                }
            });
            currentStage.hide();
            currentStage.setScene(nextScene);
            currentStage.show();
        } else if (event.getCode()==KeyCode.SPACE){
            try{
                if(!basis.getStoryComplete()/*OR YOURE TALKING TO AN NPC*/){
                eventPlaying.incrementDialogue();
                play();
                }
            }catch(IndexOutOfBoundsException ioobe){
                    
                }                                   
        }
    }
    
    public void goToPuzzleMenu() throws IOException{
        
        Node node = (Node) choice1;
        Scene currentScene = node.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/PuzzleMenuFXML.fxml"));
        
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
                    System.out.println("io efgklen");
                }

            }
        });
        currentStage.hide();
        currentStage.setScene(nextScene);
        currentStage.show();
    }
    
    public void play(){
        try{
            obstructor.setVisible(true);
            charName.setText("");
            pfp.setImage(new Image(getClass().getResourceAsStream("graphics/null.png")));
            dialogue.setText("");
            displayed.setImage(new Image(getClass().getResourceAsStream("graphics/null.png")));
            toGlow.setVisible(false);
            toDarkenBG.setVisible(false);

            int di = eventPlaying.getDialogueIncrement();
            boolean puzzleLaunch = true;
            String colFour = eventPlaying.getDialogueFileContentList().get(Settings.getPhaseText()).get(di).get(3);
            
            if(eventPlaying.getDialogueFileContentList().get(Settings.getPhaseText()).get(di).get(0) != null && eventPlaying.getDialogueFileContentList().get(Settings.getPhaseText()).get(di).get(2) != null){
                charName.setText((String) eventPlaying.getDialogueFileContentList().get(Settings.getPhaseText()).get(di).get(0));
                pfp.setImage(new Image((InputStream) getClass().getResourceAsStream(eventPlaying.getDialogueFileContentList().get(Settings.getPhaseText()).get(di).get(1))));
                dialogue.setText((String) eventPlaying.getDialogueFileContentList().get(Settings.getPhaseText()).get(di).get(2));
            }

            switch(colFour){
                case "puzzle0":
                    Puzzle.setPuzzleNum(0);
                    goToPuzzleMenu();
                    break;
                case "puzzle1":
                    Puzzle.setPuzzleNum(1);
                    goToPuzzleMenu();
                    break;
                case "puzzle2":
                    Puzzle.setPuzzleNum(2);
                    goToPuzzleMenu();
                    break;
                case "puzzle3":
                    Puzzle.setPuzzleNum(3);
                    goToPuzzleMenu();
                    break;  
                case "puzzle4":
                    Puzzle.setPuzzleNum(4);
                    goToPuzzleMenu();
                    break;
                case "puzzle5":
                    Puzzle.setPuzzleNum(5);
                    goToPuzzleMenu();
                    break;
                case "puzzle6":
                    Puzzle.setPuzzleNum(6);
                    goToPuzzleMenu();
                    break;
                case "puzzle7":
                    Puzzle.setPuzzleNum(7);
                    goToPuzzleMenu();
                    break;
                case "puzzle8":
                    Puzzle.setPuzzleNum(8);
                    goToPuzzleMenu();
                    break;  
                case "puzzle9":
                    Puzzle.setPuzzleNum(9);
                    goToPuzzleMenu();
                    break;
                case "battle0":
                    puzzleLaunch = false;
                    //go to battle
                    break;
                case "displayTeleporter":
                    toDarkenBG.setVisible(true);
                    toGlow.setVisible(true);
                    displayed.setImage(new Image(getClass().getResourceAsStream("graphics/teleporterDevice.png")));
                    puzzleLaunch = false;
                    break;
                case "displayFrag1":
                    toDarkenBG.setVisible(true);
                    toGlow.setVisible(true);
                    displayed.setImage(new Image(getClass().getResourceAsStream("graphics/gemofwit_fragment1.png")));
                    puzzleLaunch = false;
                    basis.completeStory();
                    break;
                case "displayFrag2":
                    toDarkenBG.setVisible(true);
                    toGlow.setVisible(true);
                    displayed.setImage(new Image(getClass().getResourceAsStream("graphics/gemofwit_fragment2.png")));
                    puzzleLaunch = false;
                    basis.completeStory();
                    break;
                case "displayFrag3":
                    toDarkenBG.setVisible(true);
                    toGlow.setVisible(true);
                    displayed.setImage(new Image(getClass().getResourceAsStream("graphics/gemofwit_fragment3.png")));
                    puzzleLaunch = false;
                    basis.completeStory();
                    break;
                case "displayFrag4":
                    toDarkenBG.setVisible(true);
                    toGlow.setVisible(true);
                    displayed.setImage(new Image(getClass().getResourceAsStream("graphics/gemofwit_fragment4.png")));
                    puzzleLaunch = false;
                    break;
                case "completeLoc1":
                    puzzleLaunch = false;
                    basis.completeStory();
                    break;
                default:
                    break;
            }
        } catch (IndexOutOfBoundsException ioobe){
            obstructor.setVisible(false);
            if(!(eventPlaying instanceof Scenario)&&!basis.getStoryComplete()&&choiceChosen!=2){
                if(eventNumIncrement != 0){
                    Event.setEventNum(Event.getEventNum() + eventNumIncrement);
                    eventNumIncrement = 1;
                    play();
                } //still need to fix this to account for NPCs
            } else if(eventPlaying instanceof Scenario) {
                displayChoices();
            } else if(basis.getStoryComplete()){
                eventNumIncrement = 0;
            } else if(choiceChosen==2){
                Event.setEventNum(Event.getEventNum()+1);
                choiceChosen=0;
                play();
            }
            
        } catch(IOException io){
            
        } catch(NullPointerException npe){
            
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try{ (toggle try-catch to make this work)
            basis = WithinLocation.getWL(WithinLocation.getWLNum());
            eventPlaying = Event.getEventList().get(Event.getEventNum());
            iconList = new ArrayList();
            labelList = new ArrayList();
            buttonList = new ArrayList();
            typeList = new ArrayList();
            System.out.print("reaches1");
            
            iconList.add(icon1);
            iconList.add(icon2);
            iconList.add(icon3);
            iconList.add(icon4);
            iconList.add(icon5);
            iconList.add(icon6);
            labelList.add(actionName1);
            labelList.add(actionName2);
            labelList.add(actionName3);
            labelList.add(actionName4);
            labelList.add(actionName5);
            labelList.add(actionName6);
            buttonList.add(actionButton1);
            buttonList.add(actionButton2);
            buttonList.add(actionButton3);
            buttonList.add(actionButton4);
            buttonList.add(actionButton5);
            buttonList.add(actionButton6);
            System.out.print("reaches2");

            page = 0;
            maxPage = basis.getGameplayList().length/6; //do this but for the interactive arraylist
            setContent(); //
            checkLimit(); // 
            System.out.print("reaches3");
            
            if(WithinLocation.getWLNum()==0 && Protag.getFirstPlay()){
                pause.setVisible(false);
                Protag.firstPlayDone();
            }

            if(!basis.getStoryComplete()){
                eventNumIncrement = 1;
                play();
            }
            System.out.print("reaches4");
            
//        } catch(NullPointerException npe){
//            System.out.print("npe");
//        } catch(IndexOutOfBoundsException ioobe) {
//            System.out.print("ioobe");
//        }
    }
}
