//package dealershipapplicationB.Service;
//
//
//import dealershipapplicationB.Model.Customer;
//import dealershipapplicationB.Model.Employee;
//import dealershipapplicationB.Model.Inventory;
//import dealershipapplicationB.Model.SalesRecord;
//import dealershipapplicationB.Repo.DealershipRepo;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Data
//@Service
//public class DealershipService {
//
//    DealershipRepo dealershipRepo;
//
//    @Autowired
//    public DealershipService(DealershipRepo dealershipRepo) {
//        this.dealershipRepo = dealershipRepo;
//
//    }
//    private double startingWalletAmount = 1000000;
//    private Customer customer;
//    private Inventory inventory;
//    private Employee employee;
//    private List<SalesRecord> salesRecord;
//
//
//    private double priceOfCar = inventory.salesPriceOfCar();
//    private double profit = (priceOfCar - inventory.getVehiclePrice());
//    private double wallet = profit + startingWalletAmount;
//    //public List<Inventory> carInventory = inventory.getCarInventory();
//    double approvedAmount = (priceOfCar * .35);
//    double amountNeeded = priceOfCar - customer.getCustomerCashOnHand() - approvedAmount;
//    double loanAmount = (priceOfCar - customer.getCustomerCashOnHand());
//
//
//////    public DealershipService(DealershipRepo dealershipRepo) {
//////        this.dealershipRepo = dealershipRepo;
//////
//////    }
//
//    public void handleCustomer(Customer customer, Inventory inventory, Employee employee) {
//        double approvedAmount = (priceOfCar * .35);
//        double amountNeeded = (priceOfCar - customer.getCustomerCashOnHand()) - approvedAmount;
//        double loanAmount = (priceOfCar - customer.getCustomerCashOnHand());
//        if (customer.getCustomerCashOnHand() >= priceOfCar) {
//            processTransaction(customer, inventory, employee);
//            System.out.println(customer.getCustomerName() + "has enough cash to purchase " + inventory.getVehicleDescription() + " .");
//
//        } else if (priceOfCar * .50 <= customer.getCustomerCashOnHand()) {
//
//            processTransaction(customer, inventory, employee);
//            System.out.println(customer.getCustomerName() + "has been approved for " + inventory.getVehicleDescription() + ", and a loan of $" + approvedAmount + " .");
//
//        } else {
//            System.out.println("YOU NEED: " + amountNeeded + " AMOUNT TO PURCHASE THE VEHICLE.");
//        }
//
//        setSalesRecord(salesRecord);
//    }
//
//    public void processTransaction(Customer customer, Inventory inventory, Employee employee ) {
//
//        if (getApprovedAmount() + customer.getCustomerCashOnHand() >= priceOfCar) {
//            System.out.println("Vehicle " + inventory.getVehicleNumber() + "was sold to " + customer.getCustomerName() + " for $ " + priceOfCar + ". ");
//        }
//        customer.setCustomerCashOnHand(priceOfCar - customer.getCustomerCashOnHand());
//
////        int indexOfVehicleFound = 0;
////        for (int i = 0; i == carInventory.size(); ++i) {
////            Inventory vehicleInInventory = carInventory.get(i);
////            if (inventory.getVehicleNumber() == vehicleInInventory.getVehicleNumber()) {
////                indexOfVehicleFound = i;
////            }
////        }
////        carInventory.remove(indexOfVehicleFound);
//
////        SalesRecord salesRecord = new SalesRecord(, this, this, this);
////
////**************how to set up the SalesRecord to be Dynamic*******
//
//    }
//    public void processCommission(Employee employee, Inventory inventory) {
//        //processSalesCommission
//        double commissionMin = 250;
//        double commissionPaid = (priceOfCar * .20);
//
//        for (int i = 0; i == salesRecord.size() - 1; i++) {
//            SalesRecord recordedSale = salesRecord.get(i);
//
//            if (!salesRecord.contains(salesRecord)) {
//                //System.out.println(emp.getEmployeeName() + " did not receive any commission.");
//
//            }
//            if (!recordedSale.isCommissioned() && commissionPaid >= commissionMin) {
//                employee.setEmployeeWallet(employee.getEmployeeWallet() + commissionPaid);
//                recordedSale.setCommissioned(true);
//                this.wallet = (wallet - commissionPaid);
//                System.out.println(employee.getEmployeeName() + " was paid $" + commissionPaid + " on Vehicle " + inventory.getVehicleNumber() + ".");
//            } else if (!recordedSale.isCommissioned() && commissionPaid <= commissionMin) {
//                employee.setEmployeeWallet(employee.getEmployeeWallet() + commissionMin);
//                recordedSale.setCommissioned(true);
//                this.wallet = (wallet - commissionMin);
//                System.out.println(employee.getEmployeeName() + " was paid $" + commissionMin + " on Vehicle " + inventory.getVehicleNumber() + ".");
//            } else {
//                System.out.println("No commission was paid.");
//            }
//            System.out.println(employee.getEmployeeName() + "'s Commission for this pay period is $" + employee.getEmployeeWallet() + ".");
//        }
//
//    }
//}



//    public List<Inventory> currentInventory (Inventory theInventory) {
//        if (inventory.inInventory = true) {
//
//        }
//        return currentInventory(theInventory);
//    }
//



//TODO Look at making the commission more dynamic and reality based as far as how a Dealership would pay a salesperson
//TODO Write Unit Tests for current Methods in Dealership

//TODO add a DB to this for more possibilities of manipulation, calculations, and analysis
//TODO rolling paycheck (employee as well as the Dealership wallet)

//TODO Look at some sort of Supply Chain/Inventory creation/manipulation
//TODO API??
//TODO What would be needed for a basic UI




