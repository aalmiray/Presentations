package com.acme

class MirrorTestCase extends GroovyTestCase {
    @Mirror
    private class Person {
        String name
    }

    void testIdentifiableTransformation() {
        def bean = new Person(name: 'Bean')
        def mirrorClass = "${MirrorTestCase.class.name}\$PersonMirror" as Class
        def mirror = mirrorClass.newInstance(name: 'Mirror')
        assert bean.name == 'Bean'
        assert mirror.name == 'Mirror'
    }
}
