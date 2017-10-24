package vn.finixasia.springframework.spring5webapp.repositories

import org.springframework.data.repository.CrudRepository
import vn.finixasia.springframework.spring5webapp.model.Author

interface AuthorRepository: CrudRepository<Author, Long> {
}