# language: nl

Functionaliteit: De status bij het inplannen van een demo veranderen voor het scenario dat een ambassadeur eerst heeft geweigerd, vervolgens door een andere is goedgekeurd

  Voor een demo moet een ambassadeur geselecteerd worden, die moet kiezen of hij confirmeert of weigert en moet de demo ten slotte uitvoeren.

  Op een demo dat aangemaakt is kan een ambassadeur worden gezet.
  Zodra ambassadeur weigert moet er opnieuw een ambassadeur gekozen worden, als die confirmeert moet de demo alleen nog uitgevoerd worden.
  Zodra de demo wordt uitgevoerd is hij gesloten.

  Achtergrond:
    Gegeven er is een demo aangemaakt

  Scenario: Een ambassadeur wordt geselecteerd voor de demo
    Wanneer ik een ambassadeur selecteer voor de demo
    Dan zou de status van de demo "WACHTEN" moeten zijn

  Scenario: De ambassadeur bevestigt dat hij de demo gaat geven
    Gegeven er is een ambassadeur geselecteerd voor de demo
    Wanneer de ambassadeur weigert de demo te geven
    Dan zou de status van de demo "KIEZEN" moeten zijn

  Scenario: Een ambassadeur wordt geselecteerd voor de demo
    Wanneer ik een ambassadeur selecteer voor de demo
    Dan zou de status van de demo "WACHTEN" moeten zijn

  Scenario: De ambassadeur bevestigt dat hij de demo gaat geven
    Gegeven er is een ambassadeur geselecteerd voor de demo
    Wanneer de ambassadeur bevestigt dat hij de demo gaat geven
    Dan zou de status van de demo "GECONFIRMEERD" moeten zijn

  Scenario: De ambassadeur weigert de demo te geven
    Gegeven er is een ambassadeur geselecteerd voor de demo
    Wanneer de ambassadeur weigert de demo te geven
    Dan zou de status van de demo "KIEZEN" moeten zijn

  Scenario: De demo wordt uitgevoerd
    Gegeven de demo is bevestigd door de ambassadeur
    Wanneer de demo wordt uitgevoerd
    Dan zou de status van de demo "UITGEVOERD" moeten zijn