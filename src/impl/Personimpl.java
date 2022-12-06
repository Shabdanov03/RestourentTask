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
        return foods;
    }

    @Override
    public String sortByPrice(ArrayList<Foods> foods) {
        Commorator commorator = new Commorator();
        foods.sort(commorator);
        for (Foods food : foods) {
            System.out.print(" "+food);
        }
        return "Successful sort a price !";
    }

    @Override
    public String removeByFood(ArrayList<Foods> foods, String nameFood) {
        int i = 0;
        for (Foods food : foods) {
            if (nameFood.toLowerCase().equals(food.name())) {
                foods.remove(food);
            }
        }

        return " Food successful remove ! ";
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
    public String payForFood(ArrayList<Foods> foods, ArrayList<Person> people) {

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
        return " Money successful take away ! ";
    }

}
