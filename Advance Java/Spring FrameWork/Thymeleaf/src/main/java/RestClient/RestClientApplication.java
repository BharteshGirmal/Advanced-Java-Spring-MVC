package RestClient;

import org.springframework.web.client.RestTemplate;

public class RestClientApplication
{
	public static void main(String[] args) {
		
		RestTemplate rs=new RestTemplate();
		String url="http://localhost:8080/primary/hello";
		String value=rs.getForObject(url, String.class);
		System.out.println("The rest API : "+value);
		
		url="http://localhost:8080/primary/postit";
		String resp=rs.getForObject(url, null, String.class);
		System.out.println("The rest API : "+resp);
	}

}
