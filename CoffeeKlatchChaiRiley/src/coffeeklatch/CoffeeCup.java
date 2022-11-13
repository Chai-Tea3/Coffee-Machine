/**
 * Author: Riley Chai 
 * Class: ICS4U 
 * Program: Coffee Klatch
 */
package coffeeklatch;

/**
 *
 * @author Riley Chai
 */
public class CoffeeCup {

    private boolean isFull;// Is this cup full?  Default value false.
    private String cupName;//Name of the customer.

    /**
     * Creates a new coffee cup with the customer's name.
     *
     * @param ownerName The customer's name.
     */
    CoffeeCup(String ownerName) {//Each new coffee cup requires a name to be associated with it.
        cupName = ownerName;//Sets the cup name to the customer's name.
    }

    /**
     * Fill this cup to the top.
     *
     * @param cMachine The coffee machine.
     */
    public void fill(CoffeeMachine cMachine) {
        if (cMachine.brewStatus() == true && isFull == false) {//Ensures that the coffee has been brewed and the cup is empty before pouring a cup.
            if (cMachine.getLevel() >= cMachine.getSizeInt()) {//Checks if there is enough coffee left to pour a cup of the desired size.
                System.out.println("~ " + cMachine.getStrength() + " coffee is poured for " + cupName);
                cMachine.subtractLevel(cMachine.getSizeInt());//Subract the respective units from the reservoir 
                isFull = true;//The cup is now full.
            } 
            else {//If there is not enough coffee remaining, the user must brew more coffee.
                System.out.println("**Not enough coffee remaining, please brew more**");
                //Reset variables to allow the user to brew more coffee.
                cMachine.reset();//Resets the coffee machine.
                reset();//Resets the cup.
            }
        } 
        else if (isFull == true) {//If the cup is already full.
            System.out.println("**The coffee has already been poured**");
        } 
        else if (cMachine.customerStatus() == false) {//Checks if a customer has been created.
            System.out.println("**Please create a new customer first (n)**");
        } 
        else {//If the coffee has not been brewed yet.
            System.out.println("**You must brew the coffee first (b)**");
        }
    }

    /**
     * Drink this cup entirely.
     *
     * @param cMachine The coffee machine.
     */
    public void drink(CoffeeMachine cMachine) {
        if (isFull == true) {//Checks to make sure the cup is full before allowing the user to drink.
            System.out.println("~ " + cupName + " glugs the coffee down.");
            isFull = false;//Changes the cup state to empty
        } 
        else if (cMachine.customerStatus() == false) {//Checks if a customer has been created.
            System.out.println("**Please create a new customer first (n)**");
        } 
        else if (cMachine.brewStatus() == false) {//Checks if the coffee has not been brewed yet.
            System.out.println("**You must brew the coffee first (b)**");
        } 
        else {//If the is cup currently empty and coffee has been brewed.
            System.out.println("~ " + cupName + " sips furiously, but only sucks air.");
            if (cMachine.getLevel() >= cMachine.getSizeInt()) {//If there is still enough coffee to fill a cup.
                System.out.println("**Please pour a cup first**");
            } 
            else {//If there is not enough coffee in the pot to pour another cup.
                System.out.println("**Please brew more coffee**");
                //Reset variables to allow the user to brew more coffee.
                cMachine.reset();//Resets the coffee machine.
                reset();//Resets the cup.
            }
        }
    }

    /**
     * Returns whether this cup is full (true) or empty(false);
     *
     * @return isFull - is this cup full?
     */
    public boolean isFull() {
        return isFull;
    }

    /**
     * Returns the name of the coffee cup.
     *
     * @return cupName - A String representing the customer's name.
     */
    public String getName() {
        return cupName;
    }

    /**
     * Resets variables when there is no longer enough coffee in the pot, or
     * another customer is created.
     *
     */
    public void reset() {
        isFull = false;
    }
}
