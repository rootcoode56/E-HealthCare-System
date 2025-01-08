import java.util.*;

public class Doctor {
    private final int id;
    private final String name;

    private final int age;

    private final String specialist;

    public Doctor(String name,int id, int age, String specialist) {
        this.id = id;
        this.name = name;
        this.age= age;
        this.specialist = specialist;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public int id() {
        return id;
    }

    public String specialist() {
        return specialist;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        var that = (Doctor) obj;
        return Objects.equals(this.name, that.name) &&
                this.id == that.id &&
                this.age == that.age &&
                Objects.equals(this.specialist, that.specialist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, age, specialist);
    }

    @Override
    public String toString() {
        return "Doctor[" +
                "name=" + name + ", " +
                "id=" + id + ", " +
                "age=" + age + ", " +
                "specialist=" + specialist + ", " +']';
    }
}
