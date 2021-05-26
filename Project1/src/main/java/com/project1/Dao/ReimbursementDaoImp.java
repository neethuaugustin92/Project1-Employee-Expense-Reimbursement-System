package com.project1.Dao;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.project1.model.ERS_REIMBURSEMENT;
import com.project1.model.ERS_USERS;

public class ReimbursementDaoImp implements GenericDao<ERS_REIMBURSEMENT> 
{
	private DbConnection dbCon;
	
	public ReimbursementDaoImp()
	{
		dbCon = new DbConnection();
	}

	@Override
	public List<ERS_REIMBURSEMENT> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public List<ERS_REIMBURSEMENT> getAllByIdForEmployee(int id ) {
		
		List<ERS_REIMBURSEMENT> reims  = new ArrayList<ERS_REIMBURSEMENT>();
		
	
		try(Connection con =  dbCon.getDbConnection()){
			System.out.println("inside  Dao try ");
			
			System.out.println("inside id value " +id);
			
			String sql = "select * from ERS_REIMBURSEMEN where reimb_author =? "; 
			PreparedStatement  cs = con.prepareStatement(sql);
			cs.setInt(1, id);
			ResultSet rs = cs.executeQuery();
			
			while(rs.next()) {
				ERS_REIMBURSEMENT r =new ERS_REIMBURSEMENT();
				
				//ERS_REIMBURSEMENT r = new Reimbursement();
				r.setREIMB_ID(rs.getInt(1));

				r.setREIMB_AMOUNT(rs.getInt(2));
				r.setREIMB_SUBMITTED(rs.getTimestamp(3));
				r.setREIMB_RESOLVED(rs.getTimestamp(4));
				r.setREIMB_DESCRIPTION(rs.getString(5));
				r.setREIMB_AUTHOR(rs.getInt(6));
				r.setEIMB_RESOLVER(rs.getInt(7));
				r.setREIMB_STATUS_ID(rs.getInt(8));
				r.setREIMB_TYPE_ID(rs.getInt(9));
				reims.add(r);

				
				
			}
			
			
			
			/*
			for(String color: entity.getColorList()) { //this is because I messed up in my app creation, I could fix junction table, or have a model for color and fix my models
				if(color.equals("White")) {
					insertJunction(entity.getName(),1);
				}else if(color.equals("Blue")){
					insertJunction(entity.getName(), 2);
				}else if(color.equals("Black")) {
					insertJunction(entity.getName(), 3);
				}else if(color.equals("Red")) {
					insertJunction(entity.getName(), 4);
				}else if(color.equals("Green")) {
					insertJunction(entity.getName(), 5);
				}else {
					insertJunction(entity.getName(), 6);
				}
			}*/
			
		} catch (SQLException e) {
			
			System.out.println("inside  catch1 ");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			System.out.println("inside  catch2 ");
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		// TODO Auto-generated method stub
		System.out.println("the returned reimbb"+reims);
		return  reims;
	}
	
	

	@Override
	public ERS_REIMBURSEMENT getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ERS_REIMBURSEMENT entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(ERS_REIMBURSEMENT entity) {
		
		
		
		System.out.println("inside  reins Dao");
		
		System.out.println("Enity value"+entity);
		
		try(Connection con =  dbCon.getDbConnection()){
			System.out.println("inside  Dao try ");
			
			String sql = "{? = call ERS_REIMBURSEMENT_INSERT(?,?,?,?,?,?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setDouble(2, entity.getREIMB_AMOUNT());
			cs.setTimestamp(3, entity.getREIMB_SUBMITTED());
			cs.setTimestamp(4, entity.getREIMB_RESOLVED());
			cs.setString(5, entity.getREIMB_DESCRIPTION());
		//	cs.setBlob(6, entity.getREIMB_RECEIPT());
			cs.setInt(7, entity.getREIMB_AUTHOR());//its an id field author id 
			cs.setInt(8, entity.getEIMB_RESOLVER());
			cs.setInt(9, entity.getREIMB_STATUS_ID());
			cs.setInt(10, entity.getREIMB_TYPE_ID());
			cs.execute();
			System.out.println("result from insert "+cs.getString(1));
			
			/*
			for(String color: entity.getColorList()) { //this is because I messed up in my app creation, I could fix junction table, or have a model for color and fix my models
				if(color.equals("White")) {
					insertJunction(entity.getName(),1);
				}else if(color.equals("Blue")){
					insertJunction(entity.getName(), 2);
				}else if(color.equals("Black")) {
					insertJunction(entity.getName(), 3);
				}else if(color.equals("Red")) {
					insertJunction(entity.getName(), 4);
				}else if(color.equals("Green")) {
					insertJunction(entity.getName(), 5);
				}else {
					insertJunction(entity.getName(), 6);
				}
			}*/
			
		} catch (SQLException e) {
			
			System.out.println("inside  catch1 ");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			System.out.println("inside  catch2 ");
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	

	public void insert(double Amount,Timestamp resolveddate, Timestamp submiteddate,String Description,int a,int b,int c,int d,int f) {
		
		//System.out.println("Enity value"+entity);
		
		System.out.println("inside  reins Dao");
		
		try(Connection con =  dbCon.getDbConnection()){
			String sql = "{? = call ERS_REIMBURSEMENT_INSERT(?,?,?,?,?,?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setDouble(2, Amount);
			cs.setTimestamp(3,resolveddate);
			cs.setTimestamp(4, submiteddate);
			cs.setString(5, Description);
			//cs.setBlob(6, );
			cs.setInt(7, a);//its an id field author id 
			cs.setInt(8, b);
			cs.setInt(9, c);
			cs.setInt(10, d);
			cs.execute();
			System.out.println(cs.getString(1));
			
			/*
			for(String color: entity.getColorList()) { //this is because I messed up in my app creation, I could fix junction table, or have a model for color and fix my models
				if(color.equals("White")) {
					insertJunction(entity.getName(),1);
				}else if(color.equals("Blue")){
					insertJunction(entity.getName(), 2);
				}else if(color.equals("Black")) {
					insertJunction(entity.getName(), 3);
				}else if(color.equals("Red")) {
					insertJunction(entity.getName(), 4);
				}else if(color.equals("Green")) {
					insertJunction(entity.getName(), 5);
				}else {
					insertJunction(entity.getName(), 6);
				}
			}*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void delete(ERS_REIMBURSEMENT entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ERS_REIMBURSEMENT queryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	public ERS_REIMBURSEMENT save(ERS_REIMBURSEMENT obj) { // TODO Auto-generated methodstub
		// TODO Auto-generated method stub
System.out.println("Inside remim save dao");
System.out.println(obj);
		try {
			Connection con = dbCon.getDbConnection();
			String SQL = "{? = call INSERT_ERS_REIMBURSEMEN(?,?,?,?,?,?,?)}";
			String[] keyNames = { "reimb_id" };
			CallableStatement cs = con.prepareCall(SQL);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, obj.getREIMB_AMOUNT());
			cs.setString(3, obj.getREIMB_DESCRIPTION());
			cs.setInt(4, obj.getREIMB_AUTHOR());
			cs.setInt(5, obj.getEIMB_RESOLVER());
			cs.setInt(6, obj.getREIMB_STATUS_ID());
			cs.setInt(7, obj.getREIMB_TYPE_ID());
			cs.setString(8, obj.getREIMB_RECEIPT());
			cs.execute();
			//obj.getREIMB_STATUS_ID(cs.getInt(1));
			//obj.getREIMB_STATUS_ID(cs.getInt(1));
			//log.info(obj);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		//catch (IOException e) {
			//e.printStackTrace();
		//}
		// TODO Auto-generated catch block e.printStackTrace(); }
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	/*
	
	public ERS_REIMBURSEMENT find(String usr)  {
		
		ERS_REIMBURSEMENT ers = null;
			
			try {
				Connection con = dbCon.getDbConnection();
				
				String sql = "SELECT * FROM ERS_REIMBURSEMEN  ?";
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,  usr);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					ers.getREIMB_DESCRIPTION()
					
					user = new ERS_USERS();
					user.setERS_USERS_ID(rs.getInt(1));
					user.setERS_USERNAME(usr);
					user.setERS_PASSWORD(rs.getString(3));
					user.setUSER_FIRST_NAME(rs.getString(4));
					user.setUSER_LAST_NAME(rs.getString(5));	
					user.setUSER_EMAIL(rs.getString(6));
					user.setUSER_ROLE_ID(rs.getInt(7));
					
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			return user;
		}
		
*/
	
	
	
	
}

/*

try(Connection con =  dbCon.getDbConnection()){
	System.out.println("inside  Dao try ");
	
	String sql = "{? = call ERS_REIMBURSEMENT_INSERT(?,?,?,?,?,?,?,?,?)}";
	CallableStatement cs = con.prepareCall(sql);
	
	cs.registerOutParameter(1, Types.VARCHAR);
	cs.setDouble(2, entity.getREIMB_AMOUNT());
	cs.setTimestamp(3, entity.getREIMB_SUBMITTED());
	cs.setTimestamp(4, entity.getREIMB_RESOLVED());
	cs.setString(5, entity.getREIMB_DESCRIPTION());
	cs.setBlob(6, entity.getREIMB_RECEIPT());
	cs.setInt(7, entity.getREIMB_AUTHOR());//its an id field author id 
	cs.setInt(8, entity.getEIMB_RESOLVER());
	cs.setInt(9, entity.getREIMB_STATUS_ID());
	cs.setInt(10, entity.getREIMB_TYPE_ID());
	cs.execute();

*/