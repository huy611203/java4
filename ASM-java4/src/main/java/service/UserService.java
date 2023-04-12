package service;

import java.util.List;

import model.User;

public interface UserService {
	User findById(Integer id);

	User findByEmail(String email);

	User findByUserName(String userName);

	User login(String username, String password);

	User resetPassWord(String email);
	
	List<User> findAll();

	List<User> findAll(int pageNumber, int pageSize);

	User create(String username,String password,String email);

	User update(User entity);

	User delete(String username);
	
	
}
