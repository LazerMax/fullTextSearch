package org.example.controller;

import org.example.model.Worker;
import org.example.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private WorkerService workerService;

    @GetMapping("/")
    public String getIndex(Model model) {
        Page<Worker> workerPage = workerService.getAll(Pageable.ofSize(10));
        model.addAttribute("workerPage", workerPage);
        return "index";
    }

    @PostMapping("/")
    public String postIndex(Model model, String searchStr) {
        Page<Worker> workerPage = workerService.search(searchStr, Pageable.ofSize(10));
        model.addAttribute("workerPage", workerPage);
        return "index";
    }

    @GetMapping("/add")
    public String getAdd() {
        return "add";
    }

    @PostMapping("/add")
    public String addWorker(Worker worker) {
        workerService.add(worker);
        return "redirect:/";
    }

    @GetMapping("/info/{id}")
    public String getInfo(Model model, @PathVariable("id") String id) {
        Worker worker = workerService.getById(id);
        model.addAttribute("worker", worker);
        return "info";
    }
}
