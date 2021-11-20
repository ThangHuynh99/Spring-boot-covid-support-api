package com.spring.covidsupport.repository;

import com.spring.covidsupport.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
