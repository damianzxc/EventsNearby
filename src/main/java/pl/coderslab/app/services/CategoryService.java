package pl.coderslab.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.model.Category;
import pl.coderslab.app.repositories.CategoryRepository;

import java.util.List;

@Service
@Transactional
public class CategoryService {


    @Autowired
    CategoryRepository categoryRepository;


    public List<Category> getAll(){
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }
}
