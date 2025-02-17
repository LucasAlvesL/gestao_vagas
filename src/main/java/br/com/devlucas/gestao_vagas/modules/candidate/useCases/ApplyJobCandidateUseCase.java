package br.com.devlucas.gestao_vagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devlucas.gestao_vagas.modules.candidate.entity.ApplyJobEntity;
import br.com.devlucas.gestao_vagas.modules.candidate.repository.ApplyJobRepository;
import br.com.devlucas.gestao_vagas.modules.candidate.repository.CandidateRepository;
import br.com.devlucas.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {
        // Validate if candidate exists
        this.candidateRepository.findById(idCandidate).orElseThrow(() -> {
            throw new RuntimeException("Candidate not found");
        });

        // Validate if job exists
        this.jobRepository.findById(idJob).orElseThrow(() -> {
            throw new RuntimeException("Job not found");
        });

        // Candidate apply to the job
        var applyJob = ApplyJobEntity.builder()
                .candidateId(idCandidate)
                .jobId(idJob)
                .build();
        applyJob = this.applyJobRepository.save(applyJob);
        return applyJob;
    }

}
