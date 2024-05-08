package com.example.FinalProject.Controllers.otherController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.example.FinalProject.App;

import java.util.Objects;

public class page2Controller {

    @FXML
    public Button cbtn;

    @FXML
    public Button htmlbtn;

    @FXML
    public Button pythonbtn;

    @FXML
    public Button cppbtn;

    @FXML
    public Button javabtn;

    @FXML
    public Button cssbtn;

    @FXML
    public ImageView profiePic;

    @FXML
    public ImageView showicon;

    @FXML
    public TextArea overview;

    @FXML
    public Button nextbtn;

    @FXML
    public void initialize()
    {

    }

    @FXML
    public void handleHtmlButtonClick(ActionEvent event) {

        Image htmlIcon = new Image(Objects.requireNonNull(App.class.getResourceAsStream("/image/html_icon.png")));
        showicon.setImage(htmlIcon);
        overview.setText("HTML is the standard markup language used for creating web pages and web applications. It provides the structure and content of a webpage by using a system of tags and attributes to define elements such as headings, paragraphs, images, links, and forms. HTML documents are composed of a hierarchy of nested elements, forming a tree-like structure known as the Document Object Model (DOM). With HTML, developers can create interactive and multimedia-rich web experiences, supported by the latest HTML5 specifications and APIs.");
    }

    @FXML
    public void handlePythonButtonClick(ActionEvent event) {
        Image pythonIcon = new Image(Objects.requireNonNull(App.class.getResourceAsStream("/image/python_icon.png")));
        showicon.setImage(pythonIcon);
        overview.setText("Python is a high-level programming language known for its simplicity and readability. It emphasizes code readability and allows programmers to express concepts in fewer lines of code compared to other languages. Python supports multiple programming paradigms, including procedural, object-oriented, and functional programming. It is widely used in various domains such as web development, data science, artificial intelligence, and automation.");
    }

    @FXML
    public void handleJavaButtonClick(ActionEvent event) {
        Image javaicon = new Image(Objects.requireNonNull(App.class.getResourceAsStream("/image/java_icon.png")));
        showicon.setImage(javaicon);
        overview.setText("Java is a popular and widely-used programming language known for its portability, performance, and security features. Developed by Sun Microsystems (now owned by Oracle), Java is designed to be platform-independent, meaning that Java programs can run on any device that has a Java Virtual Machine (JVM). Java is commonly used for building enterprise-level applications, web servers, mobile apps (Android), and large-scale distributed systems.");
    }

    @FXML
    public void handleCssButtonClick(ActionEvent event) {
        Image cssIcon = new Image(Objects.requireNonNull(App.class.getResourceAsStream("/image/css_icon.png")));
        showicon.setImage(cssIcon);
        overview.setText("CSS is a fundamental technology used to style and layout web pages. It defines how HTML elements are displayed, including their design, layout, and visual presentation. With CSS, developers can control aspects such as colors, fonts, spacing, and positioning, allowing for the creation of visually appealing and responsive websites.");
    }

    @FXML
    public void handleCButtonClick(ActionEvent event) {
        Image cIcon = new Image(Objects.requireNonNull(App.class.getResourceAsStream("/image/c_icon.png")));
        showicon.setImage(cIcon);
        overview.setText("C is a general-purpose, procedural programming language developed by Dennis Ritchie at Bell Labs in the early 1970s. It is one of the oldest and most influential programming languages, serving as the foundation for many other languages. C is known for its efficiency, flexibility, and low-level access to memory, making it suitable for system programming, embedded systems, and developing operating systems and device drivers.");
    }

    @FXML
    public void handleCppButtonClick(ActionEvent event) {
        Image cppIcon = new Image(Objects.requireNonNull(App.class.getResourceAsStream("/image/cpp_icon.png")));
        showicon.setImage(cppIcon);
        overview.setText("C++ is a powerful and versatile programming language derived from C. It was developed by Bjarne Stroustrup in the 1980s and introduced object-oriented programming (OOP) features to C, such as classes and inheritance. C++ combines the features of both high-level and low-level languages, providing developers with control over system resources while also supporting modern programming concepts like polymorphism and encapsulation. It is commonly used in game development, system software, and performance-critical applications.");
    }
}
