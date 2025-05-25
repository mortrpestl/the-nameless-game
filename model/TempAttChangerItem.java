/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

import java.util.ArrayList;
/**
 * TempAttChangerItems are a specific type of AttChangerItem that can have a temporary effect on the protagonist.
 * @author Diogn Lei R. Mortera
 */
public class TempAttChangerItem extends AttChangerItem {
  private int duration;
  static private ArrayList<TempAttChangerItem> ActiveTACIs = new ArrayList<>();
  static private ArrayList<TempAttChangerItem> WillBePassiveTACIs = new ArrayList<>();
  
  /**
   * A TempAttChangerItem inherits the properties of an AttChangerItems, as well as having a duration variable to determine when the effect will wear off.
   *  @param n the name of the TempAttChangerItem
   * @param tS the filename of the texture of the TempAttChangerItem
   * @param d the description of the TempAttChangerItem
   * @param t the type of the TempAttChangerItem
   * @param v the the amount/value the TempAttChangerItem affects the attribute
   * @param du the number of turns in a battle before the effect of the TempAttChangerItem wears off
   */
  public TempAttChangerItem(String n, String tS, String d, String t, int v, int du){
    super(n, tS, d, t, v);
    duration = du;
  }

  /**
   * Gets the duration of turns in a battle before the effect of the TempAttChangerItem wears off
   * @return duration
   */
  public int getDuration(){
    return duration;
  }
  
  /**
   * Changes the attribute of the protagonist the TempAttChangerItem type pertains to by the amount/value the AttChangerItem affects the attribute, for a certain duration.
   */
  public void changeProtagAtt(Protag p){
      //utilize ArrayList to store the active TempAttChangerItems
      //every turn, theres gonna be a decrement on the turns of each TempAttChangerItem
      for(TempAttChangerItem aTACI : TempAttChangerItem.ActiveTACIs){
          ((AttChangerItem) aTACI).changeProtagAtt(p);
          ActiveTACIs.remove(aTACI);
          WillBePassiveTACIs.add(aTACI);
      }
      for(TempAttChangerItem wbpTACI : TempAttChangerItem.WillBePassiveTACIs){
          wbpTACI.duration--;
          //when a turn for one of the items turns 0, reverse engineer its effects
          if(wbpTACI.getDuration() == 0){
              ((AttChangerItem) wbpTACI).revertProtagAtt(p);
              WillBePassiveTACIs.remove((AttChangerItem) wbpTACI);
          }
      }
  }
}