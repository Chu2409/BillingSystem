package dao;

import dto.Product;
import java.util.List;

public interface ProductDao {
    public boolean insert(Product product);

    public boolean delete(String id);

    public boolean update(Product product);
}
