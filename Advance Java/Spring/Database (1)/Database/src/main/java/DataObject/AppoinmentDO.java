package DataObject;

public class AppoinmentDO 
{
	private String  Uname ,Date ,Purpose ,Reason,Time;
	public AppoinmentDO()
	{
		
	}
	
	public AppoinmentDO(String uname, String date, String purpose, String reason, String time) 
	{
		super();
		Uname = uname;
		Date = date;
		Purpose = purpose;
		Reason = reason;
		Time = time;
	}
	
	@Override
	public String toString()
	{
		String str="UserName: "+Uname+"  Date : "+Date+"  Pupose : "+Purpose+"  Reason : "+Reason+"  Time: "+Time;
		str+="\n_____________________________________________________________________________________";
		return str;
	}

	public String getUname() {
		return Uname;
	}

	public void setUname(String uname) {
		Uname = uname;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getPurpose() {
		return Purpose;
	}

	public void setPurpose(String purpose) {
		Purpose = purpose;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}
	
}
