import javax.swing.*;
import java.util.Random;

public class Board {
    private char matrix[][];
    private Ship captainShipList;
    private Ship lieutenantShipList;
    private Ship almirante;

    public Board(char[][] matrix, Ship captainShipList, Ship lieutenantShipList, Ship almirante) {
        this.matrix = new char[6][6];
        this.captainShipList = captainShipList;
        this.lieutenantShipList = lieutenantShipList;
        this.almirante = almirante;
    }

    public Board() {
        this.matrix = new char[6][6];
        this.captainShipList = null;
        this.lieutenantShipList = null;
        this.almirante = null;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public Ship getCaptainShipList() {
        return captainShipList;
    }

    public void setCaptainShipList(Ship captainShipList) {
        this.captainShipList = captainShipList;
    }

    public Ship getLieutenantShipList() {
        return lieutenantShipList;
    }

    public void setLieutenantShipList(Ship lieutenantShipList) {
        this.lieutenantShipList = lieutenantShipList;
    }

    public Ship getAlmirante() {
        return almirante;
    }

    public void setAlmirante(Ship almirante) {
        this.almirante = almirante;
    }

    public void showMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (j != matrix[i].length - 1) System.out.print("\t");
            }
            System.out.println("|");
        }
    }

    public void fillMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ' ';
            }
        }
    }

    // For the assignment of the ships by coordinates
    public void assignCoordinates(int i, int j, char value) { //receive the number of the row and column, and the live points of the ship
        matrix[i][j] = value;
    }

    public void fillMatrixRandomly() {
        Random random = new Random();
        //Assign ships for Almirante
        int iCoord = random.nextInt((5 - 0) + 1) + 0;
        int jCoord = random.nextInt((5 - 0) + 1) + 0;

        assignCoordinates(iCoord, jCoord, '4');

        //Assign ships for Capitan
        for (int i = 0; i < 2; i++) {
            iCoord = random.nextInt((5 - 0) + 1) + 0;
            jCoord = random.nextInt((5 - 0) + 1) + 0;
            if (getMatrix()[iCoord][jCoord] == ' ') {//this if is to make sure that the coordinate is empty
                assignCoordinates(iCoord, jCoord, '3');
            } else {
                i--;
            }
        }
        //Assign ships for Teniente
        for (int i = 0; i < 3; i++) {
            iCoord = random.nextInt((5 - 0) + 1) + 0;
            jCoord = random.nextInt((5 - 0) + 1) + 0;
            if (getMatrix()[iCoord][jCoord] == ' ') {//this if is to make sure that the coordinate is empty
                assignCoordinates(iCoord, jCoord, '1');
            } else {
                i--;
            }
        }
    }
}

