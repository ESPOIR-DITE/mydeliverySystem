package gui;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;


public class ClientDriver {
    public static void main(String[] args) {



    ClientLogIn clientLogIn=new ClientLogIn();

        clientLogIn.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        clientLogIn.setSize( 1000, 850 ); // set frame size
        clientLogIn.setVisible( true );

}}
