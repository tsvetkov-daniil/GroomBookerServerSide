package tsvetkov.daniil.groombooker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tsvetkov.daniil.groombooker.dto.BranchDTO;
import tsvetkov.daniil.groombooker.entity.Branch;
import tsvetkov.daniil.groombooker.repository.BranchRepository;

@Service
public class BranchService {
    @Autowired
    private BranchRepository branchRepository;

    public Branch create(BranchDTO branchDTO)
    {
//        DtoConverter<Branch, BranchDTO> cnvrt = ConverterFabric.get(Entity.BRANCH);
        Branch branch = Branch.builder()
                .address(branchDTO.getAddress())
                .workStartTime(branchDTO.getWorkStartTime())
                .workEndTime(branchDTO.getWorkEndTime())
                .longitude(branchDTO.getLongitude())
                .latitude(branchDTO.getLatitude())
                .build();
        return branchRepository.save(branch);
    }
}
