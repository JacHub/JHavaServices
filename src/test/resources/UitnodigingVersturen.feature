# language: nl
Functionaliteit: Versturen van een uitnodiging van een evenement naar een lijst van genodigden

  Scenario: uitnodiging voor een evenement versturen naar lijst van genodigden
    Gegeven een evenement "Zomerfeest 2015"
    En uitnodiging met de volgende beschrijving:
    """
    Kom je naar het zomerfeest?
    """
    En de volgende genodigden met emailadres:
      | a@test.com |
      | b@test.com |
    Als ik de uitnodiging verstuur
    Dan verwacht ik dat elke genodigde een uitnodiging ontvangt
