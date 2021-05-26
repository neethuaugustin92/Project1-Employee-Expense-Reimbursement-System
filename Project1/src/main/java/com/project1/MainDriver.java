package com.project1;

import org.apache.log4j.Logger;

import com.project1.Dao.UsersDao;
import com.project1.model.ERS_USERS;

public class MainDriver {
	
	private static Logger log = Logger.getRootLogger();

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
	
		
		UsersDao usD =new UsersDao();
		//ERS_USERS user = new ERS_USERS("augustin","sssso","susu","susu","susus",1);
		ERS_USERS user = new ERS_USERS("admin","admin","admin","admin","admin",2);
		log.info(user);
		
		log.info("this is from Logger");
		
		usD.insert(user);
	}

}
