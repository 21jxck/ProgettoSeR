import java.util.*;

public class Data {
    public String comune;
    public String provincia;
    public String tipologia;
    public String categoria;
    public String numeroStelle;
    public String denominazione;
    public String indirizzo;
    public String cap;
    public String numTelefono;
    public String fax;
    public String postaElettronica;
    public String zona;
    public HashMap<String, Boolean> features;
    public HashMap<String, Boolean>  ambienti;
    public HashMap<String, Boolean> lingue;
    public String codice;

    public Data() {
        features = new HashMap<>();
        ambienti = new HashMap<>();
        lingue = new HashMap<>();
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setNumeroStelle(String numeroStelle) {
        this.numeroStelle = numeroStelle;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setPostaElettronica(String postaElettronica) {
        this.postaElettronica = postaElettronica;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public void setFeature(String feature, String presente) {
        this.features.put(feature, contenuto(presente));
    }

    public void setAmbiente(String ambiente, String presente) {
        this.ambienti.put(ambiente, contenuto(presente));
    }

    public void setLingua(String lingua, String presente) {
        this.lingue.put(lingua, contenuto(presente));
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Boolean contenuto(String presente) {
        if(presente.equalsIgnoreCase("Si")) return true;
        return false;
    }

    public String getComune() {
        return comune;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getTipologia() {
        return tipologia;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getNumeroStelle() {
        return numeroStelle;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCap() {
        return cap;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public String getFax() {
        return fax;
    }

    public String getPostaElettronica() {
        return postaElettronica;
    }

    public String getZona() {
        return zona;
    }

    public Map<String, Boolean> getFeature() {
        Map<String, Boolean> presentFeature = new HashMap<>();

        for(Map.Entry<String, Boolean> feature : features.entrySet()) {
            if(feature.getValue()) {
                presentFeature.put(feature.getKey(), feature.getValue());
            }
        }

        return presentFeature;
    }

    public Map<String, Boolean> getAmbiente() {
        Map<String, Boolean> presentAmbiente = new HashMap<>();

        for(Map.Entry<String, Boolean> ambiente : ambienti.entrySet()) {
            if(ambiente.getValue()) {
                presentAmbiente.put(ambiente.getKey(), ambiente.getValue());
            }
        }

        return presentAmbiente;
    }

    public Map<String, Boolean> getLingua() {
        Map<String, Boolean> presentLingua = new HashMap<>();

        for(Map.Entry<String, Boolean> lingua : lingue.entrySet()) {
            if(lingua.getValue()) {
                presentLingua.put(lingua.getKey(), lingua.getValue());
            }
        }

        return presentLingua;
    }

    public String getCodice() {
        return codice;
    }

    @Override
    public String toString() {
        String s = "===============================================================\n\r";
        s += tipologia + " " + denominazione;

        if(!numeroStelle.isEmpty()) {
            s += ", Stelle: " + numeroStelle;
        }

        if(!categoria.isEmpty()) {
            s += ", Categoria: " + categoria;
        }

        s += ", Codice identificativo: " + codice + "\n\rComune: " + comune +
                ", Provincia: " + provincia + ", Indirizzo: " + indirizzo +
                ", CAP: " + cap + ", Zona: " + zona + "\n\r";

        if(!numTelefono.isEmpty()) {
            s += "Numero di telefono: " + numTelefono ;
        }
        if(!fax.isEmpty()) {
            s += ", Fax: " + fax ;
        }
        if(!postaElettronica.isEmpty()) {
            s += ", Posta elettronica: " + postaElettronica;
        }
        s += "\n\rFeatures: ";

        String featuresPresenti = "";
        for (int i = 0; i < (CSVReader.costantFeatureKey.size() / 2); i++) {
            if (features.containsKey(CSVReader.costantFeatureKey.get(i)) &&
                    Boolean.TRUE.equals(features.get(CSVReader.costantFeatureKey.get(i)))) {
                featuresPresenti += CSVReader.costantFeatureKey.get(i) + " ";
            }
        }

        String ambientiPresenti = "";
        for (int i = 0; i < (CSVReader.costantAmbientKey.size() / 2); i++) {
            if (ambienti.containsKey(CSVReader.costantAmbientKey.get(i)) &&
                    Boolean.TRUE.equals(ambienti.get(CSVReader.costantAmbientKey.get(i)))) {
                ambientiPresenti += CSVReader.costantAmbientKey.get(i) + " ";
            }
        }

        String linguePresenti = "";
        for (int i = 0; i < (CSVReader.costantLanguageKey.size() / 2); i++) {
            if (lingue.containsKey(CSVReader.costantLanguageKey.get(i)) &&
                    Boolean.TRUE.equals(lingue.get(CSVReader.costantLanguageKey.get(i)))) {
                linguePresenti += CSVReader.costantLanguageKey.get(i) + " ";
            }
        }

        if(featuresPresenti.isEmpty()) {
            featuresPresenti = "nessuna.";
        }

        if(ambientiPresenti.isEmpty()) {
            ambientiPresenti = "niente.";
        }

        if(linguePresenti.isEmpty()) {
            linguePresenti = "nessuna.";
        }
        s += featuresPresenti + "\n\rAmbiente circostante: " + ambientiPresenti + "\n\rLingue straniere parlate: " + linguePresenti + "\n\r";

        return s + "===============================================================\n\r";
    }
}