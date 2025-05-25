/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

/**
 * The LockedDoorException catches the exception that triggers when the Protag tries to toggle a Door in a locked state.
 * 
 * @author Diogn Lei R. Mortera
 */
public class LockedDoorException extends Exception {
  public LockedDoorException(String msg){
    super(msg);
  }  
}