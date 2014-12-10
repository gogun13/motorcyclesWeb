package th.go.motorcycles.app.enjoy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EnjoyConectDb {
	// JDBC driver name and database URL
	   static final String 	JDBC_DRIVER 	= "com.mysql.jdbc.Driver";
	   static final String 	jdbcutf8 		= "?useUnicode=true&characterEncoding=UTF-8";
	   static final String 	DB_NAME 		= "motorcycles";
	   static final String 	DB_URL 			= "jdbc:mysql://localhost:3306/" + DB_NAME + jdbcutf8;

	   //  Database credentials
	   static final String 	USER 			= "root";
	   static final String 	PASS 			= "";
	   
	   private Connection 	conn 			= null;
	   private Statement 	stmt 			= null;
	   
	   public EnjoyConectDb(){
		   setConnection();
	   }
	   
	   public ResultSet executeQuery(String sql) throws Exception{
		   System.out.println("[ConectDb][executeQuery][Begin]");
		   
		   ResultSet rs = null;
		   
		   try{
			   rs = this.stmt.executeQuery(sql);
		   }catch(Exception e){
			   throw new Exception(e.getMessage());
		   }finally{
			   System.out.println("[ConectDb][executeQuery][End]");
		   }
		   return rs;
	   }
	   
	   public boolean execute(String sql) throws Exception, SQLException{
		   System.out.println("[ConectDb][execute][Begin]");
		   
		   boolean rs = false;
		   
		   try{
			    this.stmt.execute(sql);
			    rs = true;
		   }catch(Exception e){
			   throw new Exception(e.getMessage());
		   }finally{
			   System.out.println("[ConectDb][execute][End]");
		   }
		   return rs;
	   }
	   
		public Connection getConn() {
			return conn;
		}

		public void setConn(Connection conn) {
			this.conn = conn;
		}

		public Statement getStmt() {
			return stmt;
		}

		public void setStmt(Statement stmt) {
			this.stmt = stmt;
		}

		private void setConnection() {
			System.out.println("[ConectDb][setConnection][Begin]");

			try {
				Class.forName(JDBC_DRIVER);

				this.conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
				this.stmt = (Statement) this.conn.createStatement();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("[ConectDb][setConnection][End]");
			}
		}
}
