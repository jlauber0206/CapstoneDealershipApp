package dealershipapplicationB.Contoller;

import dealershipapplicationB.ExceptionHandling.Exceptions;
import dealershipapplicationB.Model.Customer;
import dealershipapplicationB.Model.Inventory;
import dealershipapplicationB.Model.SalesRecord;
import dealershipapplicationB.Repo.InventoryRepo;
import dealershipapplicationB.Repo.SalesRecordRepo;
import dealershipapplicationB.Service.InventoryService;
import dealershipapplicationB.Service.SalesRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping(value = "/inventory/")
public class InventoryController {

    private Inventory inventory;
    private InventoryRepo inventoryRepo;
    private InventoryService inventoryService;
    private SalesRecordRepo salesRecordRepo;
    private SalesRecordService salesRecordService;


    @Autowired
    public InventoryController(InventoryService inventoryService, InventoryRepo inventoryRepo) {
        this.inventoryService = inventoryService;
        this.inventoryRepo = inventoryRepo;
    }

    //***** User Entry page **** Works
    @RequestMapping(value = "UserName", method = RequestMethod.GET)
    public String userName(@ModelAttribute(name = "userName") Customer theCustomer)
            throws Exceptions {
        log.info("User Name page showing");
        //model.addAttribute("vehicles", inventoryRepo.findAll());

        return "UserName";
    }

    //***** User Entry page *** Submit button *** works
    @RequestMapping(value = "UserName", method = RequestMethod.POST)
    public String printUserGreeting(@ModelAttribute(name = "userName")Customer theCustomer) {
        return "redirect:../inventory/list";
    }

    //*****Get All List******  WORKS ****
    @GetMapping("list")
    public String getAllInventory(@Valid Model model)
            throws Exceptions {
        log.info("Getting all Inventory");
        model.addAttribute("vehicles", inventoryRepo.findAll());
        log.info("Received all Inventory");

        return "list-inventory";
    }

    //*****Delete Vehicle with current "id"**** WORKS ****
    @RequestMapping(path = "delete/{id}")
    public String deleteVehicleById(@PathVariable("id") String id, Model model)
            throws Exceptions {
        log.info("Vehicle has been Deleted");
        inventoryService.deleteById(id);

        return "redirect:../list";
    }

    //*****Get Inventory Form (Blank) ***** Works ****
    @RequestMapping("InventoryForm")
    public String getInventoryForm(@ModelAttribute(name = "vehicle")
                                           Inventory inventoryForm, Model model, Inventory theInventory) {
        if (inventoryForm == null) {
            log.info("Page Not Available");
        } else {
            log.info("Add Inventory Page has been displayed");
        }
        return "inventory-form";
    }
    //inventory-form

    //*****Submit Button ***** Works ****
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String createSalesRecord(@ModelAttribute(name = "vehicleData") String id, Inventory description) {

        SalesRecord data = new SalesRecord();
        inventory.getVehicleDescription();
        log.info("Created New Inventory: {}", description);
        //salesRecordService.create(salesRecord(theInventory.getVehicleDescription()));
        //salesRecordService.save(id.getVehicleDescription());

        return "redirect:../inventory/list";
    }

    @GetMapping(value = "get/{id}")
    public Optional<Inventory> getByInventoryId(@PathVariable("id")
                                                        String id, Inventory theInventory) {

        Optional<Inventory> vehicleInfo = inventoryService.getVehicleById(id);
        //inventoryService.getVehicleById(id);
        log.info("Retrieving Inventory information");
        //How to display this information in the Inventory Form

//        theInventory.setVehicleNumber(122222);
//        theInventory.setYear(2000);
//        theInventory.setMake("Toyota");
//        theInventory.setModelOfCar("Van");
//        theInventory.setColor("Blue");
//        theInventory.setPriceOfCar(theInventory.getVehiclePrice());
//        theInventory.setInInventory(true);
//        theInventory.setAvailableForOrder(false);
//        theInventory.setVehiclePrice(40000);
//        updateVehicle.setVehicleDescription(updateVehicle.getVehicleDescription());

        return vehicleInfo;
    }

    @GetMapping(value = "update/{id}}")
    public String saveVehicleById(@PathVariable("id") @ModelAttribute(name = "updateVehicle")
                                          Model model, String id, Inventory theInventory) {

        Optional<Inventory> vehicleData = inventoryRepo.findById("5e6a3c3f9e66983e9ccea6b0");

        log.info("Retrieving Inventory information");
        //How to display this information in the Inventory Form
        Inventory data = new Inventory();
        return "redirect:../inventory/list";
    }

    @PutMapping("update/{id}")
    public String updateVehicle(@RequestBody @ModelAttribute(name = "updateVehicle")@PathVariable String id, Inventory theInventory) {

        inventoryService.updateInventory(id, theInventory);
        return "redirect:../inventory/list";
    }

    public String vehiclePurchase(@ModelAttribute(name = "salesrecord")Inventory description, SalesRecord salesRecord) {

        salesRecordService.createSalesRecord();
        return "edit-customer";
    }


//    @PutMapping(value = "update/{id}") //how to get update to connect to UI text fields
//    public String update(@Valid @PathVariable(value = "id") @ModelAttribute(value = "veh") BindingResult bindingResult,
//                         Inventory theInventory,
//                         Model model,
//                         RedirectAttributes ra) {
//        log.info("Updating Inventory with information: {}", theInventory);
//        if (bindingResult.hasErrors()) {
//
//            return "list";
//        }
//        ra.addAttribute("veh", getAllInventory(model));
//        model.addAttribute("veh", inventoryService.updateInventory(theInventory));
//        Inventory updated = inventoryService.updateInventory(theInventory);
//        log.info("Updated Inventory with information: {}", updated);
//        return "redirect:list-inventory";
//    }

//        Inventory data = new Inventory();
//        theInventory.setYear(2014);
//        theInventory.setColor("White");
//        theInventory.setMake("Range Rover");
//        theInventory.setModelOfCar("Sport");//
//        theInventory.setPriceOfCar(theInventory.getVehiclePrice());
//        theInventory.setInInventory(true);//
//        theInventory.setAvailableForOrder(false);
//        theInventory.setVehicleDescription(theInventory.getVehicleDescription());
//        //theInventory.setCreatedDate(LocalDate.now());
//        inventoryService.save(theInventory);


//        return data;
//    }

    //************UI for Creating Inventory**************
//

//    @PutMapping(value = "update/{id}")
//    public Optional<Inventory> edit(@Valid @PathVariable("id") String id,
//                                    Inventory theInventory, Model model)
//    {
//        Optional<Inventory> i = inventoryService.getVehicleById(id);
//        //String.valueOf(i);
//        Inventory editInventory = new Inventory();
//        theInventory.getYear();
//        theInventory.getColor();
//        theInventory.getMake();
//        theInventory.getModelOfCar();//
//        theInventory.getInInventory();//
//        theInventory.getAvailableForOrder();
//        theInventory.getPriceOfCar();
//        theInventory.getInInventory();
//        theInventory.getAvailableForOrder();
//        //theInventory.setVehicleDescription(theInventory.getVehicleDescription());
//
//        log.info("So far so good");
//
//        return ;
//    }


}
