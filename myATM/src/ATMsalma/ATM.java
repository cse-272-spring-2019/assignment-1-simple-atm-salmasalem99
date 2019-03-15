
package ATMsalma;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ATM extends ATM_logic{
      
    String stringfromTF;
    String mystring="1234";
    int s;

    ATM()
    {
        setup_mytransactions();
        setup_wdw();
        setup_mydeposit();
        setup_main_menu();
        setup_mybalanceinquiry();
        validatewindow();      
    }
   
    public final void validatewindow ()
    {
        cn = 0;
        JPanel validatePanel = new JPanel();
        JLabel welcomeLabel = new JLabel("              Welcome              ");
        JLabel plsenteryourCN = new JLabel("         Please enter your card number          "); 
        welcome = new JFrame("ATM");
        CN = new JTextField();
        CN.setColumns(20);
        validatePanel.add(welcomeLabel); 
        validatePanel.add(plsenteryourCN); 
        validatePanel.add(CN);
        welcome.setSize(300,200);
        welcome.add(validatePanel);
        welcome.setVisible(true);
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel IncorrectCN = new JLabel("Access denied re-enter your card number");
        validatePanel.add(IncorrectCN);
        IncorrectCN.setVisible(false);
        BoxLayout boxvpanellayout = new BoxLayout(validatePanel, BoxLayout.Y_AXIS);
        CN.addActionListener(new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                 SwingUtilities.invokeLater(() -> {
                     stringfromTF = CN.getText();
                     if(validate(stringfromTF)==1)
                     {
                         welcome.setVisible(false);
                         main_menu();
                     }
                     else
                     {
                         CN.setText("");
                         IncorrectCN.setVisible(true);
                     }
                 });
            }
        });      
    }
       
    public final void setup_main_menu()
    {
        menu.setSize(200, 250);
        menuPanel.add(welcomelabel);
        menuPanel.add(action);       
        menuPanel.add(deposit);
        menuPanel.add(withdraw);
        menuPanel.add(balanceIN);
        menuPanel.add(previous);
        menu.add(menuPanel);
        deposit.addActionListener((ActionEvent e) -> {
            mydeposit();
            menu.setVisible(false);
        });
        
        withdraw.addActionListener((ActionEvent e) -> {
            
            mywithdrawal();
            menu.setVisible(false);
        });
        
        balanceIN.addActionListener((ActionEvent e) -> {
            balanceinquiry();
            menu.setVisible(false);
        });
        
        previous.addActionListener((ActionEvent e) -> {
            Next.setEnabled(true);
            Previoustr.setEnabled(true);
            countmytrs=b4.size()-1;
            if(flag==true)
            {
                showafter.setText(""+aft.get(countmytrs));
                showbefore.setText(""+b4.get(countmytrs));
                printtot.setText(""+tot.get(countmytrs));
            }
            mytransactions();
            menu.setVisible(false);
        });
    }

    
    public void main_menu()
    {  
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
   
    public final void setup_mydeposit()
    {
        amntdep.setColumns(25);
        depPanel.add(Edepamount);
        depPanel.add(amntdep);
        depPanel.add(zerodep);
        depPanel.add(onedep);
        depPanel.add(twodep);
        depPanel.add(threedep);
        depPanel.add(fourdep);
        depPanel.add(fivedep);
        depPanel.add(sixdep);
        depPanel.add(sevendep);
        depPanel.add(eightdep);
        depPanel.add(ninedep) ;
        depPanel.add(correct_amount);
        depPanel.add(backfromdep);
        depPanel.add(successful_transaction2);
        depPanel.add(unsuccessful_transaction2);
        successful_transaction2.setVisible(false);
        unsuccessful_transaction2.setVisible(false);
        dep.setSize(300,300);
        dep.add(depPanel,BorderLayout.CENTER);
        dep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        onedep.addActionListener((ActionEvent e) -> {
            amntdep.append(1+"");
        });
        
        twodep.addActionListener((ActionEvent e) -> {
            amntdep.append(2+"");
        });
        
        threedep.addActionListener((ActionEvent e) -> {
            amntdep.append(3+"");
        });
        
        fourdep.addActionListener((ActionEvent e) -> {
            amntdep.append(4+"");
        });
        
        fivedep.addActionListener((ActionEvent e) -> {
            amntdep.append(5+"");
        });
        
        sixdep.addActionListener((ActionEvent e) -> {
            amntdep.append(6+"");
        });
        
        sevendep.addActionListener((ActionEvent e) -> {
            amntdep.append(7+"");
        });
        
        eightdep.addActionListener((ActionEvent e) -> {
            amntdep.append(8+"");
        });
        
        ninedep.addActionListener((ActionEvent e) -> {
            amntdep.append(9+"");
        });
        
        zerodep.addActionListener((ActionEvent e) -> {
            amntdep.append(0+"");
        });
        
        correct_amount.addActionListener((ActionEvent e) -> {
            amntdep.append(".0");
            deposited = amntdep.getText();
            depamount = Double.parseDouble(deposited);
            balancebefore = balance;
            if(deposit(depamount)==true)
            {
                balanceafter = balance;
                successful_transaction2.setVisible(true);
                amntdep.setText("");
                depamount=0.0;
                documentation(balancebefore,balanceafter);
                successful_transaction2.setVisible(true);
                unsuccessful_transaction2.setVisible(false);
            }
            else
            {
                amntdep.setText("");
                successful_transaction2.setVisible(false);
                unsuccessful_transaction2.setVisible(true);
            }
        });
       
        backfromdep.addActionListener((ActionEvent e) -> {
            main_menu();
            dep.setVisible(false);
            amntdep.setText("");
            depamount=0.0;
        });
        amntdep.setEditable(false); 
    }
    
    public void mydeposit()
    {
        deposited="";
        depamount = 0.0;
        dep.setVisible(true);
        successful_transaction2.setVisible(false);
    }

    public final void setup_wdw()
    {
        amntwdw.setColumns(25);
        wdwPanel.add( Eamount);
        amntwdw.setEditable(false);
        wdwPanel.add(amntwdw);
        wdwPanel.add(zerowdw);
        wdwPanel.add(onewdw);
        wdwPanel.add(twowdw);
        wdwPanel.add(threewdw);
        wdwPanel.add(fourwdw);
        wdwPanel.add(fivewdw);
        wdwPanel.add(sixwdw);
        wdwPanel.add(sevenwdw);
        wdwPanel.add(eightwdw);
        wdwPanel.add(ninewdw) ;        
        JButton correct_amount1 = new JButton("amount is correct");
        wdwPanel.add(correct_amount1);
        wdwPanel.add(backfromwdw);
        wdwPanel.add(successful_transaction);
        wdwPanel.add(unsuccessful_transaction);
        wdw.setSize(300,300);
        wdw.add(wdwPanel,BorderLayout.CENTER);
        wdw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        successful_transaction.setVisible(false);
        unsuccessful_transaction.setVisible(false);
        
        onewdw.addActionListener((ActionEvent e) -> {
            amntwdw.append(1+"");
        });
        
        twowdw.addActionListener((ActionEvent e) -> {
            amntwdw.append(2+"");
        });
        
        threewdw.addActionListener((ActionEvent e) -> {
            amntwdw.append(3+"");
        });
        
        fourwdw.addActionListener((ActionEvent e) -> {
            amntwdw.append(4+"");
        });
        
        fivewdw.addActionListener((ActionEvent e) -> {
            amntwdw.append(5+"");
        });
        
        sixwdw.addActionListener((ActionEvent e) -> {
            amntwdw.append(6+"");
        });
        
        sevenwdw.addActionListener((ActionEvent e) -> {
            amntwdw.append(7+"");
        });
        
        eightwdw.addActionListener((ActionEvent e) -> {
            amntwdw.append(8+"");
        });
        
        ninewdw.addActionListener((ActionEvent e) -> {
            amntwdw.append(9+"");
        });
        
        zerowdw.addActionListener((ActionEvent e) -> {
            amntwdw.append(0+"");
        });
        
        correct_amount1.addActionListener((ActionEvent e) -> {
            amntwdw.append(".0");
            withdrawed = amntwdw.getText();
            wdwamount = Double.parseDouble(withdrawed);
            balancebefore = balance;
            if(withdrawal(wdwamount)==1)
            {
                balanceafter = balance;
                amntwdw.setText("");
                successful_transaction.setVisible(true);
                unsuccessful_transaction.setVisible(false);
                documentation(balancebefore,balanceafter);
            }
            else if(withdrawal(wdwamount)==0)
            {
                amntwdw.setText("");
                successful_transaction.setVisible(false);
                unsuccessful_transaction.setVisible(true);
            }
        });
  
         backfromwdw.addActionListener((ActionEvent e) -> {
             amntwdw.setText("");
             main_menu();
             wdw.setVisible(false);
        });
        amntwdw.setEditable(false);
    }
    
    public void mywithdrawal() 
    {
        amntwdw.setText("");
        withdrawed="";
        wdwamount = 0.0;
        wdw.setVisible(true);
        successful_transaction.setVisible(false);
        unsuccessful_transaction.setVisible(false);
    }
      
    public final void setup_mybalanceinquiry()
    {
        JButton backfromBI = new JButton("Back to main menu");
        JPanel BIpanel = new JPanel();        
        JLabel YCBalance = new JLabel("Your current balance:");
        BIpanel.add(YCBalance);
        CurrentBalance.setColumns(15);
        BIpanel.add(CurrentBalance);
        BIpanel.add(backfromBI);
        BI.add(BIpanel,BorderLayout.CENTER);
        BI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CurrentBalance.setEditable(false);
        BI.setSize(200,200);
        CurrentBalance.setVisible(true);
        backfromBI.addActionListener((ActionEvent e) -> {
             CurrentBalance.setText("");
             
             BI.setVisible(false);
             main_menu();
        }); 
    }

    public void mytransactions()
    {
        countmytrs=b4.size()-1;
        
        if(flag==true)
        {
            backfromnoprv.setVisible(false);
            nprv.setVisible(false);
            beforeLabel.setVisible(true);
            afterLabel.setVisible(true);
            showbefore.setVisible(true);
            backfromtr.setVisible(true);
            showafter.setVisible(true);
            Previoustr.setVisible(true);
            Next.setVisible(true);  
            printtot.setVisible(true);
        }
        else
        {
            backfromnoprv.setVisible(true); 
            nprv.setVisible(true);
            beforeLabel.setVisible(false);
            afterLabel.setVisible(false);
            showbefore.setVisible(false);
            backfromtr.setVisible(false);
            showafter.setVisible(false);
            Previoustr.setVisible(false);
            Next.setVisible(false);
            printtot.setVisible(false);
        }
        trwindow.setVisible(true);
    }
    
    public final void setup_mytransactions()
    {
        trwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        trwindow.setSize(300,300);
        trpanel.add(beforeLabel);
        trpanel.add(showbefore);
        showbefore.setColumns(20);
        showbefore.setText("");
        showbefore.setEditable(false);
        trpanel.add(afterLabel);
        trpanel.add(showafter);
        trpanel.add(printtot);
        trpanel.add(Previoustr);
        trpanel.add(Next);
        trpanel.add(backfromtr);
        showafter.setColumns(20);
        showafter.setText("");
        showafter.setEditable(false);
        trpanel.add(nprv);
        trpanel.add(backfromnoprv); 
        trwindow.add(trpanel);  

        backfromnoprv.addActionListener((ActionEvent e) -> {
               trwindow.setVisible(false);
               menu.setVisible(true);
           });
        
        Previoustr.addActionListener((ActionEvent e) -> {
            --countmytrs;
            Previoustr.setEnabled(true);
            if(countmytrs>=0 && countmytrs<=(b4.size()-1))
            {
                Next.setEnabled(true);
                showbefore.setText(null);
                showafter.setText(null);
                printtot.setText(null);
                mytrs();
            }
            else
            {
                Previoustr.setEnabled(false);
                countmytrs=0;
            }
        });
        Next.addActionListener((ActionEvent e) -> {
            ++countmytrs;
            Next.setEnabled(true);
            if(countmytrs>=0 && countmytrs<=(b4.size()-1))
            {   Previoustr.setEnabled(true);
                showbefore.setText(null);
                showafter.setText(null);
                printtot.setText(null);
                mytrs();
            }
            else
            {
                Next.setEnabled(false);
                countmytrs=b4.size()-1;
            }
        });
        
        backfromtr.addActionListener((ActionEvent e) -> {
            main_menu();
            trwindow.setVisible(false);
            showbefore.setText(null);
            showafter.setText(null);
            printtot.setText(null);
        });   
    }
           
    public static void main(String[] args)
    {
        ATM atm = new ATM();
    }     
}
