package sample;

public class User {
    private static int objectsNumber=0;
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        objectsNumber++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int count(){
        return objectsNumber;
    }
}
