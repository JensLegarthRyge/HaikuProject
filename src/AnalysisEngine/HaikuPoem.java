package AnalysisEngine;

import java.util.*;

public class HaikuPoem {
    private String author;
    private int id;
    private String[] haikuBody = new String[3];
    private Date date;



    public HaikuPoem(String author, String[] haikuBody) {
        this.author = author;
        this.date = new Date();
        this.id = new Random().nextInt(100000);
        System.arraycopy(haikuBody, 0, this.haikuBody, 0, haikuBody.length);
    }

    @Override
    public String toString() {
        return "ID: "+id+"\n"+
                "Date: "+date+"\n"+
                "Written by: "+author+"\n"+
                haikuBody[0]+"\n"+
                haikuBody[1]+"\n"+
                haikuBody[2];

    }

    public int getId() {
        return id;
    }

    public String getHaikuBody(int i) {
        return haikuBody[i];
    }
}
