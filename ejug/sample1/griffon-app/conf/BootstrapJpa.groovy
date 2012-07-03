import javax.persistence.EntityManager
import data.Person

class BootstrapJpa {
    def init = { String persistenceUnit, EntityManager em ->
        em.getTransaction().begin()
        [[id: 1, name: 'Jamie',  lastname: 'Hyneman'],
         [id: 2, name: 'Adam',   lastname: 'Savage'],
         [id: 3, name: 'Tori',   lastname: 'Belleci'],
         [id: 4, name: 'Kari',   lastname: 'Byron'],
         [id: 5, name: 'Grant',  lastname: 'Imahara'],
         [id: 6, name: 'Buster', lastname: '']].each { data ->
            em.persist(new Person(data))
        }
        em.getTransaction().commit()
    }

    def destroy = { String persistenceUnit, EntityManager em ->
    }
}
