package dev.ajay.whatToBuild.service;

import dev.ajay.whatToBuild.model.Idea;

import java.util.List;

public interface IdeaService {


    void createIdea(Idea idea);

    List<Idea> getAllIdeas();

    void likeIdea(String ideaId, String userId);
}
