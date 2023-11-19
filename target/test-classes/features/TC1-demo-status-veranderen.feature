# language: nl

Functionaliteit: De status bij het inplannen van een demo veranderen voor het scenario dat de ambassadeur weigert

  Voor een demo moet een ambassadeur geselecteerd worden, die weigert en er moet dus een nieuwe gevonden worden.

  Op een demo dat aangemaakt is kan een ambassadeur worden gezet.
  Zodra ambassadeur weigert moet er opnieuw een ambassadeur gekozen worden.

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
    Wanneer de ambassadeur weigert de demo te geven
    Dan zou de status van de demo "KIEZEN" moeten zijn