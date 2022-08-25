package kg.megacom.student.models.enums;

public enum Day {
    SUNDAY,// 1
    MONDAY, //2
    TUESDAY, //3
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY; //7;


    public int getDayValue(){
        return ordinal() + 1;
    }
}
