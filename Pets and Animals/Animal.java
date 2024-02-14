
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Animal {
    String name;
    private String birthDate;
    private List<String> commands;

    public Animal(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void displayCommands() {
        System.out.println("Commands for " + name + ":");
        for (String command : commands) {
            System.out.println(command);
        }
    }

    public String getBirthDate() {
        return birthDate;
    }
}