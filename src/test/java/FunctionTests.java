import org.example.Function;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FunctionTests {

    @Test
    public void nameCaseOneNameLowercaseTest() {
        String name = "vytautas";
        String actual = Function.nameCase(name);
        String expected = "Vytautas";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void nameCaseOneNameUppercaseTest() {
        String name = "VYTAUTAS";
        String actual = Function.nameCase(name);
        String expected = "Vytautas";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void nameCaseTwoNameTest() {
        String name = "vytautas petras";
        String actual = Function.nameCase(name);
        String expected = "Vytautas Petras";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void nameCaseWithSymbolTest() {
        String name = "vytautas pet!ras";
        String actual = Function.nameCase(name);
        String expected = "Invalid name";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void nameCaseEmptyTest() {
        String name = "";
        String actual = Function.nameCase(name);
        String expected = "";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void phoneNumberWith370Test() { // With +370
        String phone = "+37012345678";
        String actual = Function.phoneNo(phone);
        String expected = "12345678";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void phoneNumberWithDashTest() {
        String phone = "+370-123-45678";
        String actual = Function.phoneNo(phone);
        String expected = "12345678";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void phoneNumberWith00370Test() { // With 00370
        String phone = "0037012345678";
        String actual = Function.phoneNo(phone);
        String expected = "12345678";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void phoneNumberWhit8Test() { // With 8
        String phone = "812345678";
        String actual = Function.phoneNo(phone);
        String expected = "12345678";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void phoneNumberWithLestNumbersTest() {
        String phone = "5678";
        String actual = Function.phoneNo(phone);
        String expected = "Invalid phone number";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void phoneNumberEmptyTest() {
        String phone = "";
        String actual = Function.phoneNo(phone);
        String expected = "Invalid phone number";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void emailTest() {
        String email = "betkas@domain.com";
        boolean isValid = Function.emailCheck(email);
        Assert.assertTrue(isValid);
    }

    @Test
    public void emailWithTwoDomainTest() {
        String email = "betkas@domain.kitas.com";
        boolean isValid = Function.emailCheck(email);
        Assert.assertTrue(isValid);
    }

    @Test
    public void emailWithSymbolsTest() {
        String email = "betkas2!@domain.com";
        boolean isValid = Function.emailCheck(email);
        Assert.assertTrue(isValid);
    }

    @Test
    public void emailWithTwoDotsTest() {
        String email = "betkas@domain..com";
        boolean isValid = Function.emailCheck(email);
        Assert.assertFalse(isValid);
    }

    @Test
    public void emailWithTwoEtaSymbolsTest() {// symbol @@
        String email = "betkas@@domain.com";
        boolean isValid = Function.emailCheck(email);
        Assert.assertFalse(isValid);

    }

    @Test
    public void emailWithOutNameTest() {
        String email = "@domain.com";
        boolean isValid = Function.emailCheck(email);
        Assert.assertFalse(isValid);

    }

    @Test
    public void emailWithOutDomainTest() {
        String email = "betkas@.com";
        boolean isValid = Function.emailCheck(email);
        Assert.assertFalse(isValid);

    }

    @Test
    public void emailWithOutEtaSymbolTest() {// symbol @
        String email = "betkasdomain.com";
        boolean isValid = Function.emailCheck(email);
        Assert.assertFalse(isValid);
    }

    @Test
    public void emailWithOnlyNameTest() {
        String email = "betkasdomain";
        boolean isValid = Function.emailCheck(email);
        Assert.assertFalse(isValid);
    }

    @Test
    public void emailWithOutTopLvlDomainTest() {
        String email = "betkas@domain";
        boolean isValid = Function.emailCheck(email);
        Assert.assertFalse(isValid);
    }

    @Test
    public void emailWithSymbolTest() {
        String email = "betk>as@domain.com";
        boolean isValid = Function.emailCheck(email);
        Assert.assertFalse(isValid);
    }

    @Test
    public void emailWithSymbolInDomainTest() {
        String email = "betkas@dom%0ain.com";
        boolean isValid = Function.emailCheck(email);
        Assert.assertFalse(isValid);
    }
}
