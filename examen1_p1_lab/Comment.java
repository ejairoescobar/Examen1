/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen1_p1_lab;


import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 *
 * @author efern
 */

public class Comment {
    private int postId;
    private String author;
    private String content;
    private Calendar date;

    public Comment(int postId, String author, String content) {
        this.postId = postId;
        this.author = author;
        this.content = content;
        this.date = Calendar.getInstance();
    }

    public void print() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(author + " - " + dateFormat.format(date.getTime()) + "\n" + content + "\n");
    }

    public int getPostId() {
        return postId;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return dateFormat.format(date.getTime());
    }
}
