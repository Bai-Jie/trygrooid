package gq.baijie.tryit.grooid

import groovy.transform.CompileDynamic

class Book {
    String title

    String getTitleUp() {
        title.capitalize()
    }

    @CompileDynamic
    static Book createWithMetaProgramming() {
        final def book = new Book(title:"the stand");
        // class metaClass
        Book.metaClass.getTitleUp = { -> "${title.capitalize()} changed by class metaClass" }
        // object metaClass
        book.metaClass.getTitleUp = { -> "${title.toUpperCase()} changed by object metaClass" }
        return book
    }
}
