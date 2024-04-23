package com.example.FinalProject.Controllers.ChatBot;

import org.apache.commons.logging.LogFactory;

import org.htmlunit.BrowserVersion;
import org.htmlunit.WebClient;
import org.htmlunit.corejs.javascript.NativeArray;
import org.htmlunit.html.HtmlForm;
import org.htmlunit.html.HtmlPage;
import org.htmlunit.html.HtmlTextInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import org.json.JSONObject;

public class botParser {

    private static botParser instance = new botParser();

    public static botParser getInstance(){
        return instance;
    }

    private AtomicReference<HtmlPage> page = new AtomicReference<>();

    public void init() throws IOException{
        /* Suppress HtmlUnit logs */
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);

        WebClient client = new WebClient(BrowserVersion.BEST_SUPPORTED);
        client.getOptions().setCssEnabled(false);
        client.getOptions().setUseInsecureSSL(true);

        client.getOptions().setThrowExceptionOnScriptError(false);
        client.getOptions().setThrowExceptionOnFailingStatusCode(false);

        client.setIncorrectnessListener((arg0, arg1) -> {
        });

        this.page.set(client.getPage("https://cleverbot.com"));
    }

    public String sendAI(String text) throws IOException{
        final HtmlForm form = this.page.get().getForms().get(page.get().getForms().size() - 1);
        final HtmlTextInput textField = form.getInputByName("stimulus");
        textField.type(text);

        this.page.get().executeJavaScript("cleverbot.sendAI()"); //Send date from form

        //noinspection StatementWithEmptyBody
        while(textField.getText().equals("thinking")
                || textField.getText().equals("thinking.")
                || textField.getText().equals("thinking..")
                || textField.getText().equals("thinking...")) ; //Wait while the bot thinking
        System.out.println("Answer: " + textField.getText());

        Object result = this.page.get().executeJavaScript("cleverbot.alternates")
                .getJavaScriptResult(); //Get answers

        if(result instanceof NativeArray){
            return ((NativeArray) result).get(0).toString();
        }

        return "";
    }
}
