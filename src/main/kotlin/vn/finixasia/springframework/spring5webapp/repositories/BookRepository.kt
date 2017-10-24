package vn.finixasia.springframework.spring5webapp.repositories

import org.springframework.data.repository.CrudRepository
import vn.finixasia.springframework.spring5webapp.model.Book

interface BookRepository: CrudRepository<Book, Long> {
}