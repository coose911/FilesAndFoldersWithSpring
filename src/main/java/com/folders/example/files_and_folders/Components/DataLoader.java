package com.folders.example.files_and_folders.Components;

import com.folders.example.files_and_folders.Models.Folder;
import com.folders.example.files_and_folders.Models.Person;
import com.folders.example.files_and_folders.Models.File;
import com.folders.example.files_and_folders.Repository.FileRepository;
import com.folders.example.files_and_folders.Repository.FolderRepository;
import com.folders.example.files_and_folders.Repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile("!test") //Run every time EXCEPT Tests
@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    PeopleRepository peopleRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;


    public DataLoader() {
    }


    public void run(ApplicationArguments args) {

        Person person = new Person("Marcus");
        peopleRepository.save(person);

        Folder folder = new Folder("docs", person);
        folder.setPerson(person); // set the owner of the folder to the person just created
        folderRepository.save(folder);

        File file = new File("file", "jpeg", person, folder);
        file.setFolder(folder); // set the folder property of the file to the folder just created
        fileRepository.save(file);


    }
}
