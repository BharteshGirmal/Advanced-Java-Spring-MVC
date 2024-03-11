package JavaConfig;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class Config
{
	@Bean
	public JdbcTemplate GetTemplate()
	{
		JdbcTemplate obj= new JdbcTemplate();
		obj.setDataSource(GetDS()); // Injected
		return obj;
	}
	
	@Bean
	public DataSource GetDS()
	{
		DriverManagerDataSource obj = new DriverManagerDataSource();
		obj.setDriverClassName("com.mysql.cj.jdbc.Driver");
		obj.setUrl("jdbc:mysql://localhost:3306/db1");
		obj.setUsername("root");
		obj.setPassword("Bhartesh@1008");
		return obj;
	}
}
