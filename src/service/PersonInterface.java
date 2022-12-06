package service;

import classes.Person;
import enams.Foods;

import java.util.ArrayList;
import java.util.List;

public interface PersonInterface {
    String createPerson(ArrayList<Person> people);
    List<Person> getAllPerson(ArrayList<Person> people);
    List<Foods>getAllFood(ArrayList<Foods> foods);
    String sortByPrice(ArrayList<Foods> foods);
    String removeByFood (ArrayList<Foods> foods,String nameFood);
    void sortByStatus(ArrayList<Person> people );
    String payForFood(ArrayList<Foods> foods,ArrayList<Person> people);

}
