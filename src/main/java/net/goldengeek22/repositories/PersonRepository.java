package net.goldengeek22.repositories;

import net.goldengeek22.models.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonRepository {

    List<Person> persons;

    public PersonRepository() {
        persons = new ArrayList<>();
        Person person1 = new Person(1, "AMEVOR", "Alexandre", 20);
        Person person2 = new Person(2, "AMEVOR", "Jennifer", 18);

        persons.addAll(Arrays.asList(person1, person2));
    }

    public List<Person> getPersons() {
        return persons;
    }

    public Person getPersonById(int id) {
        return persons.stream().filter(person -> person.getId() == id).findFirst().get();
    }

    public Person savePerson(Person person) {
        this.persons.add(person);

        return person;
    }
}
