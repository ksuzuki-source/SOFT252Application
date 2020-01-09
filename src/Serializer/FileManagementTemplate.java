/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serializer;

import Models.ModelsStore;
/**
 *
 * @author kouss
 */
public abstract class FileManagementTemplate {
    
      protected ModelsStore modelsStore;

    /**
     *This is the template for file management
     * Template to read and write to file
     * it handles all the file management and returns the models
     * from the data.json file 
     *
     * @param Models
     * @return The models written/read from the JSON file
     */
    public ModelsStore executeAction(ModelsStore Models){
        this.modelsStore = Models;
        openFile();
        modifyFile();
        closeFile();
        return this.modelsStore;
    }

    /**
     * Abstract method to implement
     */
    protected abstract void modifyFile();

    /**
     * Abstract method to implement
     */
    protected abstract void closeFile();

    /**
     * Abstract method to implement
     */
    protected abstract void openFile();
        
    

    
}
