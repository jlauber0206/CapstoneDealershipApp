package dealershipapplicationB.Repo;

import dealershipapplicationB.Model.SalesRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRecordRepo extends MongoRepository <SalesRecord, String>{

//    List<SalesRecord> findAllBySalesRecord(double salesRecord);
    SalesRecord findDistinctBy(int salesRecordNumber);
}
