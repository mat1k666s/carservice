package ru.car.api.nsi.entity;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BaseEntity.class)
public abstract class BaseEntity_ {

	public static volatile SingularAttribute<BaseEntity, Date> dateUpdate;
	public static volatile SingularAttribute<BaseEntity, Date> dateWrite;
	public static volatile SingularAttribute<BaseEntity, String> name;
	public static volatile SingularAttribute<BaseEntity, Integer> id;

	public static final String DATE_UPDATE = "dateUpdate";
	public static final String DATE_WRITE = "dateWrite";
	public static final String NAME = "name";
	public static final String ID = "id";

}

