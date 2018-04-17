package com.stock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.stock.model.ProductBean;

@Repository
public class ProductDao {

	
	  private final JdbcTemplate jdbcTemplate ;
	 private final String SELECT_QUERY = "select productname, price, quantity, categoryname from productlist";
private final String QUERY1 = "select productname, price, quantity,categoryname from productlist where categoryname=?";
private final String sql="insert into productlist values(?,?,?,?)";
//private final String q="update productlist set quantity =( quantity - ?) where productname = ? ";  


	 @Autowired
	 public ProductDao(DriverManagerDataSource dataSource) {
		 this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	 
	 public List<ProductBean> getProductRecord() {
		return  jdbcTemplate.query(SELECT_QUERY,new ProductRowMapper());
	
	 }
		

		public List<ProductBean> getproductbycategoryname( String s) {
		return jdbcTemplate.query(QUERY1, new Object[]{s}, new ProductRowMapper());

		}
		 public int deleteproduct(String s) {
			// ProductBean fb = new ProductBean();
		 String sql1="delete from productlist where productname='"+s+"'";  
		 	return jdbcTemplate.update(sql1);	 
		 }
		 
		 public void totalorder() {
			 String qry ="select sum(price * quantity) as sumup from productlist";
			   jdbcTemplate.update(qry); 

		 }
		 public void addproduct( ProductBean fb) {

			 jdbcTemplate.update(sql, new Object[] {fb.getproductname(), fb.getprice(), fb.getquantity(), fb.getcategoryname()} );

			    }
				
		 public void editproduct( ProductBean fb){  
		
			    String query="update productlist set quantity='"+fb.getquantity()+"', price='"+fb.getprice()+"' where productname='"+fb.getproductname()+"'";  
			  jdbcTemplate.update(query); 
		 }
		 
		 
		 public void productbuy( ProductBean fb) {

			    String query="update productlist set quantity= (quantity - '"+fb.getquantity()+"')  where productname='"+fb.getproductname()+"'";  
			   jdbcTemplate.update(query); 
		 }
		 public void insertorder( String productname,int quantity) {
				String q = "insert into orderplaced values(?,?)";
			 jdbcTemplate.update(q, new Object[] {productname, quantity} );

			    }

			public List<ProductBean> productbuy1(String productname,int quantity) {
				String query="select productname,quantity from orderplaced";  
				//String query="update productlist set quantity= (quantity - "+quantity+")  where productname='"+productname+"'";  
				 //  jdbcTemplate.update(query); 
				return jdbcTemplate.query(query,new ProductMapper());
			}

		 
	 private final class ProductRowMapper implements RowMapper{

	 @Override
	 public ProductBean mapRow(ResultSet rs, int args) throws SQLException {
	 return new ProductBean(rs.getString("productname"), rs.getInt("price") , rs.getInt("quantity"), rs.getString("categoryname"));
	 }
 }

	 private final class ProductMapper implements RowMapper{

		 @Override
		 public ProductBean mapRow(ResultSet rs, int args) throws SQLException {
		 return new ProductBean( rs.getInt("quantity"),rs.getString("productname"));
		 }
	 }


}
