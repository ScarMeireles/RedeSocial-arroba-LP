package com.arroba.ui;

import com.arroba.dominio.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateAccountUI extends JFrame {

    //ELEMENTS LOGIN
    private JPanel body = new JPanel();
    private JPanel sectionCreateAccount = new JPanel();
    private JPanel divCredential = new JPanel();
    private JPanel divName = new JPanel();
    private JPanel divEmail = new JPanel();
    private JPanel divPassword = new JPanel();
    private JPanel divBtns = new JPanel();
    private JLabel loginPlaceHolderName= new JLabel("Nome:");
    private JTextField loginUserName = new JTextField();
    private JLabel loginPlaceHolderEmail= new JLabel("Email:");
    private JTextField loginUserEmail = new JTextField();
    private JLabel loginPlaceHolderPassword = new JLabel("Senha:");
    private JPasswordField loginPassword = new JPasswordField();
    private JButton createButton = new JButton("Criar Conta");
    private JButton previousButton = new JButton("Voltar");

    JLabel logoAccount = new JLabel(new ImageIcon("./src/main/resources/img/createaccountwhite.png"));    //LOGOS DO SISTEMA



    public static void main(String[] args) {
        Service service = new Service();
        service.setUp();
        new CreateAccountUI(service);
    }
    public CreateAccountUI(Service service){

        Color color = new Color(59, 74, 178);

        divName.setBackground(color);
        divName.add(loginPlaceHolderName).setForeground(Color.white);
        divName.add(loginUserName);
        loginUserName.setColumns(20);

        divEmail.setBackground(color);
        divEmail.add(loginPlaceHolderEmail).setForeground(Color.white);
        divEmail.add(loginUserEmail);
        loginUserEmail.setColumns(20);

        divPassword.setBackground(color);
        divPassword.add(loginPlaceHolderPassword).setForeground(Color.white);
        divPassword.add(loginPassword);
        loginPassword.setColumns(20);

        divCredential.setLayout(new GridLayout(4, 1));
        divCredential.setBackground(color);
        divCredential.add(divName);
        divCredential.add(divEmail);
        divCredential.add(divPassword);

        FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
        layout.setVgap(20);
        divBtns.setLayout(layout);
        divBtns.setBackground(color);
        divBtns.add(previousButton).setPreferredSize(new Dimension(150, 35));
        divBtns.add(createButton).setPreferredSize(new Dimension(150, 35));


        sectionCreateAccount.setLayout(new GridLayout(3, 3, 20, 25));
        sectionCreateAccount.setBackground(color);
        sectionCreateAccount.add(logoAccount);
        sectionCreateAccount.add(divCredential);
        sectionCreateAccount.add(divBtns);

        body.setLayout(new FlowLayout(FlowLayout.CENTER,200,190));
        body.setBackground(color);
        body.add(sectionCreateAccount);



        this.setTitle("arrob@ - Criar Conta");
        this.setSize(1100,800);
        this.getContentPane().add(body);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);


        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginUI loginUI = new LoginUI(service);
                dispose();
            }
        });


        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String nome = loginUserName.getText();
                String email = loginUserEmail.getText();
                char[] senha = loginPassword.getPassword();


                service.cadastrarUser(nome, email, senha);

                LoginUI loginUI = new LoginUI(service);
                dispose();
            }
        });



    }


}
