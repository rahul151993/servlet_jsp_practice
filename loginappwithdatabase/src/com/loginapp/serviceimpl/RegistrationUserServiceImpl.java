package com.loginapp.serviceimpl;

import com.loginapp.dao.RegisterUserDao;
import com.loginapp.model.User;
import com.loginapp.service.RegisterUserService;

public class RegistrationUserServiceImpl implements RegisterUserService{

	@Override
	public boolean addUser(User user) {
		RegisterUserDao dao = new RegisterUserDao();
		return dao.addUser(user);
	}

}
