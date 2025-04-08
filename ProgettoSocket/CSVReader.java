import java.io.*;
import java.util.ArrayList;

public class CSVReader {
    ArrayList<String> fileContent = new ArrayList<>();
    ArrayList<String> costantFeatureKey = new ArrayList<>();
    ArrayList<String> costantAmbientKey = new ArrayList<>();
    ArrayList<String> costantLanguageKey = new ArrayList<>();

    public CSVReader() {
        readCSV();
    }

    public void readCSV() {
        try(BufferedReader br = new BufferedReader(new FileReader("ProgettoSocket\\Regione-Veneto---Elenco-strutture-ricettive.csv"))) {
            String fileLine;
            int nLinea = 0;
            while((fileLine = br.readLine()) != null) {
                String[] dataTopics = fileLine.split(";");
                if(nLinea == 0) {
                    for(int i = 17; i <= 28; i++) {
                        costantFeatureKey.add(dataTopics[i]);
                    }

                    for(int i = 29; i <= 39; i++) {
                        costantAmbientKey.add(dataTopics[i]);
                    }

                    for(int i = 40; i <= 43; i++) {
                        costantLanguageKey.add(dataTopics[i]);
                    }
                    nLinea++;
                    continue;
                }

                Data data = new Data();
                data.setComune(dataTopics[0]);
                data.setProvincia(dataTopics[1]);
                data.setTipologia(dataTopics[3]);
                data.setCategoria(dataTopics[5]);
                data.setNumeroStelle(dataTopics[6]);
                data.setDenominazione(dataTopics[7]);
                data.setIndirizzo(dataTopics[8]);
                data.setNumeroCivico(dataTopics[9]);
                data.setCap(dataTopics[11]);
                data.setNumTelefono(dataTopics[12]);
                data.setFax(dataTopics[13]);
                data.setPostaElettronica(dataTopics[14]);
                data.setZona(dataTopics[16]);

                for(int i = 17; i <= 28; i++) {
                    data.setFeature(costantFeatureKey.get(i), dataTopics[i]);
                }

                for(int i = 29; i <= 39; i++) {
                    data.setAmbiente(costantAmbientKey.get(i), dataTopics[i]);
                }

                for(int i = 40; i <= 43; i++) {
                    data.setLingua(costantLanguageKey.get(i), dataTopics[i]);
                }

                data.setCodice(dataTopics[46]);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}