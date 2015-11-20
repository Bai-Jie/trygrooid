package gq.baijie.tryit.grooid

import groovy.transform.CompileDynamic

class TestGroovyClass {
    String name

    public String hello() {
        "Hello $name"
    }

    @CompileDynamic
    public String tryMetaProgramming() {
        Book.createWithMetaProgramming().titleUp
    }
}

class Book {
    String title

    String getTitleUp() {
        title.capitalize()
    }

    @CompileDynamic
    static Book createWithMetaProgramming() {
        final def book = new Book(title:"the stand");
        // object metaClass
        book.metaClass.getTitleUp = {-> title.toUpperCase() }
        return book
    }
}
