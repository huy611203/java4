package dao;

import java.util.List;

import model.User;

public interface UserDao {

	User findById(Integer id);

	User findByEmail(String email);

	User findByUserName(String userName);

	User findByUserNameAndPassword(String username, String password);

	List<User> findAll();

	List<User> findAll(int pageNumber, int pageSize);

	User create(User entity);

	User update(User entity);

	User delete(User entity);

}