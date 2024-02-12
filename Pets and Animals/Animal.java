import java.util.ArrayList;
import java.util.List;

class Animal {
    String name;
    String birthDate;
    List<String> commands;

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
}
