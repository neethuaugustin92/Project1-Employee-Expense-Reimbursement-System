package com.project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;

//import com.example.model.SuperVillain;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.Dao.UsersDao;
import com.project1.model.ERS_USERS;

//@WebServlet("/login")
public class JSONLoginServlet extends HttpServlet {
	
	
	private static Logger log = Logger.getRootLogger();
	
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
			PrintWriter pw = res.getWriter();
			res.setContentType("appllication/json");
		      res.setCharacterEncoding("UTF-8");
			
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
		//System.out.println("inside servlet");
		log.info("inside servlet");
			//ObjectMapper mapper = new ObjectMapper();
		//	System.out.println("after mapper" +mapper);	
			//ERS_USERS u = mapper.readValue(req.getInputStream(), ERS_USERS.class);
			//System.out.println("after u" +u);
		String  us= req.getParameter("username");
		//System.out.println("id "+us);
		String  ps= req.getParameter("password");
		//System.out.println("ps "+ps);
	//	log.info("ps "+ps);
			
		//boolean val= userDao.validateUser(u.getERS_USERNAME(),u.getERS_PASSWORD());
		boolean val= userDao.validateUser(us,ps);
		//System.out.println(val);
		
		  res.setHeader("Cache_Control","no-cache,no-store,must-revalidate");
		
		res.setContentType("text/html");  
		PrintWriter pw=res.getWriter(); 
			if(val)
			{
				//PrintWriter pw = res.getWriter();
			//res.setContentType("appllication/json");
			     // res.setCharacterEncoding("UTF-8");
				
				//ERS_USERS user = userDao.findByUser(u.getERS_USERNAME());
				ERS_USERS user = userDao.findByUser(us);
				//System.out.println(user);
				
				//res.setContentType("text/html");  
				//PrintWriter pw=res.getWriter(); 

				  HttpSession session=req.getSession();  
			        session.setAttribute("Currentuser",user); 
			        
			        res.setHeader("Cache_Control","no-cache,no-store,must-revalidate");
			        
			      //  log.info("Session User "+user);
				
				if (user.getUSER_ROLE_ID()==1)
				{
					//System.out.println("inside if==1:   "+ user.getUSER_ROLE_ID());
					pw.write("Welcome  " +us);
					log.info("SUCCESSFULLY LOGED IN");
					//res.sendRedirect("http://www.google.com"); 
					
					//res.setContentType("appllication/json");
				    // res.setCharacterEncoding("UTF-8");
					
					
			 
					
					  
				//	res.sendRedirect("UserWelcome.html");  
			//req.getRequestDispatcher("html/UserWelcome.html").forward(req, res);
					
					
					
					
			//req.getRequestDispatcher("html/ReimbursementsubmitEmployee.html").include(req, res);
					
			 // this is the new change that i added redirecting to pagewithlayout
			req.getRequestDispatcher("html/pagewithlayout.html").include(req, res);
					  
				pw.close();  
					
					
					
					
					
					
					//res.setContentType("application/json");
					
					
					
					//to turn a java object into a JSON we are going use Jacksons ObjectMapper and conjuction with the PrintWriter
					
					//res.getWriter().write(new ObjectMapper().writeValueAsString(user.getERS_USERNAME()));
					//req.getRequestDispatcher("html/UserWelcome.html").forward(req, res);
					
					
				}
				else if (user.getUSER_ROLE_ID()==2)
				{
				//	System.out.println("inside of  if==2:  userrole id is displayed "+ user.getUSER_ROLE_ID());
					
					
					pw.write("Welcome Admin/Manager " +us);
					
					//res.sendRedirect("http://www.google.com"); 
					
					//res.setContentType("appllication/json");
				    // res.setCharacterEncoding("UTF-8");
					
					
			 
					
					  
				//	res.sendRedirect("UserWelcome.html");  
			//req.getRequestDispatcher("html/UserWelcome.html").forward(req, res);
					
					
					
					
			//req.getRequestDispatcher("html/ReimbursementsubmitEmployee.html").include(req, res);
					
			 // this is the new change that i added redirecting to pagewithlayout
			req.getRequestDispatcher("html/ManagerWelcome.html").include(req, res);
					  
				//pw.close();  
					
					
					
					
					
					
					//res.setContentType("application/json");
					
					
					
					//to turn a java object into a JSON we are going use Jacksons ObjectMapper and conjuction with the PrintWriter
					
					//res.getWriter().write(new ObjectMapper().writeValueAsString(user.getERS_USERNAME()));
					//req.getRequestDispatcher("html/UserWelcome.html").forward(req, res);
					
					
					
					
					
				}
				else 
					pw.write("invalid,username or password error please try again!");
				log.info("Errorr login due to bad username password,please try again");
				//req.getRequestDispatcher("html/login2.html").include(req, res);
				
				//pw.close();  
			}
			
			
			else {
				
				//pw.write("invalid,username or password error please try again!");
				//req.getRequestDispatcher("html/login2.html").include(req, res);
				
				
				//pw.print("Sorry change UserName or Password Error!");  
			       // RequestDispatcher rd=req.getRequestDispatcher("html/login2.html");  
			      //  rd.include(req, res);  
				
				//req.getRequestDispatcher("html/login2.html").include(req, res);
				
				//req.getRequestDispatcher("/Project1/html/login2.html").forward(req, res);
				//req.getRequestDispatcher("/Project1/html/login2.html").include(req, res);
				
				//System.out.println("Errorr login due to bad username password,please try again");
				log.info("Errorr login due to bad username password,please try again");
				res.sendRedirect("/Project1/html/login2.html");
				
			}
			pw.close();  
	
	}
}
