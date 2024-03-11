package OneToOneRelation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserProfile
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//auto Increment Column 
	private int profileId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;
	
	@OneToOne
	private User user;
	
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	
	public UserProfile() {
		// TODO Auto-generated constructor stub
	}

	public UserProfile(int profileId, String firstName, String lastName, String email) {
		super();
		this.profileId = profileId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
