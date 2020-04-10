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
		// 복수개의 리스트를 담을 수 있음
		ResultSet rs;
		
		conn = ds.getConnection();
		
//		String url = "jdbc:mysql://localhost:3306/pre_management";
//		String id = "root";
//		String password = "";
//		Class.forName("com.mysql.jdbc.Driver");
		
		// DB접속
//		conn = DriverManager.getConnection(url, id, password);
		
		System.out.println(conn);
		
		// SQL생성
		String sql = "select now()";
		
		ps = conn.prepareStatement(sql);
		
		// SQL실행
		// 결과값 ts격납
		rs = ps.executeQuery();
		
		// rs로부터 취득값 출력
		while (rs.next()) {
			// rs로부터 시간값 취득
			String time = rs.getString("now()");
			// 취득값 출력
			System.out.println(time);
		}
		
		// 방법1
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		// 방법2
//		ModelAndView mv = new ModelAndView("login");
		
		return mv;
	}

}
