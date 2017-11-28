package me.arsen.misc.simplefreeze;

public enum Permissions {
	
	ADMIN("simplefreeze.admin");
	
	public String name;
	
	private Permissions(String name)
	{
		this.name = name;
	}
}
