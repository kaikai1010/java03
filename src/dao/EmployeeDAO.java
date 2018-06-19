package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeDAO {
	public List<Employee> findAll() {

		Connection conn = null;
		List<Employee> eList = new ArrayList<Employee>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/example?characterEncoding=UTF-8&serverTimezone=JST",
				"root", "");

			String sql = "SELECT ID,NAME,AGE FROM EMPLOYEE";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");

				Employee e = new Employee(id, name, age);
				eList.add(e);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return eList;
	}
}
