package dev.ajay.whatToBuild.repository;

import dev.ajay.whatToBuild.model.Idea;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepository extends MongoRepository<Idea, String> {
}
