public class Person {
    // Private parts that are retrieved with getters and setters
    private String name;
    private int age;
    private String gender;

    // Constructor ('this' refers to the object Person itself)
    public Person() {
        this.name = "John Smith";
        this.age = 20;
        this.gender = "Male";
    }

    // Parameters assigned to the object (Overloaded constructor)
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Getters and Setters for all the things that are private
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public int findAgeDifference(Person anotherIndividual) {
        return Math.abs(this.age - anotherIndividual.getAge());
    }
}