/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen1_p1_lab;

import javax.swing.*;

/**
 *
 * @author efern
 */




public class Twitter extends SocialClass {
    public Twitter(String username) {
        super(username);
    }

    @Override
    public void myProfile() {
        // Mostrar la ventana de perfil utilizando Swing
        JFrame profileFrame = new JFrame("My Profile");
        profileFrame.setSize(400, 300);
        JTextArea profileTextArea = new JTextArea();
        profileTextArea.append("My Profile: " + username + "\n");
        for (String post : posts) {
            profileTextArea.append(post + "\n");
        }
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
        profileFrame.add(profileTextArea);
        profileFrame.setVisible(true);
    }
}

