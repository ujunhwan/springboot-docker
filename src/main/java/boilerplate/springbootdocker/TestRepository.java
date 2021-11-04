package boilerplate.springbootdocker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class TestRepository {

    @PersistenceContext
    EntityManager em;

    public TestEntity find(Long id) {
        return em.find(TestEntity.class, id);
    }

    @Entity
    @Getter
    @NoArgsConstructor
    static class TestEntity {
        @Id @GeneratedValue
        private Long id;
        private String content;
    }

}
