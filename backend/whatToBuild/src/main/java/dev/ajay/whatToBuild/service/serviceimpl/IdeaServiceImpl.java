package dev.ajay.whatToBuild.service.serviceimpl;

import dev.ajay.whatToBuild.model.Idea;
import dev.ajay.whatToBuild.repository.IdeaRepository;
import dev.ajay.whatToBuild.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeaServiceImpl implements IdeaService {
    @Autowired
    private IdeaRepository ideaRepository;


    @Override
    public void createIdea(Idea idea) {
        int numbers = ideaRepository.findAll().size();
        numbers++;
        idea.setLikes(1);
        idea.setId(Integer.toString(numbers));
        ideaRepository.save(idea);
    }

    @Override
    public List<Idea> getAllIdeas() {
        return ideaRepository.findAll();
    }

    @Override
    public void likeIdea(String ideaId, String userId) {
        Idea idea = ideaRepository.findById(ideaId).orElse(null);

        if (idea != null) {
            if (!idea.getLikedUserIds().contains(userId)) {
                idea.setLikes(idea.getLikes() + 1);
                idea.getLikedUserIds().add(userId);
                ideaRepository.save(idea);
            } else {
                idea.setLikes(idea.getLikes() - 1);
                idea.getLikedUserIds().remove(userId);
                ideaRepository.save(idea);
            }
        }

    }
}
