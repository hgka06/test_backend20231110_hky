package com.hk.board.command;


public class UpdateUserCommand {


	private String name;	

	private String num;
 
    private String password;

	public UpdateUserCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateUserCommand(String name, String num, String password) {
		super();
		this.name = name;
		this.num = num;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UpdateUserCommand [name=" + name + ", num=" + num + ", password=" + password + "]";
	}
		
		
		
}
