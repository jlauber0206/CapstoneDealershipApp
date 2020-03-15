package dealershipapplicationB.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

import static dealershipapplicationB.Utility.PreCondition.*;

@EntityScan
@Validated
@Document(collection = "Inventory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory implements Serializable {

    static final int MAX_LENGTH_VEHICLENAME = 100;
    static final int MAX_LENGTH_DESCRIPTION = 500;
    static final int MAX_LENGTH_VEHICLENUMBER = 9;
    static final int MAX_LENGTH_YEAR = 4;

    private
    @Id
    String id;

    private //@NotBlank(message = "Vehicle Number is Mandatory")
    @Field(name = "VehicleNumber")
    int vehicleNumber;
    private
    @Field(name = "Year")
    int year;
    private
    @Field(name = "Color")
    String color;
    private
    @Field(name = "Make")
    String make;
    private
    @Field(name = "Model")
    String modelOfCar;
    private
    @Field(name = "Inventory")
    Boolean inInventory;
    private
    @Field(name = "Available")
    Boolean availableForOrder;
    private
    @Field(name = "InventoryPrice")
    double vehiclePrice;
    private
    @Field(name = "SalesPrice")
    double priceOfCar = salesPriceOfCar();
    private
    @CreatedDate
    LocalDate createdDate;

    public double salesPriceOfCar() {
        System.out.print(priceOfCar);
        return (getVehiclePrice() + ((getVehiclePrice() * 0.15)));
    }

    public String vehicleDescription = getVehicleDescription();

    private Inventory(Builder builder) {
        this.id = builder.id;
        this.vehicleDescription = builder.vehicleDescription;
        this.vehicleNumber = builder.vehicleNumber;
        //this.vehicleName = builder.vehicleName;
        this.year = builder.year;
        this.color = builder.color;
        this.modelOfCar = builder.modelOfCar;
        this.make = builder.make;
        this.inInventory = builder.inInventory;
        this.availableForOrder = builder.availableForOrder;
        this.vehiclePrice = builder.vehiclePrice;
        this.priceOfCar = builder.getPriceOfCar();//priceOfCar
    }

    public String getVehicleDescription() {
        return (year + ", " + make + ", " + modelOfCar + ", " + color + ", " + salesPriceOfCar());
    }

    static Builder getBuilder() {
        return new Builder();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Builder {

        private String id;
        private String vehicleDescription = getVehicleDescription();
        private int vehicleNumber;
        private String vehicleName;
        @Size(min = 4, max = 4)
        private int year;
        private String color;
        private String modelOfCar;
        private String make;
        private Boolean inInventory;
        private Boolean availableForOrder;
        private double vehiclePrice;
        private double priceOfCar;

        Inventory build() {
            Inventory build = new Inventory(this);
            build.checkDescription(build.getVehicleDescription());
            build.checkVehicleNumber(build.getVehicleNumber());
            build.checkYear(build.getYear());

            return build;
        }

    }

    private void checkDescription(String vehicleDescription) {
        notNull(vehicleDescription, "Vehicle Description cannot be null");
        notEmpty(String.valueOf(vehicleDescription), "Vehicle Description cannot be empty");
        isTrue(vehicleDescription.length() <= MAX_LENGTH_DESCRIPTION,
                "Vehicle Description cannot be longer than %d",
                MAX_LENGTH_DESCRIPTION);
    }

//    private void checkVehicleName(String vehicleName) {
//        notNull(vehicleName, "Vehicle Name cannot be null");
//        notEmpty(vehicleName, "Vehicle Name cannot be empty");
//        isTrue(vehicleName.length() <= MAX_LENGTH_VEHICLENAME,
//                "Vehicle Name cannot be longer than %d characters",
//                MAX_LENGTH_VEHICLENAME);
//    }

    private void checkYear(int year) {
        notNull(String.valueOf(year), "Year cannot be null");
        notEmpty(String.valueOf(year), "Year cannot be empty");
        isTrue(String.valueOf(year).length() <= MAX_LENGTH_YEAR,
                "Year cannot be longer than %d",
                MAX_LENGTH_YEAR);
    }

    private void checkVehicleNumber(int vehicleNumber) {
        notNull(String.valueOf(vehicleNumber), "Vehicle Number cannot be null");
        notEmpty(String.valueOf(vehicleNumber), "Vehicle Number cannot be empty");
        isTrue(String.valueOf(vehicleNumber).length() <= MAX_LENGTH_VEHICLENUMBER,
                "Vehicle Number cannot be longer than %d",
                MAX_LENGTH_VEHICLENUMBER);
    }
}
