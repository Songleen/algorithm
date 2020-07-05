package tencomalgorithms.greedy;

import java.util.*;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/07/05/10:09
 */
public class GreedyDemo {
    public static void main(String[] args) {

        Map<String, HashSet<String>> broadcast = new HashMap<>();
        broadcast.put("k1", new HashSet<>(Arrays.asList("北京", "上海", "天津")));
        broadcast.put("k2", new HashSet<>(Arrays.asList("广州", "北京", "深圳")));
        broadcast.put("k3", new HashSet<>(Arrays.asList("上海", "杭州")));
        broadcast.put("k4", new HashSet<>(Arrays.asList("上海", "天津")));
        broadcast.put("k5", new HashSet<>(Arrays.asList("杭州", "大连", "成都")));

        List<String> allArea = new ArrayList<>();
        allArea.add("北京");
        allArea.add("上海");
        allArea.add("天津");
        allArea.add("广州");
        allArea.add("深圳");
        allArea.add("成都");
        allArea.add("杭州");
        allArea.add("大连");

        // 一个保存被选中key的集合
        List<String> keys = new ArrayList<>();

        while (allArea.size() != 0) {
            // 每次循环都先将两个临时变量置为零
            int num = 0;
            String tempKey = null;
            for (String key : broadcast.keySet()) {
                if (!keys.contains(key)) {
                    int numOfIntersection = getNumOfIntersection(allArea, broadcast.get(key));
                    if (numOfIntersection > num) {
                        num = numOfIntersection;
                        tempKey = key;
                    }
                }
            }
            keys.add(tempKey);
            allArea.removeAll(broadcast.get(tempKey));
        }

        System.out.println(keys.toString());

    }

    // 查找两个集合的交集个数
    private static int getNumOfIntersection(List<String> list1, Set<String> list2) {
        int num = 0;
        for (String s : list2) {
            if (list1.contains(s)) {
                num++;
            }
        }
        return num;
    }


}
