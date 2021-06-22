package de.iainschmidt.inf.textgame.game;

import de.iainschmidt.inf.textgame.framework.ButtonOrientation;
import de.iainschmidt.inf.textgame.framework.GameFrame;
import de.iainschmidt.inf.textgame.framework.RoomFactory;
import de.iainschmidt.inf.textgame.game.frames.EscapedScreen;
import de.iainschmidt.inf.textgame.map.b.ground.Floor;

import java.util.logging.Level;

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

    HAUPTHOF,





    ESCAPED(new EscapedScreen())
    ;


    static {

        //B-GEBÄUDE
        {
            B_06.setFrame(
                    RoomFactory
                            .create("B06 | Kunstraum", "Du bist in einem Kunstraum", "")
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
                                    ""
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
                                    ""
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
                                    ""
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
                                    ""
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
                            ""
                    )
                            .addButton("B-Foryer", Room.B_FORYER, ButtonOrientation.BUTTON)
                            .setItems(Item.FOOD)
            );
            B_02.setFrame(
                    RoomFactory.create(
                            "B02 | Klassenraum der 9e",
                            "Du bist im Klassenraum der 9e.",
                            ""
                    )
                            .addButton("Flur", Room.B_FLOOR, ButtonOrientation.BUTTON)
            );
            B_03.setFrame(
                    RoomFactory.create(
                            "B03 | Klassenraum der 11b",
                            "Du bist im Klassenraum der 11b.",
                            ""
                    )
                            .addButton("Flur", Room.B_FLOOR, ButtonOrientation.BUTTON)
            );
            B_05.setFrame(
                    RoomFactory.create(
                            "B05 | Klassenraum der 8e",
                            "Du bist im Klassenraum der 8e.",
                            ""
                    )
                            .addButton("Flur", Room.B_FLOOR, ButtonOrientation.BUTTON)
            );

            B_UPSTAIRS.setFrame(
                    RoomFactory.create(
                            "B - 1. OG",
                            "Du bist nun die Treppen hochgekommen. Von hier aus kommst du zu den BioRäumen",
                            ""
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
                            ""
                    )
                    .addButton("Raum verlassen", B_UPSTAIRS, ButtonOrientation.BUTTON)
                    .setItems(Item.KEY_INF)
            );
            B_103.setFrame(
                    RoomFactory.create(
                            "B102 | Klassenraum der 7b",
                            "Du bist im Klassenraum der 7b!" +
                                    "",
                            ""
                    )
                    .addButton("Raum verlassen", B_UPSTAIRS, ButtonOrientation.BUTTON)
            );

            B_101.setFrame(
                    RoomFactory.create(
                            "B101 | Bioraum",
                            "Diese Bioraum scheint auggeschlossen zu sein. Jemand hat seine Schlüssel verloren",
                            ""
                    )
                            .addButton("Raum verlassen", Room.B_UPSTAIRS, ButtonOrientation.BUTTON)
                            .setItems(Item.KEY_BIO)
            );
            B_108.setFrame(
                    RoomFactory.create(
                            "B108",
                            "Du hast den Bioraum geöffnet!",
                            ""
                    )
                            .addButton("Raum verlassen", Room.B_UPSTAIRS, ButtonOrientation.TOP)
                            .setKeyLevel(KeyLevel.BIOLOGY)
            );
            B_107.setFrame(
                    RoomFactory.create(
                            "B107",
                            "Du hast die Biosammlung geöffnet! Hier stehen einige Vitrinen mit Skeletten von Tieren.",
                            ""
                    )
                            .addButton("Raum verlassen", Room.B_UPSTAIRS, ButtonOrientation.TOP)
                            .setKeyLevel(KeyLevel.BIOLOGY)
            );
            B_106.setFrame(
                    RoomFactory.create(
                            "B106",
                            "Du hast den Bioraum geöffnet!",
                            ""
                    )
                            .addButton("Raum verlassen", Room.B_UPSTAIRS, ButtonOrientation.TOP)
                            .setKeyLevel(KeyLevel.BIOLOGY)
            );
        }

        //A-Gebäude
        {
            A_STAIRCASE.setFrame(
                    RoomFactory.create(
                            "A | Treppenhaus",
                            "Du bist nun im Treppenhaus des A-Gebäudes",
                            ""
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
                            ""
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
                            ""
                    )
                    .addButton("Raum verlassen", A_STAIRCASE, ButtonOrientation.BUTTON)
            );
            A_08.setFrame(
                    RoomFactory.create(
                            "A08 | Klassenraum der 7d",
                            "Du bist im Klassenraum der 7d",
                            ""
                    )
                    .addButton("Raum verlassen", A_STAIRCASE, ButtonOrientation.BUTTON)
            );
            A_CAFETERIA.setFrame(
                    RoomFactory.create(
                            "Cafeteria",
                            "Du bist in der Cafeteria. Hier hat jemand eine Brotdose vergessen. Du siehst auch einen Schlüssel, den du nicht zuordnen kannst.",
                            ""
                    )
                    .setItems(Item.FOOD, Item.KEY_UNKNOWN)
                    .addButton("Cafeteria verlassen", A_STAIRCASE, ButtonOrientation.BUTTON)
            );

            A_UPSTAIRS.setFrame(
                    RoomFactory.create(
                            "A - 1. OG",
                            "Du bist nun im ersten Stock!",
                            ""
                    )
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
                            ""
                    )
                    .addButton("Raum verlassen", A_UPSTAIRS, ButtonOrientation.BUTTON)
            );

            A_112.setFrame(
                    RoomFactory.create(
                            "A112 | Klassenraum 11b",
                            "Du bist im Klassenraum der 11b",
                            ""
                    )
                    .addButton("Raum verlassen", A_UPSTAIRS, ButtonOrientation.BUTTON)
            );

            A_113.setFrame(
                    RoomFactory.create(
                            "A113 | Klassenraum 10e",
                            "Du bist im Klassenraum der 10e",
                            ""
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
                            ""
                    )
                    .addButton("Treppe runter gehen", A_UPSTAIRS, ButtonOrientation.BUTTON)
                    .addButton("A202 (Computerraum)", A_202, ButtonOrientation.LEFT)
                    .addButton("A201 (Computerraum)", A_201, ButtonOrientation.LEFT)
            );

            A_201.setFrame(
                    RoomFactory.create(
                            "A201 | Computerraum",
                            "Hier sind alle Computer aus. Hier ist nichts Spannendes",
                            ""
                    )
                    .addButton("Zurück zum Flur", A_200, ButtonOrientation.RIGHT)
                    .addButton("A202 (Computerraum)", A_202, ButtonOrientation.TOP)
                    .setKeyLevel(KeyLevel.COMPUTER)
            );

            A_202.setFrame(
                    RoomFactory.create(
                            "A202 | Computerraum",
                            "Hier sind alle Computer aus. Hier ist nichts Spannendes",
                            ""
                    )
                    .addButton("Zurück zum Flur", A_200, ButtonOrientation.RIGHT)
                    .addButton("A203 (Serverraum)", A_203, ButtonOrientation.TOP)
                    .addButton("A201 (Computerraum)", A_201, ButtonOrientation.BUTTON)
                    .setKeyLevel(KeyLevel.COMPUTER)
            );
        }
    }


    GameFrame frame;

    Room(GameFrame frame) {
        this.frame = frame;
    }

    Room() {
    }

    public GameFrame getFrame() {
        return frame;
    }

    public void setFrame(GameFrame frame) {
        this.frame = frame;
    }

    public void setFrame(RoomFactory frame) {
        this.frame = frame.build();
    }
}
