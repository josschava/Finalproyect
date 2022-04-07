public class Ship {
    private String name;
    private int coordinateI;
    private int coordinateJ;
    private int lifePoints;
    private boolean attacked;

    public Ship(String name, int coordinateI, int coordinateJ, int lifePoints, boolean attacked) {
        this.name = name;
        this.coordinateI = coordinateI;
        this.coordinateJ = coordinateJ;
        this.lifePoints = lifePoints;
        this.attacked = attacked;
    }

    public Ship() {
        this.name = "";
        this.coordinateI = 0;
        this.coordinateJ = 0;
        this.lifePoints = 0;
        this.attacked = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoordinateI() {
        return coordinateI;
    }

    public void setCoordinateI(int coordinateI) {
        this.coordinateI = coordinateI;
    }
    public int getCoordinateJ() {
        return coordinateJ;
    }

    public void setCoordinateJ(int coordinateJ) {
        this.coordinateJ = coordinateJ;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }
    public boolean getAttacked() {
        return attacked;
    }

    public void setAttacked(boolean attacked) {
        this.attacked = attacked;
    }

}
