package boilerplate.springbootdocker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Long> {
    TestEntity findTestEntityById(Long id);
}
