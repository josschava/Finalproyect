import javax.swing.*;

public class Board {
    private int matrix[][];
    private Ship captainShipList;
    private Ship lieutenantShipList;
    private Ship almirante;

    public Board(int[][] matrix, Ship captainShipList, Ship lieutenantShipList, Ship almirante) {
        this.matrix = new int[6][6];
        this.captainShipList = captainShipList;
        this.lieutenantShipList = lieutenantShipList;
        this.almirante = almirante;
    }

    public Board() {
        this.matrix = new int[6][6];
        this.captainShipList = null;
        this.lieutenantShipList = null;
        this.almirante = null;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
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

    public int assignRandom() {
        return 0;
    }

    ;

    public int assigncoordinates() {
        return 0;
    }

    ;

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
    public int[][] fillMatrix() {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int value = Integer.parseInt(JOptionPane.showInputDialog("Please add the value for the position [" + i + "]" + "[" + j + "]"));
                matrix[i][j] = value;
            }
        }
        return matrix;
    }
    // For the assignment of the ships by coordinates
    public void assignCoordinates(int i, int j, int value){ //receive the number of the row and column, and the live points of the ship
                matrix[i][j] = value;
            }
        }

