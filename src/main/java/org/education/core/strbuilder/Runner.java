package org.education.core.strbuilder;

public class Runner {

    public static void main(String[] args) {

        CustomStringBuilder csb = new CustomStringBuilder("CSB-1.0", "Hello World");
        csb.save();
        // Hello World
        System.out.println(csb);

        csb.append("@LD1dw");
        // Hello World@LD1dw
        System.out.println(csb);

        csb.undo();
        // Hello World
        System.out.println(csb);
    }
}
