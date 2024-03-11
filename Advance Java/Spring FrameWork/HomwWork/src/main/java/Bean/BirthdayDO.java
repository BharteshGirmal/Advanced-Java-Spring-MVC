package Bean;

public class BirthdayDO {
	private int id;
	private String fname, sname, dob;

	public BirthdayDO() {
		System.out.println("BirthdayDo Constructor ...");
	}

	public BirthdayDO(String fname, String sname, String dob) {
		super();
		this.fname = fname;
		this.sname = sname;
		this.dob = dob;
	}

	public BirthdayDO(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}


	@Override
	public String toString() {
		return "  "+ id;
	}

	
	/*
	 * @Override public String toString() { return "+fname+ " "+ sname + "  / " +
	 * dob ; }
	 */


}
