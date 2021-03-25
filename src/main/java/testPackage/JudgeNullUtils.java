package testPackage;

import java.lang.reflect.Field;

/**
 * @Describe
 * @ClassName
 * @Author 李松林
 * @Date 2020/12/24 16:41
 */
public class JudgeNullUtils {

    public static boolean isAll(Object obj) throws IllegalAccessException {
        Class<?> stuClass = obj.getClass();
        Field[] declaredFields = stuClass.getDeclaredFields();
        boolean flag = true;
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Object val = field.get(obj);
            if (val != null) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
