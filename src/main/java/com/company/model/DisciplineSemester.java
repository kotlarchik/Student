package com.company.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "discipline_semester")
public class DisciplineSemester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "audit_hours",nullable = false)
    private int audit_hours;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "discipline_learning_plan_id", nullable = false)
    private DisciplineLearningPlan disciplineLearningPlan;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "semester_id", nullable = false)
    private Semester semester;


    @ManyToMany(mappedBy = "disciplineSemesters")
    Set<Teachers> teachers;

    @OneToMany(mappedBy = "disciplineSemester", fetch = FetchType.EAGER)
    private Set<Lesson> lessons;



    @Override
    public String toString() {
        return "DisciplineSemester{" +
                "id=" + id +
                ", audit_hours=" + audit_hours +
                ", disciplineLearningPlan=" + disciplineLearningPlan +
                ", semester=" + semester +
                '}';
    }
}