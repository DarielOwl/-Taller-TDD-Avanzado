import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class StringCalculatorTest {
    public StringCalculator stringCalculatorInstance = new StringCalculator();

    @Test
    public void stringIsEmplty() throws Exception{
            Assertions.assertEquals(0,stringCalculatorInstance.add(""));
    }

    @Test
    public void singleNumberReturnItsValueTest() throws Exception {
        Assertions.assertEquals(1,stringCalculatorInstance.add("1"));
        Assertions.assertEquals(2,stringCalculatorInstance.add("2"));
    }

    @Test
    public void twoNumbersCommaDelimitedReturnsTheSumTest() throws Exception{
        Assertions.assertEquals(4,stringCalculatorInstance.add("2,2"));
        Assertions.assertEquals(2,stringCalculatorInstance.add("1,1"));
        Assertions.assertEquals(3,stringCalculatorInstance.add("1,2"));
    }

    @Test
    public void sameThatBeforeButNewLineDelimitedTest() throws Exception{
        Assertions.assertEquals(2,stringCalculatorInstance.add("0\n2"));
        Assertions.assertEquals(2,stringCalculatorInstance.add("1\n1"));
        Assertions.assertEquals(3,stringCalculatorInstance.add("1\n2"));

    }

    @Test
    public void sameThatBeforeButAllDelimitersWorksTest() throws Exception{
        Assertions.assertEquals(6,stringCalculatorInstance.add("1\n2,3"));
        Assertions.assertEquals(7,stringCalculatorInstance.add("1,2\n4"));
    }

    @Test
    public void negativeNumbersThrowsAnExceptionTest() throws Exception{
        Assertions.assertThrows(Exception.class,()->{stringCalculatorInstance.add("-1,-1");});
    }


    @Test
    public void greaterThan1000AreIgnoredTest() throws Exception{
        Assertions.assertEquals(1002,stringCalculatorInstance.add("2,1000"));
        Assertions.assertEquals(2,stringCalculatorInstance.add("2,1001"));
    }


    @Test
    public void singleCharDelimiterTest() throws Exception{
        Assertions.assertEquals(1002, stringCalculatorInstance.add("#2#1000"));
    }


}