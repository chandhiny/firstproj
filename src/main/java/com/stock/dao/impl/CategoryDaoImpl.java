package com.stock.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.stock.dao.CategoryDao;
import com.stock.model.Category;

//@Repository("categorydaofunctions")
@Named
public class CategoryDaoImpl implements CategoryDao{

	 private final JdbcTemplate jdbcTemplate;
	 private static final String SELECT_QUERY= "select categoryname, categorydescription from category";
	  private static final  String INSERT_QUERY = "insert into category values(?,?)";

	  private static final  String UPDATE_QUERY="update category set categoryname=?, categorydescription=? where categoryname=?";  
	  private static final String DELETE_QRY="delete from category where categoryname=?";  

	 
	// @Autowired
	 @Inject
	 public CategoryDaoImpl(DriverManagerDataSource dataSource) {
		 this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

		public List<Category> showcategory() {
			return  jdbcTemplate.query(SELECT_QUERY,new CategoryRowMapper());
		}
		

	 public void addcategory( Category cb) {

		 jdbcTemplate.update(INSERT_QUERY, new Object[] {cb.getcategoryname(), cb.getcategorydescription()} );

		    }
			
	 public void editcategory(Category cb){  
		   jdbcTemplate.update(UPDATE_QUERY); 
	 }
	 
	 public int deletecategory(Category cb) {
		 
			  return  jdbcTemplate.update(DELETE_QRY);  
		 
	 }
		
		private final class CategoryRowMapper implements RowMapper{

			 @Override
			 public Category mapRow(ResultSet rs1, int args1) throws SQLException {
				return new Category(rs1.getString("categoryname"), rs1.getString("categorydescription"));
				 }
			 
		}

		
		
	
			
		}
