public class testPerson {
    public static void main(String[] args) {
        //2 Person objects one set with default values in code while second is custom values as per parameter constructor
        Person john = new Person();
        Person josephine = new Person("Josephine Smith", 30, "Female");

        // Printing information for each Table object by accessing the attributes with getters
        System.out.println("Person 1: " + john.getName() + "           Age: " + john.getAge() + "    Gender: " + john.getGender());
        System.out.println("Person 2: " + josephine.getName() + "      Age: " + josephine.getAge() + "    Gender: " + josephine.getGender());

        //Setters to modify any of the attributes
        josephine.setAge(25);
        System.out.print("Note: ");
        System.out.println("Josephine's age was updated to " + josephine.getAge() +  " after document verification");

        int ageDifference = john.findAgeDifference(josephine);
        System.out.println("Age difference between " + john.getName() + " and " + josephine.getName() + " is: " + ageDifference + " years");
    }
}
