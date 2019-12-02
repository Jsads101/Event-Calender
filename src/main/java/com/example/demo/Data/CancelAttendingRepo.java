package com.example.demo.Data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;


@Repository
public class CancelAttendingRepo implements CancelAttendingInterface {

    //Creating JDBC connection and giving it to class. Used to get data from database.
//    @Autowired
    private final JdbcTemplate jdbcTemplate;
    private HttpSession session;

    public CancelAttendingRepo(JdbcTemplate aTemplate, HttpSession session) {
        jdbcTemplate = aTemplate;
        this.session = session;
    }

    @Override
    public int cancelAttending(int eventId) {
        jdbcTemplate.update("DELETE FROM BookingStatus WHERE peopleId=(?) AND eventId=(?);",
                getSessionID(), eventId
        );
        return 0;
    }

    public int getSessionID() {
        return jdbcTemplate.queryForObject("select PeopleId from People where Email = ?",
                new Object[]{session.getAttribute("SESSION_USERNAME")},
                (rs, i) -> new Integer(
                        rs.getInt("PeopleId")
                )
        );
    }
}