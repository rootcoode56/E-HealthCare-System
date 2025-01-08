import java.util.List;

public interface PatientManager {
    void addPatient(Patient patient);
    void deletePatient(Patient patient);
    List<Patient> getAllPatients();
}