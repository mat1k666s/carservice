package ru.car.api.nsi.filtr.equipment;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import ru.car.api.nsi.entity.CountryEntity;
import ru.car.api.nsi.entity.EquipmentEntity;
import ru.car.api.nsi.filtr.country.CountryFilter;

import java.util.ArrayList;
import java.util.List;

public class EquipmentSpecification {
    public static Specification<EquipmentEntity> buildSpecification(EquipmentFilter filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter != null) {
                if (filter.getCode() !=null && !filter.getCode().trim().isEmpty()){
                    predicates.add(cb.equal(root.get("code"), filter.getCode()));


                }

            }


            return cb.and(predicates.toArray(new Predicate[0]));
        }
                ;
    }

}
