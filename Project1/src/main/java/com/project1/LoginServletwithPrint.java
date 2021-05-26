package com.project1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.Dao.UsersDao;
import com.project1.model.ERS_USERS;

@WebServlet("/login")
public class LoginServletwithPrint extends HttpServlet {
	UsersDao userDao =new UsersDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		//JSONDispatcherServlet.process(req, res);
	System.out.println("inside servlet");	
		//ObjectMapper mapper = new ObjectMapper();
	//	System.out.println("after mapper" +mapper);	
		//ERS_USERS u = mapper.readValue(req.getInputStream(), ERS_USERS.class);
		//System.out.println("after u" +u);
	String  us= req.getParameter("username");
	System.out.println("id "+us);
	String  ps= req.getParameter("password");
	System.out.println("ps "+ps);
		
	//boolean val= userDao.validateUser(u.getERS_USERNAME(),u.getERS_PASSWORD());
	boolean val= userDao.validateUser(us,ps);
	System.out.println(val);
		if(val)
		{
			
			res.setContentType("appllication/json");
		      res.setCharacterEncoding("UTF-8");
			PrintWriter pw = res.getWriter();
			
			
			//ERS_USERS user = userDao.findByUser(u.getERS_USERNAME());
			ERS_USERS user = userDao.findByUser(us);
			System.out.println(user);
			
			if (user.getUSER_ROLE_ID()==1)
			{
				System.out.println(user.getUSER_ROLE_ID());
				pw.write("Employee");
				
			}
			else if (user.getUSER_ROLE_ID()==2)
			{
				pw.write("Manager");
			}
			else 
				pw.write("invalid");
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		//JSONDispatcherServlet.process(req, res);
		//JSONDispatcherServlet.process(req, res);
		System.out.println("inside servlet dopost");	
			//ObjectMapper mapper = new ObjectMapper();
		//	System.out.println("after mapper" +mapper);	
			//ERS_USERS u = mapper.readValue(req.getInputStream(), ERS_USERS.class);
			//System.out.println("after u" +u);
		String  us= req.getParameter("username");
		System.out.println("id "+us);
		String  ps= req.getParameter("password");
		System.out.println("ps "+ps);
			
		//boolean val= userDao.validateUser(u.getERS_USERNAME(),u.getERS_PASSWORD());
		boolean val= userDao.validateUser(us,ps);
		System.out.println(val);
			if(val)
			{
				res.setContentType("text/html");
				PrintWriter pw = res.getWriter();
			
			     // res.setCharacterEncoding("UTF-8");
				
				//ERS_USERS user = userDao.findByUser(u.getERS_USERNAME());
				ERS_USERS user = userDao.findByUser(us);
				System.out.println(user);
				
				if (user.getUSER_ROLE_ID()==1)
				{
					System.out.println(user.getUSER_ROLE_ID());
					pw.write("Employee");
					
				}
				else if (user.getUSER_ROLE_ID()==2)
				{
					pw.write("Manager");
				}
				else 
					pw.write("invalid");
				
			}
	}
}
