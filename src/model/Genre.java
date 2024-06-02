package model;

public enum Genre {
    HORROR("Ужасы"),
    NOVELLA("Рассказ"),
    DRAMA("Драма"),
    BALADA("Баллада"),
    FAIRY_TALE("Сказка");
    private String name;

    Genre(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
