package com.stock.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.stock.dao.ProductDao;
import com.stock.model.Product;

//@Repository("productdaofunctions")
@Named("product functions")
public class ProductDaoImpl implements ProductDao{

	private final JdbcTemplate jdbcTemplate ;
	
private static final String SELECT_QUERY = "select productname, price, quantity, categoryname from productlist";
private static final String SELECT_QUERY_CATEG_NAME = "select productname, price, quantity,categoryname from productlist where categoryname=?";
private static final String INSERT_QUERY="insert into productlist values(?,?,?,?)";
private static final String BUY_UPDATE_QRY="update productlist set quantity =( quantity - ?) where productname = ? ";  
private static final String DELETE_QUERY="delete from productlist where productname=?";  
private static final String EDIT_QUERY="update productlist set quantity=?, price=? where productname=?";  


	 @Inject
	 public ProductDaoImpl(DriverManagerDataSource dataSource) {
		 this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	 
	 public List<Product> getProductRecord() {
		return  jdbcTemplate.query(SELECT_QUERY,new ProductRowMapper());
	
	 }
		

	public List<Product> getproductbycategoryname( String s) {
		return jdbcTemplate.query(SELECT_QUERY_CATEG_NAME, new Object[]{s}, new ProductRowMapper());

	}
		
	public String deleteproduct(String s) {
	
		int op= jdbcTemplate.update(DELETE_QUERY,new Object[]{s});	
		if(op!=0) {
		 	return "the product that is deleted is="+s;}
		else {
			return "the prod is not available";
		}
	}
		 
	
		
	public void addproduct( Product fb) {

		jdbcTemplate.update(INSERT_QUERY, new Object[] {fb.getproductname(), fb.getprice(), fb.getquantity(), fb.getcategoryname()} );
			
			
	}
				
	public Product editproduct( Product fb) {  
		int val = jdbcTemplate.update(EDIT_QUERY, new Object[] { fb.getquantity(),fb.getprice(),fb.getproductname()}); 
			if (val!=0) {
				return fb;
			}else {
				return null;
			}
	}
		 
		 
	public Product productbuy( Product fb) {
int result = jdbcTemplate.update(BUY_UPDATE_QRY,new Object[] {fb.getquantity(),fb.getproductname()}); 
if( result != 0) {
			   return fb;}
else {
	return null;
}
	}
		
		 
private final class ProductRowMapper implements RowMapper{

	 @Override
	 public Product mapRow(ResultSet rs, int args) throws SQLException {
	 return new Product(rs.getString("productname"), rs.getInt("price") , rs.getInt("quantity"), rs.getString("categoryname"));
	 }
}

	

}
