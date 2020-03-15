package dealershipapplicationB.Contoller;

import dealershipapplicationB.ExceptionHandling.Exceptions;
import dealershipapplicationB.Model.Employee;
import dealershipapplicationB.Repo.EmployeeRepo;
import dealershipapplicationB.Service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping(value = "/employee")
final class EmployeeController {

    private EmployeeService employeeService;
    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeRepo employeeRepo) {
        this.employeeService = employeeService;
        this.employeeRepo = employeeRepo;
    }

    //*****Home
    @GetMapping(value = "/")
    public String homePage() {
        return "home";
    }
    //*****Get/List All
    @GetMapping(value = "list")
    public String getAllEmployees(@Valid Model model) {
        log.info("Getting all Employees");
        model.addAttribute("employees", employeeRepo.findAll());
        log.info("Received all Employees");
        return "list-employee";
    }

    //*****Create
    @RequestMapping("create")
    public String create(Model model) {
        return "add-edit-employee";
    }

    //*****Save
    @RequestMapping("save")
    public String save(@RequestParam String employeeFirstName,
                       @RequestParam String employeeLastName,
                       @RequestParam String employeeTitle,
                       @RequestParam int employeeAge,
                       @RequestParam String employeeAddress)
    {

        Employee employee = new Employee();
        employee.setEmployeeFirstName(employeeFirstName);
        employee.setEmployeeLastName(employeeLastName);
        employee.setEmployeeTitle(employeeTitle);
        employee.setEmployeeAge(employeeAge);
        employee.setEmployeeAddress(employeeAddress);
        employeeRepo.save(employee);

        return "redirect:/list/" + employee.getId();
    }

    //*****Delete
    @RequestMapping(path = "delete/{id}")
    public String deleteEmployeeById(Model model, @PathVariable("id") String id)
            throws Exceptions
    {
        log.info("Employee has been Deleted");
        employeeService.deleteById(id);
        return "redirect:../list";
    }

    //********UI for Creating customer*************
    @GetMapping(value = "NewEmployee")
    public String showFormForAdd(@Valid Model model) {
        log.info("Showing form for New Employee");
//TODO: connect form to this Method

        return "add-edit-employee"; //createEmployee();
    }

    //*****Get by ID
    @GetMapping("{id}")
    public Optional<Employee> getEmployeeById(@PathVariable(value = "id") String id) {
        Optional<Employee> employeeData = employeeRepo.findById(id);
        log.info("Retrieving Employee information");

        return employeeData;
        //  "list-employee.html"
    }

    @PostMapping(value = "NewEmployee/create")
    public String newEmployee(@Valid Employee theEmployee) {
        log.info("Creating New Employee");

        Employee employee = new Employee();
        theEmployee.setEmployeeFirstName("Too");
        theEmployee.setEmployeeLastName("Bad");
        theEmployee.setEmployeeAddress("99 Pie St.");
        theEmployee.setEmployeeAge(24);
        theEmployee.setEmployeeTitle("Intern");
        theEmployee.getDateOfHire();
        theEmployee.setEmployeeWallet(1500);
        theEmployee.setEmployeeNumber(1222234);
        theEmployee.getEmployeeName();

        employeeService.save(theEmployee);
        log.info("Created New Employee");

        return "add-edit-employee";
    }

//    @PostMapping(value = "/newEmployee")
//    public String newEmployee(@Valid Employee theEmployee, BindingResult result) {
//        log.info("Creating New Employee");
//        ModelAndView modelAndView = new ModelAndView();
//        if (result.hasErrors()) {
//            log.info("Validation errors while submitting form.");
//            modelAndView.setViewName("list");
//            modelAndView.addObject("employees", theEmployee);
//            //modelAndView.addObject("allEmployees", getAllEmployees();
//
//        }
//        return "";
//    }

}



//    @PutMapping(value = "/employee/update")
//    public ResponseEntity<Employee> updateEmployee(@Valid Employee theEmployee) {
//        log.info("Update Employee");
//        return employeeService.findEmployeesById()
//                .map(employeeData -> {
//                    employeeData.setEmployeeNumber(theEmployee.getEmployeeNumber());
//                    employeeData.setEmployeeTitle(theEmployee.getEmployeeTitle());
//                    employeeData.setEmployeeAddress(theEmployee.getEmployeeAddress());
//                    employeeData.setEmployeeAge(theEmployee.getEmployeeAge());
//                    //employeeData.setEmployeeSenority(theEmployee.getEmployeeSenority());
//                    employeeData.setEmployeeWallet(theEmployee.getEmployeeWallet());
//
//                    //    Employee updateEmployee(id, employee) = employeeService.save(employeeData);
//                    return EmployeeService.save(theEmployee);
//                }).orElse(ResponseEntity.notFound().build());
//    }