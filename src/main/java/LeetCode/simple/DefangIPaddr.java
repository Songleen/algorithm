package LeetCode.simple;

/**
 * ip地址无效化
 *
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/07/07/19:48
 */
public class DefangIPaddr {
    public static void main(String[] args) {
        String address = "255.100.50.0";
        System.out.println(defangIPaddr(address));
    }

    public static String defangIPaddr(String ip) {
        return ip.replaceAll("\\.", "[.]");
    }
}
