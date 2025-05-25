/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package placeholder;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import placeholder.model.*;

/**
 *
 * @author Del Rosario, Mortera, Tongco
 */
public class Placeholder extends Application {
    
    /*to visit all of the menus, press these keys:
    
    B - battle layout
    G - main gameplay (within location) layout
    H - phase layout
    I - inventory layout
    L - location selection layout
    M - main menu layout (no need to press M to enter, opens when program is run)
    O - options menu layout
    P - pause menu layout
    S - sliding puzzle layout
    
    Esc - nothing (main menu) / close / go to the pause menu (depends on the menu)
    
    */
  
    
    //static Scene scene;
    
    @Override
    public void start(Stage stage) throws Exception{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainMenuFXML.fxml"));
        Parent root = loader.load();
        MainMenuFXMLController controller = loader.getController();
        
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            
            @Override
            public void handle(KeyEvent event){
                try{
                    controller.keyPress(event, scene);
                    /*switch(event.getCode()){
                    case B:
                        controller.pressB(event);
                        break;
                    }*/
                }
                catch(IOException io){
                    System.out.println("io");
                }
                
            }
        });
        
        stage.setScene(scene);
        stage.show();
        
        //pressedKey();
    }
    
    /*public void pressedKey() throws IOException {
        scene.setOnKeyPressed(k -> {
            Scene currentScene = (Scene) k.getSource();
            Stage currentStage = (Stage) currentScene.getWindow();
            
            if(k.getCode()==KeyCode.ESCAPE){
                System.out.println();
                currentStage.close();
            }
            
            if(k.getCode()==KeyCode.B){
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("view/BattleMenuFXML.fxml"));
                    
                    Scene nextScene = new Scene(root);
                    currentStage.hide();
                    currentStage.setScene(nextScene);
                    currentStage.show();
                } catch (IOException ex) {
                    System.out.println("io exception");
                }
            }
            
            if(k.getCode()==KeyCode.I){
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("view/InventoryMenuFXML.fxml"));
                    
                    Scene nextScene = new Scene(root);
                    currentStage.hide();
                    currentStage.setScene(nextScene);
                    currentStage.show();
                } catch (IOException ex) {
                    System.out.println("io exception");
                }
            }
            
            if(k.getCode()==KeyCode.G){
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("view/MainGPMenuFXML.fxml"));
                    
                    Scene nextScene = new Scene(root);
                    currentStage.hide();
                    currentStage.setScene(nextScene);
                    currentStage.show();
                } catch (IOException ex) {
                    System.out.println("io exception");
                }
            }
            
            if(k.getCode()==KeyCode.L){
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("view/LocationMenuFXML.fxml"));
                    
                    Scene nextScene = new Scene(root);
                    currentStage.hide();
                    currentStage.setScene(nextScene);
                    currentStage.show();
                } catch (IOException ex) {
                    System.out.println("io exception");
                }
            }
            
            if(k.getCode()==KeyCode.M){
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("view/MainMenuFXML.fxml"));
                    
                    Scene nextScene = new Scene(root);
                    currentStage.hide();
                    currentStage.setScene(nextScene);
                    currentStage.show();
                } catch (IOException ex) {
                    System.out.println("io exception");
                }
            }
            
            if(k.getCode()==KeyCode.O){
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("view/OptionsMenuFXML.fxml"));
                    
                    Scene nextScene = new Scene(root);
                    currentStage.hide();
                    currentStage.setScene(nextScene);
                    currentStage.show();
                } catch (IOException ex) {
                    System.out.println("io exception");
                }
            }
            
            if(k.getCode()==KeyCode.P){
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("view/PauseMenuFXML.fxml"));
                    
                    Scene nextScene = new Scene(root);
                    currentStage.hide();
                    currentStage.setScene(nextScene);
                    currentStage.show();
                } catch (IOException ex) {
                    System.out.println("io exception");
                }
            }
            
            if(k.getCode()==KeyCode.S){
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("view/PuzzleMenuFXML.fxml"));
                    
                    Scene nextScene = new Scene(root);
                    currentStage.hide();
                    currentStage.setScene(nextScene);
                    currentStage.show();
                } catch (IOException ex) {
                    System.out.println("io exception");
                }
            }
            
        });
    }
    
    public void openBattle() throws IOException{
        
    }*/

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Choice s0c1, s0c2, s1c1, s1c2, s1c3, s1c4, s2c1, s2c2, s2c3, s2c4, s3c1, s3c2, s3c3, s3c4, s4c1, s4c2, s4c3, s4c4;
    
        ///INITIALIZATION
        //(1.1) Initializing AttChangerItems
        new HealItem("Water", "graphics/hp_waterbottle.png", 
                "Nothing can beat the feeling of drinking the basic drink.", 
                10, 10, 10);
        new HealItem("Lemon Concoction", "graphics/hp_lemonconcoction.png", 
                "So warm, it gradually heals all minor bodily inconveniences!", 
                15, 15, 15);
        new HealItem("Cetirizine", "graphics/hp_cetirizine.png", 
                "Your fevers gripped me again, never kisses all you ever send are fullstops...", 
                20, 20, 20);
        new HealItem("Alchemist's Supreme Healing Potion", "graphics/hp_alchemistssupremehealingpotion.png", 
                "Gives you immense health points when you were there alone...", 
                25, 25, 25);
        new HealItem("Rod of <Name>", "graphics/hp_rodofinsertnamehere.png", 
                "A magical healing staff infused with the souls of an indeterminable number of Redd School Chem-Bio students.", 
                35, 35, 35);
        
        new AttChangerItem("Dagger", "graphics/atk_dagger.png", 
                "Small, but terrible. Packs quite a punch (or stab).", 
                "atk", 5);
        new AttChangerItem("Tequila", "graphics/atk_tequila.png", 
                "When lemon concoction doesn't suffice, drinking this is recommended for improving your concentration.", 
                "atk", 10);
        new AttChangerItem("Radioactive Pie", "graphics/atk_radioactivepie.png", 
                "Came from outer space! While the gamma rays might hurt your throat, the beneficial mutations allow you to grow your strength...", 
                "atk", 15);
        new AttChangerItem("Gold Oxide Concoction", "graphics/atk_goldoxideconcoction.png", 
                "Manufactured from an electrolytic chamber, gives you a sense of great potential.", 
                "atk", 20);
        new AttChangerItem("Trigem Amulet", "graphics/atk_trigemamulet.png", 
                "A familiar-looking circular compass that guides your attack capabilities.",
                "atk", 30);
        
        new AttChangerItem("Glasses", "graphics/def_glasses.png", 
                "In a post-apocalyptic world, it's better to have eye protection.", 
                "def", 5);
        new AttChangerItem("Compass Cap", "graphics/def_socks.png", 
                "It's not much, but it protects and always points North!", 
                "def", 10);
        new AttChangerItem("Socks", "graphics/def_orionsbletnecklace.png", 
                "Two cases knitted with threads of twilight and goatskin; giften by a certain Maru Mori to a poet grown old centuries ago.", 
                "def", 15);
        new AttChangerItem("Orion's Belt Necklace", "graphics/def_orionsbeltnecklace.png", 
                "Contains the protection of a thousand magnetic fields.", 
                "def", 20);
        new AttChangerItem("Silver-Nitrate Electroplated Chestplate", "graphics/def_silvernitrateelectroplatedarmor.png", 
                "An antique prized piece of protection manufactured in the bygone eras that still holds today.",
                "def", 30);
        
        //(1.2) Initializing TempAttChangerItems
        new TempAttChangerItem("Water", "graphics/hp_waterbottle.png", 
                "Nothing can beat the feeling of drinking the basic drink.", 
                "hp", 10, 3);
        new TempAttChangerItem("Lemon Concoction", "graphics/hp_lemonconcoction.png", 
                "So warm, it gradually heals all minor bodily inconveniences!", 
                "hp", 15, 3);
        new TempAttChangerItem("Cetirizine", "graphics/hp_cetirizine.png", 
                "Your fevers gripped me again, never kisses all you ever send are fullstops...", 
                "hp", 20, 3);
        new TempAttChangerItem("Alchemist's Supreme Healing Potion", "graphics/hp_alchemistssupremehealingpotion.png", 
                "Gives you immense health points when you were there alone...", 
                "hp", 25, 3);
        new TempAttChangerItem("Rod of <Name>", "graphics/hp_rodofinsertnamehere.png", 
                "A magical healing staff infused with the souls of an indeterminable number of Redd School Chem-Bio students.", 
                "hp", 35, 3);
        
        new TempAttChangerItem("Dagger", "graphics/atk_dagger.png", 
                "Small, but terrible. Packs quite a punch (or stab).", 
                "atk", 5, 3);
        new TempAttChangerItem("Tequila", "graphics/atk_tequila.png", 
                "When lemon concoction doesn't suffice, drinking this is recommended for improving your concentration.", 
                "atk", 10, 3);
        new TempAttChangerItem("Radioactive Pie", "graphics/atk_radioactivepie.png", 
                "Came from outer space! While the gamma rays might hurt your throat, the beneficial mutations allow you to grow your strength...", 
                "atk", 15, 3);
        new TempAttChangerItem("Gold Oxide Concoction", "graphics/atk_goldoxideconcoction.png", 
                "Manufactured from an electrolytic chamber, gives you a sense of great potential.", 
                "atk", 20, 3);
        new TempAttChangerItem("Trigem Amulet", "graphics/atk_trigemamulet.png", 
                "A familiar-looking circular compass that guides your attack capabilities.",
                "atk", 30, 3);
        
        new TempAttChangerItem("Glasses", "graphics/def_glasses.png", 
                "In a post-apocalyptic world, it's better to have eye protection.", 
                "def", 5, 3);
        new TempAttChangerItem("Compass Cap", "graphics/def_socks.png", 
                "It's not much, but it protects and always points North!", 
                "def", 10, 3);
        new TempAttChangerItem("Socks", "graphics/def_orionsbletnecklace.png", 
                "Two cases knitted with threads of twilight and goatskin; giften by a certain Maru Mori to a poet grown old centuries ago.", 
                "def", 15, 3);
        new TempAttChangerItem("Orion's Belt Necklace", "graphics/def_orionsbeltnecklace.png", 
                "Contains the protection of a thousand magnetic fields.", 
                "def", 20, 3);
        new TempAttChangerItem("Silver-Nitrate Electroplated Chestplate", "graphics/def_silvernitrateelectroplatedarmor.png", 
                "An antique prized piece of protection manufactured in the bygone eras that still holds today.",
                "def", 30, 3);
        
        //(1.2) Initializing Events, Scenarios, and Choices
        
        Event camp01 = new Event("01camp", null, "csv/01camppath.csv", null, null); //due to time constraints, we were not able to create dialogue files for each of the four phases
        Event camp02 = new Event("02camp", null, "csv/02camppathfoundpuzzle.csv", null, null);
        Event camp03 = new Event("03camp", null, "csv/03camppathsolvedpuzzle.csv",null,null);
        Event trashc1 = new Event("05trashpile",null,"csv/05trashpilepath_choice1",null,null);
        Event trashc2 = new Event("06trashpile",null,"csv/06trashpilepath_choice2",null,null);
        Event trash07 = new Event("07trashpile",null,"csv/07trashpilepath2.csv",null,null);
        Event trash08 = new Event("08trashpile",null,"csv/08trashpilepathtwinsheardconvo.csv",null,null);
        Event trash09 = new Event("09trashpile",null,"csv/09trashpilepathafterpuzzle.csv",null,null);
        Event alt10 = new Event("10armslegstorso",null,"csv/10armslegstorsopath.csv",null,null);
        Event lasc1 = new Event("12lascaux",null,"csv/12ALTpathpainting1_choice1.csv",null,null);
        Event lasc2 = new Event("13lascaux",null,"csv/13ALTpathpainting1_choice2.csv",null,null);
        Event lasc2cont = new Event("14lascaux",null,"csv/14ALTpathpainting1_choice2cont.csv",null,null);
        Event lasc3 = new Event("15lascaux",null,"csv/15ALTpathpainting1_choice3.csv",null,null);
        Event lasc4 = new Event("16lascaux",null,"csv/16ALTpathpainting1_choice4.csv",null,null);
        Event lasc4cont = new Event("17lascaux",null,"csv/17ALTpathpainting1_choice4cont.csv",null,null);
        Event altc1 = new Event("19altamira",null,"csv/19ALTpathpainting2_choice1.csv",null,null);
        Event altc2 = new Event("20altamira",null,"csv/20ALTpathpainting2_choice2.csv",null,null);
        Event altc2cont = new Event("21altamira",null,"csv/21ALTpathpainting2_choice2cont.csv",null,null);
        Event altc3 = new Event("22altamira",null,"csv/22ALTpathpainting2_choice3.csv",null,null);
        Event altc4 = new Event("23altamira",null,"csv/23ALTpathpainting2_choice4.csv",null,null);
        Event altc4cont = new Event("24altamira",null,"csv/24ALTpathpainting2_choice4cont.csv",null,null);
        Event chac1 = new Event("25chauvet",null,"csv/25ALTpathpainting3_choice1.csv",null,null);
        Event chac2 = new Event("26chauvet",null,"26ALTpathpainting3_choice2.csv",null,null);
        Event chac2cont = new Event("27chauvet",null,"csv/27ALTpathpainting3_choice2cont.csv",null,null);
        Event chac3 = new Event("28chauvet",null,"csv/28ALTpathpainting3_choice3.csv",null,null);
        Event chac4 = new Event("29chauvet",null,"csv/29ALTpathpainting3_choice4.csv",null,null);
        Event chac4cont = new Event("30chauvet",null,"csv/30ALTpathpainting3_choice4cont.csv",null,null);
        Event magc1 = new Event("31.5magura",null,"csv/31.5ALTpathpainting4_choice1.csv",null,null);
        Event magc2 = new Event("32magura",null,"csv/32ALTpathpainting4_choice2.csv",null,null);
        Event magc2cont = new Event("33magura",null,"csv/33ALTpathpainting4_choice2cont.csv",null,null);
        Event magc3 = new Event("34magura",null,"csv/34ALTpathpainting4_choice3.csv",null,null);
        Event magc4 = new Event("35magura",null,"csv/35ALTpathpainting4_choice4.csv",null,null);
        Event magc4cont = new Event("36magura",null,"csv/36ALTpathpainting4_choice4cont.csv",null,null);
        Event torso37 = new Event("37torsopath",null,"csv/37torsopath.csv",null,null);
        Event head38 = new Event("38headpath",null,"csv/38headpath.csv",null,null);
        Event head39 = new Event("39headpath",null,"csv/39headpathbattlefield.csv",null,null);
        Event head40 = new Event("40headpath",null,"csv/40headpathafterthebattle.csv",null,null);
        
        s0c1 = new Choice("Why are you here?",trashc1); //csv here
        s0c2 = new Choice("What are you doing here?", trashc2); //csv here

        s1c1 = new Choice("Hi, can you help me go to the next location, please?",lasc1); //csv here
        s1c2 = new Choice("Hey you! Can you help me go to the next location?",lasc2); //csv here
        s1c3 = new Choice("Can you tell me who you are? And help me go to the next location.", lasc3); //csv here
        s1c4 = new Choice("I don't care. Just help me.", lasc4); //csv here

        s2c1 = new Choice("Hi, can you help me go to the next location, please?",altc1); //csv here
        s2c2 = new Choice("Hey you! Can you help me go to the next location?",altc2); //csv here
        s2c3 = new Choice("Can you tell me who you are? And help me go to the next location.", altc3); //csv here
        s2c4 = new Choice("I don't care. Just help me.", altc4); //csv here

        s3c1 = new Choice("Hi, can you help me go to the next location, please?",chac1); //csv here
        s3c2 = new Choice("Hey you! Can you help me go to the next location?",chac2); //csv here
        s3c3 = new Choice("Can you tell me who you are? And help me go to the next location.", chac3); //csv here
        s3c4 = new Choice("I don't care. Just help me.", chac4); //csv here

        s4c1 = new Choice("Hi, can you help me go to the next location, please?",magc1); //csv here
        s4c2 = new Choice("Hey you! Can you help me go to the next location?",magc2); //csv here
        s4c3 = new Choice("Can you tell me who you are? And help me go to the next location.", magc3); //csv here
        s4c4 = new Choice("I don't care. Just help me.", magc4); //csv here
        
        Scenario s0 = new Scenario("04trashpile",null,"csv/04trashpilepath.csv",null,null, s0c1, s0c2);
        Scenario s1 = new Scenario("11armslegstorso",null,"csv/11armslegstorsopathafterfindingpuzzle.csv",null,null, s1c1, s1c2, s1c3, s1c4);
        Scenario s2 = new Scenario("18altamira",null,"csv/18ALTpathpainting2.csv",null,null, s2c1, s2c2, s2c3, s2c4);
        Scenario s3 = new Scenario("24.5chauvet",null,"csv/24.5ALTpathpainting3.csv",null,null, s3c1, s3c2, s3c3, s3c4);
        Scenario s4 = new Scenario("31magura",null,"csv/31ALTpathpainting4.csv",null,null, s4c1, s4c2, s4c3, s4c4);
        
        camp01.addToEventList();
        camp02.addToEventList();
        camp03.addToEventList();
        s0.addToEventList();
        trashc1.addToEventList();
        trashc2.addToEventList();
        trash07.addToEventList();
        trash08.addToEventList();
        trash09.addToEventList();
        alt10.addToEventList();
        s1.addToEventList();
        lasc1.addToEventList();
        lasc2.addToEventList();
        lasc2cont.addToEventList();
        lasc3.addToEventList();
        lasc4.addToEventList();
        lasc4cont.addToEventList();
        s2.addToEventList();
        altc1.addToEventList();
        altc2.addToEventList();
        altc2cont.addToEventList();
        altc3.addToEventList();
        altc4.addToEventList();
        altc4cont.addToEventList();
        s3.addToEventList();
        chac1.addToEventList();
        chac2.addToEventList();
        chac2cont.addToEventList();
        chac3.addToEventList();
        chac4.addToEventList();
        chac4cont.addToEventList();
        s4.addToEventList();
        magc1.addToEventList();
        magc2.addToEventList();
        magc2cont.addToEventList();
        magc3.addToEventList();
        magc4.addToEventList();
        magc4cont.addToEventList();
        torso37.addToEventList();
        head38.addToEventList();
        head39.addToEventList();
        head40.addToEventList();
        
        Event altbrokenpaintings = new Event("altbrokenpaintings",null,"csv/armslegstorsobrokenpaintingsSheet.csv",null,null);
        Event altclothes = new Event("altclothes",null,"csv/armslegstorsoclothesSheet.csv",null,null);
        Event altjoseph = new Event("altjoseph",null,"csv/armslegstorsojosephSheet.csv",null,null);
        Event altrichard = new Event("altrichard",null,"csv/armslegstorsorichardSheet.csv",null,null);
        Event altstatuepieces = new Event("altstatuepieces",null,"csv/armslegstorsostatuepiecesSheet.csv",null,null);
        Event altstone = new Event("altstone",null,"csv/armslegstorsostoneSheet.csv",null,null);
        Event altthomas = new Event("altthomas",null,"csv/armslegstorsothomasSheet.csv",null,null);
        Event campcampfire = new Event("campcampfire",null,"csv/campcampfireSheet.csv",null,null);
        Event campjames = new Event("campjames",null,"csv/campjamesSheet.csv",null,null);
        Event campjohn = new Event("campjohn",null,"csv/campjohnSheet.csv",null,null);
        Event camppillow = new Event("camppillow",null,"csv/camppillowSheet.csv",null,null);
        Event camprobert = new Event("camprobert",null,"csv/camprobertSheet.csv",null,null);
        Event camptable = new Event("camptable",null,"csv/camptableSheet.csv",null,null);
        Event camptent = new Event("camptent",null,"csv/camptentSheet.csv",null,null);
        Event headarmors = new Event("headarmors",null,"csv/headarmorsSheet.csv",null,null);
        Event headcharles = new Event("headcharles",null,"csv/headcharlesSheet.csv",null,null);
        Event headchristopher = new Event("headchristopher",null,"csv/headchristopherSheet.csv",null,null);
        Event headdaniel = new Event("headdaniel",null,"csv/headdanielSheet.csv",null,null);
        Event headdurendal = new Event("headdurendal",null,"csv/headdurendalSheet.csv",null,null);
        Event headhelmets = new Event("headhelmets",null,"csv/headhelmetsSheet.csv",null,null);
        Event headskulls = new Event("headskulls",null,"csv/headskullsSheet.csv",null,null);
        Event trashpilebottles = new Event("trashpilebottles",null,"csv/trashpilebottlesSheet.csv",null,null);
        Event trashpileclothes = new Event("trashpileclothes",null,"csv/trashpileclothesSheet.csv",null,null);
        Event trashpiledavid = new Event("trashpiledavid",null,"csv/trashpiledavidSheet.csv",null,null);
        Event trashpilefoods = new Event("trashpilefoods",null,"csv/trashpilefoodsSheet.csv",null,null);
        Event trashpileglassware = new Event("trashpileglassware",null,"csv/trashpileglasswareSheet.csv",null,null);
        Event trashpilemichael = new Event("trashpilemichael",null,"csv/trashpilemichaelSheet.csv",null,null);
        Event trashpilewilliam = new Event("trashpilewilliam",null,"csv/trashpilewilliamSheet.csv",null,null);
        
        // (1.3) Initializing Characters

        // (1.3.1) Protag
        Protag protag = new Protag("Ethel", "graphics/ethel.png");

        // (1.3.2) MainChara
        MainChara kilo = new MainChara(
                "Kilo",
                "graphics/fatherpfp.png",
                80,
                80,
                15,
                15); //insert event here
        MainChara sierra = new MainChara(
                "Sierra",
                "graphics/motherpfp.png",
                80,
                80,
                15,
                15); //insert event here
        MainChara riley = new MainChara(
                "Riley",
                "graphics/sisterpfp.png",
                80,
                80,
                15,
                15); //insert event here
        MainChara lascaux = new MainChara(
                "Lascaux",
                "graphics/paintingpfp1_nobg.png",
                50,
                50,
                10,
                10); //insert event here
        MainChara altamira = new MainChara(
                "Altamira",
                "graphics/paintingpfp2_nobg.png",
                50,
                50,
                10,
                10); //insert event here
        MainChara chauvet = new MainChara(
                "Chauvet",
                "graphics/paintingpfp3_nobg.png",
                50,
                50,
                10,
                10); //insert event here
        MainChara magura = new MainChara(
                "Magura",
                "graphics/paintingpfp4_nobg.png",                 
                50,
                50,
                10,
                10); //insert event here
        MainChara trashman = new MainChara(
                "Trashman",
                "graphics/trashmanpfp.png",
                75,
                75,
                15,
                15); //insert event here
        MainChara delta = new MainChara(
                "Delta",
                "graphics/twin1pfp.png",
                200,
                200,
                40,
                40); //insert event here
        MainChara ditto = new MainChara(
                "Ditto",
                "graphics/twin2pfp.png",              
                200,
                200,
                40,
                40); //insert event here

        //(1.3.3) NPC 
        NPC joseph = new NPC(
            "Joseph",
            "graphics/josephphp.png",
            0,
            0,
            0,
            0,
            altjoseph); //insert event here
        NPC richard = new NPC(
            "Richard",
            "graphics/richardphp.png",
            0,
            0,
            0,
            0,
            altrichard); //insert event here
        NPC thomas = new NPC(
            "Thomas",
            "graphics/thomasphp.png",
            0,
            0,
            0,
            0,
            altthomas); //insert event here
        NPC james = new NPC(
            "James",
            "graphics/jamespfp.png",
            0,
            0,
            0,
            0,
            campjames); //insert event here
        NPC john = new NPC(
            "John",
            "graphics/johnphp.png",
            0,
            0,
            0,
            0,
            campjohn); //insert event here
        NPC robert = new NPC(
            "Robert",
            "graphics/robertphp.png",
            0,
            0,
            0,
            0,
            camprobert); //insert event here
        NPC charles = new NPC(
            "Charles",
            "graphics/charlespfp.png",
            0,
            0,
            0,
            0,
            headcharles); //insert event here
        NPC cristopher = new NPC(
            "Cristopher",
            "graphics/christopherpfp.png",
            0,
            0,
            0,
            0,
            headchristopher); //insert event here
        NPC daniel = new NPC(
            "Daniel",
            "graphics/danielpfp.png",
            0,
            0,
            0,
            0,
            headdaniel); //insert event here
        NPC david = new NPC(
            "David",
            "graphics/davidpfp.png",
            0,
            0,
            0,
            0,
            trashpiledavid); //insert event here
        NPC michael = new NPC(
            "Michael",
            "graphics/michaelphp.png",
            0,
            0,
            0,
            0,
            trashpilemichael); //insert event here
        NPC william = new NPC(
            "William",
            "graphics/williamphp.png",
            0,
            0,
            0,
            0,
            trashpilewilliam); //insert event here

        //(1.5) Puzzle

        //(1.5.1) Puzzle 1
        Puzzle puzzle1 = new Puzzle(
        "puzzle1",
        6, //bX
        6, //bY
        0, //pX
        5, //pY
        5, //tX
        5, //tY
        null, //block f: set already in Puzzle view
        protag);


        Door p1_d1 = new Door(
        "Door",
        "graphics/DoorHorizontal.png",
        2, //pX
        2, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        Door p1_d2 = new Door(
        "Door",
        "graphics/DoorHorizontal.png",
        4, //pX
        4, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        PuzzleBlock p1_pb1 = new PuzzleBlock(
        "PuzzleBlock",
        "graphics/PuzzleBlock.png",
        1, //change (pX)
        4, //change (pY)
        puzzle1, //change (puzzle)
        p1_d1, //change to Door if applicable
        null, //change to Item if applicable
        1, //change (gpX)
        0, //change (gpY)
        0, //change (ipX)
        0, //change (ipY)
        "door" //change to "door" or "item"
        );

        ButtonPuzzle p1_b2 = new ButtonPuzzle(
        (Puzzle) null, //puzzle
        "Button Puzzle (Item)", 
        "graphics/button.png",
        4, //pX
        1, //pY
        p1_d2, //door to open
        4, //dX
        4  //dY
        ); //change Puzzle and Door
        
        Wall wall = new Wall(
        "Wall",
        "graphics/wall.png",
        0, 0);

        puzzle1.genCol(2, wall);
        puzzle1.genBlock(2, 5, null);
        puzzle1.genBlock(3, 5, wall);
        puzzle1.genBlock(3, 4, wall);
        puzzle1.genBlock(5, 4, wall);

        puzzle1.genBlock(1, 4, p1_pb1);
        puzzle1.genBlock(2, 2, p1_d1);
        puzzle1.genBlock(4, 1, p1_b2);
        puzzle1.genBlock(4, 4, p1_d2);

        //(1.5.2) Puzzle 2
        Puzzle puzzle2 = new Puzzle(
        "puzzle2",
        6, //bX
        6, //bY
        1, //pX
        5, //pY
        5, //tX
        5, //tY
        null, //block f: set already in Puzzle view
        protag);

        //door1 (1)
        Door p2_d1_1 = new Door(
        "Door",
        "graphics/DoorHorizontal.png",
        0, //pX
        3, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //door1 (2)
        Door p2_d1_2 = new Door(
        "Door",
        "graphics/DoorHorizontal.png",
        1, //pX
        3, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //lever1
        Door[] p2_l1_cd = {p2_d1_1, p2_d1_2};
        Lever p2_l1 = //Lever
        new Lever(
        "Lever",
        "graphics/LeverWest.png",
        0, //pX 
        4, //pY
        null, //connected Levers
        p2_l1_cd //connected Doors array Door[]
        ); //dont forget to change direction + door


        //door2
        Door p2_d2 = new Door(
        "Door",
        "graphics/DoorVertical.png",
        2, //pX
        1, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //pb2
        PuzzleBlock p2_pb2 = new PuzzleBlock(
        "PuzzleBlock",
        "graphics/PuzzleBlock.png",
        1, //change (pX)
        2, //change (pY)
        puzzle2, //change (puzzle)
        p2_d2, //change to Door if applicable
        null, //change to Item if applicable
        1, //change (gpX)
        0, //change (gpY)
        0, //change (ipX)
        0, //change (ipY)
        "door" //change to Door or Item
        );

        //door3
        Door p2_d3 = new Door(
        "Door",
        "graphics/DoorHorizontal.png",
        5, //pX
        4, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //pb3
        PuzzleBlock p2_pb3 = new PuzzleBlock(
        "PuzzleBlock",
        "graphics/PuzzleBlock.png",
        3, //change (pX)
        1, //change (pY)
        puzzle2, //change (puzzle)
        p2_d3, //change to Door if applicable
        null, //change to Item if applicable
        5, //change (gpX)
        1, //change (gpY)
        0, //change (ipX)
        0, //change (ipY)
        "door" //change to Door or Item
        );

        puzzle2.genRow(2, wall);
        puzzle2.genCol(2, wall);
        puzzle2.genCol(4, wall);
        puzzle2.genBlock(2, 5, null);
        puzzle2.genBlock(2, 4, null);
        puzzle2.genBlock(2, 1, null);
        puzzle2.genBlock(4, 5, wall);
        puzzle2.genBlock(4, 4, wall);
        puzzle2.genBlock(p2_d1_1.getPosX(), p2_d1_1.getPosY(), p2_d1_1);
        puzzle2.genBlock(p2_d1_2.getPosX(), p2_d1_2.getPosY(), p2_d1_2);
        puzzle2.genBlock(p2_l1.getPosX(), p2_l1.getPosY(), p2_l1);
        puzzle2.genBlock(p2_d2.getPosX(), p2_d2.getPosY(), p2_d2);
        puzzle2.genBlock(p2_pb2.getPosX(), p2_pb2.getPosY(), p2_pb2);
        puzzle2.genBlock(p2_d3.getPosX(), p2_d3.getPosY(), p2_d3);
        puzzle2.genBlock(p2_pb3.getPosX(), p2_pb3.getPosY(), p2_pb3);

        //(1.5.3) Puzzle 3
        Puzzle puzzle3 = new Puzzle(
        "puzzle3",
        6, //bX
        6, //bY
        0, //pX
        5, //pY
        4, //tX
        1, //tY
        null, //block f: set already in Puzzle view
        protag);

        //d1 (unlocked)
        Door p3_d1 = new Door(
        "Door",
        "graphics/DoorHorizontal.png",
        1, //pX
        2, //pY
        "<>", //sin
        false, //opened
        false //locked
        );

        //b1
        ButtonPuzzle p3_b1 = new ButtonPuzzle(
        (Puzzle) null, //puzzle
        "Button Puzzle (Item)", 
        "graphics/button.png",
        0, //pX
        0, //pY
        p3_d1, //door to open
        1, //dX
        2  //dY
        ); //change Puzzle and Door

        //d2 (u by b1)
        Door p3_d2 = new Door(
        "Door",
        "graphics/DoorVertical.png",
        2, //pX
        4, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //d3
        Door p3_d3 = new Door(
        "Door",
        "graphics/DoorHorizontal.png",
        2, //pX
        1, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //pb3
        PuzzleBlock p3_pb3 = new PuzzleBlock(
        "PuzzleBlock",
        "graphics/PuzzleBlock.png",
        4, //change (pX)
        4, //change (pY)
        puzzle3, //change (puzzle)
        p3_d3, //change to Door if applicable
        null, //change to Item if applicable
        0, //change (gpX)
        0, //change (gpY)
        0, //change (ipX)
        0, //change (ipY)
        "Door" //change to Door or Item
        );

        puzzle3.genRow(2, wall);
        puzzle3.genCol(2, wall);
        puzzle3.genBlock(p3_d1.getPosX(), p3_d1.getPosY(), p3_d1);//d1 (unlocked)
        puzzle3.genBlock(p3_b1.getPosX(), p3_b1.getPosY(), p3_b1);//b1
        puzzle3.genBlock(p3_d2.getPosX(), p3_d2.getPosY(), p3_d2);//d2 (u by b1)
        puzzle3.genBlock(p3_d3.getPosX(), p3_d3.getPosY(), p3_d3);//d3
        puzzle3.genBlock(p3_pb3.getPosX(), p3_pb3.getPosY(), p3_pb3); //pb3

        //(1.5.4) Puzzle 4
        Puzzle puzzle4 = new Puzzle(
        "puzzle4",
        6, //bX
        6, //bY
        1, //pX
        3, //pY
        1, //tX
        5, //tY
        null, //block f: set already in Puzzle view
        protag);

        //d1 (u)
        Door p4_d1 = new Door(
        "Door",
        "graphics/DoorHorizontal.png",
        0, //pX
        2, //pY
        "<>", //sin
        false, //opened
        false //locked
        );

        //d2
        Door p4_d2 = new Door(
        "Door",
        "graphics/DoorVertical.png",
        2, //pX
        1, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //d3
        Door p4_d3 = new Door(
        "Door",
        "graphics/DoorVertical.png",
        4, //pX
        4, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //d4
        Door p4_d4 = new Door(
        "Door",
        "graphics/DoorHorizontal.png",
        5, //pX
        0, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //b2
        ButtonPuzzle p4_b2 = new ButtonPuzzle(
        puzzle4, //puzzle
        "Button Puzzle (Item)", 
        "graphics/button.png",
        0, //pX
        0, //pY
        p4_d2, //door to open
        2, //dX
        1  //dY
        ); //change Puzzle and Door

        //pb3
        PuzzleBlock p4_pb3 = new PuzzleBlock(
        "PuzzleBlock",
        "graphics/PuzzleBlock.png",
        3, //change (pX)
        3, //change (pY)
        puzzle4, //change (puzzle)
        p4_d3, //change to Door if applicable
        null, //change to Item if applicable
        3, //change (gpX)
        5, //change (gpY)
        0, //change (ipX)
        0, //change (ipY)
        "door" //change to Door or Item
        );

        //pb4
        PuzzleBlock p4_pb4 = new PuzzleBlock(
        "PuzzleBlock",
        "graphics/PuzzleBlock.png",
        0, //change (pX)
        0, //change (pY)
        puzzle4, //change (puzzle)
        p4_d4, //change to Door if applicable
        null, //change to Item if applicable
        5, //change (gpX)
        0, //change (gpY)
        0, //change (ipX)
        0, //change (ipY)
        "door" //change to Door or Item
        );


        puzzle4.genCol(2, wall);
        puzzle4.genCol(4, wall);
        puzzle4.genBlock(0, 4, wall);
        puzzle4.genBlock(1, 2, wall);
        puzzle4.genBlock(p4_d1.getPosX(), p4_d1.getPosY(), p4_d1); //d1 (u)
        puzzle4.genBlock(p4_d2.getPosX(), p4_d2.getPosY(), p4_d2); //d2
        puzzle4.genBlock(p4_d3.getPosX(), p4_d3.getPosY(), p4_d3); //d3
        puzzle4.genBlock(p4_d4.getPosX(), p4_d4.getPosY(), p4_d4); //d4
        puzzle4.genBlock(p4_b2.getPosX(), p4_b2.getPosY(), p4_b2); //b2
        puzzle4.genBlock(p4_pb3.getPosX(), p4_pb3.getPosY(), p4_pb3); //pb3
        puzzle4.genBlock(p4_pb4.getPosX(), p4_pb4.getPosY(), p4_pb4); //pb4

        //(1.5.5) Puzzle 5
        Puzzle puzzle5 = new Puzzle(
        "puzzle5",
        6, //bX
        6, //bY
        2, //pX
        0, //pY
        2, //tX
        5, //tY
        null, //block f: set already in Puzzle view
        protag);


        //d1
        Door p5_d1 = new Door(
        "Door",
        "graphics/DoorHorizontal.png",
        4, //pX
        4, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //d2
        Door p5_d2 = new Door(
        "Door",
        "graphics/DoorHorizontal.png",
        2, //pX
        4, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //pb1
        PuzzleBlock p5_pb1 = new PuzzleBlock(
        "PuzzleBlock",
        "graphics/PuzzleBlock.png",
        4, //change (pX)
        2, //change (pY)
        puzzle5, //change (puzzle)
        p5_d1, //change to Door if applicable
        null, //change to Item if applicable
        0, //change (gpX)
        0, //change (gpY)
        0, //change (ipX)
        0, //change (ipY)
        "door" //change to Door or Item
        );

        //b2
        ButtonPuzzle p5_b2 = new ButtonPuzzle(
        puzzle5, //puzzle
        "Button Puzzle (Item)", 
        "graphics/button.png",
        5, //pX
        5, //pY
        p5_d2, //door to open
        0, //dX
        0  //dY
        ); //change Puzzle and Door

        puzzle5.genBlock(1, 4, wall);
        puzzle5.genBlock(1, 5, wall);
        puzzle5.genBlock(3, 4, wall);
        puzzle5.genBlock(3, 5, wall);
        puzzle5.genBlock(5, 4, wall);
        puzzle5.genBlock(3, 0, wall);
        puzzle5.genBlock(3, 1, wall);
        puzzle5.genBlock(2, 1, wall);
        puzzle5.genBlock(2, 2, wall);
        puzzle5.genBlock(p5_d1.getPosX(), p5_d1.getPosY(), p5_d1);
        puzzle5.genBlock(p5_d2.getPosX(), p5_d2.getPosY(), p5_d2);
        puzzle5.genBlock(p5_pb1.getPosX(), p5_pb1.getPosY(), p5_pb1);
        puzzle5.genBlock(p5_b2.getPosX(), p5_b2.getPosY(), p5_b2);

        //(1.5.6) Puzzle 6
        Puzzle puzzle6 = new Puzzle(
        "puzzle6",
        6, //bX
        6, //bY
        1, //pX
        5, //pY
        0, //tX
        0, //tY
        null, //block f: set already in Puzzle view
        protag);


        //d1
        Door p6_d1 = new Door(
        "Door",
        "graphics/DoorHorizontal.png",
        4, //pX
        5, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //d2
        Door p6_d2 = new Door(
        "Door",
        "graphics/DoorHorizontal.png",
        0, //pX
        2, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //pb1
        PuzzleBlock p6_pb1 = new PuzzleBlock(
        "PuzzleBlock",
        "graphics/PuzzleBlock.png",
        2, //change (pX)
        4, //change (pY)
        puzzle6, //change (puzzle)
        p6_d1, //change to Door if applicable
        null, //change to Item if applicable
        0, //change (gpX)
        5, //change (gpY)
        0, //change (ipX)
        0, //change (ipY)
        "door" //change to Door or Item
        );

        //pb2
        PuzzleBlock p6_pb2 = new PuzzleBlock(
        "PuzzleBlock",
        "graphics/PuzzleBlock.png",
        3, //change (pX)
        1, //change (pY)
        puzzle6, //change (puzzle)
        p6_d2, //change to Door if applicable
        null, //change to Item if applicable
        5, //change (gpX)
        0, //change (gpY)
        0, //change (ipX)
        0, //change (ipY)
        "door" //change to Door or Item
        );

        puzzle6.genBlock(1, 4, wall);
        puzzle6.genBlock(4, 1, wall);
        puzzle6.genBlock(1, 0, wall);
        puzzle6.genBlock(1, 1, wall);
        puzzle6.genBlock(1, 2, wall);
        puzzle6.genBlock(2, 2, wall);
        puzzle6.genBlock(3, 3, wall);
        puzzle6.genBlock(4, 3, wall);
        puzzle6.genBlock(4, 4, wall);
        puzzle6.genBlock(p6_d1.getPosX(), p6_d1.getPosY(), p6_d1);
        puzzle6.genBlock(p6_d2.getPosX(), p6_d2.getPosY(), p6_d2);
        puzzle6.genBlock(p6_pb1.getPosX(), p6_pb1.getPosY(), p6_pb1);
        puzzle6.genBlock(p6_pb2.getPosX(), p6_pb2.getPosY(), p6_pb2);

        //(1.5.7) Puzzle 7
        Puzzle puzzle7 = new Puzzle(
        "puzzle7",
        6, //bX
        6, //bY
        5, //pX
        0, //pY
        4, //tX
        4, //tY
        null, //block f: set already in Puzzle view
        protag);

        //d1
        Door p7_d1 = new Door(
        "Door",
        "graphics/DoorVertical.png",
        2, //pX
        4, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //pb1
        PuzzleBlock p7_pb1 = new PuzzleBlock(
        "PuzzleBlock",
        "graphics/PuzzleBlock.png",
        1, //change (pX)
        1, //change (pY)
        puzzle7, //change (puzzle)
        p7_d1, //change to Door if applicable
        null, //change to Item if applicable
        1, //change (gpX)
        5, //change (gpY)
        0, //change (ipX)
        0, //change (ipY)
        "door" //change to Door or Item
        );

        puzzle7.genRow(2, wall);
        puzzle7.genCol(2, wall);
        puzzle7.genBlock(0, 2, null);
        puzzle7.genBlock(1, 2, null);
        puzzle7.genBlock(2, 0, null);
        puzzle7.genBlock(2, 1, null);
        puzzle7.genBlock(p7_pb1.getPosX(), p7_pb1.getPosY(), p7_pb1);
        puzzle7.genBlock(p7_d1.getPosX(), p7_d1.getPosY(), p7_d1);

        //(1.5.8) Puzzle 8
        Puzzle puzzle8 = new Puzzle(
        "puzzle8",
        6, //bX
        6, //bY
        0, //pX
        5, //pY
        5, //tX
        0, //tY
        null, //block f: set already in Puzzle view
        protag);


        //d1
        Door p8_d1 = new Door(
        "Door",
        "graphics/DoorVertical.png",
        1, //pX
        2, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //d2
        Door p8_d2 = new Door(
        "Door",
        "graphics/DoorHorizontal.png",
        5, //pX
        3, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //d3
        Door p8_d3 = new Door(
        "Door",
        "graphics/DoorHorizontal.png",
        5, //pX
        1, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //lever1
        Door[] p8_l1_cd = {p8_d1};
        Lever p8_l1 = new Lever(
        "Lever",
        "graphics/LeverNorth.png",
        0, //pX 
        0, //pY
        null, //connected Levers
        p8_l1_cd //connected Doors array Door[]
        ); //dont forget to change direction + door

        //pb2
        PuzzleBlock p8_pb2 = new PuzzleBlock(
        "PuzzleBlock",
        "graphics/PuzzleBlock.png",
        2, //change (pX)
        3, //change (pY)
        puzzle8, //change (puzzle)
        p8_d2, //change to Door if applicable
        null, //change to Item if applicable
        2, //change (gpX)
        5, //change (gpY)
        0, //change (ipX)
        0, //change (ipY)
        "door" //change to Door or Item
        );

        //pb3
        PuzzleBlock p8_pb3 = new PuzzleBlock(
        "PuzzleBlock",
        "graphics/PuzzleBlock.png",
        3, //change (pX)
        2, //change (pY)
        puzzle8, //change (puzzle)
        p8_d3, //change to Door if applicable
        null, //change to Item if applicable
        3, //change (gpX)
        0, //change (gpY)
        0, //change (ipX)
        0, //change (ipY)
        "door" //change to Door or Item
        );

        puzzle8.genCol(1, wall);
        puzzle8.genCol(4, wall);
        puzzle8.genBlock(4, 4, null);
        puzzle8.genBlock(4, 5, null);
        puzzle8.genBlock(p8_l1.getPosX(), p8_l1.getPosY(), p8_l1);
        puzzle8.genBlock(p8_d1.getPosX(), p8_d1.getPosY(), p8_d1);
        puzzle8.genBlock(p8_d2.getPosX(), p8_d2.getPosY(), p8_d2);
        puzzle8.genBlock(p8_d3.getPosX(), p8_d3.getPosY(), p8_d3);
        puzzle8.genBlock(p8_pb2.getPosX(), p8_pb2.getPosY(), p8_pb2);
        puzzle8.genBlock(p8_pb3.getPosX(), p8_pb3.getPosY(), p8_pb3);

        //(1.5.9) Puzzle 9
        Puzzle puzzle9 = new Puzzle(
        "puzzle9",
        6, //bX
        6, //bY
        2, //pX
        0, //pY
        5, //tX
        4, //tY
        null, //block f: set already in Puzzle view
        protag);

        //d1
        Door p9_d1 = new Door(
        "Door",
        "graphics/DoorHorizontal.png",
        2, //pX
        1, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //d2
        Door p9_d2 = new Door(
        "Door",
        "graphics/DoorHorizontal.png",
        2, //pX
        2, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //d3
        Door p9_d3 = new Door(
        "Door",
        "graphics/DoorVertical.png",
        3, //pX
        4, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //pb1
        PuzzleBlock p9_pb1 = new PuzzleBlock(
        "PuzzleBlock",
        "graphics/PuzzleBlock.png",
        1, //change (pX)
        0, //change (pY)
        puzzle9, //change (puzzle)
        p9_d1, //change to Door if applicable
        null, //change to Item if applicable
        0, //change (gpX)
        0, //change (gpY)
        0, //change (ipX)
        0, //change (ipY)
        "door" //change to Door or Item
        );

        //pb2
        PuzzleBlock p9_pb2 = new PuzzleBlock(
        "PuzzleBlock",
        "graphics/PuzzleBlock.png",
        3, //change (pX)
        0, //change (pY)
        puzzle9, //change (puzzle)
        p9_d2, //change to Door if applicable
        null, //change to Item if applicable
        4, //change (gpX)
        0, //change (gpY)
        0, //change (ipX)
        0, //change (ipY)
        "door" //change to Door or Item
        );

        //pb3
        PuzzleBlock p9_pb3 = new PuzzleBlock(
        "PuzzleBlock",
        "graphics/PuzzleBlock.png",
        1, //change (pX)
        4, //change (pY)
        puzzle9, //change (puzzle)
        p9_d3, //change to Door if applicable
        null, //change to Item if applicable
        0, //change (gpX)
        3, //change (gpY)
        0, //change (ipX)
        0, //change (ipY)
        "door" //change to Door or Item
        );

        puzzle9.genRow(1, wall);
        puzzle9.genRow(2, wall);
        puzzle9.genCol(3, wall);

        puzzle9.genBlock(p9_d1.getPosX(), p9_d1.getPosY(), p9_d1);
        puzzle9.genBlock(p9_d2.getPosX(), p9_d2.getPosY(), p9_d2);
        puzzle9.genBlock(p9_d3.getPosX(), p9_d3.getPosY(), p9_d3);
        puzzle9.genBlock(p9_pb1.getPosX(), p9_pb1.getPosY(), p9_pb1);
        puzzle9.genBlock(p9_pb2.getPosX(), p9_pb2.getPosY(), p9_pb2);
        puzzle9.genBlock(p9_pb3.getPosX(), p9_pb3.getPosY(), p9_pb1);

        //(1.5.10) Puzzle 10
        Puzzle puzzle10 = new Puzzle(
        "puzzle10",
        6, //bX
        6, //bY
        1, //pX
        0, //pY
        0, //tX
        4, //tY
        null, //block f: set already in Puzzle view
        protag);

        //door1
        Door p10_d1 = new Door(
        "Door",
        "graphics/DoorHorizontal.png",
        4, //pX
        2, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //door2
        Door p10_d2 = new Door(
        "Door",
        "graphics/DoorVertical.png",
        3, //pX
        4, //pY
        "<>", //sin
        false, //opened
        true //locked
        );

        //pb1
        PuzzleBlock p10_pb1 = new PuzzleBlock(
        "PuzzleBlock",
        "graphics/PuzzleBlock.png",
        4, //change (pX)
        1, //change (pY)
        puzzle10, //change (puzzle)
        p10_d1, //change to Door if applicable
        null, //change to Item if applicable
        1, //change (gpX)
        1, //change (gpY)
        0, //change (ipX)
        0, //change (ipY)
        "door" //change to Door or Item
        );
        //pb2

        PuzzleBlock p10_pb2 = new  PuzzleBlock(
        "PuzzleBlock",
        "graphics/PuzzleBlock.png",
        4, //change (pX)
        4, //change (pY)
        puzzle10, //change (puzzle)
        p10_d2, //change to Door if applicable
        null, //change to Item if applicable
        4, //change (gpX)
        5, //change (gpY)
        0, //change (ipX)
        0, //change (ipY)
        "door" //change to Door or Item
        );

        puzzle10.genRow(2, wall);
        puzzle10.genBlock(1, 4, wall);
        puzzle10.genBlock(2, 0, wall);
        puzzle10.genBlock(5, 2, wall);
        puzzle10.genBlock(3, 3, wall);
        puzzle10.genBlock(3, 5, wall);

        puzzle10.genBlock(p10_d1.getPosX(), p10_d1.getPosY(), p10_d1);
        puzzle10.genBlock(p10_d2.getPosX(), p10_d2.getPosY(), p10_d2);
        puzzle10.genBlock(p10_pb1.getPosX(), p10_pb1.getPosY(), p10_pb1);
        puzzle10.genBlock(p10_pb2.getPosX(), p10_pb2.getPosY(), p10_pb2);
        
        
        //(1.7) Initializing WorldItems
        
        WorldItem wl_altbrokenpaintings = new WorldItem("altbrokenpaintings", "graphics/item_armslegstorsobrokenpaintings.png", "", altbrokenpaintings);
        WorldItem wl_altclothes = new WorldItem("altclothes", "graphics/item_armslegstorsoclothes.png", "", altclothes);
        WorldItem wl_altstatuespieces = new WorldItem("altstatuespieces", "graphics/item_armslegstorsostatuepieces.png", "", altstatuepieces);
        WorldItem wl_altstone = new WorldItem("altstone", "graphics/item_armslegstorsostone.png", "", altstone);
        WorldItem wl_campcampfire = new WorldItem("campcampfire", "graphics/item_campcampfire.png", "", campcampfire);
        WorldItem wl_camppillow = new WorldItem("camppillow", "graphics/item_camppillow.png", "", camppillow);
        WorldItem wl_camptable = new WorldItem("camptable", "graphics/item_camptable.png", "", camptable);
        WorldItem wl_camptent = new WorldItem("camptent", "graphics/item_camptent.png", "", camptent);
        WorldItem wl_headarmors = new WorldItem("headarmors", "graphics/item_headarmors.png", "", headarmors);
        WorldItem wl_headdurendal = new WorldItem("headdurendal", "graphics/item_headdurendal.png", "", headdurendal);
        WorldItem wl_headhelmets = new WorldItem("headhelmets", "graphics/item_headhelmets.png", "", headhelmets);
        WorldItem wl_headskulls = new WorldItem("headskulls", "graphics/item_headskulls.png", "", headskulls);
        WorldItem wl_trashpilebottles = new WorldItem("trashpilebottles", "graphics/item_trashpilebottles.png", "", trashpilebottles);
        WorldItem wl_trashpileclothes = new WorldItem("trashpileclothes", "graphics/item_trashpileclothes.png", "", trashpileclothes);
        WorldItem wl_trashpilefoods = new WorldItem("trashpilefoods", "graphics/item_trashpilefoods.png", "", trashpilefoods);
        WorldItem wl_trashpileglassware = new WorldItem("trashpileglassware", "graphics/item_trashpileglassware.png", "", trashpileglassware);

        //(1.8) Initializing Battles
        Battle b0 = new Battle("twinsbattle", protag, null, null, delta, ditto, null, "graphics/bgbattleplacetwins.png"); //add background of battle
        
        //(1.9) Initializing WithinLocations
//          public WithinLocation(String n, String d, String tS, GameplayList[] GL, Scenario[] SL, Choice[] CL) {
//        name = n;
//        desc = d;
//        textureStr = tS;
//        GameplayList = GL;
//        ScenarioList = SL;
//        ChoiceList = CL;
//        storyComplete = false;
//
//        WLList.add(this);
//    }  
        //(1.9.1) Phase 1 WL0 
        GameplayList[] p1_wl0_gl = {                         joseph, 
            richard,
            thomas,
            wl_campcampfire,
            wl_camppillow,
            wl_camptable,
            wl_camptent
        };
        
        WithinLocation p1_wl0 = new WithinLocation(
        "Camp",
        "A place for campers who seeks to find happiness and possibly different resources like gold, money, and pieces of jewelry around the area",
        "graphics/bgcampplace.jpg",
        p1_wl0_gl
        );
        
        //(1.9.2) Phase 1 WL2
        GameplayList[] p1_wl1_gl = {                          wl_trashpilebottles, 
            wl_trashpileclothes,
            wl_trashpilefoods,
            wl_trashpileglassware,
            james,
            john,
            robert
        };
        
        WithinLocation p1_wl1 = new WithinLocation(
        "Trash Pile",
        "A place dumped with different wastes of the people. Most people believe that this place has one of the many fragments of the gem of wit.",
        "graphics/bgtrashpile.jpg",
        p1_wl1_gl
        );
     
        //(1.9.3) Phase 1 WL2
        GameplayList[] p1_wl2_gl = {                          wl_altbrokenpaintings, 
            wl_altclothes,
            cristopher,
            daniel
        };
        
        WithinLocation p1_wl2 = new WithinLocation(
        "Arms and Legs",
        "A place where the arms and legs of the statue landed after its destruction. The limbs seem to be connected to the statue's torso. Most people also believe that this place has one of the Gem of Wit's fragments.",
        "graphics/bgarmsandlegs.png",
        p1_wl2_gl
        );
        
        
        //(1.9.3) Phase 1 WL3
        GameplayList[] p1_wl3_gl = {
            wl_altstatuespieces,
            wl_altstone,
            charles
        };
        
        
        WithinLocation p1_wl3 = new WithinLocation(
        "Torso",
        "A place where the torso part of the great hero statue landed after its destruction. It has a heart inside of it where a puzzle is placed and contains the fragment of the gem of wit.",        
        "graphics/bgtorso.jpg",
        p1_wl3_gl);
        
        //(1.9.4) Phase 1 WL4
        GameplayList[] p1_wl4_gl = {                          wl_altbrokenpaintings, 
            wl_headarmors,
            wl_headdurendal,
            wl_headhelmets,
            wl_headskulls,
            david,
            michael,
            william
        };
        
        WithinLocation p1_wl4 = new WithinLocation(
        "Head",
        "A place where the head of the statue landed after its destruction. Most people believe that this place has a battlefield inside of it and contains the last fragment of the gem of wit.",
        "graphics/bghead.jpg",
        p1_wl4_gl
        );
        
        //(1.10) Initialize Phases
        new Phase("Phase 0", "The beginning of an unnamed character's journey in a post-apocalyptic dystopian world. (This Phase cannot yet be played in this version of the game)");
        new Phase("Phase 1", "An eerie place along the outskirts of the city, where a monument dedicated to a legend once stood. With the hero gone, the city languished, the populace resigned to their indolence. Pilgrims visit to think fondly of times bygone...\n" +
"\n" +
"\n" +
"...A mysterious glow emanates from the ruins of the statue...");
        new Phase("Phase 2", "Sounds of drilling can be heard from a distance, metal colliding with rock. The sound of lava popping beneath your feet is hard to ignore. The mining district is one of the few places still active after [EVENT].\n" +
"\n" +
"There it is again, that unsettling light. It comes from the entrance of the cave. Your curiosity betrays you... (This Phase cannot yet be played in this version of the game)");
        new Phase("Phase 3", "After a grueling journey, you stumble upon the time machine. You knew what you had to do.\n" +
"\n" +
"You stepped in, waiting, listening for the whirs and clicks. Everything went black.\n" +
"\n" +
"When you woke up, you found yourself in the past, 2500 years ago. However, the once bustling city is still infested with zombies. You find one of them looking at you with curiosity... (This Phase cannot yet be played in this version of the game)");
        
        
        
        launch(args);
    }
    
    
}
