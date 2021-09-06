package com.mapper.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String timer;
    private String img;
    private int count;
    @Column(columnDefinition="varchar(2000)")
    private String description;

}
