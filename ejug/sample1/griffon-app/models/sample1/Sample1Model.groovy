package sample1

import data.Person
import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.BasicEventList
import ca.odell.glazedlists.SortedList

class Sample1Model {
   EventList<Person> people = new SortedList<Person>(new BasicEventList<Person>(),
     {a, b -> a.id <=> b.id} as Comparator<Person>)
}