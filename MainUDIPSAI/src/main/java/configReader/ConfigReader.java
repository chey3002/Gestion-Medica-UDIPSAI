/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos
 */
public class ConfigReader {

    String database;
    String user;
    String pass;
    String ip;

    public ConfigReader() {
        try {
            String fileName = "c:\\UDIPSAI-Config.txt";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                //process the line
                String value;
                String key = line.split(":")[0];
                if (line.split(":").length >= 2) {
                    value = line.split(":")[1];
                } else {
                    value = "";
                }
                if ("database".equals(key)) {
                    this.database = value;
                }
                
                if ("user".equals(key)) {
                    this.user = value;
                }
                if ("pass".equals(key)) {
                    this.pass = value;
                }
                if ("ip".equals(key)) {
                    this.ip = value;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ConfigReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
