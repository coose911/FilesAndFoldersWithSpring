package com.folders.example.files_and_folders.Repository;

import com.folders.example.files_and_folders.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<Person, Long> {
}
