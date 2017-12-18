package com.helloword.entity;

import javax.persistence.*;

/**
 * Created by scnyig on 12/14/2017.
 */
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
