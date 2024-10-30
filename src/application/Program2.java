package application;

import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===== TEST 1: department findById =====");
		Department department = departmentDao.findById(2);
		System.out.println(department);

		System.out.println("\n===== TEST 2: department findAll =====");
		List<Department> departmentList = departmentDao.findAll();
		for (Department list : departmentList) {
			System.out.println(list);
		}
		
		System.out.println("\n===== TEST 3: department insert =====");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! new id = " + newDepartment.getId());
		
		System.out.println("\n===== TEST 4: department update =====");
		department = departmentDao.findById(1);
		department.setName("TI");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n===== TEST 5: department delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");

		sc.close();
		DB.closeConnection();
	}
}
