package testPackage;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/11/19/8:43
 */
public class TempClass {

    @Test
    public void test() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("breed", "螺纹钢");
        map1.put("material", "HPB300");
        map1.put("spec", "$6");
        map1.put("place", "河钢承钢");
        Collection<String> values = map1.values();

        System.out.println(values);

        Map<String, String> map2 = new HashMap<>();
        map2.put("breed", "螺纹钢");
        map2.put("material", "HPB300");
        map2.put("spec", "$6");
        map2.put("place", "河钢承钢");
        Collection<String> values1 = map2.values();
        System.out.println(values1);

        String s = values.toString();
        String s1 = values1.toString();
        System.out.println(s.equals(s1));

    }

    @Test
    public void test3() {
        Map<String, String> map = new HashMap<>();
        map.put("date", "2019-11-18 14:31:03");
        String date = map.compute("date", new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                String date1 = s.substring(0, 10);
                String date2 = s2.substring(0, 10);
                if (date1.equals(date2)) {
                    int i = s.substring(11).compareTo(s.substring(11));
                    if (i == 1) {
                        return s;
                    }
                }
                return s2;
            }
        });
        System.out.println(date);
    }
}
