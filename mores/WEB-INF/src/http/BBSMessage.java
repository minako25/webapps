package http;

public class BBSMessage{

	private String user;
	private String message;
	//p254 —ûK–â‘è
	private String ipAddr;
	private String userAgent;

	public BBSMessage(){

	}

	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getUser(){
		return user;
	}

	public void setUser(String user){
		this.user = user;
	}

	public String getIpAddr(){
		return ipAddr;
	}

	public void setIpAddr(String ipAddr){
		this.ipAddr = ipAddr;
	}

	public String getUserAgent(){
		return userAgent;
	}

	public void setUserAgent(String userAgent){
		this.userAgent = userAgent;
	}
}
