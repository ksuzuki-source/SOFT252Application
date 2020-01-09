/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serializer;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.ModelsStore;

/**
 *
 * @author kouss
 */
public class ReadFile extends FileManagementTemplate{
    FileReader file;
    /**
     *Reads data from a file
     */
    @Override
    protected void modifyFile() {
        ModelsStore store = null;
        Gson gson = new Gson();
        try (Reader r = new FileReader("Data.json")) {
            // Convert JSON File to Java Object
            store = gson.fromJson(r, ModelsStore.class);	
            // print staff 
            this.modelsStore = store;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *Closes the open file
     */
    @Override
    protected void closeFile() {
        try {
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Opens the file to be read from
     * <p> Opens the file Data.json to be read from </p>
     */
    @Override
    protected void openFile() {
        try {
            this.file = new FileReader("Data.json");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
