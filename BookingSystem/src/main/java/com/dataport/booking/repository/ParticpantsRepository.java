package com.dataport.booking.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
@Repository
public class ParticpantsRepository {
    @Autowired
    EntityManager entityManager;
}
