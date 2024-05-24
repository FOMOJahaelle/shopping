package com.shoppingList.shoppingList.Dto;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CourseResponse {

    private String name;
    private String description;
    private Date dateCreation;
}
