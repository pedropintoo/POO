package OOP.AcessModifier.package2;
import OOP.AcessModifier.package1.*;

public class C {
    // Estes AcessLevels herdam as caracteristicas dos de baixo !!!
        public String publicMessage = "This is public"; // Tudo pode aceder
    protected  String protectedMessage = "This is protected";  // Apenas para os elementos filhos
               String defaultMessage = "This is the default";  // Apenas visivel para o package que o contem
       private String privateMessage = "This is private";  // Apenas visivel na classe que o contem
}
