# Progetto Sistemi e Reti
Un'applicazione Java client-server che permette l'analisi e la ricerca dei dati sulle strutture ricettive della regione veneto. La fruizione del servizio è disponibile sia tramite la console dell'IDE Java, che tramite l'interfaccia grafica realizzata mediante Swing.

## Funzionalità
- Connessione client-server (mediante Socket TCP).
- Varie tipologie di ricerca per analizzare i dati (disponibilità di ricerche filtrate).
- Interfaccia grafica con bottoni, aree di testo e un menu integrato.
- Possibilità di filtraggio delle ricerche: se si effettuano più ricerche consecutive senza premere il pulsante 'nuova         ricerca', i risultati verranno filtrati sulla base delle ricerche precedenti, e non considerati come indipendenti.

## Requisiti / Prerequisiti
- Una porta libera per permettere la comunicazione tra client e server (default: 1050).
- Java JDK 17 o una versione superiore.
- Un IDE per compilare il codice Java (es. Visual Studio Code, IntelliJ IDEA, ...).

## Istruzioni d'uso per attivazione server
1. Clonare la repository mediante il terminale, con il comando 'git clone https://github.com/21jxck/ProgettoSeR.git'.
2. Aprire la cartella del progetto tramite l'IDE.
3. Aprire ed mettere in esecuzione il file .java del server (Percorso: ProgettoSeR\ParteServer\MainServer.java).

## Istruzioni d'uso per attivazione client (da terminale)
1. Aprire e mettere in esecuzione il file .java del client (Percorso: ProgettoSeR\ParteClient\MainClient.java).
2. Per connettersi al server in esecuzione immettere nella console dell'IDE l'indirizzo IP e numero di porta del server.
3. Per effettuare le ricerche si utilizzino i comandi predisposti dal protocollo. Per maggiori informazioni consultare la relazione oppure inserire il carattere '?' e premere invio.

## Istruzioni d'uso per attivazione client (GUI)
1. Aprire e mettere in esecuzione il file .java dell'interfaccia grafica del client (Percorso: ProgettoSeR\ParteClient\Menu.java).
2. Comparirà un menù con due bottoni, premere il bottone denominato 'Connetti' per connettersi al server.
3. Immettere poi nelle apposite caselle l'indirizzo IP e il numero di porta del server.
4. Uscirà poi una finestra con un bottone per la disconnessione, un menù a tendina con le varie ricerche, uno spazio per inserire la parola chiave, un bottone per iniziare la ricerca e un bottone per ricominciare le ricerche.

## Struttura del progetto
Parte Server:
- MainServer.java: classe che avvia il server e gestisce i socket.
- CSVReader.java: classe che si occupa di leggere i dati dal file CSV e implementa i metodi di ricerca.
- ServerThreads.java: classe che gestisce il flusso di messaggi tra server e client.
- Data.java: Classe che comprende tutti gli attributi di un singolo dato del file CSV.

Parte Client:
- MainClient.java: classe che gestisce le richieste del client verso il server.
- Menu.java: classe che si occupa del menu e dei bottoni 'Connetti' ed 'Esci'.
- GUIClient.java: classe che comprende la finestra per la ricerca dei dati.

## Note 
- Assicurarsi che il server sia in esecuzione quando si tenta la connessione con i client.
- Per la ricerca 'ALL' la casella di testo nella GUI deve rimanere vuota. Invece con la ricerca 'GET_ROW' si deve inserire     un numero intero.
- Attualmente vi è un bug nella GUI: premendo solo una volta il bottone non si avvia la ricerca, bisogna premerlo più volte (questo anche con il tasto 'nuova ricerca'.

## Autore
Jacopo Olivo 4IB
Sistemi e Reti 2024/25
Itis C. Zuccante
