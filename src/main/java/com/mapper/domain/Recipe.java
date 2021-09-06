package com.mapper.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


import lombok.*;

@Entity
@Table(name = "recipes")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int complexity;
	
	private String kitchenTime;
	
	private String totalTime;
	

	@OneToMany(cascade = CascadeType.ALL)
    private	List<Step> cooking;

	//@ManyToMany(cascade=CascadeType.ALL)
	//@ManyToMany(cascade=CascadeType.MERGE)
	@ManyToMany(fetch = FetchType.LAZY, cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE,
	})
	@JoinTable(name = "recipe_ingredients",
			joinColumns = @JoinColumn(name = "recipe_id"),
			inverseJoinColumns = @JoinColumn(name = "ingredient_id")
	)
	private Set<Ingredient> ingredients = new HashSet<>();



	private String title;
	private String category;



}
