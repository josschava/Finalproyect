
import java.util.Scanner;
import java.util.InputMismatchException;

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
        System.out.println("3. Print Matrix");
        int option = input.nextInt();
        if (option == 1 ) {

        } else if (option == 2) {
            
        } else if (option==3){
            boardPerson.showMatrix();
        
        } else {
            System.out.println("Invalid Option");
              
        }
           
        Scanner sn = new Scanner(System.in);
        boolean exit = false;
        int opt; //We will save the user's option
        do{
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
        while (!exit) ;
    }
}        
   
