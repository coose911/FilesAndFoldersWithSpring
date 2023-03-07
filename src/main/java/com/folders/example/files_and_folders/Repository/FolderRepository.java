package com.folders.example.files_and_folders.Repository;

import com.folders.example.files_and_folders.Models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
