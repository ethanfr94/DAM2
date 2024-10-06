package org.example.modelos;

public class Movie {
    private Integer id;
    private String title;
    private Integer duration;
    private Integer year;
    private String producer;

    public Movie() {
    }

    public Movie(String title, Integer duration, Integer year, String producer) {
        this.title = title;
        this.duration = duration;
        this.year = year;
        this.producer = producer;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "movies{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", year=" + year +
                ", producer='" + producer + '\'' +
                '}';
    }
}
