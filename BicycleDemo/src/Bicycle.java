/*
 * Bicycle class
 * This class models basic state and behavior
 * for Bicycles. The class contains:
 * - 2 example private members, speed and gear
 * - 2 constructors
 * - Accessor methods
 * - Mutator methods
 * - Other general purpose methods
 */

public class Bicycle {
    /*
     * members
     */
    private int speed = 0;
    private int gear = 1;

    /*
     *  constructors
     */

    // no argument constructor
    public Bicycle()
    {

    }

    public Bicycle( int sp, int gr)
    {
        this.speed = sp;
        this.gear = gr;
    }

    /*
     * Methods
     */
    public void speedUp(int amount)
    {
        speed = speed + amount;
    }

    public void slowDown(int amount)
    {
        speed = speed - amount;
    }


    /*
     * accessor methods
     */
    public int getSpeed()
    {
        return speed;
    }

    public int getGear()
    {
        return gear;
    }

    /*
     * mutator methods
     */

    public void setGear(int newValue)
    {
        this.gear = newValue;
    }

    public void setSpeed(int newSpeed)
    {
        this.speed = newSpeed;
    }

} ///~