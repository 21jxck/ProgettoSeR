import java.util.HashMap;

public class Data {
    public String comune;
    public String provincia;
    public String tipologia;
    public String categoria;
    public String numeroStelle;
    public String denominazione;
    public String indirizzo;
    public String numeroCivico;
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

    public void setNumeroCivico(String numeroCivico) {
        this.numeroCivico = numeroCivico;
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
        if(presente.equalsIgnoreCase("Si")) {
            return true;
        }
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

    public String getNumeroCivico() {
        return numeroCivico;
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

    public String getCodice() {
        return codice;
    }
}
