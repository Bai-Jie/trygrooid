package gq.baijie.tryit.grooid

import groovy.transform.CompileDynamic

class TestGroovyClass {
    String name

    public String hello() {
        "Hello $name"
    }

    @CompileDynamic
    public String tryMetaProgrammingWithCompileDynamic() {
        Book.createWithMetaProgramming().titleUp
    }

    public String tryMetaProgramming() {
        Book.createWithMetaProgramming().titleUp
    }

    public String tryMetaProgrammingWithGetProperty() {
        Book.createWithMetaProgramming().getProperty('titleUp')
    }
}
