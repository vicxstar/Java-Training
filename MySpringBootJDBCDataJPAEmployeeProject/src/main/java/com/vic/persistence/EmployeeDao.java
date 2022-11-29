/**
 * 
 */
package com.vic.persistence;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vic.entity.Employee;

/**
 *
 * @author vic
 * date: 28/11/2022
 * purpose: Step 3. The DAO INTERFACE (PERSISTENCE LAYER)
 *
 */

//'@Repository' indicates that this class is a 'repository' that can store and retrieve a collection of objects:
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	//TO FIND EMPLOYEE BY DEPARTMENT:
	//to search via department (the Jpa does this for us):
	//import 'List'
	List<Employee> findByDepartmentName(String department);
	
	//TO FIND EMPLOYEE VIA SALARY:
	//to search via salary:
	List<Employee> findByEmpSalary(double salary);
	
	//TO FIND EMPLOYEE BY ROLE:
	//JPQL (Jakarta Persistence Query Language)
	//it's query (@Query) can retrieve an entity object rather than field result set from database
	@Query("from Employee where role =: role")
	//'@Param' is used to bind parameters to a query via a named parameter:
	List<Employee> searchEmployeeByRole(@Param("role") String designation);
	
	//TO DELETE EMPLOYEE:
	//use JPQL to retrieve an object from database:
	//'@Modifying' is used to modify a query and change the way it needs to be executed:
	@Modifying
	//'@Transactional' provides the applications the ability to control the transaction boundaries:
	@Transactional
	//use '@Query' to retrieve objects from the database:
	@Query("delete from Employee where empLastName =: na")
	int deleteByName(@Param("na") String name);
	
	//TO ADD NEW EMPLOYEE:
	//Native Query is a query written as text in the database's query language (usually SQL)
	//use '@Modifying' to modify a query and change the way it needs to be executed:
	@Modifying
	//use '@Transactional' to control the transaction boundaries:
	@Transactional
	//use '@Query' to retrieve objects from the database:
	@Query(value = "insert into employee values(:id, :na, :na, :email, :num, :date, :jId, :salary, :comm, "
			+ ":manId, :deptId, :deptName, :role)", nativeQuery = true)
	int insertEmployee(@Param("id") int id, @Param("na") String firstName, @Param("na") String lastName, @Param("email") String empEmail, 
			@Param("num") String empPhoneNum, @Param("date") LocalDate hireDate, @Param("jId") String jobId, @Param("salary") double empSalary,
			@Param("comm") double empCommission, @Param("manId") int managerId, @Param("deptId") int departmentId, 
			@Param("deptName") String departmentName, @Param("role") String role)throws SQLIntegrityConstraintViolationException;

	//TO INCREASE SALARY:
	//use JPQL to retrieve an object from database:
	//use '@Modifying' to modify a query and change the way it needs to be executed:
	@Modifying
	//use '@Transactional' to control the transaction boundaries:
	@Transactional
	//use '@Query' to retrieve objects from the database:
	@Query("update Employee set salary = salary +:inc where empId =:id")
	int updateSalary(@Param("id") int empId,@Param("inc") double increment);
}
