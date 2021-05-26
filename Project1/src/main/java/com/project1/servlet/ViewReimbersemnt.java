package com.project1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.ers.model.Reimbursement;
//import com.ers.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.Dao.ReimbursementDaoImp;
import com.project1.Dao.UsersDao;
import com.project1.model.ERS_REIMBURSEMENT;
import com.project1.model.ERS_USERS;

/**
 * Servlet implementation class ViewReimbersemnt
 */
@WebServlet("/ViewReimbersemnt")
public class ViewReimbersemnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewReimbersemnt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	
		
		
		
		ReimbursementDaoImp rDao =new ReimbursementDaoImp();
		
		HttpSession session = request.getSession();
		ERS_USERS u = (ERS_USERS) session.getAttribute("Currentuser");
		System.out.println("userid from currentsession "+u.getERS_USERS_ID());
		System.out.println("in newReim get method");
		//load reimbursements into json file
		//List<ERS_REIMBURSEMENT> reim = rDao.findReims(u.getUserId());
		List<ERS_REIMBURSEMENT> reim = rDao.getAllByIdForEmployee(u.getERS_USERS_ID());
		for(ERS_REIMBURSEMENT r : reim)
		{
			System.out.println(r);
		}
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reim);
		
		//log.trace("All Reimbursements: " + json);

		PrintWriter writer = response.getWriter();
		response.setHeader("Cache_Control","no-cache,no-store,must-revalidate");// session clearance should be in every page 
		response.setContentType("application/json");
		writer.write(json);

	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
