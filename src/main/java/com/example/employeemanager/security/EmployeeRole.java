package com.example.employeemanager.security;

import com.google.common.collect.Sets;

import java.util.Set;

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
}
