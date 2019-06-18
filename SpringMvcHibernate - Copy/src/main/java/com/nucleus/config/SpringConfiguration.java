package com.nucleus.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.nucleus.dao.LoginDao;
import com.nucleus.dao.LoginDaoInterface;
import com.nucleus.dto.CustomerDto;
import com.nucleus.dto.UserDto;


@EnableWebMvc
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:datasource-cfg.properties")
@ComponentScan(basePackages="com.nucleus")
public class SpringConfiguration extends WebMvcConfigurerAdapter {
	
	  @Autowired
	  private Environment env;
	  
	@Autowired LoginDaoInterface userDaoI;
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/Resources/**").addResourceLocations("/Resources/");
	}
	
	
	@Bean
    public DataSource oracleDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
        dataSource.setUrl(env.getProperty("ds.url"));
        dataSource.setUsername(env.getProperty("ds.username"));
        dataSource.setPassword(env.getProperty("ds.password"));
 
        return dataSource;
    }
	
	/*@Bean(name= "template")
	public JdbcTemplate jdbcTemplate(){
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(oracleDataSource());
		return template;
		
	}*/
	
	 // Transaction Manager
	  @Autowired
	  @Bean(name = "transactionManager")
	  public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
	      DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
	 
	      return transactionManager;
	  }
	  
	  @Bean(name="sessionFactory")
		public SessionFactory getSessionFactory() {
			Properties hibernate=new Properties();
			hibernate.put("hibernate.dialect",env.getProperty("hibernate.dialect"));
			hibernate.setProperty("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));
			hibernate.setProperty("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
			LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(oracleDataSource());
			localSessionFactoryBuilder.addProperties(hibernate);
			localSessionFactoryBuilder.addAnnotatedClass(CustomerDto.class);
			localSessionFactoryBuilder.addAnnotatedClass(UserDto.class);
			//localSessionFactoryBuilder.addAnnotatedClass(User.class);
			SessionFactory sessionFactory=localSessionFactoryBuilder.buildSessionFactory();
			
			
			return sessionFactory;
			
		}
	  
	  



}