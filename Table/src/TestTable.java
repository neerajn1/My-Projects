// Testing the 'Table' class
public class TestTable {
    public static void main(String[] args) {
        //2 Table objects one set with default values in code while second is custom values as per parameter constructor
        Table table1 = new Table();
        Table table2 = new Table("Metal", 4, 6, "Dining", "Vintage", 2000);

        // Printing information for each Table object
        System.out.println("Table 1's make: " + table1.getMake() + "  Model: " + table1.getModel() + "  Year: " + table1.getYear());
        System.out.println("Table 1's material: " + table1.getMaterial() + "  Length: " + table1.getLength() + "  Width: " + table1.getWidth());
        System.out.print("\n");
        System.out.println("Table 2's make: " + table2.getMake() + "   Model: " + table2.getModel() + "   Year: " + table2.getYear());
        System.out.println("Table 2's material: " + table2.getMaterial() + "  Length: " + table2.getLength() + "  Width: " + table2.getWidth());
    }
}
