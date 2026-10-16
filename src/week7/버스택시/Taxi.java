package week7.버스택시;

public class Taxi extends Transport{
    public Taxi(FareStrategy fareStrategy){
        super("택시", fareStrategy);
    }
}
