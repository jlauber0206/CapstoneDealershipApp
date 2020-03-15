//package dealershipapplicationB.Service;
//
//import dealershipapplicationB.Model.Employee;
//import dealershipapplicationB.Repo.EmployeeRepo;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class employeeServiceTest {
//
//    @InjectMocks
//    EmployeeService employeeService;
//
//    @Mock
//    EmployeeRepo employeeRepo;
//
//    @Test
//    public void testGetAllEmployees() throws Exception {
//
//        //Arrange
//        List<Employee> list = new ArrayList<>();
//        Employee employee = new Employee();
//        employee.setId("23");
//        employee.setEmployeeFirstName("Too");
//        employee.setEmployeeLastName("Bad");
//        employee.setEmployeeAddress("99 Pie St.");
//        employee.setEmployeeAge(24);
//        employee.setEmployeeTitle("Intern");
//        employee.setEmployeeWallet(1500);
//        employee.setEmployeeNumber(1222222);
//
//        list.add(employee);
//            when(employeeRepo.findAll()).thenReturn(list);
//
//
//        //Act
//        List<Employee> actual = employeeService.getAllEmployees();
//
//        //Assert
//        List<Employee> expected = new ArrayList<>();
//        Employee expectedEmployee = new Employee("23", 1222222, "Too", "Bad", "Intern", "99 Pie St.", 24, 0, 1500.0);
//
//
//        assertEquals(expected, actual);
//        System.out.println(expected);
//        System.out.println(actual);
//
//
//
//
//    }
//}
