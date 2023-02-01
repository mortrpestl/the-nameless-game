public class Scenario extends Event {
  private String[] displayText;
  private Choice[] choices;
  
  public Scenario(String n, String[] dc, Choice[] c){
    super(n);
    displayText = dc;
    choices = c;
  }

  public void display(){
    
  }
  
  public void presentChoices(){
    
  }
}