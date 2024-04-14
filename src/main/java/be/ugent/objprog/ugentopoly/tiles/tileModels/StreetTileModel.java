package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;

public class StreetTileModel extends TileModel {

    private final String defaultOwner = "no owner";

    private final String area;
    private final String cost;
    private final String rent0;
    private final String rent1;
    private final String rent2;
    private final String rent3;
    private final String rent4;
    private final String rent5;
    private String owner;
    private final String color;
    private final String streetName;

    public StreetTileModel(
            String id,
            int position,
            String color,
            String area,
            String cost,
            String rent0,
            String rent1,
            String rent2,
            String rent3,
            String rent4,
            String rent5) {
        super(id, position);
        this.streetName = PropertyLoader.getLabel(id);
        this.color = color;
        this.area = area;
        this.owner = "no owner";
        this.cost = cost;
        this.rent0 = rent0;
        this.rent1 = rent1;
        this.rent2 = rent2;
        this.rent3 = rent3;
        this.rent4 = rent4;
        this.rent5 = rent5;

    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        if (! this.owner.equals(defaultOwner)) {
            System.err.println("Owner is already set...");
        } else {
            this.owner = owner;
            fireInvalidationEvent();
        }
        // NEEDSLOG
    }


    public String getColor() {
        return color;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCost() {
        return cost;
    }

    public String getRent0() {
        return rent0;
    }

    public String getRent1() {
        return rent1;
    }

    public String getRent2() {
        return rent2;
    }

    public String getRent3() {
        return rent3;
    }

    public String getRent4() {
        return rent4;
    }

    public String getRent5() {
        return rent5;
    }

    public String getArea() {
        return area;
    }
}