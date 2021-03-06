package vn.finixasia.springframework.spring5webapp.model

import javax.persistence.*

@Entity
data class Author constructor(val firstName: String, val lastName: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    @ManyToMany(mappedBy = "authors")
    val books: Set<Book> = HashSet()

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val author = o as Author?

        return id == author!!.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}'
    }
}