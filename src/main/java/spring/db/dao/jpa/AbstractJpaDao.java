package spring.db.dao.jpa;

import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import java.util.function.Function;

public abstract class AbstractJpaDao {

    @Setter(onMethod = @__(@PersistenceUnit))
    protected EntityManagerFactory emf;

    protected <T> T mapEntityManager(Function<EntityManager, T> entityManagerMapper) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManagerMapper.apply(entityManager);
    }

    protected <T> T mapEntityManagerInTransaction(Function<EntityManager, T> entityManagerMapper) {
        return mapEntityManager(entityManager -> {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            T result = entityManagerMapper.apply(entityManager);
            entityTransaction.commit();
            return result;
        });
    }

}
