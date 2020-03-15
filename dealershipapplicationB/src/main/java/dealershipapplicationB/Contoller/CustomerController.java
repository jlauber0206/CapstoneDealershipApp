package dealershipapplicationB.Contoller;

import dealershipapplicationB.ExceptionHandling.Exceptions;
import dealershipapplicationB.Model.Customer;
import dealershipapplicationB.Repo.CustomerRepo;
import dealershipapplicationB.Service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping(value = "/customer")
public class CustomerController {

    private CustomerRepo customerRepo;
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerRepo customerRepo) {
        this.customerService = customerService;
        this.customerRepo = customerRepo;
    }

    @GetMapping(value = "/")
    public String homePage() {
        return "home";
    }

    @GetMapping(value = "list")
    public String getAllCustomers(@Valid Model model) {
        log.info("Getting all Customers");
        model.addAttribute("customers", customerRepo.findAll());
        log.info("Received all Customers");
        return "list-customer";
    }

    @RequestMapping("create")
    public String create(Model model) {
        return "edit-customer";
    }

    @RequestMapping("save")
    public String save(@RequestParam String customerFirstName,
                       @RequestParam String customerLastName,
                       @RequestParam String customerAddress,
                       @RequestParam String customerCity,
                       @RequestParam String customerState,
                       @RequestParam String customerEmail,
                       @RequestParam int customerPhoneNumber,
                       @RequestParam double customerCashOnHand)
    {

        Customer customer = new Customer();
        customer.setCustomerFirstName(customerFirstName);
        customer.setCustomerLastName(customerLastName);
        customer.setCustomerAddress(customerAddress);
        customer.setCustomerCity(customerCity);
        customer.setCustomerState(customerState);
        customer.setCustomerEmail(customerEmail);
        customer.setCustomerPhoneNumber(customerPhoneNumber);
        customer.setCustomerCashOnHand(customerCashOnHand);
        customerRepo.save(customer);

        return "redirect:list" + customer.getId();
    }

    @PutMapping(value = "update/{id}")
    public String update(@Valid Customer theCustomer) {
        log.info("Updating Customer entry with information: {}", theCustomer);

        Customer updated = customerService.updateCustomer(theCustomer);
        log.info("Updated Customer entry with information: {}", updated);

        return "edit-customer";
    }

    @RequestMapping(path = "delete/{id}")
    public String deleteCustomerById(Model model, @PathVariable("id") String id)
        throws Exceptions {
        log.info("Customer has been Deleted");
        customerService.deleteById(id);
        return "redirect:../list";
    }

    //********UI for Creating customer*************
    @GetMapping(value = "NewCustomer")
    public String showFormForAdd(@Valid Model model) {
        log.info("Showing form for New Customer");
//TODO: connect form to this Method

        return "edit-customer"; //createCustomer();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable String id) {
        Optional<Customer> employeeData = customerService.findById(id);
        log.info("Retrieving Customer information");

        return employeeData;
    }

    @PostMapping(value = "NewCustomer")
    public String newCustomer(@Valid Customer theCustomer) {
        log.info("Creating New Customer");

        Customer customer = new Customer();
//        theCustomer.setCustomerNumber(8888888);
//        theCustomer.setCustomerFirstName("Tomorrow");
//        theCustomer.setCustomerLastName("Yesterday");
//        theCustomer.setCustomerAddress("90 St Rd.");
//        theCustomer.setCustomerCity("Cheney");
//        theCustomer.setCustomerState("WA");//
//        theCustomer.setCustomerCashOnHand(20000.00);//
//        theCustomer.getDateOfVisit();
//        theCustomer.getCustomerName();

        customerService.save(theCustomer);
        log.info("Created New Customer");

        return "list-customer";
    }
}

//
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public String createEmployee(Employee theEmployee) {
//        LOG.info("Create New Employee");
//        employeeService.save(theEmployee);
//        return "redirect:/employee/list";
//
//    @RequestMapping(value = "/employee/update", method = RequestMethod.PUT)
//    public ResponseEntity<Employee> updateEmployee(String id, @Valid @RequestBody Employee employee) {
//        LOG.info("Update Employee");
//        return employeeRepo.findById(id)
//                .map(employeeData -> {
//                    employeeData.setEmployeeNumber(employee.getEmployeeNumber());
//                    employeeData.setEmployeeTitle(employee.getEmployeeTitle());
//                    employeeData.setEmployeeAddress(employee.getEmployeeAddress());
//                    employeeData.setEmployeeAge(employee.getEmployeeAge());
//                    employeeData.setEmployeeSenority(employee.getEmployeeSenority());
//                    employeeData.setEmployeeWallet(employee.getEmployeeWallet());
//
//                    Employee updatedEmployee = employeeRepo.save(employeeData);
//                    return ResponseEntity.ok().body(employeeData);
//                }).orElse(ResponseEntity.notFound().build());

