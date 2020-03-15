//package dealershipapplicationB.Contoller;
//
//
//import dealershipapplicationB.Model.SalesRecord;
//import dealershipapplicationB.Repo.DealershipRepo;
//import dealershipapplicationB.Repo.SalesRecordRepo;
//import dealershipapplicationB.Service.DealershipService;
//import dealershipapplicationB.Service.SalesRecordService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@Slf4j
//@RequestMapping(value = "/dealership")
//public class DealershipController {
//
//    private DealershipRepo dealershipRepo;
//    private DealershipService dealershipService;
//    private SalesRecordService salesRecordService;
//    private SalesRecordRepo salesRecordRepo;
//
//    @Autowired
//    public DealershipController(DealershipRepo dealershipRepo,DealershipService dealershipService, SalesRecordService salesRecordService, SalesRecordRepo salesRecordRepo) {
//        this.dealershipRepo = dealershipRepo;
//        this.dealershipService = dealershipService;
//        this.salesRecordService = salesRecordService;
//        this.salesRecordRepo = salesRecordRepo;
//
//        //System.out.println(dealershipService.handleCustomer(customer, inventory, employee));
//    }
//
//    //********************************
//    @GetMapping(value = "/list")
//    public List<SalesRecord> getAllSales() {
//        log.info("Getting all Sales");
//        List<SalesRecord> salesRecords = salesRecordService.getAllSalesRecords();
//
//        return salesRecords;
//    }
//}
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<?> deleteCustomer(@PathVariable("id") @Valid String id) {
//        try {
//            customerRepo.deleteById(id);
//            log.info("Customer information has been deleted");
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            log.info("Customer information was not deleted");
//            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
//        }






//    }


