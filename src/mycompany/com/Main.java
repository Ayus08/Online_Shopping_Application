package mycompany.com;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;
import java.sql.*;

public class Main {
    Connection conn;
    JFrame frame2,frame1,frame;
    JTextField fName1,lName1,email1,mailfield,username1;
    JPasswordField cPassword1,password1;

    Main() {
        frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1500, 1080);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.orange);
        // for image
       // JLabel  backimg1 = new JLabel(new ImageIcon("E:\\LoginPage\\src\\mycompany\\com\\backImage.png"));
       // backimg1.setBounds(0,0,1500,1080);
       //Sanidhya Dave
        JLabel username = new JLabel("Email Id ");
        username.setBounds(100, 100, 100, 30);
        username1 = new JTextField();
        username1.setBounds(200, 100, 200, 30);
        JLabel password = new JLabel("Password ");
        password.setBounds(100, 160, 100, 30);
        password1 = new JPasswordField();
        password1.setBounds(200, 160, 200, 30);
        JButton signin = new JButton("SignIn ");
        signin.setBounds(100, 220, 80, 30);
        JButton signup = new JButton("SignUp ");
        signup.setBounds(200, 220, 80, 30);
        frame.add(username);
        frame.add(username1);
        frame.add(password);
        frame.add(password1);
        frame.add(signin);
        frame.add(signup);
        //frame.add(backimg1);

        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(false);
                frame2 = new JFrame();
                frame2.setVisible(true);
                frame2.setSize(800, 800);
                frame2.setLayout(null);
                frame2.getContentPane().setBackground(Color.orange);
                JLabel fName = new JLabel("First Name ");
                fName.setBounds(100, 100, 150, 30);
                fName1 = new JTextField();
                fName1.setBounds(300, 100, 150, 30);
                JLabel lName = new JLabel("Last Name ");
                lName.setBounds(100, 160, 150, 30);
                lName1 = new JTextField();
                lName1.setBounds(300, 160, 150, 30);
                JLabel email = new JLabel("Email Id ");
                email.setBounds(100, 220, 150, 30);
                email1 = new JTextField();
                email1.setBounds(300, 220, 150, 30);
                JLabel fpassword = new JLabel("Password ");
                fpassword.setBounds(100, 280, 150, 30);
                JPasswordField fpassword1 = new JPasswordField();
                fpassword1.setBounds(300, 280, 150, 30);
                JLabel cPassword = new JLabel("Confirm Password ");
                cPassword.setBounds(100, 340, 150, 30);
                cPassword1 = new JPasswordField();
                cPassword1.setBounds(300, 340, 150, 30);
                JButton register = new JButton("Submit ");
                register.setBounds(250, 400, 80, 30);
                JButton back = new JButton("Back ");
                back.setBounds(150, 400, 80, 30);
                frame2.add(back);
                frame2.add(register);
                frame2.add(cPassword);
                frame2.add(cPassword1);
                frame2.add(fpassword);
                frame2.add(fpassword1);
                frame2.add(email);
                frame2.add(email1);
                frame2.add(lName);
                frame2.add(lName1);
                frame2.add(fName);
                frame2.add(fName1);

                String str3 = fName1.getText();
                String str4 = lName1.getText();
                String str5 = email1.getText();
                String str6 = String.valueOf(fpassword1.getPassword());
                String str7 = String.valueOf(cPassword1.getPassword());
                register.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                   signUpDatabase();
                    }
                });
                back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frame2.setVisible(false);
                        frame.setVisible(true);
                    }
                });
            }
        });
        signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String str1 = username1.getText();
                String str2 = String.valueOf(password1.getPassword());
                if (str1.equals("") || str2.equals("")) {

                    JOptionPane.showMessageDialog(frame, "Please fill correct entries");
                } else {

                    signInDatabase();
                    frame1.setVisible(true);
                   frame1.setLayout(null);
                   frame1.setSize(1500, 1080);
                    frame1.getContentPane().setBackground(Color.orange);
                    JLabel print = new JLabel("Welcome to ekart !!");
                    print.setBounds(500, 300, 400, 150);

                    frame1.add(print);
                    JButton about = new JButton("About Us");
                    about.setBounds(600, 100, 100, 40);
                    frame1.add(about);
                    JButton shopping = new JButton("Shopping");
                    shopping.setBounds(750, 100, 100, 40);
                    frame1.add(shopping);
                    JButton exit = new JButton("Exit");
                    exit.setBounds(900, 100, 100, 40);
                    frame1.add(exit);
                    exit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {

                            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame1.setContentPane(exit);
                            exit.addActionListener(e -> {
                                frame1.dispose();
                            });
                            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        }
                    });

                    about.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            frame1.setVisible(false);
                            JFrame frame3 = new JFrame();
                            frame3.setVisible(true);
                            frame3.setLayout(null);
                            frame3.setSize(1500, 1080);
                            frame3.getContentPane().setBackground(Color.orange);

                            JLabel aboutus = new JLabel("<html>This is e-commerce website.<br>Developed By-<b> Ayush  Chandra </b> </html>");
                            aboutus.setBounds(500, 300, 300, 200);
                            frame3.add(aboutus);

                            JButton homeback = new JButton("Home");
                            homeback.setBounds(800, 100, 90, 40);
                            frame3.add(homeback);

                            homeback.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent actionEvent) {
                                    frame3.setVisible(false);
                                    frame1.setVisible(true);
                                }
                            });
                        }
                    });

                    shopping.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            frame1.setVisible(false);
                            JFrame frame4 = new JFrame();
                            frame4.setVisible(true);
                            frame4.setSize(1500, 1080);
                            frame4.setLayout(null);
                            frame4.getContentPane().setBackground(Color.orange);

                            JButton done = new JButton("Done");
                            done.setBounds(200, 150, 80, 30);
                            final DefaultListModel<String> l1 = new DefaultListModel<>();
                            l1.addElement("Mobile");
                            l1.addElement("Laptop");
                            l1.addElement("Speakers");
                            l1.addElement("Books");
                            final JList<String> list1 = new JList<>(l1);
                            list1.setBounds(100, 100, 75, 75);
                            frame4.add(list1);

                            frame4.add(done);
                            JButton exit1 = new JButton("Exit");
                            exit1.setBounds(900, 100, 100, 40);
                            frame4.add(exit1);
                            exit1.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent actionEvent) {

                                    frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    frame4.setContentPane(exit);
                                    exit.addActionListener(e -> {
                                        frame4.dispose();
                                    });
                                    frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                }
                            });

                            done.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    String data = "";
                                    if (list1.getSelectedValue() == "Mobile") {
                                        frame4.setVisible(false);
                                        JFrame frame5 = new JFrame();
                                        frame5.setVisible(true);
                                        frame5.setLayout(null);
                                        frame5.setSize(800, 800);
                                        frame5.getContentPane().setBackground(Color.orange);
                                       JLabel  backimage4 = new JLabel(new ImageIcon("E:\\LoginPage\\src\\mycompany\\com\\image4.jpg"));
                                       backimage4.setBounds(480,200,300,300);
                                        frame5.add(backimage4);
                                        final DefaultListModel<String> l2 = new DefaultListModel<>();
                                        //l2.addElement("Redmi");
                                        l2.addElement("Motorola");
                                        l2.addElement("iPhone");
                                        //l2.addElement("Samsung");
                                        final JList<String> list2 = new JList<>(l2);
                                        list2.setBounds(100, 100, 75, 75);
                                        frame5.add(list2);
                                        JButton mdone = new JButton("Done");
                                        mdone.setBounds(200, 150, 80, 30);
                                        frame5.add(mdone);
                                        JButton exit2 = new JButton("Exit");
                                        exit2.setBounds(900, 100, 100, 40);
                                        frame5.add(exit2);
                                        exit2.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent actionEvent) {

                                                frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                frame5.setContentPane(exit);
                                                exit2.addActionListener(e -> {
                                                    frame5.dispose();
                                               });
                                                frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                            }
                                        });

                                        mdone.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent actionEvent) {
                                                String mdata = "";
                                                if(list2.getSelectedValue() == "Motorola"){
                                                    frame5.setVisible(false);
                                                    JFrame frame9 = new JFrame();
                                                    frame9.setVisible(true);
                                                    frame9.setLayout(null);
                                                    frame9.setSize(800,800);
                                                    frame9.getContentPane().setBackground(Color.orange);
                                                    JLabel comname = new JLabel("<html><b>Model</b> :  Motorola One Power<br><b>Price :</b>  Rs. 19,000 </html> ");
                                                    comname.setBounds(200,200,200,40);
                                                    frame9.add(comname);
                                                    JButton combut = new JButton("Buy");
                                                    combut.setBounds(420,200,100,40);
                                                    frame9.add(combut);
                                                    JLabel comname1 = new JLabel("<html><b>Model</b> :  Moto X4<br><b>Price :</b>  Rs. 16,000 </html> ");
                                                    comname1.setBounds(200,400,200,40);
                                                    frame9.add(comname1);
                                                    JButton combut1 = new JButton("Buy");
                                                    combut1.setBounds(420,400,100,40);
                                                    frame9.add(combut1);
                                                    JButton exit3 = new JButton("Exit");
                                                    exit3.setBounds(900, 100, 100, 40);
                                                    frame9.add(exit3);
                                                    exit3.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {

                                                            frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                            frame9.setContentPane(exit);
                                                            exit.addActionListener(e -> {
                                                                frame9.dispose();
                                                            });
                                                            frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                        }
                                                    });

                                                    combut.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {
                                                            frame9.setVisible(false);
                                                            JFrame frame17 = new JFrame();
                                                            frame17.setVisible(true);
                                                            frame17.setSize(800,800);
                                                            frame17.setLayout(null);
                                                            frame17.getContentPane().setBackground(Color.orange);
                                                            JLabel confirmshop = new JLabel("Thanks for shopping !! ");
                                                            confirmshop.setBounds(100,200,150,50);
                                                            frame17.add(confirmshop);
                                                            JLabel showitems = new JLabel("Number of items: ");
                                                            showitems.setBounds(100,300,100,50);
                                                            frame17.add(showitems);
                                                            JTextField noitems = new JTextField();
                                                            noitems.setBounds(250,300,50,30);
                                                            frame17.add(noitems);
                                                            JButton forconfirmbut = new JButton("Submit");
                                                            forconfirmbut.setBounds(200,400,100,40);
                                                            frame17.add(forconfirmbut);
                                                            JButton exit4 = new JButton("Exit");
                                                            exit4.setBounds(900, 100, 100, 40);
                                                            frame17.add(exit4);
                                                            exit4.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {

                                                                    frame17.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    frame17.setContentPane(exit);
                                                                    exit.addActionListener(e -> {
                                                                        frame17.dispose();
                                                                    });
                                                                    frame17.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                }
                                                            });

                                                            forconfirmbut.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {
                                                                    String insertitems= noitems.getText();
                                                                    Double totalcost = Double.parseDouble(insertitems)*19000;
                                                                    JOptionPane.showMessageDialog(frame17,"Your total cost is : " + "Rs. " + totalcost);
                                                                    try {
                                                                        sendMail(username1.getText());
                                                                    } catch (MessagingException ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    });
                                                    combut1.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {
                                                            frame9.setVisible(false);
                                                            JFrame frame18 = new JFrame();
                                                            frame18.setVisible(true);
                                                            frame18.setSize(800,800);
                                                            frame18.setLayout(null);
                                                            frame18.getContentPane().setBackground(Color.orange);
                                                            JLabel confirmshop1 = new JLabel("Thanks for shopping !! ");
                                                            confirmshop1.setBounds(100,200,150,50);
                                                            frame18.add(confirmshop1);
                                                            JLabel showitems1 = new JLabel("Number of items: ");
                                                            showitems1.setBounds(100,300,100,30);
                                                            frame18.add(showitems1);
                                                            JTextField noitems1 = new JTextField();
                                                            noitems1.setBounds(250,300,50,30);
                                                            frame18.add(noitems1);
                                                           //mail id
                                                            JLabel maillabel = new JLabel("Your Mail id ");
                                                            maillabel.setBounds(100,400,100,30);
                                                            mailfield = new JTextField();
                                                            mailfield.setBounds(250,400,200,30);
                                                            JButton forconfirmbut1 = new JButton("Submit");
                                                            frame18.add(maillabel);
                                                            frame18.add(mailfield);
                                                            forconfirmbut1.setBounds(200,500,100,40);
                                                            frame18.add(forconfirmbut1);
                                                            JButton exit5 = new JButton("Exit");
                                                            exit5.setBounds(900, 100, 100, 40);
                                                            frame18.add(exit5);
                                                            exit5.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {

                                                                    frame18.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    frame18.setContentPane(exit);
                                                                    exit.addActionListener(e -> {
                                                                        frame18.dispose();
                                                                    });
                                                                    frame18.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                }
                                                            });

                                                            forconfirmbut1.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {
                                                                    String insertitems1 = noitems1.getText();
                                                                    Double totalcost1 = Double.parseDouble(insertitems1)*16000;
                                                                    JOptionPane.showMessageDialog(frame18,"Your total cost is : " + "Rs. " + totalcost1);
                                                                    try {
                                                                        sendMail(username1.getText());
                                                                    } catch (MessagingException ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    });
                                                }
                                                else if(list2.getSelectedValue() == "iPhone"){
                                                    frame5.setVisible(false);
                                                    JFrame frame10 = new JFrame();
                                                    frame10.setVisible(true);
                                                    frame10.setLayout(null);
                                                    frame10.setSize(800,800);
                                                    frame10.getContentPane().setBackground(Color.orange);
                                                    JLabel comi = new JLabel("<html><b>Model</b> :  iPhone 7 plus<br><b>Price :</b>  Rs. 37,000 </html> ");
                                                    comi.setBounds(200,200,200,40);
                                                    frame10.add(comi);
                                                    JButton combuti = new JButton("Buy");
                                                    combuti.setBounds(420,200,100,40);
                                                    frame10.add(combuti);
                                                    JLabel comname1i = new JLabel("<html><b>Model</b> :  iPhone 7<br><b>Price :</b>  Rs. 30,000 </html> ");
                                                    comname1i.setBounds(200,400,200,40);
                                                    frame10.add(comname1i);
                                                    JButton combut1i = new JButton("Buy");
                                                    combut1i.setBounds(420,400,100,40);
                                                    frame10.add(combut1i);
                                                    JButton exit6 = new JButton("Exit");
                                                    exit6.setBounds(900, 100, 100, 40);
                                                    frame10.add(exit6);
                                                    exit6.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {

                                                            frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                            frame10.setContentPane(exit);
                                                            exit.addActionListener(e -> {
                                                                frame10.dispose();
                                                            });
                                                            frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                        }
                                                    });

                                                    combuti.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {
                                                            frame10.setVisible(false);
                                                            JFrame frame19 = new JFrame();
                                                            frame19.setVisible(true);
                                                            frame19.setSize(800,800);
                                                            frame19.setLayout(null);
                                                            frame19.getContentPane().setBackground(Color.orange);
                                                            JLabel confirmshop2 = new JLabel("Thanks for shopping !! ");
                                                            confirmshop2.setBounds(100,200,150,50);
                                                            frame19.add(confirmshop2);
                                                            JLabel showitems2 = new JLabel("Number of items: ");
                                                            showitems2.setBounds(100,300,100,50);
                                                            frame19.add(showitems2);
                                                            JTextField noitems2 = new JTextField();
                                                            noitems2.setBounds(250,300,50,30);
                                                            frame19.add(noitems2);
                                                            JButton forconfirmbut2 = new JButton("Submit");
                                                            forconfirmbut2.setBounds(200,400,100,40);
                                                            frame19.add(forconfirmbut2);
                                                            JButton exit7 = new JButton("Exit");
                                                            exit7.setBounds(900, 100, 100, 40);
                                                            frame19.add(exit7);
                                                            exit7.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {

                                                                    frame19.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    frame19.setContentPane(exit);
                                                                    exit.addActionListener(e -> {
                                                                        frame19.dispose();
                                                                    });
                                                                    frame19.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                }
                                                            });

                                                            forconfirmbut2.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {
                                                                    String insertitems2 = noitems2.getText();
                                                                    Double totalcost2 = Double.parseDouble(insertitems2)*37000;
                                                                    JOptionPane.showMessageDialog(frame19,"Your total cost is : " + "Rs. " + totalcost2);
                                                                    try {
                                                                        sendMail(username1.getText());
                                                                    } catch (MessagingException ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    });
                                                    combut1i.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {
                                                            frame10.setVisible(false);
                                                            JFrame frame20 = new JFrame();
                                                            frame20.setVisible(true);
                                                            frame20.setSize(800,800);
                                                            frame20.setLayout(null);
                                                            frame20.getContentPane().setBackground(Color.orange);
                                                            JLabel confirmshop3 = new JLabel("Thanks for shopping !! ");
                                                            confirmshop3.setBounds(100,200,150,50);
                                                            frame20.add(confirmshop3);
                                                            JLabel showitems3 = new JLabel("Number of items: ");
                                                            showitems3.setBounds(100,300,100,50);
                                                            frame20.add(showitems3);
                                                            JTextField noitems3 = new JTextField();
                                                            noitems3.setBounds(250,300,50,30);
                                                            frame20.add(noitems3);
                                                            JButton forconfirmbut3 = new JButton("Submit");
                                                            forconfirmbut3.setBounds(200,400,100,40);
                                                            frame20.add(forconfirmbut3);
                                                            JButton exit9 = new JButton("Exit");
                                                            exit9.setBounds(900, 100, 100, 40);
                                                            frame20.add(exit9);
                                                            exit9.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {

                                                                    frame20.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    frame20.setContentPane(exit);
                                                                    exit.addActionListener(e -> {
                                                                        frame20.dispose();
                                                                    });
                                                                    frame20.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                }
                                                            });

                                                            forconfirmbut3.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {
                                                                    String insertitems3 = noitems3.getText();
                                                                    Double totalcost3 = Double.parseDouble(insertitems3)*30000;
                                                                    JOptionPane.showMessageDialog(frame20,"Your total cost is : " + "Rs. " + totalcost3);
                                                                    try {
                                                                        sendMail(username1.getText());
                                                                    } catch (MessagingException ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    });
                                                }
                                            }
                                        });
                                    }
                                    else if (list1.getSelectedValue() == "Laptop") {
                                        frame4.setVisible(false);
                                        JFrame frame6 = new JFrame();
                                        frame6.setVisible(true);
                                        frame6.setLayout(null);
                                        frame6.setSize(800, 800);
                                        frame6.getContentPane().setBackground(Color.orange);
                                        JLabel  backimage3 = new JLabel(new ImageIcon("E:\\LoginPage\\src\\mycompany\\com\\image3.jpg"));
                                        backimage3.setBounds(480,200,300,300);
                                        frame6.add(backimage3);
                                        final DefaultListModel<String> l3 = new DefaultListModel<>();
                                        //l3.addElement("Hp");
                                        //l3.addElement("Lenovo");
                                        l3.addElement("Asus");
                                        l3.addElement("Acer");
                                        final JList<String> list3 = new JList<>(l3);
                                        list3.setBounds(100, 100, 75, 75);
                                        frame6.add(list3);
                                        JButton ldone = new JButton("Done");
                                        ldone.setBounds(200, 150, 80, 30);
                                        frame6.add(ldone);
                                        JButton exit10 = new JButton("Exit");
                                        exit10.setBounds(900, 100, 100, 40);
                                        frame6.add(exit10);
                                        exit10.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent actionEvent) {

                                                frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                frame6.setContentPane(exit);
                                                exit.addActionListener(e -> {
                                                    frame6.dispose();
                                                });
                                                frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                            }
                                        });

                                        ldone.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent actionEvent) {
                                                String ldata = "";
                                                if (list3.getSelectedValue() == "Asus") {
                                                    frame6.setVisible(false);
                                                    JFrame frame11 = new JFrame();
                                                    frame11.setVisible(true);
                                                    frame11.setLayout(null);
                                                    frame11.setSize(800, 800);
                                                    frame11.getContentPane().setBackground(Color.orange);
                                                    JLabel coml = new JLabel("<html><b>Model</b> :  Asus VivoBook Gaming Core i7 9th Gen<br><b>Price :</b>  Rs. 76,000 </html> ");
                                                    coml.setBounds(200, 200, 300, 80);
                                                    frame11.add(coml);
                                                    JButton combutl = new JButton("Buy");
                                                    combutl.setBounds(500, 200, 100, 60);
                                                    frame11.add(combutl);
                                                    JLabel comasus = new JLabel("<html><b>Model</b> :  Asus VivoBook Gaming Core i5 9th Gen<br><b>Price :</b>  Rs. 55,000 </html> ");
                                                    comasus.setBounds(200, 400, 300, 80);
                                                    frame11.add(comasus);
                                                    JButton combutasus1 = new JButton("Buy");
                                                    combutasus1.setBounds(500, 400, 100, 60);
                                                    frame11.add(combutasus1);
                                                    JButton exit11 = new JButton("Exit");
                                                    exit11.setBounds(900, 100, 100, 40);
                                                    frame11.add(exit11);
                                                    exit11.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {

                                                            frame11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                            frame11.setContentPane(exit);
                                                            exit.addActionListener(e -> {
                                                                frame11.dispose();
                                                            });
                                                            frame11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                        }
                                                    });


                                                    combutl.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {
                                                            frame11.setVisible(false);
                                                            JFrame frame21 = new JFrame();
                                                            frame21.setVisible(true);
                                                            frame21.setSize(800,800);
                                                            frame21.setLayout(null);
                                                            frame21.getContentPane().setBackground(Color.orange);
                                                            JLabel confirmshop4 = new JLabel("Thanks for shopping !! ");
                                                            confirmshop4.setBounds(100,200,150,50);
                                                            frame21.add(confirmshop4);
                                                            JLabel showitems4 = new JLabel("Number of items: ");
                                                            showitems4.setBounds(100,300,100,50);
                                                            frame21.add(showitems4);
                                                            JTextField noitems4 = new JTextField();
                                                            noitems4.setBounds(250,300,50,30);
                                                            frame21.add(noitems4);
                                                            JButton forconfirmbut4 = new JButton("Submit");
                                                            forconfirmbut4.setBounds(200,400,100,40);
                                                            frame21.add(forconfirmbut4);
                                                            JButton exit12 = new JButton("Exit");
                                                            exit12.setBounds(900, 100, 100, 40);
                                                            frame21.add(exit12);
                                                            exit12.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {

                                                                    frame21.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    frame21.setContentPane(exit);
                                                                    exit.addActionListener(e -> {
                                                                        frame21.dispose();
                                                                    });
                                                                    frame21.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                }
                                                            });

                                                            forconfirmbut4.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {
                                                                    String insertitems4 = noitems4.getText();
                                                                    Double totalcost4 = Double.parseDouble(insertitems4)*76000;
                                                                    JOptionPane.showMessageDialog(frame21,"Your total cost is : " + "Rs. " + totalcost4);
                                                                    try {
                                                                        sendMail(username1.getText());
                                                                    } catch (MessagingException ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    });
                                                    combutasus1.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {
                                                            frame11.setVisible(false);
                                                            JFrame frame22 = new JFrame();
                                                            frame22.setVisible(true);
                                                            frame22.setSize(800,800);
                                                            frame22.setLayout(null);
                                                            frame22.getContentPane().setBackground(Color.orange);
                                                            JLabel confirmshop5 = new JLabel("Thanks for shopping !! ");
                                                            confirmshop5.setBounds(100,200,150,50);
                                                            frame22.add(confirmshop5);
                                                            JLabel showitems5 = new JLabel("Number of items: ");
                                                            showitems5.setBounds(100,300,100,50);
                                                            frame22.add(showitems5);
                                                            JTextField noitems5 = new JTextField();
                                                            noitems5.setBounds(250,300,50,30);
                                                            frame22.add(noitems5);
                                                            JButton forconfirmbut5 = new JButton("Submit");
                                                            forconfirmbut5.setBounds(200,400,100,40);
                                                            frame22.add(forconfirmbut5);
                                                            JButton exit13 = new JButton("Exit");
                                                            exit13.setBounds(900, 100, 100, 40);
                                                            frame22.add(exit13);
                                                            exit13.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {

                                                                    frame22.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    frame22.setContentPane(exit);
                                                                    exit.addActionListener(e -> {
                                                                        frame22.dispose();
                                                                    });
                                                                    frame22.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                }
                                                            });

                                                            forconfirmbut5.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {
                                                                    String insertitems5 = noitems5.getText();
                                                                    Double totalcost5 = Double.parseDouble(insertitems5)*55000;
                                                                    JOptionPane.showMessageDialog(frame22,"Your total cost is : " + "Rs. " + totalcost5);
                                                                    try {
                                                                        sendMail(username1.getText());
                                                                    } catch (MessagingException ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    });
                                                } else if (list3.getSelectedValue() == "Acer") {
                                                    frame6.setVisible(false);
                                                    JFrame frame12 = new JFrame();
                                                    frame12.setVisible(true);
                                                    frame12.setLayout(null);
                                                    frame12.setSize(800, 800);
                                                    frame12.getContentPane().setBackground(Color.orange);
                                                    JLabel comacer = new JLabel("<html><b>Model</b> :  Acer Nitro 5 Core i7 9th Gen<br><b>Price :</b>  Rs. 70,000 </html> ");
                                                    comacer.setBounds(200, 200, 300, 80);
                                                    frame12.add(comacer);
                                                    JButton combutacer = new JButton("Buy");
                                                    combutacer.setBounds(500, 200, 100, 60);
                                                    frame12.add(combutacer);
                                                    JLabel comacer1 = new JLabel("<html><b>Model</b> :  Acer Swift 3 Core i5 8th Gen<br><b>Price :</b>  Rs. 54,000 </html> ");
                                                    comacer1.setBounds(200, 400, 300, 80);
                                                    frame12.add(comacer1);
                                                    JButton combutacer1 = new JButton("Buy");
                                                    combutacer1.setBounds(500, 400, 100, 60);
                                                    frame12.add(combutacer1);
                                                    JButton exit14 = new JButton("Exit");
                                                    exit14.setBounds(900, 100, 100, 40);
                                                    frame12.add(exit14);
                                                    exit14.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {

                                                            frame12.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                            frame12.setContentPane(exit);
                                                            exit.addActionListener(e -> {
                                                                frame12.dispose();
                                                            });
                                                            frame12.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                        }
                                                    });

                                                    combutacer.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {
                                                            frame12.setVisible(false);
                                                            JFrame frame23 = new JFrame();
                                                            frame23.setVisible(true);
                                                            frame23.setSize(800,800);
                                                            frame23.setLayout(null);
                                                            frame23.getContentPane().setBackground(Color.orange);
                                                            JLabel confirmshop6 = new JLabel("Thanks for shopping !! ");
                                                            confirmshop6.setBounds(100,200,150,50);
                                                            frame23.add(confirmshop6);
                                                            JLabel showitems6 = new JLabel("Number of items: ");
                                                            showitems6.setBounds(100,300,100,50);
                                                            frame23.add(showitems6);
                                                            JTextField noitems6 = new JTextField();
                                                            noitems6.setBounds(250,300,50,30);
                                                            frame23.add(noitems6);
                                                            JButton forconfirmbut6 = new JButton("Submit");
                                                            forconfirmbut6.setBounds(200,400,100,40);
                                                            frame23.add(forconfirmbut6);
                                                            JButton exit15 = new JButton("Exit");
                                                            exit15.setBounds(900, 100, 100, 40);
                                                            frame23.add(exit15);
                                                            exit15.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {

                                                                    frame23.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    frame23.setContentPane(exit);
                                                                    exit.addActionListener(e -> {
                                                                        frame23.dispose();
                                                                    });
                                                                    frame23.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                }
                                                            });

                                                            forconfirmbut6.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {
                                                                    String insertitems6 = noitems6.getText();
                                                                    Double totalcost6 = Double.parseDouble(insertitems6)*70000;
                                                                    JOptionPane.showMessageDialog(frame23,"Your total cost is : " + "Rs. " + totalcost6);
                                                                    try {
                                                                        sendMail(username1.getText());
                                                                    } catch (MessagingException ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    });
                                                    combutacer1.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {
                                                            frame12.setVisible(false);
                                                            JFrame frame24 = new JFrame();
                                                            frame24.setVisible(true);
                                                            frame24.setSize(800,800);
                                                            frame24.setLayout(null);
                                                            frame24.getContentPane().setBackground(Color.orange);
                                                            JLabel confirmshop7 = new JLabel("Thanks for shopping !! ");
                                                            confirmshop7.setBounds(100,200,150,50);
                                                            frame24.add(confirmshop7);
                                                            JLabel showitems7 = new JLabel("Number of items: ");
                                                            showitems7.setBounds(100,300,100,50);
                                                            frame24.add(showitems7);
                                                            JTextField noitems7 = new JTextField();
                                                            noitems7.setBounds(250,300,50,30);
                                                            frame24.add(noitems7);
                                                            JButton forconfirmbut7 = new JButton("Submit");
                                                            forconfirmbut7.setBounds(200,400,100,40);
                                                            frame24.add(forconfirmbut7);
                                                            JButton exit16 = new JButton("Exit");
                                                            exit16.setBounds(900, 100, 100, 40);
                                                            frame24.add(exit16);
                                                            exit16.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {

                                                                    frame24.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    frame24.setContentPane(exit);
                                                                    exit.addActionListener(e -> {
                                                                        frame24.dispose();
                                                                    });
                                                                    frame24.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                }
                                                            });

                                                            forconfirmbut7.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {
                                                                    String insertitems7 = noitems7.getText();
                                                                    Double totalcost7 = Double.parseDouble(insertitems7)*54000;
                                                                    JOptionPane.showMessageDialog(frame24,"Your total cost is : " + "Rs. " + totalcost7);
                                                                    try {
                                                                        sendMail(username1.getText());
                                                                    } catch (MessagingException ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    });
                                                }
                                            }

                                        });
                                    }

                                    else if (list1.getSelectedValue() == "Speakers") {
                                        frame4.setVisible(false);
                                        JFrame frame7 = new JFrame();
                                        frame7.setVisible(true);
                                        frame7.setLayout(null);
                                        frame7.setSize(800, 800);
                                        frame7.getContentPane().setBackground(Color.orange);
                                        JLabel  backimage2 = new JLabel(new ImageIcon("E:\\LoginPage\\src\\mycompany\\com\\image2.jpg"));
                                        backimage2.setBounds(480,200,300,300);
                                        frame7.add(backimage2);
                                        final DefaultListModel<String> l4 = new DefaultListModel<>();
                                        l4.addElement("boAt");
                                        l4.addElement("Jbl");
                                        //l4.addElement("Sony");
                                        //l4.addElement("Mi");
                                        final JList<String> list4 = new JList<>(l4);
                                        list4.setBounds(100, 100, 75, 75);
                                        frame7.add(list4);
                                        JButton sdone = new JButton("Done");
                                        sdone.setBounds(200, 150, 80, 30);
                                        frame7.add(sdone);
                                        JButton exit17 = new JButton("Exit");
                                        exit17.setBounds(900, 100, 100, 40);
                                        frame7.add(exit17);
                                        exit17.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent actionEvent) {

                                                frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                frame7.setContentPane(exit);
                                                exit.addActionListener(e -> {
                                                    frame7.dispose();
                                                });
                                                frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                            }
                                        });

                                        sdone.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent actionEvent) {
                                                String sdata = "";
                                                if(list4.getSelectedValue() == "boAt"){
                                                    frame7.setVisible(false);
                                                    JFrame frame13 = new JFrame();
                                                    frame13.setVisible(true);
                                                    frame13.setLayout(null);
                                                    frame13.setSize(800, 800);
                                                    frame13.getContentPane().setBackground(Color.orange);
                                                    JLabel boatlabel = new JLabel("<html><b>Model</b> :  boAt Stone Grenade 5 W Portable Bluetooth Speaker<br><b>Price :</b>  Rs. 1,500 </html> ");
                                                    boatlabel.setBounds(200, 200, 300, 80);
                                                    frame13.add(boatlabel);
                                                    JButton boatbut = new JButton("Buy");
                                                    boatbut.setBounds(500, 200, 100, 60);
                                                    frame13.add(boatbut);
                                                    JLabel boatlabel1 = new JLabel("<html><b>Model</b> :  boAt Stone 650 10 W Bluetooth Speaker<br><b>Price :</b>  Rs. 2,000 </html> ");
                                                    boatlabel1.setBounds(200, 400, 300, 80);
                                                    frame13.add(boatlabel1);
                                                    JButton boatbut1 = new JButton("Buy");
                                                    boatbut1.setBounds(500, 400, 100, 60);
                                                    frame13.add(boatbut1);
                                                    JButton exit18 = new JButton("Exit");
                                                    exit18.setBounds(900, 100, 100, 40);
                                                    frame13.add(exit18);
                                                    exit18.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {

                                                            frame13.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                            frame13.setContentPane(exit);
                                                            exit.addActionListener(e -> {
                                                                frame13.dispose();
                                                            });
                                                            frame13.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                        }
                                                    });

                                                    boatbut.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {
                                                            frame13.setVisible(false);
                                                            JFrame frame25 = new JFrame();
                                                            frame25.setVisible(true);
                                                            frame25.setSize(800,800);
                                                            frame25.setLayout(null);
                                                            frame25.getContentPane().setBackground(Color.orange);
                                                            JLabel confirmshop8 = new JLabel("Thanks for shopping !! ");
                                                            confirmshop8.setBounds(100,200,150,50);
                                                            frame25.add(confirmshop8);
                                                            JLabel showitems8 = new JLabel("Number of items: ");
                                                            showitems8.setBounds(100,300,100,50);
                                                            frame25.add(showitems8);
                                                            JTextField noitems8 = new JTextField();
                                                            noitems8.setBounds(250,300,50,30);
                                                            frame25.add(noitems8);
                                                            JButton forconfirmbut8 = new JButton("Submit");
                                                            forconfirmbut8.setBounds(200,400,100,40);
                                                            frame25.add(forconfirmbut8);
                                                            JButton exit19 = new JButton("Exit");
                                                            exit19.setBounds(900, 100, 100, 40);
                                                            frame25.add(exit19);
                                                            exit19.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {

                                                                    frame25.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    frame25.setContentPane(exit);
                                                                    exit.addActionListener(e -> {
                                                                        frame25.dispose();
                                                                    });
                                                                    frame25.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                }
                                                            });

                                                            forconfirmbut8.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {
                                                                    String insertitems8 = noitems8.getText();
                                                                    Double totalcost8 = Double.parseDouble(insertitems8)*1500;
                                                                    JOptionPane.showMessageDialog(frame25,"Your total cost is : " + "Rs. " + totalcost8);
                                                                    try {
                                                                        sendMail(username1.getText());
                                                                    } catch (MessagingException ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    });
                                                    boatbut1.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {
                                                            frame13.setVisible(false);
                                                            JFrame frame26 = new JFrame();
                                                            frame26.setVisible(true);
                                                            frame26.setSize(800,800);
                                                            frame26.setLayout(null);
                                                            frame26.getContentPane().setBackground(Color.orange);
                                                            JLabel confirmshop9 = new JLabel("Thanks for shopping !! ");
                                                            confirmshop9.setBounds(100,200,150,50);
                                                            frame26.add(confirmshop9);
                                                            JLabel showitems9 = new JLabel("Number of items: ");
                                                            showitems9.setBounds(100,300,100,50);
                                                            frame26.add(showitems9);
                                                            JTextField noitems9 = new JTextField();
                                                            noitems9.setBounds(250,300,50,30);
                                                            frame26.add(noitems9);
                                                            JButton forconfirmbut9 = new JButton("Submit");
                                                            forconfirmbut9.setBounds(200,400,100,40);
                                                            frame26.add(forconfirmbut9);
                                                            JButton exit20 = new JButton("Exit");
                                                            exit20.setBounds(900, 100, 100, 40);
                                                            frame26.add(exit20);
                                                            exit20.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {

                                                                    frame26.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    frame26.setContentPane(exit);
                                                                    exit.addActionListener(e -> {
                                                                        frame26.dispose();
                                                                    });
                                                                    frame26.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                }
                                                            });

                                                            forconfirmbut9.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {
                                                                    String insertitems9 = noitems9.getText();
                                                                    Double totalcost9 = Double.parseDouble(insertitems9)*2000;
                                                                    JOptionPane.showMessageDialog(frame26,"Your total cost is : " + "Rs. " + totalcost9);
                                                                    try {
                                                                        sendMail(username1.getText());
                                                                    } catch (MessagingException ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    });
                                                }
                                                else if(list4.getSelectedValue() == "Jbl"){
                                                    frame7.setVisible(false);
                                                    JFrame frame14 = new JFrame();
                                                    frame14.setVisible(true);
                                                    frame14.setLayout(null);
                                                    frame14.setSize(800, 800);
                                                    frame14.getContentPane().setBackground(Color.orange);
                                                    JLabel jbllabel = new JLabel("<html><b>Model</b> :  JBL Tuner Portable Bluetooth Speaker<br><b>Price :</b>  Rs. 3,600 </html> ");
                                                    jbllabel.setBounds(200, 200, 300, 80);
                                                    frame14.add(jbllabel);
                                                    JButton jblbut = new JButton("Buy");
                                                    jblbut.setBounds(500, 200, 100, 60);
                                                    frame14.add(jblbut);
                                                    JLabel jbllabel1 = new JLabel("<html><b>Model</b> :  JBL Go PLUS Portable Bluetooth Speaker<br><b>Price :</b>  Rs. 1,600 </html> ");
                                                    jbllabel1.setBounds(200, 400, 300, 80);
                                                    frame14.add(jbllabel1);
                                                    JButton jblbut1 = new JButton("Buy");
                                                    jblbut1.setBounds(500, 400, 100, 60);
                                                    frame14.add(jblbut1);
                                                    JButton exit21 = new JButton("Exit");
                                                    exit21.setBounds(900, 100, 100, 40);
                                                    frame14.add(exit21);
                                                    exit21.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {

                                                            frame14.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                            frame14.setContentPane(exit);
                                                            exit.addActionListener(e -> {
                                                                frame14.dispose();
                                                            });
                                                            frame14.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                        }
                                                    });

                                                    jblbut.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {
                                                            frame14.setVisible(false);
                                                            JFrame frame27 = new JFrame();
                                                            frame27.setVisible(true);
                                                            frame27.setSize(800,800);
                                                            frame27.setLayout(null);
                                                            frame27.getContentPane().setBackground(Color.orange);
                                                            JLabel confirmshop10 = new JLabel("Thanks for shopping !! ");
                                                            confirmshop10.setBounds(100,200,150,50);
                                                            frame27.add(confirmshop10);
                                                            JLabel showitems10 = new JLabel("Number of items: ");
                                                            showitems10.setBounds(100,300,100,50);
                                                            frame27.add(showitems10);
                                                            JTextField noitems10 = new JTextField();
                                                            noitems10.setBounds(250,300,50,30);
                                                            frame27.add(noitems10);
                                                            JButton forconfirmbut10 = new JButton("Submit");
                                                            forconfirmbut10.setBounds(200,400,100,40);
                                                            frame27.add(forconfirmbut10);
                                                            JButton exit22 = new JButton("Exit");
                                                            exit22.setBounds(900, 100, 100, 40);
                                                            frame27.add(exit22);
                                                            exit22.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {

                                                                    frame27.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    frame27.setContentPane(exit);
                                                                    exit.addActionListener(e -> {
                                                                        frame1.dispose();
                                                                    });
                                                                    frame27.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                }
                                                            });

                                                            forconfirmbut10.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {
                                                                    String insertitems10 = noitems10.getText();
                                                                    Double totalcost10 = Double.parseDouble(insertitems10)*3600;
                                                                    JOptionPane.showMessageDialog(frame27,"Your total cost is : " + "Rs. " + totalcost10);
                                                                    try {
                                                                        sendMail(username1.getText());
                                                                    } catch (MessagingException ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    });
                                                    jblbut1.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {
                                                            frame14.setVisible(false);
                                                            JFrame frame28 = new JFrame();
                                                            frame28.setVisible(true);
                                                            frame28.setSize(800,800);
                                                            frame28.setLayout(null);
                                                            frame28.getContentPane().setBackground(Color.orange);
                                                            JLabel confirmshop11 = new JLabel("Thanks for shopping !! ");
                                                            confirmshop11.setBounds(100,200,150,50);
                                                            frame28.add(confirmshop11);
                                                            JLabel showitems11 = new JLabel("Number of items: ");
                                                            showitems11.setBounds(100,300,100,50);
                                                            frame28.add(showitems11);
                                                            JTextField noitems11 = new JTextField();
                                                            noitems11.setBounds(250,300,50,30);
                                                            frame28.add(noitems11);
                                                            JButton forconfirmbut11 = new JButton("Submit");
                                                            forconfirmbut11.setBounds(200,400,100,40);
                                                            frame28.add(forconfirmbut11);
                                                            JButton exit23 = new JButton("Exit");
                                                            exit23.setBounds(900, 100, 100, 40);
                                                            frame28.add(exit23);
                                                            exit23.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {

                                                                    frame28.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    frame28.setContentPane(exit);
                                                                    exit.addActionListener(e -> {
                                                                        frame1.dispose();
                                                                    });
                                                                    frame28.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                }
                                                            });

                                                            forconfirmbut11.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {
                                                                    String insertitems11 = noitems11.getText();
                                                                    Double totalcost11 = Double.parseDouble(insertitems11)*1600;
                                                                    JOptionPane.showMessageDialog(frame28,"Your total cost is : " + "Rs. " + totalcost11);
                                                                    try {
                                                                        sendMail(username1.getText());
                                                                    } catch (MessagingException ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    });
                                                }
                                            }
                                        });
                                    }
                                    else if (list1.getSelectedValue() == "Books") {
                                        frame4.setVisible(false);
                                        JFrame frame8 = new JFrame();
                                        frame8.setVisible(true);
                                        frame8.setLayout(null);
                                        frame8.setSize(800, 800);
                                        frame8.getContentPane().setBackground(Color.orange);
                                        JLabel  backimage1 = new JLabel(new ImageIcon("E:\\LoginPage\\src\\mycompany\\com\\image1.jpg"));
                                        backimage1.setBounds(480,200,300,300);
                                        frame8.add(backimage1);
                                        final DefaultListModel<String> l5 = new DefaultListModel<>();
                                        l5.addElement("E-learning");
                                        l5.addElement("Fiction");
                                        //l5.addElement("Non Fiction");
                                        //l5.addElement("test Prep");
                                        final JList<String> list5 = new JList<>(l5);
                                        list5.setBounds(100, 100, 75, 75);
                                        frame8.add(list5);
                                        JButton bdone = new JButton("Done");
                                        bdone.setBounds(200, 150, 80, 30);
                                        frame8.add(bdone);
                                        JButton exit24 = new JButton("Exit");
                                        exit24.setBounds(900, 100, 100, 40);
                                        frame8.add(exit24);
                                        exit24.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent actionEvent) {

                                                frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                frame8.setContentPane(exit);
                                                exit.addActionListener(e -> {
                                                    frame8.dispose();
                                                });
                                                frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                            }
                                        });

                                        bdone.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent actionEvent) {
                                                String bdata = "";
                                                if(list5.getSelectedValue() == "E-learning"){
                                                    frame8.setVisible(false);
                                                    JFrame frame15 = new JFrame();
                                                    frame15.setVisible(true);
                                                    frame15.setLayout(null);
                                                    frame15.setSize(800, 800);
                                                    frame15.getContentPane().setBackground(Color.orange);
                                                    JLabel elabel = new JLabel("<html><b>Model</b> :  Udemy.com Pianoforall<br><b>Price :</b>  Rs. 450 </html> ");
                                                    elabel.setBounds(200, 200, 300, 80);
                                                    frame15.add(elabel);
                                                    JButton ebut = new JButton("Buy");
                                                    ebut.setBounds(500, 200, 100, 60);
                                                    frame15.add(ebut);
                                                    JLabel elabel1 = new JLabel("<html><b>Model</b> :  Testbook.com Test Preparation <br><b>Price :</b>  Rs. 300 </html> ");
                                                    elabel1.setBounds(200, 400, 300, 80);
                                                    frame15.add(elabel1);
                                                    JButton ebut1 = new JButton("Buy");
                                                    ebut1.setBounds(500, 400, 100, 60);
                                                    frame15.add(ebut1);
                                                    JButton exit25 = new JButton("Exit");
                                                    exit25.setBounds(900, 100, 100, 40);
                                                    frame15.add(exit25);
                                                    exit25.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {

                                                            frame15.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                            frame15.setContentPane(exit);
                                                            exit.addActionListener(e -> {
                                                                frame15.dispose();
                                                            });
                                                            frame15.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                        }
                                                    });

                                                    ebut.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {
                                                            frame15.setVisible(false);
                                                            JFrame frame29 = new JFrame();
                                                            frame29.setVisible(true);
                                                            frame29.setSize(800,800);
                                                            frame29.setLayout(null);
                                                            frame29.getContentPane().setBackground(Color.orange);
                                                            JLabel confirmshop12 = new JLabel("Thanks for shopping !! ");
                                                            confirmshop12.setBounds(100,200,150,50);
                                                            frame29.add(confirmshop12);
                                                            JLabel showitems12 = new JLabel("Number of items: ");
                                                            showitems12.setBounds(100,300,100,50);
                                                            frame29.add(showitems12);
                                                            JTextField noitems12 = new JTextField();
                                                            noitems12.setBounds(250,300,50,30);
                                                            frame29.add(noitems12);
                                                            JButton forconfirmbut12 = new JButton("Submit");
                                                            forconfirmbut12.setBounds(200,400,100,40);
                                                            frame29.add(forconfirmbut12);
                                                            JButton exit26 = new JButton("Exit");
                                                            exit26.setBounds(900, 100, 100, 40);
                                                            frame29.add(exit26);
                                                            exit26.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {

                                                                    frame29.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    frame29.setContentPane(exit);
                                                                    exit.addActionListener(e -> {
                                                                        frame29.dispose();
                                                                    });
                                                                    frame29.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                }
                                                            });

                                                            forconfirmbut12.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {
                                                                    String insertitems12 = noitems12.getText();
                                                                    Double totalcost12 = Double.parseDouble(insertitems12)*450;
                                                                    JOptionPane.showMessageDialog(frame29,"Your total cost is : " + "Rs. " + totalcost12);
                                                                    try {
                                                                        sendMail(username1.getText());
                                                                    } catch (MessagingException ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    });
                                                    ebut1.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {
                                                            frame15.setVisible(false);
                                                            JFrame frame30 = new JFrame();
                                                            frame30.setVisible(true);
                                                            frame30.setSize(800,800);
                                                            frame30.setLayout(null);
                                                            frame30.getContentPane().setBackground(Color.orange);
                                                            JLabel confirmshop13 = new JLabel("Thanks for shopping !! ");
                                                            confirmshop13.setBounds(100,200,150,50);
                                                            frame30.add(confirmshop13);
                                                            JLabel showitems13 = new JLabel("Number of items: ");
                                                            showitems13.setBounds(100,300,100,50);
                                                            frame30.add(showitems13);
                                                            JTextField noitems13 = new JTextField();
                                                            noitems13.setBounds(250,300,50,30);
                                                            frame30.add(noitems13);
                                                            JButton forconfirmbut13 = new JButton("Submit");
                                                            forconfirmbut13.setBounds(200,400,100,40);
                                                            frame30.add(forconfirmbut13);
                                                            JButton exit27 = new JButton("Exit");
                                                            exit27.setBounds(900, 100, 100, 40);
                                                            frame30.add(exit27);
                                                            exit27.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {

                                                                    frame30.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    frame30.setContentPane(exit);
                                                                    exit.addActionListener(e -> {
                                                                        frame30.dispose();
                                                                    });
                                                                    frame30.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                }
                                                            });

                                                            forconfirmbut13.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {
                                                                    String insertitems13 = noitems13.getText();
                                                                    Double totalcost13 = Double.parseDouble(insertitems13)*300;
                                                                    JOptionPane.showMessageDialog(frame30,"Your total cost is : " + "Rs. " + totalcost13);
                                                                    try {
                                                                        sendMail(username1.getText());
                                                                    } catch (MessagingException ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    });
                                                }
                                                else if(list5.getSelectedValue() == "Fiction"){
                                                    frame8.setVisible(false);
                                                    JFrame frame16 = new JFrame();
                                                    frame16.setVisible(true);
                                                    frame16.setLayout(null);
                                                    frame16.setSize(800, 800);
                                                    frame16.getContentPane().setBackground(Color.orange);
                                                    JLabel flabel = new JLabel("<html><b>Model</b> :  Fahrenheit 451<br><b>Price :</b>  Rs. 270 </html> ");
                                                    flabel.setBounds(200, 200, 200, 40);
                                                    frame16.add(flabel);
                                                    JButton fbut = new JButton("Buy");
                                                    fbut.setBounds(420, 200, 100, 40);
                                                    frame16.add(fbut);
                                                    JLabel flabel1 = new JLabel("<html><b>Model</b> :  Never Let Me Go<br><b>Price :</b>  Rs. 300 </html> ");
                                                    flabel1.setBounds(200, 400, 200, 40);
                                                    frame16.add(flabel1);
                                                    JButton fbut1 = new JButton("Buy");
                                                    fbut1.setBounds(420, 400, 100, 40);
                                                    frame16.add(fbut1);
                                                    JButton exit28 = new JButton("Exit");
                                                    exit28.setBounds(900, 100, 100, 40);
                                                    frame16.add(exit28);
                                                    exit28.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {

                                                            frame16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                            frame16.setContentPane(exit);
                                                            exit.addActionListener(e -> {
                                                                frame16.dispose();
                                                            });
                                                            frame16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                        }
                                                    });

                                                    fbut.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {
                                                            frame16.setVisible(false);
                                                            JFrame frame31 = new JFrame();
                                                            frame31.setVisible(true);
                                                            frame31.setSize(800,800);
                                                            frame31.setLayout(null);
                                                            frame31.getContentPane().setBackground(Color.orange);
                                                            JLabel confirmshop14 = new JLabel("Thanks for shopping !! ");
                                                            confirmshop14.setBounds(100,200,150,50);
                                                            frame31.add(confirmshop14);
                                                            JLabel showitems14 = new JLabel("Number of items: ");
                                                            showitems14.setBounds(100,300,100,50);
                                                            frame31.add(showitems14);
                                                            JTextField noitems14 = new JTextField();
                                                            noitems14.setBounds(250,300,50,30);
                                                            frame31.add(noitems14);
                                                            JButton forconfirmbut14 = new JButton("Submit");
                                                            forconfirmbut14.setBounds(200,400,100,40);
                                                            frame31.add(forconfirmbut14);
                                                            JButton exit29 = new JButton("Exit");
                                                            exit29.setBounds(900, 100, 100, 40);
                                                            frame31.add(exit29);
                                                            exit29.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {

                                                                    frame31.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    frame31.setContentPane(exit);
                                                                    exit.addActionListener(e -> {
                                                                        frame31.dispose();
                                                                    });
                                                                    frame31.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                }
                                                            });

                                                            forconfirmbut14.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {
                                                                    String insertitems14 = noitems14.getText();
                                                                    Double totalcost14 = Double.parseDouble(insertitems14)*270;
                                                                    JOptionPane.showMessageDialog(frame31,"Your total cost is : " + "Rs. " + totalcost14);
                                                                    try {
                                                                        sendMail(username1.getText());
                                                                    } catch (MessagingException ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    });
                                                    fbut1.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent actionEvent) {
                                                            frame16.setVisible(false);
                                                            JFrame frame32 = new JFrame();
                                                            frame32.setVisible(true);
                                                            frame32.setSize(800,800);
                                                            frame32.setLayout(null);
                                                            frame32.getContentPane().setBackground(Color.orange);
                                                            JLabel confirmshop15 = new JLabel("Thanks for shopping !! ");
                                                            confirmshop15.setBounds(100,200,150,50);
                                                            frame32.add(confirmshop15);
                                                            JLabel showitems15 = new JLabel("Number of items: ");
                                                            showitems15.setBounds(100,300,100,50);
                                                            frame32.add(showitems15);
                                                            JTextField noitems15 = new JTextField();
                                                            noitems15.setBounds(250,300,50,30);
                                                            frame32.add(noitems15);
                                                            JButton forconfirmbut15 = new JButton("Submit");
                                                            forconfirmbut15.setBounds(200,400,100,40);
                                                            frame32.add(forconfirmbut15);
                                                            JButton exit30 = new JButton("Exit");
                                                            exit30.setBounds(900, 100, 100, 40);
                                                            frame32.add(exit30);
                                                            exit30.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {

                                                                    frame32.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                    frame32.setContentPane(exit);
                                                                    exit.addActionListener(e -> {
                                                                        frame32.dispose();
                                                                    });
                                                                    frame32.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                }
                                                            });

                                                            forconfirmbut15.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent actionEvent) {
                                                                    String insertitems15 = noitems15.getText();
                                                                    Double totalcost15 = Double.parseDouble(insertitems15)*300;
                                                                    JOptionPane.showMessageDialog(frame32,"Your total cost is : " + "Rs. " + totalcost15);
                                                                    try {
                                                                        sendMail(username1.getText());
                                                                    } catch (MessagingException ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    });
                                                }
                                            }
                                        });


                                    }
                                }

                            });

                                                    }
                    });
                }

            }


        });
    }
    public void signUpDatabase(){
        Connection conn;
        PreparedStatement pst;
        try
        {  Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","123");
            String sql="Insert into customer(first_name,last_name,email_id,password) values(?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1,fName1.getText());
            pst.setString(2,lName1.getText());
            pst.setString(3,email1.getText());
            pst.setString(4,String.valueOf(cPassword1.getPassword()));
            pst.execute();
            JOptionPane.showMessageDialog(null, "New Acount Created");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void signInDatabase(){
        Connection conn;
        ResultSet rs;
        PreparedStatement pst;

        String sql="select * from customer where email_id=? and password=?";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","123");
            pst=conn.prepareStatement(sql);
           // pst.setString(1,email1.getText());
           // pst.setString(2,cPassword1.getText());

            pst.setString(1,username1.getText());
            pst.setString(2,String.valueOf(password1.getPassword()));
            rs=pst.executeQuery();
            if(rs.next())
            {
                rs.close();
                pst.close();
                frame.setVisible(false);
                frame1 = new JFrame();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Incorrect Username and Password");
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }

    }

    public void sendMail(String recepient) throws MessagingException {
        System.out.println("Preparing to send email..");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "abc@gmail.com";
        String password = "*******";


        Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        //return super.getPasswordAuthentication();
                        return new javax.mail.PasswordAuthentication(myAccountEmail,password);
                    }
                });
                Message message = prepareMessage(session, myAccountEmail, recepient);
        Transport.send(message);
        System.out.println("Messsage send successfully..");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String receptient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receptient));
            message.setSubject("Hi Customer!!");
            message.setText("Welcome!! Thanks for shopping......");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


                public static void main(String[] args) throws Exception {
                    new Main();
                }


            }
