package com.mandala.activitiesperhour.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mandala.activitiesperhour.entity.ActivityEntity;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity, Id> {

}
