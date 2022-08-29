package com.ufg.environmentcontrol.cript.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Data
// NoArgs and AllArgs are used to add flexibility when calling a constructor
// Entity defines the table name on the DB
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="tb_user")
public class UserModel {

    // Defines that it's an ID column
    @Id
    // Defines the ID generation strategy
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Defines that the column must be unique
    @Column(unique = true)
    private String login;

    @Column
    private String password;
}
