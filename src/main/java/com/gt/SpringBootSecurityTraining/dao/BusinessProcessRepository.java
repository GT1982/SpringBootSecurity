package com.gt.SpringBootSecurityTraining.dao;

import com.gt.SpringBootSecurityTraining.model.BusinessProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessProcessRepository extends JpaRepository<BusinessProcess,String> {
    List<BusinessProcess> findBusinessProcessByType(String type);
    List<BusinessProcess> findBusinessProcessByProcessId(String processId);
}