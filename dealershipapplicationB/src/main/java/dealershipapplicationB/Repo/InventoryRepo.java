package dealershipapplicationB.Repo;


import dealershipapplicationB.Model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends MongoRepository<Inventory, String> {

    Inventory findDistinctBy(int vehicleNumber);

    //ResponseEntity<?> deleteById();

}
