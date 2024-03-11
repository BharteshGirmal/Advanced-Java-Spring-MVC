package HW2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class UserEntity
{
	@Id
	@Column
	private String username;
	@Column
	private String password;
	
	public UserEntity() {
		// TODO Auto-generated constructor stub
	}

	public UserEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() 
	{
		return "User Name : "+username+"\nPassword : "+password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
