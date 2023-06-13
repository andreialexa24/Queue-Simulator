import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
    public class SimulationFrame extends JFrame {

        private JPanel contentPane;

        /**
         * Launch the application.
         */

          public static void main(String[] args)
          {
              SimulationFrame s=new SimulationFrame();
              s.setVisible(true);
          }

        /**
         * Create the frame.
         */
        public SimulationFrame() {
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(100, 100, 786, 539);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel lblNewLabel_1 = new JLabel("Numar de clienti");
            lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
            lblNewLabel_1.setBounds(10, 22, 216, 21);
            contentPane.add(lblNewLabel_1);

            JTextPane textPane = new JTextPane();
            textPane.setBounds(10, 48, 235, 35);
            contentPane.add(textPane);

            JTextPane textPane_1 = new JTextPane();
            textPane_1.setBounds(10, 115, 235, 35);
            contentPane.add(textPane_1);

            JTextPane textPane_2 = new JTextPane();
            textPane_2.setBounds(10, 188, 235, 35);
            contentPane.add(textPane_2);

            JTextPane textPane_3 = new JTextPane();
            textPane_3.setBounds(10, 252, 235, 35);
            contentPane.add(textPane_3);

            JTextPane textPane_4 = new JTextPane();
            textPane_4.setBounds(10, 316, 235, 35);
            contentPane.add(textPane_4);

            JTextPane textPane_5 = new JTextPane();
            textPane_5.setBounds(10, 388, 235, 35);
            contentPane.add(textPane_5);

            JTextPane textPane_6 = new JTextPane();
            textPane_6.setBounds(10, 457, 235, 35);
            contentPane.add(textPane_6);

            JLabel lblNewLabel_1_1 = new JLabel("Numar de servere");
            lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
            lblNewLabel_1_1.setBounds(10, 93, 216, 21);
            contentPane.add(lblNewLabel_1_1);

            JLabel lblNewLabel_1_2 = new JLabel("Timp maxim de servire");
            lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
            lblNewLabel_1_2.setBounds(10, 160, 216, 21);
            contentPane.add(lblNewLabel_1_2);

            JLabel lblNewLabel_1_3 = new JLabel("Timp minim de servire");
            lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
            lblNewLabel_1_3.setBounds(10, 223, 216, 21);
            contentPane.add(lblNewLabel_1_3);

            JLabel lblNewLabel_1_4 = new JLabel("Timp minim de procesare");
            lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
            lblNewLabel_1_4.setBounds(10, 295, 216, 21);
            contentPane.add(lblNewLabel_1_4);

            JLabel lblNewLabel_1_5 = new JLabel("Timp maxim de procesare");
            lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
            lblNewLabel_1_5.setBounds(10, 361, 216, 21);
            contentPane.add(lblNewLabel_1_5);

            JLabel lblNewLabel_1_6 = new JLabel("Timp maxim de simulare");
            lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
            lblNewLabel_1_6.setBounds(10, 433, 265, 21);
            contentPane.add(lblNewLabel_1_6);

            JButton btnNewButton = new JButton("START");
            btnNewButton.setForeground(Color.BLACK);
            btnNewButton.setBackground(Color.GREEN);
            btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            btnNewButton.setBounds(311, 22, 440, 51);
            contentPane.add(btnNewButton);

            JPanel panel = new JPanel();
            panel.setBackground(Color.LIGHT_GRAY);
            panel.setBounds(296, 115, 466, 377);
            contentPane.add(panel);
        }
    }
