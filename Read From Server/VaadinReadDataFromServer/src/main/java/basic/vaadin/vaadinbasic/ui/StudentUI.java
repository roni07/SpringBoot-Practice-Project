package basic.vaadin.vaadinbasic.ui;

import basic.vaadin.vaadinbasic.model.Student;
import basic.vaadin.vaadinbasic.service.StudentService;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import java.util.Set;

@SpringUI
@Theme("valo")
public class StudentUI extends UI {
    private StudentService studentService;

    public StudentUI(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Button button = new Button("Hit");

        Grid<Student> studentGrid = new Grid<>();
        studentGrid.setItems(studentService.getAllStudents());
        studentGrid.addColumn(Student::getId).setCaption("Id");
        studentGrid.addColumn(Student::getName).setCaption("Name");
        studentGrid.addColumn(Student::getCgpa).setCaption("CGPA");
        studentGrid.setSelectionMode(Grid.SelectionMode.MULTI);

        button.addClickListener(clickEvent -> {
            Set<Student> studentSet = studentGrid.getSelectedItems();
            studentSet.stream().forEach(System.out :: println);
        });

        VerticalLayout verticalLayout = new VerticalLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        horizontalLayout.addComponent(button);

        verticalLayout.addComponents(horizontalLayout, studentGrid);

        setContent(verticalLayout);
    }
}
