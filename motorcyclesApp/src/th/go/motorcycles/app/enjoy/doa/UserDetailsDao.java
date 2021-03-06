package th.go.motorcycles.app.enjoy.doa;

import java.sql.ResultSet;

import th.go.motorcycles.app.enjoy.bean.UserDetailsBean;
import th.go.motorcycles.app.enjoy.utils.EnjoyConectDb;
import th.go.motorcycles.app.enjoy.utils.EnjoyEncryptDecrypt;

public class UserDetailsDao {	
	private EnjoyConectDb db = null;	
	public UserDetailsDao(){
		db = new EnjoyConectDb();
	}
	
	public static void main(String[] args) {
		EnjoyConectDb db = new EnjoyConectDb();
		String 				sql			 	= null;
		ResultSet 			rs 				= null;
		String				passWord		= null;
		
		passWord	= EnjoyEncryptDecrypt.enCryption("admin", "admin");
		sql 		= " SELECT * from motoruser ";
		
		System.out.println("[EnjoyMotorUserDao][userSelect] sql :: " + sql);
		
	    try {
			rs 			= db.executeQuery(sql);
			while(rs.next()){
		    	
		    	System.out.println(rs.getString("mUser"));
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public UserDetailsBean userSelect(String userId, String pass){
		System.out.println("[EnjoyMotorUserDao][userSelect][Begin]");
		
		String 				sql			 	= null;
		ResultSet 			rs 				= null;
		UserDetailsBean		userBean		= null;
        String				passWord		= null;
		
		try{
			passWord	= EnjoyEncryptDecrypt.enCryption(userId, pass);
			sql 		= " SELECT userUniqueId, userId, userName, userSurname, userPrivilege, userLevel ";
			sql 		= sql + " FROM userdetails where userId = '" + userId + "' and userPassword = '" + passWord + "' and userStatus = 'A'";
			
			System.out.println("[EnjoyMotorUserDao][userSelect] sql :: " + sql);
			
		    rs 			= this.db.executeQuery(sql);
		    
		    while(rs.next()){
		    	userBean	= new UserDetailsBean();
		    	
		    	userBean.setUserUniqueId(rs.getString("userUniqueId"));
		    	userBean.setUserId(rs.getString("userId"));
		    	userBean.setUserName(rs.getString("userName"));
		    	userBean.setUserSurname(rs.getString("userSurname"));
		    	userBean.setUserPrivilege(rs.getString("userSurname"));
		    	userBean.setUserLevel(rs.getString("userLevel"));
		    }
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("[EnjoyMotorUserDao][userSelect][End]");
		}
		
		return userBean;
	}
}
