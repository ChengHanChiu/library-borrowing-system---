package tw.chiuchenghan.springboot.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import tw.chiuchenghan.springboot.controller.BookController;
import tw.chiuchenghan.springboot.entity.Book;

@Component
public class BookModelAssembler implements RepresentationModelAssembler<Book, EntityModel<Book>> {

  @Override
  public EntityModel<Book> toModel(Book Book) {

    return EntityModel.of(Book, //
        linkTo(methodOn(BookController.class).one(Book.getISBN())).withSelfRel());
//        linkTo(methodOn(BookController.class).all()).withRel("Book"));
  }
}