package dealershipapplicationB.Repo;

import dealershipapplicationB.Model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends MongoRepository < Customer, String > {

    Customer findDistinctBy(int customerNumber);
    //ResponseEntity<?> deleteById();
//    List<Customer> findCustomerByCustomerAddress();
//    //Optional<Customer> findDistinctByCustomerCashOnHandIsGreaterThanEqual(x);
//    List<Customer> findCustomerByCustomerLastName();

        //ResponseEntity<?> deleteById();
//    String getCustomerName();
//
//    default ResponseEntity<Customer> deleteById() {
//        return null;
//    }

}
