package com.stock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.stock.model.CategoryBean;

@Repository
public class CategoryDao {

	 private final JdbcTemplate jdbcTemplate;
	 private final String SELECT_QUERY1 = "select categoryname, categorydescription from category";
	  private final  String sql = "insert into category values(?,?)";
	//	 private final String QUERY1 = "select categoryname from category";

	
	 
	 @Autowired
	 public CategoryDao(DriverManagerDataSource dataSource) {
		 this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

		public List<CategoryBean> showcategory() {
			return  jdbcTemplate.query(SELECT_QUERY1,new CategoryRowMapper());
		}
		

	 public void addcategory( CategoryBean cb) {

		 jdbcTemplate.update(sql, new Object[] {cb.getcategoryname(), cb.getcategorydescription()} );

		    }
			
	 public void editcategory(CategoryBean cb){  
		    String query="update category set categoryname='"+cb.getcategoryname()+"', categorydescription='"+cb.getcategorydescription()+"' where categoryname='"+cb.getcategoryname()+"'";  
		   jdbcTemplate.update(query); 
	 }
	 
	 public void deletecategory(CategoryBean cb) {
		 
			    String sql1="delete from category where categoryname='"+cb.getcategoryname()+"'";  
			    jdbcTemplate.update(sql1);  
		 
	 }
		
		private final class CategoryRowMapper implements RowMapper{

			 @Override
			 public CategoryBean mapRow(ResultSet rs1, int args1) throws SQLException {
				//CategoryBean cb = new CategoryBean();
				// cb.setcategoryname(rs1.getString("categoryname"));
				//cb.setcategorydescription(rs1.getString("categorydescription"));
				// return cb;
				return new CategoryBean(rs1.getString("categoryname"), rs1.getString("categorydescription"));
				 }
			 
		}

		
		
	
			
		}
