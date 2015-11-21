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
