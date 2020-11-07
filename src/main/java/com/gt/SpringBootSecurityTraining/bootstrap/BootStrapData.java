package com.gt.SpringBootSecurityTraining.bootstrap;

import com.gt.SpringBootSecurityTraining.dao.BusinessProcessRepository;
import com.gt.SpringBootSecurityTraining.model.BusinessProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BootStrapData implements CommandLineRunner {

    private final BusinessProcessRepository bsRepository;

    @Override
    public void run(String... args) throws Exception{
        System.out.println("Boot - Strap: Populating database with process information");
        BusinessProcess bsProcess;
        bsProcess = new BusinessProcess(UUID.randomUUID(),"2e23rr23vfr4r4","insurance","01244");
        bsRepository.save(bsProcess);
        bsProcess = new BusinessProcess(UUID.randomUUID(),"2e23rr23vfr4r3","re-insurance","01241");
        bsRepository.save(bsProcess);
        bsProcess = new BusinessProcess(UUID.randomUUID(),"t6565t3443435","insurance","01243");
        bsRepository.save(bsProcess);
        bsProcess = new BusinessProcess(UUID.randomUUID(),"trtr3332r3546","re-insurance","01242");
        bsRepository.save(bsProcess);
    }
}
