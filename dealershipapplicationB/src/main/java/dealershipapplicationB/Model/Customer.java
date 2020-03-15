package dealershipapplicationB.Model;


import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import static dealershipapplicationB.Utility.PreCondition.*;

@EntityScan
@Validated
@Document(collection = "Customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {


    static final int MAX_LENGTH_CUSTOMERNAME = 500;
    static final int MAX_LENGTH_EMAIL = 100;
    static final int MAX_LENGTH_CUSTOMERNUMBER = 10;

    private @Id String id; //will be set when persisting

    //AtomicSequenceGenerator will be sequentially distinct but auto generated
    private @NonNull @Field(name = "FirstName") String customerFirstName;
    private @NonNull @Field(name = "LastName") String customerLastName;
    private @Field(name = "Address") String customerAddress;
    private @Field(name = "City") String customerCity;
    private @Field(name = "State") String customerState;
    private @Field(name = "Email") @Email(message = "(errors.invalid_email)") String customerEmail;
    private @Field(name = "DateOfVisit") String dateOfVisit = getNow();
    private @Field(name = "PhoneNumber") int customerPhoneNumber;
    private @Field(name = "COH") Double customerCashOnHand; //COH Logic
    private String customerName = getCustomerName();
    private int customerNumber = getCustomerNumber();
    private @Field(name = "UserName") String userName;
    private @Field(name = "Password") String passWord;
    //private double loanAmount = dealership.getLoanAmount();

//    public int getCustomerNumber() {
//        this.customerNumber = getId();
//        return customerNumber;
//    }

    String getNow() {
        Date now = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd.hhmmss");
        return sdf.format(now);
    }

    public String getCustomerName() {
        return (customerLastName + ", " + customerFirstName);
    }

    private Customer(Builder builder) {

        this.customerName = builder.getCustomerName();
        this.dateOfVisit = builder.getDateOfVisit();
        this.customerNumber = builder.customerNumber;
        this.customerAddress = builder.customerAddress;
        this.customerCity = builder.customerCity;
        this.customerState = builder.customerState;
        this.customerEmail = builder.customerEmail;
        this.customerCashOnHand = builder.customerCashOnHand;
        this.userName = builder.userName;
        this.passWord = builder.passWord;

    }

    static Builder getBuilder() {
        return new Builder();
    }

//    public void customerNumberLength(int customerNumber) {
//        checkCustomerNumber(customerNumber);
//
//        this.customerNumber = customerNumber;
//    }

    public void update(String customerName, String customerEmail) {
        checkCustomerNumber(customerNumber);

        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Builder {

        private String customerName;
        private String customerAddress;
        private String customerCity;
        private String customerState;
        private String customerEmail;
        private double customerCashOnHand;
        private String dateOfVisit;
        private int customerNumber;
        private String userName;
        private String passWord;

        Builder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        Builder customerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
            return this;
        }

        Builder customerCity(String customerCity) {
            this.customerCity = customerCity;
            return this;
        }

        Builder customerState(String customerState) {
            this.customerState = customerState;
            return this;
        }

        Builder customerEmail (String customerEmail) {
            this.customerEmail = customerEmail;
            return this;
        }

        Builder customerCashOnHand (double customerCashOnHand) {
            this.customerCashOnHand = customerCashOnHand;
            return this;
        }

        Builder dateOfVisit (String dateOfVisit) {
            this.dateOfVisit = dateOfVisit;
            return this;
        }

        Builder customerNumber (int customerNumber) {
            this.customerNumber = customerNumber;
            return this;
        }

        Builder userName (String userName) {
            this.userName = userName;
            return this;
        }

        Builder passWord (String passWord) {
            this.passWord = passWord;
            return this;
        }

        Customer build() {
            Customer build = new Customer(this);

            build.checkCustomerNumber(build.getCustomerNumber());
            build.checkCustomerEmail(build.getCustomerEmail());
            return build;
        }
    }
    private void checkCustomerNumber(int customerNumber) {
        notNull(customerNumber, "Customer Number cannot be null");
        notEmpty(String.valueOf(customerNumber), "Customer Number cannot be empty");
        isTrue(String.valueOf(customerNumber).length() <= MAX_LENGTH_CUSTOMERNUMBER,
                "Customer Number cannot be longer than %d",
                MAX_LENGTH_CUSTOMERNUMBER);
    }

//    private void checkCustomerName(String customerName) {
//        notNull(customerName, "Customer Name cannot be null");
//        notEmpty(String.valueOf(customerName), "Customer Name cannot be empty");
//        isTrue(String.valueOf(customerName).length() <= MAX_LENGTH_CUSTOMERNAME,
//                "Customer Name cannot be longer than %d",
//                MAX_LENGTH_CUSTOMERNAME);
//    }
//
    private void checkCustomerEmail(String customerEmail) {
        notNull(customerEmail, "Customer Email cannot be null");
        notEmpty(customerEmail, "Employee Email cannot be empty");
        isTrue(customerEmail.length() <= MAX_LENGTH_EMAIL,
                "Customer Email cannot be longer than %d characters",
                MAX_LENGTH_EMAIL
        );

        if (customerEmail != null) {
            isTrue(customerEmail.length() <= MAX_LENGTH_EMAIL,
                    "Employee Name cannot be longer than %d characters",
                    MAX_LENGTH_EMAIL
            );
        }
    }
}