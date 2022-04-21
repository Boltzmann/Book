package de.neuefische.bookproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.*;

@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {
    private String isbn;
    private String name;
}
