package com.petstore.pojo.pet;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

  private Long id;

  private Category category;
  private String name;
  private List<String> photoUrls;
  private List<Tags> tags;
  private Status status;

  public Pet(
      Category category, String name, List<String> photoUrls, List<Tags> tags, Status status) {
    this.category = category;
    this.name = name;
    this.photoUrls = photoUrls;
    this.tags = tags;
    this.status = status;
  }
}
