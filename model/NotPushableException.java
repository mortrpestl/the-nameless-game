/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

import java.lang.Exception;
/**
 * The NotPushableException catches the exception that triggers when the Protag tries to push a Block that implements Solid into a Block that implements Solid and Immovable.
 * @author Diogn Lei R. Mortera
 */
public class NotPushableException extends Exception {
  public NotPushableException(String msg){
    super(msg);
  }  
}