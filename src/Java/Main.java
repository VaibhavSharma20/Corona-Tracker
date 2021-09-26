package Java;
import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;
        import javax.swing.border.Border;

import static Java.finalMail.sendFinalMail;

class Error
{
    Frame f;
    Error()
    {
        f=new Frame();
        f.setLayout(new GridLayout(2,1));
        f.setSize(1000,100);
        f.setVisible(true);
        f.setBackground(Color.GRAY);

        Label  sent;
        Button ok;

        sent= new Label("E-mail should be in form abc@xyz.com .");
        sent.setAlignment(Label.CENTER);

        ok = new Button("OK");
        ok.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                f.setVisible(false);
                new Options();
            }
        });

        f.add(sent);
        f.add(ok);

        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
    }
}
class Email
{
    Frame f;
    Email()
    {
        f=new Frame();
        f.setLayout(new GridLayout(2,1));
        f.setSize(1000,100);
        f.setVisible(true);
        f.setBackground(Color.GRAY);

        Label  sent;
        Button ok;

        sent= new Label("E-mail sent successfully.");
        sent.setAlignment(Label.CENTER);

        ok = new Button("OK");
        ok.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                f.setVisible(false);
                new Options();
            }
        });

        f.add(sent);
        f.add(ok);

        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
    }
}
class CoronaDetails
{
    Frame f;
    public static String emailAWT;
    public static String stateAWT;
    public static String type = "covidStateDetail";

    CoronaDetails()
    {
        f=new Frame();
        f.setLayout(new GridLayout(3,1));
        f.setSize(500,500);
        f.setVisible(true);
        f.setBackground(Color.GRAY);

        Panel p1 = new Panel();
        p1.setLayout(new GridLayout(3, 2));
        FlowLayout layout = new FlowLayout();
        Panel p2 = new Panel();
        p2.setLayout(layout);
        Label one, two, three,details;
        TextField tname, tstate, tmail;
        Button submit,back;

        one = new Label("NAME:");
        one.setAlignment(Label.CENTER);
        tname = new TextField(20);
        two = new Label("STATE:");
        two.setAlignment(Label.CENTER);
        tstate = new TextField(20);
        three = new Label("E-MAIL:");
        three.setAlignment(Label.CENTER);
        tmail = new TextField(20);
        details =new Label("DETAILS");
        details.setAlignment(Label.CENTER);
        details.setForeground(Color.RED);

        submit = new Button("Submit");
        submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String name=tname.getText();
                String state=tstate.getText();
                stateAWT = state;
                String mail=tmail.getText();
                emailAWT = mail;
                String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
                Boolean b = mail.matches(EMAIL_REGEX);
                if(b==true)
                {
                    f.setVisible(false);
                    sendFinalMail(type);
                    new Email();
                }
                else
                {
                    f.setVisible(false);
                    new Error();
                }
            }
        });


        back = new Button("Back");
        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                f.setVisible(false);
                new Options();
            }
        });

        p1.add(one);
        p1.add(tname);
        p1.add(two);
        p1.add(tstate);
        p1.add(three);
        p1.add(tmail);
        p2.add(submit);
        p2.add(back);
        f.add(details);
        f.add(p1);
        f.add(p2);

        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
    }
}
class Links
{
    Frame f;
    public static String mailAWT;
    public static String type = "Links";
    Links()
    {
        f=new Frame();
        f.setLayout(new GridLayout(3,1));
        f.setSize(500,500);
        f.setVisible(true);
        f.setBackground(Color.GRAY);

        Panel p1 = new Panel();
        p1.setLayout(new GridLayout(1, 2));
        FlowLayout layout = new FlowLayout();
        Panel p2 = new Panel();
        p2.setLayout(layout);
        Label  three,details;
        TextField tmail;
        Button submit,back;

        three = new Label("E-MAIL:");
        three.setAlignment(Label.CENTER);
        tmail = new TextField(20);
        details =new Label("DETAILS");
        details.setAlignment(Label.CENTER);
        details.setForeground(Color.RED);

        submit = new Button("Submit");
        submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String mail = tmail.getText();
                String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
                Boolean b = mail.matches(EMAIL_REGEX);
                if(b==true)
                {f.setVisible(false);
                    mailAWT = mail;
                    sendFinalMail(type);
                    new Email();
                }
                else
                {
                    f.setVisible(false);
                    new Error();
                }
            }
        });


        back = new Button("Back");
        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                f.setVisible(false);
                new Options();
            }
        });


        p1.add(three);
        p1.add(tmail);
        p2.add(submit);
        p2.add(back);
        f.add(details);
        f.add(p1);
        f.add(p2);

        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
    }
}
class Options
{
    Frame f;

    Options()
    {
        f=new Frame();
        f.setLayout(new GridLayout(3,1));
        f.setSize(500,500);
        f.setVisible(true);
        f.setBackground(Color.GRAY);

        Label head,madeby;
        head = new Label("CORONA TRACKER");
        head.setAlignment(Label.CENTER);
        head.setForeground(Color.RED);

        madeby = new Label("MADE BY : Adnan Habib,Vaibhav Sharma,Ishaan Sharma,Mayank Singh");
        madeby.setAlignment(Label.CENTER);
        madeby.setForeground(Color.BLUE);

        Panel p1 = new Panel();
        p1.setLayout(new FlowLayout());
        Button precautions,update;

        update = new Button("Get Covid Update");
        update.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new CoronaDetails();
                f.setVisible(false);
            }
        });


        precautions = new Button("Covid Important Utilities");
        precautions.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                new CovidUtilities();
                f.setVisible(false);
            }
        });

        p1.add(precautions);
        p1.add(update);
        f.add(head);
        f.add(p1);
        f.add(madeby);

        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });

    }


}
class CovidUtilities
{
    Frame f;

    CovidUtilities()
    {
        f=new Frame();

        f.setLayout(new GridLayout(3,1));
        f.setSize(500,500);
        f.setVisible(true);
        f.setBackground(Color.GRAY);

        Label head;
        head = new Label("IMPORTANT LINKS");
        head.setAlignment(Label.CENTER);
        head.setForeground(Color.RED);


        Panel p1 = new Panel();
        Panel p2 = new Panel();
        p1.setLayout(new FlowLayout());
        Button precautions,vaccine,download,back;

        precautions = new Button("Covid Precautions");
        precautions.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                f.setVisible(false);
                new Links();
            }
        });

        vaccine = new Button("Covid Vaccine Registration");
        vaccine.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                f.setVisible(false);
                new Links();
            }
        });


        download = new Button("Download Arogya Setu");
        download.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                f.setVisible(false);
                new Links();
            }
        });


        back = new Button("Back");
        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                f.setVisible(false);
                new Options();
            }
        });


        p1.add(precautions);
        p1.add(vaccine);
        p1.add(download);
        p2.add(back);
        f.add(head);
        f.add(p1);
        f.add(p2);

        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
    }
}
public class Main
{
    public static void main(String args[])
    {
        new Options();

    }
}

