package com.acme

class SortableTestCase extends GroovyTestCase {
    @Sortable
    private class Person {
        int id
        String name
    }

    void testIdentifiableTransformation() {
        def person1 = new Person(id: 1, name: 'Andres')
        def person2 = new Person(id: 2, name: 'Guillame')
        def person3 = new Person(id: 3, name: 'Dierk')

        def people = [person1, person2, person3]
        assert people.sort() == [person1, person2, person3]
        assert people.sort(Person.comparatorById()) == [person1, person2, person3]
        assert people.sort(Person.comparatorByName()) == [person1, person3, person2]
    }
}
