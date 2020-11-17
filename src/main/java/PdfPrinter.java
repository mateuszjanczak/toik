import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.stream.Collectors;

public class PdfPrinter {
    private User user;
    private String filename;

    public PdfPrinter(String filename, User user) {
        this.user = user;
        this.filename = filename;
    }

    public void print() {
        try {
            OutputStream fos = new FileOutputStream(new File(filename));
            Document document = new Document();
            PdfWriter.getInstance(document, fos);
            document.open();

            Paragraph paragraph = new Paragraph("Resume");
            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.setSpacingAfter(25);

            PdfPTable table = new PdfPTable(2);

            table.getDefaultCell().setPadding(10);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

            table.addCell("First name");
            table.addCell(user.getFirstName());

            table.addCell("Last name");
            table.addCell(user.getLastName());

            table.addCell("Profession");
            table.addCell(user.getProfession());

            table.addCell("Education");
            table.addCell(user.getEducation().stream().map(Object::toString).collect(Collectors.joining("\n")));

            table.addCell("Summary");
            table.addCell(user.getSummary());

            document.add(paragraph);
            document.add(table);

            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
