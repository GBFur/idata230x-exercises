package no.ntnu.book.Model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Represents a book in the library")

public record Book (
  @Schema(description = "id of the book") int id, 
  @Schema(description = "title of the book") String title, 
  @Schema(description = "year of the books publishing date") int year, 
  @Schema(description = "number of pages of the book") int numberOfPages){}
