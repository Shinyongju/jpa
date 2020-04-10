package com.kimschool.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired
	DataSource ds;
	
	@RequestMapping("login")
	public ModelAndView login() throws ClassNotFoundException, SQLException { 
		

		
		Connection conn;
		PreparedStatement ps = null;
		// �������� ����Ʈ�� ���� �� ����
		ResultSet rs;
		
		conn = ds.getConnection();
		
//		String url = "jdbc:mysql://localhost:3306/pre_management";
//		String id = "root";
//		String password = "";
//		Class.forName("com.mysql.jdbc.Driver");
		
		// DB����
//		conn = DriverManager.getConnection(url, id, password);
		
		System.out.println(conn);
		
		// SQL����
		String sql = "select now()";
		
		ps = conn.prepareStatement(sql);
		
		// SQL����
		// ����� ts�ݳ�
		rs = ps.executeQuery();
		
		// rs�κ��� ��氪 ���
		while (rs.next()) {
			// rs�κ��� �ð��� ���
			String time = rs.getString("now()");
			// ��氪 ���
			System.out.println(time);
		}
		
		// ���1
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		// ���2
//		ModelAndView mv = new ModelAndView("login");
		
		return mv;
	}

}
