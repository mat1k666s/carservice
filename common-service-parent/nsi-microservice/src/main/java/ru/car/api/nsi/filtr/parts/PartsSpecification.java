package ru.car.api.nsi.filtr.parts;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import ru.car.api.nsi.entity.PartsEntity;

import java.util.ArrayList;
import java.util.List;

public class PartsSpecification {
    public static Specification<PartsEntity> buildSpecification(PartsFilter filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter != null) {
                if (filter.getManufacturer() !=null && !filter.getManufacturer().trim().isEmpty()) {
                    predicates.add(cb.like(root.get("code"), "%" + filter.getManufacturer() + "%"));


                }
                if (filter.getPrice() !=null){
                    predicates.add(cb.between(root.get("price"), filter.getPrice(), filter.getPrice()));
                }

            }


            return cb.and(predicates.toArray(new Predicate[0]));
        }
                ;
    }
}


