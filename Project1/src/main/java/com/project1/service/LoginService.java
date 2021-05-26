package com.project1.service;

//import com.example.model.SuperVillain;
import com.project1.Dao.UsersDao;
import com.project1.model.ERS_USERS;
public class LoginService {

	private UsersDao userdao;
	
	public LoginService( UsersDao userdao)
	{
		super();
		this.userdao =userdao;
	}
	
	public ERS_USERS getUserVerify(String username, String userpassword) {
		
	/*	ERS_USERS un = userdao.getByName(username);
		 if(un != null) {
			 if(un.getERS_PASSWORD().equals(userpassword)) {
				 return un;
			 }
		 }
		
		return null;
	}*/
		
		if (userdao.validateUser(username, userpassword))
		{
			System.out.println("inside if checking ++"+userdao.validateUser(username, userpassword));
			ERS_USERS un = userdao.findByUser(username);
			
			return un;
		}
		
		else return null;
	}
}
