#Op1 registrazione di un nuovo utete
INSERT INTO UTENTI (IdUtente, Nome, Cognome, DataDiNascita, Sesso, FotoProfilo, Biografia, Res_Citta, Res_Provincia, Peso, Altezza)
VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);

#Op2 svolgimento attivita ciclismo
#prima bisogna inserire un percorso, supponiamo idpercorso=45
INSERT INTO PERCORSI (IdPercorso, Descrizione, Traccia, Nome)
VALUE (45, ?, ?, ?);
#poi inserisco attivita: 3 è ciclismo 
INSERT INTO ATTIVITA (IdSport, IdAttivita, IdPercorso, Titolo, Visibilita, Giorno, Distanza, TempoMovimento, VelocitaMedia, CalorieBruciate, Likes, IdUtente, DislivelloPositivo, DislivelloNegativo, AltitudineMax)
VALUE (?, (SELECT IdSport
FROM SPORT
WHERE Nome='Ciclismo'), 45, ?, ?, now(), ?, ?, ?, ?, ?, ?, ?, ?, ?);

#eventuali segemnti percorsi, mantengo 3 per ciclismo, poi il secondo valore deve essere coerente con idattivita di quella inserita
INSERT INTO SEGMENTI_PERCORSI 
VALUES (3, ?, ?, ?, ?),(3, ?, ?, ?, ?)...;

#Op3 scrittura di un commento da utente con id 16
INSERT INTO COMMENTI (IdSport, IdAttivita, IdCommento, Testo, Likes, IdUtente)
VALUE (?, ?, ?, ?, 0, 16);

#Op4 inserimento di una scarpa, dato idUtente=24
INSERT INTO SCARPE (IdUtente, Modello, Nickname, IdMarca)
VALUE (24, ?, ?, ?);

#Op5 assegnazione riconoscimento a id utente 24, se nessun utente ha ancora percorso il segmento con id 230
INSERT INTO RICONOSCIMENTI_UTENTI (IdUtente, IdSegmento, IdRiconoscimento)
VALUE (24, 230, 1);
#se invece é già presente un utente, e il tempo del nuovo inserimento è il primo (in questo caso KOM)
SELECT A.IdUtente
FROM SEGMENTI_PERCORSI SP, ATTIVITA A
WHERE A.IdSport=SP.IdSport
AND A.IdAttivita=SP.IdAttivita
AND SP.IdSegmento=20
ORDER BY SP.TempoPercorrenza
LIMIT 1;
#Allora posso aggiornare il riconoscimento
UPDATE RICONOSCIMENTI_UTENTI
SET IdUtente=24
where IdSegmento=230
and IdRiconoscimento=1;

#Op6 Visualizzare tutte le attivita dei seguiti da un utente, incluso percorso e sport
SELECT U1.Nome, A.*, S.Nome Sport, P.Nome NomePercorso
FROM UTENTI U, FOLLOW F, UTENTI U1, ATTIVITA A, PERCORSI P, SPORT S
WHERE F.IdUtente=U.IdUtente
AND U1.IdUtente=F.Seg_IdUtente
AND U1.IdUtente=A.IdUtente
AND A.IdPercorso=P.IdPercorso
AND A.IdSport=S.IdSport
AND A.Visibilita=true
AND U.IdUtente=?;

#Op7 Visualizzazione utente con il migliore tempo su un segmento
#utilizzo la stessa query utilizzara per Op5
SELECT A.IdUtente
FROM SEGMENTI_PERCORSI SP, ATTIVITA A
WHERE A.IdSport=SP.IdSport
AND A.IdAttivita=SP.IdAttivita
AND SP.IdSegmento=?
ORDER BY SP.TempoPercorrenza
LIMIT 1;

#Op8 attivita di nuoto svolte in estate
SELECT A.*
FROM ATTIVITA A, SPORT S
WHERE A.IdSport=S.IdSport
AND S.Nome='Nuoto'
AND month()(A.Giorno) BETWEEN 7 AND 9;

#Op9 Distanza totale percorsa in un anno da un utetnte
SELECT U.IdUtente, U.Nome, sum(A.Distanza) DistanzaAnnuale
FROM ATTIVITA A, UTENTI U
WHERE U.IdUtente=A.IdUtente
AND U.IdUtente=?
AND year(A.Giorno)=year(now())
GROUP BY U.IdUtente, U.Nome;

#Op10 Migliori prestazioni su tutti i segmenti di un utente
SELECT A.IdUtente, SP.IdSegmento, S.Nome, min(SP.TempoPercorrenza) TempoMinimo, count(SP.TempoPercorrenza) NumVoltePercorso
FROM ATTIVITA A, SEGMENTI_PERCORSI SP, SEGMENTI S
WHERE A.IdSport=SP.IdSport
AND A.IdAttivita=SP.IdAttivita
AND S.IdSegmento=SP.IdSegmento
AND A.IdUtente=3
GROUP BY SP.IdSegmento, A.IdUtente, S.Nome
ORDER BY A.IdUtente;
