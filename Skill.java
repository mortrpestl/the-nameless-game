public class Skill {
  private String type;
  private int level;
  private String[] abilities; //array size 6 [5]

  public Skill(String t, int l, String[] a){
    type = t;
    level = l;
    abilities = a;
  }

  public int getLevel(){
    return level;
  }

  public String getType(){
    return type;
  }
  
  public String[] getAbilities(){
    return abilities;
  }
  
  public void levelUp(){
    level++;
  }

  
}