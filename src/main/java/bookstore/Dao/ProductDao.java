/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Dao;

import bookstore.entities.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ProductDao {
    
    private Connection con;

    public ProductDao(Connection con) {
        this.con = con;
    }
    
    public boolean saveProduct(Product products  ){
    boolean f=false;
    
    try {
        String  query ="insert into products(ptitle,pdesc,pphoto,pprice,pdiscount,pquantity) values(?,?,?,?,?,?)" ;
        PreparedStatement pstmt=this.con.prepareStatement(query);
       
        pstmt.setString( 1, products.getProduct_title()       ); 
        pstmt.setString( 2, products.getProduct_description()  );
        pstmt.setString( 3, products.getProduct_image()      );
        pstmt.setString(  4, products.getProduct_price()      );
        pstmt.setString(  5, products.getProduct_discount()    );
        pstmt.setString(  6, products.getProduct_quantity()     );
        
        pstmt.executeUpdate();
        
        
        
        
        f=true;
     
    }catch(Exception e){e.printStackTrace();}
    
    return f;
    }
    public ArrayList<Product> getAllProducts(){
        ArrayList<Product> pro=null;
        
        try {
        
        pro = new ArrayList<Product>();
        String query ="select * from products";
        PreparedStatement pstmt=this.con.prepareStatement(query);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            
            Product newpro =new Product();
            newpro.setProduct_id(rs.getString("pid"));
            newpro.setProduct_title(rs.getString("ptitle"));
            newpro.setProduct_price(rs.getString("pprice"));
            newpro.setProduct_image(rs.getString("pphoto"));
            newpro.setProduct_discount(rs.getString("pdiscount"));
            newpro.setProduct_quantity(rs.getString("pquantity"));
            newpro.setProduct_description(rs.getString("pdesc"));
            pro.add(newpro);
        
        
        
        
        }
        
        
        
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    
    
    return pro;
    }
    
    
    public Product getProductByid(int proid){
        Product pro=new Product();
        
        try {
        
        
        String query ="select * from products where pid="+proid;
        
        PreparedStatement pstmt=this.con.prepareStatement(query);
        
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            System.out.print(rs.getString("pprice"));
           
           
            pro.setProduct_id(rs.getString("pid"));
            pro.setProduct_title(rs.getString("ptitle"));
            pro.setProduct_price(rs.getString("pprice"));
            pro.setProduct_image(rs.getString("pphoto"));
            pro.setProduct_discount(rs.getString("pdiscount"));
            pro.setProduct_quantity(rs.getString("pquantity"));
            pro.setProduct_description(rs.getString("pdesc"));
           
        
        
        
        
        }
        
        
        
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    
    
    return pro;
    }
    
    
}
