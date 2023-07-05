/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.entities;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class orders {
    
        
    private int    id                  ;         
    private int    user_id             ;               
    private String user_name           ;          
    private String user_address        ;               
    private int    product_id          ;            
    private String product_name        ;             
    private String product_price       ;            
    private String product_quantity    ;             
    private String product_total       ;               
    private String product_status      ;                  
    private Date   time                ;   

    public orders() {
    }

    
    public orders(int user_id, String user_name, String user_address, int product_id, String product_name, String product_price, String product_quantity, String product_total, String product_status) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_address = user_address;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
        this.product_total = product_total;
        this.product_status = product_status;
    }
    
    

    public orders(int user_id, String user_name, String user_address, int product_id, String product_name, String product_price, String product_quantity, String product_total, String product_status, Date time) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_address = user_address;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
        this.product_total = product_total;
        this.product_status = product_status;
        this.time = time;
    }

    public orders(int id, int user_id, String user_name, String user_address, int product_id, String product_name, String product_price, String product_quantity, String product_total, String product_status, Date time) {
        this.id = id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_address = user_address;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
        this.product_total = product_total;
        this.product_status = product_status;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(String product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getProduct_total() {
        return product_total;
    }

    public void setProduct_total(String product_total) {
        this.product_total = product_total;
    }

    public String getProduct_status() {
        return product_status;
    }

    public void setProduct_status(String product_status) {
        this.product_status = product_status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
    
    
    
    
    
}
