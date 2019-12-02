package com.example.demo.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.http.HttpSession;
import java.util.List;


@Repository
public class SignUpRepo implements SignUpInterface {

    //Creating JDBC connection and giving it to class. Used to get data from database.
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private HttpSession session;
    private int peopleID;


    public SignUpRepo (JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    @Override
    public int signUp (BookingStatus bookingStatus) {
        /*peopleID = jdbcTemplate.query("select PeopleId from people where Email = ?",
                new Object[]{session.getAttribute("SESSION_USERNAME")},
                (rs, i) -> new BookingStatus(
                        rs.getInt("peopleID")
                )
        );*/
        return jdbcTemplate.update("insert into BookingStatus(peopleId, eventId, statusId, dietReq)  values(?,?,?,?)",
                bookingStatus.getPeopleId(), bookingStatus.getEventId(), bookingStatus.getStatusId(), bookingStatus.getDietReq());

    }
}
