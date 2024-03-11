package study.jparest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User1")
public class UserEntity
{
	@Id
	@Column
	private String uname;
	
	@Column
	private String password;
	
	public UserEntity()
	{
		
	}

	public UserEntity(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserEntity [uname=" + uname + ", password=" + password + "]";
	}

}













