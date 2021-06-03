package model.service;

import model.domain.Flower;
import java.io.*;
import java.util.Date;
import java.util.List;

public class FileIO {

    public static final String FILE_NAME = "data.txt";
    public static final String OUTER = "Updated: ";
    public static final String LOG_FILE = "log.txt";
    
    public void writeFile(String text) throws IOException {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(OUTER + new Date().toString() + "\n" + text + "\n");
            writer.flush();
        }
    }

    public  List<Flower> readFlowersArray() throws IOException, ClassNotFoundException {
        List<Flower> flowers;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            flowers = (List<Flower>) inputStream.readObject();
        }
        return flowers;
    }

    public void saveChanges(List<Flower> flowers) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            outputStream.writeObject(flowers);
        }
    }
}
