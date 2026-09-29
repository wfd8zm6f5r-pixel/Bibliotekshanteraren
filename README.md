# Bibliotekshanteraren

Bibliotekshanteraren är ett enkelt konsoprogram i Java för att hantera böcker, medlemer och lån.

## Funktioner

- Lägga till böcker
- Registrera medlemmar
- Låna böcker
- Lämna tillbaka böcker
- Söka efter böcker
- Visa alla böcker och deras  status

## Struktur

Programmet använder fasta arrayer för att lagra böcker och medlemmer.
Klassen `Library` hanterar böcker, medlemmar och lån.

`Book` är en record eftersom bokens ISBN, titel och författaren inte behöver ändras.

`Member` är en vanlig klass eftersom antalet aktiva lån kan ändras.

## Reflektion

Jag valde att använda en record för `Book` eftersominformation om en bok inte behöver ändras efter att boken har skapats.
Jag använde en vanlig klass för `Member` eftersom antalet aktiva lån behöver kunna ändras.
Jag använde fasta arrayer eftersom uppgiften ska lösas utan Collections Framwork.
Programmet kontrollerar felaktig inmatning så att det inte krachar när användaren skriver ett ogiltigt värde.

## Köra programmet

Programmet körs genom `Main.java`.

