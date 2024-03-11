package Q2;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration // to identify that it is a java configuration 
public class MyjavaConfig 
{
	@Bean
	public JdbcTemplate Gettemplate()
	{
		JdbcTemplate obj=new JdbcTemplate();
		obj.setDataSource(getDS());
		return obj;
	}
	
	@Bean
	public DataSource getDS()
	{
		DriverManagerDataSource dm=new DriverManagerDataSource();
		dm.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dm.setUrl("jdbc:mysql://localhost:3306/lab");
		dm.setUsername("root");
		dm.setPassword("Bhartesh@1008");
		return dm;
	}
}
