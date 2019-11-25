package com.example.demo.auth.CreateNewEvent;

import com.example.demo.auth.CreateNewEvent.NewEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class NewEventRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public NewEventRepository(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    /*
    Add a new user to the users table in the database using a User object passed
    from RegController which is built from what the user submits as part of the
    registration form.
    */
    private int _addAttendeeToTheTable(NewEvent e){
        String sql = "insert into People(Email) value(?)";
        return jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                //unlike the databases learning resources surrounding tv shows, the user table here does not contain
                // an auto-incrementing field named id, otherwise a second attribute would be added to the line
                // above --> new String[]{"id"}
                ps.setString(1, e.getAttendees());
                return ps;
            }
        });
    }

    /*
        Add a new user to the database.
        User data is added across two tables, which have been split into separate methods here.
    */
    public boolean addEvent(NewEvent e) {
        return _addAttendeeToTheTable(e) > 0;
    }
}
