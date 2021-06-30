package de.iainschmidt.inf.textgame.game;

import de.iainschmidt.inf.textgame.framework.ButtonOrientation;
import de.iainschmidt.inf.textgame.framework.DisplayableFrame;
import de.iainschmidt.inf.textgame.framework.RoomFactory;
import de.iainschmidt.inf.textgame.game.frames.EscapedScreen;
import de.iainschmidt.inf.textgame.game.specialrooms.A202;
import de.iainschmidt.inf.textgame.game.specialrooms.ABouroEntry;
import de.iainschmidt.inf.textgame.map.b.ground.Floor;


/**
 * @author Lukas S. PrimeAPI
 * created on 17.06.2021
 * crated for INF-11-Abschlussabgabe
 */
public enum Room {

    B_FORYER,
    B_08,
    B_08_SAMMLUNG,
    B_FLOOR,
    B_07,
    B_06,
    B_05,
    B_03,
    B_02,
    B_01,
    B_UPSTAIRS,
    B_101,
    B_102,
    B_103,
    B_108,
    B_107,
    B_106,

    A_STAIRCASE,
    A_CAFETERIA,
    A_08,
    A_07,
    A_FORYER,

    A_UPSTAIRS,
    A_121,
    A_112,
    A_113,
    A_120,

    A_200,
    A_201,
    A_202,
    A_203,
    A_ATTIC,

    C_FORYER,
    C_01,
    C_02,
    C_03,
    C_04,
    C_05,
    C_06,
    C_07,
    C_STAIRCASE,

    C_UPSTAIRS,
    C_102,
    C_103,
    C_105,
    C_106,
    C_107,
    C_SAMMLUNG,

    HAUPTHOF,
    B_WIESE,
    C_WIESE,


    A_BOURO,
    A_BOURO_ENTRY,


    ESCAPED(new EscapedScreen());


    static {

        //B-GEBÄUDE
        {
            B_06.setFrame(
                    RoomFactory
                            .create("B06 | Kunstraum", "Du bist in einem Kunstraum", "img/kunstraum.png")
                            .addButton("Flur", Room.B_FLOOR, ButtonOrientation.TOP)
                            .addButton("B07 (Kunstsammlung)", Room.B_07, ButtonOrientation.LEFT)
                            .setItems(Item.KEY_ART)
                            .build()
            );
            B_07.setFrame(
                    RoomFactory
                            .create(
                                    "B07 | Kunstsammlung",
                                    "Du hast die Kunstsammlung aufgeschlossen!\nHier steht eine Liege, eine Kaffemaschiene und Tee",
                                    "img/kafeeecke.png"
                            )
                            .addButton("B08 KunstSammlung", Room.B_08_SAMMLUNG, ButtonOrientation.LEFT)
                            .addButton("B06 | Kunstraum", Room.B_06, ButtonOrientation.RIGHT)
                            .setKeyLevel(KeyLevel.ART)
                            .build()
            );
            B_08_SAMMLUNG.setFrame(
                    RoomFactory
                            .create(
                                    "B08 | Kunstsammlung",
                                    "Du bist in der Werkstatt! Hier stehen einige Werkzeuge für den Kunstunterricht",
                                    "img/kunstwerkstatt.png"
                            )
                            .addButton("B08 Kunstraum", Room.B_08, ButtonOrientation.LEFT)
                            .addButton("Flur", Room.B_FLOOR, ButtonOrientation.TOP)
                            .setKeyLevel(KeyLevel.ART)
                            .build()
            );
            B_08.setFrame(
                    RoomFactory
                            .create(
                                    "B08 | Unterrichtsraum",
                                    "Du bist jetzt im Kustraum. Ausm Fenster kannst du auf die B-Wiese rausgucken.",
                                    "img/kunstraum.png"
                            )
                            .addButton("B08 KunstSammlung", Room.B_08_SAMMLUNG, ButtonOrientation.RIGHT)
                            .addButton("B-Foryer", Room.B_FORYER, ButtonOrientation.TOP)
                            .build()
            );
            B_FORYER.setFrame(
                    RoomFactory
                            .create(
                                    "B-Foryer",
                                    "Du bist in das B-Gebäude gegangen! Von hier aus kannst du \n ins A-Gebäude, die Treppe hoch oder zu den Kunsträumen!",
                                    "img/bgebaude.png"
                            ).addButton("Pausenhof", Room.HAUPTHOF, ButtonOrientation.LEFT)
                            .addButton("B08 (Kunstraum)", Room.B_08, ButtonOrientation.BUTTON)
                            .addButton("Treppe hoch", Room.B_UPSTAIRS, ButtonOrientation.TOP)
                            .addButton("A-Gebäude", Room.A_STAIRCASE, ButtonOrientation.TOP)
                            .addButton("B01 (Klassenraum)", Room.B_01, ButtonOrientation.RIGHT)
                            .addButton("Flur betreten", Room.B_FLOOR, ButtonOrientation.RIGHT)
            );
            B_FLOOR.setFrame(new Floor()); //In getrennte Class gepackt für Übersuchtlichkeit
            B_01.setFrame(
                    RoomFactory.create(
                            "B01 | Klassenraum der 8a",
                            "Du bist im Klassenraum der 8a. Ein(e) Schüler(in) hat sein/ihr Pausenbrot vergessen",
                            "img/classroom-1.png"
                    )
                            .addButton("B-Foryer", Room.B_FORYER, ButtonOrientation.BUTTON)
                            .setItems(Item.FOOD)
            );
            B_02.setFrame(
                    RoomFactory.create(
                            "B02 | Klassenraum der 9e",
                            "Du bist im Klassenraum der 9e.",
                            "img/classroom-2.png"
                    )
                            .addButton("Flur", Room.B_FLOOR, ButtonOrientation.BUTTON)
            );
            B_03.setFrame(
                    RoomFactory.create(
                            "B03 | Klassenraum der 11b",
                            "Du bist im Klassenraum der 11b.",
                            "img/classroom-3.png"
                    )
                            .addButton("Flur", Room.B_FLOOR, ButtonOrientation.BUTTON)
            );
            B_05.setFrame(
                    RoomFactory.create(
                            "B05 | Klassenraum der 8e",
                            "Du bist im Klassenraum der 8e.",
                            "img/classroom-1.png"
                    )
                            .addButton("Flur", Room.B_FLOOR, ButtonOrientation.BUTTON)
            );

            B_UPSTAIRS.setFrame(
                    RoomFactory.create(
                            "B - 1. OG",
                            "Du bist nun die Treppen hochgekommen. Von hier aus kommst du zu den BioRäumen",
                            "img/floor.png"
                    )
                            .addButton("B101 (Bioraum)", Room.B_101, ButtonOrientation.LEFT)
                            .addButton("B102 (Klassenraum)", Room.B_102, ButtonOrientation.TOP)
                            .addButton("B103 (Klassenraum)", Room.B_103, ButtonOrientation.RIGHT)
                            .addButton("B106 (Bioraum)", Room.B_106, ButtonOrientation.RIGHT)
                            .addButton("B107 (Biosammlung)", Room.B_107, ButtonOrientation.BUTTON)
                            .addButton("B108 (Bioraum)", Room.B_108, ButtonOrientation.LEFT)
                            .addButton("Treppen runter", B_FORYER, ButtonOrientation.BUTTON)
            );

            B_102.setFrame(
                    RoomFactory.create(
                            "B102 | Klassenraum der 7a",
                            "Du bist im Klassenraum der 7a. Herr Karasch hatte hier zuletzt Unterricht, und scheint seinen Schlüssel vergessen zu haben!" +
                                    "",
                            "img/classroom-1.png"
                    )
                            .addButton("Raum verlassen", B_UPSTAIRS, ButtonOrientation.BUTTON)
                            .setItems(Item.KEY_INF)
            );
            B_103.setFrame(
                    RoomFactory.create(
                            "B102 | Klassenraum der 7b",
                            "Du bist im Klassenraum der 7b!" +
                                    "",
                            "img/classroom-2.png"
                    )
                            .addButton("Raum verlassen", B_UPSTAIRS, ButtonOrientation.BUTTON)
            );

            B_101.setFrame(
                    RoomFactory.create(
                            "B101 | Bioraum",
                            "Diese Bioraum scheint auggeschlossen zu sein. Jemand hat seine Schlüssel verloren",
                            "img/bioraum.png"
                    )
                            .addButton("Raum verlassen", Room.B_UPSTAIRS, ButtonOrientation.BUTTON)
                            .setItems(Item.KEY_BIO)
            );

            {
                B_108.setFrame(
                        RoomFactory.create(
                                "B108",
                                "Du hast den Bioraum geöffnet! Hier liegt ein Zettel von Frau Wutschke an Frau Wriedt." +
                                        " Er scheint älter zu sein. Man kann nur die letzten beiden Zahlen erkennen. Diese Lauten: '61'",
                                "img/bioraum.png"
                        )
                                .addButton("Raum verlassen", Room.B_UPSTAIRS, ButtonOrientation.TOP)
                                .setKeyLevel(KeyLevel.BIOLOGY)
                );
            }
            B_107.setFrame(
                    RoomFactory.create(
                            "B107",
                            "Du hast die Biosammlung geöffnet! Hier stehen einige Vitrinen mit Skeletten von Tieren.",
                            "img/biosammlung.png"
                    )
                            .addButton("Raum verlassen", Room.B_UPSTAIRS, ButtonOrientation.TOP)
                            .setKeyLevel(KeyLevel.BIOLOGY)
            );
            B_106.setFrame(
                    RoomFactory.create(
                            "B106",
                            "Du hast den Bioraum geöffnet!",
                            "img/bioraum.png"
                    )
                            .addButton("Raum verlassen", Room.B_UPSTAIRS, ButtonOrientation.TOP)
                            .setKeyLevel(KeyLevel.BIOLOGY)
            );


            B_WIESE.setFrame(
                    RoomFactory.create(
                            "B-Wiese",
                            "Du bist nun hinter dem B-Gebäude",
                            "img/bwiese.png"
                    )
                            .addButton("Haupthof", HAUPTHOF, ButtonOrientation.TOP)
                            .addButton("C-Wiese", C_WIESE, ButtonOrientation.LEFT)
                            .addButton("Schulgelände verlassen", ESCAPED, ButtonOrientation.RIGHT)
            );
        }

        //A-Gebäude
        {
            HAUPTHOF.setFrame(
                    RoomFactory.create(
                            "Haupthof",
                            "Du bist auf dem Pausenhof. Von hier kannst du in alle Gebäude gehen",
                            "img/haupthof.png"
                    )
                            .addButton("A-Gebäude (Foryer)", A_FORYER, ButtonOrientation.LEFT)
                            .addButton("A-Gebäude (Treppenhaus)", A_STAIRCASE, ButtonOrientation.TOP)
                            .addButton("B-Gebäude", B_FORYER, ButtonOrientation.RIGHT)
                            .addButton("C-Gebäude", C_FORYER, ButtonOrientation.BUTTON)
                            .addButton("B-Wiese", B_WIESE, ButtonOrientation.RIGHT)
                            .addButton("C-Wiese", C_WIESE, ButtonOrientation.LEFT)
            );

            A_STAIRCASE.setFrame(
                    RoomFactory.create(
                            "A | Treppenhaus",
                            "Du bist nun im Treppenhaus/Flur des A-Gebäudes",
                            "img/floor.png"
                    )
                            .addButton("Pausenhof", Room.HAUPTHOF, ButtonOrientation.BUTTON)
                            .addButton("A07 | Klassenraum", A_07, ButtonOrientation.LEFT)
                            .addButton("A08 | Klassenraum", A_08, ButtonOrientation.LEFT)
                            .addButton("A-Foryer", A_FORYER, ButtonOrientation.LEFT)
                            .addButton("B-Gebäude", Room.B_FORYER, ButtonOrientation.RIGHT)
                            .addButton("Treppe hoch gehen", A_UPSTAIRS, ButtonOrientation.TOP)
                            .addButton("Cafeteria", A_CAFETERIA, ButtonOrientation.TOP)
            );

            A_FORYER.setFrame(
                    RoomFactory.create(
                            "A-Foryer",
                            "Du bist nun im A-Foryer. Die Türen zur Straße sind verschlossen. Nur die Schulleitung kann diese Tür öffnen.\n" +
                                    "Wann Frau Wutschke am Montag wohl wieder zur Schule kommt...",
                            "img/agebaude.png"
                    )
                            .addButton("Treppe hoch gehen", A_UPSTAIRS, ButtonOrientation.TOP)
                            .addButton("Schule verlassen", ESCAPED, ButtonOrientation.TOP)
                            .addButton("Flur betreten", A_STAIRCASE, ButtonOrientation.RIGHT)
                            .addButton("Pausenhof betreten", HAUPTHOF, ButtonOrientation.BUTTON)
            );
            A_07.setFrame(
                    RoomFactory.create(
                            "A07 | Klassenraum der 7a",
                            "Du bist im Klassenraum der 7a",
                            "img/classroom-1.png"
                    )
                            .addButton("Raum verlassen", A_STAIRCASE, ButtonOrientation.BUTTON)
            );
            A_08.setFrame(
                    RoomFactory.create(
                            "A08 | Klassenraum der 7d",
                            "Du bist im Klassenraum der 7d",
                            "img/classroom-2.png"
                    )
                            .addButton("Raum verlassen", A_STAIRCASE, ButtonOrientation.BUTTON)
            );
            A_CAFETERIA.setFrame(
                    RoomFactory.create(
                            "Cafeteria",
                            "Du bist in der Cafeteria. Hier hat jemand eine Brotdose vergessen. Du siehst auch einen Schlüssel, den du nicht zuordnen kannst.",
                            "img/cafeteria.png"
                    )
                            .setItems(Item.FOOD, Item.KEY_UNKNOWN)
                            .addButton("Cafeteria verlassen", A_STAIRCASE, ButtonOrientation.BUTTON)
            );

            A_UPSTAIRS.setFrame(
                    RoomFactory.create(
                            "A - 1. OG",
                            "Du bist nun im ersten Stock!",
                            "img/floor.png"
                    )
                            .addButton("Büro betreten", A_BOURO_ENTRY, ButtonOrientation.LEFT)
                            .addButton("Treppe hoch gehen", A_200, ButtonOrientation.TOP)
                            .addButton("A112 (Klassenraum)", A_112, ButtonOrientation.LEFT)
                            .addButton("A113 (Klassenraum)", A_113, ButtonOrientation.TOP)
                            .addButton("A120 (Sammlung)", A_120, ButtonOrientation.TOP)
                            .addButton("A121 (Klassenraum)", A_121, ButtonOrientation.RIGHT)
                            .addButton("Treppe runter (Treppenhaus)", A_STAIRCASE, ButtonOrientation.RIGHT)
                            .addButton("Treppe Runter (Foryer)", A_FORYER, ButtonOrientation.LEFT)
            );

            A_121.setFrame(
                    RoomFactory.create(
                            "A121 | Klassenraum 8a",
                            "Du bist im Klassenraum der 8a",
                            "img/classroom-1.png"
                    )
                            .addButton("Raum verlassen", A_UPSTAIRS, ButtonOrientation.BUTTON)
            );

            A_112.setFrame(
                    RoomFactory.create(
                            "A112 | Klassenraum 11b",
                            "Du bist im Klassenraum der 11b",
                            "img/classroom-2.png"
                    )
                            .addButton("Raum verlassen", A_UPSTAIRS, ButtonOrientation.BUTTON)
            );

            A_113.setFrame(
                    RoomFactory.create(
                            "A113 | Klassenraum 10e",
                            "Du bist im Klassenraum der 10e",
                            "img/classroom-3.png"
                    )
                            .addButton("Raum verlassen", A_UPSTAIRS, ButtonOrientation.BUTTON)
            );

            A_120.setFrame(
                    RoomFactory.create(
                            "A120 | Sammlung",
                            "Du bist in einer Sammlung",
                            ""
                    )
                            .setKeyLevel(KeyLevel.NORMAL)
                            .addButton("Raum verlassen", A_UPSTAIRS, ButtonOrientation.BUTTON)
            );


            A_200.setFrame(
                    RoomFactory.create(
                            "A - 2. OG",
                            "Du bist nun vor den Computerräumen.\n" +
                                    "Im Flur steht ein Schrank. In diesem kannst du einen Stundenplan von einem Schüler erkennen." +
                                    "Du kannst lesen, dass Herr Karasch zuletzt in B102 mit der 7d Unterricht hatte.",
                            "img/floor.png"
                    )
                            .addButton("Treppe runter gehen", A_UPSTAIRS, ButtonOrientation.BUTTON)
                            .addButton("A202 (Computerraum)", A_202, ButtonOrientation.LEFT)
                            .addButton("A201 (Computerraum)", A_201, ButtonOrientation.LEFT)
                            .addButton("Dachboden", A_ATTIC, ButtonOrientation.TOP)
            );

            A_201.setFrame(
                    RoomFactory.create(
                            "A201 | Computerraum",
                            "Hier sind alle Computer aus. Hier ist nichts Spannendes",
                            "img/computerraum.png"
                    )
                            .addButton("Zurück zum Flur", A_200, ButtonOrientation.RIGHT)
                            .addButton("A202 (Computerraum)", A_202, ButtonOrientation.TOP)
                            .setKeyLevel(KeyLevel.COMPUTER)
            );

            A_202.setFrame(
                    new A202()
            );

            A_203.setFrame(
                    RoomFactory.create(
                            "A203 | Serverraum",
                            "Du bist im Serverraum. Hier stehen die Server für I-Serv. Mach bloß nichts kaputt!",
                            "img/serverraum.png"
                    )
                            .addButton("Zurück zu A202", A_202, ButtonOrientation.BUTTON)
            );

            A_ATTIC.setFrame(
                    RoomFactory.create(
                            "Dachboden",
                            "Du bist im Dachboden! Hier ist es sehr Dunkel und Muffig." +
                                    "In der einen Ecke hängen Stöcker.\n" +
                                    "An einer Wand steht ein WLAN Router. Auf der Rückseite davon stehen das Passwort '" + A202.WLANKEY + "'.",
                            "img/attic.png"
                    )
                            .addButton("Dachboden verlassen", A_200, ButtonOrientation.BUTTON)
            );

            A_BOURO.setFrame(
                    RoomFactory.create(
                            "Büro",
                            "Du bist nun im Büro! Hier liegt der Schlüssel der Schulleitung, mit dem du die Schule verlassen kannst!\n",
                            "img/bouro.png"
                    )
                            .addButton("Büro verlassen", A_UPSTAIRS, ButtonOrientation.RIGHT)
                            .setItems(Item.KEYS_HEADTEACHER)
            );

            A_BOURO_ENTRY.setFrame(
                    new ABouroEntry()
            );

        }

        //C-GEBÄUDE
        {
            C_FORYER.setFrame(
                    RoomFactory.create(
                            "C | Foryer",
                            "Du bist im Foryer des C-Gebäudes. Von hier kannst du in die Bibliothek, in die Musikräume" +
                                    "und die Treppe hoch gehen",
                            "img/cgebaude.png"
                    )
                            .addButton("C01 | Bibliothek", C_01, ButtonOrientation.LEFT)
                            .addButton("C02 | Musikraum", C_02, ButtonOrientation.RIGHT)
                            .addButton("C03 | Musiksammlung", C_03, ButtonOrientation.RIGHT)
                            .addButton("C04 | Musikraum", C_04, ButtonOrientation.RIGHT)
                            .addButton("Pausenhof", HAUPTHOF, ButtonOrientation.TOP)
                            .addButton("Treppe hoch gehen [1. OG]", C_UPSTAIRS, ButtonOrientation.TOP)
                            .addButton("C05 | Musikraum", C_05, ButtonOrientation.LEFT)
                            .addButton("C-Wiese (Pausenhof)", C_WIESE, ButtonOrientation.BUTTON)
                            .setKeyLevel(KeyLevel.NORMAL)
            );

            {

                String holeNumber = ABouroEntry.passcode.toString();
                if(holeNumber.length() != 4){
                    throw new IllegalStateException("ABouroEntry#passcode MUSS eine vierstellige Zahl sein! Laden der Räume wird abgebrochen...");
                }
                C_01.setFrame(
                        RoomFactory.create(
                                "C01 | Bibliothek",
                                "Du bist in der Bibliothek. Liegt liegt ein Zettel von Frau Wutsche an Frau Labinsky. " +
                                        "In diesem steht irgendeine PIN, welche kaum noch lesbar ist, das ein Kaffe über den Zettel ausgelaufen ist. " +
                                        "Die ersten beiden Zahlen sind '15'",
                                "img/bibliothek.png"
                        )
                                .addButton("C-Foryer", C_FORYER, ButtonOrientation.RIGHT)
                                .addButton("C07", C_07, ButtonOrientation.LEFT)
                                .setKeyLevel(KeyLevel.NORMAL)
                );
            }

            C_07.setFrame(
                    RoomFactory.create(
                            "C07",
                            "Du bist in C07",
                            ""
                    )
                            .addButton("C01 | Bibliothek", C_01, ButtonOrientation.RIGHT)
                            .addButton("Treppenhaus", C_STAIRCASE, ButtonOrientation.BUTTON)
                            .setKeyLevel(KeyLevel.NORMAL)
            );

            C_02.setFrame(
                    RoomFactory.create(
                            "C02 | Musikraum",
                            "Du bist im Musikraum. Die letzte Musikklasse die hier war hat hier nicht aufgeräumt." +
                                    "Die Stühöle stehe hier noch rum.",
                            "img/musik.png"
                    )
                            .addButton("C-Foryer", C_FORYER, ButtonOrientation.LEFT)
                            .addButton("C03 | Musiksammlung", C_03, ButtonOrientation.BUTTON)
                            .setKeyLevel(KeyLevel.MUSIC)
            );

            C_03.setFrame(
                    RoomFactory.create(
                            "C03 | Musiksammlung",
                            "Du bist in der Musiksammlung. Hier stehen mehrere Intrumente rum.",
                            "img/musiksammlung.png"
                    )
                            .addButton("C02 | Musikraum", C_02, ButtonOrientation.TOP)
                            .addButton("C-Foryer", C_FORYER, ButtonOrientation.LEFT)
                            .addButton("C04 | Musikraum", C_04, ButtonOrientation.BUTTON)
                            .setKeyLevel(KeyLevel.MUSIC)
                            .setItems(Item.GUITARR, Item.KLANGSTAEBE)
            );
            C_04.setFrame(
                    RoomFactory.create(
                            "C04 | Musikraum",
                            "Du bist im Musikraum",
                            "img/musik.png"
                    )
                            .addButton("C03 | Musiksammlung", C_03, ButtonOrientation.TOP)
                            .addButton("C-Foryer", C_FORYER, ButtonOrientation.LEFT)
                            .setItems(Item.KEY_MUSIC)
            );
            C_05.setFrame(
                    RoomFactory.create(
                            "C05 | Musikraum",
                            "Du bist im Musikraum",
                            "img/musik.png"
                    )
                            .addButton("C06 | Sammlung", C_06, ButtonOrientation.LEFT)
                            .addButton("C-Foryer", C_FORYER, ButtonOrientation.RIGHT)
                            .setKeyLevel(KeyLevel.MUSIC)
            );
            C_06.setFrame(
                    RoomFactory.create(
                            "C06 | Sammlung",
                            "Du bist in der Sammlung",//TODO
                            ""
                    )
                            .addButton("Treppenhaus", C_STAIRCASE, ButtonOrientation.LEFT)
                            .addButton("C05 | MUsikraum", C_05, ButtonOrientation.RIGHT)
                            .setKeyLevel(KeyLevel.MUSIC)
            );

            C_STAIRCASE.setFrame(
                    RoomFactory.create(
                            "C-Treppenhaus",
                            "Du bist im Treppenhaus. Die Treppe nach oben ist gesperrt, da es mal wieder vom Dach" +
                                    "reinregnet.",
                            ""
                    )
                            .addButton("C07", C_07, ButtonOrientation.TOP)
                            .addButton("C06 | Sammlung", C_06, ButtonOrientation.RIGHT)
                            .addButton("Gebäude verlassen [C-Wiese]", C_WIESE, ButtonOrientation.LEFT)
            );


            C_WIESE.setFrame(
                    RoomFactory.create(
                            "C-Wiese",
                            "Du befindest dich hinter dem C-Gebäude",
                            "img/cwiese.png"
                    )
                            .addButton("C-Gebäude betreten [Foryer]", C_FORYER, ButtonOrientation.RIGHT)
                            .addButton("C-Gebäude betreten [Treppenhaus)", C_STAIRCASE, ButtonOrientation.LEFT)
                            .addButton("B-Wiese", B_WIESE, ButtonOrientation.RIGHT)
                            .addButton("Haupthof", HAUPTHOF, ButtonOrientation.TOP)
                            .addButton("Schulgelände verlassen", ESCAPED, ButtonOrientation.LEFT)
            );


            C_102.setFrame(
                    RoomFactory.create(
                            "C102 | Chemieraum",
                            "Du bist im Chemieraum",
                            "img/mint2.png"
                    )
                            .addButton("Raum verlassen [Flur]", C_UPSTAIRS, ButtonOrientation.LEFT)
                            .addButton("C103 | Chemieraum", C_103, ButtonOrientation.TOP)
            );

            C_103.setFrame(
                    RoomFactory.create(
                            "C103 | Chemieraum",
                            "Du bist in einem Chemieraum. Hier hat jemand seinen Schlüssel liegen gelassen",
                            "img/mint-1.png"
                    )
                            .addButton("C102 | Chemieraum", C_102, ButtonOrientation.BUTTON)
                            .addButton("C105 | Physik- und Chemieraum", C_105, ButtonOrientation.LEFT)
                            .addButton("Raum verlassen [Flur]", C_UPSTAIRS, ButtonOrientation.LEFT)
                            .setItems(Item.KEY_CHEMISTRY)
            );

            C_105.setFrame(
                    RoomFactory.create(
                            "C105 | Physik- und Chemieraum",
                            "Du bist im neuen Physik und Chemieraum!",
                            "img/mint-3.png"
                    )
                            .addButton("Raum verlassen [Flur]", C_UPSTAIRS, ButtonOrientation.RIGHT)
                            .addButton("C103 | Chemieraum", C_103, ButtonOrientation.RIGHT)
                            .addButton("C106 | Physikraum", C_106, ButtonOrientation.LEFT)
                            .setKeyLevel(KeyLevel.NORMAL)
            );
            C_106.setFrame(
                    RoomFactory.create(
                            "C106 | Physikraum",
                            "Du bist im Physikraum",
                            "img/mint-4.png"
                    )
                            .addButton("C105 | Physik- und Chemieraum", C_105, ButtonOrientation.RIGHT)
                            .addButton("C107 | Physikraum", C_107, ButtonOrientation.BUTTON)
                            .addButton("Raum verlassen [Flur]", C_UPSTAIRS, ButtonOrientation.RIGHT)
            );
            C_107.setFrame(
                    RoomFactory.create(
                            "C107 | Physikraum",
                            "Du bist im Physikraum",
                            "img/mint-5.png"
                    )
                            .addButton("C106 | Physikraum", C_106, ButtonOrientation.TOP)
                            .addButton("Raum verlassen [Flur]", C_UPSTAIRS, ButtonOrientation.RIGHT)
            );

            C_UPSTAIRS.setFrame(
                    RoomFactory.create(
                            "C-Gebäude | 1. OG",
                            "Du bist die Treppen hoch gegangen!",
                            "img/floor.png"
                    )
                            .addButton("C103 | Chemieraum", C_103, ButtonOrientation.RIGHT)
                            .addButton("C102 | Chemieraum", C_102, ButtonOrientation.RIGHT)
                            .addButton("C106 | Physikraum", C_106, ButtonOrientation.LEFT)
                            .addButton("C107 | Physikraum", C_107, ButtonOrientation.LEFT)
                            .addButton("C105 | Physik- und Chemieraum", C_105, ButtonOrientation.TOP)
                            .addButton("Sammlung", C_SAMMLUNG, ButtonOrientation.BUTTON)
                            .addButton("Treppe runter gehen", C_FORYER, ButtonOrientation.BUTTON)
            );

            C_SAMMLUNG.setFrame(
                    RoomFactory.create(
                            "C- Sammlung",
                            "",
                            "img/mint-sammlung.png"
                    )
                            .addButton("Raum verlassen [Flur]", C_UPSTAIRS, ButtonOrientation.TOP)
            );
        }
    }


    DisplayableFrame frame;

    Room(DisplayableFrame frame) {
        this.frame = frame;
    }

    Room() {
    }

    public DisplayableFrame getFrame() {
        return frame;
    }

    public void setFrame(DisplayableFrame frame) {
        this.frame = frame;
    }

    public void setFrame(RoomFactory frame) {
        this.frame = frame.build();
    }
}
