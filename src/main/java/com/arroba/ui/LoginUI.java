package com.arroba.ui;

import com.arroba.dominio.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {
    //ELEMENTS LOGIN
    private JPanel body = new JPanel();
    private JPanel sectionLogin = new JPanel();
    private JPanel divCredential = new JPanel();
    private JPanel divUser = new JPanel();
    private JPanel divPassword = new JPanel();
    private JPanel divBtns = new JPanel();
    private JLabel loginPlaceHolderUser= new JLabel("Usuário:");
    private JTextField loginUserEmail = new JTextField();
    private JLabel loginPlaceHolderPassword = new JLabel("Senha:");
    private JPasswordField loginPassword = new JPasswordField();
    private JButton loginButton = new JButton("Login");
    private JButton loginCreateAccount = new JButton("Criar conta");

    JLabel logoArroba = new JLabel(new ImageIcon("./src/main/resources/img/logowhite.png"));    //LOGOS DO SISTEMA
    ImageIcon logoErrorLogin = new ImageIcon("./src/main/resources/img/erro.gif");    //LOGOS DO SISTEMA

    public static void main(String[] args) {

        Service service = new Service();
        service.setUp();

        new LoginUI(service);

    }
    public LoginUI(Service service){
        Color color = new Color(59, 74, 178);

        divUser.setBackground(color);
        divUser.add(loginPlaceHolderUser).setForeground(Color.white);
        divUser.add(loginUserEmail);
        loginUserEmail.setColumns(20);

        divPassword.setBackground(color);
        divPassword.add(loginPlaceHolderPassword).setForeground(Color.white);
        divPassword.add(loginPassword);
        loginPassword.setColumns(20);

        divCredential.setLayout(new GridLayout(2, 1));
        divCredential.setBackground(color);
        divCredential.add(divUser);
        divCredential.add(divPassword);

        FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
        layout.setVgap(20);
        divBtns.setLayout(layout);
        divBtns.setBackground(color);
        divBtns.add(loginCreateAccount).setPreferredSize(new Dimension(150, 35));
        divBtns.add(loginButton).setPreferredSize(new Dimension(150, 35));

        sectionLogin.setLayout(new GridLayout(3, 3, 20, 25));
        sectionLogin.setBackground(color);
        sectionLogin.add(logoArroba);
        sectionLogin.add(divCredential);
        sectionLogin.add(divBtns);

        body.setLayout(new FlowLayout(FlowLayout.CENTER,200,190));
        body.setBackground(color);
        body.add(sectionLogin);

        this.setTitle("arrob@ - Login");
        this.setSize(1100,800);
        this.getContentPane().add(body);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        //DEFINE PARAMETROS DE LAYOUT DO SHOW MENSAGEM DIALOG
        UIManager.put("OptionPane.background", new Color(255, 255, 255));
        UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(255, 255, 255));

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String email = loginUserEmail.getText();
                char[] senha = loginPassword.getPassword();

                service.loginUser(email, senha);

                if(service.getCurrentUser() != null){
                    HomeUI homeUI = new HomeUI(service.getCurrentUser(),  service);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"Usuário ou senha inválido","Ops...", JOptionPane.INFORMATION_MESSAGE, logoErrorLogin);
                }


            }
        });
        loginCreateAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccount(service);
            }
        });
    }
    private void createAccount(Service service) {
        CreateAccountUI createAccountUI = new CreateAccountUI(service);
        dispose();
    }




}
