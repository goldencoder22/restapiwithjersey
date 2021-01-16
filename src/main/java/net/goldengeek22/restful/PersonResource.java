package net.goldengeek22.restful;

import net.goldengeek22.models.Person;
import net.goldengeek22.repositories.PersonRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("persons")
public class PersonResource {

    /*
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Person getPerson() {

        return new Person("AMEVOR", "Alexandre", 20);
    }*/

    PersonRepository personRepository = new PersonRepository();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Person> getPersons() {
        return personRepository.getPersons();
    }

    @GET
    @Path("person/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Person getPersonById(@PathParam("id") int id) {
        return personRepository.getPersonById(id);
    }

    @POST
    @Path("person")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Person createPerson(Person person) {

        System.out.println(person);
        person = this.personRepository.savePerson(person);

        return person;
    }
}
