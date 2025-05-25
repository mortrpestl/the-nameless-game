/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * An Event is something that plays when a Choice is made. It consists of a character and his dialogue.
 * @author Diogn Lei R. Mortera
 */
public class Event {
    protected String name;
    protected Settings settings;
    protected int dialogueIncrement;
    protected ArrayList<String> DialogueFileList = new ArrayList<String>();
    protected ArrayList<String> ContentList;
    protected ArrayList<ArrayList<String>> DialogueContentList;
    protected ArrayList<ArrayList<ArrayList<String>>> DialogueFileContentList = new ArrayList<>();
    protected static int eventNum = 0;
    
    public static ArrayList<Event> EventList = new ArrayList<Event>();
    
    /**
     * An Event has a name, a corresponding character (who the dialogue belongs to), and a dialogue list of the lines the character says in the Event
     * @param n the name of the Event
     * @param DF0 the file for the lines the character in the Event says (in phase-0 phase text version)
     * @param DF1 the file for the lines the character in the Event says (in phase-1 phase text version)
     * @param DF2 the file for the lines the character in the Event says (in phase-2 phase text version)
     * @param DF3 the file for the lines the character in the Event says (in phase-3 phase text version)
     */
    public Event(String n, String DF0, String DF1, String DF2, String DF3){
        name = n;
        DialogueFileList.add(DF0);
        DialogueFileList.add(DF1);
        DialogueFileList.add(DF2);
        DialogueFileList.add(DF3);
        dialogueIncrement = 0;
        
        for(String df : DialogueFileList){
            try{
                DialogueContentList = new ArrayList<>();
                FileReader fr = new FileReader(new File(df));
                BufferedReader reader = new BufferedReader(fr);
                
                String line;
                while((line = reader.readLine())!=null){
                    String info[] = line.split(",");
                    ContentList = new ArrayList<>();
                    
                    for(int i = 0; i < 4; i++){
                        ContentList.add(info[i]);
                    }
                    DialogueContentList.add(ContentList);
                }
                DialogueFileContentList.add(DialogueContentList);

            } catch (FileNotFoundException f){

            } catch (IOException io){
                
            } catch (NullPointerException npe){
                
            }
        }
        
    }
    
    /**
     * Gets the name of the Event for future reference
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Displays the sequence of dialogues in the Event
     */
    public void play(){
        int pT = settings.getPhaseText();
        /*for(int DLi = 0; DLi < DialogueMasterList.get(pT).length; DLi++){
            //integrate to view
            System.out.print(DialogueMasterList.get(pT)[DLi]);
        }*/ //modify this for filename
    }
    
    /**
     * Gets the dialogue file for the Event at a specified phase.
     * @param i
     * @return DF0, DF1, DF2, DF3
     */
    public String getDialogueFile(int i){
        return DialogueFileList.get(i);
    }
    
    /**
     * Gets the String for the Dialogue File Content List of the Event instance.
     * @return DialogueFileContentList
     */
    public ArrayList<ArrayList<ArrayList<String>>> getDialogueFileContentList(){
        return DialogueFileContentList;
    }
    
    /**
     * Increments the dialogue increment by 1 of the Event instance.
     */
    public void incrementDialogue(){
        dialogueIncrement++;
    }
    
    /**
     * Gets the dialogue increment of the Event instance.
     * @return dialogueIncrement
     */
    public int getDialogueIncrement(){
        return dialogueIncrement;
    }
    
    /**
     * Gets the event number.
     * @return eventNum
     */
    public static int getEventNum(){
        return eventNum;
    }
    
    /**
     * Sets the event number, given a number.
     * @param i number to set the event number to
     */
    public static void setEventNum(int i){
        eventNum = i;
    }
    
    /**
     * Adds the Event to the EventList
     */
    public void addToEventList(){
        EventList.add(this);
    }
    
    /**
     * Gets the Event List.
     * @return EventList
     */
    public static ArrayList<Event> getEventList(){
        return EventList;
    }
}
