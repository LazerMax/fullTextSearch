package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "books")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Worker {
    @Id
    private int id;
    private String name;
    private int salary;
    private String description;
}
