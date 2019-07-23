package com.dataport.booking.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoomRepository {

	@Autowired
	EntityManager entityManager;
}
