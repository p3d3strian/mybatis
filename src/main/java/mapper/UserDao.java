package dao;

import java.util.List;

import entity.User;

public interface UserDao {
	List<User> findUser();
	int insertUser(User user);
}
