/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.entities;

/**
 *
 * @author Admin
 */
public class CartProducts {
    private int id;
    private int cart_id;
    private int product_id;
    private int product_quantity;

    public CartProducts() {
    }
    
    

    public CartProducts(int cart_id, int product_id, int product_quantity) {
        this.cart_id = cart_id;
        this.product_id = product_id;
        this.product_quantity = product_quantity;
    }

    public CartProducts(int id, int cart_id, int product_id, int product_quantity) {
        this.id = id;
        this.cart_id = cart_id;
        this.product_id = product_id;
        this.product_quantity = product_quantity;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }
    
    
    
    
}
