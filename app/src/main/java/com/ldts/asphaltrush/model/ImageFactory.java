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

    public Image getImage(String image){
        if (!images.containsKey(image)) {
            Image loadedImage = loadImageFromFile(image);
            images.put(image, loadedImage);
        }
        return images.get(image);
    }

    private Image loadImageFromFile(String image){
        URL resource = ImageFactory.class.getResource(image + ".txt");
        assert resource != null;
        try {

            BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
            return readImage(br);
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private Image readImage(BufferedReader br) throws IOException {
        int width = Integer.parseInt(br.readLine());
        int height = Integer.parseInt(br.readLine());

        String[][] colorMatrix = new String[height][width];

        for (int i=0; i<height; i++){
            String line = br.readLine();
            colorMatrix[i] = line.split("-");
        }
        return new Image(width, height, colorMatrix);

    }

}
