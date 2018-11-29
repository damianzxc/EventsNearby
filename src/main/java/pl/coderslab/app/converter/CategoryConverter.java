package pl.coderslab.app.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.app.model.Category;
import pl.coderslab.app.repositories.CategoryRepository;

public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category convert(String s) {
        Long id = Long.parseLong(s);
        try{
            Category category = categoryRepository.findOne(id);
            return category;
        }
        catch (Throwable t){
            t.printStackTrace();
            throw t;
        }
    }
}
