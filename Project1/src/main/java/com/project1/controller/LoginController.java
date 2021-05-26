package com.project1.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.example.dao.SuperVillainDaoImpl;
//import com.example.model.SuperVillain;
//import com.example.service.VillainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.Dao.UsersDao;
import com.project1.model.ERS_USERS;
import com.project1.service.LoginService;

public class LoginController {

	
//static VillainService villServ = new VillainService(new SuperVillainDaoImpl());
	static LoginService logserv = new LoginService(new UsersDao());
	
	public static String login(HttpServletRequest req) {
		
		
		System.out.println("in login controller login");
		System.out.println(req.getMethod());
		/*
		
		if(!req.getMethod().equals("POST")) {
			System.out.println("Inside the if loop ");
			return "html/UserWelcome.html";
		}
		*/
		//SuperVillain vill = villServ.getVillainVerify(req.getParameter("villainName"), req.getParameter("villainPower"));
		System.out.println("username."+req.getParameter("username")+".");
		System.out.println("password."+req.getParameter("password")+".");
		ERS_USERS user = logserv.getUserVerify(req.getParameter("username"), req.getParameter("password") );
		System.out.println("-------------------");	
	System.out.println(user);	
		if(user== null) {
			return "wrongcreds.change";
		}else {
			req.getSession().setAttribute("currentVill", user);
			//res.getWriter().write(new ObjectMapper().writeValueAsString(user));
			System.out.println("Inside the else loop ");
			return "html/UserWelcome.html";
		}
		

		//if(user== null) {
			//return "userdosentexistintherecords"; // to be corrceted 
		//}else {
		//	req.getSession().setAttribute("currentuser", user);
		//	return "html/UserWelcome.html";
		//}
	}
	/*
	public static void getSessionVill(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		SuperVillain vill = (SuperVillain)req.getSession().getAttribute("currentVill");
		res.getWriter().write(new ObjectMapper().writeValueAsString(vill));
	}*/
	
	public static void getSessionUser(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		ERS_USERS user = (ERS_USERS)req.getSession().getAttribute("currentvill");
		res.getWriter().write(new ObjectMapper().writeValueAsString(user));
	}

	public static String login(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException 
	{
		// TODO Auto-generated method stub
		
		    System.out.println("in login controller login");
			System.out.println(req.getMethod());
			/*
			
			if(!req.getMethod().equals("POST")) {
				System.out.println("Inside the if loop ");
				return "html/UserWelcome.html";
			}
			*/
			//SuperVillain vill = villServ.getVillainVerify(req.getParameter("villainName"), req.getParameter("villainPower"));
			System.out.println("username."+req.getParameter("username")+".");
			System.out.println("password."+req.getParameter("password")+".");
			ERS_USERS user = logserv.getUserVerify(req.getParameter("username"), req.getParameter("password") );
			System.out.println("-------------------");	
		System.out.println(user);	
			if(user== null) {
				return "wrongcreds.change";
			}else {
				req.getSession().setAttribute("currentVill", user);
				//res.getWriter().write(new ObjectMapper().writeValueAsString(user));
				System.out.println("Inside the else loop ");
				return "html/UserWelcome.html";
			}
	
	}
	
}

