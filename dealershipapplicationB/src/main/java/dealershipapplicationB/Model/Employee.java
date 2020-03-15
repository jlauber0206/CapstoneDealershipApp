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

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import static dealershipapplicationB.Utility.PreCondition.*;

@EntityScan
@Validated
@Document(collection = "Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    //EmployeeRepo employeeRepo;

    static final int MAX_LENGTH_EMPLOYEENAME = 100;
    static final int MAX_LENGTH_TITLE = 500;
    static final int MAX_LENGTH_NUMBER = 9;

    private @Id
    String id; //will be set when persisting

    //Java 8 time to compare two dates for year
    private //UUID class
    @NonNull
    @Field(name = "EmployeeNumber")
    @Indexed(unique = true)
    int employeeNumber;//AtomicSequenceGenerator will be sequentially distinct but auto generated
    @Size(min=3, max=20)
    private @NonNull @Field(name = "FirstName")
    String employeeFirstName;
    @Size(min=3, max=30)
    private @NonNull @Field(name = "LastName")
    String employeeLastName;
    @Size(min=4, max=30)
    private @Field(name = "Title")
    String employeeTitle;
    private @Field(name = "Address")
    String employeeAddress;
    private @Field(name = "Age")
    int employeeAge;
    private @Field(name = "DOH")
    String dateOfHire = getNow();
//    private @Field(name = "Senority")
//    String employeeSenority = getSenority(); //senority logic
    private @Field(name = "Wallet")
    double employeeWallet; //employee wallet logic
    private String employeeName = getEmployeeName();


    private Employee(Builder builder) {
        this.employeeNumber = builder.getEmployeeNumber();
        this.employeeName = builder.getEmployeeName();
        this.employeeTitle = builder.employeeTitle;
        this.employeeAddress = builder.employeeAddress;
        this.employeeAge = builder.employeeAge;
        //this.employeeSenority = builder.employeeSenority;
        this.employeeWallet = builder.employeeWallet;
        this.dateOfHire = builder.dateOfHire;

    }

    public Employee employeeList(Builder builder) {
        //this.employeeNumber = builder.getEmployeeNumber();
        //this.employeeName = builder.getEmployeeName();
        this.employeeFirstName = builder.getEmployeeFirstName();
        this.employeeLastName = builder.getEmployeeLastName();
        this.employeeTitle = builder.employeeTitle;
        this.employeeAge = builder.employeeAge;
        this.employeeAddress = builder.employeeAddress;

        return employeeList(builder);

    }

    public String getEmployeeName() {
        return (employeeLastName + ", " + employeeFirstName);
    }

    public String getNow() {
        Date now = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd.hhmmss");
        return sdf.format(now);
    }

//    String getSenority() {
//        //current date - date of hire
//        String dateOfHire = getDateOfHire();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd.hh:mm:ss");
//        LocalDate now = LocalDate.now();
//
//
//        Date diff = daysBetween(dateOfHire, now);
//
//        return sdf.format(diff);
//    }
//
//    private static long daysBetween(Date one, Date two) {
//        long difference = ((two.getTime()-one.getTime())/86400000)/365;
//        return Math.abs(difference);
//    }

    static Builder getBuilder() {
        return new Builder();
    }

    public void update(Employee employee) {
        checkEmployeeTitleAndEmployeeName(employeeTitle, employeeName);

        this.employeeTitle = employeeTitle;
        this.employeeName = employeeName;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Builder {

        private String employeeTitle;
        private String employeeName;
        private int employeeNumber;
        private String employeeAddress;
        private int employeeAge;
        private String employeeSenority;
        private double employeeWallet;
        private String dateOfHire;
        private String employeeFirstName;
        private String employeeLastName;

        Employee build() {
            Employee build = new Employee(this);

            build.checkEmployeeTitleAndEmployeeName(build.getEmployeeTitle(), build.getEmployeeName());
            build.checkEmployeeNumber(build.getEmployeeNumber());
            return build;
        }
    }

    private void checkEmployeeNumber(int employeeNumber) {
        notNull(employeeNumber, "Employee Number cannot be null");
        notEmpty(String.valueOf(employeeNumber), "Employee Number cannot be empty");
        isTrue(String.valueOf(employeeNumber).length() <= MAX_LENGTH_NUMBER,
                "Employee Number cannot be longer than %d",
                MAX_LENGTH_NUMBER);
    }

    private void checkEmployeeTitleAndEmployeeName(String employeeTitle, String employeeName) {
        notNull(employeeTitle, "Employee Title cannot be null");
        notEmpty(employeeTitle, "Employee Title cannot be empty");
        isTrue(employeeTitle.length() <= MAX_LENGTH_TITLE,
                "Employee Title cannot be longer than %d characters",
                MAX_LENGTH_TITLE);

        if (employeeName != null) {
            isTrue(employeeName.length() <= MAX_LENGTH_EMPLOYEENAME,
                    "Employee Name cannot be longer than %d characters",
                    MAX_LENGTH_EMPLOYEENAME);
        }
    }
}




