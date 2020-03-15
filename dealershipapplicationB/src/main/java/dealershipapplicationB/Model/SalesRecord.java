package dealershipapplicationB.Model;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

import static dealershipapplicationB.Utility.PreCondition.*;

@EntityScan
@Validated
@Document(collection = "SalesRecord")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesRecord implements Serializable {

    static final int MAX_LENGTH_SALESRECORDNUMBER = 6;

    private @Id
    String id;

    private @NonNull
    @Field(name = "SalesRecordNumber")
    @Indexed(unique = true)
    int salesRecordNumber;
    String vehicleSalesRecord = Inventory.getBuilder().getVehicleDescription();
    ;

//    private @Field(name = "VehicleSold")
//    String vehicleSold = customer.getCustomerNumber() + inventory.getVehicleDescription();
//    ***************************************


    double salesCommission = getProfit()*.10;
    private @NonNull @Field(name = "Commissioned")
    boolean commissioned;
    double profit = (Inventory.getBuilder().getVehiclePrice() - Inventory.getBuilder().getPriceOfCar());

    private SalesRecord(Builder builder) {
        this.salesRecordNumber = builder.salesRecordNumber;
        this.salesCommission = builder.getSalesCommission();
        this.commissioned = builder.commissioned;
        this.vehicleSalesRecord = builder.getVehicleSalesRecord();
    }

//    private SalesRecord finishedSalesRecord(Builder builder, Inventory inventory) {
//        this.salesRecordNumber = builder.getSalesRecordNumber();
//
//    }

    static Builder getBuilder() {
        return new Builder();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Builder {

        private int salesRecordNumber;
        private boolean commissioned;
        private String vehicleSalesRecord;
        private double salesCommission;
       // public String finalSalesRecord = Inventory.getVehicleDescription();

        Builder salesCommission(double salesCommission){
            this.salesCommission = salesCommission;
            return this;
        }

        Builder salesRecordNumber(int salesRecordNumber) {
            this.salesRecordNumber = salesRecordNumber;
            return this;
        }

        Builder commissioned(boolean commissioned) {
            this.commissioned = commissioned;
            return this;
        }

        Builder vehicleSalesRecord(String vehicleSalesRecord) {
            this.vehicleSalesRecord = vehicleSalesRecord;
            return this;
        }

        SalesRecord build() {
            SalesRecord build = new SalesRecord(this);

            build.checkSalesRecordNumber(build.getSalesRecordNumber());
            //build.checkCommissioned(build.isCommissioned());
            return build;
        }

    }

        private void checkSalesRecordNumber(int salesRecordNumber) {
            notNull(salesRecordNumber, "Sales Record Number cannot be null");
            notEmpty(String.valueOf(salesRecordNumber), "Sales Record Number cannot be empty");
            isTrue(String.valueOf(salesRecordNumber).length() <= MAX_LENGTH_SALESRECORDNUMBER,
                    "Sales Record Number cannot be longer than %d",
                    MAX_LENGTH_SALESRECORDNUMBER);
        }
    }



    /*processSalesTransaction
    @params -

    return created salesRecord + trigger processSalesCommisssion

     */

    //will contain customer info
    //salesman info
    //and vehicle info
    //as well as price and commission info



