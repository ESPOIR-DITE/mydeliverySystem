package gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientLogIn extends JFrame implements ActionListener
{
    private GridBagLayout layout; // layout of this frame
    private GridBagConstraints constraints;
    JLabel image=new JLabel();
    JButton logIn;
    ImageIcon glass;
    JTextArea t1 = new JTextArea("");
    JTextArea t2 = new JTextArea("");
    JTextArea t3 = new JTextArea("");

    public ClientLogIn() throws HeadlessException {

        super("DELIVERY MANAGEMENT SYSTEM");

        layout = new GridBagLayout();
        setLayout( layout ); // set frame layout
        constraints = new GridBagConstraints();

        //jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ESPOIR pc\\Desktop\\webAppDesing\\logotransresized.png"));


        //glass = new ImageIcon(getClass().getResource("scr:wickpic.png));
       image.setIcon(new javax.swing.ImageIcon("C:\\Users\\ESPOIR\\Pictures\\New folder\\wick.png"));
       
        JTextField userNameField= new JTextField(20);
        JTextField passWordField= new JTextField(20);
        JButton forgetBtn = new JButton("forgot");
         logIn = new JButton("LogIN");
        constraints.fill = GridBagConstraints.NONE;
        addComponent(t1,0,0,1,1);
        addComponent(t2,0,0,1,6);
        addComponent(t3,0,3,1,6);
addComponent(image,0,1,2,2);
        constraints.weightx = 0; // can grow wider
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.BOTH;
addComponent(userNameField,2,1,2,1);
        constraints.fill = GridBagConstraints.BOTH;
addComponent(passWordField,3,1,2,1);
        constraints.fill = GridBagConstraints.NONE;
addComponent(forgetBtn,4,2,1,1);
        constraints.fill = GridBagConstraints.BOTH;
addComponent(logIn,5,1,2,1);
logIn.addActionListener(this);



    }
    private void addComponent( Component component,int row, int column, int width, int height )
 {
    constraints.gridx = column; // set gridx
    constraints.gridy = row; // set gridy
    constraints.gridwidth = width; // set gridwidth
    constraints.gridheight = height; // set gridheight
    layout.setConstraints( component, constraints ); // set constraints
    add( component );
 }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==logIn)
        {

        }

    }
}
