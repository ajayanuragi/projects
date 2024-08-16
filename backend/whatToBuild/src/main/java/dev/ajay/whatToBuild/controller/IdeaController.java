package dev.ajay.whatToBuild.controller;

import dev.ajay.whatToBuild.model.Idea;
import dev.ajay.whatToBuild.service.serviceimpl.IdeaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class IdeaController {
    @Autowired
    private IdeaServiceImpl ideaService;

    @GetMapping("/ideas")
    public List<Idea> getAllIdeas() {
        return ideaService.getAllIdeas();
    }

    @PostMapping("/{ideaId}/like")
    public ResponseEntity<String> likeIdea(@PathVariable String ideaId, @RequestHeader("user-id") String userId) {
        ideaService.likeIdea(ideaId, userId);
        return new ResponseEntity<>("Done", HttpStatus.OK);
    }

    @PostMapping("/idea")
    public ResponseEntity<String> createIdea(@RequestBody Idea idea) {
        ideaService.createIdea(idea);
        return new ResponseEntity<>("Idea Created Successfully", HttpStatus.CREATED);
    }


}
