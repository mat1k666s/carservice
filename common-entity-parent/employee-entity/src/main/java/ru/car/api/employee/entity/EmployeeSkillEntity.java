package ru.car.api.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "skill", schema = "employee")
public class EmployeeSkillEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeId;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "skill_code")
    private String skillCode;

    @Column(name = "description")
    private String description;

    @Column(name = "experience_years")
    private Integer experienceYears;


    @Column(name = "certification")
    private String certification;

}
