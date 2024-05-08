package com.example.FinalProject.Controllers.otherController;

import com.example.FinalProject.App;
import com.example.FinalProject.Controllers.Community.CommunityController;
import com.example.FinalProject.Controllers.HomeController;
import com.example.FinalProject.Controllers.faqController;
import com.example.FinalProject.Controllers.resource.javaReController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
    public Hyperlink homebtn;

    @FXML
    public Hyperlink communitybtn;

    @FXML
    public Hyperlink faqbtn;

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

    @FXML
    public void handleFaqButtonClick(ActionEvent actionEvent) {
        try{
            // loading the faq page fxml file
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/faq.fxml"));
            Parent root = loader.load();

            // get the controller for the faq page
            faqController fc = (faqController) loader.getController();

            // show the faq page
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Code Astra");
            stage.getIcons().add(new Image(String.valueOf(App.class.getResource("/image/Code_Astra Logo OG.png"))));
            stage.show();

            // closing the window
            Stage homeStage = (Stage) communitybtn.getScene().getWindow();
            homeStage.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void handleHomeButtonClick(ActionEvent event) {
        try{
            // loading the login page fxml file
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/home.fxml"));
            Parent root = loader.load();

            // get the controller for the login page
            HomeController hc = (HomeController) loader.getController();

            // show the login page
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Code Astra");
            stage.getIcons().add(new Image(String.valueOf(App.class.getResource("/image/Code_Astra Logo OG.png"))));
            stage.show();

            // closing the window
            Stage homeStage = (Stage) homebtn.getScene().getWindow();
            homeStage.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void handleCommunityButtonClick(ActionEvent event) {
        try{
            // loading the login page fxml file
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/community/loading_page.fxml"));
            Parent root = loader.load();

            // get the controller for the login page
            CommunityController cc = (CommunityController) loader.getController();

            // show the login page
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Code Astra");
            stage.getIcons().add(new Image(String.valueOf(App.class.getResource("/image/Code_Astra Logo OG.png"))));
            stage.show();

            // closing the window
            Stage homeStage = (Stage) communitybtn.getScene().getWindow();
            homeStage.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void handleNextButtonClick(ActionEvent event) {
        if (javabtn.isPressed()){
            try{
                FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/resources/javaResource.fxml"));
                Parent root = loader.load();

                javaReController jc = (javaReController) loader.getController();

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Code Astra");
                stage.getIcons().add(new Image(String.valueOf(App.class.getResource("/image/Code_Astra Logo OG.png"))));
                stage.show();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if (pythonbtn.isPressed()){
            try{
                FXMLLoader loader = new FXMLLoader(App.class.getResource("/Fxml/resources/javaResource.fxml"));
                Parent root = loader.load();

                javaReController jc = (javaReController) loader.getController();

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Code Astra");
                stage.getIcons().add(new Image(String.valueOf(App.class.getResource("/image/Code_Astra Logo OG.png"))));
                stage.show();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
