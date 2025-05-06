import java.io.*;
import java.util.*;

public class CSVReader {
    static List<Data> fileContent = new ArrayList<>();
    static List<String> costantFeatureKey = new ArrayList<>();
    static List<String> costantAmbientKey = new ArrayList<>();
    static List<String> costantLanguageKey = new ArrayList<>();

    public CSVReader() {
        readCSV();
    }

    public void readCSV() {
        fileContent.clear();
        costantFeatureKey.clear();
        costantAmbientKey.clear();
        costantLanguageKey.clear();

        try (BufferedReader br = new BufferedReader(
                new FileReader("ParteServer\\Regione-Veneto---Elenco-strutture-ricettive (1).csv"))) {
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

                if (dataTopics.length < 44)
                    continue;

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

                int j = 0;

                for (int i = 17; i <= 28; i++) {
                    data.setFeature(costantFeatureKey.get(j), dataTopics[i]);
                    j++;
                }

                j = 0;
                for (int i = 29; i <= 39; i++) {
                    data.setAmbiente(costantAmbientKey.get(j), dataTopics[i]);
                    j++;
                }

                j = 0;
                for (int i = 40; i <= 43; i++) {
                    data.setLingua(costantLanguageKey.get(j), dataTopics[i]);
                    j++;
                }

                data.setCodice(dataTopics[46]);

                fileContent.add(data);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public List<Data> researchComune(String comune, List<Data> currentContent) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : currentContent) {
            if (data.getComune().equalsIgnoreCase(comune))
                researchedData.add(data);
        }

        return researchedData;
    }

    public List<Data> researchProvincia(String provincia, List<Data> currentContent) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : currentContent) {
            if (data.getProvincia().equalsIgnoreCase(provincia))
                researchedData.add(data);
        }

        return researchedData;
    }

    public List<Data> researchTipologia(String tipologia, List<Data> currentContent) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : currentContent) {
            if (data.getTipologia().equalsIgnoreCase(tipologia))
                researchedData.add(data);
        }

        return researchedData;
    }

    public List<Data> researchCategoria(String categoria, List<Data> currentContent) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : currentContent) {
            if (data.getCategoria().equalsIgnoreCase(categoria))
                researchedData.add(data);
        }

        return researchedData;
    }

    public List<Data> researchNStelle(String nStelle, List<Data> currentContent) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : currentContent) {
            if (data.getNumeroStelle().equalsIgnoreCase(nStelle))
                researchedData.add(data);
        }

        return researchedData;
    }

    public List<Data> researchDenominazione(String denominazione, List<Data> currentContent) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : currentContent) {
            if (data.getDenominazione().equalsIgnoreCase(denominazione))
                researchedData.add(data);
        }

        return researchedData;
    }

    public List<Data> researchIndirizzo(String indirizzo, List<Data> currentContent) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : currentContent) {
            if (data.getIndirizzo().equalsIgnoreCase(indirizzo))
                researchedData.add(data);
        }

        return researchedData;
    }

    public List<Data> researchCap(String cap, List<Data> currentContent) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : currentContent) {
            if (data.getCap().equalsIgnoreCase(cap))
                researchedData.add(data);
        }

        return researchedData;
    }

    public List<Data> researchNTelefono(String nTelefono, List<Data> currentContent) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : currentContent) {
            if (data.getNumTelefono().equalsIgnoreCase(nTelefono))
                researchedData.add(data);
        }

        return researchedData;
    }

    public List<Data> researchFax(String fax, List<Data> currentContent) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : currentContent) {
            if (data.getFax().equalsIgnoreCase(fax))
                researchedData.add(data);
        }

        return researchedData;
    }

    public List<Data> researchPostaElettronica(String postaElettronica, List<Data> currentContent) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : currentContent) {
            if (data.getPostaElettronica().equalsIgnoreCase(postaElettronica))
                researchedData.add(data);
        }

        return researchedData;
    }

    public List<Data> researchZona(String zona, List<Data> currentContent) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : currentContent) {
            if (data.getZona().equalsIgnoreCase(zona))
                researchedData.add(data);
        }

        return researchedData;
    }

    public List<Data> researchFeature(String feature, List<Data> currentContent) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : currentContent) {
            if (data.getFeature().get(feature) != null && data.getFeature().get(feature))
                researchedData.add(data);
        }

        return researchedData;
    }

    public List<Data> researchAmbiente(String ambiente, List<Data> currentContent) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : currentContent) {
            if (data.getAmbiente().get(ambiente) != null && data.getAmbiente().get(ambiente))
                researchedData.add(data);
        }

        return researchedData;
    }

    public List<Data> researchLingua(String lingua, List<Data> currentContent) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : currentContent) {
            if (data.getLingua().get(lingua) != null && data.getLingua().get(lingua))
                researchedData.add(data);
        }

        return researchedData;
    }

    public List<Data> researchCodice(String codice, List<Data> currentContent) {
        List<Data> researchedData = new ArrayList<>();

        for (Data data : currentContent) {
            if (data.getCodice().equalsIgnoreCase(codice))
                researchedData.add(data);
        }

        return researchedData;
    }

    public Data researchRow(int row) {
        return fileContent.get(row);
    }
}