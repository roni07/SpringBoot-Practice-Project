package basic.vaadin.vaadinbasic.ui;

import basic.vaadin.vaadinbasic.model.Student;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringUI
public class StudentUI extends UI{
    private List<Student> studentList;

    public StudentUI(){
        studentList = new ArrayList<>();
        studentList.add(new Student(55, "Shamim Pro Boss1", 3.75));
        studentList.add(new Student(78, "Kamrul Hasan Pro Boss2", 3.70));
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Label label = new Label("hello");
        Button button = new Button("click");

        Grid<Student> studentGrid = new Grid<>();
        studentGrid.setItems(studentList);
        studentGrid.addColumn(Student::getId).setCaption("ID");
        studentGrid.addColumn(Student::getName).setCaption("Name");
        studentGrid.addColumn(Student::getCgpa).setCaption("CGPA");
        studentGrid.setSelectionMode(Grid.SelectionMode.MULTI);

        button.addClickListener(clickEvent -> {
           label.setValue("User");
            Notification.show("clicked");
        });

        VerticalLayout verticalLayout = new VerticalLayout();

        HorizontalLayout horizontalLayout = new HorizontalLayout();

        horizontalLayout.addComponents(label, button);

        verticalLayout.addComponent(horizontalLayout);
        verticalLayout.addComponent(studentGrid);


        setContent(verticalLayout);
    }
}
