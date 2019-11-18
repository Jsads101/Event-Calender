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


        public List<BookingStatus> findByEvent(int eventId) {
            return jdbcTemplate.query("select PeopleId, DietReq",
                    new Object[]{},
                    (rs, i) -> new BookingStatus(
                            rs.getInt("PeopleId"),
                            rs.getString("DietReq")

                    )
            );
        }
}
