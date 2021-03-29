package datastructure.array;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/12/17/15:50
 */
public class ArrayDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>(10);
        map.put(1 + "", 1);
        map.put("1", 2);
        Object o = map.get("1");
    }
}
