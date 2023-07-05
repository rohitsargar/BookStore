/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Dao;

import bookstore.entities.CartProducts;
import bookstore.entities.Product;
import bookstore.entities.User;
import bookstore.helper.ConnectionProvider;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public class CartDao {
    
    private Connection con;

    public CartDao(Connection con) {
        this.con = con;
    }
    
    public String productaddtocart(int cartid,int proid){
    
        String  f="";
        
        try{

//check product exist in cart or not

        boolean t=productexistincart(cartid,proid);
        System.out.println(t);
        if(t==false){

//         insert product to cart
        String query2="insert into cart_products(cart_id,product_id,product_quantity) values(?,?,?)";
        PreparedStatement pstmt2=this.con.prepareStatement(query2);
        pstmt2.setInt(1,cartid);
        pstmt2.setInt(2,proid);
        pstmt2.setInt(3,1);
        pstmt2.executeUpdate();
        
        f="done";
        }else{
            f="exist";
        
        }
        
        
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
    return f;
    }
    
    public boolean productexistincart(int cartid,int productid){
        
        boolean f=false;
        
        try
        {
            String query ="select * from cart_products where cart_id="+cartid+" && "+"product_id="+productid;
            PreparedStatement pstmt=this.con.prepareStatement(query);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next())
            {
                System.out.println(rs.getString("cart_id"));
                f=true;
                
                
            }
            else
            {
               f=false; 
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    
    
    return f;
    }
    
    public ArrayList<CartProducts> getAllUserCartProducts(int cartid){
        ArrayList<CartProducts> cartproduct=new ArrayList<CartProducts>();
        
        try{
            
            String query ="select * from cart_products where cart_id= "+cartid;
            PreparedStatement pstmt=this.con.prepareStatement(query);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                CartProducts cartpro =new CartProducts();
                cartpro.setId(rs.getInt("id"));
                cartpro.setCart_id(rs.getInt("cart_id"));
                cartpro.setProduct_id(rs.getInt("product_id"));
                cartpro.setProduct_quantity(rs.getInt("product_quantity"));
                cartproduct.add(cartpro);
                
                
                
            
            
            }
            
        
        }catch(Exception e){
        e.printStackTrace();
        }
    
    
    
    
    return cartproduct;
    }
    
    public int getCartIdByUser(User user){
        int cartid=0;
        System.out.print(user.getUserId());
        
        try{
           
            
        //getting cart id
        String query="select * from cart where user_id="+user.getUserId();
        PreparedStatement pstmt=this.con.prepareStatement(query);
        
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
            cartid=rs.getInt("cart_id");
        
        }}catch(Exception e){
                e.printStackTrace();
                
                }
        
        
    
    return cartid;
    }
    public int getUserIdByCartId(int userid){
        int fuserid=0;
        
        
        try{
           
            
        //getting cart id
        String query="select * from cart where cart_id="+userid;
        PreparedStatement pstmt=this.con.prepareStatement(query);
        
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
            fuserid=rs.getInt("user_id");
        
        }}catch(Exception e){
                e.printStackTrace();
                
                }
        
        
    
    return fuserid;
    }
    
    public int gettotalprice(ArrayList<CartProducts> cartpro){
        int total=0;
        for(CartProducts pro:cartpro){
            
            try {
            String query ="select * from products where pid= "+pro.getProduct_id();
            PreparedStatement pstmt=this.con.prepareStatement(query);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                total=total+((Integer.parseInt(rs.getString("pprice")) * pro.getProduct_quantity()));
                
            
            
            }
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
        }
        
        
        
    
    
    return total;
    }
    
    public boolean deleteproductfromcart(int cartproid){
       boolean f=false;
       try{
       String query="delete  from cart_Products where id ="+cartproid;
       PreparedStatement pstmt =this.con.prepareStatement(query);
       pstmt.executeUpdate();
       f=true;
       
       }catch (Exception e){
       e.printStackTrace();
       }
       
       
    
    
    return f;
    }
    
    
    
    
    
    
}
