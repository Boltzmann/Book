import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeleteThisClassTest {
    @Test
    void showRepoIsWorkingWithTests(){
        System.out.println("TEST");
        Assertions.assertEquals("Hello World.", ToDelete.helloWorld());
    }
}
