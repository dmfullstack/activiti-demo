package top.lllyl2012.activiti.s10任务参数与附件;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public void setAge(String age) {

        this.age = age;
    }
}
