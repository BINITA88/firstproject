/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.myConnection;
import model.*;
import view.*;
import java.sql.*;

/**
 *
 * @author asism
 */
public class recoverController {
    
    recoverModel model;
    loginrecoverModel logmodel;
    recoverView view;
    loginrecoverView logview;
    ResultSet rs;
    Statement stmt;
    
    public recoverController(recoverView view)
    {
        this.view=view;
        new RecoveryListener().actionPerformed();
        
    }
        
        class RecoveryListener{
            public void actionPerformed(){
                
                try{
//                    model=view.getUser();
                    view.setMessage("Recovery Controller Test OK!");
                    Connection conn = myConnection.myDatabase();
                    String sql="select * from users";
                    stmt=conn.createStatement();
                    rs=stmt.executeQuery(sql);
                    if (rs.next()){
                        String uname = rs.getString(1);
                        String pass = rs.getString(2);
                        String re_pass = rs.getString(3);
                        String email = rs.getString(4);
                        String sec_ans = rs.getString(5);
                        
                        System.out.println("Username::"+uname);
                        System.out.println("Password::"+pass);
                        System.out.println("Verified Password::"+re_pass);
                        System.out.println("Email::"+email);
                        System.out.println("Security Question:: What is your mother's maiden name?");
                        System.out.println("Security Answer::"+sec_ans);
                        
                    }
                    conn.close();
                }
                    
                
                catch (Exception e1){
                    System.out.println(e1.getMessage());

                }
                
                
            }
          
            }
        }
        
    
    
    
    

