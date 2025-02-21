import javax.swing.*;
import java.awt.*;

public class ChatInterface {
    private JFrame frame;
    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;
    private String username;

    public ChatInterface(String username){
        this.username = username;
        initializeUI();
    }

    private void  initializeUI() {
        frame = new JFrame("Chat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setBackground(Color.BLACK);
        chatArea.setForeground(Color.WHITE);

        messageField = new JTextField();
        sendButton = new JButton("Enviar");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(messageField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        frame.add(new JScrollPane(chatArea), BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        frame.setVisible(true);
        showLoadingMessage();
    }

        private void showLoadingMessage() {
            chatArea.setForeground(Color.RED);
            chatArea.append("Carregando...\n");

            // Simulando tempo de conexão
            new Timer(2000, e -> showConnectedMessage()).start();
        }

        private void showConnectedMessage(){
            chatArea.setForeground(Color.GREEN);
            chatArea.setText("Conexão estabelecida\n");
        }
        public static void main(String[] args){
        SwingUtilities.invokeLater(()->new ChatInterface("Usuarios"));
        }







}
