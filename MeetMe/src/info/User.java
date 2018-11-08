package info;

abstract public class User {	
	protected String username;
	protected String password;
	protected int permission;
	
	public User() {
		username = "";
		password = "";
		permission = 1;
	}	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		permission = 1;//customer permission
	}	
}
