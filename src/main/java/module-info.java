module com.example.FinalProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
//    requires de.jensd.fx.glyphs.fontawsome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires jbcrypt;
    requires mysql.connector.j;
    requires jdk.unsupported;
    requires java.xml.bind;
    requires org.hibernate.orm.core;
    requires htmlunit;
    requires htmlunit.core.js;
    requires spring.jcl;
    requires java.desktop;
    requires org.json;
    requires org.apache.commons.lang3;
    requires annotations;

    opens com.example.FinalProject to javafx.fxml;
    exports com.example.FinalProject;
    exports com.example.FinalProject.Controllers;
    exports com.example.FinalProject.Controllers.Admin;
    exports com.example.FinalProject.Controllers.User;
    exports com.example.FinalProject.Controllers.Login;
    exports com.example.FinalProject.Controllers.Register;
    exports com.example.FinalProject.Controllers.otherController;
    exports com.example.FinalProject.Controllers.ChatBot;
    exports com.example.FinalProject.Controllers.Community;
    exports com.example.FinalProject.Controllers.chat;
//    exports com.example.FinalProject.Models;
//    exports com.example.FinalProject.Views;

    opens com.example.FinalProject.Controllers.Register to javafx.fxml;
    exports com.example.FinalProject.Database;
    opens com.example.FinalProject.Database to javafx.fxml;
    opens com.example.FinalProject.Controllers.Community to javafx.fxml;
}