package utilities;

import domain.*;
import dto.*;
import java.util.List;

public class Menu {

    public static FacturationSystemManager sm = initializateData();

    public static void mainMenu() {
        int opt;
        do {
            printMainMenu();
            opt = Console.askOption(0, 2);

            switch (opt) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    customerMenu();
                    break;
            }
        } while (opt != 0);
    }

    public static void adminMenu() {
        int opt;
        do {
            printAdminMenu();
            opt = Console.askOption(0, 3);

            switch (opt) {
                case 1:
                    adminCustomerMenu();
                    break;
                case 2:
                    adminProductMenu();
                    break;
                case 3:
                    adminServiceMenu();
                    break;
            }
        } while (opt != 0);
    }

    public static void adminCustomerMenu() {
        int opt;
        do {
            printAdminCustomerMenu();
            opt = Console.askOption(0, 4);

            switch (opt) {
                case 1:
                    sm.insertCustomer();
                    break;
                case 2:
                    adminCustomerUpdateMenu();
                    break;
                case 3:
                    sm.deleteCustomer();
                    break;
                case 4:
                    sm.selectCustomers();
                    break;
            }
        } while (opt != 0);
    }

    public static void adminCustomerUpdateMenu() {
        int opt;
        Customer c = sm.getCustomerById();
        if (c != null) {
            do {
                printAdminCustomerUpdateMenu();
                opt = Console.askOption(0, 6);

                switch (opt) {
                    case 1:
                        c.setIdType(Console.askCustomerIdType());
                        c.setCustomerId(Console.askCustomerId(c.getIdType()));
                        break;
                    case 2:
                        c.setName(Console.askCustomerName());
                        break;
                    case 3:
                        c.setSurname(Console.askCustomerSurname());
                        break;
                    case 4:
                        c.setAddress(Console.askCustomerAddress());
                        break;
                    case 5:
                        c.setPhoneNumber(Console.askCustomerPhoneNumber());
                        break;
                    case 6:
                        c.setEmail(Console.askCustomerEmail());
                        break;
                }
            } while (opt != 0);
        }
    }

    public static void adminProductMenu() {
        int opt;
        do {
            printAdminProductMenu();
            opt = Console.askOption(0, 4);

            switch (opt) {
                case 1:
                    sm.insertProduct();
                    break;
                case 2:
                    adminProductUpdateMenu();
                    break;
                case 3:
                    sm.deleteProduct();
                    break;
                case 4:
                    sm.selectProducts();
                    break;
            }
        } while (opt != 0);
    }

    public static void adminProductUpdateMenu() {
        int opt;
        Product p = sm.getProductById();
        if (p != null) {
            do {
                printAdminProductUpdateMenu();
                opt = Console.askOption(0, 6);

                switch (opt) {
                    case 1:
                        p.setProductId(Console.askProductId());
                        break;
                    case 2:
                        p.setName(Console.askProductName());
                        break;
                    case 3:
                        p.setPrice(Console.askProductPrice());
                        break;
                    case 4:
                        p.setMeasureUnit(Console.askProductMeasureUnit());
                        break;
                    case 5:
                        p.setIva(Console.askProductIva());
                        break;
                    case 6:
                        p.setAmount(Console.askProductAmount());
                        break;
                }
            } while (opt != 0);
        }
    }

    public static void adminServiceMenu() {
        int opt;
        do {
            printAdminServiceMenu();
            opt = Console.askOption(0, 4);

            switch (opt) {
                case 1:
                    sm.insertService();
                    break;
                case 2:
                    adminServiceUpdateMenu();
                    break;
                case 3:
                    sm.deleteService();
                    break;
                case 4:
                    sm.selectServices();
                    break;
            }
        } while (opt != 0);
    }

    public static void adminServiceUpdateMenu() {
        int opt;
        Service s = sm.getServiceById();
        if (s != null) {
            do {
                printAdminServiceUpdateMenu();
                opt = Console.askOption(0, 4);

                switch (opt) {
                    case 1:
                        s.setServiceId(Console.askServiceId());
                        break;
                    case 2:
                        s.setName(Console.askServiceName());
                        break;
                    case 3:
                        s.setPrice(Console.askServicePrice());
                        break;
                    case 4:
                        s.setIva(Console.askServiceIva());
                        break;
                }
            } while (opt != 0);
        }
    }

    public static void customerMenu() {
        int opt;
        BillManager bm = new BillManager(new Bill(sm.getCustomerById(), sm));
        FacturationSystem sAux = new FacturationSystem(sm.getSystem().getProducts());
        boolean bought = false;
        do {
            printCustomerMenu();
            opt = Console.askOption(0, 3);

            switch (opt) {
                case 1:
                    customerProductMenu(bm);
                    break;
                case 2:
                    customerServiceMenu(bm);
                    break;
                case 3:
                    customerBillMenu(bm);
                    bought = true;
                    break;
                case 0:

            }
        } while (opt != 0);

        if (!bought) {
            sm.getSystem().setProducts(sAux.getProducts());
        }
    }

    public static void customerProductMenu(BillManager bm) {
        int opt;
        do {
            sm.selectProducts();
            Message.leaveOption();
            opt = Console.askOption(0, sm.getSystem().getProducts().size());
            if (opt != 0) {
                bm.addProduct(opt - 1);
            }

        } while (opt != 0);
    }

    public static void customerServiceMenu(BillManager bm) {
        int opt;
        do {
            sm.selectServices();
            Message.leaveOption();
            opt = Console.askOption(0, sm.getSystem().getServices().size());
            if (opt != 0) {
                bm.addService(opt - 1);
            }

        } while (opt != 0);
    }

    public static void customerBillMenu(BillManager bm) {
        System.out.println("Se cobro");
    }

    public static void printMainMenu() {
        Message.print(Message.Menu.WELCOME.toString());
        Message.print(Message.Menu.MAIN_OPTIONS.toString());

    }

    public static void printAdminMenu() {
        Message.print(Message.Menu.ADMIN_OPTIONS.toString());
    }

    public static void printAdminCustomerMenu() {
        Message.print(Message.Menu.ADMIN_CUSTOMER_OPTIONS.toString());
    }

    public static void printAdminCustomerUpdateMenu() {
        Message.print(Message.Menu.ADMIN_CUSTOMER_UPDATE_OPTIONS.toString());
    }

    public static void printAdminProductMenu() {
        Message.print(Message.Menu.ADMIN_PRODUCT_OPTIONS.toString());
    }

    public static void printAdminProductUpdateMenu() {
        Message.print(Message.Menu.ADMIN_PRODUCT_UPDATE_OPTIONS.toString());
    }

    public static void printAdminServiceMenu() {
        Message.print(Message.Menu.ADMIN_SERVICE_OPTIONS.toString());
    }

    public static void printAdminServiceUpdateMenu() {
        Message.print(Message.Menu.ADMIN_SERVICE_UPDATE_OPTIONS.toString());
    }

    public static void printCustomerMenu() {
        Message.print(Message.Menu.CUSTOMER_OPTIONS.toString());
    }

    public static FacturationSystemManager initializateData() {
        Product p1 = new Product("1111", "Jabon", 0.89, "u", false, 20);
        Product p2 = new Product("2222", "Arroz", 0.48, "lb", false, 50);
        Product p3 = new Product("3333", "Atun", 1.02, "u", false, 15);
        Product p4 = new Product("4444", "Aceite", 2.41, "lt", true, 10);
        Product p5 = new Product("5555", "Agua", 0.55, "lt", false, 20);
        Product p6 = new Product("6666", "Papel", 0.43, "u", false, 18);

        Service s1 = new Service("1122", "Arreglar aire", 20, true);
        Service s2 = new Service("1133", "Arreglar tuberias", 15, true);
        Service s3 = new Service("1144", "Arreglar impresora", 10, true);
        Service s4 = new Service("1155", "Pintar casa", 100, true);

        Customer c1 = new Customer("0707047643", 1, "Erick Daniel", "Zhu Ordoñez", "Selva Alegre", "0967229875",
                "dzhu2409@gmail.com");
        Customer c2 = new Customer("0703224337", 1, "Danny", "Ordoñez Marquez", "Machala", "0993835324",
                "cyberinteractivo@hotmail.es");
        Customer c3 = new Customer("0703224345", 1, "Doris Giovanna", "Ordoñez Marquez", "Ambato", "0994459401",
                "doris28@hotmail.es");
        Customer c4 = new Customer("1850272582", 1, "Carol Anahi", "Chico Hurtado", "Ambato", "0998551942",
                "cchico259@gmail.com");

        FacturationSystem s = new FacturationSystem();
        s.getProducts().add(p1);
        s.getProducts().add(p2);
        s.getProducts().add(p3);
        s.getProducts().add(p4);
        s.getProducts().add(p5);
        s.getProducts().add(p6);

        s.getServices().add(s1);
        s.getServices().add(s2);
        s.getServices().add(s3);
        s.getServices().add(s4);

        s.getCustomers().add(c1);
        s.getCustomers().add(c2);
        s.getCustomers().add(c3);
        s.getCustomers().add(c4);

        return new FacturationSystemManager(s);
    }

}
