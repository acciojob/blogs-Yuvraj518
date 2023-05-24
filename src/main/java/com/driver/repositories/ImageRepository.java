package com.driver.repositories;

import com.driver.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {


    Integer countImages(Integer id, String screenDimensions);

    List<Image> findByDimensions(String screenDimensions);
}
