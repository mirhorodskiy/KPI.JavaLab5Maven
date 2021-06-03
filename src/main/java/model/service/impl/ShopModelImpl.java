package model.service.impl;

import model.domain.Flower;
import model.service.FileIO;
import model.service.ShopModel;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopModelImpl implements ShopModel {

    private final FileIO fileIO = new FileIO();
    private List<Flower> flowers;

//    public void writeFile(String text) throws IOException {
//        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
//            writer.write(OUTER + new Date().toString() + "\n" + text + "\n");
//            writer.flush();
//        }
//    }
//
//    public void readFlowersArray() throws Exception {
//        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
//            flowers = (List<Flower>) inputStream.readObject();
//        }
//    }
//
//    public void saveChanges() throws IOException {
//        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
//            outputStream.writeObject(flowers);
//        }
//    }

    public ShopModelImpl() throws IOException, ClassNotFoundException {
        this.flowers = fileIO.readFlowersArray();
        //this.flowers = new ArrayList<>();
    }

    public void writeFile(String text) throws IOException {
        fileIO.writeFile(text);
    }


    public void saveChanges(List<Flower> flowers) throws IOException {
        fileIO.saveChanges(flowers);
    }


    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public String getFloweringIndoorFlowersAndPrices() {
        StringBuilder builder = new StringBuilder();
        for (Flower flower : flowers) {
            if (flower.getType().equals("indoor") && flower.getSpecies().equals("flowering")) {
                builder.append("Type: ")
                        .append(flower.getTitle())
                        .append(", price: ")
                        .append(flower.getPrice())
                        .append("\n");
            }
        }
        return builder.toString();
    }

    public String getSubspeciesAndCountsOfFlower(String flowerName) {
        StringBuilder builder = new StringBuilder();
        for (Flower flower : flowers) {
            if (flower.getTitle().equals(flowerName)) {
                builder.append("Subspecies: ")
                        .append(flower.getSubspecies())
                        .append(", count: ")
                        .append(flower.getCount())
                        .append("\n");
            }
        }
        return builder.toString();
    }

    public String getListOfFlowers() {
        StringBuilder builder = new StringBuilder();
        for (Flower flower : flowers) {
            builder.append(flower.toString()).append("\n");
        }
        return builder.toString();
    }

    public List<Flower> getFlowers() {
        return flowers;
    }



    @Override
    public String toString() {
        return "ShopModel{" +
                "flowersCount=" + flowers.size() +
                ", flowersArray=" + flowers.toString() +
                '}';
    }
}
