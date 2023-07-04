package com.codeclan.example.managementservice.others;

import com.codeclan.example.managementservice.models.Folder;
import com.codeclan.example.managementservice.models.Person;
import com.codeclan.example.managementservice.repository.FileRepository;
import com.codeclan.example.managementservice.repository.FolderRepository;
import com.codeclan.example.managementservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component

public class DataLoader implements ApplicationRunner {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) {
        Person alex = new Person("Alex", "Computers");
        personRepository.save(alex);

        Folder Kitchenstuff = new Folder("Kitchen","Alex");
        folderRepository.save(Kitchenstuff);

        File file1 = new File("ITstuff", ".rb", 12);
        fileRepository.save(file1);
    }


}
