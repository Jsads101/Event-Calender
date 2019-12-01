package com.example.demo.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/*
This repository contains all SQL logic and database interaction via JDBC
*/
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

    /*
    An example of inserting data into the database using data from a TVShow object
    Note the JdbcTemplate 'update' method is used here still refers to an insert operation
    See: https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html#update-java.lang.String-java.lang.Object...-
    */
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

    @Override
    public int addAttendees(CreateEvent attendees) {
        return jdbcTemplate.update("insert into BookingStatus(PeopleId, eventId, statusId) " +
                        "select People.PeopleId, ?,? from People " +
                        "where Email = ?",
                21,
                3,
                attendees.getTokenField());
    }

//    public String[] emailList(){
//
//
//    }


}
