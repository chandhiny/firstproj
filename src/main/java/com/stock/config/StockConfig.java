package com.stock.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.stock")
public class StockConfig {
	

	

	@Bean
	  public InternalResourceViewResolver viewResolver() {
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/view/");
	    resolver.setSuffix(".jsp");
	    return resolver;
	  }
	

	  @Bean
	public DriverManagerDataSource dataSource(){
	   DriverManagerDataSource ret = new DriverManagerDataSource();
	   ret.setDriverClassName("org.postgresql.Driver");
	   ret.setUsername("postgres");
	   ret.setPassword("Momdad@143");
	   ret.setUrl("jdbc:postgresql://localhost:5432/stock");
	   return ret;
	}
	
/*	  @Bean
	  public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
	      DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
	 
	      return transactionManager;
	  } */
}
