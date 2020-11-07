package com.gt.SpringBootSecurityTraining.controller;

import com.gt.SpringBootSecurityTraining.model.BusinessProcess;
import com.gt.SpringBootSecurityTraining.service.BusinessProcessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/processes")
@Slf4j
@RequiredArgsConstructor
public class BusinessProcessController {

    private final BusinessProcessService bsService;

    @GetMapping(produces = "application/json")
    public List<BusinessProcess> getBusinessProcessesByType(@RequestParam("type") String type){
        return bsService.getBusinessProcessesByType(type);
    }

    @GetMapping(path = "{processId}")
    public BusinessProcess getBusinessProcess(@PathVariable ("processId") String processId){
        return bsService.getBusienssProcessById(processId);
    }

    @PostMapping()
    public void createProcess(@RequestBody BusinessProcess businessProcess){
       bsService.createNewBusinessProcess(businessProcess);
    }
}
