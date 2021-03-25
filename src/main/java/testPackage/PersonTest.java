package testPackage;

import org.junit.Test;

/**
 * @Describe
 * @ClassName PersonTest
 * @Author 李松林
 * @Date 2020/12/24 16:47
 */
public class PersonTest {

    @Test
    public void test01() throws IllegalAccessException {
        Person person = new Person();
        boolean all = JudgeNullUtils.isAll(person);
        System.out.println(all);
    }
}
