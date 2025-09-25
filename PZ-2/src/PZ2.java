
public class PZ2 {
    public static void main(String[] args) {
        double a,b,c,d;

        a=3.56; b=1.02; c=3.0; d=2.43;
        double y1 = Math.pow(Math.tan(a), 1.0 / c)/(1+(Math.sinh(b)/(Math.abs(Math.log10(d+c)))));
        System.out.println("y1 = " + y1);

        a=2.54; b=1.23; c=-2.14; d=-0.23;
        double y2=2*Math.cos(Math.pow(a,b))+Math.abs(Math.acos(-Math.sqrt(c/d)));
        System.out.println("y2 = " + y2);

        a=-1.23; b=-0.34; c=0.707; d=2.312;
        double y3=3*(Math.log10(Math.abs(b/a))+Math.sqrt(Math.sin(c)+Math.exp(d)));
        System.out.println("y3 = " + y3);
    }
}