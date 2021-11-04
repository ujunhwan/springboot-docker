package boilerplate.springbootdocker;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/test/{id}")
    public TestEntity getTest(@PathVariable("id") Long id) {
        return testService.findTestById(id);
    }

}
