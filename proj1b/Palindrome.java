public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> d=new LinkedListDeque<>();
        for(int i=0;i<word.length();i++){
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public boolean isPalindrome(String word){
        Deque<Character> d=wordToDeque(word);
        return innerIsPalindrome(d);
    }

    private boolean innerIsPalindrome(Deque<Character> dq){
        if(dq.size()==0 || dq.size()==1)
            return true;
        if(dq.removeFirst()==dq.removeLast())
            return innerIsPalindrome(dq);
        else
            return false;
    }
}
