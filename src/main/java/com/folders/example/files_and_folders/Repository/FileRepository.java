package com.folders.example.files_and_folders.Repository;

import com.folders.example.files_and_folders.Models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
