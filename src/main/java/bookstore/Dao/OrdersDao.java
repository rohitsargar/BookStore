
package bookstore.Dao;

import bookstore.entities.Product;
import bookstore.entities.orders;
import bookstore.helper.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDao {
	private Connection con;

	public OrdersDao(Connection con) {
		this.con = con;
	}

	public Boolean save_order(orders order) {
		Boolean f = false;

		try {
			String query = "insert into orders( `user_id`, `user_name`, `user_address`, `product_id`, `product_name`, `product_price`, `product_quantity`, `product_total`, `product_status`) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = this.con.prepareStatement(query);
			pstmt.setInt(1, order.getUser_id());
			System.out.println(order.getUser_name());
			pstmt.setString(2, order.getUser_name());

			pstmt.setString(3, order.getUser_address());
			pstmt.setInt(4, order.getProduct_id());
			pstmt.setString(5, order.getProduct_name());
			pstmt.setString(6, order.getProduct_price());
			pstmt.setString(7, order.getProduct_quantity());
			pstmt.setString(8, order.getProduct_total());
			pstmt.setString(9, order.getProduct_status());
			pstmt.executeUpdate();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();

		}

		return f;
	}

	public ArrayList<orders> getAllUserOders(int userid) {
		ArrayList<orders> myallorders = null;
		try {

			myallorders = new ArrayList<orders>();
			String query = "select * from orders where user_id= " + userid + " order by id desc";
			PreparedStatement pstmt = this.con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				orders userorder = new orders();
				userorder.setId(rs.getInt("id"));
				userorder.setUser_id(rs.getInt("user_id"));
				userorder.setUser_name(rs.getString("user_name"));
				userorder.setProduct_id(rs.getInt("product_id"));
				userorder.setProduct_name(rs.getString("product_name"));
				userorder.setProduct_price(rs.getString("product_price"));
				userorder.setProduct_quantity(rs.getString("product_quantity"));
				userorder.setProduct_total(rs.getString("product_total"));
				userorder.setUser_address(rs.getString("user_address"));
				userorder.setTime(rs.getDate("time"));
				userorder.setProduct_status(rs.getString("product_status"));
				myallorders.add(userorder);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return myallorders;
	}

	public ArrayList<orders> getAdminUserOders() {
		ArrayList<orders> myallorders = null;
		try {

			myallorders = new ArrayList<orders>();
			String query = "select * from orders ";
			PreparedStatement pstmt = this.con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				orders userorder = new orders();
				userorder.setId(rs.getInt("id"));
				userorder.setUser_id(rs.getInt("user_id"));
				userorder.setUser_name(rs.getString("user_name"));
				userorder.setProduct_id(rs.getInt("product_id"));
				userorder.setProduct_name(rs.getString("product_name"));
				userorder.setProduct_price(rs.getString("product_price"));
				userorder.setProduct_quantity(rs.getString("product_quantity"));
				userorder.setProduct_total(rs.getString("product_total"));
				userorder.setUser_address(rs.getString("user_address"));
				userorder.setTime(rs.getDate("time"));
				userorder.setProduct_status(rs.getString("product_status"));
				myallorders.add(userorder);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return myallorders;
	}

	public boolean checkQuanAvl(int proid, int quan) {
		boolean avl = false;

		ProductDao prodao = new ProductDao(ConnectionProvider.getConnection());
		Product pro = prodao.getProductByid(proid);

		if (Integer.parseInt(pro.getProduct_quantity()) >= quan) {
			avl = true;
		}

		return avl;
	}

	public boolean decreaseProQuan(int proid, int quan) {
		boolean dec = false;

		ProductDao prodao = new ProductDao(ConnectionProvider.getConnection());
		Product pro = prodao.getProductByid(proid);

		try {
			String query = "UPDATE `products` SET `pquantity`="+String.valueOf(Integer.parseInt(prodao.getProductByid(proid).getProduct_quantity())-quan)+" WHERE `pid`="+proid;
			PreparedStatement pstmt = this.con.prepareStatement(query);
			//pstmt.setString(1, String.valueOf(Integer.parseInt(prodao.getProductByid(proid).getProduct_quantity())-quan));
		//	pstmt.setInt(2, proid);
		
			pstmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);

		}

		return dec;
	}

}
