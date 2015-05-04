# language: nl
  Functionaliteit: Bewaren (en weer ophalen) van een evenement

  Scenario: een nieuw evenement bewaren in de repository
    Gegeven een evenement "Zomerfeest 2015"
    En een beschikbare evementen repository
    Als het evenement bewaard wordt
    Dan verwacht ik als resultaat een nieuw evenement-id > 0

  Scenario: een bewaard evenement weer ophalen uit de repository
    Gegeven een beschikbare evenementen repository
    En een bewaard evenement "Zomerfeest 2015"
    Als het evenement wordt opgevraagd met het aangemaakte evenement-id
    Dan verwacht ik als resultaat een evenement met dezelfde inhoud als het bewaarde
