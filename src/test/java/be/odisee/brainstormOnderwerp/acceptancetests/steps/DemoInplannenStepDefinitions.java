package be.odisee.brainstormOnderwerp.acceptancetests.steps;
import io.cucumber.java.nl.Als;
import io.cucumber.java.nl.Gegeven;
import Klassen.*;
import io.cucumber.java.nl.Gegeven;
import io.cucumber.java.nl.Als;
import io.cucumber.java.nl.Dan;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DemoInplannenStepDefinitions {
    private Demo demo;


    @Gegeven("^er is een demo aangemaakt$")
    public void er_is_een_demo_aangemaakt() {
        demo = new Demo();
    }

    @Gegeven("^er is een ambassadeur geselecteerd voor de demo$")
    public void er_is_een_ambassadeur_geselecteerd_voor_de_demo() {
        demo.setAmbassadeur("Ambassadeur");
    }

    @Gegeven("^de demo is bevestigd door de ambassadeur$")
    public void de_demo_is_bevestigd_door_de_ambassadeur() {
        demo.setAmbassadeur("Ambassadeur");
        demo.confirmeer();
    }

    @Als("^ik een ambassadeur selecteer voor de demo$")
    public void ik_selecteer_een_ambassadeur_voor_de_demo() {
        demo.setAmbassadeur("Ambassadeur");
    }

    @Als("^de ambassadeur bevestigt dat hij de demo gaat geven$")
    public void de_ambassadeur_bevestigt_dat_hij_de_demo_gaat_geven() {
        demo.confirmeer();
    }

    @Als("^de ambassadeur weigert de demo te geven$")
    public void de_ambassadeur_weigert_de_demo_te_geven() {
        demo.weiger();
    }

    @Als("^de demo wordt uitgevoerd$")
    public void de_demo_wordt_uitgevoerd() {
        demo.voerUit();
    }

    @Dan("^zou de status van de demo \"([^\"]*)\" moeten zijn$")
    public void de_status_van_de_demo_moet_zijn(String verwachteStatus) {
        assertEquals(verwachteStatus, demo.getStatus().toString());
    }
}
