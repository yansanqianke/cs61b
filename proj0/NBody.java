public class NBody {
    public static double readRadius(String str){
        In in=new In(str);
        in.readDouble();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String str){
        In in=new In(str);
        int num=in.readInt();
        Planet[] ap=new Planet[num];
        in.readDouble();
        for(int i=0;i<num;i++){
            ap[i]=new Planet(in.readDouble(),in.readDouble(),in.readDouble(),
            in.readDouble(),in.readDouble(),in.readString());
        }
        return ap;
    }
}
