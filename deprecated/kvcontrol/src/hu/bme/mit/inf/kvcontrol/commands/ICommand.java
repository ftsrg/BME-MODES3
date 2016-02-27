/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bme.mit.inf.kvcontrol.commands;


/**
 *
 * @author zsoltmazlo
 */
public interface ICommand {
    
    public static final String COMMAND_TAG = "command";
    public static final String RESULT_TAG = "result";
    
    public String jsonify();
    
}
