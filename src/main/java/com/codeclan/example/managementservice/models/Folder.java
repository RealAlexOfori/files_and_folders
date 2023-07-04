package com.codeclan.example.managementservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folders")

public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @ManyToOne
    private List<File> files;

    @JsonIgnoreProperties({"folder"})
    @OneToMany(mappedBy="folder", fetch = FetchType.LAZY)
    private List<Person> persons;

    @ManyToOne
    @JoinColumn(name = "file_id", nullable = false)
    //You can use JsonBackReference here as an alternative
    @JsonIgnoreProperties({"person"})
    private File file;

    public Folder() {
    }

    public Folder(String title, List<Person> persons) {
        this.title = title;
        this.persons = persons;
        this.files = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<File> getFiles() {
        return files;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public File getFile() {
        return file;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
