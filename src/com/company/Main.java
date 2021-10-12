package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {


        public static void main(String[] args) throws IOException {


            ArrayList<String> noms = new ArrayList<>();
            ArrayList<String> cognoms = new ArrayList<>();
            ArrayList<String> edats = new ArrayList<>();
            llegirFitxer(noms, cognoms, edats);
            mostraPerPantala(noms, cognoms, edats);
            escriuSortidaCSV(noms, cognoms, edats);
        }

        private static void escriuSortidaCSV(ArrayList<String> noms, ArrayList<String> cognoms, ArrayList<String> edats) {
            try {
                BufferedWriter outputStream = new BufferedWriter(new FileWriter("C:\\Users\\jbm19\\Documents\\Nuevodocumentodetexto.csv"));
                outputStream.write("nom,cognom,edat");
                outputStream.newLine();
                for (int i = 0; i < noms.size(); i++) {
                    outputStream.write(noms.get(i) + "," + cognoms.get(i) + "," + edats.get(i));
                    outputStream.newLine();
                }
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void mostraPerPantala(ArrayList<String> noms, ArrayList<String> cognoms, ArrayList<String> edats) {
            for (int i = 0; i < noms.size(); i++) {
                System.out.print(noms.get(i) + ",");
                System.out.print(cognoms.get(i) + ",");
                System.out.print(edats.get(i));
                System.out.println();
            }
        }

        private static void llegirFitxer(ArrayList<String> noms, ArrayList<String> cognoms, ArrayList<String> edats) throws IOException {
            try {
                BufferedReader inputStream = new BufferedReader(new FileReader("C:\\Users\\jbm19\\Documents\\Nuevodocumentodetexto.txt"));

                String line;
                while ((line = inputStream.readLine()) != null) {
                    if (line.equals("****")) line = inputStream.readLine();

                    noms.add(line);
                    cognoms.add(inputStream.readLine());
                    edats.add(inputStream.readLine());
                }
                inputStream.close();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }

}