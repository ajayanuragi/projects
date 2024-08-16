package com.exaajay.photoz.clone.service;

import com.exaajay.photoz.clone.model.Photo;
import com.exaajay.photoz.clone.repository.PhotozRepository;
import org.springframework.stereotype.Service;

@Service
public class PhotozService {
    private final PhotozRepository photozRepository;

    public PhotozService(PhotozRepository photozRepository) {
        this.photozRepository = photozRepository;
    }


    public Iterable<Photo> get() {
        return photozRepository.findAll();
    }

    public Photo get(Integer id) {
        return photozRepository.findById(id).orElse(null);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
     photozRepository.save(photo);
        return photo;
    }

    public void delete(Integer id) {
       photozRepository.deleteById(id);
    }
}
