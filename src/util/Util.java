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

    public static void mascaraTelFixo(TextField textField) {

        String val = "";

        textField.setOnKeyTyped((KeyEvent event) -> {

            if ("0123456789".contains(event.getCharacter()) == false) {
                event.consume();
            }

            if (event.getCharacter().trim().length() == 0) { // apagando

                if (textField.getText().length() == 1) {
                    textField.setText(textField.getText().substring(0, 0));
                    textField.positionCaret(textField.getText().length());
                } else if (textField.getText().length() == 4) {
                    textField.setText(textField.getText().substring(0, 3));
                    textField.positionCaret(textField.getText().length());
                } else if (textField.getText().length() == 10) {
                    textField.setText(textField.getText().substring(0, 9));
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

    }

    public static void mascaraTelCelular(TextField textField) {

        String val = "";

        textField.setOnKeyTyped((KeyEvent event) -> {

            if ("0123456789".contains(event.getCharacter()) == false) {
                event.consume();
            }

            if (event.getCharacter().trim().length() == 0) { // apagando

                if (textField.getText().length() == 1) {
                    textField.setText(textField.getText().substring(0, 0));
                    textField.positionCaret(textField.getText().length());
                } else if (textField.getText().length() == 5) {
                    textField.setText(textField.getText().substring(0, 3));
                    textField.positionCaret(textField.getText().length());
                } else if (textField.getText().length() == 11) {
                    textField.setText(textField.getText().substring(0, 10));
                    textField.positionCaret(textField.getText().length());
                }

            } else { // escrevendo

                if (textField.getText().length() == 15) {
                    event.consume();
                }

                if (textField.getText().length() == 0) {
                    textField.setText(textField.getText() + "(");
                    textField.positionCaret(textField.getText().length());
                } else if (textField.getText().length() == 3) {
                    textField.setText(textField.getText() + ") 9");
                    textField.positionCaret(textField.getText().length());
                } else if (textField.getText().length() == 10) {
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                }

            }
        });

    }

    public static boolean verificaCPF(String CPF) {

        CPF = CPF.replace("-", "");
        CPF = CPF.replace(".", "");

//         considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return false;
        }

        try {
            // Primeiro digito verificador
            int x = 10, nv1, nv2, total = 0;
            for (int i = 0; i < 9; i++) {
                total += ((int) (CPF.charAt(i) - 48) * x);
                x--;
            }
            nv1 = 11 - (total % 11);
            if (nv1 == 10 || nv1 == 11) {
                nv1 = 0;
            }
            // Segundo digito verificador
            x = 11;
            total = 0;
            for (int i = 0; i < 10; i++) {
                total += ((int) (CPF.charAt(i) - 48) * x);
                x--;
            }
            nv2 = 11 - (total % 11);
            if (nv2 == 10 || nv2 == 11) {
                nv2 = 0;
            }
            
            return (int) (CPF.charAt(9) - 48) == nv1 && (int) (CPF.charAt(10) - 48) == nv2;
        } catch (Exception erro) {
            System.out.println(erro.toString());
            return false;
        }
    }

}
