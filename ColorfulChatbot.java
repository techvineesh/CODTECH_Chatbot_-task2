import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorfulChatbot extends JFrame implements ActionListener {
    private JTextField userInputField;
    private JTextArea chatArea;
    private int conversationCount;

    public ColorfulChatbot() {
        super("Colorful Chatbot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setBackground(Color.LIGHT_GRAY);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        // Input field
        JPanel inputPanel = new JPanel(new BorderLayout());
        userInputField = new JTextField();
        userInputField.setFont(new Font("Arial", Font.PLAIN, 16));
        userInputField.addActionListener(this);
        inputPanel.add(new JLabel("You: "), BorderLayout.WEST);
        inputPanel.add(userInputField, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Set initial conversation count
        conversationCount = 0;

        // Display chatbot icon and watermark
        JLabel chatbotIcon = new JLabel(new ImageIcon("chatbot_icon.png"));
        chatbotIcon.setHorizontalAlignment(JLabel.CENTER);
        chatbotIcon.setVerticalAlignment(JLabel.TOP);
        add(chatbotIcon, BorderLayout.NORTH);

        // Set window properties
        setSize(600, 500);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);

        // Initial greeting from chatbot
        sendMessage("Hello! I'm your User-friendly support. May I know your good name please?");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userInput = userInputField.getText().trim();

        if (!userInput.isEmpty()) {
            sendMessage("You: " + userInput);

            // Respond based on conversation count
            if (conversationCount == 0) {
                sendMessage("Chatbot: Hi " + userInput + "! How are you today?");
            } else if (conversationCount == 1) {
                sendMessage("Chatbot: That's good to hear, " + userInput + ". What's your favorite color?");
            } else if (conversationCount == 2) {
                sendMessage("Chatbot: Nice choice! Mine's all the colors of the rainbow. What's your favorite animal?");
            } else if (conversationCount == 3) {
                sendMessage("Chatbot: " + userInput + "s are fascinating creatures! What's your favorite hobby?");
            } else if (conversationCount == 4) {
                sendMessage("Chatbot: That sounds like a lot of fun, " + userInput + "! Do you have any other interests?");
            } else if (conversationCount == 5) {
                sendMessage("Chatbot: It was nice chatting with you, " + userInput + "! Feel free to chat with me anytime.");
                userInputField.setEditable(false); 
            }

            userInputField.setText("");
            conversationCount++;
        }
    }

    private void sendMessage(String message) {
        chatArea.append(message + "\n");
        chatArea.setCaretPosition(chatArea.getDocument().getLength()); // Scroll to bottom
    }

    public static void main(String[] args) {
        // Create and display the chatbot GUI
        SwingUtilities.invokeLater(ColorfulChatbot::new);
    }
}
