package controls;

public class Control {

    public static boolean validateIdCard(String idCard) {
        boolean correctId = false;
        try {
            if (idCard.length() == 10) {
                int tercerDigito = Integer.parseInt(idCard.substring(2, 3));
                if (tercerDigito < 6) {
                    int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
                    int verificador = Integer.parseInt(idCard.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (idCard.length() - 1); i++) {
                        digito = Integer.parseInt(idCard.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        correctId = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        correctId = true;
                    } else {
                        correctId = false;
                    }
                } else {
                    correctId = false;
                }
            } else {
                correctId = false;
            }
        } catch (NumberFormatException nfe) {
            correctId = false;
        } catch (Exception err) {
            correctId = false;
        }
        return correctId;
    }

    public static boolean validateRuc(String ruc) {
        String rucPattern = "[0-9]{10}(001$)";

        ruc = ruc.trim();
        try {
            if (ruc.toLowerCase().matches(rucPattern)) {
                String idCard = ruc.substring(0, 10);
                return validateIdCard(idCard);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validateName(String name) {
        String namePattern = "[a-zñ]{2,}(\\s[a-zñ]{2,})*";
        name = name.trim();
        try {
            if (name.toLowerCase().matches(namePattern)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validateSurname(String surname) {
        String surnamePattern = "[a-zñ]{2,}([ '-][a-zñ]{2,})+";
        surname = surname.trim();
        try {
            if (surname.toLowerCase().matches(surnamePattern)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validateAddress(String address) {
        String addressPattern = "[a-zñ0-9]+(\\s[a-zñ0-9]+)*";
        address = address.trim();
        try {
            if (address.toLowerCase().matches(addressPattern)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        String phoneNumberPattern = "(09)\\d{8}";
        phoneNumber = phoneNumber.trim();
        try {
            if (phoneNumber.toLowerCase().matches(phoneNumberPattern)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validateEmail(String email) {
        String emailPattern = "([a-z0-9]+[!#$%&'*/=?^_+-`{|}~]?(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+";
        email = email.trim();
        try {
            if (email.toLowerCase().matches(emailPattern)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validateProductServiceId(String productServiceId) {
        String productServicePattern = "[0-9]{4}";
        productServiceId = productServiceId.trim();
        try {
            if (productServiceId.toLowerCase().matches(productServicePattern)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validatePrice(String price) {
        String pricePattern = "\\d+(\\.\\d{1,3})?";
        price = price.trim();
        try {
            if (price.toLowerCase().matches(pricePattern)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validateMeasureUnit(String measureUnit) {
        String measureUnitPattern = "[a-z]+";
        measureUnit = measureUnit.trim();
        try {
            if (measureUnit.toLowerCase().matches(measureUnitPattern)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean validateAmount(String amount) {
        String amountPattern = "[0-9]{0,5}";
        amount = amount.trim();
        try {
            if (amount.toLowerCase().matches(amountPattern)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validateOptions(String mainOption, int initialOpt, int finalOpt) {
        String maintOptionPattern = "[" + initialOpt + "-" + finalOpt + "]";
        mainOption = mainOption.trim();
        try {
            if (mainOption.toLowerCase().matches(maintOptionPattern)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

}
