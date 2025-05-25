/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

import java.lang.Exception;

/**
 *The FullHealthException catches the exception that triggers when the Protag tries to use a Healltem with full health.
 * @author Diogn Lei R. Mortera
 */
public class FullHealthException extends Exception {
  public FullHealthException(String msg){
    super(msg);
  }  
}
