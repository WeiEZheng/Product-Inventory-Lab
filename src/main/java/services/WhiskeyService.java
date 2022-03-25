package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import models.Sneaker;
import models.Whiskey;
import utils.CSVUtils;

import java.io.*;
import java.util.*;

public class WhiskeyService extends Service<Whiskey> {
    private int nextId = 1;
//    private List<Whiskey> inventory = new ArrayList<>();
    private Map<Integer,Whiskey> inventory = new HashMap<>();

    public Whiskey create(String name, String brand, double alcConcentration, double size, double price, int qty) {
        Whiskey createdWhiskey = new Whiskey(nextId++, name, brand, alcConcentration, size, price, qty);
        inventory.put(createdWhiskey.getId(),createdWhiskey);
        return createdWhiskey;
    }

    public Whiskey findWhiskey(int id) {
        return inventory.get(id);
//        for (Whiskey s : inventory.values()) {
//            if (s.getId() == id)
//                return s;
//        }
//        return null;
    }

    public Whiskey[] findAll() {
        return inventory.values().toArray(new Whiskey[inventory.size()]);
    }

    public boolean delete(int id) {
//        for (Whiskey s : inventory) {
//            if (s.getId() == id) {
//                inventory.remove(s);
//                return true;
//            }
//        }
//        return false;
        Whiskey whiskey = inventory.remove(id);
        if (whiskey == null)
            return false;
        return true;
    }

    public void write() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("whiskey.json"), inventory);
//        String csvFile = "/Users/batman/Desktop/Sneaker.csv";
//        FileWriter writer = new FileWriter(csvFile);
//
//        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));
//
//        for (Whiskey s : inventory.values()) {
//            List<String> list = new ArrayList<>();
//            list.add(String.valueOf(s.getId()));
//            list.add(s.getName());
//            list.add(s.getBrand());
//            list.add(String.valueOf(s.getAlcConcentration()));
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
        this.inventory = objectMapper.readValue(new File("whiskey.json"), new TypeReference<Map<Integer, Whiskey>>(){});
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
//                double alcCon = Double.parseDouble(beer[3]);
//                double size = Double.parseDouble(beer[4]);
//                int qty = Integer.parseInt(beer[5]);
//                double price = Double.parseDouble(beer[6]);
//                inventory.put(id, new Whiskey(id, name, brand, alcCon, size, price, qty));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public Whiskey[] findProductAll() {
        return findAll();
    }

    @Override
    public boolean deleteProduct(int id) {
        return delete(id);
    }
}

