package com.dataport.booking.service;

import com.dataport.booking.entity.Particpants;
import com.dataport.booking.repository.ParticpantsRepositoryIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)//当发生异常时回滚
public class ParticpantsService {
    @Autowired
    ParticpantsRepositoryIF particpantsRepositoryIF;
    public List<Particpants> findByMeetingId(int meetingId){
        return particpantsRepositoryIF.findAllByMeetingId(meetingId);
    }
}
