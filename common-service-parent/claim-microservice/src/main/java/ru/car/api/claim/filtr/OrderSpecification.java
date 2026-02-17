package ru.car.api.claim.filtr;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import ru.car.api.claim.entity.OrderEntity;

import java.util.ArrayList;
import java.util.List;

public class OrderSpecification {
    public static Specification<OrderEntity> buildSpecification(OrderFilter filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter != null) {
                if (filter.getFullName() != null && !filter.getFullName().trim().isEmpty()) {
                    predicates.add(cb.like(root.get("fullName"), "%" + filter.getFullName() + "%"));


                }
                if (filter.getPhone() != null && !filter.getPhone().trim().isEmpty()) {
                    predicates.add(cb.equal(root.get("phone"), filter.getPhone()));
                }
                if (filter.getId()!= null && filter.getId() > 0){
                    predicates.add(cb.equal(root.get("id"), filter.getId()));
                }


            }


            return cb.and(predicates.toArray(new Predicate[0]));
        }
                ;
    }
}
