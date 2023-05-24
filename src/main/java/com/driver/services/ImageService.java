package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog=blogRepository2.findById(blogId).get();
        Image image=new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        image.setBlog(blog);
        Image savedImage=imageRepository2.save(image);
        blog.getImageList().add(image);
        return savedImage;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        List<Image> imageList=imageRepository2.findByDimensions(screenDimensions);
        return imageRepository2.countImages(id,screenDimensions);
    }
}
