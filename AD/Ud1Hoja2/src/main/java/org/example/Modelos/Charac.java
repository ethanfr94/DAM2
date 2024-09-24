package org.example.Modelos;

public class Charac {
    private Integer id;
    private String name;
    private String powers;
    private String company;
    private String origin;
    private Integer isHeroe;

    public Charac() {
    }

    public Charac(String name, String origin, String company, String powers, Integer isHeroe) {
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

    public Integer getIsHeroe() {
        return isHeroe;
    }

    public void setIsHeroe(Integer isHeroe) {
        this.isHeroe = isHeroe;
    }

    @Override
    public String toString() {
        return "characters" +
                "id=" + id +
                ", name='" + name +
                ", powers='" + powers +
                ", company='" + company +
                ", origin='" + origin +
                ", isHeroe=" + isHeroe;
    }
}
