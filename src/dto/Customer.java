package dto;

public class Customer {
    private String customerId;
    private int idType;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private String email;

    public Customer(String customerId, int idType, String name, String surname, String address, String phoneNumber,
            String email) {
        this.customerId = customerId;
        this.idType = idType;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", idType=" + idType + ", name=" + name + ", surname="
                + surname + ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email + '}';
    }

}
