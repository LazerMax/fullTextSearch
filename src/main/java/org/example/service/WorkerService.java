package org.example.service;

import org.example.model.Worker;
import org.example.repo.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepo workerRepo;

    public Page<Worker> getAll(Pageable pageable) {
        return workerRepo.findAll(pageable);
    }

    public Page<Worker> search(String text, Pageable pageable) {
        return workerRepo.findByText(text, pageable);
    }

    public Worker getById(String id) {
        return workerRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Worker not found"));
    }

    public Worker add(Worker worker) {
        return workerRepo.save(worker);
    }
}
