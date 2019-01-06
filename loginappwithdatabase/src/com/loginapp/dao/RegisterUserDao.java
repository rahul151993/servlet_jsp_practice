package com.loginapp.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.context.listener.MyContextListener;
import com.loginapp.model.User;

public class RegisterUserDao {
	public boolean addUser(User user) {
		boolean status = false;
		if(MyContextListener.con!=null) {
			try {
				String sql = "INSERT INTO login(id,name,password) VALUES(?,?,?)";
				PreparedStatement pt=MyContextListener.con.prepareStatement(sql);
				pt.setInt(1, 0);
				pt.setString(2,user.getUserName());
				pt.setString(3,user.getPassword());
				int row = pt.executeUpdate();
				if(row>0)
					status=true;
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}
}
