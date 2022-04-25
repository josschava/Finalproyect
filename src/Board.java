import java.util.Random;
import java.util.Scanner;

public class Board {
    private Ship matrix[][];

    public Board(Ship[][] matrix) {
        this.matrix = new Ship[6][6];
    }

    public Board() {
        this.matrix = new Ship[6][6];
    }

    public Ship[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Ship[][] matrix) {
        this.matrix = matrix;
    }

    public void showMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].getLifePoints() == 0 && matrix[i][j].getAttacked() == false) {
                    System.out.print(" ");
                } else {
                    System.out.print(matrix[i][j].getLifePoints());
                }
                if (j != matrix[i].length - 1) System.out.print("\t");
            }
            System.out.println("|");
        }
    }

    public void fillMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Ship(); //this is to create a new ship
            }
        }
    }

    // For the assignment of the ships by coordinates
    public void assignCoordinates(int i, int j, Ship value) { //receive the number of the row and column, and the live points of the ship
        matrix[i][j] = value;
    }

    public void fillMatrixRandomly() {
        Random random = new Random();
        //Assign ships for Almirante
        int iCoord = random.nextInt((5 - 0) + 1) + 0;
        int jCoord = random.nextInt((5 - 0) + 1) + 0;

        Ship almirante = new Ship("Almirante", iCoord, jCoord, 4, false);
        assignCoordinates(iCoord, jCoord, almirante);

        //Assign ships for Capitan
        for (int i = 0; i < 2; i++) {
            iCoord = random.nextInt((5 - 0) + 1) + 0;
            jCoord = random.nextInt((5 - 0) + 1) + 0;
            Ship capitan = new Ship("Capitan", iCoord, jCoord, 3, false);
            if (getMatrix()[iCoord][jCoord].getLifePoints() == 0) {//this if is to make sure that the coordinate is empty
                assignCoordinates(iCoord, jCoord, capitan);
            } else {
                i--;
            }
        }
        //Assign ships for Teniente
        for (int i = 0; i < 3; i++) {
            iCoord = random.nextInt((5 - 0) + 1) + 0;
            jCoord = random.nextInt((5 - 0) + 1) + 0;
            Ship teniente = new Ship("Teniente", iCoord, jCoord, 1, false);
            if (getMatrix()[iCoord][jCoord].getLifePoints() == 0) {//this if is to make sure that the coordinate is empty
                assignCoordinates(iCoord, jCoord, teniente);
            } else {
                i--;
            }
        }
    }

    public void attack() {
        Scanner input = new Scanner(System.in);
        System.out.println("Assign coordinate I: ");
        int coordI = input.nextInt();
        System.out.println("Assign coordinate J: ");
        int coordJ = input.nextInt();
        if (matrix[coordI][coordJ].getLifePoints() > 0) { //if life point are more than 0 means that there is a ship
            int newLifePoints = matrix[coordI][coordJ].getLifePoints() - 1; //the -1 is to rest the life points to the ship
            matrix[coordI][coordJ].setLifePoints(newLifePoints); //we set the new life point of the ship
            matrix[coordI][coordJ].setAttacked(true);  //attacked is true because we attacked a ship
            System.out.println("You attacked a Ship");
            if (matrix[coordI][coordJ].getLifePoints() == 0) { //if life points are 0 and attacked is true the ship is destroyed
                System.out.println("You destroyed a Ship");
            }
        } else if (matrix[coordI][coordJ].getLifePoints() == 0 && matrix[coordI][coordJ].getAttacked() == false) {
            matrix[coordI][coordJ].setLifePoints(-1);
            System.out.println("You didn't hit any ship");
        } else if (matrix[coordI][coordJ].getLifePoints() == -1 && matrix[coordI][coordJ].getAttacked() == false) {
            System.out.println("You already attacked this coordinate and is empty, you should select another coordinate");
        } else if (matrix[coordI][coordJ].getLifePoints() == 0 && matrix[coordI][coordJ].getAttacked() == true) {
            System.out.println("You already attacked this ship and was destroyed, please select another coordinate");
        }
    }
    public void attackRandom() {
        Random random = new Random();
        int coordI = random.nextInt((5 - 0) + 1) + 0;
        int coordJ = random.nextInt((5 - 0) + 1) + 0;
        if (matrix[coordI][coordJ].getLifePoints() > 0) { //if life point are more than 0 means that there is a ship
            int newLifePoints = matrix[coordI][coordJ].getLifePoints() - 1; //the -1 is to rest the life points to the ship
            matrix[coordI][coordJ].setLifePoints(newLifePoints); //we set the new life point of the ship
            matrix[coordI][coordJ].setAttacked(true);  //attacked is true because we attacked a ship
            System.out.println("Ship Attacked");
            if (matrix[coordI][coordJ].getLifePoints() == 0) { //if life points are 0 and attacked is true the ship is destroyed
                System.out.println("Ship Destroyed");
            }
        } else if (matrix[coordI][coordJ].getLifePoints() == 0 && matrix[coordI][coordJ].getAttacked() == false) {
            matrix[coordI][coordJ].setLifePoints(-1);
            System.out.println("Didn't hit any ship");
        }
    }

    public void seeAttackBoard() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].getLifePoints() == -1 && matrix[i][j].getAttacked() == false) {
                    System.out.print("X");
                } else if (matrix[i][j].getLifePoints() > 0 && matrix[i][j].getAttacked() == true) {
                    System.out.print("O");
                } else if (matrix[i][j].getLifePoints() == 0 && matrix[i][j].getAttacked() == true) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                if (j != matrix[i].length - 1) System.out.print("\t");
            }
            System.out.println("|");
        }
    }

    public void seeOwnBoard() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].getLifePoints() == -1 && matrix[i][j].getAttacked() == false) {
                    System.out.print("X");
                } else if (matrix[i][j].getLifePoints() > 0 && matrix[i][j].getAttacked() == true) {
                    System.out.print("O");
                } else if (matrix[i][j].getLifePoints() == 0 && matrix[i][j].getAttacked() == true) {
                    System.out.print("*");
                } else if (matrix[i][j].getLifePoints() > 0 && matrix[i][j].getAttacked() == false){
                    System.out.print(matrix[i][j].getLifePoints());
                } else {
                    System.out.print(" ");
                }
                if (j != matrix[i].length - 1) System.out.print("\t");
            }
            System.out.println("|");
        }
    }
}

