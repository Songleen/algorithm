package objlayout;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Describe
 * @ClassName Test2
 * @Author 李松林
 * @Date 2021/3/3 22:09
 */
public class Test {
    static Person p = new Person();

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(p).toPrintable());
    }
}
