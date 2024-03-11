package DBConnection.InSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Beans.DAOBean;
import Beans.DAOJdbcTemplate;
import JavaConfig.Config;

public class DatabaseInSpringApplication {

	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		context.scan("Beans","JavaConfig");
		//context.refresh();
		//DAOBean bean= context.getBean(DAOBean.class);
		//bean.Insert(54, "Linux Laptop", 1245);
		DAOJdbcTemplate bean2 =context.getBean(DAOJdbcTemplate.class);
		bean2.Insert(121, "Earphones", 1659);
	}

}
