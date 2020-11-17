import java.util.List;

public class Resume {
    private String firstName;
    private String lastName;
    private String profession;
    private List<String> education;
    private String summary;

    public Resume(String firstName, String lastName, String profession, List<String> education, String summary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
        this.education = education;
        this.summary = summary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<String> getEducation() {
        return education;
    }

    public void setEducation(List<String> education) {
        this.education = education;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
