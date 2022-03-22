public class Board {
    private int matrix [][];
    private Ship captainShipList;
    private Ship lieutenantShipList;
    private Ship almirante;

    public Board(int[][] matrix, Ship captainShipList, Ship lieutenantShipList, Ship almirante) {
        this.matrix = matrix;
        this.captainShipList = captainShipList;
        this.lieutenantShipList = lieutenantShipList;
        this.almirante = almirante;
    }

    public Board() {
        this.matrix = null;
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

    public int assignRandom(){
        return 0;
    };

    public int assigncoordinates(){
        return 0;
    };

    public void fillMatrix (){

    }


}
