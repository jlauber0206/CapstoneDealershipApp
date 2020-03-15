package dealershipapplicationB.Repo;


import dealershipapplicationB.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, String> {

    Employee findDistinctBy(int employeeNumber);
    ResponseEntity<?> deleteById();

//    List<Employee> findByDateOfHireAndEmployeeName(Date dateOfHire, String employeeName);



    //List<Employee> findByEmployeeNumber(String employeeNumber);

//    @Query("FROM Employee p WHERE p.name = :name")
//    Employee findByEmployeeNumberAndDateOfHire(@Param("EmployeeNumber"), @Param("") String employeeName);

}
