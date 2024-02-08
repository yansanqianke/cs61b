public class NBody {
    public static double readRadius(String str){
        In in=new In(str);
        in.readDouble();
        return in.readDouble();
    }
}
