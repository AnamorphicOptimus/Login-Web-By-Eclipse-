package cn.edu.uibe.domain;

public class User {
	private String userName;
	private String password;
	private long id;
	private String email;
	public String getUserName() {
		System.out.println("��ȡ�û���:"+userName);
		return userName;
	}
	public void setUserName(String userName) {
		System.out.println("�����û���:"+userName);
		this.userName = userName;
	}
	public String getPassword() {
		System.out.println("��ȡ����:"+password);
		return password;
	}
	public void setPassword(String password) {
		System.out.println("��������:"+password);
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
