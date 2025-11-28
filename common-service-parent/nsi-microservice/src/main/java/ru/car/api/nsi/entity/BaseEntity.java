package ru.car.api.nsi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Setter
@Getter

public class BaseEntity implements Serializable {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name ="date_Write" )
    private Date dateWrite;
    @Column(name = "date_Update")
    private Date dateUpdate;
    @Column(name = "name")
    private String name;


}
