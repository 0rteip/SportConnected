INSERT INTO UTENTI (IdUtente, Nome, Cognome, DataDiNascita, Sesso, FotoProfilo, Biografia, Res_Citta, Res_Provincia, Peso, Altezza)
VALUES
    (1, 'Alice', 'Rossi', '1990-05-15', 'F', 'alice.jpg', 'Sono Alice', 'Milano', 'MI', 60.5, 165),
    (2, 'Bob', 'Verdi', '1985-08-20', 'M', 'bob.jpg', 'Sono Bob', 'Roma', 'RM', 75.2, 180),
    (3, 'Charlie', 'Bianchi', '1992-03-10', 'M', NULL, NULL, NULL, NULL, 70.0, 175),
    (4, 'David', 'Gialli', '1988-12-05', 'M', 'david.jpg', 'Sono David', 'Napoli', 'NA', 68.0, 175),
    (5, 'Eve', 'Neri', '1995-07-30', 'F', 'eve.jpg', 'Sono Eve', 'Palermo', 'PA', NULL, 160),
    (6, 'Frank', 'Rosa', '1980-10-12', 'M', NULL, 'Sono Frank', 'Firenze', 'FI', 82.3, NULL),
    (7, 'Grace', 'Marroni', '1986-06-25', 'F', 'grace.jpg', NULL, 'Napoli', 'NA', NULL, 170),
    (8, 'Helen', 'Azzurri', '1993-09-18', 'F', 'helen.jpg', 'Sono Helen', NULL, NULL, 59.8, 155),
    (9, 'Ivan', 'Arancioni', '1998-04-03', 'M', 'ivan.jpg', 'Sono Ivan', 'Milano', 'MI', NULL, NULL),
    (10, 'Jennifer', 'Verdi', '1983-02-28', 'F', NULL, 'Sono Jennifer', 'Roma', 'RM', 68.7, 167),
    (11, 'Kevin', 'Gialli', '1991-11-08', 'M', 'kevin.jpg', 'Sono Kevin', 'Napoli', 'NA', 75.5, 180),
    (12, 'Laura', 'Neri', '1996-01-14', 'F', 'laura.jpg', 'Sono Laura', 'Palermo', 'PA', 55.2, NULL),
    (13, 'Mike', 'Rosa', '1987-07-22', 'M', 'mike.jpg', 'Sono Mike', 'Firenze', 'FI', NULL, 175),
    (14, 'Nina', 'Marroni', '1990-03-04', 'F', 'nina.jpg', 'Sono Nina', 'Napoli', 'NA', 63.0, NULL),
    (15, 'Oliver', 'Azzurri', '1994-06-09', 'M', NULL, NULL, NULL, NULL, 80.1, 190),
    (16, 'Patricia', 'Arancioni', '1989-08-17', 'F', 'patricia.jpg', 'Sono Patricia', 'Milano', 'MI', 70.9, 172);

INSERT INTO TIPOLOGIE (IdTipologia, Nome, Descrizione)
VALUES
    (1, 'Mountain Bike', 'MTB per percorsi fuoristrada'),
    (2, 'Bicicletta da Strada', 'Bici per strade asfaltate'),
    (3, 'Triathlon', 'Bici per competizioni di triathlon'),
    (4, 'Gravel Bike', 'Versatile su strada e fuoristrada'),
    (5, 'Corsa con Cross', 'Bici per gare di cross-country');

INSERT INTO SPORT (IdSport, Nome)
VALUES
    (1, 'Corsa'),
    (2, 'Nuoto'),
    (3, 'Ciclismo');

INSERT INTO MARCHE (IdMarca, Nome)
VALUES
    (1, 'Nike'),
    (2, 'Adidas'),
    (3, 'New Balance'),
    (4, 'Asics'),
    (5, 'Brooks'),
    (6, 'Saucony'),
    (7, 'Mizuno'),
    (8, 'Salomon'),
    (9, 'Under Armour'),
    (10, 'Hoka One One'),
    (11, 'Reebok'),
    (12, 'Puma'),
    (13, 'On Running'),
    (14, 'Altra'),
    (15, 'Merrell'),
    (16, 'Topo Athletic'),
    (17, 'Skechers'),
    (18, 'Inov-8'),
    (19, 'Karhu'),
    (20, 'Newton Running');
    
-- Inserimento di alcune scarpe per utenti specifici
INSERT INTO SCARPE (IdUtente, Modello, Nickname, IdMarca)
VALUES
    (1, 'Air Zoom Pegasus 38', 'Pegasus38-Nike', 1),     -- Utente 1 con marca Nike
    (8, 'Ultraboost 21', 'Ultraboost21-Adidas', 2),     -- Utente 2 con marca Adidas
    (3, 'Fresh Foam 1080v11', 'FreshFoam1080v11-NewBalance', 3),  -- Utente 3 con marca New Balance
    (16, 'GEL-Kayano 27', 'Kayano27-Asics', 4),          -- Utente 4 con marca Asics
    (5, 'Ghost 14', 'Ghost14-Brooks', 5);               -- Utente 5 con marca Brooks
    
-- Inserimento di alcune biciclette con nomi di modello appropriati
INSERT INTO BICICLETTE (IdUtente, Modello, Nickname, IdTipologia)
VALUES
    (6, 'Trek X-Caliber 9', 'XCaliber9-Trek', 1),        -- Utente 1 con tipologia Mountain Bike
    (8, 'Specialized Roubaix', 'Roubaix-Specialized', 2), -- Utente 2 con tipologia Bicicletta da Strada
    (10, 'Cannondale SuperSix EVO', 'SuperSixEVO-Cannondale', 3),  -- Utente 3 con tipologia Bicicletta da Corsa
    (3, 'Giant TCX Advanced Pro', 'TCXAdvancedPro-Giant', 4),     -- Utente 4 con tipologia Gravel Bike
    (15, 'Scott Spark RC 900', 'SparkRC900-Scott', 5);           -- Utente 5 con tipologia Corsa con Cross


-- Popolamento della tabella FOLLOW con almeno due utenti seguiti per ogni utente
INSERT INTO FOLLOW (Seg_IdUtente, IdUtente)
VALUES
    (1, 2),
    (1, 3),
    (2, 1),
    (2, 3),
    (3, 1),
    (3, 2),
    (4, 5),
    (4, 6),
    (5, 4),
    (5, 6),
    (6, 4),
    (6, 5),
    (7, 8),
    (7, 9),
    (8, 7),
    (8, 9),
    (9, 7),
    (9, 8),
    (10, 11),
    (10, 12),
    (11, 10),
    (11, 12),
    (12, 10),
    (12, 11),
    (13, 14),
    (13, 15),
    (14, 13),
    (14, 15),
    (15, 13),
    (15, 14),
    (16, 1),
    (16, 2),
    (1, 16),
    (2, 16);

-- Inserimento di riconoscimenti assegnabili a una persona su un segmento
INSERT INTO RICONOSCIMENTI (Nome, IdRiconoscimento)
VALUES
    ('Re della Montagna (KOM)', 1),
    ('Sprint King', 2),
    ('Gran Fondo Finisher', 3),
    ('Record Personale', 4),
    ('Sfida Completata', 5),
    ('Master del Segmento', 6),
    ('100 Miglia Master', 7),
    ('Campione del Segmento', 8);

INSERT INTO PERCORSI (IdPercorso, Descrizione, Traccia, Nome)
VALUES
    (1, 'Percorso panoramico', 'percorso_panoramico.gpx', 'Panorama Trail'),
    (2, 'Corsa in città', 'corsa_in_citta.gpx', 'Urban Run'),
    (3, 'Escursione in montagna', 'escursione_montagna.gpx', 'Mountain Hike'),
    (4, 'Cicloturismo costiero', 'cicloturismo_costiero.gpx', 'Coastal Cycling'),
    (5, 'Trail running nel bosco', 'trail_running_bosco.gpx', 'Forest Trail Run');

-- Inserimento di dati nella tabella PERCORSI (compresi gli inserimenti precedenti)
INSERT INTO PERCORSI (IdPercorso, Descrizione, Traccia, Nome)
VALUES
    (1, 'Percorso panoramico', 'percorso_1.gpx', 'Panorama Trail'),
    (2, 'Salita in città', 'percorso_2.gpx', 'Urban Cycling'),
    (3, 'Escursione in montagna', 'percorso_3.gpx', 'Mountain Hike'),
    (4, 'Sui colli', 'percorso_4.gpx', 'Hill Cycling'),
    (5, 'Trail running nel bosco', 'percorso_5.gpx', 'Forest Trail Run'),
    (6, 'Passeggiata sul lungomare', 'percorso_6.gpx', 'Lungomare Scenic Walk'),
    (7, 'Cicloturismo tra i vigneti', 'percorso_7.gpx', 'Vineyard Cycling Tour'),
    (8, 'Escursione al lago', 'percorso_8.gpx', 'Lake Hike Adventure'),
    (9, 'Corsa in montagna', 'percorso_9.gpx', 'Mountain Trail Run'),
    (10, 'Veloce come un costiero', 'percorso_10.gpx', 'Coastal Cycling Adventure'),
    (11, 'Passeggiata in città', 'percorso_11.gpx', 'City Stroll'),
    (12, 'Nuotata pomeridiana', 'percorso_12.gpx', 'Afternoon Swim'),
    (13, 'Escursione tra i boschi', 'percorso_13.gpx', 'Woodland Hiking'),
    (14, 'Cicloturismo in campagna', 'percorso_14.gpx', 'Countryside Cycling'),
    (15, 'Corsa sul lungomare', 'percorso_15.gpx', 'Seaside Run'),
    (16, 'Escursione al tramonto', 'percorso_16.gpx', 'Sunset Hike'),
    (17, 'Escursione tra le colline', 'percorso_17.gpx', 'Hillside Hike'),
    (18, 'Galleggiamento al mare', 'percorso_18.gpx', 'Sea Floating'),
    (19, 'Corsa nel parco cittadino', 'percorso_19.gpx', 'City Park Run'),
    (20, 'Passeggiata sulle rive del fiume', 'percorso_20.gpx', 'Riverside Stroll'),
    (21, 'Escursione sulle montagne innevate', 'percorso_21.gpx', 'Snowy Mountain Hike'),
    (22, 'Giro tra le valli', 'percorso_22.gpx', 'Valley Cycling Adventure'),
    (23, 'Trail running nella foresta pluviale', 'percorso_23.gpx', 'Rainforest Trail Run'),
    (24, 'Passeggiata serale in città', 'percorso_24.gpx', 'Evening City Walk'),
    (25, 'Nuoto in compagnia', 'percorso_25.gpx', 'Swim With Friends'),
    (26, 'Giro sui monti', 'percorso_26.gpx', 'Mountain Cycling Tour'),
    (27, 'Corsa al tramonto', 'percorso_27.gpx', 'Sunset Run'),
    (28, 'Passeggiata nel parco nazionale', 'percorso_28.gpx', 'National Park Walk'),
    (29, 'Cicloturismo sulle strade di campagna', 'percorso_29.gpx', 'Country Road Cycling'),
    (30, 'Controcorrente', 'percorso_30.gpx', 'River Swim'),
    (31, 'Trail running tra le dune', 'percorso_31.gpx', 'Dunes Trail Run'),
    (32, 'In sella attraverso le foreste', 'percorso_32.gpx', 'Forest Cycling Adventure'),
    (33, 'Corsa in montagna avanzata', 'percorso_33.gpx', 'Advanced Mountain Run'),
    (34, 'Non mollo', 'percorso_34.gpx', 'Hard Swim'),
    (35, 'Escursione sulle scogliere', 'percorso_35.gpx', 'Cliffside Hike'),
    (36, 'Cicloturismo sul lago', 'percorso_36.gpx', 'Lakeside Cycling Tour'),
    (37, 'Giro scarico', 'percorso_37.gpx', 'Unloading Cycling'),
    (38, 'Nella riserva naturale', 'percorso_38.gpx', 'Nature Reserve Cycling'),
    (39, 'Nuotate attraverso le gole', 'percorso_39.gpx', 'Canyon Swim'),
    (40, 'Cicloturismo tra i vigneti', 'percorso_40.gpx', 'Vineyard Cycling Tour');

    
INSERT INTO ATTIVITA (IdSport, IdAttivita, IdPercorso, Titolo, Visibilita, Giorno, Distanza, TempoMovimento, VelocitaMedia, CalorieBruciate, Likes, IdUtente, DislivelloPositivo, DislivelloNegativo, AltitudineMax, TempoVascaMinore)
VALUES
    (1, 1, 1, 'Percorso panoramico', True, '2023-09-01', 8000, 2700, 12.0, 450, 5, 1, 300, 200, 1200, null),
    (3, 15, 2, 'Salita in Citta', True, '2023-07-05', 12000, 4300, 11.37, 500, 6, 6, 420, 250, 950, null),
    (1, 3, 5, 'Trail running nel bosco', True, '2023-01-20', 10000, 3800, 9.87, 400, 7, 8, 320, 180, 780, null),
    (1, 4, 3, 'Escursione in montagna', True, '2023-09-01', 13000, 5000, 8.6, 600, 4, 3, 800, 300, 2200, null),
    (3, 1, 4, 'Sui colli', True, '2023-09-01', 11000, 3800, 9.56, 480, 1, 10, 390, 210, 1450, null),
    (1, 5, 6, 'Passeggiata sul lungomare' , True, '2023-09-01', 7000, 2700, 10.45, 350, 0, 16, 250, 150, 580, null),
    (3, 2, 7, 'Cicloturismo tra i vigneti' , True, '2023-09-01', 12000, 4200, 11.42, 520, 0, 8, 310, 190, 1100, null),
    (1, 6, 8, 'Escursione al lago' , True, '2023-09-01', 10000, 3600, 10.0, 500, 2, 1, 280, 160, 960, null),
    (1, 7, 9, 'Corsa in montagna', false, '2023-09-01', 14000, 5500, 8.8, 550, 6, 5, 660, 400, 2800, null),
    (3, 3, 10, 'Veloce come un costiero', True, '2023-09-01', 11000, 4000, 11.75, 490, 7, 15, 400, 240, 1400, null),
    (1, 8, 11, 'Passeggiata in città', True, '2023-09-01', 9000, 3200, 11.25, 430, 8, 3, 360, 210, 890, null),
    (2, 1, 12, 'Nuotata pomeridiana', True, '2023-09-01', 8000, 2700, 12.0, 350, 1, 9, null, null, null, 150),
    (3, 4, 13, 'Escursione tra i boschi', True, '2023-09-01', 9500, 3900, 9.87, 410, 4, 8, 300, 180, 740, null),
    (3, 5, 14, 'Cicloturismo in campagna', True, '2023-09-01', 11500, 4500, 10.2, 520, 2, 3, 360, 210, 1100, null),
    (1, 10, 15, 'Corsa sul lungomare', True, '2023-09-01', 7500, 3000, 10.0, 380, 1, 7, 250, 150, 580, null),
    (3, 6, 16, 'Escursione al tramonto', True, '2023-09-01', 8200, 3300, 10.5, 400, 7, 11, 290, 170, 820, null),
    (1, 12, 17, 'Escursione tra le colline', True, '2023-09-01', 9500, 3600, 10.75, 450, 4, 2, 310, 180, 1000, null),
    (2, 2, 18, 'Galleggiamento al mare', True, '2023-09-01', 6500, 2600, 9.8, 320, 5, 11, null, null, null, 130),
    (1, 13, 19, 'Corsa nel parco cittadino', True, '2023-09-01', 7300, 2800, 10.32, 370, 0, 8, 240, 140, 520, null),
    (1, 11, 20, 'Passeggiata sulle rive del fiume', True, '2023-09-01', 8500, 3300, 9.5, 420, 5, 5, 290, 170, 820, null),
    (1, 9, 21, 'Escursione sulle montagne innevate', True, '2023-09-01', 10500, 4100, 9.76, 550, 6, 13, 480, 290, 1600, null),
    (3, 7, 22, 'Giro tra le valli', True, '2023-09-01', 9800, 3800, 9.85, 470, 7, 15, 300, 180, 950, null),
    (1, 14, 23, 'Trail running nella foresta pluviale', True, '2023-09-01', 8800, 3600, 10.32, 420, 4, 14, 290, 170, 790, null),
    (1, 15, 24, 'Passeggiata serale in città', True, '2023-09-01', 7700, 2900, 10.03, 360, 8, 9, 250, 150, 580, null),
    (2, 3, 25, 'Nuoto in compagnia', True, '2023-09-01', 8300, 2700, 12.0, 350, 2, 9, null, null, null, 150),
    (3, 8, 26, 'Giro sui monti', True, '2023-09-01', 9300, 3500, 10.1, 480, 3, 4, 340, 200, 1200, null),
    (1, 16, 27, 'Corsa al tramonto', False, '2023-09-01', 7000, 2600, 10.5, 320, 5, 1, 230, 140, 480, null),
    (1, 17, 28, 'Passeggiata nel parco nazionale', True, '2023-09-01', 10500, 4000, 10.2, 500, 0, 7, 320, 190, 1100, null),
    (3, 9, 29, 'Cicloturismo sulle strade di campagna', True, '2023-09-01', 12000, 4500, 10.5, 530, 5, 6, 360, 210, 950, null),
    (2, 6, 30, 'Controcorrente', True, '2023-09-01', 7500, 3000, 9.75, 380, 2, 2, null, null, null, 120),
    (1, 19, 31, 'Trail running tra le dune' , True, '2023-09-01', 8300, 3300, 9.7, 410, 4, 8, 280, 160, 780, null),
    (3, 10, 32, 'In sella attraverso le foreste', True, '2023-09-01', 9900, 3900, 10.0, 490, 1, 3, 300, 180, 950, null),
    (1, 2, 33, 'Corsa in montagna avanzata', True, '2023-09-01', 12500, 4800, 9.6, 580, 5, 16, 520, 310, 1800, null),
    (2, 4, 34, 'Non mollo', True, '2023-09-01', 6800, 2600, 10.5, 320, 4, 9, null, null, null, 130),
    (1, 18, 35, 'Escursione sulle scogliere', True, '2023-09-01', 9000, 3300, 9.87, 420, 3, 6, 310, 180, 950, null),
    (3, 11, 36, 'Cicloturismo sul lago', True, '2023-09-01', 11000, 4200, 11.42, 520, 3, 12, 320, 190, 1100, null),
    (3, 14, 37, 'Giro scarico', True, '2023-09-01', 8000, 2900, 10.03, 360, 6, 10, 250, 150, 580, null),
    (3, 13, 38, 'Nella riserva naturale', True, '2023-09-01', 7600, 2800, 10.32, 370, 0, 8, 240, 140, 520, null),
    (2, 5, 39, 'Nuotate attraverso le gole', True, '2023-09-01', 9200, 3600, 10.0, 450, 1, 11, null, null, null, 150),
    (3, 12, 40, 'Cicloturismo tra i vigneti', True, '2023-09-01', 10500, 4000, 10.2, 500, 4, 3, 360, 210, 1100, null);

UPDATE ATTIVITA
SET Giorno =
    CASE
        WHEN IdSport = 2 THEN
            DATE_ADD('2023-06-01', INTERVAL FLOOR(RAND() * 60) DAY)
        ELSE
            DATE_ADD('2023-04-01', INTERVAL FLOOR(RAND() * 183) DAY)
    END;


INSERT INTO CARATTERISTICHE_SEGMENTI (IdSport, IdCaratteristica, Descrizione)
VALUES
    (1, 1, 'Salita ripida'),
    (1, 2, 'Discesa veloce'),
    (1, 3, 'Pianura ventosa'),
    (1, 4, 'Salita lunga'),
    (1, 5, 'Discesa tecnica'),
    (2, 1, 'Nuoto in acque aperte'),
    (2, 2, 'Nuoto in piscina'),
    (3, 1, 'Salita ripida'),
    (3, 2, 'Salita fuoristrda'),
    (3, 3, 'Sentiero ghiaioso'),
    (3, 4, 'Discesa lunga'),
    (3, 5, 'Lungovalle');
    
INSERT INTO SALVATAGGI_PERCORSI (IdPercorso, IdUtente)
VALUES
    (12, 1),
    (5, 7),
    (3, 2),
    (13, 12),
    (5, 3),
    (13, 13),
    (36, 4),
    (16, 4),
    (9, 7),
    (34, 8);
    
    
INSERT INTO `COMMENTI` (`IdSport`, `IdAttivita`, `IdCommento`, `Testo`, `Likes`, `IdUtente`) VALUES
    (1, 1, 21, 'Percorso panoramico bellissimo!', 12, 5),
    (3, 15, 22, 'Salita in Citta faticosa ma gratificante.', 9, 3),
    (1, 3, 23, 'Trail running nel bosco, natura meravigliosa.', 7, 1),
    (1, 4, 24, 'Escursione in montagna emozionante!', 10, 2),
    (3, 1, 25, 'Sui colli, panorami spettacolari.', 6, 4),
    (1, 5, 26, 'Passeggiata sul lungomare rilassante.', 8, 5),
    (3, 2, 27, 'Cicloturismo tra i vigneti, ottimo vino in zona!', 11, 1),
    (1, 6, 28, 'Escursione al lago, pace e tranquillità.', 7, 3),
    (1, 7, 29, 'Corsa in montagna, sfida personale.', 5, 2),
    (3, 3, 30, 'Veloce come un costiero, adrenalina pura.', 9, 4);

INSERT INTO COMMENTI (IdSport, IdAttivita, IdCommento, Testo, Likes, IdUtente)
VALUES
    (1, 1, 1, 'Bel percorso!', 5, 2),
    (3, 15, 1, 'Che sfida! Complimenti!', 6, 4),
    (1, 3, 1, 'Il bosco è sempre un ottimo posto per correre.', 7, 3),
    (1, 4, 1, 'La montagna ti fa sentire libero.', 4, 1),
    (3, 1, 1, 'Scenari mozzafiato sui colli.', 1, 5),
    (1, 5, 1, 'Una passeggiata rilassante lungo il mare.', 16, 6),
    (3, 2, 1, 'I vigneti sono bellissimi in bici.', 8, 8),
    (1, 6, 1, 'Il lago era stupendo oggi.', 1, 1),
    (1, 7, 1, 'Corsa faticosa ma gratificante in montagna.', 5, 3),
    (3, 3, 1, 'Ho battuto tutti i record personali oggi.', 15, 2),
    (1, 8, 1, 'Una passeggiata tra le strade della città.', 3, 4),
    (2, 1, 1, 'Una nuotata rinfrescante in mare.', 9, 7),
    (3, 4, 1, 'Escursione nella foresta. La natura è meravigliosa.', 8, 6),
    (3, 5, 1, 'Cicloturismo tra campi verdi.', 3, 8),
    (1, 10, 1, 'Correre lungo il lungomare è fantastico.', 7, 2),
    (3, 6, 1, 'Escursione al tramonto con amici.', 11, 9),
    (1, 12, 1, 'Nuotata rilassante in piscina.', 9, 7),
    (3, 8, 1, 'Giro panoramico tra le montagne.', 4, 1),
    (1, 16, 1, 'Corsa al tramonto per chi ama la tranquillità.', 1, 5),
    (1, 17, 1, 'Passeggiata nel parco nazionale. Che bellezza!', 7, 6),
    (3, 9, 1, 'Cicloturismo nelle strade di campagna.', 6, 8),
    (2, 6, 1, 'Controcorrente in piscina.', 2, 4),
    (1, 19, 1, 'Trail running tra le dune.', 8, 3),
    (3, 10, 1, 'In sella tra le foreste. Avventura pura.', 3, 2),
    (1, 2, 1, 'Corsa avanzata in montagna. Allenamento intenso!', 16, 5),
    (2, 4, 1, 'Nuotata con determinazione in piscina.', 9, 7),
    (1, 18, 1, 'Escursione sulle scogliere. Vista mozzafiato.', 6, 8),
    (3, 11, 1, 'Cicloturismo lungo il lago. Giornata perfetta!', 12, 6),
    (3, 14, 1, 'Giro scarico in bici. Relax totale.', 10, 9),
    (3, 13, 1, 'Esplorazione nella riserva naturale.', 8, 4),
    (2, 5, 1, 'Nuotate emozionanti tra le gole.', 11, 7),
    (3, 12, 1, 'Cicloturismo tra i vigneti. Gusto e sport!', 3, 5);

-- Commenti per l'attività con IdSport 3 e IdAttivita 16
INSERT INTO COMMENTI (IdSport, IdAttivita, IdCommento, Testo, Likes, IdUtente)
VALUES
    (1, 5, 2, 'Bel Giro', 8, 11),
    (1, 5, 3, 'Prossima volta vengo', 6, 4),
    (1, 5, 4, 'Nice!!', 7, 8);

-- Commenti per l'attività con IdSport 1 e IdAttivita 12
INSERT INTO COMMENTI (IdSport, IdAttivita, IdCommento, Testo, Likes, IdUtente)
VALUES
    (2, 3, 1, 'Bel lavoro', 9, 16);

-- Commenti per l'attività con IdSport 2 e IdAttivita 18
INSERT INTO COMMENTI (IdSport, IdAttivita, IdCommento, Testo, Likes, IdUtente)
VALUES
    (2, 18, 1, 'Hai fatto un ottimo lavoro in mare!', 8, 1),
    (2, 18, 2, 'Mi piacerebbe unirmi a te la prossima volta.', 6, 2),
    (2, 18, 3, 'Ho bisogno di migliorare la mia resistenza.', 7, 3);
    
    
-- Inserimento di segmenti per il percorso 1 (Corsa)
INSERT INTO SEGMENTI (Visibilita, IdSegmento, Traccia, Nome, IdSport, IdCaratteristica)
VALUES
    (1, 1, 'segm_1.gpx', 'Salita Parco', 1, 1),
    (1, 2, 'segm_2.gpx', 'Discesa Lungofiume', 1, 2),
    (1, 3, 'segm_3.gpx', 'Pianura Parco', 1, 3),
    (1, 4, 'segm_4.gpx', 'Salita Collina', 1, 4),
    (1, 5, 'segm_5.gpx', 'Discesa Tecnica', 1, 5),
    (1, 6, 'segm_6.gpx', 'Pianura Centro Città', 1, 3),
    (1, 7, 'segm_7.gpx', 'Salita Montagna', 1, 4),
    (1, 8, 'segm_8.gpx', 'Discesa Panoramica', 1, 2),
    (1, 9, 'segm_9.gpx', 'Salita Ponte', 1, 1),
    (1, 10, 'segm_10.gpx', 'Lungovalle Rubicone', 1, 3),
    (1, 11, 'segm_11.gpx', 'Salita Collina Vista Mare', 1, 4),
    (1, 12, 'segm_12.gpx', 'Discesa Collina Vista Mare', 1, 2),
    (1, 13, 'segm_13.gpx', 'Pianura Parco del Lago', 1, 3),
    (1, 14, 'segm_14.gpx', 'Salita Monte Ventoso', 1, 1),
    (1, 15, 'segm_15.gpx', 'Discesa Tecnica Bosco', 1, 5),
    (1, 16, 'segm_16.gpx', 'Salita Montagna Boscosa', 1, 4),
    (1, 17, 'segm_17.gpx', 'Pianura Lungofiume', 1, 3),
    (1, 18, 'segm_18.gpx', 'Salita Collina Bosco', 1, 1),
    (1, 19, 'segm_19.gpx', 'Discesa Lungomare', 1, 2),
    (1, 20, 'segm_20.gpx', 'Pianura Campagna', 1, 3);
    -- Altri segmenti per il percorso 1...;

-- Inserimento di segmenti per il percorso 2 (Nuoto)
INSERT INTO SEGMENTI (Visibilita, IdSegmento, Traccia, Nome, IdSport, IdCaratteristica)
VALUES
    (1, 21, 'segm_21.gpx', 'Nuoto Lungolago', 2, 1),
    (1, 22, 'segm_22.gpx', 'Nuoto Piscina Olimpionica', 2, 2),
    (1, 23, 'segm_23.gpx', 'Nuoto Acque Libere', 2, 1),
    (1, 24, 'segm_24.gpx', 'Nuoto Fiume', 2, 1),
    (1, 25, 'segm_25.gpx', 'Nuoto Mare', 2, 1),
    (1, 26, 'segm_26.gpx', 'Nuoto Canale', 2, 1),
    (1, 27, 'segm_27.gpx', 'Nuoto Lago', 2, 1),
    (1, 28, 'segm_28.gpx', 'Nuoto Corsia', 2, 2),
    (1, 29, 'segm_29.gpx', 'Nuoto Incontro', 2, 1),
    (1, 30, 'segm_30.gpx', 'Nuoto Lungomare', 2, 1),
    (1, 31, 'segm_31.gpx', 'Nuoto Piscina Comunale', 2, 2),
    (1, 32, 'segm_32.gpx', 'Nuoto Acque Tranquille', 2, 1),
    (1, 33, 'segm_33.gpx', 'Nuoto Discesa Fiume', 2, 1),
    (1, 34, 'segm_34.gpx', 'Nuoto Lungofiume', 2, 1),
    (1, 35, 'segm_35.gpx', 'Nuoto Lungolago', 2, 1),
    (1, 36, 'segm_36.gpx', 'Nuoto Piscina Olimpionica', 2, 2);
    -- Altri segmenti per il percorso 2...

-- Inserimento di segmenti per il percorso 3 (Ciclismo)
INSERT INTO SEGMENTI (Visibilita, IdSegmento, Traccia, Nome, IdSport, IdCaratteristica)
VALUES
    (1, 37, 'segm_37.gpx', 'Salita Collina', 3, 1),
    (1, 38, 'segm_38.gpx', 'Salita Ripida', 3, 1),
    (1, 39, 'segm_39.gpx', 'Discesa Veloce', 3, 2),
    (1, 40, 'segm_40.gpx', 'Sentiero Ghiaioso', 3, 3),
    (1, 41, 'segm_41.gpx', 'Salita Montagna', 3, 1),
    (1, 42, 'segm_42.gpx', 'Discesa Tecnica', 3, 2),
    (1, 43, 'segm_43.gpx', 'Pianura Ventosa', 3, 3),
    (1, 44, 'segm_44.gpx', 'Salita Fuoristrada', 3, 2),
    (1, 45, 'segm_45.gpx', 'Salita Lunga', 3, 1),
    (1, 46, 'segm_46.gpx', 'Discesa Ripida', 3, 2),
    (1, 47, 'segm_47.gpx', 'Sentiero Forestale', 3, 3),
    (1, 48, 'segm_48.gpx', 'Salita Panoramica', 3, 1),
    (1, 49, 'segm_49.gpx', 'Discesa Panoramica', 3, 2),
    (1, 50, 'segm_50.gpx', 'Salita Collina Bosco', 3, 1),
    (1, 51, 'segm_51.gpx', 'Salita Ripida Bosco', 3, 1),
    (1, 52, 'segm_52.gpx', 'Discesa Veloce Bosco', 3, 2),
    (1, 53, 'segm_53.gpx', 'Sentiero Ghiaioso Bosco', 3, 3),
    (1, 54, 'segm_54.gpx', 'Salita Montagna Bosco', 3, 1),
    (1, 55, 'segm_55.gpx', 'Discesa Tecnica Bosco', 3, 2),
    (1, 56, 'segm_56.gpx', 'Pianura Ventosa Bosco', 3, 3),
    (1, 57, 'segm_57.gpx', 'Salita Fuoristrada Bosco', 3, 2),
    (1, 58, 'segm_58.gpx', 'Salita Lunga Bosco', 3, 1),
    (1, 59, 'segm_59.gpx', 'Discesa Ripida Bosco', 3, 2),
    (1, 60, 'segm_60.gpx', 'Sentiero Forestale Bosco', 3, 3);

-- Altri segmenti...
INSERT INTO SEGMENTI (Visibilita, IdSegmento, Traccia, Nome, IdSport, IdCaratteristica)
VALUES
    (1, 61, 'segm_61.gpx', 'Salita Collina', 3, 1),
    (1, 62, 'segm_62.gpx', 'Salita Ripida Sopra Belluno', 3, 1),
    (1, 63, 'segm_63.gpx', 'Discesa Veloce', 3, 2),
    (1, 64, 'segm_64.gpx', 'Sentiero Ghiaioso', 3, 3),
    (1, 65, 'segm_65.gpx', 'Salita Montagna', 3, 1),
    (1, 66, 'segm_66.gpx', 'Discesa Tecnica ma divertente', 3, 2),
    (1, 67, 'segm_67.gpx', 'Pianura Ventosa', 3, 3),
    (1, 68, 'segm_68.gpx', 'Salita Fuoristrada', 3, 2),
    (1, 69, 'segm_69.gpx', 'Salita Lunga', 3, 1),
    (1, 70, 'segm_70.gpx', 'Discesa Ripida', 3, 2),
    (1, 71, 'segm_71.gpx', 'Sentiero Forestale', 3, 3),
    (1, 72, 'segm_72.gpx', 'Salita Panoramica', 3, 1),
    (1, 73, 'segm_73.gpx', 'Discesa Panoramica', 3, 2),
    (1, 74, 'segm_74.gpx', 'Salita Collina Bosco', 3, 1),
    (1, 75, 'segm_75.gpx', 'Salita Ripida Bosco', 3, 1),
    (1, 76, 'segm_76.gpx', 'Discesa Veloce Bosco', 3, 2),
    (1, 77, 'segm_77.gpx', 'Sentiero Ghiaioso Bosco', 3, 3),
    (1, 78, 'segm_78.gpx', 'Salita Montagna Bosco', 3, 1),
    (1, 79, 'segm_79.gpx', 'Discesa Tecnica Bosco', 3, 2),
    (1, 80, 'segm_80.gpx', 'Pianura Ventosa Bosco', 3, 3),
    (1, 81, 'segm_81.gpx', 'Salita Fuoristrada Bosco', 3, 2),
    (1, 82, 'segm_82.gpx', 'Salita Lunga Bosco', 3, 1),
    (1, 83, 'segm_83.gpx', 'Discesa Ripida Bosco', 3, 2),
    (1, 84, 'segm_84.gpx', 'Sentiero Forestale Bosco', 3, 3);

INSERT INTO SEGMENTI (Visibilita, IdSegmento, Traccia, Nome, IdSport, IdCaratteristica)
VALUES
    (1, 85, 'segm_85.gpx', 'FondoValle Scenico', 3, 4),
    (1, 86, 'segm_86.gpx', 'Salita Ripida Collina', 3, 4),
    (1, 87, 'segm_87.gpx', 'Velocità', 3, 5),
    (1, 88, 'segm_88.gpx', 'Fondovalle Ghiaioso', 3, 5),
    (1, 89, 'segm_89.gpx', 'Montagna Challenge', 3, 4),
    (1, 90, 'segm_90.gpx', 'Fondovalle Rubicone', 3, 5);
    
-- Inserimento dei dati nella tabella SALVATAGGI_SEGMENTI
INSERT INTO SALVATAGGI_SEGMENTI (IdSegmento, IdUtente)
VALUES
    (1, FLOOR(RAND() * 16) + 1),
    (18, FLOOR(RAND() * 16) + 1),
    (14, FLOOR(RAND() * 16) + 1),
    (9, FLOOR(RAND() * 16) + 1),
    (2, FLOOR(RAND() * 16) + 1),
    (19, FLOOR(RAND() * 16) + 1),
    (12, FLOOR(RAND() * 16) + 1),
    (8, FLOOR(RAND() * 16) + 1),
    (3, FLOOR(RAND() * 16) + 1),
    (10, FLOOR(RAND() * 16) + 1),
    (17, FLOOR(RAND() * 16) + 1),
    (6, FLOOR(RAND() * 16) + 1),
    (13, FLOOR(RAND() * 16) + 1),
    (20, FLOOR(RAND() * 16) + 1),
    (4, FLOOR(RAND() * 16) + 1),
    (7, FLOOR(RAND() * 16) + 1),
    (11, FLOOR(RAND() * 16) + 1),
    (16, FLOOR(RAND() * 16) + 1),
    (5, FLOOR(RAND() * 16) + 1),
    (15, FLOOR(RAND() * 16) + 1),
    (35, FLOOR(RAND() * 16) + 1),
    (34, FLOOR(RAND() * 16) + 1),
    (33, FLOOR(RAND() * 16) + 1),
    (32, FLOOR(RAND() * 16) + 1),
    (30, FLOOR(RAND() * 16) + 1),
    (29, FLOOR(RAND() * 16) + 1),
    (27, FLOOR(RAND() * 16) + 1),
    (21, FLOOR(RAND() * 16) + 1),
    (26, FLOOR(RAND() * 16) + 1),
    (25, FLOOR(RAND() * 16) + 1),
    (24, FLOOR(RAND() * 16) + 1),
    (23, FLOOR(RAND() * 16) + 1),
    (36, FLOOR(RAND() * 16) + 1),
    (28, FLOOR(RAND() * 16) + 1),
    (22, FLOOR(RAND() * 16) + 1),
    (31, FLOOR(RAND() * 16) + 1),
    (74, FLOOR(RAND() * 16) + 1),
    (50, FLOOR(RAND() * 16) + 1),
    (51, FLOOR(RAND() * 16) + 1),
    (72, FLOOR(RAND() * 16) + 1),
    (54, FLOOR(RAND() * 16) + 1),
    (62, FLOOR(RAND() * 16) + 1),
    (69, FLOOR(RAND() * 16) + 1),
    (58, FLOOR(RAND() * 16) + 1),
    (65, FLOOR(RAND() * 16) + 1),
    (61, FLOOR(RAND() * 16) + 1),
    (48, FLOOR(RAND() * 16) + 1),
    (75, FLOOR(RAND() * 16) + 1),
    (37, FLOOR(RAND() * 16) + 1),
    (38, FLOOR(RAND() * 16) + 1),
    (82, FLOOR(RAND() * 16) + 1),
    (41, FLOOR(RAND() * 16) + 1),
    (45, FLOOR(RAND() * 16) + 1),
    (78, FLOOR(RAND() * 16) + 1),
    (79, FLOOR(RAND() * 16) + 1),
    (76, FLOOR(RAND() * 16) + 1),
    (83, FLOOR(RAND() * 16) + 1),
    (68, FLOOR(RAND() * 16) + 1),
    (73, FLOOR(RAND() * 16) + 1),
    (81, FLOOR(RAND() * 16) + 1),
    (70, FLOOR(RAND() * 16) + 1),
    (63, FLOOR(RAND() * 16) + 1),
    (44, FLOOR(RAND() * 16) + 1),
    (46, FLOOR(RAND() * 16) + 1),
    (49, FLOOR(RAND() * 16) + 1),
    (52, FLOOR(RAND() * 16) + 1),
    (42, FLOOR(RAND() * 16) + 1),
    (55, FLOOR(RAND() * 16) + 1),
    (57, FLOOR(RAND() * 16) + 1),
    (39, FLOOR(RAND() * 16) + 1),
    (59, FLOOR(RAND() * 16) + 1),
    (40, FLOOR(RAND() * 16) + 1),
    (80, FLOOR(RAND() * 16) + 1),
    (43, FLOOR(RAND() * 16) + 1),
    (84, FLOOR(RAND() * 16) + 1),
    (64, FLOOR(RAND() * 16) + 1),
    (77, FLOOR(RAND() * 16) + 1),
    (60, FLOOR(RAND() * 16) + 1),
    (67, FLOOR(RAND() * 16) + 1),
    (56, FLOOR(RAND() * 16) + 1),
    (71, FLOOR(RAND() * 16) + 1),
    (53, FLOOR(RAND() * 16) + 1),
    (47, FLOOR(RAND() * 16) + 1),
    (85, FLOOR(RAND() * 16) + 1),
    (86, FLOOR(RAND() * 16) + 1),
    (89, FLOOR(RAND() * 16) + 1),
    (87, FLOOR(RAND() * 16) + 1),
    (88, FLOOR(RAND() * 16) + 1),
    (90, FLOOR(RAND() * 16) + 1);


-- Inserimento dei dati nella tabella RICONOSCIMENTI_UTENTI
INSERT INTO RICONOSCIMENTI_UTENTI (IdUtente, IdSegmento, IdRiconoscimento)
VALUES
    (1, 1, 1),
    (2, 18, 2),
    (3, 14, 3),
    (4, 9, 4),
    (5, 2, 5),
    (6, 19, 6),
    (7, 12, 7),
    (8, 8, 8),
    (9, 3, 1),
    (10, 10, 2),
    (11, 17, 3),
    (12, 6, 4),
    (13, 13, 5),
    (14, 20, 6),
    (15, 4, 7),
    (16, 7, 8);
    -- Continua con gli altri dati...

-- Popolamento casuale della tabella SEGMENTI_PERCORSI con almeno 100 dati

-- Esempio di inserimento di dati casuali per 100 righe
SET @idSport = 1;
SET @idAttivita = 1;

-- Generazione casuale dei dati di percorrenza per 100 righe
DELIMITER //
CREATE PROCEDURE PopulateSegmentiPercorsi()
BEGIN
  DECLARE i INT DEFAULT 1;
  
  WHILE i <= 100 DO
    -- Seleziona un utente casuale da 1 a 16
    SET @idUtente = FLOOR(1 + (RAND() * 16));
    
    -- Seleziona un segmento casuale da 1 a 90
    SET @idSegmento = FLOOR(1 + (RAND() * 90));
    
    -- Genera un tempo di percorrenza casuale in secondi da 300 a 1800
    SET @tempoPercorrenza = FLOOR(300 + (RAND() * (1800 - 300 + 1)));
    
    -- Inserisci i dati casuali nella tabella SEGMENTI_PERCORSI
    INSERT INTO SEGMENTI_PERCORSI (IdSport, IdAttivita, IdSegmento, IdSegmentoPercorso, TempoPercorrenza)
    VALUES (@idSport, @idAttivita, @idSegmento, i, @tempoPercorrenza);
    
    SET i = i + 1;
  END WHILE;
END;
//
DELIMITER ;

-- Esegui la procedura per popolare la tabella
CALL PopulateSegmentiPercorsi();

-- Associazione per IdSegmento da 1 a 20
INSERT INTO CONTENGONO (IdPercorso, IdSegmento) VALUES
(1, 1),(1, 20),(1, 12),
(33, 2),
(5, 3),(5, 11),(5, 18),
(3, 4),
(6, 5),(6, 8),
(8, 6),(8, 14),(8, 9),
(9, 7),
(11, 8),(11, 6),
(21, 9),
(15, 10),(15, 1),(15, 17),(15, 3),
(20, 11),
(17, 12),
(19, 13),(19, 2),
(23, 14),
(24, 15),(24, 2),(24, 3),
(27, 16),(27, 5),
(28, 17),
(35, 18),(35, 13),(35, 16),
(31, 19);

select *
from SEGMENTI S, CARATTERISTICHE_SEGMENTI CA
where CA.IdCaratteristica=S.IdCaratteristica
and CA.IdSport=S.IdSport and S.IdSport=3;

-- Associazione per IdSegmento da 21 a 36

-- 22 28 31 36 piscina
INSERT INTO CONTENGONO (IdPercorso, IdSegmento) VALUES
('12', 21),('12', 27),('12', 33),
('18', 22),('18', 28),
('25', 34),('25', 23),('25', 29),('25', 35),
('34', 24),('34', 30),('34', 36),
('39', 25),('39', 31),
('30', 26),('30', 32);

-- Associazione per IdSegmento da 37 a 90
INSERT INTO CONTENGONO (IdPercorso, IdSegmento) VALUES
('4', 37),('4', 52),('4', 67),('4', 82),('4', 45),
('7', 38),('7', 53),('7', 68),('7', 83),
('10', 39),('10', 54),('10', 69),('10', 84),
('13', 40),('13', 55),('13', 70),('13', 85),('13', 66),('13', 81),
('14', 41),('14', 56),('14', 71),('14', 86),
('16', 42),('16', 57),('16', 72),('16', 87),('16', 63),
('22', 43),('22', 58),('22', 73),('22', 88),
('26', 44),('26', 59),('26', 74),('26', 89),
('29', 45),('29', 60),('29', 75),('29', 90),
('32', 46),('32', 61),('32', 76),('32', 88),('32', 41),
('36', 47),('36', 62),('36', 77),('36', 90),('36', 37),('36', 45),
('40', 48),('40', 63),('40', 78),('40', 86),('40', 50),
('38', 49),('38', 64),('38', 79),('38', 40),
('37', 50),('37', 65),('37', 80),('37', 90),('37', 61),
('2', 51),('2', 66),('2', 81),('2', 54),('2', 78);


insert into SEGMENTI_PERCORSI values
('1', '1', '1', 1, FLOOR(RAND() * 450) + 1),
('1', '1', '12', 1, FLOOR(RAND() * 450) + 1),
('1', '1', '20', 1, FLOOR(RAND() * 450) + 1),
('3', '15', '51', 1, FLOOR(RAND() * 450) + 1),
('3', '15', '54', 1, FLOOR(RAND() * 450) + 1),
('3', '15', '66', 1, FLOOR(RAND() * 450) + 1),
('3', '15', '78', 1, FLOOR(RAND() * 450) + 1),
('3', '15', '81', 1, FLOOR(RAND() * 450) + 1),
('1', '4', '4', 1, FLOOR(RAND() * 450) + 1),
('3', '1', '37', 1, FLOOR(RAND() * 450) + 1),
('3', '1', '45', 1, FLOOR(RAND() * 450) + 1),
('3', '1', '52', 1, FLOOR(RAND() * 450) + 1),
('3', '1', '67', 1, FLOOR(RAND() * 450) + 1),
('3', '1', '82', 1, FLOOR(RAND() * 450) + 1),
('1', '3', '3', 1, FLOOR(RAND() * 450) + 1),
('1', '3', '11', 1, FLOOR(RAND() * 450) + 1),
('1', '3', '18', 1, FLOOR(RAND() * 450) + 1),
('1', '5', '5', 1, FLOOR(RAND() * 450) + 1),
('1', '5', '8', 1, FLOOR(RAND() * 450) + 1),
('3', '2', '38', 1, FLOOR(RAND() * 450) + 1),
('3', '2', '53', 1, FLOOR(RAND() * 450) + 1),
('3', '2', '68', 1, FLOOR(RAND() * 450) + 1),
('3', '2', '83', 1, FLOOR(RAND() * 450) + 1),
('1', '6', '6', 1, FLOOR(RAND() * 450) + 1),
('1', '6', '9', 1, FLOOR(RAND() * 450) + 1),
('1', '6', '14', 1, FLOOR(RAND() * 450) + 1),
('1', '7', '7', 1, FLOOR(RAND() * 450) + 1),
('3', '3', '39', 1, FLOOR(RAND() * 450) + 1),
('3', '3', '54', 1, FLOOR(RAND() * 450) + 1),
('3', '3', '69', 1, FLOOR(RAND() * 450) + 1),
('3', '3', '84', 1, FLOOR(RAND() * 450) + 1),
('1', '8', '6', 1, FLOOR(RAND() * 450) + 1),
('1', '8', '8', 1, FLOOR(RAND() * 450) + 1),
('2', '1', '21', 1, FLOOR(RAND() * 450) + 1),
('2', '1', '27', 1, FLOOR(RAND() * 450) + 1),
('2', '1', '33', 1, FLOOR(RAND() * 450) + 1),
('3', '4', '40', 1, FLOOR(RAND() * 450) + 1),
('3', '4', '55', 1, FLOOR(RAND() * 450) + 1),
('3', '4', '66', 1, FLOOR(RAND() * 450) + 1),
('3', '4', '70', 1, FLOOR(RAND() * 450) + 1),
('3', '4', '81', 1, FLOOR(RAND() * 450) + 1),
('3', '4', '85', 1, FLOOR(RAND() * 450) + 1),
('3', '5', '41', 1, FLOOR(RAND() * 450) + 1),
('3', '5', '56', 1, FLOOR(RAND() * 450) + 1),
('3', '5', '71', 1, FLOOR(RAND() * 450) + 1),
('3', '5', '86', 1, FLOOR(RAND() * 450) + 1),
('1', '10', '1', 1, FLOOR(RAND() * 450) + 1),
('1', '10', '3', 1, FLOOR(RAND() * 450) + 1),
('1', '10', '10', 1, FLOOR(RAND() * 450) + 1),
('1', '10', '17', 1, FLOOR(RAND() * 450) + 1),
('3', '6', '42', 1, FLOOR(RAND() * 450) + 1),
('3', '6', '57', 1, FLOOR(RAND() * 450) + 1),
('3', '6', '63', 1, FLOOR(RAND() * 450) + 1),
('3', '6', '72', 1, FLOOR(RAND() * 450) + 1),
('3', '6', '87', 1, FLOOR(RAND() * 450) + 1),
('1', '12', '12', 1, FLOOR(RAND() * 450) + 1),
('2', '2', '22', 1, FLOOR(RAND() * 450) + 1),
('2', '2', '28', 1, FLOOR(RAND() * 450) + 1),
('1', '13', '2', 1, FLOOR(RAND() * 450) + 1),
('1', '13', '13', 1, FLOOR(RAND() * 450) + 1),
('1', '11', '11', 1, FLOOR(RAND() * 450) + 1),
('1', '9', '9', 1, FLOOR(RAND() * 450) + 1),
('3', '7', '43', 1, FLOOR(RAND() * 450) + 1),
('3', '7', '58', 1, FLOOR(RAND() * 450) + 1),
('3', '7', '73', 1, FLOOR(RAND() * 450) + 1),
('3', '7', '88', 1, FLOOR(RAND() * 450) + 1),
('1', '14', '14', 1, FLOOR(RAND() * 450) + 1),
('1', '15', '2', 1, FLOOR(RAND() * 450) + 1),
('1', '15', '3', 1, FLOOR(RAND() * 450) + 1),
('1', '15', '15', 1, FLOOR(RAND() * 450) + 1),
('2', '3', '23', 1, FLOOR(RAND() * 450) + 1),
('2', '3', '29', 1, FLOOR(RAND() * 450) + 1),
('2', '3', '34', 1, FLOOR(RAND() * 450) + 1),
('2', '3', '35', 1, FLOOR(RAND() * 450) + 1),
('3', '8', '44', 1, FLOOR(RAND() * 450) + 1),
('3', '8', '59', 1, FLOOR(RAND() * 450) + 1),
('3', '8', '74', 1, FLOOR(RAND() * 450) + 1),
('3', '8', '89', 1, FLOOR(RAND() * 450) + 1),
('1', '16', '5', 1, FLOOR(RAND() * 450) + 1),
('1', '16', '16', 1, FLOOR(RAND() * 450) + 1),
('1', '17', '17', 1, FLOOR(RAND() * 450) + 1),
('3', '9', '45', 1, FLOOR(RAND() * 450) + 1),
('3', '9', '60', 1, FLOOR(RAND() * 450) + 1),
('3', '9', '75', 1, FLOOR(RAND() * 450) + 1),
('3', '9', '90', 1, FLOOR(RAND() * 450) + 1),
('2', '6', '26', 1, FLOOR(RAND() * 450) + 1),
('2', '6', '32', 1, FLOOR(RAND() * 450) + 1),
('1', '19', '19', 1, FLOOR(RAND() * 450) + 1),
('3', '10', '41', 1, FLOOR(RAND() * 450) + 1),
('3', '10', '46', 1, FLOOR(RAND() * 450) + 1),
('3', '10', '61', 1, FLOOR(RAND() * 450) + 1),
('3', '10', '76', 1, FLOOR(RAND() * 450) + 1),
('3', '10', '88', 1, FLOOR(RAND() * 450) + 1),
('1', '2', '2', 1, FLOOR(RAND() * 450) + 1),
('2', '4', '24', 1, FLOOR(RAND() * 450) + 1),
('2', '4', '30', 1, FLOOR(RAND() * 450) + 1),
('2', '4', '36', 1, FLOOR(RAND() * 450) + 1),
('1', '18', '13', 1, FLOOR(RAND() * 450) + 1),
('1', '18', '16', 1, FLOOR(RAND() * 450) + 1),
('1', '18', '18', 1, FLOOR(RAND() * 450) + 1),
('3', '11', '37', 1, FLOOR(RAND() * 450) + 1),
('3', '11', '45', 1, FLOOR(RAND() * 450) + 1),
('3', '11', '47', 1, FLOOR(RAND() * 450) + 1),
('3', '11', '62', 1, FLOOR(RAND() * 450) + 1),
('3', '11', '77', 1, FLOOR(RAND() * 450) + 1),
('3', '11', '90', 1, FLOOR(RAND() * 450) + 1),
('3', '14', '50', 1, FLOOR(RAND() * 450) + 1),
('3', '14', '61', 1, FLOOR(RAND() * 450) + 1),
('3', '14', '65', 1, FLOOR(RAND() * 450) + 1),
('3', '14', '80', 1, FLOOR(RAND() * 450) + 1),
('3', '14', '90', 1, FLOOR(RAND() * 450) + 1),
('3', '13', '40', 1, FLOOR(RAND() * 450) + 1),
('3', '13', '49', 1, FLOOR(RAND() * 450) + 1),
('3', '13', '64', 1, FLOOR(RAND() * 450) + 1),
('3', '13', '79', 1, FLOOR(RAND() * 450) + 1),
('2', '5', '25', 1, FLOOR(RAND() * 450) + 1),
('2', '5', '31', 1, FLOOR(RAND() * 450) + 1),
('3', '12', '48', 1, FLOOR(RAND() * 450) + 1),
('3', '12', '50', 1, FLOOR(RAND() * 450) + 1),
('3', '12', '63', 1, FLOOR(RAND() * 450) + 1),
('3', '12', '78', 1, FLOOR(RAND() * 450) + 1),
('3', '12', '86', 1, FLOOR(RAND() * 450) + 1);

