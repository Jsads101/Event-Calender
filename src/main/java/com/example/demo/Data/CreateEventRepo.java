package com.example.demo.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

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

    @Autowired
    public CreateEventRepo(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
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
                5,
                createEvent.getEventDesc(),
                createEvent.getLocation(),
                0,
                0,
                createEvent.getEventTime(),
                createEvent.getEventDate());

    }

    /*
    An alternative implementation that uses a PreparedStatement to insert the data rather than raw object data.
    This is a means to help mitigate SQLInjection attacks.
    https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
    https://docs.oracle.com/javase/10/docs/api/java/sql/Connection.html#prepareStatement(java.lang.String,int%5B%5D)

    Additionally, we are using a jdbc GeneratedKeyHolder object (see online docs) to capture the id of the added
    row after it is placed in the database (as this is determined by the database rather than set here).
    */
//    public int addEvent(CreateEvent createEvent) {
//        KeyHolder kh = new GeneratedKeyHolder();
//        String sql="insert into Event(Name, Organiser, Description, Location, TeamBased, DietReq, Date, Time)  values(?,?,?,?,?,?,?,?)";
//        jdbcTemplate.update(new PreparedStatementCreator() {
//                                @Override
//                                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//                                    PreparedStatement ps = connection.prepareStatement(sql, new String[]{"EventId"}); //list of auto-generated key columns
//                                    ps.setString(1, createEvent.getEventTitle());
//                                    ps.setInt(2, 5);
//                                    ps.setString(3, createEvent.getEventDesc());
//                                    ps.setString(4, createEvent.getLocation());
//                                    ps.setInt(5, 0);
//                                    ps.setInt(6, 0);
//                                    ps.setTime(7, createEvent.getEventTime());
//                                    ps.setDate(8, createEvent.getEventDate());
//                                    return ps;
//                                }
//                            }
//                , kh);
//        return kh.getKey().intValue();
//    }

}
