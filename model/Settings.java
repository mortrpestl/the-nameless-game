/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

/**
 * The Settings class manages changes in the global scale such as difficulty changes and phaseText changes which affect multiple classes.
 * @author Diogn Lei R. Mortera
 */
public class Settings {
    static int difficulty = 2;
    static int phaseText = 0;
    private static String pauseOrigin, optionsOrigin;
    
    /**
     * Sets the difficulty of the game.
     * @param d the difficulty of the game
     * @param p the instance of Protag
     */
    public static void setDifficulty(int d, Protag p){
        switch(d){
            
            case 1:
            //set difficulty to Easy
            difficulty = 1;
            //make corresponding changes to Protag and Chara attributes
            p.setMaxHP(125);
            p.changeAtk(10);
            p.changeDef(10);
            
            for(NPC npc : NPC.NPCList){
                npc.setMaxHP(75);
                if(npc.getHP() > npc.getMaxHP()){
                    npc.changeHP(npc.getMaxHP() - npc.getHP());
                }
                npc.changeAtk(-10);
                npc.changeDef(-10);
            }
            p.updateHPBar();
            break;
            
            case 2:
            //set difficulty to Normal
            difficulty = 2;
            //make corresponding changes to Protag and Chara attributes
            p.setMaxHP(100);
            
            for(NPC npc : NPC.NPCList){
                if(npc.getHP() > npc.getMaxHP()){
                    npc.changeHP(npc.getMaxHP() - npc.getHP());
                }
                npc.setMaxHP(100);
            }
            p.updateHPBar();
            break;
            
            case 3:
            //set difficulty to Hard
            difficulty = 3;
            //make corresponding changes to Protag and Chara attributes
            p.setMaxHP(75);
            p.changeAtk(-10);
            p.changeDef(-10);
            
            for(NPC npc : NPC.NPCList){
                npc.setMaxHP(125);
                
                if(npc.getHP() > npc.getMaxHP()){
                    npc.changeHP(npc.getMaxHP() - npc.getHP());
                }
                
                npc.changeAtk(10);
                npc.changeDef(10);
            }
            p.updateHPBar();
            break;
        }
    }
    
    /**
     * Changes the simplicity/complexity of the text style.
     * @param pT the number that will determine the phase of the dialogue
     */
    public static void setPhaseText(int pT){
        phaseText = pT;
    }
    
    /**
     * Gets the phase text
     * @return phaseText
     */
    public static int getPhaseText(){
        return phaseText;
    }
    
    public static String getPauseOrigin(){
        return pauseOrigin;
    }
    
    public static String getOptionsOrigin(){
        return optionsOrigin;
    }
    
    public static void setPauseOrigin(String s){
        pauseOrigin = s;
    }
    
    public static void setOptionsOrigin(String s){
        optionsOrigin = s;
    }
}
