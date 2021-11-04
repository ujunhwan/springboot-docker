package boilerplate.springbootdocker;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public TestEntity findTestById(Long id) {
        return testRepository.findTestEntityById(id);
    }

}
