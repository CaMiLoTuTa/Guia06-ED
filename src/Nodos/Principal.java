
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Principal {

    public Principal() {
        try {
            ListaCircular listaCircular = new ListaCircular();

            System.out.println("<<-- Ejemplo de lista circular simple -->>\n");

            // Agregar al final de la lista circular
            listaCircular.agregarAlFinal(12);
            listaCircular.agregarAlFinal(15);
            listaCircular.agregarAlFinal(9);
            // Agregar in inicio de la lista circular
            listaCircular.agregarAlInicio(41);
            listaCircular.agregarAlInicio(6);

            System.out.println("<<-- Lista Circular -->>");
            listaCircular.listar();

            System.out.println("\n\n<<-- Tamaño -->");
            System.out.println(listaCircular.getTamaño());

            // System.out.println("\n<<-- Obtener el valor del nodo en la posicion 3 -->>");
            // System.out.println(listaCircular.getValor(3));

            System.out.println("\nInserta un nodo con valor 16 después del 15");
            listaCircular.insertarPorReferencia(15, 16);
            listaCircular.listar();
            System.out.print(" | Tamaño: ");
            System.out.println(listaCircular.getTamaño());

            System.out.println("\n\nInserta un nodo con valor 44 en la posición 5");
            listaCircular.insertarPorPosicion(5, 44);
            listaCircular.listar();
            System.out.print(" | Tamaño: ");
            System.out.println(listaCircular.getTamaño());

            System.out.println("\nActualiza el valor 12 del tercer nodo por 13");
            listaCircular.editarPorReferencia(12, 13);
            listaCircular.listar();
            System.out.print(" | Tamaño: ");
            System.out.println(listaCircular.getTamaño());

            System.out.println("\nActualiza el valor nodo en la posición 0 por 17");
            listaCircular.editarPorPosicion(0, 17);
            listaCircular.listar();
            System.out.print(" | Tamaño: ");
            System.out.println(listaCircular.getTamaño());

            System.out.println("\nElimina el nodo con el valor 41");
            listaCircular.removerPorReferencia(41);
            listaCircular.listar();
            System.out.print(" | Tamaño: ");
            System.out.println(listaCircular.getTamaño());

            System.out.println("\nElimina el nodo en la posición 4");
            listaCircular.removerPorPosicion(4);
            listaCircular.listar();
            System.out.print(" | Tamaño: ");
            System.out.println(listaCircular.getTamaño());

            System.out.println("\nConsulta si existe el valor 30");
            System.out.println(listaCircular.buscar(30));

            System.out.println("\nConsulta la posicion del valor 16");
            System.out.println(listaCircular.getPosicion(16));

            System.out.println("\nElimina la lista");
            listaCircular.eliminar();

            System.out.println("\nConsulta si la lista está vacia");
            System.out.println(listaCircular.esVacia());

            System.out.println("\n\n<<-- Fin de ejemplo lista simple -->>");
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en la lista circular ");

        }
    }

    public static void main(String[] args) throws Exception {
        new Principal();
    }
}
