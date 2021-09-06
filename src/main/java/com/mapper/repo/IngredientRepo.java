package com.mapper.repo;

import com.mapper.domain.Ingredient;
import com.mapper.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepo extends JpaRepository<Ingredient, Long>{
    public void findIngredientById(long id);

//    public Optional <Ingredient> findIngredientByName(String name);
//    public boolean existsByName(String name);
}
