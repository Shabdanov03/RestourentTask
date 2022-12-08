package impl;

import classes.Person;
import enams.Country;
import enams.Foods;
import enams.Status;
import impl.comporator.Commorator;
import service.PersonInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Personimpl implements PersonInterface {
    private ArrayList<Person> createdPerson = new ArrayList<>();

    public ArrayList<Person> getCreatedPerson() {
        return createdPerson;
    }

    public void setCreatedPerson(ArrayList<Person> createdPerson) {
        this.createdPerson = createdPerson;
    }

    @Override
    public String createPerson(ArrayList<Person> people) {
        this.createdPerson.addAll(people);
            return "Person successful created !";
        }

    @Override
    public String insertPerson(ArrayList<Person> people) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter by name : ");
        String name= scanner.nextLine();
        System.out.println(" Enter by year, month, day : ");
        LocalDate year = LocalDate.of(scanner.nextInt(), scanner.nextInt(),scanner.nextInt());
        System.out.println(" 1.Client.  2.Kitchen Manager. 3.Waiter.  4.Head Chef ");
        System.out.println("Enter by command : ");
        int num = scanner.nextInt();
        Status status=null;
        switch (num){
            case 1 -> status=Status.CLIENT;
            case 2 -> status=Status.KITCHEN_MANAGER;
            case 3 -> status=Status.WAITER;
            case 4 -> status=Status.HEAD_CHEF;
            default -> System.out.println(" No such status");
        }
        System.out.println(" Enter by bank account : ");
        double bank = scanner.nextDouble();
        System.out.println("1.Kyrgyzstan.  2.French.  3.Russian.  4.USA.");
        System.out.println(" Enter by command :");
        Country country= null;
        int number = scanner.nextInt();
        switch (number){
            case 1 -> country=Country.KYRGYZSTAN;
            case 2 -> country=Country.FRENCH;
            case 3 -> country=Country.RUSSIAN;
            case 4 -> country=Country.USA ;
            default -> System.out.println(" No such country");
        }
        Person person =new Person(name,year,status,bank,country);
        createdPerson.add(person);
            return " Successfully insert !";

    }

    @Override
    public List<Person> getAllPerson(ArrayList<Person> people) {
        return this.createdPerson;
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
