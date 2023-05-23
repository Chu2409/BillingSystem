package dao;

import dto.Product;

public interface ProductDao {
    public boolean insert(Product product);

    public boolean delete(String id);

    public boolean update(Product product);
}
