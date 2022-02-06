package Ferramentas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class LeitorCsv {
	
	CSVReader leitor;
	
	public LeitorCsv(String arquivo) throws FileNotFoundException {
		leitor = new CSVReader( new FileReader(arquivo));
	}
	
	public String lerProximaLinha() throws CsvValidationException, IOException {
		return leitor.readNext()[0];	
	}
	public String[] lerProximaLinhaSeparando(String em) throws CsvValidationException, IOException {
		return lerProximaLinha().split(em);
		
	}

}
