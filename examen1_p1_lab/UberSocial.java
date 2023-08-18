/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen1_p1_lab;

import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author efern
 */




public class UberSocial {
    private ArrayList<SocialClass> socialAccounts;

    public UberSocial() {
        this.socialAccounts = new ArrayList<>();
    }

    public SocialClass search(String username) {
        for (SocialClass account : socialAccounts) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }

    public void addAccount(String username, String type) {
        if (search(username) == null) {
            SocialClass account;
            if (type.equals("FACEBOOK")) {
                account = new Facebook(username);
            } else if (type.equals("TWITTER")) {
                account = new Twitter(username);
            } else {
                return;
            }
            socialAccounts.add(account);
        }
    }

    public void addPost(String username, String type, String post) {
        SocialClass account = search(username);
        if (account != null) {
            account.addPost(post);
        }
    }

    public void addFriend(String user1, String user2) {
        SocialClass account1 = search(user1);
        SocialClass account2 = search(user2);
        if (account1 != null && account2 != null && account1.getClass() == account2.getClass()) {
            if (account1 instanceof Facebook) {
                ((Facebook) account1).addFriend(user2);
                ((Facebook) account2).addFriend(user1);
            }
        }
    }

    public void addComment(String user, int postId, String author, String comment) {
        SocialClass account = search(user);
        if (account != null && account instanceof Facebook) {
            Comment newComment = new Comment(postId, author, comment);
            ((Facebook) account).addComment(newComment);
        }
    }

    public void profileFrom(String user) {
        SocialClass account = search(user);
        if (account != null) {
            account.myProfile();
        }
    }

    public void showFriendDialog(String user) {
        SocialClass account = search(user);
        if (account != null) {
            ArrayList<String> friends = account.getFriends();
            ArrayList<String> sameTypeFriends = new ArrayList<>();
            for (String friend : friends) {
                SocialClass friendAccount = search(friend);
                if (friendAccount != null && friendAccount.getClass() == account.getClass()) {
                    sameTypeFriends.add(friend);
                }
            }
            if (sameTypeFriends.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No valid friends to add.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Object[] friendArray = sameTypeFriends.toArray();
            String selectedFriend = (String) JOptionPane.showInputDialog(null, "Select a friend:", "Add Friend", JOptionPane.QUESTION_MESSAGE, null, friendArray, friendArray[0]);
            if (selectedFriend != null) {
                addFriend(user, selectedFriend);
            }
        }
    }

    public void showCommentDialog(String user, int postId) {
        SocialClass account = search(user);
        if (account != null && account instanceof Facebook) {
            String author = JOptionPane.showInputDialog("Enter author:");
            String comment = JOptionPane.showInputDialog("Enter comment:");
            if (author != null && comment != null) {
                addComment(user, postId, author, comment);
            }
        }
    }
}
