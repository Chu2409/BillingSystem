package utilities;

public class Message {

    public static void enter(String ms) {
        System.out.print("Ingrese " + ms + ": ");
    }

    public static void enterByOption(String ms) {
        System.out.print("Ingrese " + ms);
        System.out.print("Ingrese la opcion: ");
    }

    public static void print(String ms) {
        System.out.println("\n" + ms);
    }

    public static void enterOption() {
        System.out.print("Ingrese la opcion: ");
    }

    public static void leaveOption() {
        System.out.println("0: Salir");
    }

    public static void printBillHeader(dto.Customer c) {
        System.out.println(
                "\n---------------------------------------------------------FACTURA----------------------------------------------------------");
        System.out.println(c.getName() + " " + c.getSurname() + "\n" + c.getPhoneNumber() + "\n" + c.getEmail());
    }

    public static void printBillData() {
        System.out.println("Producto/Servicio\t\t\t\tPrecio\t\tCantidad\t\tSubtotal\t\tIVA\t\tTotal");
    }

    public static void printBillProducts(String name, double price, int amount, double subtotal, boolean iva,
            double total) {
        String ivaP = iva ? "12%" : "0%";
        System.out.println(name + "\t\t\t\t\t\t" + price + "\t\t" + amount + "\t\t\t" + subtotal + "\t\t\t" + ivaP
                + "\t\t" + total);
    }

    public static void printBillServices(String name, double price, double subtotal, boolean iva, double total) {
        String ivaP = iva ? "12%" : "0%";
        System.out.println(
                name + "\t\t\t\t" + price + "\t\t" + "----" + "\t\t\t" + subtotal + "\t\t\t" + ivaP + "\t\t" + total);
    }

    public static void printFinalBill(double subtotal, double total) {
        System.out.println("\nSubtotal: " + subtotal);
        System.out.println("Total: " + total);
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------");
    }

    public static enum Product {
        PRODUCT_ENTERED("El producto ha sido ingresado correctamente"),
        PRODUCT_EXISTING("El producto ya esta registrado en el sistema"),
        PRODUCT_UPDATED("El producto ha sido actualizado correctamente"),
        PRODUCT_DELETED("El producto ha sido eliminado correctamente"),
        PRODUCT_ERROR("Ha ocurrido un error"),
        PRODUCT_NOTFOUND("No existe producto registrado con el id ingresado"),
        PRODUCT_ID("id del producto (4 numeros)"),
        PRODUCT_NAME("nombre del producto"),
        PRODUCT_PRICE("precio del producto"),
        PRODUCT_MEASURE_UNIT("unidad de medida del producto"),
        PRODUCT_IVA("si aplica iva\n1: Si\n2: No\n"),
        PRODUCT_AMOUNT("cantidad del producto"),
        PRODUCT_ADDED("El producto ha sido añadido al carrito"),;

        private String ms;

        Product(String ms) {
            this.ms = ms;
        }

        @Override
        public String toString() {
            return ms;
        }

    }

    public static enum Service {
        SERVICE_ENTERED("El servicio ha sido ingresado correctamente"),
        SERVICE_EXISTING("El servicio ya esta registrado en el sistema"),
        SERVICE_UPDATED("El servicio ha sido actualizado correctamente"),
        SERVICE_DELETED("El servicio ha sido eliminado correctamente"),
        SERVICE_NOTFOUND("No existe servicio registrado con el id ingresado"),
        SERVICE_ERROR("Ha ocurrido un error"),
        SERVICE_ID("id del servicio (4 numeros)"),
        SERVICE_NAME("nombre del servicio"),
        SERVICE_PRICE("precio del servicio"),
        SERVICE_IVA("si aplica iva\n1: Si\n2: No\n"),
        SERVICE_ADDED("El servicio ha sido añadido"),;

        private String ms;

        Service(String ms) {
            this.ms = ms;
        }

        @Override
        public String toString() {
            return ms;
        }

    }

    public static enum Customer {
        CUSTOMER_ENTERED("El cliente ha sido ingresado correctamente"),
        CUSTOMER_EXISTING("El cliente ya esta registrado en el sistema"),
        CUSTOMER_UPDATED("El cliente ha sido actualizado correctamente"),
        CUSTOMER_DELETED("El cliente ha sido eliminado correctamente"),
        CUSTOMER_ERROR("Ha ocurrido un error"),
        CUSTOMER_NOTFOUND("No existe cliente registrado con el id ingresado"),
        CUSTOMER_ID("id del cliente"),
        CUSTOMER_ID_TYPE("tipo de identificacion\n1: Cedula\n2: RUC\n"),
        CUSTOMER_NAME("nombre del cliente"),
        CUSTOMER_SURNAME("apellidos del cliente"),
        CUSTOMER_ADDRESS("direccion del cliente"),
        CUSTOMER_PHONE_NUMBER("numero de telefono del cliente"),
        CUSTOMER_EMAIL("email del cliente"),;

        private String ms;

        Customer(String ms) {
            this.ms = ms;
        }

        @Override
        public String toString() {
            return ms;
        }
    }

    public static enum Menu {
        WELCOME("************BIENVENIDO AL SISTEMA DE FACTURACION************"),
        MAIN_OPTIONS(
                "\n********************\nOpciones del sistema\n1: Administrador\n2: Cliente\n0: Salir\n********************"),
        ADMIN_OPTIONS(
                "\n**************************\nOpciones de administracion\n1: Cliente\n2: Producto\n3: Servicio\n0: Salir\n**************************"),
        ADMIN_CUSTOMER_OPTIONS(
                "\n**************************************\nOpciones de administracion de clientes\n1: Ingresar cliente\n2: Modificar cliente\n3: Eliminar cliente\n4: Revisar clientes\n0: Salir\n**************************************"),
        ADMIN_CUSTOMER_UPDATE_OPTIONS(
                "\n1: Identifacion - Tipo de identificacion\n2: Nombre\n3: Apellido\n4: Direccion\n5: Numero de telefono\n6: Email\n0: Salir\n***************************************"),
        ADMIN_PRODUCT_OPTIONS(
                "\n***************************************\nOpciones de administracion de productos\n1: Ingresar producto\n2: Modificar producto\n3: Eliminar producto\n4: Revisar productos\n0: Salir\n***************************************"),
        ADMIN_PRODUCT_UPDATE_OPTIONS(
                "1: Id\n2: Nombre\n3: Precio\n4: Unidad de medida\n5: Iva\n6: Cantidad\n0: Salir"),
        ADMIN_SERVICE_OPTIONS(
                "\n***************************************\nOpciones de administracion de servicios\n1: Ingresar servicio\n2: Modificar servicio\n3: Eliminar servicio\n4: Revisar servicios\n0: Salir\n***************************************"),
        ADMIN_SERVICE_UPDATE_OPTIONS(
                "1: Id\n2: Nombre\n3: Precio\n4: Iva\n0: Salir"),
        CUSTOMER_OPTIONS(
                "\n********************\nOpciones del cliente\n1: Comprar producto\n2: Adquirir servicio\n3: Facturar\n0: Salir\n********************"),;

        private String ms;

        Menu(String ms) {
            this.ms = ms;
        }

        @Override
        public String toString() {
            return ms;
        }
    }
}
