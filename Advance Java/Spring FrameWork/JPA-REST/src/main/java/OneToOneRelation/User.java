package OneToOneRelation;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user2")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userid;
	@Column
	private String user_name;
	@Column
	private String password;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserProfile profile;
	
	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}
	
	public UserProfile getProfile() {
		return profile;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String user_name, String password) {
		super();
		this.userid = id;
		this.user_name = user_name;
		this.password = password;
	}

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
