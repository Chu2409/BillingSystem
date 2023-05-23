package dao;

import dto.Customer;
import java.util.List;

public interface CustomerDao {
    public boolean insert(Customer customer);

    public boolean delete(String id);

    public boolean update(Customer customer);
}
