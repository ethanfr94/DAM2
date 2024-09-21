package org.example.modelos;

public class acts {
    private Integer character_id;
    private Integer movie_id;
    private Integer minutes;
    private boolean main;
    private String actor;

    public acts() {
    }

    public acts(Integer character_id, Integer movie_id, Integer minutes, boolean main, String actor) {
        this.character_id = character_id;
        this.movie_id = movie_id;
        this.minutes = minutes;
        this.main = main;
        this.actor = actor;
    }

    public Integer getCharacter_id() {
        return character_id;
    }

    public void setCharacter_id(Integer character_id) {
        this.character_id = character_id;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "acts{" +
                "character_id=" + character_id +
                ", movie_id=" + movie_id +
                ", minutes=" + minutes +
                ", main=" + main +
                ", actor='" + actor + '\'' +
                '}';
    }
}
