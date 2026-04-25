package kz.university.storage;

public interface DataStorage {
    void saveData(Object data);
    Object loadData();
}
