package dealershipapplicationB.Contoller;

import dealershipapplicationB.ExceptionHandling.Exceptions;
import dealershipapplicationB.Model.SalesRecord;
import dealershipapplicationB.Repo.SalesRecordRepo;
import dealershipapplicationB.Service.SalesRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping(value = "/salesrecord")
public class SalesRecordController {

    private SalesRecordRepo salesRecordRepo;
    private SalesRecordService salesRecordService;

    @Autowired
    public SalesRecordController(SalesRecordRepo salesRecordRepo, SalesRecordService salesRecordService) {
        this.salesRecordRepo = salesRecordRepo;
        this.salesRecordService = salesRecordService;
    }

    @GetMapping(value = "/")
    public String homePage() {
        return "home";
    }

    @GetMapping(value = "list")
    public String getAllSalesRecords(@Valid Model model) {
        log.info("Getting All SalesRecords");
        model.addAttribute("salesrecords", salesRecordRepo.findAll());
        log.info("Received all Sales Records");
        return "list-salesrecord";
    }

    @RequestMapping(value = "update")
    public String update(@Valid @ModelAttribute(value = "salesRec") SalesRecord theSalesRecord, Model model) {
        log.info("Updating Sales Record entry with information: {}", theSalesRecord);
        model.addAttribute("salesRec", salesRecordService.updateSalesRecord(theSalesRecord));
        SalesRecord updated = salesRecordService.updateSalesRecord(theSalesRecord);
        log.info("Updated Sales Record entry with information: {}", updated);

        return "add-edit-salesrecord";
    }

    @RequestMapping(path = "delete/{id}")
    public String deleteSalesRecord(Model model, @PathVariable("id") String id)
        throws Exceptions
    {
        log.info("Sales Record has been Deleted");
        salesRecordService.deleteById(id);
        return "redirect:../list";
    }

    //***********UI for Creating customer************
    @GetMapping(value = "newSalesRecordForm")
    public String showFormForAdd(@Valid @RequestBody SalesRecord theSalesRecord) {
        log.info("Showing form for New SalesRecord");

        return "redirect: /newSalesRecord";
    }

    @GetMapping(value = "{id}")
    public Optional<SalesRecord> getSalesRecordById(@PathVariable String id)  {
        Optional<SalesRecord> salesRecordData = salesRecordService.findById(id);
        log.info("Retrieving Sales Record information");

        return salesRecordData;
    }

    @PostMapping(value = "NewSalesRecord/create")
    public String newSalesRecord(@Valid SalesRecord theSalesRecord) {
        log.info("Creating New Sales Record");

        //how to kick off the SalesRecord
        //What is the connecting factor...unique identifier
        SalesRecord salesRecord = new SalesRecord();
        theSalesRecord.setSalesRecordNumber(11020);
        theSalesRecord.getVehicleSalesRecord();
        theSalesRecord.getSalesCommission();
        theSalesRecord.setCommissioned(false);

        salesRecordService.save(theSalesRecord);
        log.info("Created New Sales Record");

        return "redirect:";

    }
}
