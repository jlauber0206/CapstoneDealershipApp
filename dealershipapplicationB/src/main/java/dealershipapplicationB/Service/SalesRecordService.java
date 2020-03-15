package dealershipapplicationB.Service;

import dealershipapplicationB.ExceptionHandling.Exceptions;
import dealershipapplicationB.Model.Employee;
import dealershipapplicationB.Model.Inventory;
import dealershipapplicationB.Model.SalesRecord;
import dealershipapplicationB.Repo.SalesRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SalesRecordService {

    private SalesRecordRepo salesRecordRepo;
    private InventoryService inventoryService;
    private Inventory id;
    private Employee employee;

    @Autowired
    public SalesRecordService(SalesRecordRepo salesRecordRepo) {
        this.salesRecordRepo = salesRecordRepo;

    }

    public List<SalesRecord> getAllSalesRecords() {
        return this.salesRecordRepo.findAll();
    }

//    public SalesRecord createSalesRecord() {
//
//        this.inventoryService.findById(id);
//        return ;
//    }

    public SalesRecord updateSalesRecord(SalesRecord theSalesRecord) {
        SalesRecord salesRecordDB = this.salesRecordRepo.findDistinctBy(theSalesRecord.getSalesRecordNumber());
        if (salesRecordDB == null) {
            throw new Exceptions("Record not found with Sales Record Number: " + theSalesRecord.getSalesRecordNumber());
        } else {
            salesRecordDB.setSalesRecordNumber(theSalesRecord.getSalesRecordNumber()); //atomicGeneratedNumber
            salesRecordDB.setCommissioned(theSalesRecord.isCommissioned());
            //salesRecordDB.setCustomerLastName(theSalesRecord.getCustomerLastName());

            salesRecordDB = salesRecordRepo.save(salesRecordDB);

            return salesRecordDB;
        }
    }

    public void save(SalesRecord salesRecord) {
        salesRecordRepo.save(salesRecord);
    }

    public Optional<SalesRecord> findById(String id) {
        return salesRecordRepo.findById(id);
    }

    public void deleteById(String id) {
        salesRecordRepo.deleteById(id);
    }
}

//        public SaleRecord(double priceOfCar, boolean commissioned) {
//            //this.vehicleSold = vehicleSold;*******Where does this go? ()****************
//            this.priceOfCar = priceOfCar;
//            this.commissioned = commissioned;
//            //this.employee = employee;
//    }




