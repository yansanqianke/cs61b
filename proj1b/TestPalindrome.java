import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class. 

    @Test
    public void testIsPalindrome(){
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("aa"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("b"));
        assertFalse(palindrome.isPalindrome("Aa"));
    }

    @Test
    public void testNewIsPalindrome(){
        CharacterComparator cc=new OffByOne();
        assertTrue(palindrome.isPalindrome("ab",cc));
        assertTrue(palindrome.isPalindrome("a",cc));
        assertFalse(palindrome.isPalindrome("aa",cc));
        assertTrue(palindrome.isPalindrome("detrude",cc));
    }
}
