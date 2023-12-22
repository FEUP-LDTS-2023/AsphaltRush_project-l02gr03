package com.ldts.asphaltrush.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class ImageFactory {

    private HashMap<String, Image> images;
    public ImageFactory(){
        images =  new HashMap<>();
    }

    // Returns the correspondent image
    public Image getImage(String image){
        // Checks if image is already loaded
        if (!images.containsKey(image)) {
            // Loads image from file
            Image loadedImage = loadImageFromFile(image);
            // Saves it to use later
            images.put(image, loadedImage);
        }
        return images.get(image);
    }

    private Image loadImageFromFile(String image){
        // Get the Image txt file URL
        URL resource = ImageFactory.class.getResource("/images/"+ image + ".txt");
        // Asserts that it exists
        assert resource != null;
        try {
            // Reads the .txt file and returns the correspondent image
            BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
            return readImage(br);
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private Image readImage(BufferedReader br) throws IOException {
        // Gets the dimensions from the file
        int width = Integer.parseInt(br.readLine());
        int height = Integer.parseInt(br.readLine());

        // The structure where the color information of the image will be stored
        String[][] colorMatrix = new String[height][width];

        // Reads line by line considering the height of the image
        for (int i=0; i<height; i++){
            String line = br.readLine();
            colorMatrix[i] = line.split("-");
        }
        return new Image(width, height, colorMatrix);
    }

}
