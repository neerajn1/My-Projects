//the main superclass Fruit
class Fruit {
    String appearance;
    String ripe;

    //constructor which has 2 attributes
    public Fruit(String appearance, String ripe) {
        this.appearance = appearance;
        this.ripe = ripe;
    }

    //method to get fruit details without multiple print line statements
    public void getFruitData() {
        System.out.println("Appearance: " + appearance);
        System.out.println("Ripe?: " + ripe);
    }
}


