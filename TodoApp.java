package IntershipTasks.TodoApp;

import javax.swing.*;
import java.awt.*;

public class TodoApp {

    // Model to store tasks
    private DefaultListModel<String> listModel = new DefaultListModel<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TodoApp().createUI());
    }

    public void createUI() {
        // Create main window
        JFrame frame = new JFrame("To-Do App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create input components
        JLabel label = new JLabel("Enter Task:");
        JTextField taskField = new JTextField(15);
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

        // Create task list
        JList<String> taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Add button functionality
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a task!");
            }
        });

        // Delete button functionality
        deleteButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                listModel.remove(index);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a task to delete!");
            }
        });

        // Top panel for input and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.add(label);
        inputPanel.add(taskField);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        // Add components to frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Show window
        frame.setVisible(true);
    }
}
