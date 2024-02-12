import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AnimalRegistry {
    static Map<String, Integer> animalCounter = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();
        
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add new animal");
            System.out.println("2. Display commands for an animal");
            System.out.println("3. Teach new command to an animal");
            System.out.println("4. Display animals by birth date");
            System.out.println("5. Display list of animals");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNewAnimal(animals);
                    break;
                case 2:
                    displayCommandsForAnimal(animals, scanner);
                    break;
                case 3:
                    teachNewCommand(animals, scanner);
                    break;
                case 4:
                    displayAnimalsByBirthDate(animals);
                    break;
                case 5:
                    //System.out.println(animalCounter);
                    animalCounter.entrySet().forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addNewAnimal(List<Animal> animals) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter animal type (dog/cat/hamster/horse/camel/donkey): ");
        String type = scanner.next();
        System.out.print("Enter animal name: ");
        String name = scanner.next();
        System.out.print("Enter animal birth date: ");
        String birthDate = scanner.next();
        
        Animal newAnimal;
        switch (type) {
            case "dog":
            case "cat":
            case "hamster":
                newAnimal = new Pets(name, birthDate);
                break;
            case "horse":
            case "camel":
            case "donkey":
                newAnimal = new PackAnimals(name, birthDate);
                break;
            default:
                System.out.println("Invalid animal type.");
                return;
        }
        
        animals.add(newAnimal);

        animalCounter.put(type, animalCounter.getOrDefault(type, 0) + 1);
        System.out.println("New animal added successfully.");
        
    }

    private static void displayCommandsForAnimal(List<Animal> animals, Scanner scanner) {
        System.out.print("Enter animal name: ");
        String name = scanner.next();

        for (Animal animal : animals) {
            if (animal.name.equalsIgnoreCase(name)) {
                animal.displayCommands();
                return;
            }
        }

        System.out.println("Animal not found.");
    }

    private static void teachNewCommand(List<Animal> animals, Scanner scanner) {
        System.out.print("Enter animal name: ");
        String name = scanner.next();

        for (Animal animal : animals) {
            if (animal.name.equalsIgnoreCase(name)) {
                System.out.print("Enter new command to teach: ");
                String command = scanner.next();
                animal.addCommand(command);
                System.out.println("New command added successfully.");
                return;
            }
        }

        System.out.println("Animal not found.");
    }

    private static void displayAnimalsByBirthDate(List<Animal> animals) {
        animals.sort((a1, a2) -> a1.birthDate.compareTo(a2.birthDate));
        for (Animal animal : animals) {
            System.out.println(animal.name + " - " + animal.birthDate);
        }
    }
}
