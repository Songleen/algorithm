package testPackage;

/**
 * @Describe
 * @ClassName Person
 * @Author 李松林
 * @Date 2020/12/24 16:46
 */
public class Person {
    private String name;
    private int age;
    private Boolean dead;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getDead() {
        return dead;
    }

    public void setDead(Boolean dead) {
        this.dead = dead;
    }
}
