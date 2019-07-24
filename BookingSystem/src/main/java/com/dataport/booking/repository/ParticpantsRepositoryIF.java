package com.dataport.booking.repository;

import com.dataport.booking.entity.Meeting;
import com.dataport.booking.entity.Particpants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticpantsRepositoryIF extends JpaRepository<Particpants, String> {
    List<Particpants> findAllByMeetingId(int meetingId);
}
