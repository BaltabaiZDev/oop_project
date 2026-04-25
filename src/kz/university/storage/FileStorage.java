package kz.university.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileStorage implements DataStorage {
    private String fileName;

    public FileStorage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void saveData(Object data) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(data);
        } catch (Exception e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }

    @Override
    public Object loadData() {
        File file = new File(fileName);
        if (!file.exists()) {
            return null;
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return in.readObject();
        } catch (Exception e) {
            System.out.println("Load error: " + e.getMessage());
            return null;
        }
    }
}
