
package leituraarquivos;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvScanner {
    
    public CsvScanner() {
        
    }
    
    public void lerArquivo(RepositorioCrimes repositorio) throws IOException{
        BufferedReader reader = new  BufferedReader(new FileReader("cvli_pernambuco_dezembro-2015.csv"));
        String line = null;
        Scanner scanner = null;
        int index = 0;
        List<Crime> listacrimes = new ArrayList<>();
        
        while((line = reader.readLine())!= null) {
            Crime crime = new Crime();
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                String data = scanner.next();
                
                if(index == 0)
                    crime.setData(data);
                else if(index == 1)
                    crime.setNome(data);
                else if(index == 2)
                    crime.setSexo(data);
                else if(index == 3)
                    crime.setObjeto_utilizado(data);
                else if(index == 4)
                    crime.setMunicipio(data);
                else if(index == 5 )
                    crime.setIdade(Integer.parseInt(data));
                else if(index == 6)
                    crime.setNatureza(data);
                else if(index == 7)
                    crime.setTotal_vitimas(Integer.parseInt(data));
                
                index++;
            }
            index = 0;
            repositorio.adicionarCrime(crime);
            
        }
        
        reader.close();
        
    }
    
    
    
    
}
