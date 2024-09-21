package org.example.modelos;

public class movies {
    private String title;
    private Integer duration;
    private Integer year;
    private String producer;

    public movies() {
    }

    public movies(String title, Integer duration, Integer year, String producer) {
        this.title = title;
        this.duration = duration;
        this.year = year;
        this.producer = producer;
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
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", year=" + year +
                ", producer='" + producer + '\'' +
                '}';
    }
}
