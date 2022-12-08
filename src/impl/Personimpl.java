package impl;

import classes.Person;
import enams.Foods;
import enams.Status;
import impl.comporator.Commorator;
import service.PersonInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Personimpl implements PersonInterface {

    @Override
    public String createPerson(ArrayList<Person> people) {
        ArrayList<Person> createPerson = new ArrayList<>();
        for (Person person : people) {
            createPerson.add(person);
            System.out.println(createPerson);
        }
        return "Person successful created !";
    }

    @Override
    public List<Person> getAllPerson(ArrayList<Person> people) {
        return people;
    }

    @Override
    public List<Foods> getAllFood(ArrayList<Foods> foods) {
        System.err.println("  Menu : ");
        return foods;

    }

    @Override
    public String sortByPrice(ArrayList<Foods> foods) {
        Commorator commorator = new Commorator();
        foods.sort(commorator);
        for (Foods food : foods) {
            System.out.print(" " + food);
        }
        return "Successful sort a price !";
    }

    @Override
    public String removeByFood(ArrayList<Foods> foods, String nameFood) {

        while (true) {
            try {
                {
                    if (foods.isEmpty()) {
                        throw new Exception();
                    } else {
                        if (Foods.WATER.getName().equals(nameFood)) {
                            foods.remove(Foods.WATER);
                        }
                        if (Foods.FISH_SEAFOOF.getName().equals(nameFood)) {
                            foods.remove(Foods.FISH_SEAFOOF);
                        }
                        if (Foods.TASTY.getName().equals(nameFood)) {
                            foods.remove(Foods.TASTY);
                        }
                        if (Foods.MEAT_POULSTRY.getName().equals(nameFood)) {
                            foods.remove(Foods.MEAT_POULSTRY);
                        } else {
                            if (foods.isEmpty()) {
                                throw new Exception();
                            }
                        }
                        return " Food successful remove ! ";
                    }
                }
            } catch (Exception e) {
                return " Your menu is empty ! ";
            }
        }
    }

    @Override
    public void sortByStatus(ArrayList<Person> people) {
        ArrayList<Person> client = new ArrayList<>();
        ArrayList<Person> chefs = new ArrayList<>();
        for (Person person : people) {
            if (person.getStatus().equals(Status.CLIENT)) {
                client.add(person);
            } else {
                chefs.add(person);
            }
        }
        System.out.println(" Cleints array : ");
        System.out.println(client);
        System.out.println("=================================");
        System.out.println(" Sotrudnik array : ");
        System.out.println(chefs);
        System.out.println("Successful sort by status !");
    }

    @Override
    public void check(ArrayList<Foods> foods) {
        System.out.println(" Your check ! ");
        double check = 0;
        for (Foods food : foods) {
            System.out.println(food.getName() + " " + food.getPrice());
            check += food.getPrice();
        }
        System.out.println(" In All : " + check);
    }


    @Override
    public String payForFood(ArrayList<Foods> foods, ArrayList<Person> people) {
        try {

            int i = 0;
            if (people.get(i).getBankAccount() > 0) {
                Person clientPerson = null;
                for (Person person : people) {
                    if (person.getStatus().equals(Status.CLIENT)) clientPerson = person;
                }
                double summa = 0;
                for (Foods food : foods) {
                    summa += food.getPrice();
                }
                double bankAccount = clientPerson.getBankAccount() - summa;
                clientPerson.setBankAccount(bankAccount);
                int counter = 0;
                for (Person person : people) {
                    if (!(person.getStatus().equals(Status.CLIENT))) {
                        counter++;
                    }
                }

                double salary = summa / counter;
                for (Person person : people) {
                    if (!(person.getStatus().equals(Status.CLIENT))) {
                        person.setBankAccount(person.getBankAccount() + salary);
                    }
                }
                return " Money successful take away !" +
                        "\n Thank you we are still waiting for you ! ";
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            return "The client has no money left !";
        }
    }

}
