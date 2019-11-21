package com.example.demo.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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

@Override
        public List<BookingStatus> findByEvent(int e) {
            return jdbcTemplate.query("select bookingStatusId, peopleId, eventId, statusId, dietReq from BookingStatus where eventId = ?",
                    new Object[]{e},
                    (rs, i) -> new BookingStatus(
                            rs.getInt("bookingStatusId"),
                            rs.getInt("peopleId"),
                            rs.getInt("eventId"),
                            rs.getInt("statusId"),
                            rs.getString("dietReq")

                    )
            );
        }
}
