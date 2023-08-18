/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen1_p1_lab;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author efern
 */



public class Facebook extends SocialClass implements Commentable {
    private ArrayList<Comment> comments;

    public Facebook(String username) {
        super(username);
        this.comments = new ArrayList<>();
    }

    @Override
    public boolean addComment(Comment comment) {
        if (comment.getPostId() >= 0 && comment.getPostId() < posts.size()) {
            comments.add(comment);
            return true;
        }
        return false;
    }

    @Override
    public void myProfile() {
        // Mostrar la ventana de perfil utilizando Swing
        JFrame profileFrame = new JFrame("My Profile");
        profileFrame.setSize(400, 400);
        JTextArea profileTextArea = new JTextArea();
        profileTextArea.append("My Profile: " + username + " (Facebook)\n");
        profileTextArea.append("Friends:\n");
        int count = 0;
        for (String friend : friends) {
            profileTextArea.append(friend + " ");
            count++;
            if (count >= 10) {
                profileTextArea.append("\n");
                count = 0;
            }
        }
        profileTextArea.append("\n\nPosts:\n");
        for (String post : posts) {
            profileTextArea.append(post + "\n");
        }
        profileTextArea.append("\n\nComments:\n");
        for (Comment comment : comments) {
            profileTextArea.append(comment.getAuthor() + " - " + formatDate(new Date()) + "\n");
            profileTextArea.append(comment.getContent() + "\n\n");
        }
        profileFrame.add(profileTextArea);
        profileFrame.setVisible(true);
    }

    public void addPost(String msg) {
        posts.add(msg);
    }

    public void timeline() {
        // Mostrar la ventana de timeline utilizando Swing
        JFrame timelineFrame = new JFrame("Timeline");
        timelineFrame.setSize(400, 400);
        JTextArea timelineTextArea = new JTextArea();
        timelineTextArea.append("Timeline for " + username + " (Facebook)\n\n");
        for (String post : posts) {
            timelineTextArea.append(post + "\n\n");
        }
        timelineTextArea.append("Comments:\n");
        for (Comment comment : comments) {
            timelineTextArea.append("Post " + comment.getPostId() + " - " + comment.getAuthor() + " - " + formatDate(new Date()) + "\n");
            timelineTextArea.append(comment.getContent() + "\n\n");
        }
        timelineFrame.add(timelineTextArea);
        timelineFrame.setVisible(true);
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
