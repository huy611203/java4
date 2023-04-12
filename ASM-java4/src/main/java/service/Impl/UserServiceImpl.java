package service.Impl;

import java.util.List;

import dao.UserDao;
import dao.iplm.UserDaoImpl;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService{
     private UserDao dao;
     public UserServiceImpl() {
    	 dao = new UserDaoImpl();
     }
	@Override
	public User findById(Integer id) {
		
		return dao.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public User findByUserName(String userName) {
		return dao.findByUserName(userName);
	}

	@Override
	public User login(String username, String password) {
		return dao.findByUserNameAndPassword(username, password);
	}

	@Override
	public User resetPassWord(String email) {
		return null;
	}

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public User create(String username, String password, String email) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setIsAdmin(Boolean.FALSE);
		user.setIsActive(Boolean.TRUE);
		return dao.create(user);
	}

	@Override
	public User update(User entity) {
		return dao.update(entity);
	}

	@Override
	public User delete(String username) {
		User user = dao.findByUserName(username);
		user.setIsActive(Boolean.FALSE);
		return dao.update(user);
	}

}
