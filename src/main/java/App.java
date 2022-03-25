import io.Console;
import models.Sneaker;
import models.Whiskey;
import services.Service;
import services.SneakerService;
import services.WhiskeyService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class App {
    private SneakerService sneakerService = new SneakerService();
    private WhiskeyService whiskeyService = new WhiskeyService();
    private Console console = new Console();

    public static void main(String... args) {
        App application = new App();
        application.init();
    }

    public void init() {
        try {
            sneakerService.loadData();
            whiskeyService.loadData();
        } catch (FileNotFoundException e) {
            try {
                whiskeyService.write();
                sneakerService.write();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        console.printWelcome();
        console.printCommands();
        String input = "", current = "Sneaker";
        while (!input.equalsIgnoreCase("Exit")) {
            input = console.getStringInput("What would you like to do? (You are currently looking at %s inventory)",
                    current);
            if (input.equalsIgnoreCase("Switch")) {
                if (current.equalsIgnoreCase("Sneaker")) {
                    current = "Whiskey";
                } else if (current.equalsIgnoreCase("Whiskey"))
                    current = "Sneaker";
            } else if (input.equalsIgnoreCase("Add") || input.equalsIgnoreCase("Update")) {
                productToolPager(current, input);
            }else if (input.equalsIgnoreCase("Help")){
                console.help();
            }else {
                if (current.equals("Whiskey")) {
                    inventoryOption(whiskeyService, input);
                } else if (current.equals("Sneaker"))
                    inventoryOption(sneakerService, input);
            }
        }
        try {
            sneakerService.write();
            whiskeyService.write();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void productToolPager(String current, String input) {
        if (current.equals("Sneaker")) {
            if (input.equalsIgnoreCase("Add"))
                sneakerBuilder(sneakerService);
            else if (input.equalsIgnoreCase("Update"))
                sneakerUpdater(sneakerService);
        }
        else {
            if (input.equalsIgnoreCase("Add"))
                whiskeyBuilder(whiskeyService);
            else if (input.equalsIgnoreCase("Update"))
                whiskeyUpdater(whiskeyService);
        }
    }

    public <T extends Service> void inventoryOption(T services, String input) {
        if (input.equalsIgnoreCase("Read")) {
            Object[] product = services.findProductAll();
            if (product == null)
                console.println("No inventory");
            else
                console.println(Arrays.toString(product));
        } else if (input.equalsIgnoreCase("Delete")) {
            int id = console.getIntegerInput("What is the product id for the product you wish to delete?");
            if (services.deleteProduct(id))
                console.println("Successful! Product removed.");
            else
                console.println("Cannot find product.");
        }
    }

    public void sneakerBuilder(SneakerService sneakerService) {
        String name = console.getStringInput("What is the name of the product?");
        String brand = console.getStringInput("What is the brand of the product?");
        String sport = console.getStringInput("What sport is the product for?");
        double size = console.getDoubleInput("What size is the product?");
        int qty = console.getIntegerInput("How many do you have?");
        double price = console.getDoubleInput("What is the price of product?");
        sneakerService.create(name, brand, sport, size, qty, price);
    }

    public void sneakerUpdater(SneakerService sneakerService) {
        int id = console.getIntegerInput("Which product would you like to update?");
        Sneaker sneaker = sneakerService.findSneaker(id);
        if (sneaker == null)
            console.println("Product does not exist!");
        else {
            String input = console.getStringInput("What needs to be updated?");
            if (input.equalsIgnoreCase("name"))
                sneaker.setName(console.getStringInput("What is the name of the product?"));
            else if (input.equalsIgnoreCase("brand"))
                sneaker.setBrand(console.getStringInput("What is the brand of the product?"));
            else if (input.equalsIgnoreCase("sport"))
                sneaker.setSport(console.getStringInput("What sport is the product for?"));
            else if (input.equalsIgnoreCase("size"))
                sneaker.setSize(console.getDoubleInput("What size is the product?"));
            else if (input.equalsIgnoreCase("quantity"))
                sneaker.setQty(console.getIntegerInput("How many do you have?"));
            else if (input.equalsIgnoreCase("price"))
                sneaker.setPrice(console.getDoubleInput("What is the price of product?"));
        }
    }

    private void whiskeyBuilder(WhiskeyService whiskeyService) {
        String name = console.getStringInput("What is the name of the product?");
        String brand = console.getStringInput("What is the brand of the product?");
        double alcConcentration = console.getDoubleInput("What is the alcohol concentration?");
        double size = console.getDoubleInput("What size is the product?");
        double price = console.getDoubleInput("What is the price of the product?");
        int qty =console.getIntegerInput("How many do you have?");
        whiskeyService.create(name, brand, alcConcentration, size, price, qty);
    }

    public void whiskeyUpdater(WhiskeyService whiskeyService) {
        int id = console.getIntegerInput("Which product would you like to update?");
        Whiskey whiskey = whiskeyService.findWhiskey(id);
        if (whiskey == null)
            console.println("Product does not exist!");
        else {
            String input = console.getStringInput("What needs to be updated?");
            if (input.equalsIgnoreCase("name"))
                whiskey.setName(console.getStringInput("What is the name of the product?"));
            else if (input.equalsIgnoreCase("brand"))
                whiskey.setBrand(console.getStringInput("What is the brand of the product?"));
            else if (input.equalsIgnoreCase("sport"))
                whiskey.setAlcConcentration(console.getDoubleInput("What is the product alcohol concentration?"));
            else if (input.equalsIgnoreCase("size"))
                whiskey.setSize(console.getDoubleInput("What size is the product?"));
            else if (input.equalsIgnoreCase("quantity"))
                whiskey.setQty(console.getIntegerInput("How many do you have?"));
            else if (input.equalsIgnoreCase("price"))
                whiskey.setPrice(console.getDoubleInput("What is the price of product?"));
        }
    }
}
