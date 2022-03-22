
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Type your name please");
        String playerName = input.nextLine();
        System.out.println("Type CPU name please");
        String CPUName = input.nextLine();

        Board boardPerson = new Board();
        Board boardCPU = new Board();

        Person person1 = new Person(playerName, boardPerson);
        CPU cpu1 = new CPU(CPUName, boardCPU);

        System.out.println("Hi " + person1.getName() + ", the CPU name assigned is " + cpu1.getName() +", please select the correct option: ");
        System.out.println("1. Assign coordinates");
        System.out.println("2. Assign random");
        int option = input.nextInt();
        if (option == 1 ) {

        } else if (option == 2) {

        } else {
            System.out.println("Invalid Option");
        }
    }
}
