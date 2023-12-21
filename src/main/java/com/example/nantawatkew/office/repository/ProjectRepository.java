package com.example.nantawatkew.office.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.nantawatkew.office.model.Project;

public interface ProjectRepository extends CrudRepository <Project , Integer>{
    List<Project>findByNameContaining(String name);
}
