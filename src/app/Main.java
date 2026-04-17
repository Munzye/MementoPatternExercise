package app;

import java.util.Scanner;

import caretaker.History;
import model.EditorMemento;
import model.TextEditor;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        History history = new History();

        int option;
        boolean running = true;

        //Menú
        while (running) {
            showMenu();
            option = readInt(scanner);

            switch (option) {
                case 1:
                    System.out.println("\nEscriba el nuevo texto:");
                    String newText = scanner.nextLine();
                    editor.write(newText);
                    System.out.println("Texto actualizado correctamente.");
                    break;

                case 2:
                    history.save(editor.save());
                    System.out.println("Estado guardado correctamente.");
                    break;

                case 3:
                    EditorMemento previousState = history.undo();
                    if (previousState == null) {
                        System.out.println("No hay estados guardados para deshacer.");
                    } else {
                        editor.restore(previousState);
                        System.out.println("Se restauró el último estado guardado.");
                    }
                    break;

                case 4:
                    System.out.println("\nTexto actual:");
                    System.out.println("\"" + editor.getContent() + "\"");
                    break;

                case 5:
                    running = false;
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n== EDITOR DE TEXTO - PATRÓN MEMENTO ==");
        System.out.println("1. Escribir / modificar texto");
        System.out.println("2. Guardar estado actual");
        System.out.println("3. Deshacer último cambio guardado");
        System.out.println("4. Ver texto actual");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }
}
