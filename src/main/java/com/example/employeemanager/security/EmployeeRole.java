package com.example.employeemanager.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.employeemanager.security.EmployeePermission.*;

public enum EmployeeRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_WRITE, COURSE_READ, STUDENT_READ, STUDENT_WRITE)),
    ADMINTRAINEE(Sets.newHashSet( COURSE_READ, STUDENT_READ));

    private final Set<EmployeePermission> permissions;

    EmployeeRole(Set<EmployeePermission> permissions) {
        this.permissions = permissions;
    }

    public Set<EmployeePermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
      Set<SimpleGrantedAuthority> permission=  getPermissions().stream()
              .map(permissions->new SimpleGrantedAuthority(permissions
                      .getPermission()))
                .collect(Collectors.toSet());
      permission.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
      return permission;
    }
}
