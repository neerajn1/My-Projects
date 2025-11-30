import java.util.LinkedList;

public class runLinkedList {
    public static void main(String[] args) {
        // Creating a LinkedList with 3 College objects that are added to the list named "collegesList"
        LinkedList<College> collegesList = new LinkedList<>();

        // Add College objects to the LinkedList
        collegesList.add(new College("UMBC", 1966));
        collegesList.add(new College("Towson University", 1866));
        collegesList.add(new College("UMD (College Park)", 1856));

        // Printing out this linked list
        System.out.println("LinkedList of Colleges:");
        for (College finalCollegeList : collegesList) { // listed in order as for college object, naming the final list from the 3 we created
            System.out.println(finalCollegeList);
        }
    }
}
