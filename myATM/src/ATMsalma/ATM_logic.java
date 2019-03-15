
package ATMsalma;

import java.util.LinkedList;
import javax.swing.*;


public class ATM_logic implements ATM_interface  { 
    
    double balance = 0.0;
    String compstring = "1234";
    double balanceafter=0.0;
    double balancebefore=0.0;
    JLabel printtot = new JLabel("");
    @Override
    public void balanceinquiry() {
            balancebefore = balance;
            balanceafter = balance;
            documentation(balancebefore,balanceafter);
            CurrentBalance.setText(""+balance);
            BI.setVisible(true);
    }

    @Override
    public int validate(String x) {
         return(compstring.equals(x) ? 1 : 0);        
    }

    LinkedList b4= new LinkedList();
    LinkedList aft = new LinkedList();
    LinkedList tot = new LinkedList();
    boolean flag;
    
    
    @Override
    public void documentation(double b_b4,double b_aft)
    {
        b4.add(b_b4);
        aft.add(b_aft);
        if(b4.size()==1)
            flag = true;
        if(b4.size()==6)
        {
            b4.removeFirst();
            aft.removeFirst();
        }
    }
    public void addtotot(double bef, double aft)
    {
        if(bef<aft)
            tot.add("      Type of transaction: Deposit                           ");
        else if (bef > aft)
            tot.add("Type of transaction: Withdrawal            ");
        else if (bef == aft)
            tot.add("                      Type of transaction: Balance Inquiry                         ");
            
    }
     
    
    

    
    
    @Override
     public boolean deposit(double y) {
         
         balance = balance + y;
         return(y!=0);
    }


    @Override
    public int withdrawal(double z) {
       
        if(z<=balance && z>0)
        {
            balance=balance-z;
            return 1;
        }
            
        
        else if(z>balance || z==0)
            return 0;
        
        return 0;
        
        
    }

    
    JFrame menu = new JFrame("Menu");
    JLabel welcomelabel = new JLabel("     Welcome     ");  
    JLabel action = new JLabel("please choose an action");
    JButton deposit = new JButton("Deposit");
    JButton withdraw = new JButton("Withdrawal");
    JButton balanceIN = new JButton("Balance Inquiry");
    JPanel menuPanel = new JPanel();
    BoxLayout boxlayout = new BoxLayout(menuPanel, BoxLayout.Y_AXIS);
    
    
    int countmytrs = 0;

    
    
    JFrame dep = new JFrame("Deposit");
    JPanel depPanel = new JPanel();
    String deposited;
    JTextArea amntdep= new JTextArea(""); 
    JButton backfromdep = new JButton("Back to main menu");
    JButton onedep = new JButton("1");
    JButton twodep = new JButton("2");
    JButton threedep = new JButton("3");
    JButton fourdep = new JButton("4");
    JButton fivedep = new JButton("5");
    JButton sixdep = new JButton("6");
    JButton sevendep = new JButton("7");
    JButton eightdep = new JButton("8");
    JButton ninedep = new JButton("9");
    JButton zerodep = new JButton("0");
    JLabel Edepamount = new JLabel("enter amount to be deposited");

    
    
    
    
        JPanel wdwPanel = new JPanel();
        String withdrawed;
        JFrame wdw = new JFrame();
        JTextArea amntwdw = new JTextArea("");
        JButton backfromwdw = new JButton("Back to main menu");
        JButton onewdw = new JButton("1");
        JButton twowdw = new JButton("2");
        JButton threewdw = new JButton("3");
        JButton fourwdw = new JButton("4");
        JButton fivewdw = new JButton("5");
        JButton sixwdw = new JButton("6");
        JButton sevenwdw = new JButton("7");
        JButton eightwdw = new JButton("8");
        JButton ninewdw = new JButton("9");
        JButton zerowdw = new JButton("0");
        JLabel Eamount = new JLabel("Enter amount to be withdrawed");
    
    
    
    
      
    
    JButton next = new JButton("Next Transaction");
    JButton previous = new JButton("Previous Transaction");
    JButton correct_amount = new JButton("Amount is Correct");    
    JLabel successful_transaction = new JLabel("Successful Transaction!");
    JLabel successful_transaction2 = new JLabel("Successful Transaction!");
    JLabel unsuccessful_transaction = new JLabel("Unsuccessful Transaction!");
    JFrame BI = new JFrame("Balance Inquiry"); 
    JTextArea CurrentBalance= new JTextArea("");
    JLabel unsuccessful_transaction2 = new JLabel("Unsuccessful transaction");
     
    
    double wdwamount;
    double depamount;
    public void mytrs()
    {
        showbefore.setText("" + b4.get(countmytrs));
        showafter.setText("" + aft.get(countmytrs));
        printtot.setText(""+tot.get(countmytrs));
    }        
     
    int cn=0;
    JLabel ICCN = new JLabel("Incorrect card number");
    JTextField CN;
    JFrame welcome; 



    JFrame trwindow =  new JFrame("Previous Transactions");
    JPanel trpanel = new JPanel();
    JLabel beforeLabel = new JLabel("Balance before:");
    JTextField showbefore = new JTextField("");
    JLabel afterLabel = new JLabel("Balance after:");
    JTextField showafter = new JTextField("");
    JButton Previoustr = new JButton("Previous");
    JButton backfromtr = new JButton("Back to main menu");
    JButton Next = new JButton("Next");   
    JLabel nprv = new JLabel("No previous transactions");
    JButton backfromnoprv = new JButton("Back to main menu");




    
}
