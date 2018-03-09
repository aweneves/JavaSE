package ConstantTest;

public class ConstantTest {
    public static void main(String[] args){
        Integer i1 = -129;
        Integer i2 = -129;
        Integer i3 = new Integer(20);
        System.out.println(i1==i2);
        System.out.println(i1==i3);
        String s1 = "asdfasdfasdf";
        String s2 = "asdfasdf";
        String s3 = "asdf";
        String s4 = "asdfasdf"+"asdf";
        System.out.println(s1==(s2+s3));
        System.out.println(s1==(s4));
    }
}
