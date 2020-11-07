package com.gt.SpringBootSecurityTraining.service;

import com.gt.SpringBootSecurityTraining.dao.BusinessProcessRepository;
import com.gt.SpringBootSecurityTraining.model.BusinessProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class BusinessProcessService {

    private final BusinessProcessRepository bsRepository;

    public List<BusinessProcess> getBusinessProcessesByType(String type){
        return bsRepository.findBusinessProcessByType(type);
    }

    public BusinessProcess getBusienssProcessById(String processId){
        List<BusinessProcess> bsProcessList = bsRepository.findBusinessProcessByProcessId(processId);
        return bsProcessList.stream().findFirst().orElseThrow(() -> new IllegalStateException("Process Id: "+ processId + " not found"));
    }
}
