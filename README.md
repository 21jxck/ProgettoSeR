# English Version:

# Systems and Networks Project  
A Java client-server application that allows analysis and searching of data about hospitality facilities in the Veneto region. The service can be accessed either through the Java IDE console or via the graphical interface built with Swing.

## Features  
- Client-server connection (via TCP Socket).  
- Various types of search to analyze the data (filtered searches available).  
- Graphical interface with buttons, text areas, and an integrated menu.  
- Search filtering: if multiple searches are performed consecutively without pressing the `nuova ricerca` button, the results will be filtered based on previous searches, and not treated as independent.

## Requirements / Prerequisites  
- A free port to allow communication between client and server (default: 1050).  
- Java JDK 17 or higher.  
- An IDE to compile the Java code (e.g., Visual Studio Code, IntelliJ IDEA, ...).

## Server Activation Instructions  
1. Clone the repository via terminal using the command `git clone https://github.com/21jxck/ProgettoSeR.git`.  
2. Open the project folder using the IDE.  
3. Open and run the server `.java` file (Path: `ProgettoSeR\ParteServer\MainServer.java`).

## Client Activation Instructions (from terminal)  
1. Open and run the client `.java` file (Path: `ProgettoSeR\ParteClient\MainClient.java`).  
2. To connect to the running server, enter the server’s IP address and port number in the IDE console.  
3. To perform searches, use the commands provided by the protocol. For more information, consult the documentation or enter `?` and press enter.

## Client Activation Instructions (GUI)  
1. Open and run the client graphical interface `.java` file (Path: `ProgettoSeR\ParteClient\Menu.java`).  
2. A menu with two buttons will appear. Click the button labeled `Connetti` to connect to the server.  
3. Enter the server’s IP address and port number into the appropriate fields.  
4. A new window will open with a disconnect button, a dropdown menu with the various searches, a space to enter the keyword, a button to start the search, and a button to restart searches.

## Project Structure  
**Server Side:**  
- `MainServer.java`: class that starts the server and manages sockets.  
- `CSVReader.java`: class that reads data from the CSV file and implements search methods.  
- `ServerThreads.java`: class that handles the message flow between server and client.  
- `Data.java`: class that includes all the attributes of a single data entry from the CSV file.

**Client Side:**  
- `MainClient.java`: class that manages client requests to the server.  
- `Menu.java`: class that handles the menu and the `Connetti` and `Esci` buttons.  
- `GUIClient.java`: class that includes the window for data searching.

## Notes  
- Make sure the server is running when trying to connect with clients.  
- For the `ALL` search, the text field in the GUI must remain empty. For the `GET_ROW` search, you must enter an integer.  
- Currently, there is a bug in the GUI: clicking the button only once does not start the search—you need to click it multiple times (same for the `nuova ricerca` button).

## Author  
Jacopo Olivo 4IB  
Systems and Networks 2024/25  
Itis C. Zuccante


# Italian Version:

# Progetto Sistemi e Reti
Un'applicazione Java client-server che permette l'analisi e la ricerca dei dati sulle strutture ricettive della regione veneto. La fruizione del servizio è disponibile sia tramite la console dell'IDE Java, che tramite l'interfaccia grafica realizzata mediante Swing.

## Funzionalità
- Connessione client-server (mediante Socket TCP).
- Varie tipologie di ricerca per analizzare i dati (disponibilità di ricerche filtrate).
- Interfaccia grafica con bottoni, aree di testo e un menu integrato.
- Possibilità di filtraggio delle ricerche: se si effettuano più ricerche consecutive senza premere il pulsante `nuova ricerca`, i risultati verranno filtrati sulla base delle ricerche precedenti, e non considerati come indipendenti.

## Requisiti / Prerequisiti
- Una porta libera per permettere la comunicazione tra client e server (default: 1050).
- Java JDK 17 o una versione superiore.
- Un IDE per compilare il codice Java (es. Visual Studio Code, IntelliJ IDEA, ...).

## Istruzioni d'uso per attivazione server
1. Clonare la repository mediante il terminale, con il comando `git clone https://github.com/21jxck/ProgettoSeR.git`.
2. Aprire la cartella del progetto tramite l'IDE.
3. Aprire ed mettere in esecuzione il file `.java` del server (Percorso: `ProgettoSeR\ParteServer\MainServer.java`).

## Istruzioni d'uso per attivazione client (da terminale)
1. Aprire e mettere in esecuzione il file `.java` del client (Percorso: `ProgettoSeR\ParteClient\MainClient.java`).
2. Per connettersi al server in esecuzione immettere nella console dell'IDE l'indirizzo IP e numero di porta del server.
3. Per effettuare le ricerche si utilizzino i comandi predisposti dal protocollo. Per maggiori informazioni consultare la relazione oppure inserire il carattere `?` e premere invio.

## Istruzioni d'uso per attivazione client (GUI)
1. Aprire e mettere in esecuzione il file `.java` dell'interfaccia grafica del client (Percorso: `ProgettoSeR\ParteClient\Menu.java`).
2. Comparirà un menù con due bottoni, premere il bottone denominato `Connetti` per connettersi al server.
3. Immettere poi nelle apposite caselle l'indirizzo IP e il numero di porta del server.
4. Uscirà poi una finestra con un bottone per la disconnessione, un menù a tendina con le varie ricerche, uno spazio per inserire la parola chiave, un bottone per iniziare la ricerca e un bottone per ricominciare le ricerche.

## Struttura del progetto
Parte Server:
- `MainServer.java`: classe che avvia il server e gestisce i socket.
- `CSVReader.java`: classe che si occupa di leggere i dati dal file CSV e implementa i metodi di ricerca.
- `ServerThreads.java`: classe che gestisce il flusso di messaggi tra server e client.
- `Data.java`: Classe che comprende tutti gli attributi di un singolo dato del file CSV.

Parte Client:
- `MainClient.java`: classe che gestisce le richieste del client verso il server.
- `Menu.java`: classe che si occupa del menu e dei bottoni `Connetti` ed `Esci`.
- `GUIClient.java`: classe che comprende la finestra per la ricerca dei dati.

## Note 
- Assicurarsi che il server sia in esecuzione quando si tenta la connessione con i client.
- Per la ricerca `ALL` la casella di testo nella GUI deve rimanere vuota. Invece con la ricerca `GET_ROW` si deve inserire un numero intero.
- Attualmente vi è un bug nella GUI: premendo solo una volta il bottone non si avvia la ricerca, bisogna premerlo più volte (questo anche con il tasto `nuova ricerca`).

## Autore
Jacopo Olivo 4IB
Sistemi e Reti 2024/25
Itis C. Zuccante
