package dealershipapplicationB.Service;

import dealershipapplicationB.ExceptionHandling.Exceptions;
import dealershipapplicationB.Model.Employee;
import dealershipapplicationB.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    private EmployeeRepo employeeRepo;

    private String id;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> getAllEmployees() {
        return this.employeeRepo.findAll();
    }

    public Optional<Employee> findEmployeesById() {

        return this.employeeRepo.findById(id);
    }

//TODO: Find all Employees AND sort list by employeeLastName in Alphabetical order
//    List<Employee> findEmployeesByEmployeeLastName() {
//        getAllEmployees().sort();
//        return employeeRepo.findEmployeesByEmployeeLastName();
//    }

    public void save(Employee employee) {
        employeeRepo.save(employee);
    }


    public Optional<Employee> findById(String id) {
        return employeeRepo.findById(id);
    }

    public void deleteById(String id) {
         employeeRepo.deleteById(id);
    }

    public Employee updateEmployee(Employee theEmployee) {
        Employee employeeDB = this.employeeRepo.findDistinctBy(theEmployee.getEmployeeNumber());
        //TODO - auto employeeNumber generator
        //TODO - visible concatonation of First and Last Name
        //TODO - Logic for employeeWallet
        //TODO - Logic for employeeSenority

        if (employeeDB == null) {
            throw new Exceptions("Record not found with Employee Number : " + theEmployee.getEmployeeNumber());
        } else {

            employeeDB.setEmployeeNumber(theEmployee.getEmployeeNumber()); //atomicGeneratedNumber
            employeeDB.setEmployeeFirstName(theEmployee.getEmployeeFirstName());
            employeeDB.setEmployeeLastName(theEmployee.getEmployeeLastName());
            employeeDB.setEmployeeTitle(theEmployee.getEmployeeTitle());
            employeeDB.setEmployeeAddress(theEmployee.getEmployeeAddress());
            employeeDB.setEmployeeAge(theEmployee.getEmployeeAge());
            //employeeDB.setEmployeeSenority(theEmployee.getEmployeeSenority()); //senorityGenerator based on hire date
            //need a hire date parameter for the Employee data object
            //need a current salary for the Employee data object
            employeeDB.setEmployeeWallet(theEmployee.getEmployeeWallet()); //walletLogic based on sales of vehicles/salary

            employeeDB = employeeRepo.save(employeeDB);

            return employeeDB;

        }

    }

//    public List<Employee> findByDateOfHireAndEmployeeName {
//        return employeeRepo.findByDateOfHireAndEmployeeName(Date, String);
//    }

}


