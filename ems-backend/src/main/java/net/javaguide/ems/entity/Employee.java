package net.javaguide.ems.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Employees")
public  class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // TO AUTO INCREMENT
    private long id;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;
    
    @Column(name = "Email", nullable = false, unique = true)
    private String email;
}