/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

import java.lang.Exception;
/**
 * The CantExitException catches the exception that triggers when a Protag tries to exit out of a Location but is not allowed to
 * 
 * @author Diogn Lei R. Mortera
 */
public class CantExitException extends Exception {
  public CantExitException(String msg){
    super(msg);
  }  
}
