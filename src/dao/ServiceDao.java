package dao;

import dto.Service;

public interface ServiceDao {
    public boolean insert(Service service);

    public boolean delete(String id);

    public boolean update(Service service);
}
