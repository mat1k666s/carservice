package ru.car.api.nsi.filtr.service;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import ru.car.api.nsi.entity.ServiceEntity;

import java.util.ArrayList;
import java.util.List;

public class ServiceSpecification {
    public static Specification<ServiceEntity> buildSpecification(ServiceFilter filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter != null) {
                if (filter.getShortName() != null && filter.getShortName().trim().isEmpty()) {
                    predicates.add(cb.like(root.get("shortName"), "%" + filter.getShortName() + "%"));


                }
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}



