import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagementSystem implements PatientManager {
    private static final String FILE_PATH = "patient_list.docx";

    private List<Patient> patients;


    @Override
    public void addPatient(Patient patient) {
        try {
            FileWriter writer = new FileWriter(FILE_PATH, true);
            writer.write(patient.name() + "," + patient.id() + "," + patient.age() + "," + patient.problem() + "," + patient.recommendedDoctor() + "," +
                    patient.dischargeDate() + "\n");
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error occurred while saving the patient.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }




    @Override
    public void deletePatient(Patient patient) {
        try {
            File inputFile = new File(FILE_PATH);
            File tempFile = new File("temp.docx");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = patient.name() + "," + patient.id() + "," + patient.age() + "," + patient.problem() + "," + patient.recommendedDoctor() + "," +
                    patient.dischargeDate();
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if (!trimmedLine.equals(lineToRemove)) {
                    writer.write(currentLine + "\n");
                }
            }

            writer.close();
            reader.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error occurred while deleting the patient.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int id = Integer.parseInt(data[1]);
                int age = Integer.parseInt(data[2]);
                String problem = data[3];
                String recommendedDoctor = data[4];
                String dischargeDate = data[5];


                Patient patient = new Patient(name, id, age, problem, recommendedDoctor, dischargeDate);
                patients.add(patient);
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error occurred while reading the patient list.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return patients;
    }


}