/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

import java.util.ArrayList;

/**
 * A Phase instance shows the menu for choosing the Phase the player will be playing in. Subsequent phases will only be accessible after the previous phase has been completed.
 * 
 * @author Diogn Lei R. Mortera
 */
public class Phase {
    private String name;
    private String desc;
    private static int phaseNum = 1; //only phase 1 is playable for now
    private static int phaseFin = 0;
    
    private static ArrayList<Phase> PhaseList = new ArrayList<Phase>();
    
    /**
     * A Phase instance has a name, a number, and 5 Locations.
     * @param n name of the Phase instance
     * @param d description of the Phase instance
     */
    public Phase(String n, String d){
        name = n;
        desc = d;
        PhaseList.add(this);
    }
    
    /**
     * Gets the name of the Phase instance 
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Gets the description of the Phase
     * @return desc
     */
    public String getDesc(){
        return desc;
    }
    
    /**
     * Gets the phase Number of the Phase instance
     * @return phaseNum
     */
    public static int getPhaseNum(){
        return phaseNum;
    }
    
    public static void setPhaseNum(int i){
        phaseNum = i;
    }
    
    /**
     * Increments the phaseFin variable, usually triggered when a Phase has been beaten
     */
    public static void incrementPhaseFin(){
        phaseFin++;
    }
    
    /**
     * Gets the corresponding Location when a Location button in the Phase layout is clicked
     * @param n the number that the image in the Phase layout returns when clicked. Decremented by one to get the actual corresponding Phase in the PhaseList arrayList
     * @return PhaseList.get(n-1)
     */
    public static Phase getPhase(int n){
        return PhaseList.get(n);
    }
}
