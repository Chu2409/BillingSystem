package dao;

import dto.Customer;

public interface CustomerDao {
    public boolean insert(Customer customer);

    public boolean delete(String id);

    public boolean update(Customer customer);
}
