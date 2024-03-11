package Study;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value = "/ProductLifeCycle", loadOnStartup = -1)
// for Eagar Initialize

public class ProductLifeCycle extends HttpServlet {
	@Override
	public void init() throws ServletException
	{
		System.out.println("Init Method Called");
		super.init();
	}
	
    public ProductLifeCycle()
    {
    	System.out.println("Constructor of ProductLifeCycle");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	System.out.println("DoGet Method of ProductLifeCycle");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
    	System.out.println("DoPost Method of ProductLifeCycle");

	}

}
