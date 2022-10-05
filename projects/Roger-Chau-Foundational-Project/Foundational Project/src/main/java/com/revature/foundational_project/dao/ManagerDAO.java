package com.revature.foundational_project.dao;

import com.revature.foundational_project.models.Manager;

public interface ManagerDAO {
    Manager getByUsername(String username);
}
