import java.util.Scanner;
import javax.swing.*;  

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String playerName = JOptionPane.showInputDialog("Enter your name");
        String CPUName = JOptionPane.showInputDialog("Enter name for the CPU");

        Board boardPerson = new Board();
        Board boardCPU = new Board();

        Person person1 = new Person(playerName, boardPerson);
        CPU cpu1 = new CPU(CPUName, boardCPU);

        String menu = JOptionPane.showInputDialog("Welcome " + person1.getName() + ", the assigned CPU name is " + cpu1.getName() + ". Please select an option: \n"
                    + "1. Assign coordinates\n"
                    + "2. Assign randomly\n"
                    + "3. Print matrix");
        
        int option=0;
        do {
        option = Integer.parseInt(menu);
        switch (option) {
            case 1: JOptionPane.showMessageDialog(null,"You chose option # 1. Assign your coordinates now.");break;
            case 2: JOptionPane.showMessageDialog(null,"You chose option # 2. Your coordinates have been assigned randomly.");break;
            case 3: JOptionPane.showMessageDialog(null,"You chose option # 3. Printing matrix...");break;
                default: JOptionPane.showMessageDialog(null,"Choose a valid option.\n","Option Not Found",JOptionPane.WARNING_MESSAGE);
            System.exit(0);    
                
        } } while (option!=3);
            boardPerson.showMatrix(); 
        }

        }
