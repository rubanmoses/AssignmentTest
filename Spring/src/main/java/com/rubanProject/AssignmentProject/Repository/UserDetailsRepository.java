package com.rubanProject.AssignmentProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubanProject.AssignmentProject.Models.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> 
{

}
