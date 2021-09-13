
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import prob.Problem;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int numProbs = Integer.parseInt(input.readLine()); // numero total de problemas a resolver
		
		for (int i = 0; i < numProbs; i++) {
			int numOffers = Integer.parseInt(input.readLine());
			Problem prob = new Problem(numOffers);
			
			for (int j = 0; j < numOffers; j++) {
				String[] tokens = input.readLine().split(" ");
				prob.newOffer(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
			}
			
			System.out.println(prob.solve());
		}
	}
}
