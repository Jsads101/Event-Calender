package com.example.demo.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


@Repository
public class SearchEventsRepo{

    //Creating JDBC connection and giving it to class. Used to get data from database.
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SearchEventsRepo(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }


    public List<Events> findByEvent() {
        return jdbcTemplate.query("select Name,FirstName,SurName,Location,e.Date,e.Time,e.EventId " +
                        "from Events e inner join People p on p.PeopleId = e.Organiser WHERE DATE > NOW() ORDER BY DATE",
                new Object[]{},
                (rs, i) -> new Events(
                        rs.getString("Name"),
                        rs.getString("FirstName"),
                        rs.getString("SurName"),
                        rs.getString("Location"),
                        rs.getString("Date"),
                        rs.getString("Time"),
                        rs.getInt("eventID")

                )
        );
    }
}
