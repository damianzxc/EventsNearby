package pl.coderslab.app.converter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.config.AppConfig;
import pl.coderslab.app.config.DBConfig;
import pl.coderslab.app.model.Category;
import pl.coderslab.app.services.CategoryService;

import javax.persistence.PersistenceContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
//@ContextConfiguration(classes = {DBConfig.class, AppConfig.class})
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = {AppConfig.class, DBConfig.class})
@Transactional
@WebAppConfiguration
public class CategoryConverterTest {

    @Autowired
    private CategoryConverter categoryConverter;
    private Category category;

    private CategoryService categoryService;

    @Before
    public void before(){
//        categoryConverter = new CategoryConverter();
        category = new Category();
        category.setName("Sport");
        category.setId(5l);
    }
    @After
    public void after(){}

    @Test(expected = Exception.class)
    public void convert() {
        //given
        categoryConverter = new CategoryConverter();
        Category newCat = this.category;
        String number = "5";

        //when
        categoryConverter.convert(number);

        //then
        assertThat("wrong data", newCat.getName(), is("Sport"));


    }

}