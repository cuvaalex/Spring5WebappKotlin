package vn.finixasia.springframework.spring5webapp.repositories

import org.springframework.data.repository.CrudRepository
import vn.finixasia.springframework.spring5webapp.model.Publisher

interface PublisherRepository: CrudRepository<Publisher, Long> {
}