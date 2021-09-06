package com.mapper.repo;

import com.mapper.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Long>{
public  void findRecipeById(long id);
}
