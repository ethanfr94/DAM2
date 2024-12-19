public class City {

    private String name;
    private String country;
    private String province;
    private int population;
    private double latitude;
    private double longitude;

    public City(String name, String country, String province, int population, double latitude, double longitude) {
        this.name = name;
        this.country = country;
        this.province = province;
        this.population = population;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + ", País: " + country + ", Provincia: " + province + ", Población: " + population + ", Latitud: " + latitude + ", Longitud: " + longitude;
    }
}
