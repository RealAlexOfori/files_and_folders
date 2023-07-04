package com.codeclan.example.managementservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persons")

public class Person {

    @Column(name = "name")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private List<File> files;

    @ManyToOne
    @JoinColumn(name = "folder_id", nullable = false)
    //You can use JsonBackReference here as an alternative
    @JsonIgnoreProperties({"person"})
    private Folder folder;

    public Person(String name, Folder folder) {
        this.name = name;
        this.folder = folder;
        this.files = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
