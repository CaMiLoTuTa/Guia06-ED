package ValidarExpresion.Code;

import java.util.Stack;

import javax.swing.JOptionPane;

public class Operar {

    public static Stack<String> ecuacion = new Stack<String>();

    public Operar(String txtEntrada) {
        ecuacion.clear();

        String numerosConOperadores[] = txtEntrada.split("(?<=[-+*/()])|(?=[-+*/()])");

        for (int i = numerosConOperadores.length - 1; i >= 0; i--) {
            ecuacion.push(numerosConOperadores[i]);
        }
        System.out.println("The ecuacion is: " + ecuacion);

        int contadorParenAbr = 0, contadorCorcheAbr = 0, contadorParenCer = 0, contadorCorcheCer = 0;
        if (hayDelimitadores()) {
            // ? Contar paréntesis y corchetes
            for (String i : numerosConOperadores) {
                if (i.equals("(")) {
                    contadorParenAbr++;
                } else if (i.equals("{")) {
                    contadorCorcheAbr++;
                } else if (i.equals(")")) {
                    contadorParenCer++;
                } else if (i.equals("}")) {
                    contadorCorcheCer++;
                }
            }
        }

        if ((contadorParenAbr == contadorParenCer && contadorCorcheAbr == contadorCorcheCer)) {
            operarEcuacion();

        } else {
            JOptionPane.showMessageDialog(null, "VERIFIQUE LOS PARÉNTESIS Y CORCHETES.");
        }

    }

    public boolean hayDelimitadores() {
        return ecuacion.contains("(") || ecuacion.contains(")") || ecuacion.contains("{") || ecuacion.contains("}");
    }

    // TODO: Que tengan prioridades los () y los * y /
    // TODO: Que no se borre cuando no este balanceada en (){} y cuando se evalua
    // teniendo parentesis no manda resultado sino un )
    public void operarEcuacion() {
        if (ecuacion.size() > 1) {
            for (String i : ecuacion) {
                if ((!i.equals("(") && !i.equals(")") && !i.equals("{") && !i.equals("}"))) {
                    var numA = Double.parseDouble(ecuacion.pop());
                    var operador = ecuacion.pop();
                    var numB = Double.parseDouble(ecuacion.pop());

                    switch (operador) {
                        case "+":
                            ecuacion.push(String.valueOf(sumar(numA, numB)));
                            break;
                        case "-":
                            ecuacion.push(String.valueOf(restar(numA, numB)));
                            break;
                        case "*":
                            ecuacion.push(String.valueOf(multiplicar(numA, numB)));
                            break;
                        case "/":
                            ecuacion.push(String.valueOf(dividir(numA, numB)));
                            break;
                        default:
                            break;
                    }
                    break;

                } else {
                    ecuacion.pop();
                    break;
                }
            }
            System.out.println("The ecuacion is: " + ecuacion);
            operarEcuacion();
        }
    }

    public double sumar(double a, double b) {
        return a + b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        return a / b;
    }
}
