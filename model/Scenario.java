/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

import java.util.ArrayList;

/**
 * A Scenario contains Choices a protagonist can choose from which will determine the Events that will happen in the future.
 * @author Diogn Lei R. Mortera
 */
public class Scenario extends Event {
    private Choice choice1, choice2, choice3, choice4;
    private String desc;
    
    public static ArrayList<Scenario> ScenarioList = new ArrayList<Scenario>();
    
    /**
     * A Scenario inherits the properties of a Event, as well as have 2 Choices. A Scenario instance is also automatically added to an ArrayList containing all Scenarios.
     * 
     * @param n name of the Scenario
     * @param DF0 the file for the lines the character in the Scenario says (in phase-0 phase text version)
     * @param DF1 the file for the lines the character in the Scenario says (in phase-1 phase text version)
     * @param DF2 the file for the lines the character in the Scenario says (in phase-2 phase text version)
     * @param DF3 the file for the lines the character in the Scenario says (in phase-3 phase text version)
     * @param c1 first Choice in the Scenario
     * @param c2 second Choice in the Scenario
     */
    public Scenario(String n, String DF0, String DF1, String DF2, String DF3, Choice c1, Choice c2){
        super(n, DF0, DF1, DF2, DF3);
        choice1 = c1;
        choice2 = c2;
        
        String[] emptyArr = {};
        choice3 = new Choice("", null);
        choice4 = new Choice("", null);
        
        desc = "...";
        
        ScenarioList.add(this);
    }
    
    /**
     * A Scenario inherits the properties of a Event, as well as have 3 Choices. A Scenario instance is also automatically added to an ArrayList containing all Scenarios.
     * 
     * @param n name of the Scenario
     * @param DF0 the file for the lines the character in the Scenario says (in phase-0 phase text version)
     * @param DF1 the file for the lines the character in the Scenario says (in phase-1 phase text version)
     * @param DF2 the file for the lines the character in the Scenario says (in phase-2 phase text version)
     * @param DF3 the file for the lines the character in the Scenario says (in phase-3 phase text version)
     * @param c1 first Choice in the Scenario
     * @param c2 second Choice in the Scenario
     * @param c3 third Choice in the Scenario
     */
    public Scenario(String n, String DF0, String DF1, String DF2, String DF3, Choice c1, Choice c2, Choice c3){
        super(n, DF0, DF1, DF2, DF3);
        choice1 = c1;
        choice2 = c2;
        choice3 = c3;
        
        String[] emptyArr = {};
        choice4 = new Choice("", null);
        
        desc = "...";
        
        ScenarioList.add(this);
    }
    
    /**
     * A Scenario inherits the properties of a Event, as well as have 4 Choices. A Scenario instance is also automatically added to an ArrayList containing all Scenarios.
     * 
     * @param n name of the Scenario
     * @param DF0 the file for the lines the character in the Scenario says (in phase-0 phase text version)
     * @param DF1 the file for the lines the character in the Scenario says (in phase-1 phase text version)
     * @param DF2 the file for the lines the character in the Scenario says (in phase-2 phase text version)
     * @param DF3 the file for the lines the character in the Scenario says (in phase-3 phase text version)
     * @param c1 first Choice in the Scenario
     * @param c2 second Choice in the Scenario
     * @param c3 third Choice in the Scenario
     * @param c4 fourth Choice in the Scenario
     */
    public Scenario(String n, String DF0, String DF1, String DF2, String DF3, Choice c1, Choice c2, Choice c3, Choice c4){
        super(n, DF0, DF1, DF2, DF3);
        choice1 = c1;
        choice2 = c2;
        choice3 = c3;
        choice4 = c4;
        
        desc = "...";
        
        ScenarioList.add(this);
    }
    
    /**
     * A Scenario inherits the properties of a Event, as well as have 4 Choices and a description. A Scenario instance is also automatically added to an ArrayList containing all Scenarios.
     * 
     * @param n name of the Scenario
     * @param DF0 the file for the lines the character in the Scenario says (in phase-0 phase text version)
     * @param DF1 the file for the lines the character in the Scenario says (in phase-1 phase text version)
     * @param DF2 the file for the lines the character in the Scenario says (in phase-2 phase text version)
     * @param DF3 the file for the lines the character in the Scenario says (in phase-3 phase text version)
     * @param c1 first Choice in the Scenario
     * @param c2 first Choice in the Scenario
     * @param c3 first Choice in the Scenario
     * @param c4 first Choice in the Scenario
     * @param d description of the Scenario to be displayed in the upper part of the View of the Scenario part in the Within-Location layout
     */
    public Scenario(String n, String DF0, String DF1, String DF2, String DF3, Choice c1, Choice c2, Choice c3, Choice c4, String d){
        super(n, DF0, DF1, DF2, DF3);
        choice1 = c1;
        choice2 = c2;
        choice3 = c3;
        choice4 = c4;
        
        desc = d;
        
        ScenarioList.add(this);
    }
    
    
    //MOVED TO CONTROLLER
    /**
     * Presents the choices to the player (more View-code heavy)
     
    public void presentChoices(){
       //display choices in a 4x4 grid
       //allow each choice to be clickable with a MouseEvent
       //when a choice is clicked, play the corresponding triggerChoice(Choice c)
       
    }*/ 
    
    /**
     * Gets the choice chosen by the player in the View, given a number obtained from a mechanism in the View.
     * @param i
     * @return choice1, choice2, choice3, choice4
     */
    public Choice getChoice(int i){
        switch(i){
            case 1:
                return choice1;
            case 2:
                return choice2;
             case 3:
                return choice3;
            case 4:
                return choice4;
            default:
                break;
        }
        return null;
    }
}
