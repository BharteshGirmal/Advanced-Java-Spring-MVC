package Config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JavaConfig 
{

	@Bean
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate obj = new JdbcTemplate();
		obj.setDataSource(getDS());
		return obj;
	}

	@Bean
	public DataSource getDS()
	{
		DriverManagerDataSource  obj = new DriverManagerDataSource();
		obj.setDriverClassName("com.mysql.cj.jdbc.Driver");
		obj.setUrl("jdbc:mysql://localhost:3306/db4");
		obj.setUsername("root");
		obj.setPassword("rootpooja@19");
		
		return obj;
	}
}
