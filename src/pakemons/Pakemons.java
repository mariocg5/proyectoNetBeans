package pakemons;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Pakemons {

    public static void main(String[] args) {
        try {
            File f = new File("fichero_pakemon.txt");
            Scanner rf = new Scanner(f);
            Scanner sc = new Scanner(System.in);
            String nombre = "";
            String tipo = "";
            String onomatopeya = "";
            double peso = 0;
            double altura = 0;
            ArrayList<String>nombres=new ArrayList<>();
            while (rf.hasNextLine()) {
                String linea = rf.nextLine();
                String[] datos = linea.split(";");
                nombre = datos[0];
                nombres.add(nombre);
                tipo = datos[1];
                onomatopeya = datos[2];
                peso = Double.parseDouble(datos[3]);
                altura = Double.parseDouble(datos[4]);

            }
            System.out.println("Numero");
            int opcion = sc.nextInt();
            if (opcion>0 && opcion<nombres.size()) {
                String nombrePokemon = nombres.get(opcion-1);
                System.out.println("El nombre es "+ nombrePokemon );
            } else{
                System.out.println("La posición está fuera de rango");
            }
            rf.close();
        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println("Errror de tipo SQL " + e);
        }

    }
}
