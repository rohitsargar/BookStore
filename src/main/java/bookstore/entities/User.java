/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.entities;

import java.sql.Timestamp;

public class User {
    private int         userId              ;          
    private String      name                ;                 
    private String         phone_no            ;              
    private String      email_adr           ;                 
    private String      password            ;                 
    private String      adr_room_no         ;               
    private String      adr_floor_no        ;                
    private String      adr_apt_name        ;                  
    private String      adr                 ;                        
    private String      adr_landmark        ;                 
    private String      adr_city            ;                      
    private int         adr_zip_code        ;               
    private String      user_des            ;                   
    private String      user_profile_pic    ;                
    private Timestamp   user_rdate          ; 
    private String      user_type           ;
    private String      cart_id             ;
    
    //constructors
    
    //constructor with userId

    public User(int userId, String name, String phone_no, String email_adr, String password, String adr_room_no, String adr_floor_no, String adr_apt_name, String adr, String adr_landmark, String adr_city, int adr_zip_code, String user_des, String user_profile_pic, Timestamp user_rdate ,String user_type) {
        this.userId = userId;
        this.name = name;
        this.phone_no = phone_no;
        this.email_adr = email_adr;
        this.password = password;
        this.adr_room_no = adr_room_no;
        this.adr_floor_no = adr_floor_no;
        this.adr_apt_name = adr_apt_name;
        this.adr = adr;
        this.adr_landmark = adr_landmark;
        this.adr_city = adr_city;
        this.adr_zip_code = adr_zip_code;
        this.user_des = user_des;
        this.user_profile_pic = user_profile_pic;
        this.user_rdate = user_rdate;
        this.user_type=user_type;
    }
    
    
    //constructor without userId

    public User(String name, String phone_no, String email_adr, String password, String adr_room_no, String adr_floor_no, String adr_apt_name, String adr, String adr_landmark, String adr_city, int adr_zip_code, String user_des) {
        this.name = name;
        this.phone_no = phone_no;
        this.email_adr = email_adr;
        this.password = password;
        this.adr_room_no = adr_room_no;
        this.adr_floor_no = adr_floor_no;
        this.adr_apt_name = adr_apt_name;
        this.adr = adr;
        this.adr_landmark = adr_landmark;
        this.adr_city = adr_city;
        this.adr_zip_code = adr_zip_code;
        this.user_des = user_des;
        
    }
    
    //default empty constructor 

    public User() {
    }
    
    
    //getters and setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail_adr() {
        return email_adr;
    }

    public void setEmail_adr(String email_adr) {
        this.email_adr = email_adr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdr_room_no() {
        return adr_room_no;
    }

    public void setAdr_room_no(String adr_room_no) {
        this.adr_room_no = adr_room_no;
    }

    public String getAdr_floor_no() {
        return adr_floor_no;
    }

    public void setAdr_floor_no(String adr_floor_no) {
        this.adr_floor_no = adr_floor_no;
    }

    public String getAdr_apt_name() {
        return adr_apt_name;
    }

    public void setAdr_apt_name(String adr_apt_name) {
        this.adr_apt_name = adr_apt_name;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getAdr_landmark() {
        return adr_landmark;
    }

    public void setAdr_landmark(String adr_landmark) {
        this.adr_landmark = adr_landmark;
    }

    public String getAdr_city() {
        return adr_city;
    }

    public void setAdr_city(String adr_city) {
        this.adr_city = adr_city;
    }

    public int getAdr_zip_code() {
        return adr_zip_code;
    }

    public void setAdr_zip_code(int adr_zip_code) {
        this.adr_zip_code = adr_zip_code;
    }

    public String getUser_des() {
        return user_des;
    }

    public void setUser_des(String user_des) {
        this.user_des = user_des;
    }

    public String getUser_profile_pic() {
        return user_profile_pic;
    }

    public void setUser_profile_pic(String user_profile_pic) {
        this.user_profile_pic = user_profile_pic;
    }

    public Timestamp getUser_rdate() {
        return user_rdate;
    }

    public void setUser_rdate(Timestamp user_rdate) {
        this.user_rdate = user_rdate;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
    
}
