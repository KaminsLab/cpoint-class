package studlab.kaminski;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringTests {
    @DataProvider(name = "Test-Cases-For-concat-Throws-nullPointerEx")
    public Object[][] parameterForConcatNullParams() {
        return new Object[][]{
                {
                        new String("Learn Java".toCharArray()),
                        null,
                        new String("Learn Java and other languages".toCharArray())
                },
                {
                        null,
                        new String(", JUnit.".toCharArray()),
                        new String("Use TestNG, JUnit.".toCharArray())
                },
        };
    }

    @DataProvider(name = "Test-Cases-For-concat")
    public Object[][] parameterForConcat(){
        return new Object[][]{
                {
                        new String("Learn Java".toCharArray()),
                        new String(" and other languages".toCharArray()),
                        new String("Learn Java and other languages".toCharArray())
                },
                {
                        new String("Use TestNG".toCharArray()),
                        new String(", JUnit.".toCharArray()),
                        new String("Use TestNG, JUnit.".toCharArray())
                },
                {
                        new String(),
                        new String("Mechanics and Mathematics faculty".toCharArray()),
                        new String("Mechanics and Mathematics faculty".toCharArray()),
                }
        };
    }

    @Test(dataProvider = "Test-Cases-For-concat")
    public void concat_TwoStringUnits_ReturnResult(String lhs, String rhs, String expected){
        String actual = String.concat(lhs, rhs);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = {NullPointerException.class}, dataProvider = "Test-Cases-For-concat-Throws-nullPointerEx")
    public void concat_ParameterStringIsNull_ThrowsNullPointerException(String lhs, String rhs, String expected){
        String actual = String.concat(lhs, rhs);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void ctor_RightParameters_DeepCopy(){
        String parameter = new String("Lorem ipsul".toCharArray());
        String copied = new String(parameter);
        Assert.assertNotSame(parameter, copied);
        Assert.assertEquals(parameter, copied);
    }
}
