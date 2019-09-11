package lambda;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/28/15:52
 */
public class Test1 {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("hello world 1");
        r.run();
    }

    public static void process(Runnable r){
        r.run();
    }
}

class Apple {
    private String name;
    private int weight;

    public Apple(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
