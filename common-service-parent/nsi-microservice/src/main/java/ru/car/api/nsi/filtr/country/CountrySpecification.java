package ru.car.api.nsi.filtr.country;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import ru.car.api.nsi.entity.CountryEntity;

import java.util.ArrayList;
import java.util.List;

public class CountrySpecification {
    public static Specification<CountryEntity> buildSpecification(CountryFilter filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter != null) {
                if (filter.getShortName() != null && filter.getShortName().trim().length() > 0) {
                    predicates.add(cb.like(root.get("shortname"), "%" + filter.getShortName() + "%"));


                }
                if (filter.getCode()!= null && filter.getCode() > 0){
                    predicates.add(cb.equal(root.get("code"), filter.getCode()));
                }


            }


            return cb.and(predicates.toArray(new Predicate[0]));
        }
                ;
    }

}
