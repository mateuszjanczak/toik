import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Resume resume = new Resume("Mateusz", "Janczak", "Student", Arrays.asList("2014 - 2018 ZSME Tarnow", "2018 - 2022 PWSZ Tarnow"), "Jestem studentem trzeciego roku studiow inzynierskich w Panstwowej Wyzszej Szkole Zawodowej w Tarnowie na kierunku informatyka stosowana. W przyszlosci chcialbym zostac Full-Stack Developerem.");
        String filename = "resume.pdf";
        PdfPrinter pdfPrinter = new PdfPrinter(filename, resume);
        pdfPrinter.print();
    }
}