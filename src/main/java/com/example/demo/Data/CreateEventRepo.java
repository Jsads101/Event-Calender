package com.example.demo.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.servlet.http.HttpSession;
import java.security.cert.Certificate;
import java.util.Iterator;
import java.util.List;

@Repository
public class CreateEventRepo  implements CreateEventInterface{

    /*
    Constructor instructs Spring to inject a dependency (see slides + online documentation)
    The JdbcTemplate object provides methods for accessing the database. The connection
    is configured from the properties defined in resources -> application.properties.
    */
    private JdbcTemplate jdbcTemplate;
    HttpSession session;

    @Autowired
    public CreateEventRepo(JdbcTemplate aTemplate, HttpSession session) {
        jdbcTemplate = aTemplate;
        this.session = session;
    }

    @Override
    public int addEvent(CreateEvent createEvent) {
        return jdbcTemplate.update("insert into Events(Name, Organiser, Description, Location, TeamBased, DietReq, Date, Time)  values(?,?,?,?,?,?,?,?)",
                createEvent.getEventTitle(),
                5,   //session.getAttribute("SESSION_USERNAME"),
                createEvent.getEventDesc(),
                createEvent.getLocation(),
                0,
                0,
                createEvent.getEventDate(),
                createEvent.getEventTime());
    }

    //TODO create a function to select form the Events table EventId of the newly created event.
    //Need to get eventId which is validated in terms of event name and date - there can be reoccurring events with the same name time location and desc.
//    public List<Events> getEventId(int e) {
//        return jdbcTemplate.query("select EventId from Events where Name = eventId.getEventTitle() and Date = eventId.getEventDate",
//                new Object[]{e},
//                (rs, i) -> new Events(
//                rs.getInt("EventId")
//                );
//
//    }

//    CreateEvent list = new CreateEvent();

//    @Override
//    public int addAttendees(CreateEvent attendees) {
//        for (int i = 0; i < list.attendees.size(); i++) {
//            return jdbcTemplate.update("insert into BookingStatus(PeopleId, eventId, statusId) " +
//                            "select People.PeopleId, Events.EventId,? from People, Events " +
//                            "where Email = ? and EventId = ?",
//                    3,
//                    list.attendees.get(i),
//                    attendees.getEventId()); //it should get eventId form the above method
//        }
//    }


}
