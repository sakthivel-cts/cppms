
package com.example.insurance.controller;

import com.example.insurance.entity.Policy;
import com.example.insurance.service.PolicyService;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService service;

    public PolicyController(PolicyService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Policy createPolicy(@RequestBody Policy policy) {
        return service.create(policy);
    }

    // READ ALL
    @GetMapping
    public List<Policy> getAllPolicies() {
        return service.getAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Policy getPolicy(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Policy updatePolicy(@PathVariable Long id, @RequestBody Policy policy) {
        return service.update(id, policy);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deletePolicy(@PathVariable Long id) {
        service.delete(id);
        return "Policy deleted successfully";
    }
}