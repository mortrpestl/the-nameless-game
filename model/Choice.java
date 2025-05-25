/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

/**
 * A Choice can be picked by the protagonist in a Scenario of the story (the Scenario displays Choices) and lead to different Events that may or may have an effect on the story.
 * @author Diogn Lei R. Mortera
 */
public class Choice {
    private String response;
    private Event event;
    
    /**
     * A Choice has a name that will be displayed in the view of the Within-Location when a Scenario is triggered. When triggered, a Choice will trigger a corresponding Event.
     * @param r the response of the Choice
     * @param e the Event played when the Choice is picked
     */
    public Choice(String r, Event e){
        response = r;
        event = e;
    }
    
    /**
     * Gets the response associated with the Choice
     * @return response
     */
    public String getResponse(){
        return response;
    }
    
    
    /**
     * Gets the Event associated with the Choice
     * @return event
     */
    public Event getEvent(){
        return event;
    }
}
