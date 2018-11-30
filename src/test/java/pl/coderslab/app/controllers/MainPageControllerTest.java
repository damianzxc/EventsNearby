package pl.coderslab.app.controllers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.coderslab.app.model.Category;
import pl.coderslab.app.model.Event;
import pl.coderslab.app.model.User;
import pl.coderslab.app.services.EventService;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MainPageControllerTest {

    private Event event;
    private EventService eventService;
    private Category cat1;
    private User user;

    @Before
    public void before(){

        event = new Event();
        eventService = new EventService();
        cat1 = new Category();
        cat1.setName("Koncert");
        user = new User();
        user.setLogin("login123");
        user.setEmail("email@o2.pl");

        event.setName("Nazwa");
        event.setCategory(cat1);
        event.setCity("Katowice");
        event.setStreet("Krakowska 52");
        event.setStartDate(LocalDate.now().minusDays(2));
        event.setEndDate(LocalDate.now().plusDays(5));
        event.setUser(user);
        event.setDescription("jakiś opis eventu");

    }

    @After
    public void after(){}

    @Test(expected = Exception.class)
    public void events() {
        //given
        Event newEvent = this.event;

        //when
        eventService.addEvent(newEvent);

        //then
        assertThat("Wrong or null event name", newEvent.getName(), is("Nazwa"));
        assertThat("Wrong event category", newEvent.getCategory().getName(), is("Koncert"));
        assertThat("Wrong Event City", newEvent.getCity(), is("Katowice"));
        assertThat("Wrong address", newEvent.getStreet(), is("Krakowska 52"));
        assertThat("Wrong startDate", newEvent.getStartDate(), is(LocalDate.now().minusDays(2)));
        assertThat("Wrong endDate", newEvent.getEndDate(), is(LocalDate.now().plusDays(5)));
        assertThat("Wrong user login", newEvent.getUser().getLogin(), is("login123"));
        assertThat("Wrong user email", newEvent.getUser().getEmail(), is("email@o2.pl"));
    }
}