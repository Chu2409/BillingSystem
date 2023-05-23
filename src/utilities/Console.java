package utilities;

import controls.Control;
import dto.*;
import java.util.Scanner;

public class Console {

    private static Scanner readString = new Scanner(System.in);
    private static Scanner readInt = new Scanner(System.in);
    private static Scanner readDouble = new Scanner(System.in);

    public static String askCustomerId(int idType) {
        try {
            Message.enter(Message.Customer.CUSTOMER_ID.toString());
            String customerId = readString.nextLine();
            if (idType == 1) {
                if (Control.validateIdCard(customerId)) {
                    return customerId;
                }
                return askCustomerId(idType);
            }
            if (Control.validateRuc(customerId)) {
                return customerId;
            }
            return askCustomerId(idType);
        } catch (Exception e) {
            return askCustomerId(idType);
        }
    }

    public static String askCustomerId() {
        try {
            Message.enter(Message.Customer.CUSTOMER_ID.toString());
            String customerId = readString.nextLine();
            if (Control.validateIdCard(customerId) || Control.validateRuc(customerId)) {
                return customerId;
            }
            return askCustomerId();
        } catch (Exception e) {
            return askCustomerId();
        }
    }

    public static int askCustomerIdType() {
        try {
            Message.enterByOption(Message.Customer.CUSTOMER_ID_TYPE.toString());
            int idType = readInt.nextInt();
            if (Control.validateOptions(String.valueOf(idType), 1, 2)) {
                return idType;
            }
            return askCustomerIdType();
        } catch (Exception e) {
            readInt.next();
            return askCustomerIdType();
        }
    }

    public static String askCustomerName() {
        try {
            Message.enter(Message.Customer.CUSTOMER_NAME.toString());
            String name = readString.nextLine();
            if (Control.validateName(name)) {
                return name;
            }
            return askCustomerName();
        } catch (Exception e) {
            return askCustomerName();
        }
    }

    public static String askCustomerSurname() {
        try {
            Message.enter(Message.Customer.CUSTOMER_SURNAME.toString());
            String surname = readString.nextLine();
            if (Control.validateSurname(surname)) {
                return surname;
            }
            return askCustomerSurname();
        } catch (Exception e) {
            return askCustomerSurname();
        }
    }

    public static String askCustomerAddress() {
        try {
            Message.enter(Message.Customer.CUSTOMER_ADDRESS.toString());
            String address = readString.nextLine();
            if (Control.validateAddress(address)) {
                return address;
            }
            return askCustomerAddress();
        } catch (Exception e) {
            return askCustomerAddress();
        }
    }

    public static String askCustomerPhoneNumber() {
        try {
            Message.enter(Message.Customer.CUSTOMER_PHONE_NUMBER.toString());
            String phoneNumer = readString.nextLine();
            if (Control.validatePhoneNumber(phoneNumer)) {
                return phoneNumer;
            }
            return askCustomerPhoneNumber();
        } catch (Exception e) {
            return askCustomerPhoneNumber();
        }
    }

    public static String askCustomerEmail() {
        try {
            Message.enter(Message.Customer.CUSTOMER_EMAIL.toString());
            String email = readString.nextLine();
            if (Control.validateEmail(email)) {
                return email;
            }
            return askCustomerEmail();
        } catch (Exception e) {
            return askCustomerEmail();
        }
    }

    public static Customer askCustomer() {
        int newCustomerIdType = askCustomerIdType();
        String newCustomerId = askCustomerId(newCustomerIdType);
        String newCustomerName = askCustomerName();
        String newCustomerSurname = askCustomerSurname();
        String newCustomerAddress = askCustomerAddress();
        String newCustomerPhoneNumber = askCustomerPhoneNumber();
        String newCustomerEmail = askCustomerEmail();
        return new Customer(newCustomerId, newCustomerIdType, newCustomerName, newCustomerSurname, newCustomerAddress,
                newCustomerPhoneNumber, newCustomerEmail);
    }

    public static String askProductId() {
        try {
            Message.enter(Message.Product.PRODUCT_ID.toString());
            String productId = readString.nextLine();
            if (Control.validateProductServiceId(productId)) {
                return productId;
            }
            return askProductId();
        } catch (Exception e) {
            return askProductId();
        }
    }

    public static String askProductName() {
        try {
            Message.enter(Message.Product.PRODUCT_NAME.toString());
            String productName = readString.nextLine();
            if (Control.validateName(productName)) {
                return productName;
            }
            return askProductName();
        } catch (Exception e) {
            return askProductName();
        }
    }

    public static double askProductPrice() {
        try {
            Message.enter(Message.Product.PRODUCT_PRICE.toString());
            double productPrice = readDouble.nextDouble();
            if (Control.validatePrice(String.valueOf(productPrice))) {
                return productPrice;
            }
            return askProductPrice();
        } catch (Exception e) {
            readDouble.next();
            return askProductPrice();
        }
    }

    public static String askProductMeasureUnit() {
        try {
            Message.enter(Message.Product.PRODUCT_MEASURE_UNIT.toString());
            String measureUnit = readString.nextLine();
            if (Control.validateMeasureUnit(measureUnit)) {
                return measureUnit;
            }
            return askProductMeasureUnit();
        } catch (Exception e) {
            return askProductMeasureUnit();
        }
    }

    public static boolean askProductIva() {
        try {
            Message.enterByOption(Message.Product.PRODUCT_IVA.toString());
            int productIva = readInt.nextInt();
            if (Control.validateOptions(String.valueOf(productIva), 1, 2)) {
                if (productIva == 1) {
                    return true;
                }
                return false;
            }
            return askProductIva();
        } catch (Exception e) {
            readInt.next();
            return askProductIva();
        }
    }
    
    public static int askProductAmount() {
        try {
            Message.enter(Message.Product.PRODUCT_AMOUNT.toString());
            int productAmount = readInt.nextInt();
            if (Control.validateAmount(String.valueOf(productAmount))) {
                return productAmount;
            }
            return askProductAmount();
        } catch (Exception e) {
            readInt.next();
            return askProductAmount();
        }
    }

    public static Product askProduct() {
        String newProductId = askProductId();
        String newProductName = askProductName();
        double newProductPrice = askProductPrice();
        String newProductMeasureUnit = askProductMeasureUnit();
        boolean newProductIva = askProductIva();
        int newAmount = askProductAmount();
        return new Product(newProductId, newProductName, newProductPrice, newProductMeasureUnit, newProductIva, newAmount);
    }

    public static String askServiceId() {
        try {
            Message.enter(Message.Service.SERVICE_ID.toString());
            String serviceId = readString.nextLine();
            if (Control.validateProductServiceId(serviceId)) {
                return serviceId;
            }
            return askServiceId();
        } catch (Exception e) {
            return askServiceId();
        }
    }

    public static String askServiceName() {
        try {
            Message.enter(Message.Service.SERVICE_NAME.toString());
            String serviceName = readString.nextLine();
            if (Control.validateName(serviceName)) {
                return serviceName;
            }
            return askServiceName();
        } catch (Exception e) {
            return askServiceName();
        }
    }

    public static double askServicePrice() {
        try {
            Message.enter(Message.Service.SERVICE_PRICE.toString());
            double servicePrice = readDouble.nextDouble();
            if (Control.validatePrice(String.valueOf(servicePrice))) {
                return servicePrice;
            }
            return askServicePrice();
        } catch (Exception e) {
            readDouble.next();
            return askServicePrice();
        }
    }

    public static boolean askServiceIva() {
        try {
            Message.enterByOption(Message.Service.SERVICE_IVA.toString());
            int iva = readInt.nextInt();
            if (Control.validateOptions(String.valueOf(iva), 1, 2)) {
                if (iva == 1) {
                    return true;
                }
                return false;
            }
            return askServiceIva();
        } catch (Exception e) {
            readInt.next();
            return askServiceIva();
        }
    }

    public static Service askService() {
        String newserviceId = askServiceId();
        String newServiceName = askServiceName();
        double newServicePrice = askServicePrice();
        boolean newServiceIva = askServiceIva();
        return new Service(newserviceId, newServiceName, newServicePrice, newServiceIva);
    }

    public static int askOption(int initialOpt, int finalOpt) {
        try {
            Message.enterOption();
            int option = readInt.nextInt();
            if (Control.validateOptions(String.valueOf(option), initialOpt, finalOpt)) {
                return option;
            }
            return askOption(initialOpt, finalOpt);
        } catch (Exception e) {
            readInt.next();
            return askOption(initialOpt, finalOpt);
        }
    }

}
