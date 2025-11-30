class College {
    private String name;
    private int yearStarted;

    // Constructor for these 2 above attributes
    public College(String name, int yearStarted) {
        this.name = name;
        this.yearStarted = yearStarted;
    }

    // Getters for the name and year
    public String getName() {
        return name;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    // toString method to print out this array list more simply
    @Override
    public String toString() {
        return "Name : " + name + " , Year Started = " + yearStarted;
    }
}
