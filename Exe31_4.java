package Week14;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Exe31_4 extends JFrame{
    private static final long serialVersionUID = 1L;
    private int ClientNumber = 0;
    private JTextArea jta = new JTextArea();
    private JButton jButton = new JButton("Stop");
    private int count;
    private RandomAccessFile raf;

    public static void main(String[] args) {
        new Exe31_4();
    }

    public Exe31_4() {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    raf.seek(0);
                    raf.writeInt(count);
                    System.exit(0);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        });

        setLayout(new BorderLayout());
        add(new JScrollPane(jta), BorderLayout.CENTER);
        add(jButton, BorderLayout.SOUTH);
        jta.append("Server started at count: " + count + "\n\n");

        setTitle("Exercise04s");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        try {
            raf = new RandomAccessFile("count.dat", "rw");

            if (raf.length() == 0)
                count = 0;
            else
                count = raf.readInt();

            @SuppressWarnings("resource")
            ServerSocket serverSocket = new ServerSocket(8000);
            while (true) {
                Socket socket = serverSocket.accept();
                jta.append("Starting thread " + ClientNumber + "\n");
                ClientNumber++;
                InetAddress inetAddress = socket.getInetAddress();
                jta.append("Client IP " + inetAddress.getHostAddress() + "\n\n");
                HandleAClient task = new HandleAClient(socket);
                new Thread(task).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    class HandleAClient implements Runnable {

        private Socket socket;

        public HandleAClient(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                count++;
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                outputToClient.writeInt(count);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
