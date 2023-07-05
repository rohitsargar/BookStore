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
public class Product {
   private String product_id;
   private String product_title;
   private String product_price;
   private String product_image;
   private String product_discount;
   private String product_quantity ;
   private String product_description;

    public Product() {
    }
   
   
    

    public Product(String product_title, String product_price, String product_image, String product_discount, String product_quantity, String product_description) {
        this.product_title = product_title;
        this.product_price = product_price;
        this.product_image = product_image;
        this.product_discount = product_discount;
        this.product_quantity = product_quantity;
        this.product_description = product_description;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
    
    

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public String getProduct_discount() {
        return product_discount;
    }

    public void setProduct_discount(String product_discount) {
        this.product_discount = product_discount;
    }

    public String getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(String product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }
   
   
   
    
}
