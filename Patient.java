import java.util.Objects;

public final class Patient {
    private final String name;
    private final int id;
    private final int age;

    private final String problem;

    private final String recommendedDoctor;
    private final String dischargeDate;



    public Patient(String name, int id, int age, String problem, String recommendedDoctor, String dischargeDate) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.problem = problem;
        this.recommendedDoctor = recommendedDoctor;
        this.dischargeDate = dischargeDate;
    }

    public String name() {
        return name;
    }

    public int id() {
        return id;
    }

    public int age() {
        return age;
    }

    public String problem(){
        return problem;
    }

    public String recommendedDoctor(){
        return recommendedDoctor;
    }

    public String dischargeDate() {
        return dischargeDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        var that = (Patient) obj;
        return Objects.equals(this.name, that.name) &&
                this.id == that.id &&
                this.age == that.age &&
                Objects.equals(this.problem, that.problem) &&
                Objects.equals(this.recommendedDoctor, that.recommendedDoctor) &&
                Objects.equals(this.dischargeDate, that.dischargeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, age,problem,recommendedDoctor, dischargeDate);
    }

    @Override
    public String toString() {
        return "Patient[" +
                "name=" + name + ", " +
                "id=" + id + ", " +
                "age=" + age + ", " +
                "problem=" + problem+ ", "+
                "recommended doctor: " + recommendedDoctor + ", " +
                "dischargeDate=" + dischargeDate + ']';
    }
}