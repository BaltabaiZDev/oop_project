package kz.university.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kz.university.model.User;
import kz.university.storage.DataStorage;

public class UserRepository implements Repository<User> {
    private Map<String, User> users = new LinkedHashMap<>();
    private DataStorage dataStorage;

    public UserRepository(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public void delete(String id) {
        users.remove(id);
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public void saveToFile() {
        dataStorage.saveData(new ArrayList<>(users.values()));
    }

    public void loadFromFile() {
        Object data = dataStorage.loadData();
        if (data instanceof List) {
            users.clear();
            List<?> list = (List<?>) data;
            for (Object item : list) {
                if (item instanceof User) {
                    User user = (User) item;
                    users.put(user.getId(), user);
                }
            }
        }
    }
}
