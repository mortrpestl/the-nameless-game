/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

import java.util.ArrayList;

/**
 * A Within-Location hosts the items that can be interacted, as well as Scenarios and Choices that happen in the WithinLocation.
 * @author Diogn Lei R. Mortera // Edits by Krixian Skye D. Del Rosario
 */
public class WithinLocation {
    private String name;
    private String desc;
    private String textureStr;
    private boolean storyComplete;
    private static int WLNum = 0;
    private static ArrayList<WithinLocation> WLList = new ArrayList<>();
    private GameplayList[] GameplayList;
    private Scenario[] ScenarioList;
    private Choice[] ChoiceList;
    
    //public static ArrayList<WithinLocation> WLList = new ArrayList<WithinLocation>();
    /**
     * A WithinLocation has a name, a texture String for its image in the Location layout, a list of all interactive objects that can be found in the location, and a scenario and choices list that can happen and be chosen, respectively, in the location. A WithinLocation instance is also automatically added to an ArrayList containing all WithinLocations.
     * @param n the name of the Within-Location
     * @param d the description of the Within-Location
     * @param tS the file name of the texture of the Within-Location
     * @param GL the list of all GameplayList objects that can be found in the Within-Location
     */
    public WithinLocation(String n, String d, String tS, GameplayList[] GL){
        name = n;
        desc = d;
        textureStr = tS;
        GameplayList = GL;
        storyComplete = false;
        
        WLList.add(this);
    }
    
    /**
     * Gets the name of the Within-Location.
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Gets the description of the Within-Location.
     * @return desc
     */
    public String getDesc(){
        return desc;
    }
    
    /**
     * Gets the file name of the texture in the Location menu of the Within-Location.
     * @return textureStr
     */
    public String getTextureStr(){
        return textureStr;
    }
    /**
     * Gets the list of all Interactive objects and Puzzles that can be found in the Within-Location.
     * @return GameplayList
     */
    public GameplayList[] getGameplayList(){
        return GameplayList;
    }
    
    /**
     * Gets the list of all Scenarios that can happen in the Within-Location.
     * @return ScenarioList
     */
    public Scenario[] getScenarioList(){
        return ScenarioList;
    }
    
    /**
     * Gets the list of all Choices that can be chosen in the Within-Location.
     * @return ChoiceList
     */
    public Choice[] getChoiceList(){
        return ChoiceList;
    }
    
    public void completeStory(){
        storyComplete = true;
    }
    
    public boolean getStoryComplete(){
        return storyComplete;
    }
    
    /**
     * Gets the number of the Within Location
     * @return WLNum
     */
    public static int getWLNum(){
        return WLNum;
    }
    
    /**
     * Sets the number of the Within Location
     * @param n number to set the number of the WithinLocation to
     */
    public static void setWLNum(int n){
        WLNum = n;
    }
    
    /**
     * when a WithinLocation is clicked in view, this opens the corresponding WithinLocation
     * @param n number of the WithinLocation in the WithinLocation List
     * @return WLList.get(n)
     */
    public static WithinLocation getWL(int n){
        return WLList.get(n);
        //check notebook got more details on this
    }
}
