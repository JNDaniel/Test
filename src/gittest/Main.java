/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gittest;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, FileNotFoundException, IOException {

   
     

        
       

    }
    public static void rotateImage() throws IOException
    {
         //Przykład - kopiowanie obrazu piksel po pikselu
     File imgFile = new File("1a.jpg"); //odczytaj obraz
     BufferedImage img1 = ImageIO.read(imgFile); //obraz -> obiekt
     int w=img1.getWidth();
     int h=img1.getHeight();
     int min = Integer.min(w, h);
    if(w!=h)
    {
        img1=cropImage(img1,new Rectangle(min, min));
    }
     w=min;
     h=min;
     
     int buff[] = new int[w*h]; //przygotuj tablicę pikseli
     img1.getRGB(0, 0, w, h, buff, 0, w); //kopiuj piksele do tablicy
     BufferedImage img2=new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB);
     int buff2[][] = new int[w][h];
        for(int i=0; i<h; i++) {
        for(int j=0; j<w; j++) {
         buff2[i][j]=buff[i*h+j];
    }
    }
     int buff3[][] = new int[w][h];
     for(int i=0; i<h; i++) {
        for(int j=0; j<w; j++) {
        buff3[i][j] = buff2[w-1-j][i];
    }
    }

     for(int i=0; i<h; i++) {
        for(int j=0; j<w; j++) {
        buff[i*h+j] = buff3[i][j];
    }
    }
     
     
     img2.setRGB(0, 0, w, h, buff, 0, w);
     File outFile = new File("2.jpg");
     ImageIO.write(img2, "JPG", outFile) ;
    }
        public static String simplifyText(String text) throws RemoteException, FileNotFoundException {
           String pattern = "(?m)^\\s";   
           String s = text;
           s = s.replaceAll(pattern, " ").replaceAll(","," ").toLowerCase();   
           return s;
       
    }
        private static HashMap sortByValues(HashMap map) 
{ 
       List list = new LinkedList(map.entrySet());
       Collections.sort(list, (Object o2, Object o1) -> ((Comparable) ((Map.Entry) (o1)).getValue())
               .compareTo(((Map.Entry) (o2)).getValue()));
       int i=0;
       HashMap sortedHashMap = new LinkedHashMap();
       for (Iterator it = list.iterator(); it.hasNext();) {
            if(i>5) break;
              Map.Entry entry = (Map.Entry) it.next();
              sortedHashMap.put(entry.getKey(), entry.getValue());
              i++;
              
       } 
       return sortedHashMap;
  }
        private static BufferedImage cropImage(BufferedImage src, Rectangle rect) {
      BufferedImage dest = src.getSubimage(0, 0, rect.width, rect.height);
      return dest; 
   }
}
    

