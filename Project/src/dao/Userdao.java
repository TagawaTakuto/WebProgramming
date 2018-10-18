package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class Userdao {

	public User findByLoginInfo(String login_id,String password) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,login_id);
			pStmt.setString(2,password);
			ResultSet rs = pStmt.executeQuery();

			if(!rs.next()) {
			return null;
		}
			String loginIdData = rs.getString("login_id");
			String nameData = rs.getString("name");
			return new User(loginIdData,nameData);

		}catch(SQLException e){
			e.printStackTrace();
			return null;

		}finally {
			if(conn != null) {
				try {
					conn .close();
				}catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}


		public List<User>findAll(){
			Connection conn = null;
			List<User> userList = new ArrayList<User>();
			try {
				conn = DBManager.getConnection();

				String sql = "SELECT * FROM user";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				while(rs.next()) {
					int id = rs.getInt("id");
					String loginId = rs.getString("login_id");
					String name = rs.getString("name");
					Date birthDate = rs.getDate("birth_date");
					String password = rs.getString("password");
					String createDate = rs.getString("create_date");
					String updateDate = rs.getString("update_date");
					User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

					userList.add(user);
				}
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}finally {
				if(conn != null) {
					try {
						conn.close();
					}catch(SQLException e) {
						e.printStackTrace();
						return null;
					}
				}
			}
			return userList;
		}


		public User findByLoginId(String id) {
			Connection conn = null;
			try {
				conn = DBManager.getConnection();

				String sql = "SELECT * FROM user WHERE id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1,id);
				ResultSet rs = pStmt.executeQuery();

				if(!rs.next()) {
				return null;
			}
				int Id = rs.getInt("id");
				String loginIdData = rs.getString("login_id");
				String nameData = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");

				return new User(Id,loginIdData,nameData,birthDate,createDate, updateDate);

			}catch(SQLException e){
				e.printStackTrace();
				return null;

			}finally {
				if(conn != null) {
					try {
						conn .close();
					}catch (SQLException e) {
						e.printStackTrace();
						return null;
					}
				}
			}
		}


		public User findByUser(String name, String birthDate, String password) {
			Connection conn = null;
			try {
				conn = DBManager.getConnection();

				String sql = "SELECT * FROM user WHERE name = ? and birth_date = ? and password = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1,name);
				pStmt.setString(2,birthDate);
				pStmt.setString(3,password);

				ResultSet rs = pStmt.executeQuery();

				if(!rs.next()) {
				return null;
			}

				String nameData = rs.getString("name");
				Date birthdate = rs.getDate("birth_date");
				String Password = rs.getString("password");


				return new User(nameData,birthdate,Password);

			}catch(SQLException e){
				e.printStackTrace();
				return null;

			}finally {
				if(conn != null) {
					try {
						conn .close();
					}catch (SQLException e) {
						e.printStackTrace();
						return null;
					}
				}
			}
		}

		//public User findByNew(String loginId, String password, String nameDate, String birthDate) {






		public void CU(String loginId, String nameDate, String birthDate, String Password) {
			Connection conn = null;

			/*String source = "password";
			 Charset charset = StandardCharsets.UTF_8;
			 String algorithm = "MD5";
			 byte[] bytes;
			try {
				bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
				 String result = DatatypeConverter.printHexBinary(bytes);
				 System.out.println(result);
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}*/

			try {
				conn = DBManager.getConnection();

				 String sql = "INSERT INTO user (login_id, name, birth_date, password, create_date, update_date)"
				 		+ "values(?, ?, ?, ?, now(),now())";
				 PreparedStatement st = conn.prepareStatement(sql);

				 st.setString(1,loginId);
				 st.setString(2,nameDate);
				 st.setString(3,birthDate);
				 st.setString(4,Password);

				 int i = st.executeUpdate();
				 System.out.println(i);
				 st.close();
			}catch(SQLException e){
				e.printStackTrace();
				return;

			}finally {
				if(conn != null) {
					try {
						conn.close();
					}catch (SQLException e) {
						e.printStackTrace();
						return;
					}
				}
			}
		}
		//アップデート
		public void UU(String loginId, String nameDate, String birthDate, String Password){
			Connection conn = null;
			try {
				conn = DBManager.getConnection();

				 String sql = "UPDATE user SET name = ? , birth_date = ?"
				 		+ ", password = ? ,update_date = now() WHERE login_id =?" ;
				 PreparedStatement st = conn.prepareStatement(sql);

				 st.setString(1,nameDate);
				 st.setString(2,birthDate);
				 st.setString(3,Password);
				 st.setString(4,loginId);

				 int i = st.executeUpdate();
				 System.out.println(i);
				 st.close();
			}catch(SQLException e){
				e.printStackTrace();
				return;

			}finally {
				if(conn != null) {
					try {
						conn.close();
					}catch (SQLException e) {
						e.printStackTrace();
						return;
					}
				}
			}
		}


		public User findByNew(String loginId, String password, String nameData, String birthDate) {

			return new User(loginId,password,nameData,birthDate);
		}


		public User findByU(String nameData, String birthDate, String password) {
			// TODO 自動生成されたメソッド・スタブ
			return new User(nameData, birthDate, password);
		}
}