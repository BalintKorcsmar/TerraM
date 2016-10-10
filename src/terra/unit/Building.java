package terra.unit;

public abstract class Building {
    protected String color;

    public String getColor() {
        return this.color;
    }

    public abstract void build();

    public abstract BuildingType getBuildingType();

    public abstract String toString();
}
