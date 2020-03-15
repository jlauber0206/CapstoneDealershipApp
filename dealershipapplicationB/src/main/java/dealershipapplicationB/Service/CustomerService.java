package dealershipapplicationB.Service;


import dealershipapplicationB.ExceptionHandling.Exceptions;
import dealershipapplicationB.Model.Customer;
import dealershipapplicationB.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepo customerRepo;

    private String id;

    @Autowired
    public CustomerService(CustomerRepo theCustomerRepo) {
        this.customerRepo = theCustomerRepo;
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepo.findAll();
    }

//TODO: Find all Employees AND sort list by employeeLastName in Alphabetical order

    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    public Optional<Customer> findById(String id) {
        return customerRepo.findById(id);
    }

    public void deleteById(String id) {
        customerRepo.deleteById(id);
    }


    public Customer updateCustomer(Customer theCustomer) {
        Customer customerDB = this.customerRepo.findDistinctBy(theCustomer.getCustomerNumber());
        //TODO - auto employeeNumber generator
        //TODO - visible concatonation of First and Last Name
        //TODO - Logic for employeeWallet
        //TODO - Logic for employeeSenority

        if (customerDB == null) {
            throw new Exceptions("Record not found with Customer Number : " + theCustomer.getCustomerNumber());
        } else {

            customerDB.setCustomerNumber(theCustomer.getCustomerNumber()); //atomicGeneratedNumber
            customerDB.setCustomerFirstName(theCustomer.getCustomerFirstName());
            customerDB.setCustomerLastName(theCustomer.getCustomerLastName());
            customerDB.setCustomerEmail(theCustomer.getCustomerEmail());
            customerDB.setCustomerCashOnHand(theCustomer.getCustomerCashOnHand());
            customerDB.setCustomerAddress(theCustomer.getCustomerAddress());
            customerDB.setCustomerCity(theCustomer.getCustomerCity());
            customerDB.setCustomerState(theCustomer.getCustomerState());

            //employeeDB.setEmployeeSenority(theEmployee.getEmployeeSenority()); //senorityGenerator based on hire date
            //need a hire date parameter for the Employee data object
            //need a current salary for the Employee data object

            customerDB = customerRepo.save(customerDB);

            return customerDB;

        }
    }
}

//    public Customer updateCustomer(Customer theCustomer) {
//
//        Customer customerDB = this.customerRepo.findDistinctBy(theCustomer.getCustomerNumber());
//
//
//        if (customerDB == null) {
//            throw new Exceptions("Record not found with Customer Name: " + theCustomer.getCustomerName());
//        } else {
//
//            customerDB.setCustomerFirstName(theCustomer.getCustomerFirstName());
//            customerDB.setCustomerLastName(theCustomer.getCustomerLastName()); //atomicGeneratedNumber
//            customerDB.setCustomerAddress(theCustomer.getCustomerAddress());
//            customerDB.setCustomerCity(theCustomer.getCustomerCity());
//            customerDB.setCustomerState(theCustomer.getCustomerState());
//            customerDB.setCustomerEmail(theCustomer.getCustomerEmail());
//            customerDB.setCustomerCashOnHand(theCustomer.getCustomerCashOnHand());
//
//            customerDB = customerRepo.save(customerDB);
//
//            return customerDB;
//        }

//        public String findDistinctByCustomerCashOnHandIsGreaterThanEqual() {
//
//            Double cashMoneyFiveK = 5000.00;
//            Double COH = getCustomerCashOnHand();
//            String customersWithCash = this.customer.getCustomerName();
//            if(COH >= cashMoneyFiveK) {
//              return customersWithCash;
//            } else {
//                return "No one has enough money.";
//            }
//
//        }


