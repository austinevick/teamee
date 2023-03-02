package com.example.employeemanager.security;

public enum EmployeePermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permission;
    EmployeePermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
