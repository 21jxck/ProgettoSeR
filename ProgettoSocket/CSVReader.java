import java.io.*;
import java.util.*;

public class CSVReader {
    List<Data> fileContent = new ArrayList<>();
    List<String> costantFeatureKey = new ArrayList<>();
    List<String> costantAmbientKey = new ArrayList<>();
    List<String> costantLanguageKey = new ArrayList<>();

    public CSVReader() {
        readCSV();
    }

    // metodo per leggere i dati dal file
    public void readCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader("ProgettoSocket\\Regione-Veneto---Elenco-strutture-ricettive.csv"))) {
            String fileLine;
            int nLinea = 0;
            while ((fileLine = br.readLine()) != null) {
                String[] dataTopics = fileLine.split(";");
                if (nLinea == 0) {
                    for (int i = 17; i <= 28; i++) {
                        costantFeatureKey.add(dataTopics[i]);
                    }

                    for (int i = 29; i <= 39; i++) {
                        costantAmbientKey.add(dataTopics[i]);
                    }

                    for (int i = 40; i <= 43; i++) {
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
                data.setCap(dataTopics[11]);
                data.setNumTelefono(dataTopics[12]);
                data.setFax(dataTopics[13]);
                data.setPostaElettronica(dataTopics[14]);
                data.setZona(dataTopics[16]);

                for (int i = 17; i <= 28; i++) {
                    data.setFeature(costantFeatureKey.get(i), dataTopics[i]);
                }

                for (int i = 29; i <= 39; i++) {
                    data.setAmbiente(costantAmbientKey.get(i), dataTopics[i]);
                }

                for (int i = 40; i <= 43; i++) {
                    data.setLingua(costantLanguageKey.get(i), dataTopics[i]);
                }

                data.setCodice(dataTopics[46]);

                fileContent.add(data);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    // metodi per la ricerca dei dati
    public List<Data> researchComune(String comune) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : fileContent) {
            if (data.getComune().equalsIgnoreCase(comune)) {
                researchedData.add(data);
            }
        }

        return researchedData;
    }

    public List<Data> researchProvincia(String provincia) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : fileContent) {
            if (data.getComune().equalsIgnoreCase(provincia)) {
                researchedData.add(data);
            }
        }

        return researchedData;
    }

    public List<Data> researchTipologia(String tipologia) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : fileContent) {
            if (data.getComune().equalsIgnoreCase(tipologia)) {
                researchedData.add(data);
            }
        }

        return researchedData;
    }

    public List<Data> researchCategoria(String categoria) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : fileContent) {
            if (data.getComune().equalsIgnoreCase(categoria)) {
                researchedData.add(data);
            }
        }

        return researchedData;
    }

    public List<Data> ricercaNStelle(String nStelle) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : fileContent) {
            if (data.getComune().equalsIgnoreCase(nStelle)) {
                researchedData.add(data);
            }
        }

        return researchedData;
    }

    public List<Data> researchDenominazione(String denominazione) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : fileContent) {
            if (data.getComune().equalsIgnoreCase(denominazione)) {
                researchedData.add(data);
            }
        }

        return researchedData;
    }

    public List<Data> researchIndirizzo(String indirizzo) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : fileContent) {
            if (data.getComune().equalsIgnoreCase(indirizzo)) {
                researchedData.add(data);
            }
        }

        return researchedData;
    }

    public List<Data> researchCap(String cap) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : fileContent) {
            if (data.getComune().equalsIgnoreCase(cap)) {
                researchedData.add(data);
            }
        }

        return researchedData;
    }

    public List<Data> researchNTelefono(String nTelefono) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : fileContent) {
            if (data.getComune().equalsIgnoreCase(nTelefono)) {
                researchedData.add(data);
            }
        }

        return researchedData;
    }

    public List<Data> researchFax(String fax) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : fileContent) {
            if (data.getComune().equalsIgnoreCase(fax)) {
                researchedData.add(data);
            }
        }

        return researchedData;
    }

    public List<Data> researchPostaElettronica(String postaElettronica) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : fileContent) {
            if (data.getComune().equalsIgnoreCase(postaElettronica)) {
                researchedData.add(data);
            }
        }

        return researchedData;
    }

    public List<Data> researchZona(String zona) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : fileContent) {
            if (data.getComune().equalsIgnoreCase(zona)) {
                researchedData.add(data);
            }
        }

        return researchedData;
    }

    public List<Data> researchFeature(String feature) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : fileContent) {
            if (data.getFeature().get(feature)) {
                researchedData.add(data);
            }
        }

        return researchedData;
    }

    public List<Data> researchAmbiente(String ambiente) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : fileContent) {
            if (data.getAmbiente().get(ambiente)) {
                researchedData.add(data);
            }
        }

        return researchedData;
    }

    public List<Data> researchLingua(String lingua) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : fileContent) {
            if (data.getLingua().get(lingua)) {
                researchedData.add(data);
            }
        }

        return researchedData;
    }

    public List<Data> researchCodice(String codice) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : fileContent) {
            if (data.getComune().equalsIgnoreCase(codice)) {
                researchedData.add(data);
            }
        }

        return researchedData;
    }
}