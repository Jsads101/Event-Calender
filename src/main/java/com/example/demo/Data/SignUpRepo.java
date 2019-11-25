package com.example.demo.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Repository
public class SignUpRepo implements SignUpInterface{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public SignUpRepo(JdbcTemplate aTemplate){
        jdbcTemplate = aTemplate;
    }

    @Override
    public int signUp (BookingStatus bookingStatus){
        return jdbcTemplate.update("insert into BookingStatus(peopleId, eventId, statusId, dietReq) values(?,?,?,?)",
                bookingStatus.getPeopleId(), bookingStatus.getEventId(), bookingStatus.getStatusId(), bookingStatus.getDietReq());
    }
}
