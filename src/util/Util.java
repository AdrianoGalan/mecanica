/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Laboratorio101
 */
public class Util {

    public static void mascaraCEP(TextField textField) {

        String val = "";

        textField.setOnKeyTyped((KeyEvent event) -> {
            if ("0123456789".contains(event.getCharacter()) == false) {
                event.consume();
            }

            if (event.getCharacter().trim().length() == 0) { // apagando

                if (textField.getText().length() == 6) {
                    textField.setText(textField.getText().substring(0, 5));
                    textField.positionCaret(textField.getText().length());
                }

            } else { // escrevendo

                if (textField.getText().length() == 9) {
                    event.consume();
                }

                if (textField.getText().length() == 5) {
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                }

            }
        });

        textField.setOnKeyReleased((KeyEvent evt) -> {

            if (!textField.getText().matches("\\d-*")) {
                textField.setText(textField.getText().replaceAll("[^\\d-]", ""));
                textField.positionCaret(textField.getText().length());
            }
        });

    }

    public static void mascaraCPF(TextField textField) {

        String val = "";

        textField.setOnKeyTyped((KeyEvent event) -> {

            if ("0123456789".contains(event.getCharacter()) == false) {
                event.consume();
            }

            if (event.getCharacter().trim().length() == 0) { // apagando

                if (textField.getText().length() == 4) {
                    textField.setText(textField.getText().substring(0, 3));
                    textField.positionCaret(textField.getText().length());
                } else if (textField.getText().length() == 8) {
                    textField.setText(textField.getText().substring(0, 7));
                    textField.positionCaret(textField.getText().length());
                } else if (textField.getText().length() == 12) {
                    textField.setText(textField.getText().substring(0, 11));
                    textField.positionCaret(textField.getText().length());
                }

            } else { // escrevendo

                if (textField.getText().length() == 14) {
                    event.consume();
                }

                if (textField.getText().length() == 3 || textField.getText().length() == 7) {
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                } else if (textField.getText().length() == 11) {
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                }

            }
        });

//        textField.setOnKeyReleased((KeyEvent evt) -> {
//
//            if (!textField.getText().matches("\\d-*")) {
//                textField.setText(textField.getText().replaceAll("[^\\d-]", ""));
//                textField.positionCaret(textField.getText().length());
//            }
//        });
    }

    public static void mascaraPlaca(TextField textField) {

        String val = "";

        textField.setOnKeyTyped((KeyEvent event) -> {

            if (event.getCharacter().trim().length() == 0) { // apagando

                if (textField.getText().length() == 4) {
                    textField.setText(textField.getText().substring(0, 3));
                    textField.positionCaret(textField.getText().length());
                }

            } else { // escrevendo

                if (textField.getText().length() == 8) {
                    event.consume();
                }

                if (textField.getText().length() == 3) {
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                }

            }
        });

//        textField.setOnKeyReleased((KeyEvent evt) -> {
//
//            if (!textField.getText().matches("\\d-*")) {
//                textField.setText(textField.getText().replaceAll("[^\\d-]", ""));
//                textField.positionCaret(textField.getText().length());
//            }
//        });
    }

    public static void mascaraTel(TextField textField) {

        String val = "";

        textField.setOnKeyTyped((KeyEvent event) -> {

            if ("0123456789".contains(event.getCharacter()) == false) {
                event.consume();
            }

            if (event.getCharacter().trim().length() == 0) { // apagando

                if (textField.getText().length() == 0) {
                    textField.setText(textField.getText().substring(0, 1));
                    textField.positionCaret(textField.getText().length());
                } else if (textField.getText().length() == 4) {
                    textField.setText(textField.getText().substring(0, 3));
                    textField.positionCaret(textField.getText().length());
                }

            } else { // escrevendo

                if (textField.getText().length() == 14) {
                    event.consume();
                }

                if (textField.getText().length() == 0) {
                    textField.setText(textField.getText() + "(");
                    textField.positionCaret(textField.getText().length());
                } else if (textField.getText().length() == 3) {
                    textField.setText(textField.getText() + ") ");
                    textField.positionCaret(textField.getText().length());
                } else if (textField.getText().length() == 9) {
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                }

            }
        });

//        textField.setOnKeyReleased((KeyEvent evt) -> {
//
//            if (!textField.getText().matches("\\d-*")) {
//                textField.setText(textField.getText().replaceAll("[^\\d-]", ""));
//                textField.positionCaret(textField.getText().length());
//            }
//        });
    }

}
