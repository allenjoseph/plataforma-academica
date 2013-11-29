package com.platacad.repositories.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.platacad.entities.Curso;

public class CursoSpecifications {
	
	public static Specification<Curso> getCursoMatricula(Integer ciclo, String usuario){
		
		return new Specification<Curso>() {
			
			public Predicate toPredicate(Root<Curso> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				return null;
			}
		};
	}
}
