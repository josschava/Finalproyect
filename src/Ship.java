public class Ship {
    private String name;
    private String cell;
    private Integer livePoints;

    public Ship(String name, String cell, Integer livePoints) {
        this.name = name;
        this.cell = cell;
        this.livePoints = livePoints;
    }

    public Ship() {
        this.name = "";
        this.cell = "";
        this.livePoints = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public Integer getLivePoints() {
        return livePoints;
    }

    public void setLivePoints(Integer livePoints) {
        this.livePoints = livePoints;
    }

}
