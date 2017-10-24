package vn.finixasia.springframework.spring5webapp.bootstrap

import javafx.application.Application
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component
import vn.finixasia.springframework.spring5webapp.model.Author
import vn.finixasia.springframework.spring5webapp.model.Book
import vn.finixasia.springframework.spring5webapp.model.Publisher
import vn.finixasia.springframework.spring5webapp.repositories.AuthorRepository
import vn.finixasia.springframework.spring5webapp.repositories.BookRepository
import vn.finixasia.springframework.spring5webapp.repositories.PublisherRepository

@Component
class DevBootstrap constructor(
        var authorRepository: AuthorRepository
        , var bookRepository: BookRepository
        , var publisherRepository: PublisherRepository)
    : ApplicationListener<ContextRefreshedEvent> {

    override fun onApplicationEvent(p0: ContextRefreshedEvent?) {
        initData()
    }

    private fun initData() {

        //Eric
        var eric = Author("Eric", "Evans")
        var harper = Publisher("Harper Collins", "http://")
        var ddd = Book("Domain Driven Design", "1234")
        eric.books.add(ddd)
        ddd.publisher = harper
        ddd.authors.add(eric)

        publisherRepository.save(harper)
        authorRepository.save(eric)
        bookRepository.save(ddd)

        //Rod
        val rod = Author("Rod", "Johnson")
        val wrox = Publisher("Wrox", "http://")
        val noEJB = Book("J2EE Development without EJB", "23444")
        rod.books.add(noEJB)
        noEJB.publisher = wrox
        noEJB.authors.add(rod)

        publisherRepository.save(wrox)
        authorRepository.save(rod)
        bookRepository.save(noEJB)
    }
}