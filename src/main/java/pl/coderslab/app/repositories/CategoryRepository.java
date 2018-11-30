package pl.coderslab.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.app.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}