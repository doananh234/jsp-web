package services;

import shopdemo.User;

public interface IUser {
	public User login(String user, String pass);
	public String logout();
	public boolean create(User user);
}
