
package leituraarquivos;

import java.io.IOException;


public class LeituraArquivosMain {


    public static void main(String[] args) {
        try {
            CsvScanner scanner  = new CsvScanner();
            RepositorioCrimes repositorio = new RepositorioCrimes();
        
            scanner.lerArquivo(repositorio);
            repositorio.municipiosComMaisCrimes();
            System.out.println("media das idades :" + repositorio.getMediaIdades() + " anos");
            repositorio.proporcaoHomemMulher();
            repositorio.dataComMaisCrimes();
            System.out.println("Qtd Homicidios :" + repositorio.getQuantidadeHomicidios());
        }
        catch(IOException e) {
            System.out.println("erro");
        }
    
    }
}
