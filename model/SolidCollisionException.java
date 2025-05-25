/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

import java.lang.Exception;

/**
 * The SolidCollisionException catches the exception that triggers when a GameObject that implements Solid collides with another GameObject that implements Solid.
 *
 * @author Diogn Lei R. Mortera
 */
public class SolidCollisionException extends Exception {
  public SolidCollisionException(String msg){
    super(msg);
  }  
}
