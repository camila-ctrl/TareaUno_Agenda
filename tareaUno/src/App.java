import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido a la AGENDA DE CONTACTOS");

        boolean aux = true;
        boolean aux1 = true;
        int lastIndex;
        String op;
        String search;
        final int MAX_CONTACTOS = 256;


        ArrayList<Contacto> contactos = new ArrayList<Contacto>();

        // Contactos ya creados de prueba
        Contacto contacto1 = new Contacto("Camila", "0123456", "hola@");
        contactos.add(contacto1);
        Contacto contacto2 = new Contacto("Juan", "000000", "");
        contactos.add(contacto2);
        Contacto contacto3 = new Contacto("Maria", "2256", "nop@.com");
        contactos.add(contacto3);

        // Muestra todos los contactos
        // for (int i = 0; i < contactos.size(); i++) {
        //     System.out.println(contactos.get(i).getNombre() + " " + contactos.get(i).getTelefono() + " " + contactos.get(i).getMail());
        // }

        do {
            System.out.print("¿Quieres [I]ngresar un nuevo contacto o [C]onsultar un contacto existente? Para salir presione enter --> ");
            op = scan.nextLine();

            if (op == "") {
                System.out.println("Nos vemos pronto!");
                aux = false;
            } else if (op.equals("I") || op.equals("i")) {

                System.out.print("Ingresa el nombre --> ");
                String nombreNvo = scan.nextLine();

                System.out.print("Ingresa el telefono  --> ");
                String telefonoNvo = scan.nextLine();
                

                System.out.print("Ingresa el mail (o presiona enter si no lo sabes)  --> ");
                String mailNvo = scan.nextLine();

                if (mailNvo != "") {
                    while ((mailNvo.contains("@")) == false) {
                        System.out.println("Correo electrónico no válido");
                        System.out.print("Ingresa el mail (o presiona enter si no lo sabes) --> ");
                        mailNvo = scan.nextLine();
                        if (mailNvo == "") {
                            break;
                        }
                    }
                }
                if (contactos.size() < MAX_CONTACTOS) { // mientras haya lugar disponible en la agenda, agrega contactos
                    Contacto contactoNvo = new Contacto(nombreNvo, telefonoNvo, mailNvo);
                    contactos.add(contactoNvo);
                    System.out.println("CONTACTO INGRESADO");
                } else {
                    System.out.println("Lo sentimos, no hay lugar disponible para este nuevo contacto");
                    // estaría bueno que esto lo dijera antes de ingresar toda la info del contacto nuevo
                }

            } else if (op.equals("C") || op.equals("c")) {

                aux1 = true;
                while (aux1) {
                    System.out.print("Ingresa el nombre del contacto que desea buscar --> ");
                    search = scan.nextLine();
                    if (search == "") {
                        aux1 = false;
                    }
                    for (int i = 0; (i < contactos.size() && aux1); i++) {
                        final Contacto contactoIter = contactos.get(i); 
                        if (contactoIter.getNombre().equals(search)) {
                            System.out.println("Contacto encontrado");
                            contactoIter.printContact();
                            
                            aux1 = false;
                        } else {
                            lastIndex = contactos.size() - 1;
                            // System.out.println("lastIndex = " + lastIndex);
                            if (i == lastIndex) {
                                System.out.println("Lo sentimos, no hemos econtrado ese contacto.");
                                System.out.println("Vuelva a intentar o presione enter para salir.");

                            }

                        }

                    }
                }

            } else {
                System.out.println("Opcion incorrecta. Vuelva a intentar.");
            }

        } while (aux);

    }

}
