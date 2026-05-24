

package com.example.insurance.service;

import com.example.insurance.entity.Policy;
import com.example.insurance.repository.PolicyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

    private final PolicyRepository repo;

    public PolicyService(PolicyRepository repo) {
        this.repo = repo;
    }

    public Policy create(Policy policy) {
        return repo.save(policy);
    }

    public List<Policy> getAll() {
        return repo.findAll();
    }

    public Policy getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Policy update(Long id, Policy policy) {
        policy.setId(id);
        return repo.save(policy);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
