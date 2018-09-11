/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import business.User;
import java.util.HashMap;

/**
 *
 * @author USER
 */
public interface DataAccess {
    public boolean Insert(Object obj);
    public boolean Delete(Object obj);
    public boolean Update(Object obj);
    public Object GetRecord(Object obj);
    
}
