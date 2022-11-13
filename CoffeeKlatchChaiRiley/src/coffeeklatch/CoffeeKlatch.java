/**
 * Author: Riley Chai
 * Class: ICS4U
 * Program: Coffee Klatch
 */
package coffeeklatch;

import java.util.Scanner;

/**
 *
 * @author Riley Chai
 */
public class CoffeeKlatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean machineOn = true;//Keeps the program running until the user decides to exit
        //Ensures the user enters a valid option.
        boolean isValid = false;//Ensures a name is entered
        boolean cupChosen = false;//Ensures an avalible cup size is selected.
        boolean strengthChosen = false;//Ensures an avalible strength is selected.

        String cupName = "";//Name of the customer.
        String userChoice = "";//Stores the option chosen by the user.

        CoffeeMachine cMachine;// Declare a reference to a CoffeeMachine.       
        cMachine = new CoffeeMachine();// Create a new CoffeeMachine and make the variable refer to it.
        CoffeeCup cCup = new CoffeeCup("None");//Creates a new coffee cup and makes a variable refer to it.

        while (machineOn == true) {//Loops the program until the user chooses to exit

            //Displays the current status of all steps in the coffee machine, the user's name, cup size, and coffee strength.
            System.out.printf("\n\t\t\t COFFEE MACHINE \t\t\t" + "USER: " + cCup.getName() + "\t" + "Cup Size: " + cMachine.getSize() + "\n");
            System.out.printf("\t Water \t Level \t Beans \t BeansGround \t CoffeeBrewed \t Cup full \t Strength \n");
            System.out.printf("\t " + cMachine.waterStatus() + "\t " + cMachine.getLevel() + "\t " + cMachine.beansStatus() + "\t " + cMachine.groundStatus() + "\t\t "
                    + cMachine.brewStatus() + "\t\t " + cCup.isFull() + "\t\t " + cMachine.getStrength() + "\n\n");

            //Displays all options
            System.out.printf("OPTION: n - New Customer \n"
                    + "\tw - Add Water\n"
                    + "\tc - Add Coffee Beans\n"
                    + "\tg - Grind Beans\n"
                    + "\tb - Brew Coffee\n"
                    + "\tp - Pour a Cup\n"
                    + "\td - Drink a Cup\n"
                    + "\tx - Exit\n");
            System.out.print("Please choose an option: ");
            userChoice = keyboard.nextLine();

            if (userChoice.length() == 1) {//Ensures the user only enters one character.
                switch (userChoice.charAt(0)) {//Avalible options are: n, w, c, g, b, p, d, and x.
                    case 'n'://New Customer
                        //Resets all variables when a new customer is created
                        isValid = false;
                        strengthChosen = false;
                        cupChosen = false;
                        cMachine.reset();
                        cCup.reset();

                        //Loops until all information is correctly entered
                        while (isValid == false) {
                            System.out.print("Please enter your name: ");
                            cupName = keyboard.nextLine();
                            if (inputValidation(cupName) == true) {//Ensures the input is not empty
                                cCup = new CoffeeCup(cupName);//Updates the name on the coffee cup
                                isValid = true;
                            }
                        }
                        while (cupChosen == false) {//Repeats until valid option is selected
                            System.out.print("Please enter the desired cup size. Small(s), Medium(m), Large(l): ");//Displays all avalible options
                            userChoice = keyboard.nextLine();
                            if (userChoice.length() == 1) {//Ensures the user only enters one character.
                                //setSize method will set cupChosen to true if a valid option is chosen and allow the program to proceed to the next promt.
                                cupChosen = cMachine.setSize(userChoice);//Determines if a valid size is selected and sets it as the current cup size
                            } else {//If the user does not choose an option/empty input.
                                System.out.println("**Invalid input. Please try again**");//Informs the user to try again
                            }
                        }
                        while (strengthChosen == false) {//Repeats until valid option is selected
                            System.out.print("Please enter the strength of coffee. "
                                    + "Weak(w), Regular(r), Strong(s), or Killer Intense(k): ");//Displays all avalible options.
                            String cStrength = keyboard.nextLine();
                            if (cStrength.length() == 1) {//Ensures the user only enters one character.
                                //strengthChosen will be set to true if a valid option was selected and allows the program to continue.
                                strengthChosen = cMachine.setStrength(cStrength);//Checks if a valid option was selected and changes the coffee strength.
                            } else {//If the user does not choose an option/empty input.
                                System.out.println("**Invalid input. Please try again**");//Informs the user to try again
                            }
                        }
                        break;

                    case 'w'://Adds water to the coffee machine
                        cMachine.addWater();
                        break;

                    case 'c'://Adds coffee beans to the machine
                        cMachine.addBeans();
                        break;

                    case 'g'://Grinds the coffee beans
                        cMachine.grindBeans();
                        break;

                    case 'b'://Brews the coffee
                        cMachine.brew(cCup);
                        break;

                    case 'p'://Pours a cup
                        cCup.fill(cMachine);
                        break;

                    case 'd'://Drink the cup of coffee
                        cCup.drink(cMachine);
                        break;

                    case 'x'://Exits the loop and ends the program
                        System.out.println("~ MACHINE OFF");
                        machineOn = false;
                        break;

                    default://If the user fails to choose one of the options
                        System.out.println("**Please choose one of the options**");
                        break;
                }

            } else {//If the user enters nothing
                System.out.println("**Please choose one of the options**");
            }
        }
        keyboard.close();//Closes the scanner.
    }

    /**
     * Performs type verification for the customer's name. The name must not be
     * empty and must start with a letter.
     *
     * @param name The user entry.
     * @return isValid - If the name is valid(true), if not(false).
     */
    public static boolean inputValidation(String name) {
        boolean isValid = false;
        if (name.length() > 0) {//Ensures the input is not empty.
            int ASCII = (int) name.charAt(0);//Retreives the ASCII code of the first character.
            if (ASCII >= 65 && ASCII <= 122) {//Checks if the first character is a letter.
                isValid = true;
            } else {//Inform the user to try again.
                System.out.println("**Name should start with a letter**");
                isValid = false;
            }
        } else {//If the user enters nothing
            System.out.println("**Empty input. Please try again**");//Informs the user to try again
            isValid = false;
        }
        return isValid;
    }
}
