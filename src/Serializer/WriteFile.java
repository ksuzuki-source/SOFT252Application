/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serializer;


import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.ModelsStore;

/**
 *
 * @author kouss
 */

public class WriteFile extends FileManagementTemplate{
    FileWriter file;
    
    /**
     *Closes the file to be written to
     */
    @Override
    protected void closeFile() {
        try {
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *Opens the file
     */
    @Override
    protected void openFile() {
        
        try {
            this.file = new FileWriter("Data.json");
        } catch (IOException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     *Writes models to file
     * <p> writes the models to the file using GSON </p>
     */
    @Override
    protected void modifyFile() {
        try {
            Gson gson = new Gson();
            String jsonString = gson.toJson(modelsStore);
            file.write(jsonString);
        } catch (IOException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
