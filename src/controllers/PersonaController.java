package controllers;

import models.Persona;

public class PersonaController {
    public void sortByDireccionCodigo(Persona [] personas) {
        int n = personas.length;
        for (int i = 0; i < n; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (personas[j].equalsByCodigoDireccion(personas[maxIndex]))
                    maxIndex = j;
            }
            if (maxIndex != i) {
                Persona aux = personas[maxIndex];
                personas[maxIndex] = personas[i];
                personas[i] = aux;
            }
        }
    }
    public Persona findByCodigoPersona(Persona [] personas,int codigo) {
        int n = personas.length;
        for (int i = 0; i < n; i++) {
            int bajo=0;
            int alto=n-1;
            while(bajo<codigo){
                int centro = (alto+bajo)/2;
                if (personas[centro].equalsByCodigoDireccion(codigo)) {
                    return personas[centro];
                }
                if (personas[centro].getCodigoDireccion()>codigo){
                    bajo = centro+1;
                }
                else{
                    alto=centro-1;
                }
            }

        }
        return null;
    }
}
