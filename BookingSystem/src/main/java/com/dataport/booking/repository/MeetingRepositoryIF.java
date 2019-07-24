/**                                
 * Copyright ? 2019 河北数港;
 * 版权所有。     
 */ 

package com.dataport.booking.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dataport.booking.entity.Meeting;

/**
 * <p>Class       : com.dataport.booking.repository.MeetingRepositoryIF
 * <p>Descdription: 类功能描述
 *
 * @author  XX XX@dataport.com.cn
 * @version 1.0.0
 *<p>
 *--------------------------------------------------------------<br>
 * 修改履历：<br>
 *        <li> 2019年7月23日，XX@dataport.com.cn，创建文件；<br>
 *--------------------------------------------------------------<br>
 *</p>
 */
public interface MeetingRepositoryIF extends JpaRepository<Meeting, String>{
	List<Meeting> findByDateAndRoomId(Date date,Integer roomId);
	List<Meeting> findAll();
}
