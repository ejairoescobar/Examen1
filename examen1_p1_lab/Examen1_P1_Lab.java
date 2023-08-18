package examen1_p1_lab;

import javax.swing.*;

public class Examen1_P1_Lab {


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        UberSocial uberSocial = new UberSocial();

        while (true) {
            String[] options = {"Create Account", "Add Friend", "Add Post", "View Profile", "Exit"};
            int selectedOption = JOptionPane.showOptionDialog(null, "Choose an action:", "UberSocial", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            if (selectedOption == 0) {
                String user = JOptionPane.showInputDialog("Enter your username:");
                if (user != null) {
                    String type = JOptionPane.showInputDialog("Enter social network (FACEBOOK or TWITTER):");
                    if (type != null) {
                        uberSocial.addAccount(user, type);
                    }
                }
            } else if (selectedOption == 1) {
                String user = JOptionPane.showInputDialog("Enter your username:");
                if (user != null) {
                    uberSocial.showFriendDialog(user);
                }
            } else if (selectedOption == 2) {
                String user = JOptionPane.showInputDialog("Enter your username:");
                if (user != null) {
                    String type = JOptionPane.showInputDialog("Enter social network (FACEBOOK or TWITTER):");
                    if (type != null) {
                        String post = JOptionPane.showInputDialog("Enter your post:");
                        if (post != null) {
                            uberSocial.addPost(user, type, post);
                        }
                    }
                }
            } else if (selectedOption == 3) {
                String user = JOptionPane.showInputDialog("Enter your username:");
                if (user != null) {
                    uberSocial.profileFrom(user);
                }
            } else if (selectedOption == 4) {
                System.exit(0);
            }
        }
    }
}
