package Klassen;

import Klassen.Status;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;


public class Demo implements Serializable {
    // Fields
    private static final long serialVersionUID = 1L;
    private int id;
    private String naam;
    private String adres;
    private Status status;
    private String ambassadeur;
    private LocalDateTime datum;

    // Constructors
    public Demo(){
        status = Status.KIEZEN;
    }

    public Demo(String naam, String adres) {
        this();
        this.naam = naam;
        this.adres = adres;
    }
    public Demo(String naam, String adres, LocalDateTime datum ) {
        this();
        this.naam = naam;
        this.adres = adres;
        this.datum = datum;
    }

    public Demo(int id, String naam, String adres, String status, LocalDateTime datum) {
        this();
        this.id = id;
        this.naam = naam;
        this.adres = adres;
        if (checkDatumAvailability( datum)){
            this.datum = datum;
        }
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getAdres() {
        return adres;
    }

    public Status getStatus() {
        return status;
    }
    public LocalDateTime getDatum() {
        return datum;
    }
    public String getAmbassadeur() {
        return ambassadeur;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public void getDatums(LocalDateTime datum) {
        if (checkDatumAvailability( datum)){
            this.datum = datum;
        }
    }

    // Methods
    public boolean checkDatumAvailability(LocalDateTime datum)
    {
        //LocalDateTime now = datum
        LocalDateTime now = LocalDateTime.now(); // verbeterd

        // Check of het in het verleden is, voor dit moment zelf
        if (datum.isBefore(now)) {
            throw new IllegalArgumentException("Foutmelding: De datum en tijd moet in de toekomst liggen.");
        }

        // Check of het in de zomervakantiegepland is,Juli of Augustus
        if (datum.getMonth() == Month.JULY || datum.getMonth() == Month.AUGUST) {
            throw new IllegalArgumentException("Foutmelding: De datum moet tijdens het schooljaar vallen, niet tijdens een schoolvakantie.");
        }

        // Check of het tijdens het weekend is, zaterdag of zondag
        DayOfWeek dayOfWeek = datum.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            throw new IllegalArgumentException("Foutmelding: De datum mag niet in het weekend vallen.");
        }

        // Check of het tussen standaard schooluren is
        int hour = datum.getHour();
        if (hour < 8 || hour >= 16) { // verbeterd van if (hour <= 8 || hour >= 16)
            throw new IllegalArgumentException("Foutmelding: De uren moeten tussen 8u en 16u liggen.");
        }

        System.out.println("Klassen.Demo is ingepland");
        return true;
    }

    public int berekenAantalAmbassadeurs(int deelnemers) throws IllegalArgumentException {
        int ambassadeurs = 0;

        if( deelnemers <= 0 ) { // Moet kleiner of gelijk zijn dan nul, deelnemers <= 0
            throw new IllegalArgumentException("Aantal deelnemers moet mininaal 1 zijn");
        } else if (deelnemers <= 20) {
            ambassadeurs = 1;
        }else if (deelnemers <= 40) {
            ambassadeurs = 2;
        }else if (deelnemers <= 60) { // Moet kleiner of gelijk zijn dan 60, deelnemers <= 60
            ambassadeurs = 3;
        } else{
            throw new IllegalArgumentException("Aantal deelnemers moet maximaal 60 zijn");
        }
        return ambassadeurs;
    }

    public Status setAmbassadeur(String ambassadeur)
    {
        if (status.getCode() == 1) {
            this.ambassadeur = ambassadeur;
            status = Status.WACHTEN;
        }
        return status;
    }
    public Status confirmeer()
    {
        if (status.getCode() == 2) {
            status = Status.Geconfirmeerd;
        }
        return status;
    }
    public Status weiger()
    {
        if (status.getCode() == 2) {
            this.ambassadeur = "";
            status = Status.KIEZEN;
        }
        return status;
    }
    public Status voerUit()
    {
        if (status.getCode() == 3) {
            status = Status.Uitgevoerd;
        }
        return status;
    }
}
