import java.util.*;

public class mainSet {
    public static void main(String[] args) {
        // Create a Set and add elements
        Set<String> country = new HashSet<>();
        country.add("The USA");
        country.add("Canada");
        country.add("Japan");
        country.add("India");
        country.add("UAE");
        country.add("Russia");

        // Printing out the 1st set
        System.out.println("1st Set: " + country);

        // Adding a new element to the country Set
        country.add("New Zealand");
        System.out.println("New addition to the Country Set: " + country);

        // Deleting an element
        country.remove("Russia");
        System.out.println("Updated Set after deletion of Russia: " + country);

        // Verifying country's placement in the set using .contains
        System.out.println("Does it contain The USA? " + country.contains("The USA"));
        System.out.println("Does it contain Russia? " + country.contains("Russia"));

        // Printing out the size of the set in number form
        System.out.println("Number count of the set: " + country.size());

        // Brand-new set to show demonstration of particular main operations
        Set<String> europeCountry = new HashSet<>();
        europeCountry.add("France");
        europeCountry.add("Belgium");
        europeCountry.add("Italy");
        europeCountry.add("Greece");

        // Printing out this new 2nd set
        System.out.println("Europe Countries Set: " + europeCountry);

        // Union of two sets from Collection interface notes where addAll
        // adds all the elements in the specified collection to this collection
        Set<String> addingSet = new HashSet<>(country);
        addingSet.addAll(europeCountry);
        System.out.println("Union of 2 Sets: " + addingSet);

        // Intersection of two sets from Collection interface notes where
        // it retains the elements in this collection that are also present in the specified collection
        Set<String> retainingSet = new HashSet<>(country);
        retainingSet.retainAll(europeCountry);
        System.out.println("Intersection of 2 Sets (Note: no intersection present since 1st set's basis isn't European countries): " + retainingSet);

        // Difference of two sets from Collection interface notes where
        // removeAll method removes the elements from this collection that are present in the specified collection
        Set<String> removingSet = new HashSet<>(country);
        removingSet.removeAll(europeCountry);
        System.out.println("Difference of 2 Sets: " + removingSet);
    }
}

