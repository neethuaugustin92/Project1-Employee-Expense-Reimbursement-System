package com.project1;

import java.io.IOException;
import java.io.PrintWriter;
//import java.security.Timestamp;
import java.sql.Timestamp;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;

//import com.example.model.SuperVillain;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.Dao.ReimbursementDaoImp;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.Dao.UsersDao;
import com.project1.model.ERS_REIMBURSEMENT;
import com.project1.model.ERS_USERS;

//@WebServlet("/login")
public class ReimbursementSubmitServletold extends HttpServlet {
	UsersDao userDao =new UsersDao();
	ReimbursementDaoImp reimDao =new ReimbursementDaoImp();
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
		System.out.println("inside Reimbursement servlet");	
			//ObjectMapper mapper = new ObjectMapper();
		//	System.out.println("after mapper" +mapper);	
			//ERS_USERS u = mapper.readValue(req.getInputStream(), ERS_USERS.class);
			//System.out.println("after u" +u);
		//double  Amount= Double.parseDouble(req.getParameter("Amount"));
		int Amt = Integer.parseInt(req.getParameter("Amount"));
		System.out.println("Amount "+Amt);
	
		//Timestamp  resolveddate= req.getParameter("resolveddate");
		//Timestamp  resolveddate = "2016-06-22 19:10:25-07" ;
		
		 java.util.Date javaDate = new java.util.Date();
	      long javaTime = javaDate.getTime();
		
		Timestamp resolveddate = new Timestamp(javaTime);
		
		System.out.println("resolveddate "+resolveddate);
		
		Timestamp submiteddate = new Timestamp(javaTime);
		//String  submiteddate= req.getParameter("submiteddate");
		System.out.println("submiteddate "+submiteddate);
		
		
		String  Description= req.getParameter("Description");
		System.out.println("Description"+Description);
		

		String  Recipt= req.getParameter("Recipt");
		System.out.println("Recipt "+Recipt);
		

		String  Author= req.getParameter("Author");
		System.out.println("ps "+Author);
		
	//	ERS_REIMBURSEMENT entity = new ERS_REIMBURSEMENT(Amount,resolveddate,submiteddate,Description,1,1,1,1);
		
		ERS_REIMBURSEMENT entity = new ERS_REIMBURSEMENT(Amt,resolveddate,submiteddate,Description,1,1,1,1);
		
		
		System.out.println(entity);
		System.out.println(entity.getREIMB_AMOUNT());
		//reimDao.insert(entity);
		reimDao.save(entity);
		
		//reimDao.insert(Amount,resolveddate,submiteddate,Description,1,1,1,1,1);
		
		
			
		//boolean val= userDao.validateUser(u.getERS_USERNAME(),u.getERS_PASSWORD());
		
		//reimDao.insert(null);
		boolean val= userDao.validateUser("neethu","neethu");
		System.out.println(val);
			if(val)
			{
				//PrintWriter pw = res.getWriter();
			//res.setContentType("appllication/json");
			     // res.setCharacterEncoding("UTF-8");
				
				//ERS_USERS user = userDao.findByUser(u.getERS_USERNAME());
				ERS_USERS user = userDao.findByUser("neethu");
				System.out.println(user);
				
			 res.setContentType("text/html");  
			 	PrintWriter pw=res.getWriter(); 
				
				
				
				//ObjectMapper mapper =new ObjectMapper();
				
				//String response = mapper.writeValueAsString(user);
				//res.setContentType("appllication/json"); 
				

				  HttpSession session=req.getSession();  
			        session.setAttribute("username","neethu");  
				
				if (user.getUSER_ROLE_ID()==1)
				{
					System.out.println("inside if==1:   "+ user.getUSER_ROLE_ID());
					pw.write("Employee Name " +"neethu");
					
					//res.sendRedirect("http://www.google.com"); 
					
					//res.setContentType("appllication/json");
				    // res.setCharacterEncoding("UTF-8");
					
					
			 
					
					  
				//	res.sendRedirect("UserWelcome.html");  
			//req.getRequestDispatcher("html/UserWelcome.html").forward(req, res);
					//System.out.println("Value of res"+ res);
				//	System.out.println("Value of response "+ response);
					//PrintWriter pw=res.getWriter();
					//pw.write(response);		
					
			req.getRequestDispatcher("html/UserWelcome.html").include(req, res);
					  
				pw.close();  
					
					
					
					
					
					
					//res.setContentType("application/json");
					
					
					
					//to turn a java object into a JSON we are going use Jacksons ObjectMapper and conjuction with the PrintWriter
					
					//res.getWriter().write(new ObjectMapper().writeValueAsString(user.getERS_USERNAME()));
					//req.getRequestDispatcher("html/UserWelcome.html").forward(req, res);
					
					
				}
				else if (user.getUSER_ROLE_ID()==2)
				{
					System.out.println("inside if==2:   "+ user.getUSER_ROLE_ID());
					//pw.write("Employee");
					
					//res.sendRedirect("http://www.google.com"); 
					
					
					
					//res.setContentType("text/html");  
					//PrintWriter pw=res.getWriter();  
					
					  
				//	res.sendRedirect("UserWelcome.html");  
					//req.getRequestDispatcher("html/UserWelcome.html").forward(req, res);
					req.getRequestDispatcher("html/UserWelcome.html").include(req, res);
					pw.close();  
					
				}
				else 
					pw.write("invalid,username or password error please try again!");
				req.getRequestDispatcher("html/unsuccessfullogin.html").include(req, res);
				
				pw.close();  
			}
	}
}
