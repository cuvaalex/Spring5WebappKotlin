package vn.finixasia.springframework.spring5webapp.model

import javax.persistence.*

@Entity
data class Book constructor(var title: String, var isbn: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @ManyToMany
    @JoinTable(name = "author_book"
            , joinColumns = arrayOf(JoinColumn(name = "book_id"))
            , inverseJoinColumns = arrayOf(JoinColumn(name = "author_id")))
    var authors:MutableSet<Author> = HashSet()

    @OneToOne
    var publisher: Publisher? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val book = o as Book?

        return id == book!!.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", authors=" + authors +
                '}'
    }
}

