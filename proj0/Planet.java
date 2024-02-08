public class Planet {
    public static final double G=6.67e-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP,double yP,double xV,
    double yV,double m, String img){
        xxPos=xP;yyPos=yP;xxVel=xV;
        yyVel=yV;mass=m;imgFileName=img;
    }
    
    public Planet(Planet p){
        xxPos=p.xxPos;yyPos=p.yyPos;xxVel=p.xxVel;
        yyVel=p.yyVel;mass=p.mass;imgFileName=p.imgFileName;
    }

    public double calcDistance(Planet p){
        double absx=Math.abs(xxPos-p.xxPos);
        double absy=Math.abs(yyPos-p.yyPos);
        return Math.sqrt(absx*absx+absy*absy);
    }

    public double calcForceExertedBy(Planet p){
        double dis=calcDistance(p);
        return G*mass*p.mass/(dis*dis);
    }

    public double calcForceExertedByX(Planet p){
        double r=calcDistance(p);
        double dx=p.xxPos-xxPos;
        return calcForceExertedBy(p)*dx/r;
    }
    public double calcForceExertedByY(Planet p){
        double r=calcDistance(p);
        double dy=p.yyPos-yyPos;
        return calcForceExertedBy(p)*dy/r;
    }

    public double calcNetForceExertedByX(Planet[] ap){
        double allXForce=0;
        for(int i=0;i<ap.length;i++)
            if(! ap[i].equals(this))
                allXForce+=calcForceExertedByX(ap[i]);
        return allXForce;
    }
    public double calcNetForceExertedByY(Planet[] ap){
        double allYForce=0;
        for(int i=0;i<ap.length;i++)
            if(! ap[i].equals(this))
                allYForce+=calcForceExertedByY(ap[i]);
        return allYForce;
    }
}