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

    public static void main(String[] args){
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        double r=readRadius(filename);
        Planet[] ap=readPlanets(filename);

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-r, r);
        StdDraw.clear();
        StdDraw.picture(0,0,"images/starfield.jpg");
        for(int i=0;i<ap.length;i++)
            ap[i].draw();
        
        double t=0;
        double[] xForces=new double[ap.length];
        double[] yForces=new double[ap.length];
        while(t<T){
            for(int i=0;i<ap.length;i++){
                xForces[i]=ap[i].calcNetForceExertedByX(ap);
                yForces[i]=ap[i].calcNetForceExertedByY(ap);
            }
            for(int i=0;i<ap.length;i++)
                ap[i].update(dt,xForces[i],yForces[i]);
            StdDraw.picture(0,0,"images/starfield.jpg");
            for(int i=0;i<ap.length;i++)
                ap[i].draw();
            StdDraw.show();
            StdDraw.pause(10);
            t+=dt;         
        }

        StdOut.printf("%d\n", ap.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < ap.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        ap[i].xxPos, ap[i].yyPos, ap[i].xxVel,
                        ap[i].yyVel, ap[i].mass, ap[i].imgFileName);   
        }
    }
}
