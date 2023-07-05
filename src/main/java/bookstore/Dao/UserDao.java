
package bookstore.Dao;

import bookstore.entities.User;
import java.sql.*;


public class UserDao {
    private Connection con;

    public UserDao(Connection con) {
        this.con = con;
    }
    
    //to insert user to database
    
    public boolean saveUser(User user){
         boolean f=false;
        try {
            
          
            String query ="insert into user(name,phone_no,email_adr,password,adr_room_no,adr_floor_no,adr_apt_name,adr,adr_landmark,adr_city,adr_zip_code,user_des,user_profile_pic) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt=this.con.prepareStatement(query);
        
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPhone_no());
            pstmt.setString(3, user.getEmail_adr());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getAdr_room_no());
            pstmt.setString(6, user.getAdr_floor_no());
            pstmt.setString(7, user.getAdr_apt_name());
            pstmt.setString(8, user.getAdr());
            pstmt.setString(9, user.getAdr_landmark());
            pstmt.setString(10, user.getAdr_city());
            pstmt.setInt(11, user.getAdr_zip_code());
            pstmt.setString(12, user.getUser_des());
            pstmt.setString(13, "default.jpg");
            
            
            
           
            
            
            pstmt.executeUpdate();
            
            //save user to cart  at same time
            User getiduser=getUserByEmail(user.getEmail_adr());
            String query2="insert into cart(user_id) values(?)";
            PreparedStatement pstmt2=this.con.prepareStatement(query2);
            pstmt2.setInt(1,getiduser.getUserId() );
            pstmt2.executeUpdate();
            
            
            
            f=true;
               
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
    
    //get user by email
    public User getUserByEmail(String email){
        
        User user=null;
        try {
            String query ="select * from user where email_adr=? ";
            PreparedStatement pstmt=this.con.prepareStatement(query);
            pstmt.setString(1, email);
            
            
            ResultSet rs =pstmt.executeQuery();
            if(rs.next())
            {
                user =new User();
                user.setUserId           (rs.getInt("userid"));
                user.setName             (rs.getString("name"));
                user.setPhone_no         (rs.getString("phone_no"));
                user.setEmail_adr        (rs.getString("email_adr"));
                user.setPassword         (rs.getString("password"));
                user.setAdr_room_no      (rs.getString("adr_room_no"));
                user.setAdr_floor_no     (rs.getString("adr_floor_no"));
                user.setAdr_apt_name     (rs.getString("adr_apt_name"));
                user.setAdr              (rs.getString("adr"));
                user.setAdr_landmark     (rs.getString("adr_landmark"));
                user.setAdr_city         (rs.getString("adr_city"));
                user.setAdr_zip_code     (rs.getInt("adr_zip_code"));
                user.setUser_des         (rs.getString("user_des"));
                user.setUser_profile_pic (rs.getString("user_profile_pic"));
                user.setUser_rdate       (rs.getTimestamp("user_rdate"));
                user.setUser_type        (rs.getString("user_type"));
                
                
            
            }      
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        
        }
    return user;
    }
    
    
    //get user by email and password for login
    
    public User getUserByEmailAndPassword(String email,String password){
        
        User user=null;
        try {
            String query ="select * from user where email_adr=? and password=?";
            PreparedStatement pstmt=this.con.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            
            ResultSet rs =pstmt.executeQuery();
            if(rs.next())
            {
                user =new User();
                user.setUserId           (rs.getInt("userid"));
                user.setName             (rs.getString("name"));
                user.setPhone_no         (rs.getString("phone_no"));
                user.setEmail_adr        (rs.getString("email_adr"));
                user.setPassword         (rs.getString("password"));
                user.setAdr_room_no      (rs.getString("adr_room_no"));
                user.setAdr_floor_no     (rs.getString("adr_floor_no"));
                user.setAdr_apt_name     (rs.getString("adr_apt_name"));
                user.setAdr              (rs.getString("adr"));
                user.setAdr_landmark     (rs.getString("adr_landmark"));
                user.setAdr_city         (rs.getString("adr_city"));
                user.setAdr_zip_code     (rs.getInt("adr_zip_code"));
                user.setUser_des         (rs.getString("user_des"));
                user.setUser_profile_pic (rs.getString("user_profile_pic"));
                user.setUser_rdate       (rs.getTimestamp("user_rdate"));
                user.setUser_type        (rs.getString("user_type"));
                
                
            
            }      
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        
        }
    return user;
    }
    
    public boolean RegisterUserEmailExist(String email){
        boolean f=false;
        try{
        
            String query ="select * from user where email_adr=? ";
            PreparedStatement pstmt=this.con.prepareStatement(query);
            pstmt.setString(1, email);
            
            ResultSet rs =pstmt.executeQuery();
            if(rs.next())
            {
                f=true;
                
            }
            
        }catch(Exception e){
        e.printStackTrace();
        }
        
        
        
    
    
    return f;
    }
    
    //get user by id
    
    public User getUserByid(int userid){
        
        User user=null;
        try {
            String query ="select * from user where userid=? ";
            PreparedStatement pstmt=this.con.prepareStatement(query);
            pstmt.setInt(1, userid);
            
            
            ResultSet rs =pstmt.executeQuery();
            if(rs.next())
            {
                user =new User();
                user.setUserId           (rs.getInt("userid"));
                user.setName             (rs.getString("name"));
                user.setPhone_no         (rs.getString("phone_no"));
                user.setEmail_adr        (rs.getString("email_adr"));
                user.setPassword         (rs.getString("password"));
                user.setAdr_room_no      (rs.getString("adr_room_no"));
                user.setAdr_floor_no     (rs.getString("adr_floor_no"));
                user.setAdr_apt_name     (rs.getString("adr_apt_name"));
                user.setAdr              (rs.getString("adr"));
                user.setAdr_landmark     (rs.getString("adr_landmark"));
                user.setAdr_city         (rs.getString("adr_city"));
                user.setAdr_zip_code     (rs.getInt("adr_zip_code"));
                user.setUser_des         (rs.getString("user_des"));
                user.setUser_profile_pic (rs.getString("user_profile_pic"));
                user.setUser_rdate       (rs.getTimestamp("user_rdate"));
                user.setUser_type        (rs.getString("user_type"));
                
                
            
            }      
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        
        }
    return user;
    }
    
    
    
    
}
