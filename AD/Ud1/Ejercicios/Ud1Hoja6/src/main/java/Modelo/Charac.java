package Modelo;

public class Charac {
    private Integer id;
    private String name;
    private String powers;
    private String company;
    private String origin;
    private boolean isHeroe;

    public Charac() {
    }

    public Charac(String name, String origin, String company, String powers, boolean isHeroe) {
        this.name = name;
        this.origin = origin;
        this.company = company;
        this.powers = powers;
        this.isHeroe = isHeroe;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPowers() {
        return powers;
    }

    public void setPowers(String powers) {
        this.powers = powers;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public boolean getIsHeroe() {
        return isHeroe;
    }

    public void setIsHeroe(boolean isHeroe) {
        this.isHeroe = isHeroe;
    }

    @Override
    public String toString() {
        return String.format("%-4d %-15s %-60s %-10s %-15s %s", id, name, powers, company, origin, isHeroe ? "Heroe" : "Villano");
    }
}
