package model;

public enum Author {
    CONAN_DOILE("Артур Конан Дойль"),
    VICTOR_HUGO("Виктор Гюго"),
    ALEXANDER_PUSHKIN("Александр Пушкин"),
    NIKOLAY_TOLSTOY("Николай Толстой"),
    VLASTELIN_KOLEC("Дж.Р.Р.Толкин"),
    MITSURU_ADACHI("Мицуру Адачи"),
    RUMIKO_TAKAHASHI("Румико Такахаси"),
    LOUIS_L_AMOUR("Луи Дирборн Л'Амур"),
    ERLE_STANLEY_GARDNER("Эрл Стэнли Гарднер"),
    RYOTARO_SHIBA("Ретаро Шиба");

    private final String name;

    Author(String name) {
    this.name = name;
    }

    public String getName(){
        return name;
    }


}
