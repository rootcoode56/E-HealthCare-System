import javax.swing.*;
import java.awt.*;
import java.util.List;

class HealthCareManagementSystemGUI extends JFrame{
    private PatientManager patientManager = new FileManagementSystem();
    private JTextField nameField;
    private JTextField idField;
    private JTextField ageField;
    private JTextField problemField;
    private JTextField recommendedDoctorField;
    private JTextField dischargeDateField;
    private final JTextArea patientListArea;

    public HealthCareManagementSystemGUI(){
        setTitle("Fluffy Healthcare Management System");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Login Panel
        JPanel loginPanel = new JPanel(new FlowLayout());
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        JLabel usernameLabel= new JLabel("Username:");
        JTextField usernameField = new JTextField(10);
        JLabel passwordLabel = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField(10);
        JButton loginButton = new JButton("Login");
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        add(loginPanel, BorderLayout.CENTER);


        //Home Panel
        JPanel homePanel = new JPanel(new BorderLayout());
        homePanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        JLabel welcomeLabel = new JLabel("Welcome to Fluffy Healthcare Management System!");
        JButton patientButton = new JButton("Patient");
        JButton doctorButton = new JButton("Doctor");
        JButton healthcareInfoButton = new JButton("Healthcare Information Button");
        JButton logoutButton = new JButton("Log Out");
        homePanel.add(welcomeLabel, BorderLayout.NORTH);
        homePanel.add(patientButton, BorderLayout.WEST);
        homePanel.add(doctorButton, BorderLayout.CENTER);
        homePanel.add(healthcareInfoButton, BorderLayout.SOUTH);
        homePanel.add(logoutButton, BorderLayout.EAST);

        //Patient Panel
        JPanel patientPanel = new JPanel(new BorderLayout());
        patientPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        JButton addPatientButton = new JButton("Add Patient");
        JLabel addpatientLable = new JLabel("                                          Welcome to Patient Panel");
        JButton showPatientsButton = new JButton("Show all Patients");
        JButton BackButton1 = new JButton("Back");
        patientPanel.add(showPatientsButton, BorderLayout.EAST);
        patientPanel.add(addPatientButton, BorderLayout.WEST);
        patientPanel.add(addpatientLable, BorderLayout.NORTH);
        patientPanel.add(BackButton1, BorderLayout.SOUTH);

        // Add Patient Panel
        JPanel addPatientPanel = new JPanel(new GridLayout(5, 2));
        addPatientPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(10);
        JLabel idLabel = new JLabel("ID(4 digits):");
        idField = new JTextField(10);
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField(10);
        JLabel problemLabel = new JLabel("Problem:");
        problemField  = new JTextField(10);
        JLabel recommendedDoctorLabel= new JLabel("Recommended Doctor:");
        recommendedDoctorField  = new JTextField(10);
        JLabel dischargeDateLabel = new JLabel("Discharge Date:");
        dischargeDateField = new JTextField(10);
        JButton savePatientButton = new JButton("Save Patient");
        JButton backButton2 = new JButton("Back to Home");
        addPatientPanel.add(nameLabel);
        addPatientPanel.add(nameField);
        addPatientPanel.add(idLabel);
        addPatientPanel.add(idField);
        addPatientPanel.add(ageLabel);
        addPatientPanel.add(ageField);
        addPatientPanel.add(problemLabel);
        addPatientPanel.add(problemField);
        addPatientPanel.add(recommendedDoctorLabel);
        addPatientPanel.add(recommendedDoctorField);
        addPatientPanel.add(dischargeDateLabel);
        addPatientPanel.add(dischargeDateField);
        addPatientPanel.add(savePatientButton);
        addPatientPanel.add(backButton2);

        // Show Patients Panel
        JPanel showPatientsPanel = new JPanel(new BorderLayout());
        showPatientsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JTextField searchField = new JTextField(10);
        patientListArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(patientListArea);
        JButton searchByIdButton = new JButton("Search by ID");
        JButton deletePatientButton = new JButton("Delete Patient");
        JButton backButton3 = new JButton("Back");
        showPatientsPanel.add(searchField, BorderLayout.NORTH);
        showPatientsPanel.add(searchByIdButton, BorderLayout.NORTH);
        showPatientsPanel.add(scrollPane, BorderLayout.CENTER);
        showPatientsPanel.add(deletePatientButton, BorderLayout.EAST);
        showPatientsPanel.add(backButton3, BorderLayout.SOUTH);


        // Show Doctors Panel
        JPanel showDoctorsPanel = new JPanel(new BorderLayout());
        showDoctorsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JTextArea doctorListArea = new JTextArea();
        JScrollPane doctorScrollPane = new JScrollPane(doctorListArea);
        JButton backButton5 = new JButton("Back");
        showDoctorsPanel.add(doctorScrollPane, BorderLayout.CENTER);
        showDoctorsPanel.add(backButton5, BorderLayout.SOUTH);

        // Switch to Show Doctors Panel
        doctorButton.addActionListener(e -> {
            List<Doctor> doctors = new FileManagementSystemFORDoctor().getDoctorsFromFile();
            StringBuilder sb = new StringBuilder();
            for (Doctor doctor : doctors) {
                sb.append("Name: ").append(doctor.name()).append(", ID: ").append(doctor.id())
                        .append(", Age: ").append(doctor.age()).append(", Specialty: ").append(doctor.specialist()).append("\n");
            }
            doctorListArea.setText(sb.toString());

            getContentPane().removeAll();
            getContentPane().add(showDoctorsPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });


        // Back to Home Button (from Show Doctors Panel)
        backButton5.addActionListener(e -> {
            getContentPane().removeAll();
            getContentPane().add(homePanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });

        // Search By ID panel
        JPanel searchByIdPanel = new JPanel(new BorderLayout());
        searchByIdPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        JLabel searchIDLabel = new JLabel("Search by ID:");
        JTextField searchIdField = new JTextField(10);
        JButton searchIdButton = new JButton("Search");
        JTextArea searchResultsArea = new JTextArea(5, 15);
        JButton exitButton4 = new JButton("Exit");
        searchByIdPanel.add(exitButton4, BorderLayout.SOUTH);
        searchByIdPanel.add(searchIDLabel, BorderLayout.NORTH);
        searchByIdPanel.add(searchIdField, BorderLayout.CENTER);
        searchByIdPanel.add(searchIdButton, BorderLayout.EAST);
        searchByIdPanel.add(new JScrollPane(searchResultsArea), BorderLayout.CENTER);





        // Healthcare Center Information Panel
        JPanel infoPanel = new JPanel(new GridLayout(5, 2));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel nameLabel2 = new JLabel("Name:");
        JLabel nameValueLabel = new JLabel("Fluffy General Care");
        JLabel addressLabel = new JLabel("Address:");
        JLabel addressValueLabel = new JLabel("House: 12, Street number: 123, road: 1, Dhaka-1200");
        JLabel phoneLabel = new JLabel("Phone Number:");
        JLabel phoneValueLabel = new JLabel("01712766621");
        JLabel emailLabel = new JLabel("Email:");
        JLabel emailValueLabel = new JLabel("fluffy@generalcare.com");
        JButton backButton6 = new JButton("Back to Home");
        infoPanel.add(nameLabel2);
        infoPanel.add(nameValueLabel);
        infoPanel.add(addressLabel);
        infoPanel.add(addressValueLabel);
        infoPanel.add(phoneLabel);
        infoPanel.add(phoneValueLabel);
        infoPanel.add(emailLabel);
        infoPanel.add(emailValueLabel);
        infoPanel.add(backButton6);

        // Switch to Home Panel
        loginButton.addActionListener(e -> {
            if (usernameField.getText().equals("asif") && new String(passwordField.getPassword()).equals("12345678")) {
                getContentPane().removeAll();
                getContentPane().add(homePanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // Switch to Patient Panel
        patientButton.addActionListener(e -> {
            getContentPane().removeAll();
            getContentPane().add(patientPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });

        // Switch to Add Patient Panel
        addPatientButton.addActionListener(e -> {
            getContentPane().removeAll();
            getContentPane().add(addPatientPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });


        // Search Button in the Search by ID panel
        searchIdButton.addActionListener(e -> {
            try {
                String input = searchIdField.getText().trim(); // Trim leading and trailing spaces
                if (!input.isEmpty()) {
                    // Search for the patient with the specified name
                    String searchName = input;
                    Patient foundPatient = null;

                    for (Patient patient : patientManager.getAllPatients()) {
                        if (patient.name().equalsIgnoreCase(searchName)) {
                            foundPatient = patient;
                            break;
                        }
                    }

                    if (foundPatient != null) {
                        // Display the patient information in the search results area
                        String patientInfo = "Name: " + foundPatient.name() + "\n" +
                                "ID: " + foundPatient.id() + "\n" +
                                "Age: " + foundPatient.age() + "\n" +
                                "Problem: " + foundPatient.problem() + "\n" +
                                "Recommended Doctor: " + foundPatient.recommendedDoctor() + "\n" +
                                "Discharge Date: " + foundPatient.dischargeDate();
                        searchResultsArea.setText(patientInfo);
                    } else {
                        searchResultsArea.setText("Patient not found with name: " + searchName);
                    }
                } else {
                    searchResultsArea.setText("Please enter a patient name to search.");
                }
            } catch (NumberFormatException ex) {
                searchResultsArea.setText("Invalid input. Please enter a valid patient name.");
            }
        });






        // Switch to search by id panel
        searchByIdButton.addActionListener(e -> {
            getContentPane().removeAll();
            getContentPane().add(searchByIdPanel, BorderLayout.CENTER);
            searchResultsArea.setText("Currently in progress");
            revalidate();
            repaint();
        });



        // Exit Button (in the search by ID panel)
        exitButton4.addActionListener(e -> {
            getContentPane().removeAll();
            getContentPane().add(showPatientsPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });



        //Back to Patient Panel
        BackButton1.addActionListener(e -> {
            getContentPane().removeAll();;
            getContentPane().add(homePanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });

        // Back to Home Button (from Add Patient Panel)
        backButton2.addActionListener(e -> {
            getContentPane().removeAll();
            getContentPane().add(patientPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });

        // Save Patient Button
        savePatientButton.addActionListener(e -> {
            String name = nameField.getText();
            int id = Integer.parseInt(idField.getText());
            int age = Integer.parseInt(ageField.getText());
            String problem = problemField.getText();
            String recommendedDoctor = recommendedDoctorField.getText();
            String dischargeDate = dischargeDateField.getText();

            Patient patient = new Patient(name, id, age, problem,recommendedDoctor, dischargeDate);
            patientManager.addPatient(patient);

            JOptionPane.showMessageDialog(null, "Patient saved successfully.", "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            getContentPane().removeAll();
            getContentPane().add(homePanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });


        // Switch to Show Patients Panel
        showPatientsButton.addActionListener(e -> {
            List<Patient> patients = patientManager.getAllPatients();
            StringBuilder sb = new StringBuilder();
            for (Patient patient : patients) {
                sb.append("Name: ").append(patient.name()).append(", ID: ").append(patient.id())
                        .append(", Age: ").append(patient.age()).append(", Problem: ").append(patient.problem()).append(", Recommended Doctor: ").append(patient.recommendedDoctor()).append(", Discharge Date: ")
                        .append(patient.dischargeDate()).append("\n");
            }
            patientListArea.setText(sb.toString());

            getContentPane().removeAll();
            getContentPane().add(showPatientsPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });

        // Delete Patient Button (in the Show All Patients Panel)
        deletePatientButton.addActionListener(e -> {
            String selectedPatientData = patientListArea.getSelectedText(); // Get the selected patient data
            if (selectedPatientData != null && !selectedPatientData.isEmpty()) {
                try {
                    String[] data = selectedPatientData.split(", ");
                    String name = data[0].substring(6);
                    int id = Integer.parseInt(data[1].substring(4));

                    // Find and remove the patient with the selected ID in the patients list
                    Patient selectedPatient = null;
                    for (Patient patient : patientManager.getAllPatients()) {
                        if (patient.id() == id && patient.name().equals(name)) {
                            selectedPatient = patient;
                            break;
                        }
                    }

                    if (selectedPatient != null) {
                        patientManager.deletePatient(selectedPatient); // Delete the selected patient
                        JOptionPane.showMessageDialog(null, "Patient deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                        // Refresh the patient list display after deletion
                        List<Patient> patients = patientManager.getAllPatients();
                        StringBuilder sb = new StringBuilder();
                        for (Patient p : patients) {
                            sb.append("Name: ").append(p.name()).append(", ID: ").append(p.id())
                                    .append(", Age: ").append(p.age()).append(", Problem: ").append(p.problem())
                                    .append(", Recommended Doctor: ").append(p.recommendedDoctor()).append(", Discharge Date: ")
                                    .append(p.dischargeDate()).append("\n");
                        }
                        patientListArea.setText(sb.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Patient not found in the list.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID format. Please select valid patient information to delete.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select a patient to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


        // Back to Patient (from Show Patients Panel)
        backButton3.addActionListener(e -> {
            getContentPane().removeAll();
            getContentPane().add(patientPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });

        // Healthcare Information Button
        healthcareInfoButton.addActionListener(e -> {
            getContentPane().removeAll();
            getContentPane().add(infoPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });

        // Back to Home Button (from Healthcare Information Panel)
        backButton6.addActionListener(e -> {
            getContentPane().removeAll();
            getContentPane().add(homePanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        });

        // Logout Button
        logoutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Loged out successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });


    }
}