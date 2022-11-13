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
public class CoffeeMachine {

    //Customer variables.
    private String strength = "Killer Intense";//Default intensity of the coffee.
    private String cupSize = "None";//Stores the cup size to be displayed.
    private int cupSizeInt = 0;//The amount of coffee required for each cup.

    //Status of all the different stages in the coffee machine.
    private boolean hasCustomer = false;//If a customer has been created.
    private boolean strengthChosen = false;//If the coffee strength has been chosen.
    private boolean cupChosen = false;//If the cup size has been chosen.
    private boolean hasWater = false;//If water has been added.
    private boolean hasBeans = false;//If the beans have been added.
    private boolean isGround = false;//If the beans have been ground.
    private boolean isBrewed = false;//If the coffee is brewed.
    private int coffeeLevel = 0;//Current amount of coffee in the pot.

    /**
     * Determines if the user selected a valid option (s, m, or l). If yes,
     * saves the users choice and displays the size that was chosen. If not,
     * informs the user to try again.
     *
     * @param s The users choice.
     * @return cupChosen - A boolean representing if a valid(true) or
     * invalid(false) option was chosen.
     */
    public boolean setSize(String s) {
        //Sets the cup size based on the users choice.
        switch (s.toLowerCase().charAt(0)) {//Coverts the user entry to lowercase in order to accept uppercases aswell.
            case 's'://Small
                cupSize = "SMALL";
                cupSizeInt = 2;//Will require 2 units to fill.
                System.out.println("~ Small - selected");
                cupChosen = true;//A proper option was selected.
                break;
            case 'm'://Medium
                cupSize = "MEDIUM";
                cupSizeInt = 3;//Will require 3 units to fill.
                System.out.println("~ Medium - selected");
                cupChosen = true;//A proper option was selected.
                break;
            case 'l'://Large
                cupSize = "LARGE";
                cupSizeInt = 4;//Will require 4 units to fill.
                System.out.println("~ Large - selected");
                cupChosen = true;//A proper option was selected.
                break;
            default://If the user does not choose a valid option.
                System.out.println("**Sorry we do not offer that cup size. Please try again.**");
                cupChosen = false;//Invalid option, the user will have to try again.
                break;
        }
        return cupChosen;
    }

    /**
     * Set the strength of the Coffee to s; affects the fineness of the grind.
     * "Weak", "Regular", "Strong" are the usual options for s, but you can try
     * others.
     *
     * @param s Text Description of Strength
     * @return strengthChosen - A boolean representing if a valid(true) or
     * invalid(false) option was chosen.
     */
    public boolean setStrength(String s) {
        //Sets the strength to the users choice.
        switch (s.toLowerCase().charAt(0)) {//Coverts the user entry to lowercase in order to accept uppercases aswell.
            case 'w':
                strength = "weak";
                System.out.println("~ Weak - selected");
                strengthChosen = true;//A proper option was selected.
                break;
            case 'r':
                strength = "regular";
                System.out.println("~ Regular - selected");
                strengthChosen = true;//A proper option was selected.
                break;
            case 's':
                strength = "strong";
                System.out.println("~ Strong - selected");
                strengthChosen = true;//A proper option was selected.
                break;
            case 'k':
                strength = "killer intense";
                System.out.println("~ Killer intense - selected");
                strengthChosen = true;//A proper option was selected.
                break;
            default:
                System.out.println("**Sorry we do not offer that strength. Please try again**");
                strengthChosen = false;//Invalid option, the user will have to try again.
                break;
        }
        hasCustomer = true;//Allows the user to use the coffee machine.
        return strengthChosen;
    }

    /**
     * Grinds the beans for the coffee.
     */
    public void grindBeans() {
        if (hasBeans == true && isGround == false) {//Ensures the beans have been added and that they have not been ground yet.
            isGround = true;//Beans have been ground.
            System.out.println("~ Grinding beans for "
                    + strength + " coffee.");
        } 
        else if (isGround == true) {//If the beans have already been ground.
            System.out.println("**The beans have already been ground**");
        } 
        else if(hasCustomer == false){//Checks if a customer has been created.
            System.out.println("**Please create a new customer first (n)**");
        }
        else {//If the beans have not been added yet.
            System.out.println("**You must add the beans first (c)**");
        }
    }

    /**
     * Brew the coffee into given cup c
     *
     * @param c The cup of coffee to be filled
     */
    public void brew(CoffeeCup c) {
        //Ensures that water has been added, beans are ground, and that the coffee has not already been brewed.
        if (hasWater == true && isGround == true && isBrewed == false) {
            System.out.println("~ Brewing " + strength + " coffee for " + c.getName());
            coffeeLevel = 10;//Sets the total amount of coffee in the pot to 10 units.
            isBrewed = true;//The coffee is brewed and is ready to be poured.
        } 
        else if (isBrewed == true) {//If the coffee was already brewed.
            System.out.println("**The coffee has already been brewed**");
        } 
        else if(hasCustomer == false){//Checks if a customer has been created.
            System.out.println("**Please create a new customer first (n)**");
        }
        else if (hasWater != true) {//If water has not been added.
            System.out.println("**You must add water first (w)**");
        } 
        else {//If the beans have not been ground.
            System.out.println("**You must grind the beans first (g)**");
        }
    }

    /**
     * Add water to the machine reservoir
     */
    public void addWater() {
        if (hasWater == false && hasCustomer == true) {//Ensures a customer has been created and that the water has not already been added.
            hasWater = true;//Adds water to the machine.
            System.out.println("~ Adding Water");
        } 
        else if (hasCustomer == false) {//If a customer has not been created.
            System.out.println("**Please create a new customer first (n)**");
        } 
        else {//If the water has already been added.
            System.out.println("**Water has already been added**");
        }
    }

    /**
     * Add Beans to the Machine
     */
    public void addBeans() {
        if (hasBeans == false && hasCustomer == true) {//Ensures a customer has been created and that the beans has not already been added.
            hasBeans = true;//Adds beans to the machine
            System.out.println("~ Adding Beans");
        } 
        else if (hasCustomer == false) {//If a customer has not been created.
            System.out.println("**Please create a new customer first (n)**");
        } 
        else {//If the beans have already been added.
            System.out.println("**Beans have already been added**");
        }
    }

    /**
     * Returns the cup size chosen by the user.
     *
     * @return cupSize - A string representation of the size.
     */
    public String getSize() {
        return cupSize;
    }

    /**
     * Returns a numerical value for the size of the cup.
     *
     * @return cupSizeInt - An integer representation of the size.
     */
    public int getSizeInt() {
        return cupSizeInt;
    }

    /**
     * Returns the strength of coffee chosen by the user.
     *
     * @return strength - A string which represents the strength of the coffee.
     */
    public String getStrength() {
        return strength;
    }

    /**
     * Checks if water has been added to the machine.
     *
     * @return hasWater - If the machine has water(true), if not(false).
     */
    public boolean waterStatus() {
        return hasWater;
    }

    /**
     * Checks if the beans have been added to the machine.
     *
     * @return hasBeans - If the machine has beans(true), if not(false).
     */
    public boolean beansStatus() {
        return hasBeans;
    }

    /**
     * Checks if the beans have been ground.
     *
     * @return isGround - If the beans have been ground(true), if not(false)
     */
    public boolean groundStatus() {
        return isGround;
    }

    /**
     * Checks if the coffee has been brewed.
     *
     * @return isBrewed - If the coffee has been brewed(true), if not(false)
     */
    public boolean brewStatus() {
        return isBrewed;
    }

    /**
     * Subtracts the amount of coffee required to fill cup from the total level.
     *
     * @param amountRequired The size of the cup.
     */
    public void subtractLevel(int amountRequired) {
        coffeeLevel -= amountRequired;
    }

    /**
     * Returns the total amount of coffee in the reservoir.
     *
     * @return coffeeLevel - An integer representing the amount of coffee
     * remaining.
     */
    public int getLevel() {
        return coffeeLevel;
    }
    /**
     * Checks if a customer has been created.
     * @return hasCustomer - If yes(true), if not(false).
     */
    public boolean customerStatus(){
        return hasCustomer;
    }

    /**
     * Resets all status variables when the machine runs out of coffee, or when
     * a new customer is created.
     */
    public void reset() {
        strengthChosen = false;
        cupChosen = false;
        hasWater = false;
        hasBeans = false;
        isGround = false;
        isBrewed = false;
        coffeeLevel = 0;
    }
}
