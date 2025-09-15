package trial;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstTest {
    //кратно 3, возвращается 'T'
    //кратно 5, возвращается 'М'
    //кратно 3 и 5, возвращается 'TEAM'

    public String trialCode(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "TEAM";
        } else if (number % 5 == 0) {
            return "M";
        } else if (number % 3 == 0) {
            return "T";
        } else return "FAIL";
    }

    @Test
    public void teamTest() {
        String actualResult = trialCode(9);
        assertEquals(actualResult, "T");
    }

    @Test
    public void teamTest2() {
        String actualResult = trialCode(10);
        assertEquals(actualResult, "M");
    }

    @Test
    public void teamTest3() {
        String actualResult = trialCode(15);
        assertEquals(actualResult, "TEAM");
    }
}
