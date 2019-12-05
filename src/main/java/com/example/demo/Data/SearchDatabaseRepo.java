package com.example.demo.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


    @Repository
    public class SearchDatabaseRepo implements SearchDatabaseInterface {

        //Creating JDBC connection and giving it to class. Used to get data from database.
        @Autowired
        private JdbcTemplate jdbcTemplate;

        public SearchDatabaseRepo(JdbcTemplate aTemplate) {
            jdbcTemplate = aTemplate;
        }


        public List<BookingStatus> findByEvent(int e) {
            return jdbcTemplate.query("select FirstName,SurName, dietReq, teammembers from BookingStatus bs Inner join People p on p.PeopleId = bs.PeopleID where eventId = ?",
                    new Object[]{e},
                    (rs, i) -> new BookingStatus(
                            rs.getString("FirstName"),
                            rs.getString("SurName"),
                            rs.getString("dietReq"),
                            rs.getString("teammembers")
                    )
            );
        }


        public List<Events> showByEventId(int e) {
            return jdbcTemplate.query("select Name,FirstName,SurName,Location,e.Date,e.Time, Description, e.EventId, DietReq, TeamBased, TeamSize, p.Email " +
                            "from Events e inner join People p on p.PeopleId = e.Organiser where eventId =?",
                    new Object[]{e},
                    (rs, i) -> new Events(
                            rs.getString("Name"),
                            rs.getString("FirstName"),
                            rs.getString("SurName"),
                            rs.getString("Location"),
                            rs.getString("Date"),
                            rs.getString("Time"),
                            rs.getString("Description"),
                            rs.getInt("eventID"),
                            rs.getInt("DietReq"),
                            rs.getInt("TeamBased"),
                            rs.getInt("TeamSize"),
                            rs.getString("email")

                    )
            );
        }








}
