import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManagementSystemFORDoctor implements DoctorManager{
    private static final String FILE_PATH_2= "doctor_list.docx";
    private List<Doctor> doctors;

    public List<Doctor> getDoctorsFromFile() {
        List<Doctor> doctors = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_2));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int id = Integer.parseInt(data[1]);
                int age = Integer.parseInt(data[2]);
                String specialist = data[3];

                Doctor doctor = new Doctor(name, id, age, specialist);
                doctors.add(doctor);
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error occurred while reading the doctor list.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return doctors;
    }

    public List<Doctor> getAllDoctors() {
        return getDoctorsFromFile();
    }


}
