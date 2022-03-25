package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sun.org.apache.xpath.internal.Arg;
import models.Sneaker;
import models.Whiskey;
import utils.CSVUtils;

import java.io.*;
import java.util.*;

public class SneakerService extends Service<Sneaker> {
    private int nextId = 1;

//    private List<Sneaker> inventory = new ArrayList<>();
    private Map<Integer, Sneaker> inventory = new HashMap<>();

    public Sneaker create(String name, String brand, String sport, double size, int quantity, double price) {
        Sneaker createdSneaker = new Sneaker(nextId++, name, brand, sport, size, quantity, price);
        inventory.put(createdSneaker.getId(),createdSneaker);
        return createdSneaker;
    }

    public Sneaker findSneaker(int id) {
        return inventory.get(id);
//        for (Sneaker s: inventory) {
//            if (s.getId() == id)
//                return s;
//        }
    }

    public Sneaker[] findAll() {
        return inventory.values().toArray(new Sneaker[inventory.size()]);
    }

    public boolean delete(int id) {
//        for (Sneaker s: inventory) {
//            if (s.getId() == id){
//                inventory.remove(s);
//                return true;
//            }
//        }
//        return false;
        Sneaker sneaker = inventory.remove(id);
        if (sneaker == null)
            return false;
        return true;
    }

    public void write() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("sneaker.json"), inventory);
//        String csvFile = "/Users/batman/Desktop/Sneaker.csv";
//        FileWriter writer = new FileWriter(csvFile);
//
//        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));
//
//        for (Sneaker s : inventory.values()) {
//            List<String> list = new ArrayList<>();
//            list.add(String.valueOf(s.getId()));
//            list.add(s.getName());
//            list.add(s.getBrand());
//            list.add(s.getSport());
//            list.add(String.valueOf(s.getSize()));
//            list.add(String.valueOf(s.getQty()));
//            list.add(String.valueOf(s.getPrice()));
//            CSVUtils.writeLine(writer, list);
//        }
//
//        writer.flush();
//        writer.close();
    }

    public void loadData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.inventory = objectMapper.readValue(new File("sneaker.json"), new TypeReference<Map<Integer, Sneaker>>(){});
//        String csvFile = "/Users/batman/Desktop/Sneaker.csv";
//        String line = "";
//        String csvSplitBy = ",";
//
//        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//            nextId = Integer.parseInt(br.readLine());
//
//            while ((line = br.readLine()) != null) {
//                String[] beer = line.split(csvSplitBy);
//
//                int id = Integer.parseInt(beer[0]);
//                String name = beer[1];
//                String brand = beer[2];
//                String sport = beer[3];
//                double size = Double.parseDouble(beer[4]);
//                int qty = Integer.parseInt(beer[5]);
//                double price = Float.parseFloat(beer[6]);
//                inventory.put(id, new Sneaker(id, name, brand, sport, size, qty, price));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public Sneaker[] findProductAll() {
        return findAll();
    }

    @Override
    public boolean deleteProduct(int id) {
        return delete(id);
    }
}
