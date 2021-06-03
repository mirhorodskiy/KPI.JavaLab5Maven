package model.service;

import model.domain.Flower;

import java.io.IOException;
import java.util.List;

public interface ShopModel {
//    void writeFile(String text) throws IOException;
//
//    void readFlowersArray() throws Exception;
//
//    void saveChanges() throws IOException;

    List<Flower> getFlowers();

    void writeFile(String text) throws IOException;

    void saveChanges(List<Flower> flowers) throws IOException;

    void addFlower(Flower flower);

    String getFloweringIndoorFlowersAndPrices();

    String getSubspeciesAndCountsOfFlower(String flowerName);

    String getListOfFlowers();
}
