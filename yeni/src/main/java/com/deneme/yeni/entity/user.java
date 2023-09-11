/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deneme.yeni.entity;

/**
 *
 * @author Serdar
 */
public class user {
    
        private int iduser;
        private String username;
        private String userpass;
    
        
        public int getiduser() {
            return iduser;
        }
        public void setiduser(int iduser) {
            this.iduser = iduser;
        }
        
        public String getusername() {
            return username;
        }
        public void setusername(String username) {
            this.username = username;
        }
        
        public String getuserpass() {
            return userpass;
        }
        public void setuserpass(String userpass) {
            this.userpass = userpass;
        }
}
