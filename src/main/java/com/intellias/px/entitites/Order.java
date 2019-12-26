package com.intellias.px.entitites;

import lombok.Data;

import java.sql.Date;

@Data
public class Order {

    private int id;
    private User user;
    private Date date;
    private String comment;
    private Status status;
}
