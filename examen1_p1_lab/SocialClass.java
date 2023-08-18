/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen1_p1_lab;

import java.util.ArrayList;

/**
 *
 * @author efern
 */





public abstract class SocialClass {
    protected String username;
    protected ArrayList<String> friends;
    protected ArrayList<String> posts;

    public SocialClass(String username) {
        this.username = username;
        this.friends = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<String> getFriends() {
        return friends;
    }

    public void addPost(String post) {
        posts.add(post);
    }

    // Método abstracto para ser implementado en clases derivadas
    public abstract void myProfile();

    // Método para agregar amigos
    public void addFriend(String user) {
        if (!friends.contains(user) && !user.equals(username)) {
            friends.add(user);
        }
    }
}
