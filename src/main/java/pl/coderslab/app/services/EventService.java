package pl.coderslab.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.model.Event;
import pl.coderslab.app.repositories.EventRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class EventService {

    @Autowired
    private EventRepository eventRepository;


    public void addEvent(Event event){ eventRepository.save(event);
    }

    public List<Event> findEventsByCategoryId(Long id){
        List<Event> events = eventRepository.getEventsByCategoryId(id);
        return events;
    }

    public List<Event> findAllOrderByEndDate(){
        List<Event> events = eventRepository.getAllOrderByEndDate();
        return events;
    }

    public Event findOneById(Long id){
        Event event = eventRepository.findOne(id);
        return event;
    }

    public List<Event> findByName(String name){
        List<Event> events = eventRepository.getEventsByNameLikeOrderByStartDate("%"+name+"%");
        return events;
    }

    public List<Event> findEventsByUserId(Long id){
        List<Event> events = eventRepository.getEventsByUserId(id);
        return events;
    }

    public void deleteEvent(Long id){
        eventRepository.delete(id);
    }

    public boolean checkEndDate(Event event){
        return event.getEndDate().isAfter(LocalDate.now());
    }

    public boolean checkDates(Event event){
        return event.getEndDate().isAfter(event.getStartDate());
    }



}
