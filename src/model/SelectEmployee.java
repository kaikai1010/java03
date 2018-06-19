package model;

import java.util.List;

import dao.EmployeeDAO;

public class SelectEmployee {
	public static void main(String[] args) {

		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> eList = dao.findAll();

		for(Employee e : eList) {
			System.out.println(e.getId()+e.getName()+e.getAge());
		}

	}
}
