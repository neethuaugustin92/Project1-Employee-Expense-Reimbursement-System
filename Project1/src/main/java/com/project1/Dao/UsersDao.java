package com.project1.Dao;


//import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
//import java.util.ArrayList;
import java.util.List;


import com.project1.model.ERS_USERS;

public class UsersDao implements GenericDao<ERS_USERS>{
	private DbConnection dbCon;
	
	public UsersDao()
	{
		dbCon = new DbConnection();
	}
	
	
	@Override
	public List<ERS_USERS> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
/*
	@Override
	public ERS_USERS getByName(String name) {
		// TODO Auto-generated method stub
		
		try(Connection con =  dbCon.getDbConnection()){
		//	String sql = "select * from creature_card c left outer join creature_junction_color cjc on c.name = cjc.c_name left outer join color co on cjc.color_id = co.id\r\n"
			//		+ "		where c.name=?";
			
			String sql = "select * from ERS_USERS c "
						+ "		where c.ERS_USERNAME=?";	
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			//CreatureCard card = new CreatureCard();
		//	List<String> colorList = new ArrayList<>();
			while(rs.next()) {
				//card = new CreatureCard(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), null);
				//colorList.add(rs.getString(9));
				
			}
			//card.setColorList(colorList);
			//return card;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	*/
	
	
	public boolean validateUser(String uname, String pwd) {
		// TODO Auto-generated method stub

		//System.out.println("inside validate user");
		String SQL = "select * from ERS_USERS where ERS_USERNAME = ?  and ERS_PASSWORD =?";
		ERS_USERS user = new ERS_USERS();
		// no record false
		try {
			Connection con =  dbCon.getDbConnection();
			// Connection con = ConnectionUtil.getConnection();
			Statement st = con.createStatement();
			// ResultSet rs = st.executeQuery( "SELECT * FROM bankuser;" );
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, uname);
			pstmt.setString(2, pwd);
			ResultSet res = pstmt.executeQuery();
		//	System.out.println("resultset+++"+res.toString());
			if (res.next()) {

				return true;
				
			}
		//	System.out.println("BeforeFalse");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false; 
			
	}

	@Override
	public void update(ERS_USERS entity) {
		// TODO Auto-generated method stub
		
	}
	/*
	  public ERS_USERS queryById(int id) throws SQLException {
	        List<ERS_USERS> userList = new ArrayList<ERS_USERS>();
	        String sql = getAllUsers + " WHERE " + userId + "= ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setInt(1, id);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        mapRows(resultSet, userList);
	        return userList.get(0);
	    }*/

	@Override
	public void insert(ERS_USERS entity) {
		System.out.println("entered insert \n"+ entity);
		// TODO Auto-generated method stub
		try(Connection con =  dbCon.getDbConnection()){
			
			 System.out.println("inside try");
			String sql = "{? = call ERS_USERS_INSERT(?,?,?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(2, entity.getERS_USERNAME());
			cs.setString(3, entity.getERS_PASSWORD());
			cs.setString(4, entity.getUSER_FIRST_NAME());
			cs.setString(5, entity.getUSER_LAST_NAME());
			cs.setString(6, entity.getUSER_EMAIL());
			cs.setInt(7, entity.getUSER_ROLE_ID());//foreinkey
			cs.execute();
			System.out.println(cs.getString(1));
	}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		 System.out.println("inside catch");
		e.printStackTrace();
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	}

	@Override
	public void delete(ERS_USERS entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ERS_USERS getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ERS_USERS queryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
public ERS_USERS findByUser(String usr)  {
		
	ERS_USERS user = null;
		
		try {
			Connection con = dbCon.getDbConnection();
			
			String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,  usr);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
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
	

}
