import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Type your name please");
        String playerName = input.nextLine();
        System.out.println("Type CPU name please");
        String CPUName = input.nextLine();

        Board boardPerson = new Board(); //board for person
        Board boardCPU = new Board(); //board for cpu
        boardPerson.fillMatrix();
        boardCPU.fillMatrix();
        boardCPU.fillMatrixRandomly();

        Person person1 = new Person(playerName, boardPerson); //creating a new person, using player name and board created above
        CPU cpu1 = new CPU(CPUName, boardCPU);

        int option = 0; //We will save the user's option
        do {
            //this is the menu to assign ships
            System.out.println("Hi " + person1.getName() + ", the name assigned to the CPU is " + cpu1.getName() + ", please select one of the 2 options to assign your ships: ");
            System.out.println("1. Assign by coordinates");
            System.out.println("2. Assign randomly");

            //tasks to assign ships
            option = input.nextInt();

            if (option == 1) {
                int coordI = 0; //row
                int coordJ = 0;  //column
                //Assign coordinates for Almirante
                boolean flag = true; //this is to control the while to know when should go out
                while (flag == true) { //While flag is tru execute all this
                    System.out.println("Assigning Almirante ship that has 4 lives");
                    System.out.println("Assign coordinate I: ");
                    coordI = input.nextInt();
                    System.out.println("Assign coordinate J: ");
                    coordJ = input.nextInt();
                    if (coordI >= 0 && coordI <= 5 && coordJ >= 0 && coordJ <= 5) {
                        Ship almirante = new Ship("Almirante", coordI, coordJ, 4, false);
                        if (boardPerson.getMatrix()[coordI][coordJ].getLifePoints() == 0) { //this if is to make sure that the coordinate is empty
                            boardPerson.assignCoordinates(coordI, coordJ, almirante); //value of 4 is the 4 lives of Almirante ship
                            flag = false;
                        } else {
                            System.out.println("This coordinate is already in use, please assign again");
                        }
                    } else {
                        System.out.println("Please insert a coordinate between 0 and 5");
                    }
                }
                //Assign coordinates for Capitan
                for (int i = 0; i < 2; i++) {
                    System.out.println("Assigning Capitan ship that has 3 lives");
                    System.out.println("Assign coordinate I: "); //ask for coordinate I
                    coordI = input.nextInt();
                    System.out.println("Assign coordinate J: "); //ask for coordinate J
                    coordJ = input.nextInt();

                    if (coordI >= 0 && coordI <= 5 && coordJ >= 0 && coordJ <= 5) {
                        Ship capitan = new Ship("Capitan", coordI, coordJ, 3, false);
                        if (boardPerson.getMatrix()[coordI][coordJ].getLifePoints() == 0) {//this if is to make sure that the coordinate is empty
                            boardPerson.assignCoordinates(coordI, coordJ, capitan);
                        } else {
                            System.out.println("This coordinate is already in use, please assign again");
                            i--;
                        }
                    } else {
                        i--;  //This is to make sure that we are assigning the 2 ships for Capitan, if the coodinate is incorrect we are going to run the loop again
                        System.out.println("Please insert a coordinate between 0 and 5");
                    }
                }
                //Assign coordinates for Teniente
                for (int i = 0; i < 3; i++) {
                    System.out.println("Assigning Teniente ship that has 1 live");
                    System.out.println("Assign coordinate I: "); //ask for coordinate I
                    coordI = input.nextInt();
                    System.out.println("Assign coordinate J: "); //ask for coordinate J
                    coordJ = input.nextInt();

                    if (coordI >= 0 && coordI <= 5 && coordJ >= 0 && coordJ <= 5) {
                        Ship teniente = new Ship("Teniente", coordI, coordJ, 1, false);
                        if (boardPerson.getMatrix()[coordI][coordJ].getLifePoints() == 0) {//this if is to make sure that the coordinate is empty
                            boardPerson.assignCoordinates(coordI, coordJ, teniente);
                        } else {
                            System.out.println("This coordinate is already in use, please assign again");
                            i--;
                        }
                    } else {
                        i--;
                        System.out.println("Please insert a coordinate between 0 and 5");
                    }
                }
                boardPerson.showMatrix(); //this is for test purpose to make sure that the ships are assigned
            } else if (option == 2) {
               boardPerson.fillMatrixRandomly();


            } else if (option == 3) {
                boardPerson.showMatrix();
            } else {
                System.out.println("Invalid Option, please select 1 or 2 to continue");
            }
        } while (option != 1 && option != 2);
        System.out.println(person1.getName() + " now that the ships are assigned please select one of the options to start playing");

        boolean exit = false;
        int opt; //We will save the user's option
        do {
            System.out.println("1. Attack");
            System.out.println("2. See attack board");
            System.out.println("3. See own dashboard");
            System.out.println("4. Cheat");
            System.out.println("5. Exit");
            try {
                System.out.println("Enter one of the options");
                opt = input.nextInt();
                switch (opt) {
                    case 1:
                        System.out.println("You selected Attack");
                        boardCPU.attack();
                        System.out.println("\n Turn of CPU to attack");
                        boardPerson.attackRandom();
                        break;
                    case 2:
                        System.out.println("You selected View Attack Board");
                        boardCPU.seeAttackBoard(); //this show the CPU board
                        break;
                    case 3:
                        System.out.println("You have selected View Own Dashboard");
                        boardPerson.showMatrix();  //this is to make sure that assign randomly is working
                        break;
                    case 4:
                        System.out.println("You have selected cheat");
                        boardCPU.seeOwnBoard();  //this is to make sure that assign randomly is working
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Only numbers between 1 and 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("You must insert a number");
                input.next();
            }
        }
        while (!exit);
    }
}
