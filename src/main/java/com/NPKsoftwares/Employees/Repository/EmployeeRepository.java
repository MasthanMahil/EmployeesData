package com.NPKsoftwares.Employees.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NPKsoftwares.Employees.Model.Empolyee;

@Repository
public interface EmployeeRepository extends JpaRepository<Empolyee, Long> {

}
