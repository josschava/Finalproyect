import java.util.InputMismatchException;
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

        //this is the menu to assign ships
        System.out.println("Hi " + person1.getName() + ", the name assigned to the CPU is " + cpu1.getName() + ", please select one of the 2 options to assign your ships: ");
        System.out.println("1. Assign by coordinates");
        System.out.println("2. Assign randomly");
        System.out.println("3. Print Matrix");

        //task to assign ships
        int option = input.nextInt();
        if (option == 1) {
            int coordI = 0;
            int coordJ = 0;
            //Assign coordinates for Almirante
            boolean flag = true; //this is to control the while to know when should go out
            while (flag == true){ //While flag is tru execute all this
                System.out.println("Assigning Almirante ship that has 4 lives");
                System.out.println("Assign coordenate I: ");
                coordI = input.nextInt();
                System.out.println("Assign coordenate J: ");
                coordJ = input.nextInt();
                if (coordI >= 0 && coordI <= 5 && coordJ >= 0 && coordJ <= 5) {
                    boardPerson.assignCoordinates(coordI, coordJ, 4);
                    flag = false;
                } else {
                    System.out.println("Please insert a coordinate between 0 and 5");
                }
            }

            //Assign coordinates for Capitan
            for (int i = 0; i < 2; i++){
                System.out.println("Assigning Capitan ship that has 3 lives");
                System.out.println("Assign coordenate I: "); //ask for coordinate I
                coordI = input.nextInt();
                System.out.println("Assign coordenate J: "); //ask for coordinate J
                coordJ = input.nextInt();

                if (coordI >= 0 && coordI <= 5 && coordJ >= 0 && coordJ <= 5) {
                    boardPerson.assignCoordinates(coordI, coordJ, 3);
                } else {
                    i--;
                    System.out.println("Please insert a coordinate between 0 and 5");
                }
            }
            //Assign coordinates for Teniente
            for (int i = 0; i < 3; i++){
                System.out.println("Assigning Teniente ship that has 1 live");
                System.out.println("Assign coordenate I: "); //ask for coordinate I
                coordI = input.nextInt();
                System.out.println("Assign coordenate J: "); //ask for coordinate J
                coordJ = input.nextInt();

                if (coordI >= 0 && coordI <= 5 && coordJ >= 0 && coordJ <= 5) {
                    boardPerson.assignCoordinates(coordI, coordJ, 1);
                } else {
                    i--;
                    System.out.println("Please insert a coordinate between 0 and 5");
                }
            }
            boardPerson.showMatrix();
        } else if (option == 2) {

        } else if (option == 3) {
            boardPerson.showMatrix();
        } else {
            System.out.println("Invalid Option");
        }
        System.out.println(person1.getName() + " now that the ships are assigned please select one of the options to start playing");

        Scanner sn = new Scanner(System.in);
        boolean exit = false;
        int opt; //We will save the user's option
        do {
            System.out.println("1. Attack");
            System.out.println("2. See attack board");
            System.out.println("3. See own dashboard");
            System.out.println("4. Exit");
            try {
                System.out.println("Enter one of the options");
                opt = sn.nextInt();
                switch (opt) {
                    case 1:
                        System.out.println("You selected Attack");

                        break;
                    case 2:
                        System.out.println("You selected View Attack Board");
                        break;
                    case 3:
                        System.out.println("You have selected View Own Dashboard");
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Only numbers between 1 and 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("You must insert a number");
                sn.next();
            }
        }
        while (!exit);
    }
}
