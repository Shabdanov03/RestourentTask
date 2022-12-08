import classes.Person;
import enams.Country;
import enams.Foods;
import enams.Status;
import impl.Personimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Ilim", LocalDate.of(2003, 10, 3), Status.CLIENT, 5000, Country.KYRGYZSTAN));
        people.add(new Person("Nuradil", LocalDate.of(2004, 3, 26), Status.KITCHEN_MANAGER, 1000, Country.FRENCH));
        people.add(new Person("Samira", LocalDate.of(2004, 8, 3), Status.WAITER, 1000, Country.USA));
        people.add(new Person("Dastan", LocalDate.of(2003, 7, 9), Status.HEAD_CHEF, 1000, Country.RUSSIAN));

        ArrayList<Foods> foods = new ArrayList<>(List.of(Foods.FISH_SEAFOOF, Foods.TASTY, Foods.WATER, Foods.MEAT_POULSTRY));
        Personimpl personimpl = new Personimpl();


        while (true) {
            System.out.println(" ========Commands========" +
                    "\n========================================================================\n" +
                    "1.get oll Person.  2.Menu by Food .  3.create person.  4.Sort by price " +
                    "\n5.Sort By Status. 6.Order food.  7.Remove by food.  8.Pay for food.\n" +
                    "========================================================================");
            int number = new Scanner(System.in).nextInt();
            if (number == 1) {
                System.out.println(personimpl.getAllPerson(people));
            } else if (number == 2) {
                System.out.println(personimpl.getAllFood(foods));
            } else if (number == 3) {
                System.out.println(personimpl.createPerson(people));
            } else if (number == 4) {
                System.out.println(personimpl.sortByPrice(foods));
            } else if (number == 5) {
                personimpl.sortByStatus(people);
            } else if (number == 6) {
                personimpl.check(foods);
            } else if (number == 7) {
                System.out.println(" Enter name food :");
                String name = new Scanner(System.in).nextLine();
                System.out.println(personimpl.removeByFood(foods, name));
            } else if (number == 8) {
                System.out.println(personimpl.payForFood(foods, people));
            } else {
                System.err.println(" no such command !");
            }
        }


    }
}