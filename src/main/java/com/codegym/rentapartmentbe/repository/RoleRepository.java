package com.codegym.rentapartmentbe.repository;

import com.codegym.rentapartmentbe.entity.Role;
import com.codegym.rentapartmentbe.entity.RoleName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
