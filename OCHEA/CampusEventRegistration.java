import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CampusEventRegistration extends JFrame {

    
    private JTextField nameField;
    private JTextField ageField;
    private JTextField collegeField;

    private JComboBox<String> eventComboBox;

    private JRadioButton participantRadio;
    private JRadioButton audienceRadio;
    private JRadioButton facultyRadio;
    private ButtonGroup attendanceGroup;

    private JCheckBox javaCheckBox;
    private JCheckBox webCheckBox;
    private JCheckBox cyberCheckBox;
    private JCheckBox aiCheckBox;
    private JCheckBox databaseCheckBox;

    private JTextArea notesArea;

    private JButton registerButton;
    private JButton clearButton;


    public CampusEventRegistration() {
        setTitle("Campus Technology Week - Event Registration");
        setSize(650, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createGUI();
    }

    private void createGUI() {


        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

    
        JLabel titleLabel = new JLabel(
                "CAMPUS TECHNOLOGY WEEK - EVENT REGISTRATION",
                SwingConstants.CENTER
        );
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;


        JLabel nameLabel = new JLabel("Participant Name:");
        nameField = new JTextField(25);

        addComponent(formPanel, nameLabel, 0, 0, 1, 1, gbc);
        addComponent(formPanel, nameField, 1, 0, 2, 1, gbc);

    
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField(25);

        addComponent(formPanel, ageLabel, 0, 1, 1, 1, gbc);
        addComponent(formPanel, ageField, 1, 1, 2, 1, gbc);

    
        JLabel collegeLabel = new JLabel("College/Department:");
        collegeField = new JTextField(25);

        addComponent(formPanel, collegeLabel, 0, 2, 1, 1, gbc);
        addComponent(formPanel, collegeField, 1, 2, 2, 1, gbc);
        

        JLabel eventLabel = new JLabel("Event Category:");

        String[] events = {
                "Select Event",
                "Programming Competition",
                "Web Design Challenge",
                "Cybersecurity Seminar",
                "AI and Emerging Technologies",
                "IT Quiz Bowl"
        };

        eventComboBox = new JComboBox<>(events);

        addComponent(formPanel, eventLabel, 0, 3, 1, 1, gbc);
        addComponent(formPanel, eventComboBox, 1, 3, 2, 1, gbc);

        
        JLabel attendanceLabel = new JLabel("Attendance Type:");

        participantRadio = new JRadioButton("Student Participant");
        audienceRadio = new JRadioButton("Student Audience");
        facultyRadio = new JRadioButton("Faculty/Staff");

        attendanceGroup = new ButtonGroup();
        attendanceGroup.add(participantRadio);
        attendanceGroup.add(audienceRadio);
        attendanceGroup.add(facultyRadio);

        JPanel attendancePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        attendancePanel.add(participantRadio);
        attendancePanel.add(audienceRadio);
        attendancePanel.add(facultyRadio);

        addComponent(formPanel, attendanceLabel, 0, 4, 1, 1, gbc);
        addComponent(formPanel, attendancePanel, 1, 4, 2, 1, gbc);


        JLabel workshopLabel = new JLabel("Workshops to Attend:");

        javaCheckBox = new JCheckBox("Java Programming");
        webCheckBox = new JCheckBox("Web Development");
        cyberCheckBox = new JCheckBox("Cybersecurity");
        aiCheckBox = new JCheckBox("Artificial Intelligence");
        databaseCheckBox = new JCheckBox("Database Management");

        JPanel workshopPanel = new JPanel();
        workshopPanel.setLayout(new BoxLayout(workshopPanel, BoxLayout.Y_AXIS));

        workshopPanel.add(javaCheckBox);
        workshopPanel.add(webCheckBox);
        workshopPanel.add(cyberCheckBox);
        workshopPanel.add(aiCheckBox);
        workshopPanel.add(databaseCheckBox);

        addComponent(formPanel, workshopLabel, 0, 5, 1, 1, gbc);
        addComponent(formPanel, workshopPanel, 1, 5, 2, 1, gbc);


        JLabel notesLabel = new JLabel("Special Request/Notes:");

        notesArea = new JTextArea(5, 25);
        notesArea.setLineWrap(true);
        notesArea.setWrapStyleWord(true);

        JScrollPane notesScrollPane = new JScrollPane(notesArea);

        gbc.fill = GridBagConstraints.BOTH;
        addComponent(formPanel, notesLabel, 0, 6, 1, 1, gbc);
        addComponent(formPanel, notesScrollPane, 1, 6, 2, 1, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);

    
        registerButton = new JButton("REGISTER");
        clearButton = new JButton("CLEAR");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        buttonPanel.add(registerButton);
        buttonPanel.add(clearButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        
        registerButton.addActionListener(e -> registerParticipant());
        clearButton.addActionListener(e -> clearForm());

        add(mainPanel);
    }


    private void addComponent(
            JPanel panel,
            Component component,
            int gridx,
            int gridy,
            int gridwidth,
            int gridheight,
            GridBagConstraints gbc) {

        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;

        panel.add(component, gbc);
    }

    private void registerParticipant() {

    
        String name = nameField.getText().trim();
        String ageText = ageField.getText().trim();
        String college = collegeField.getText().trim();

        
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Participant Name is required.",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            nameField.requestFocus();
            return;
        }
        if (ageText.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Age is required.",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            ageField.requestFocus();
            return;
        }

        int age;

        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Age must be a valid whole number.",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            ageField.requestFocus();
            return;
        }

        if (age <= 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Age must be greater than zero.",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            ageField.requestFocus();
            return;
        }

        // Validate College/Department
        if (college.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "College/Department is required.",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            collegeField.requestFocus();
            return;
        }

        if (eventComboBox.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please select an Event Category.",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            eventComboBox.requestFocus();
            return;
        }

        if (!participantRadio.isSelected()
                && !audienceRadio.isSelected()
                && !facultyRadio.isSelected()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select an Attendance Type.",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        
        String eventCategory =
                eventComboBox.getSelectedItem().toString();

        // Get attendance type
        String attendanceType;

        if (participantRadio.isSelected()) {
            attendanceType = "Student Participant";
        } else if (audienceRadio.isSelected()) {
            attendanceType = "Student Audience";
        } else {
            attendanceType = "Faculty/Staff";
        }

        
        StringBuilder workshops = new StringBuilder();

        if (javaCheckBox.isSelected()) {
            workshops.append("• Java Programming\n");
        }

        if (webCheckBox.isSelected()) {
            workshops.append("• Web Development\n");
        }

        if (cyberCheckBox.isSelected()) {
            workshops.append("• Cybersecurity\n");
        }

        if (aiCheckBox.isSelected()) {
            workshops.append("• Artificial Intelligence\n");
        }

        if (databaseCheckBox.isSelected()) {
            workshops.append("• Database Management\n");
        }

        if (workshops.length() == 0) {
            workshops.append("None");
        }

        // Get notes
        String notes = notesArea.getText().trim();

        if (notes.isEmpty()) {
            notes = "None";
        }

        
        String summary =
                "CAMPUS TECHNOLOGY WEEK\n"
                + "REGISTRATION SUMMARY\n"
                + "====================================\n\n"
                + "Participant Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "College/Department: " + college + "\n"
                + "Event Category: " + eventCategory + "\n"
                + "Attendance Type: " + attendanceType + "\n\n"
                + "Workshops to Attend:\n"
                + workshops
                + "\nSpecial Request/Notes:\n"
                + notes
                + "\n\n====================================\n"
                + "Registration Successful!";

    
        JTextArea summaryArea = new JTextArea(summary);
        summaryArea.setEditable(false);
        summaryArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        summaryArea.setLineWrap(true);
        summaryArea.setWrapStyleWord(true);

        JScrollPane summaryScrollPane = new JScrollPane(summaryArea);
        summaryScrollPane.setPreferredSize(new Dimension(500, 400));

        JOptionPane.showMessageDialog(
                this,
                summaryScrollPane,
                "Registration Summary",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void clearForm() {

        nameField.setText("");
        ageField.setText("");
        collegeField.setText("");

        eventComboBox.setSelectedIndex(0);

        attendanceGroup.clearSelection();

        javaCheckBox.setSelected(false);
        webCheckBox.setSelected(false);
        cyberCheckBox.setSelected(false);
        aiCheckBox.setSelected(false);
        databaseCheckBox.setSelected(false);

        notesArea.setText("");

        nameField.requestFocus();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            CampusEventRegistration app =
                    new CampusEventRegistration();

            app.setVisible(true);
        });
    }
}